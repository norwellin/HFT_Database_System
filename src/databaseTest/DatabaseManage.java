package databaseTest;

import java.sql.*;
public class DatabaseManage{
	String url = "jdbc:mysql://localhost:3306/wg_database";
	String username = "root";
	String password = "";
	
	public Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(
                this.url,
                this.username, this.password
        );
        return conn;
	}
	
}
