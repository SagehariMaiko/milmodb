package controllers.milmodb;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import util.common.ColumnNames;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateJsonDB {
	private static final int NORMAL_END = 0;
	private static final int ERROR_END = -1;
	private static final String projectFolder = "app" + File.separator + 
			"controllers" + File.separator +
			"milmodb" + File.separator;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.exit(new CreateJsonDB().pickfile(args));
	}
	
	private int pickfile(String[] args){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String today = df.format(new Date());
		System.out.println(">> start!! : " + today);
		DB db = null;
		try {
			String JsonDir = projectFolder + "Json";
			String CSVDir = projectFolder + "csv";
			String logDir = projectFolder + "log";
			Env env = new Env(JsonDir, CSVDir, logDir, today, 1);
			db = new DB();
			String m_table = "m_service_name";
			List<Map<String, String>> tablelist = Dao.selectData(db, m_table);
			
			for (File data : env.data1s){
				String filename = data.getName().toString().replace(".json", "");
				String table = gettablename(tablelist,filename);
				String j_table = "j_" + table;
				Dao.datadeleteAll(db,j_table);
				for (File csv : env.data2s){
					String csvname = csv.getName().toString().replaceAll(".csv","");
					if (filename.equals(csvname)) {
						parse(db,data,csv,filename,j_table);
					}
				}	
			}
			db.commit();
			System.out.println(String.format(">> commit : " + today));
			System.out.println(">> END!!: " + NORMAL_END);
			return NORMAL_END;
		} catch (Exception e) {
			if (db != null) {
				db.rollback();
				System.out.println(String.format(">> rollback : " + today));
			}
			System.out.println(">> END!!: " + ERROR_END);
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
	
	public void parse(DB db, File data, File csv, String filename, String table) {
		String[] csvArray;
		int csvReadStart = 5, countRow = 0;
		String line;
		List<String> ColList = new ArrayList<String>();
		BufferedReader in = null;

		try{
			List<Map<String,String>> offices = new ObjectMapper().readValue(data,new TypeReference<List<Map<String,String>>>() {});	
			in = new BufferedReader(new FileReader(csv));
			ColList.add(ColumnNames.OFFICE_ID);
			ColList.add(ColumnNames.SERCVICE_TYPE);
			ColList.add(ColumnNames.LATITUDE);
			ColList.add(ColumnNames.LONGITUDE);
			while ((line = in.readLine()) != null){
				csvArray = line.split("\\,");
				countRow++;
				if(countRow > csvReadStart){
					if (!csvArray[6].toString().equals("-")) {ColList.add(csvArray[6]);}	
				}
			}
			db.insert(table, ColList, offices);
						
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			silentClose(in);
		}
	}
	
	private void silentClose(BufferedReader in) {
		if (in != null) {
			try {
				in.close();
				System.out.println(">>> in Close");
			} catch (IOException e) {
				
			}
		}
	}
	
	public String gettablename(List<Map<String, String>> tablelist,String filename){
		String table = null;
		for (Map<String, String> map : tablelist) {
			if ((map.get("formSerCd")).equals(filename)){
				table = map.get("table_name");
			}
		}
		return table;
	}
}

