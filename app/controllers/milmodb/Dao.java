package controllers.milmodb;

import java.io.*;
import java.util.*;

public class Dao {
		
	public static List<Map<String, String>> selectData(DB db, String table){
		StringBuilder sbSel = new StringBuilder();
		sbSel.append("SELECT");
		sbSel.append(" * ");
		sbSel.append(" FROM ");
		sbSel.append(table);
		return db.select(sbSel.toString());
	}
	
	
	public static List<Map<String, String>> selectColumn(DB db, String table){
		StringBuilder sbSel = new StringBuilder();
		sbSel.append("SELECT");
		sbSel.append(" c.name AS ColumnName ");
		sbSel.append(" ,t.name AS ColumnTypeName ");
		sbSel.append(" ,c.length AS ColumnLength ");
		sbSel.append(" FROM ");
		sbSel.append(" syscolumns as c ");
		sbSel.append(" INNER JOIN ( ");
		sbSel.append(" SELECT * FROM sysobjects WHERE sysobjects.name = '");
		sbSel.append(table);
		sbSel.append("' ");
		sbSel.append(" ) AS o ON c.id = o.id ");
		sbSel.append(" INNER JOIN ( ");
		sbSel.append(" SELECT xtype,xusertype,type,usertype,name FROM systypes ");
		sbSel.append(" ) AS t ON c.xtype = t.xtype AND c.xusertype = t.xusertype ");
		sbSel.append(" ORDER BY o.name,c.colid");
		return db.select(sbSel.toString());
	}
	
	public static void datadeleteAll(DB db, String table){
		StringBuilder sbDel = new StringBuilder();
		sbDel.append("DELETE");
		sbDel.append(" FROM ");
		sbDel.append(table);
		db.delete(sbDel.toString());
	}
	
}	

