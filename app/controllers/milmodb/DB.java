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
	private static final String DB_NAME = "milmodbdev";
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
	
	void insert(String table, Map<String, String> values) {
		PreparedStatement ps = null;
		try {
			ArrayList<String> bindArgs = new ArrayList<String>();
			StringBuilder sql = new StringBuilder();
			int officeid_i = prepareSql(sql, bindArgs, table, values);
			ps = con.prepareStatement(sql.toString());
			insertExecute(ps, bindArgs, officeid_i);
		} catch (SQLException e) {
			throw new IllegalStateException(e);
		} finally {
			if (ps != null) {
				try {
					System.out.println(">> ps Close");
					ps.close();
				} catch (SQLException e) {
					throw new IllegalStateException(e);
				}
			}
		}
	}
	
	private void insertExecute(PreparedStatement ps, ArrayList<String> bindArgs, int officeid_i) throws SQLException {
		for (int i = 0; i < bindArgs.size(); i++) {
			String bindArg = bindArgs.get(i);
			if (i == officeid_i){
				ps.setInt(i + 1, Integer.parseInt(bindArg));
				System.out.println(">> officeid_id" + Integer.parseInt(bindArg));
				continue;
			}
			ps.setString(i + 1, bindArg);
			System.out.println(">> " + (i + 1) + " : " +  bindArg);
		}
		
		ps.execute();
	}

	private int prepareSql(StringBuilder sql, ArrayList<String> bindArgs, String table, Map<String, String> values) {
		sql.append("INSERT");
		sql.append(" INTO ");
		sql.append(table);
		sql.append('(');

		int size = (values != null && values.size() > 0) ? values.size() : 0;
		int i = 0;
		int officeid_i = 0;
		for (String colName : values.keySet()) {
			sql.append((i > 0) ? "," : "");
			sql.append(colName);
			if (colName.equals("office_id")){
				officeid_i = i;
			}
			bindArgs.add(i++, values.get(colName));
		}
		sql.append(')');
		sql.append(" VALUES (");
		for (i = 0; i < size; i++) {
			sql.append((i > 0) ? ",?" : "?");
		}
		sql.append(')');
		return officeid_i;
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
