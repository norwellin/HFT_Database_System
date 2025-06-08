package databaseTest;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import java.sql.*
;
import java.util.ArrayList;
import java.util.List;
import javax.swing.SpringLayout;
public class AddContractDetails extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JFrame f;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddContractDetails frame = new AddContractDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddContractDetails() throws SQLException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1216, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		//From here automatically create table
		Connection conn;
		DatabaseManage db = new DatabaseManage();
		conn = db.getConnection();
		Statement stmt = conn.createStatement();
		
		String sql_contract = "Select tenant_id, deposit, move_in_date, move_out_date, status, amount FROM contract";
		String sql_tenant = "Select tenant_id, first_name, last_name FROM tenant";
		int buttonNumber = 0;
		List<List<String>> data = new ArrayList<>();
		
		//Search for tenant table first
		ResultSet rs_tenant = stmt.executeQuery(sql_tenant);
		while(rs_tenant.next()) {
			List<String> row = new ArrayList<>();
			
			row.add(rs_tenant.getString("tenant_id"));
			row.add(rs_tenant.getString("first_name"));
			row.add(rs_tenant.getString("last_name"));
			
			data.add(row);
			buttonNumber++;
		}
		
		//search for contract table if their tenant id matc than combine that row together to variable data
		ResultSet rs_contract = stmt.executeQuery(sql_contract);	
		while(rs_contract.next()) {		
			for(int i = 0; i<data.size();i++) {	
				if(data.get(i).get(0).equalsIgnoreCase(rs_contract.getString("tenant_id"))) {
					data.get(i).add(rs_contract.getString("deposit"));
					data.get(i).add(rs_contract.getString("move_in_date"));
					data.get(i).add(rs_contract.getString("move_out_date"));
					data.get(i).add(rs_contract.getString("status"));
					data.get(i).add(rs_contract.getString("amount"));
					break;
				}
			}
		}
		System.out.println(data);
		
		//Automatically create button
		ArrayList<JButton> buttonList = new ArrayList<>();
		
		for(int i=0; i<buttonNumber; i++) {
			//ImageIcon image = new ImageIcon("edit.png");
			JButton btn = new JButton("Edit");
			buttonList.add(btn);
			
			btn.addActionListener(e -> {
	                JButton clickedButton = (JButton) e.getSource();
	                int index = buttonList.indexOf(clickedButton);
	                System.out.println("Button at index " + index + " clicked.");
	         });
		}
		
		//List -> Array
		int cols = data.get(0).size();
		int rows = data.size();
		System.out.println("cols: "+cols+" rows: "+rows);
		Object[][] datas = new Object[rows][cols+1];
		
		for (int i = 0; i < rows; i++) {
			System.out.println("i: "+i);
		    List<String> row = data.get(i);
		    System.out.println(row);
		    for (int j = 0; j < cols; j++) {
		    	System.out.println("j: "+j);
		        datas[i][j] = row.get(j);
		    }
		    datas[i][cols] = buttonList.get(i);
		}
		String[] columnNames = {"tenant_id", "first_name", "last_name", "deposit", "move_in_date", "move_out_date", "status", "amount", "Edit"};
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		//String[] columnNames = {"tenant_id", "first_name", "last_name"};
		//model = new DefaultTableModel(datas , columnNames);
		table = new JTable(datas , columnNames);

		// 自訂Renderer顯示按鈕
		table.getColumnModel().getColumn(cols).setCellRenderer(new TableCellRenderer() {
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
		            boolean hasFocus, int row, int column) {
		        return (JButton) value;
		    }
		});

		// 自訂Editor讓按鈕可以點擊
		table.getColumnModel().getColumn(cols).setCellEditor(new DefaultCellEditor(new JCheckBox()) {
		    @Override
		    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
		            int column) {
		        return (JButton) value;
		    }
		});
		table.setBounds(30, 40, 200, 300);
		JScrollPane sp = new JScrollPane(table);
		sl_contentPane.putConstraint(SpringLayout.NORTH, sp, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, sp, 5, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, sp, -5, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, sp, 1187, SpringLayout.WEST, contentPane);
		table.setFont(new Font("Serif", Font.PLAIN, 26));
		table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 20));
		table.setRowHeight(28);
		contentPane.add(sp);
		
		
	}

}
