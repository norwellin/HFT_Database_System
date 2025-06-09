package databaseTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class AddTenant extends JFrame {
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField = new JTextField(20);
	private JTextField textField_1 = new JTextField(20);
	private JTextField textField_email = new JTextField(50);
	private JTextField textField_roomnumber = new JTextField(20);
	private JTextField textField_deposit = new JTextField(20);
	private JTextField[] fields = {textField, textField_1, textField_email, textField_roomnumber, textField_deposit};
	private JLabel message;
	JSpinner spinner;
	JSpinner spinner2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddTenant frame = new AddTenant();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddTenant() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1019, 595);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Tenant Adding Page");
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 301, SpringLayout.WEST, contentPane);
		lblNewLabel.setForeground(new Color(255, 128, 0));
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 38));
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel, 43, SpringLayout.SOUTH, lblNewLabel);
		contentPane.add(panel);
		panel.setLayout(new MigLayout("", "[][grow]", "[][][][][][]"));
		
		JLabel lblNewLabel_1 = new JLabel("Personal Details");
		lblNewLabel_1.setForeground(new Color(128, 0, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 24));
		panel.add(lblNewLabel_1, "cell 0 0");
		
		JLabel lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 24));
		panel.add(lblNewLabel_2, "cell 0 1,alignx trailing");
		

		textField.setFont(new Font("Arial", Font.PLAIN, 24));
		panel.add(textField, "cell 1 1,growx");
		textField.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Last Name:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 24));
		panel.add(lblNewLabel_2_1, "cell 0 2,alignx trailing");
		

		textField_1.setFont(new Font("Arial", Font.PLAIN, 24));
		textField_1.setColumns(10);
		panel.add(textField_1, "cell 1 2,growx");
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Email:");
		lblNewLabel_2_1_1.setFont(new Font("Arial", Font.PLAIN, 24));
		panel.add(lblNewLabel_2_1_1, "cell 0 3,alignx trailing");
		

		textField_email.setFont(new Font("Arial", Font.PLAIN, 24));
		textField_email.setColumns(10);
		panel.add(textField_email, "cell 1 3,growx");
		
		JPanel panel_2 = new JPanel();
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel, -6, SpringLayout.NORTH, panel_2);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, panel_2);
		sl_contentPane.putConstraint(SpringLayout.NORTH, panel_2, 273, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, panel_2, -67, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, panel_2);
		sl_contentPane.putConstraint(SpringLayout.WEST, panel_2, 137, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, panel_2, -175, SpringLayout.EAST, contentPane);
		contentPane.add(panel_2);
		panel_2.setLayout(new MigLayout("", "[][grow]", "[][][][][][][][]"));
		
		JLabel lblNewLabel_1_1 = new JLabel("Contract Details");
		panel_2.add(lblNewLabel_1_1, "cell 0 0");
		lblNewLabel_1_1.setForeground(new Color(128, 0, 255));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 24));
		
		JLabel lblNewLabel_2_2_1_4_1 = new JLabel("Room Number:");
		lblNewLabel_2_2_1_4_1.setFont(new Font("Arial", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_2_2_1_4_1, "cell 0 1,alignx trailing");
		

		textField_roomnumber.setFont(new Font("Arial", Font.PLAIN, 24));
		textField_roomnumber.setColumns(10);
		panel_2.add(textField_roomnumber, "cell 1 1,growx");
		
		JLabel lblNewLabel_2_2 = new JLabel("Deposit:");
		panel_2.add(lblNewLabel_2_2, "cell 0 2,alignx trailing");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 24));
		

		textField_deposit.setFont(new Font("Arial", Font.PLAIN, 24));
		textField_deposit.setColumns(10);
		panel_2.add(textField_deposit, "cell 1 2,growx");
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Move In Date:");
		panel_2.add(lblNewLabel_2_2_1, "cell 0 3,alignx trailing");
		lblNewLabel_2_2_1.setFont(new Font("Arial", Font.PLAIN, 24));
		
		/*
		textField_movein = new JTextField();
		textField_movein.setFont(new Font("Arial", Font.PLAIN, 24));
		textField_movein.setColumns(10);
		panel_2.add(textField_movein, "cell 1 3,growx");*/
		// 建立日期模型
		SpinnerDateModel model = new SpinnerDateModel();
        spinner = new JSpinner(model);
        spinner.setFont(new Font("Arial", Font.PLAIN, 24));
        spinner.setEditor(new JSpinner.DateEditor(spinner, "yyyy-MM-dd"));
        panel_2.add(spinner, "cell 1 3,growx");
        
		JLabel lblNewLabel_2_2_1_4 = new JLabel("Move Out Date:");
		lblNewLabel_2_2_1_4.setFont(new Font("Arial", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_2_2_1_4, "cell 0 4,alignx trailing");
		
		SpinnerDateModel model1 = new SpinnerDateModel();
        spinner2 = new JSpinner(model1);
        spinner2.setFont(new Font("Arial", Font.PLAIN, 24));
        spinner2.setEditor(new JSpinner.DateEditor(spinner, "yyyy-MM-dd"));
        panel_2.add(spinner2, "cell 1 4,growx");
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setFont(new Font("Arial", Font.PLAIN, 24));
		panel_2.add(lblNewLabel_2_1_1_1, "cell 0 7");
		
		JButton btnNewButton = new JButton("Saves");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addTenant(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -10, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, 0, SpringLayout.EAST, panel);
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnNewButton);
		
		message = new JLabel("");
		message.setForeground(new Color(255, 0, 0));
		sl_contentPane.putConstraint(SpringLayout.SOUTH, message, 0, SpringLayout.SOUTH, btnNewButton);
		message.setFont(new Font("Arial", Font.PLAIN, 28));
		sl_contentPane.putConstraint(SpringLayout.NORTH, message, 0, SpringLayout.NORTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, message, 0, SpringLayout.WEST, panel);
		sl_contentPane.putConstraint(SpringLayout.EAST, message, 0, SpringLayout.EAST, lblNewLabel);
		contentPane.add(message);
	}
	protected boolean checkAllFieldsFilled() {
		boolean key = true;
		for(JTextField field: fields) {
			if(field.getText().trim().isEmpty()) {
				key = false;
				field.setBackground(Color.pink);
			}
			else {
				field.setBackground(Color.white);
			}
		}
		return key;
	}
	protected void addTenant(ActionEvent e) throws SQLException {
		// TODO Auto-generated method stub
		DatabaseManage db = new DatabaseManage();
		
		//get All values from columns
		String firstName = textField.getText();
		String lastName = textField_1.getText();
		String deposit = textField_deposit.getText();
		float depositF = Float.parseFloat(deposit);
		String email = textField_email.getText();
		String roomnum = textField_roomnumber.getText();
		int roomnumInt = Integer.parseInt(roomnum);
		Date movein = (Date) spinner.getValue();
		java.sql.Date sqlmovein = new java.sql.Date(movein.getTime());
		Date moveout = (Date) spinner2.getValue();
		java.sql.Date sqlmoveout = new java.sql.Date(moveout.getTime());
		
		boolean inputKey = true;
		//check is this tenant already exit or is the room already rent out
		try {
			if(db.exitSearch(email, "tenant", "email")) {
				message.setText("This tenant is already exit.");
				inputKey = false;
			}
			if(!db.exitSearch(roomnum, "room", "room_number")) {
				message.setText("This room does not exist in the database.");
				inputKey = false;
			}
			//check is all columns been filled
			if(!checkAllFieldsFilled()) {
				message.setText("Please fill in all blanks");
				inputKey = false;
			}
			//If everything is validate than put it into database
			//We have to insert into three tables
			if(inputKey) {
				//Insert to tenant table
				String sqlTenant = "INSERT INTO tenant (first_name, last_name, email) VALUES (?,?,?)";
				PreparedStatement pstmt = db.myconn.prepareStatement(sqlTenant);
				pstmt.setString(1, firstName);
				pstmt.setString(2, lastName);
				pstmt.setString(3, email);
				
				boolean isinsert = db.insert(pstmt);
				
				//insert into contract table
				String sqlContract = "INSERT INTO contract (deposit, move_in_date, move_out_date, status, amount) VALUES (?,?,?,?,?)";
				//We have to find some value automatically
				Object amountobject = db.search(roomnumInt, "room" , "room_number", "rent_amount");
				//problem here
				float amount= 0;
				if(amountobject instanceof Float) {
					amount = (Float) amountobject;
				}
				PreparedStatement pstmtContract = db.myconn.prepareStatement(sqlContract);
				pstmtContract.setFloat(1, depositF);
				pstmtContract.setDate(2, sqlmovein);
				pstmtContract.setDate(3, sqlmoveout);
				pstmtContract.setString(4, "Active");
				pstmtContract.setFloat(5, amount);
				
				boolean isinsert2 = db.insert(pstmtContract);
			}
			
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
