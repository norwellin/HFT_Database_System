package databaseTest;

import java.sql.*;
public class DatabaseManage{
	String url = "jdbc:mysql://localhost:3306/wg_database";
	String username = "root";
	String password = "";
	Connection myconn;
	
	public DatabaseManage() throws SQLException {
		this.myconn = this.getConnection();
	}
	
	
	public Connection getConnection() throws SQLException{
		Connection conn = DriverManager.getConnection(
                this.url,
                this.username, this.password
        );
        return conn;
	}
	
	//find is the value already exit or not
	public boolean exitSearch(Object o, String tableName, String colName) throws SQLException{
		//If find the col only return 1. only find the first record than return.
		String sql = "SELECT 1 FROM " + tableName + " WHERE " + colName + " = ? LIMIT 1";
		
		Connection conn = this.getConnection();
		try(PreparedStatement pstmt = this.myconn.prepareStatement(sql)){
			if (o instanceof String) {
				pstmt.setString(1, (String)o);
			}
			else if(o instanceof Integer) {
				pstmt.setInt(1, (Integer)o);
			}
			ResultSet rs = pstmt.executeQuery();
			return rs.next();
		}catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
	
	}
	
}
