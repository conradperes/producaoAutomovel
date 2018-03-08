package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private Connection con = null;

	public Connection getConnection() {
		try {
			if (con == null) {
				con = DriverManager.getConnection("jdbc:mysql://localhost/trabalhoav1", "root", "rootroot");
			}
			return con;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void closeConnection() {
		try {
			if(con!=null && !con.isClosed())
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}