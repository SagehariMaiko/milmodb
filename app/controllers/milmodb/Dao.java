package controllers.milmodb;

import java.io.*;
import java.util.*;

public class Dao {
	
	public static List<Map<String, String>> selectData(DB db){
		StringBuilder sbSel = new StringBuilder();
		sbSel.append("SELECT");
		sbSel.append(" formSerCd,table_name ");
		sbSel.append(" FROM ");
		sbSel.append(" service_name ");
		return db.select(sbSel.toString());
	}
	
	public static int datadeleteAll(DB db, String table){
		StringBuilder sbDel = new StringBuilder();
		sbDel.append("DELETE");
		sbDel.append(" FROM ");
		sbDel.append(table);
		return db.delete(sbDel.toString());
	}
	
	public static void insert(DB db, File data, String table) {
		List<String[]> csv = CSVFileReader.read(data);
		String[] heads = csv.get(0);
		for (int i = 1; i < csv.size(); i++) {
			System.out.println(String.format("対象テーブル : %s @ %d", table, i));
			String[] line = csv.get(i);
			Map<String, String> values = createValues(heads, line);
			db.insert(table, values);
		}		
	}
	
	private static Map<String, String> createValues(String[] heads, String[] line) {
		Map<String, String> values = new HashMap<String, String>();
		for (int i = 0; i < heads.length; i++) {
			/*if (line[i].isEmpty()) {
				continue;
			}*/
			values.put(heads[i], line[i]);
		}
		return values;
	}
}	

