package databaseTest;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class UserQueryApp extends JFrame {
    private JButton queryButton;
    private JTable resultTable;
    private DefaultTableModel tableModel;

    public UserQueryApp() {
        setTitle("User Table Query");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // 上方的按鈕
        queryButton = new JButton("查詢使用者");
        add(queryButton, BorderLayout.NORTH);

        // 下方表格
        tableModel = new DefaultTableModel();
        resultTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(resultTable);
        add(scrollPane, BorderLayout.CENTER);

        // 按鈕事件
        queryButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                queryUserTable();
            }
        });
    }

    // 資料庫查詢函數
    private void queryUserTable() {
        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "";

        String query = "SELECT * FROM users";

        try (Connection conn = DriverManager.getConnection(url, username, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            // 清除舊欄位與資料
            tableModel.setRowCount(0);
            tableModel.setColumnCount(0);

            // 建立欄位名稱
            ResultSetMetaData rsMeta = rs.getMetaData();
            int columnCount = rsMeta.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                tableModel.addColumn(rsMeta.getColumnName(i));
            }

            // 加入資料列
            while (rs.next()) {
                Object[] row = new Object[columnCount];
                for (int i = 1; i <= columnCount; i++) {
                    row[i - 1] = rs.getObject(i);
                }
                tableModel.addRow(row);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "查詢失敗：" + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        // 加載驅動程式（MySQL 8+ 通常不需要這行）
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        SwingUtilities.invokeLater(() -> {
            new UserQueryApp().setVisible(true);
        });
    }
}

