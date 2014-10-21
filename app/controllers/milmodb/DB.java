package controllers.milmodb;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

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
		PreparedStatement ps_d = null;
		try {
			StringBuilder sql = new StringBuilder();
			StringBuilder sql_d = new StringBuilder();
			j_prepareSql(sql, ColList, table);
			j_prepareSql_degree(sql_d);
			ps = con.prepareStatement(sql.toString());
			ps_d = con.prepareStatement(sql_d.toString());
			System.out.println(sql_d.toString());
			insertExecute(ps, ps_d, table, ColList, offices);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			if (ps != null) {
				try {
					System.out.println(">> ps Close");
					ps.close();
					ps_d.close();
				} catch (SQLException e) {
					throw new IllegalStateException(e);
				}
			}
		}
	}
	
	
	private void insertExecute(PreparedStatement ps, PreparedStatement ps_d, String table, List<String> ColList, List<Map<String,String>> offices) throws SQLException {
		int office_id = 0;
		for (Map<String,String> c : offices) {
			ps.setInt(1, office_id);
			for ( int i = 0; i < ColList.size(); ++i ) {
				String str = c.get(ColList.get(i));
				
				ps.setString(i + 2, str);
			}
			
			ps_d.setString(1, table);
			ps_d.setInt(2, office_id);
			ps_d.setString(3, c.get("latitude"));
			ps_d.setString(4, c.get("longitude"));
			
			ps.execute();
			ps_d.execute();
			
			office_id++;
		}

	}

	private void j_prepareSql(StringBuilder sql, List<String> ColList, String table) {
		sql.append("INSERT");
		sql.append(" INTO ");
		sql.append(table);
		sql.append('(');

		int i = 0;
		sql.append("office_id,");
		for (i = 0; i < ColList.size(); ++i) {
			sql.append((i > 0) ? "," : "");
			sql.append(ColList.get(i));
		}
		sql.append(')');
		sql.append(" VALUES (");
		sql.append("?,");
		for (i = 0; i < ColList.size(); i++) {
			sql.append((i > 0) ? ",?" : "?");
		}
		sql.append(')');
	}
	
	private void j_prepareSql_degree(StringBuilder sql_d) {
		sql_d.append("INSERT");
		sql_d.append(" INTO ");
		sql_d.append("j_degree");
		sql_d.append('(');
		sql_d.append("table_name,");
		sql_d.append("office_id,");
		sql_d.append("latitude,");
		sql_d.append("longitude");
		sql_d.append(')');
		sql_d.append(" VALUES (");
		sql_d.append("?,");
		sql_d.append("?,");
		sql_d.append("?,");
		sql_d.append("?");
		sql_d.append(')');
	}	
	
	public int delete(String sql){
		PreparedStatement ps = null;
		try {
			ps = this.con.prepareStatement(sql);
			int delRow = ps.executeUpdate();
			return delRow;
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
			}
			
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
				System.out.println("rset Close");
			} catch (SQLException e) {
				//Logger.error(e, "resultsetのクローズに失敗しました。");
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
				System.out.println("stmt Close");
			} catch (SQLException e) {
				//Logger.error(e, "preparedstatementのクローズに失敗しました。");
			}
		}
	}
}
