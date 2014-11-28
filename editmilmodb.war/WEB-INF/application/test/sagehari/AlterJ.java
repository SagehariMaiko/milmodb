package sagehari;

import java.io.*;

public class AlterJ {
	
	private final static String inputCsvFile = "scraper\\scraper\\tableDefinitions\\332.csv";
	private final static String outputSQLPass = "test\\sagehari\\ALTER_J\\";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line;
		String[] csvArray;
		File inputFile = new File(inputCsvFile);
		File outputFile_j = null;
		File outputFile_v = null;
		BufferedReader in = null;
		PrintWriter out_j = null;
		PrintWriter out_v = null;
		FileOutputStream fos_j = null;
		FileOutputStream fos_v = null;
		OutputStreamWriter osw_j = null;
		OutputStreamWriter osw_v = null;
		int count = 0;
		
		try {
			FileInputStream fis = new FileInputStream(inputFile);
			InputStreamReader isr;
			isr = new InputStreamReader(fis,"UTF-8");
			in = new BufferedReader(isr);
			String j_tablename = "";
			String v_tablename = "";
			String j_atama = "";
			String v_atama = "";
			
			while ((line = in.readLine()) != null){
				csvArray = line.split("\\,");
				count++;
				if(count == 3){
					j_tablename =  "j_" + csvArray[1].toString();
					v_tablename =  "v_" + csvArray[1].toString();
					String j_filename = j_tablename + ".sql";
					String v_filename = v_tablename + ".sql";
					String j_outputSQLfile = outputSQLPass + j_filename;
					String v_outputSQLfile = outputSQLPass + v_filename;
					outputFile_j = new File(j_outputSQLfile);
					outputFile_v = new File(v_outputSQLfile);
					fos_j = new FileOutputStream(outputFile_j);
					fos_v = new FileOutputStream(outputFile_v);
					osw_j = new OutputStreamWriter(fos_j,"UTF-8");
					osw_v = new OutputStreamWriter(fos_v,"UTF-8");
					out_j = new PrintWriter(osw_j);
					out_v = new PrintWriter(osw_v);
					j_atama = "ALTER TABLE [dbo].[" + j_tablename + "] ALTER COLUMN ";
					v_atama = "ALTER TABLE [dbo].[" + v_tablename + "] ALTER COLUMN ";
					out_j.println(j_atama + "service_type nvarchar(max) NULL");
					out_j.println(j_atama + "latitude nvarchar(max) NULL");
					out_j.println(j_atama + "longitude nvarchar(max) NULL");
					out_v.println(v_atama + "service_type nvarchar(max) NULL");
					out_v.println(v_atama + "latitude nvarchar(max) NULL");
					out_v.println(v_atama + "longitude nvarchar(max) NULL");
				} else if (count > 5) {
					if (!"-".equals(csvArray[6].toString())){
						out_j.println(j_atama + csvArray[6].toString() + " nvarchar(max) NULL");
						out_v.println(v_atama + csvArray[6].toString() + " nvarchar(max) NULL");
					}
				}
			}
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try{
				if (in != null){
					in.close();
				}
				if(out_j != null){
					out_j.close();
				}
				if (fos_j != null){
					fos_j.close();
				}
				if (osw_j != null){
					osw_j.close();
				}
				if(out_v != null){
					out_v.close();
				}
				if (fos_v != null){
					fos_v.close();
				}
				if (osw_v != null){
					osw_v.close();
				}
			}catch(IOException e){
				System.out.println("close fail");
				e.printStackTrace();
			}			
		}

	}

}
