package databaseTest;

import java.sql.*;
public class Test {
	public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/testdb"; // 資料庫 URL
        String username = "root"; // 預設帳號
        String password = "";     // XAMPP 預設無密碼（可到 phpMyAdmin 設定）

        try {
            // 載入 JDBC 驅動
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 建立連線
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("資料庫連線成功！");

            //insert
            Statement stmt1 = conn.createStatement();
            String sql = "INSERT INTO users (ID, Name, Email) VALUES (1, 'Norwell', '42lich1mst@hft-stuttgart.de')";
            stmt1.executeUpdate(sql);
            // 執行查詢
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM users");
            
            

            // 印出結果
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                                   ", Name: " + rs.getString("name") +
                                   ", Email: " + rs.getString("email"));
            }

            // 關閉連線
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
