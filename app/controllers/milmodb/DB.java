package controllers.milmodb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import util.common.ColumnNames;

import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;

public class DB {
	private static final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String URL_FORMAT = "jdbc:sqlserver://%s:%s;database=%s";
	private static final String DB_SERVER = "zmc987ph20.database.windows.net";
	private static final String DB_PORT = "1433";
	private static final String DB_NAME = "milmodb";
	private static final String DB_USER = "welmo@zmc987ph20";
	private static final String DB_PASSWORD = "we11Motion";
	
	public final Connection con;
	//private final boolean showSQL;
	
	public DB() throws Exception {
		this.con = setupConnection();
		this.con.setAutoCommit(false);
		System.out.println("Connect OK!");
	}
	
	private Connection setupConnection() throws Exception {
		Class.forName(DRIVER);
		String JDBC_URL = String.format(URL_FORMAT, DB_SERVER, DB_PORT, DB_NAME);
		return DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD);
	}

	public void commit() {
		try {
			this.con.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void rollback() {
		try {
			this.con.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void close() {
		try {
			this.con.close();
			System.out.println(">> DB Close!!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	void insert(String table, List<String> ColList, List<Map<String,String>> offices) {
		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			j_prepareSql(sql, ColList, table);
			ps = con.prepareStatement(sql.toString());
			insertExecute(ps, table, ColList, offices);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			if (ps != null) {
				try {
					System.out.println(">> ps Close");
					ps.close();
				} catch (SQLException e) {
					//throw new IllegalStateException(e);
					e.printStackTrace();
				}
			}
		}
	}
	
	
	private void insertExecute(PreparedStatement ps, String table, List<String> ColList, List<Map<String,String>> offices) throws SQLException {
		int office_id = 0;
		for (Map<String,String> c : offices) {
			ps.setInt(1, office_id);
			for ( int i = 0; i < ColList.size(); ++i ) {
				if (ColList.get(i).equals(ColumnNames.OFFICE_ID)){
					ps.setInt(i + 1, office_id);
				} else {
					String str = c.get(ColList.get(i));
					ps.setString(i + 1, str);
				}
			}
			
			ps.execute();
			
			office_id++;
		}
	}

	private void j_prepareSql(StringBuilder sql, List<String> ColList, String table) {
		sql.append("INSERT");
		sql.append(" INTO ");
		sql.append(table);
		sql.append('(');

		int i = 0;
		for (i = 0; i < ColList.size(); ++i) {
			sql.append((i > 0) ? "," : "");
			sql.append(ColList.get(i));
		}
		sql.append(')');
		sql.append(" VALUES (");
		for (i = 0; i < ColList.size(); i++) {
			sql.append((i > 0) ? ",?" : "?");
		}
		sql.append(')');
	}
	
	void updatevalidate(String table, List<Map<String,String>> offices) {
		PreparedStatement ps = null;
		try {
			StringBuilder sql = new StringBuilder();
			j_updateSql(sql, table);
			ps = con.prepareStatement(sql.toString());
			updateExecute(ps, table, offices);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			if (ps != null) {
				try {
					System.out.println(">> ps Close");
					ps.close();
				} catch (SQLException e) {
					//throw new IllegalStateException(e);
					e.printStackTrace();
				}
			}
		}
	}
	
	private void updateExecute(PreparedStatement ps, String table, List<Map<String,String>> offices) throws SQLException {
		for (Map<String,String> c : offices) {
			ps.setBoolean(1, Boolean.valueOf(c.get(ColumnNames.IVALIDATE_FLG)));
			ps.setInt(2, Integer.valueOf(c.get(ColumnNames.OFFICE_ID)));		
			ps.execute();
		}
	}
	
	private void j_updateSql(StringBuilder sql, String table) {
		sql.append(" UPDATE ");
		sql.append(table);
		sql.append(" SET ");
		sql.append(ColumnNames.IVALIDATE_FLG);
		sql.append(" = ? ");
		sql.append(" WHERE ");
		sql.append(ColumnNames.OFFICE_ID);
		sql.append(" = ? ");
	}
		
	public void delete(String sql){
		PreparedStatement ps = null;
		try {
			ps = this.con.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			try {
				if (ps != null){
					ps.close();
					System.out.println("ps Close");
				}
			} catch (SQLException e) {
				//Logger.error(e, "result setのclose中にエラーが発生しました。");
				e.printStackTrace();
			}
			
		}
	}
	
	public boolean exist_table(String stadName, String table){
		CallableStatement cstmt = null;
		boolean b = false;
		try {
			cstmt = con.prepareCall(String.format("{CALL %S( ?, ? )}",stadName));
			cstmt.setString(1, table);
			cstmt.registerOutParameter(2, Types.INTEGER);
			cstmt.execute();
			if (cstmt.getInt(2) == 1 ){
				b = true;
			} 
			return b;
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new IllegalStateException(e);
		} finally {
			cstmtClose(cstmt);
		}
	}
	
	public List<Map<String, String>> select(String sql){
		Statement stmt = null;
		ResultSet rset = null;
		try {
			stmt = this.con.createStatement();
			rset = stmt.executeQuery(sql);
			return getData(rset);
		} catch (SQLException e) {
			//e.printStackTrace();
			throw new IllegalStateException(e);
		} finally {
			silentClose(rset, stmt);
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

	private void silentClose(ResultSet rset, Statement stmt) {
		if (rset != null) {
			try {
				rset.close();
				//System.out.println("rset Close");
			} catch (SQLException e) {
				//Logger.error(e, "resultsetのクローズに失敗しました。");
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
				//System.out.println("stmt Close");
			} catch (SQLException e) {
				//Logger.error(e, "preparedstatementのクローズに失敗しました。");
				e.printStackTrace();
			}
		}
	}

	private void cstmtClose(CallableStatement cstmt) {
		if (cstmt != null) {
			try {
				cstmt.close();
				//System.out.println("ctmt Close");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
