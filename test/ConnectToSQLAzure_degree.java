import java.sql.*;
import com.microsoft.sqlserver.jdbc.*;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class ConnectToSQLAzure_degree {

	public static void main(String[] args) throws IOException {

		// Create a variable for the connection string.
		String connectionUrl = "jdbc:sqlserver://zmc987ph20.database.windows.net:1433;database=milmodbdev;user=welmo@zmc987ph20;password={we11Motion};encrypt=true;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

		// Declare the JDBC objects.
		Connection con = null;
		//Statement stmt = null;
		//ResultSet rs = null;
		PreparedStatement pstmt = null;
		String[] csvArray;
		String strQuestion = "";
		String colName = "";
		String line;
		String SQL = "";
		int ColLength = 0;
		int j = 0;
		
		String inputDatFile = "./110_degree.dat";
		File inputFile = new File(inputDatFile);
		BufferedReader in = null;
		in = new BufferedReader(new FileReader(inputFile));

		try {
			// Establish the connection.
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			con = DriverManager.getConnection(connectionUrl);
			con.setAutoCommit(false);
			
			//SQL = "DELETE FROM home_care";
			//pstmt = con.prepareStatement(SQL);
			//pstmt.executeUpdate();

			// Create and execute an SQL statement that returns some data.
			colName = in.readLine();
			
			SQL = "INSERT INTO degree (" + colName + ") values (?,?,?,?)";
			pstmt = con.prepareStatement(SQL);

			while ((line = in.readLine()) != null){
				//System.out.println("line =" + line);
				csvArray = line.split("\\,");
				//System.out.println("csvArray.length = " + csvArray.length);
				for ( j = 0; j < csvArray.length; j++){
					if(("").equals( csvArray[j]) || ("null").equals( csvArray[j]) || ("NULL").equals( csvArray[j])){ csvArray[j] = null;}
					//System.out.println((j + 1) + ":" + csvArray[j]);
					pstmt.setString(j+1,csvArray[j]);
				}
				System.out.println(">>>>GO INSERT ( j = " + j + ".....");
				pstmt.executeUpdate();
			}
			System.out.println(">>>>INSERT OK.....");
			con.commit();
			System.out.println(">>>>COMMIT OK.....");
			pstmt.close();

			// Iterate through the data in the result set and display it.
			//while (rs.next()) {
			//	System.out.println(rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
			//}
			//rs.close();
			//stmt.close();
		}

		// Handle any errors that may have occurred.
		catch (Exception e) {
			System.out.println("Catch Exception");
			System.out.print(e.toString());
			if (e instanceof SQLException) {
				System.out.println("ErrorCode: " +
				((SQLException)e).getErrorCode());
			}
			e.printStackTrace();
			try{
				//if (stmt != null) { stmt.close(); }
				if (pstmt != null) { pstmt.close(); }
				if (con != null) {
					con.rollback();
					System.out.println(">>>>ROLLBACK OK.....");
					con.close();
				}
			}
			catch (SQLException se) {}
		}
		finally {
			//if (rs != null) try { rs.close(); } catch(Exception e) {}
			if (in != null) try { in.close(); } catch(Exception e) {}
			if (con != null) try { con.close(); } catch(Exception e) {}
			//if (stmt != null) try { stmt.close(); } catch(Exception e) {}
			if (pstmt != null) try { pstmt.close(); } catch(Exception e) {}
		}
	}
}
