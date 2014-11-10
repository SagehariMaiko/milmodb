package controllers.milmodb;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

public class Dao {
		
	public static List<Map<String, String>> selectData(DB db, String table) throws SQLException {
		StringBuilder sbSel = new StringBuilder();
		sbSel.append("SELECT");
		sbSel.append(" * ");
		sbSel.append(" FROM ");
		sbSel.append(table);
		return db.select(sbSel.toString());
	}
		
	public static void datadeleteAll(DB db, String table) throws SQLException {
		StringBuilder sbDel = new StringBuilder();
		sbDel.append("DELETE");
		sbDel.append(" FROM ");
		sbDel.append(table);
		db.delete(sbDel.toString());
	}
	
}	

