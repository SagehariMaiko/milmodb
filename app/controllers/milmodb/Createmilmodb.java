package controllers.milmodb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.List;
import java.util.Map;

public class Createmilmodb {
	private static final int NORMAL_END = 0;
	private static final int ERROR_END = -1;
	private static final String projectFolder = "app" + File.separator + 
												"controllers" + File.separator +
												"milmodb" + File.separator;;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.exit(new Createmilmodb().exec(args));
	}
	
	private int exec(String[] args){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String today = df.format(new Date());
		System.out.println(">> start!! : " + today);
		DB db = null;
		String table = "";
		try {
			String dataDir = projectFolder + "data";
			String degreeDir = dataDir + File.separator + "degree";
			String logDir = projectFolder + "log";
			Env env = new Env(dataDir, degreeDir, logDir,today, 0);
			db = new DB();
			
			List<Map<String, String>> tablelist = Dao.selectData(db);
			
			//data
			for (File data : env.data1s){
				String filename = data.getName().toString().replace(".dat", "");
				table = gettablename(tablelist,filename);
				//DELETE
				int delRow = Dao.datadeleteAll(db,table);
				System.out.println(String.format(">> %s テーブルを　%s 行削除しました",table,delRow));
				//INSERT
				Dao.insert(db,data,table);	
			}
			
			//degree_data
			table = "degree";
			//DELETE
			int delRow = Dao.datadeleteAll(db,table);
			System.out.println(String.format(">> %s テーブルを　%s 行削除しました",table,delRow));
			
			for (File data : env.data2s){
				//INSERT
				Dao.insert(db,data,table);	
			}			
			
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
	
	private String gettablename(List<Map<String, String>> tablelist,String filename){
		String table = null;
		for (Map<String, String> map : tablelist) {
			if ((map.get("formSerCd")).equals(filename)){
				table = map.get("table_name");
			}
		}
		return table;
	}
}
