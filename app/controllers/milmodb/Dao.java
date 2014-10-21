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
	
}	

