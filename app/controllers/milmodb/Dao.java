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
	
	public static void datadelete(DB db, String table, String Col, String Val) throws SQLException {
		StringBuilder sbDel = new StringBuilder();
		sbDel.append("DELETE");
		sbDel.append(" FROM ");
		sbDel.append(table);
		sbDel.append(" WHERE ");
		sbDel.append(Col);
		sbDel.append(" = ");
		sbDel.append("'" + Val + "'");
		db.delete(sbDel.toString());
	}
	
}	

