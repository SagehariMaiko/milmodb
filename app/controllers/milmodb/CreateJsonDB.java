package controllers.milmodb;

import java.io.*;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import util.common.*;
import util.function.*;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateJsonDB {
	private static final int NORMAL_END = 0;
	private static final int ERROR_END = -1;
	public static final String projectFolder = "app" + File.separator + "controllers" + File.separator + "milmodb" + File.separator;

	public static void main(String[] args) {
		System.exit(new CreateJsonDB().pickfile(args));
	}

	private int pickfile(String[] args){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String today = df.format(new Date());
		String ClassName = "CreateJsonDB";
		System.out.println(">>> start !!" + today);
		DB db = null;
		try {
			Env env = new Env(projectFolder, today, ClassName);
			Logger.write("start!!");
			db = new DB(env.globalSetting);
			List<Map<String, String>> tablelist = Dao.selectData(db, ViewNames.V_SERVICE_OPEN);
			db.updateAll(ViewNames.V_SERVICE_OPEN, false);
			for (File data : env.jsondatas){
				String filename = data.getName().toString().replace(".json", "");
				String tablename = gettablename(tablelist,filename);
				String j_tablename = "j_" + tablename;
				if(db.exist_table(StoredProcedureNames.S_EXISTTABLE, j_tablename)){
					Logger.write("Start -> " + j_tablename);
					List<Map<String, String>> columnlist = Dao.selectData(db,StoredProcedureNames.F_GETCOLUMNLIST + "('" + j_tablename + "')");
					Dao.datadeleteAll(db,j_tablename);
					parse(db,data,columnlist,filename,j_tablename);
					db.update(ViewNames.V_SERVICE_OPEN, true, filename);
					Logger.write("End  -> " + j_tablename);
				}
			}
			db.commit();
			return NORMAL_END;
		} catch (SQLException e) { 
			e.printStackTrace();
			db.rollback();
			return ERROR_END;
		} catch (IOException e) { 
			e.printStackTrace();
			if (db != null) { db.rollback();}
			return ERROR_END;
		} catch (Exception e) {
			e.printStackTrace();
			if (db != null) { db.rollback();}
			return ERROR_END;
		} finally {
			if (db != null) {
				db.close();
			}
			Logger.write("END!!");
			//Logger.output(System.out);
			Logger.close();
			System.out.println(">> finish!!: " + today);
		}
	}

	public void parse(DB db, File data, List<Map<String, String>> columnlist, String filename, String table) throws SQLException, JsonParseException, JsonMappingException, IOException {
		List<Map<String,String>> offices = new ObjectMapper().readValue(data,new TypeReference<List<Map<String,String>>>() {});	
		List<String> ColList = new ArrayList<String>();
		CommonFunc.CreateCol(columnlist, ColList);
		db.j_insert(table, ColList, offices);
	}

	public String gettablename(List<Map<String, String>> tablelist,String filename){
		String table = null;
		for (Map<String, String> map : tablelist) {
			if ((map.get(ColumnNames.FORMSERCD)).equals(filename)){
				table = map.get(ColumnNames.TABLE_NAME);
			}
		}
		return table;
	}
}

