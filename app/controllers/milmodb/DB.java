package controllers.milmodb;

import java.sql.*;
import java.text.*;
import java.util.*;
import java.util.Date;

import util.common.*;

import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;

public class DB {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL_FORMAT = "jdbc:sqlserver://%s:%s;database=%s";

	public static Connection con;

	public DB(Properties globalSetting) throws Exception {
		this.con = setupConnection(globalSetting);
		this.con.setAutoCommit(false);
		Logger.write(String.format(URL_FORMAT, 
				globalSetting.getProperty(GlobalSetting.SENDSERVER_KEY), 
				globalSetting.getProperty(GlobalSetting.DBPORT_KEY), 
				globalSetting.getProperty(GlobalSetting.DBNAME_KEY)) + " --- Connect OK");
	}

	private Connection setupConnection(Properties globalSetting) throws Exception {
		Class.forName(DRIVER);
		String JDBC_URL = String.format(URL_FORMAT, 
				globalSetting.getProperty(GlobalSetting.SENDSERVER_KEY),
				globalSetting.getProperty(GlobalSetting.DBPORT_KEY),
				globalSetting.getProperty(GlobalSetting.DBNAME_KEY));
		return DriverManager.getConnection(JDBC_URL, 
				globalSetting.getProperty(GlobalSetting.DBUSER_KEY), 
				globalSetting.getProperty(GlobalSetting.DBPASS_KEY));
	}

	public void commit() {
		try {
			this.con.commit();
			Logger.write("COMMIT");
			System.out.println(">> COMMIT!!: ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rollback() {
		try {
			this.con.rollback();
			Logger.write("ROLLBACK");
			System.out.println(">> ROLLBACK!!: ");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.con.close();
			Logger.write("DB Close!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void j_insert(String table, List<String> ColList, List<Map<String,String>> offices) throws SQLException {
		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			prepareSql(sql, ColList, table);
			ps = con.prepareStatement(sql.toString());
			j_insertExecute(ps, ColList, offices);
		} finally {
			psClose(ps);
		}
	}

	public static void v_insert(String v_table, List<String> collist, List<Map<String,String>> data, List<Map<String, String>> colmap) throws SQLException {
		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			prepareSql(sql, collist, v_table);
			ps = con.prepareStatement(sql.toString());
			v_insertExecute(ps, v_table, data, colmap);
		} finally {
			psClose(ps);
		}
	}

	void common_insert(String formSerCd, List<String> collist, List<Map<String,String>> data, List<Map<String, String>> colmap) throws SQLException {
		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			prepareSql(sql, collist, TableNames.OFFICE_COMMON.toString());
			ps = con.prepareStatement(sql.toString());
			common_insertExecute(ps, formSerCd, data, colmap);
		} finally {
			psClose(ps);
		}
	}

	void unique_insert(String table, List<String> collist, List<Map<String,String>> data, List<Map<String, String>> colmap) throws SQLException {
		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			prepareSql(sql, collist, table);
			ps = con.prepareStatement(sql.toString());
			unique_insertExecute(ps, table, data, colmap);
		} finally {
			psClose(ps);
		}
	}

	private void unique_insertExecute(PreparedStatement ps, String table, List<Map<String,String>> data, List<Map<String, String>> colmap) throws SQLException {
		for (Map<String,String> d : data) {
			if (d.get(ColumnNames.VALIDATE) == null){
				int i = 0;
				for ( Map<String,String> c : colmap) {
					DataTypeEnum.getValue(ps, i,  c.get(ColumnNames.DATATYPE), c.get(ColumnNames.COLUMN_NAME), d);
					i++;
				}
				//Logger.write(ColumnNames.OFFICE_ID + " : "+ d.get(ColumnNames.OFFICE_ID ));
				ps.execute();
			}
		}
	}

	private void common_insertExecute(PreparedStatement ps, String formSerCd, List<Map<String,String>> data, List<Map<String, String>> colmap) throws SQLException {
		for (Map<String,String> d : data) {
			if (d.get(ColumnNames.VALIDATE) == null){
				int i = 0;
				for ( Map<String,String> c : colmap) {
					if (c.get(ColumnNames.COLUMN_NAME).equals(ColumnNames.FORMSERCD)) {
						ps.setString(i + 1, formSerCd);
					} else {
						DataTypeEnum.getValue(ps, i,  c.get(ColumnNames.DATATYPE), c.get(ColumnNames.COLUMN_NAME), d);
					}
					i++;
				}
				ps.execute();
			}
		}
	}

	private static void v_insertExecute(PreparedStatement ps, String v_table, List<Map<String,String>> data, List<Map<String, String>> colmap) throws SQLException {
		for (Map<String,String> d : data) {
			int i = 0;
			for ( Map<String,String> c : colmap) {
				switch (c.get(ColumnNames.COLUMN_NAME)){
				case ColumnNames.OFFICE_ID:
					ps.setInt(i + 1, Integer.valueOf(d.get(ColumnNames.OFFICE_ID)));
					break;
				case ColumnNames.VALIDATE:
					if (d.get(ColumnNames.VALIDATE) != null) {
						ps.setBoolean(i + 1, false);
					} else {
						ps.setBoolean(i + 1, true);
					}
					break;
				default:
					ps.setObject(i + 1, d.get(c.get(ColumnNames.COLUMN_NAME)));
					break;
				}
				i++;
			}
			ps.execute();
		}
	}

