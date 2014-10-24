package controllers.milmodb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.List;
import java.util.Map;




//import util.common.ViewNames;
import util.common.*;

public class Createmilmosub {
	private static final int NORMAL_END = 0;
	private static final int ERROR_END = -1;
	private static final String projectFolder = "app" + File.separator + 
												"controllers" + File.separator +
												"milmodb" + File.separator;;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.exit(new Createmilmosub().exec(args));
	}
	
	private int exec(String[] args){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String today = df.format(new Date());
		System.out.println(">> start!! : " + today);
		DB db = null;
		//String table = "";
		try {
			String logDir = projectFolder + "log";
			Logger.setup(Env.find(logDir), today);
			db = new DB();
			
			List<Map<String, String>> tablelist = Dao.selectData(db, ViewNames.V_SERVICE_NAME);
			//List<Map<String, String>> officeconvlist = Dao.selectData(db, ViewNames.V_OFFICE_CONVERT);
			//List<Map<String, String>> personconvlist = Dao.selectData(db, ViewNames.V_PERSONS);
			
			for (Map<String, String> table : tablelist){
				String tablename = table.get(ColumnNames.TABLE_NAME);
				String j_tablename = "j_" + tablename;
				//Exist
				boolean b = db.exist_table(StoredProcedureNames.S_EXISTTABLE, tablename);
				boolean b2 = db.exist_table(StoredProcedureNames.S_EXISTTABLE, j_tablename);
				if (b && b2) {
					List<Map<String, String>> datalist = Dao.selectData(db, j_tablename);
					//Convert
					Converter conv = new Converter(datalist);
					List<Map<String, String>> newdata = conv.isCovert(db);
					//Validate
					HomeCare homecare = new HomeCare(newdata);
					newdata = homecare.isValid(db);
					db.updatevalidate(j_tablename, newdata);
					//for (Map<String, String> d : newdata) {
					//	Logger.write(">>> :" + d.get(ColumnNames.IVALIDATE_FLG));
					//}
				}
				
			}
						
			//Validate
			//boolean b = true;
			//HomeCare homecare = new HomeCare(datalist);
			//b = homecare.isValid(db);
			
			
			
			// 文字化けチェック
			//List<String> errid = Checker.corruption_check(datalist, today);					
			db.commit();
			System.out.println(String.format(">> commit : " + today));
			
			return NORMAL_END;
		} catch (Exception e){
			e.printStackTrace();
			if (db != null) {
				db.rollback();
				System.out.println(String.format(">> rollback : " + today));
			}
			return ERROR_END;
		} finally {
			if (db != null) {
				db.close();
			}
			Logger.output(System.out);
			Logger.close();
			System.out.println(">> finish!!: " + today);
		}		
	}
	
	public String getdata(List<Map<String, String>> tablelist,String filename){
		String table = null;
		for (Map<String, String> map : tablelist) {
			if ((map.get("formSerCd")).equals(filename)){
				table = map.get("table_name");
			}
		}
		return table;
	}
}
