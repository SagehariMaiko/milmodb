package controllers.milmodb;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateDat {
	private static final int NORMAL_END = 0;
	private static final int ERROR_END = -1;
	private static final String projectFolder = "app" + File.separator + 
			"controllers" + File.separator +
			"milmodb" + File.separator;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.exit(new CreateDat().pickfile(args));
	}
	
	private int pickfile(String[] args){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd-HHmmss");
		String today = df.format(new Date());
		System.out.println(">> start!! : " + today);
		
		try {
			String JsonDir = projectFolder + "Json";
			String CSVDir = projectFolder + "CSV";
			String logDir = projectFolder + "log";
			
			Env env = new Env(JsonDir, CSVDir, logDir, today, 1);
			
			for (File data : env.data1s){
				String filename = data.getName().toString().replaceAll(".json","");
				System.out.println(">> json!!: " + filename);
				for (File csv : env.data2s){
					String csvname = csv.getName().toString().replaceAll(".csv","");
					if (filename.equals(csvname)) {
						parse(data,csv,filename);
					}
				}
				
			}
			System.out.println(">> END!!: " + NORMAL_END);
			return NORMAL_END;
		} catch (Exception e) {
			System.out.println(">> END!!: " + ERROR_END);
			return ERROR_END;
		} finally {
			Logger.output(System.out);
			Logger.close();
			System.out.println(">> finish!!: " + today);
		}
	}
	
	public void parse(File data, File csv, String filename) {
		String[] csvArray;
		int csvReadStart = 5, countRow = 0,office_id = 0;
		String OUT_FOLDER_NAME = projectFolder + "data"+ File.separator;
		String OUT_FILE_NAME = OUT_FOLDER_NAME + filename + ".dat";
		String OUTD_FILE_NAME = OUT_FOLDER_NAME + "degree" + File.separator + filename + "_degree.dat";
		String line;
		List<String> ColList = new ArrayList<String>();
		BufferedReader in = null;
		BufferedWriter bw = null ;
		BufferedWriter bw_degree = null ;

		try{
			List<Map<String,String>> offices = new ObjectMapper().readValue(data,new TypeReference<List<Map<String,String>>>() {});	
			in = new BufferedReader(new FileReader(csv));		
			bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(OUT_FILE_NAME)),"utf-8"));
			bw_degree = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(OUTD_FILE_NAME)),"utf-8"));
			//HEADER
			bw.write("office_id");
			System.out.println(">> office_id!!: ");
			while ((line = in.readLine()) != null){
				csvArray = line.split("\\,");
				countRow++;
				if(countRow > csvReadStart && csvArray.length >= 10){
					bw.write(",");
					bw.write(csvArray[1]);
					ColList.add(csvArray[1]);
				}
			}
			bw.newLine();
			
			bw_degree.write("table_name,office_id,longitude,latitude");
			bw_degree.newLine();
			
			//VALUES
			for (Map<String,String> c : offices) {
				bw.write(String.valueOf(office_id));
				for ( int i = 0; i < ColList.size(); ++i ) {
					bw.write(",");
					String str = c.get(ColList.get(i));
					if ( str == null || str.length() == 0 ) {
						bw.write("");
					} else {
						bw.write(((str.replaceAll(",","")).replaceAll("\r\n","")).replaceAll("\n",""));
					}
						
				}
				
				bw.newLine();
				bw_degree.write(filename + "," + String.valueOf(office_id) + "," + c.get("longitude") + "," + c.get("latitude"));
				bw_degree.newLine();
				
				office_id++;
				
			}			
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		} finally {
			silentClose(in,bw,bw_degree);
			
		}
	}
	
	private void silentClose(BufferedReader in, BufferedWriter bw, BufferedWriter bw_degree) {
		if (in != null) {
			try {
				in.close();
				System.out.println("in Close");
			} catch (IOException e) {
				
			}
		}
		if (bw != null) {
			try {
				bw.close();
				System.out.println("bw Close");
			} catch (IOException e) {
				
			}
		}
		if (bw_degree != null) {
			try {
				bw_degree.close();
				System.out.println("bw_degree Close");
			} catch (IOException e) {
				
			}
		}
	}
}

