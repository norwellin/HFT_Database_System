package databaseTest;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import java.util.logging.Level;
import java.util.logging.Logger;
public class MainFrame extends javax.swing.JFrame{

	private JFrame frame;
	private JTextField email;
	private JPasswordField password;
	private JTextField status;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}
	
	private void login(ActionEvent evt) {
		String input_email = email.getText();
        char[] pw = password.getPassword();
        String input_password = new String(pw);
        
        System.out.println("username: "+input_email+" password: "+input_password);
        
        DatabaseManage db = new DatabaseManage();
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        PreparedStatement pstmt = null;
        String sql = "SELECT * FROM owner where email = ? AND password = ?"; //? is the varable will set later
        

   
        
        try {
            conn = db.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, input_email); // (position sart from 1, variable)
            pstmt.setString(2, input_password);
            
            rs = pstmt.executeQuery();
            
            boolean key = false;
            while(rs.next()){
                String name = rs.getString("email");
                String pwd = rs.getString("password");
                
                System.out.println("name: "+name+" pw: "+pwd);
                key = true;
            }

            //if find the user -> open admi dashboard
            
            if(key){
                System.out.println("Login Success");
                this.dispose();
                AdminDashboard admin = new AdminDashboard();
                admin.setVisible(true);
            }
            else{
                System.out.println("Login failed");
                status.setText("Login failed");
                
            }
            
            
            
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 961, 652);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		JLabel lblNewLabel = new JLabel("Login Page");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel, 947, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 128, 0));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 40));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_1, 98, SpringLayout.SOUTH, lblNewLabel);
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel_1, 160, SpringLayout.WEST, frame.getContentPane());
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 28));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password: ");
		springLayout.putConstraint(SpringLayout.NORTH, lblNewLabel_2, 31, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, lblNewLabel_2, 0, SpringLayout.EAST, lblNewLabel_1);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 28));
		frame.getContentPane().add(lblNewLabel_2);
		
		email = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, email, -14, SpringLayout.NORTH, lblNewLabel_1);
		email.setFont(new Font("Arial", Font.PLAIN, 28));
		springLayout.putConstraint(SpringLayout.WEST, email, 27, SpringLayout.EAST, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.SOUTH, email, 0, SpringLayout.SOUTH, lblNewLabel_1);
		springLayout.putConstraint(SpringLayout.EAST, email, 446, SpringLayout.EAST, lblNewLabel_1);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		password = new JPasswordField();
		password.setColumns(10);
		springLayout.putConstraint(SpringLayout.NORTH, password, 24, SpringLayout.SOUTH, email);
		springLayout.putConstraint(SpringLayout.WEST, password, 27, SpringLayout.EAST, lblNewLabel_2);
		springLayout.putConstraint(SpringLayout.EAST, password, -262, SpringLayout.EAST, frame.getContentPane());
		password.setFont(new Font("新細明體", Font.PLAIN, 28));
		frame.getContentPane().add(password);
		
		JButton btnNewButton = new JButton("Login");
		springLayout.putConstraint(SpringLayout.WEST, btnNewButton, 503, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNewButton, -262, SpringLayout.EAST, frame.getContentPane());
		btnNewButton.setForeground(new Color(128, 128, 255));
		btnNewButton.setBackground(Color.PINK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				login(e);

			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 28));
		frame.getContentPane().add(btnNewButton);
		
		status = new JTextField();
		springLayout.putConstraint(SpringLayout.SOUTH, password, -24, SpringLayout.NORTH, status);
		springLayout.putConstraint(SpringLayout.NORTH, btnNewButton, 35, SpringLayout.SOUTH, status);
		springLayout.putConstraint(SpringLayout.NORTH, status, 273, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, status, -295, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, status, -616, SpringLayout.EAST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, status, -318, SpringLayout.EAST, frame.getContentPane());
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setFont(new Font("Arial", Font.PLAIN, 28));
		status.setEditable(false);
		status.setForeground(Color.RED);
		frame.getContentPane().add(status);
		status.setColumns(10);
		
	}
}
