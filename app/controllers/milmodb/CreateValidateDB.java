package controllers.milmodb;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.common.*;
import util.function.CreateColList;

public class CreateValidateDB {
	private static final int NORMAL_END = 0;
	private static final int ERROR_END = -1;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.exit(new CreateValidateDB().exec(args));
	}
	
	private int exec(String[] args){
		String ClassName = "CreateValidateDB";
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String today = df.format(new Date());
		System.out.println(">> start!! : " + today);
		DB db = null;
		
		try {
			Env env = new Env(CreateJsonDB.projectFolder, today, ClassName);
			Logger.write("start!!");
			db = new DB(env.globalSetting);
			
			List<Map<String, String>> tablelist = Dao.selectData(db, ViewNames.V_SERVICE_NAME);
			
			for (Map<String, String> table : tablelist){
				String tablename = table.get(ColumnNames.TABLE_NAME);
				String servicetype = table.get(ColumnNames.SERVICE_NAME);
				String j_tablename = "j_" + tablename;
				String v_tablename = "v_" + tablename;
				boolean jexist = db.exist_table(StoredProcedureNames.S_EXISTTABLE, j_tablename);
				boolean vexist = db.exist_table(StoredProcedureNames.S_EXISTTABLE, v_tablename);
				if (jexist && vexist) {
					Logger.write("Start -> " + v_tablename);
					List<Map<String, String>> datalist = Dao.selectData(db, j_tablename);
					List<Map<String, String>> columnlist = Dao.selectData(db,StoredProcedureNames.F_GETCOLUMNDATA + "('" + v_tablename + "')");
					
					Converter conv = new Converter(datalist,columnlist);
					List<Map<String, String>> newdata = conv.isCovert();
					
					Validater valid = new Validater(newdata,columnlist, servicetype);
					newdata = valid.isValid();

					Dao.datadeleteAll(db, v_tablename);
					List<String> ColList = new ArrayList<String>();
					CreateColList.CreateCol(columnlist, ColList);
					db.v_insert(v_tablename, ColList, newdata, columnlist);
					Logger.write("End   -> " + v_tablename);
				} else {
					Logger.write(j_tablename + " 及び " + v_tablename + " が存在しません");
				}
			}
										
			db.commit();
			return NORMAL_END;
		} catch (SQLException e) { 
			e.printStackTrace();
			db.rollback();
			return ERROR_END;
		} catch (Exception e){
			e.printStackTrace();
			if (db != null) {db.rollback();}
			return ERROR_END;
		} finally {
			if (db != null) {db.close();}
			Logger.write("END!!");
			//Logger.output(System.out);
			Logger.close();
			System.out.println(">> finish!!: " + today);
		}		
	}
	
}
