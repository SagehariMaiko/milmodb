package sagehari;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class CreateTable {
	private final static String inputCsvFile = "test\\sagehari\\milmodbcsv\\milmodb_tabledefinition - 770.csv";
	private final static String outputSQLPass = "test\\sagehari\\milmodbtablesql\\";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line;
		String[] csvArray;
		File inputFile = new File(inputCsvFile);
		File outputFile = null;
		BufferedReader in = null;
		PrintWriter out = null;
		FileOutputStream fos = null;
		OutputStreamWriter osw = null;
		int count = 0;
		try {
			FileInputStream fis = new FileInputStream(inputFile);
			InputStreamReader isr;
			isr = new InputStreamReader(fis,"UTF-8");
			in = new BufferedReader(isr);
			String tablename = "";
			String filename = "";
			
			while ((line = in.readLine()) != null){
				csvArray = line.split("\\,");
				count++;
				if(count == 1){
					tablename =  csvArray[1].toString();
					filename = tablename + ".sql";
					String outputSQLfile = outputSQLPass + filename;
					outputFile = new File(outputSQLfile);
					fos = new FileOutputStream(outputFile);
					osw = new OutputStreamWriter(fos,"UTF-8");
					out = new PrintWriter(osw);
					out.println("USE [milmodb]");
					out.println("GO");
					out.println("");
					out.println("SET ANSI_NULLS ON");
					out.println("GO");
					out.println("");
					out.println("SET QUOTED_IDENTIFIER ON");
					out.println("GO");
					out.println("");
					out.println("CREATE TABLE dbo." + tablename + "(");
				} else if (count > 2) {
					if  (csvArray[2].toString().toUpperCase().equals("INT") || csvArray[2].toString().equals("NVARCHAR(MAX)") || csvArray[2].toString().equals("BIT")) {
						if  (csvArray[2].toString().toUpperCase().equals("INT")) {
							out.println("	" + csvArray[1] + " " + csvArray[2] + " NOT NULL,");
						} else {
							out.println("	" + csvArray[1] + " " + csvArray[2] + " NULL,");
						}
					} else {
						out.println("	" + csvArray[1] + " " + csvArray[2] + "(" +  csvArray[3] + ") NULL,");
					}				
				}
			}
			out.println("PRIMARY KEY CLUSTERED");
			out.println("(");
			out.println("	[office_id] ASC");
			out.println(")WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)");
			out.println(")");
			out.println("");
			out.println("GO");
			
			System.out.println("finish!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try{
				if (in != null){
					in.close();
				}
				if(out != null){
					out.close();
				}
				if (fos != null){
					fos.close();
				}
				if (osw != null){
					osw.close();
				}
			}catch(IOException e){
				System.out.println("close fail");
				e.printStackTrace();
			}		
		}
	}

}