	private void j_insertExecute(PreparedStatement ps, List<String> collist, List<Map<String,String>> offices) throws SQLException {
		int office_id = 0;
		for (Map<String,String> c : offices) {
			for ( int i = 0; i < collist.size(); ++i ) {
				if (collist.get(i).equals(ColumnNames.OFFICE_ID)){
					ps.setInt(i + 1, office_id);
				} else {
					ps.setObject(i + 1, (c.get(collist.get(i)) != null) ? c.get(collist.get(i)).trim(): null);
				}
			}
			ps.execute();
			office_id++;
		}
	}

	private static void prepareSql(StringBuilder sql, List<String> collist, String table) {
		sql.append("INSERT");
		sql.append(" INTO ");
		sql.append(table);
		sql.append('(');

		int i = 0;
		for (i = 0; i < collist.size(); ++i) {
			sql.append((i > 0) ? "," : "");
			sql.append(collist.get(i));
		}
		sql.append(')');
		sql.append(" VALUES (");
		for (i = 0; i < collist.size(); i++) {
			sql.append((i > 0) ? ",?" : "?");
		}
		sql.append(')');
	}

	void update(String table, boolean b, String formSerCd) throws SQLException {
		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			updateSql(sql, table, ColumnNames.J_FLG, ColumnNames.FORMSERCD);
			ps = con.prepareStatement(sql.toString());
			updateExecute(ps, b,formSerCd);
		} finally {
			psClose(ps);
		}
	}

	private void updateExecute(PreparedStatement ps, boolean b, String formSerCd) throws SQLException {
			ps.setBoolean(1, b);
			ps.setString(2, formSerCd);
			ps.execute();
	}

	private void updateSql(StringBuilder sql, String table, String setCol, String whCol) {
		sql.append(" UPDATE ");
		sql.append(table);
		sql.append(" SET ");
		sql.append(setCol);
		sql.append(" = ? ");
		sql.append(" WHERE ");
		sql.append(whCol);
		sql.append(" = ? ");
	}

	void updateAll(String table, boolean b) throws SQLException {
		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			updateAllSql(sql, table, ColumnNames.J_FLG);
			ps = con.prepareStatement(sql.toString());
			updateAllExecute(ps, b);
		} finally {
			psClose(ps);
		}
	}

	private void updateAllSql(StringBuilder sql, String table, String setCol) {
		sql.append(" UPDATE ");
		sql.append(table);
		sql.append(" SET ");
		sql.append(setCol);
		sql.append(" = ? ");
	}

	private void updateAllExecute(PreparedStatement ps, boolean b) throws SQLException {
		ps.setBoolean(1, b);
		ps.execute();
	}

	public void delete(String sql) throws SQLException {
		PreparedStatement ps = null;
		try {
			ps = this.con.prepareStatement(sql);
			ps.executeUpdate();
		} finally {
			psClose(ps);
		}
	}

	public boolean exist_table(String stadName, String table) throws SQLException {
		CallableStatement cstmt = null;
		boolean b = false;
		cstmt = con.prepareCall(String.format("{CALL %S( ?, ? )}",stadName));
		cstmt.setString(1, table);
		cstmt.registerOutParameter(2, Types.INTEGER);
		cstmt.execute();
		if (cstmt.getInt(2) == 1 ){ b = true; }
		cstmtClose(cstmt);
		return b;
	}

	public List<Map<String, String>> select(String sql) throws SQLException {
		Statement stmt = null;
		ResultSet rset = null;
		try {
			stmt = this.con.createStatement();
			rset = stmt.executeQuery(sql);
			return getData(rset);
		} finally {
			silentClose(rset,stmt);
		}
	}

	protected final List<Map<String, String>> getData(ResultSet rset) throws SQLException {
		List<Map<String, String>> list = new ArrayList<Map<String, String>>();
		ResultSetMetaData meta = rset.getMetaData();
		while (rset.next()) {
			int count = meta.getColumnCount();
			Map<String, String> map = new HashMap<String, String>();
			for (int i = 0; i < count; i++) {
				 String cn = meta.getColumnName(i + 1);
				 String value = rset.getString(cn);
				 map.put(cn, value);
			}
			list.add(map);
		}
		return list;
	}

	private void silentClose(ResultSet rset, Statement stmt) throws SQLException {
		if (rset != null) {
			rset.close();
		}
		if (stmt != null) {
			stmt.close();
		}
	}

	private static void psClose(PreparedStatement ps) throws SQLException {
		if (ps != null) {
			ps.close();
		}
	}	

	private void cstmtClose(CallableStatement cstmt) throws SQLException {
		if (cstmt != null) {
			cstmt.close();
		}
	}
}
