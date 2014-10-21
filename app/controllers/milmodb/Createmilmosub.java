package controllers.milmodb;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.*;
import java.util.List;
import java.util.Map;

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
			
			//List<Map<String, String>> tablelist = Dao.selectData(db);
						
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
}
