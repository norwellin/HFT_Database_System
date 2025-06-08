package databaseTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SpringLayout;
import javax.swing.JButton;

public class ManageTenantDetails extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTenantDetails frame = new ManageTenantDetails();
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
	public ManageTenantDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 537);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblPleaseSelectAn = new JLabel("Please select an Action");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblPleaseSelectAn, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblPleaseSelectAn, -231, SpringLayout.EAST, contentPane);
		lblPleaseSelectAn.setForeground(new Color(255, 128, 64));
		lblPleaseSelectAn.setFont(new Font("Arial", Font.BOLD, 36));
		contentPane.add(lblPleaseSelectAn);
		
		JButton btnNewButton_1 = new JButton("<- Back");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, lblPleaseSelectAn);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, contentPane);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnNewButton_1);
		
		JButton btnAddTenant = new JButton("Add Tenant");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnAddTenant, 57, SpringLayout.SOUTH, lblPleaseSelectAn);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnAddTenant, 216, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnAddTenant, 121, SpringLayout.SOUTH, lblPleaseSelectAn);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnAddTenant, 672, SpringLayout.WEST, contentPane);
		btnAddTenant.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnAddTenant);
		
		JButton btnUpdateTenant = new JButton("Update Tenant");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnUpdateTenant, 40, SpringLayout.SOUTH, btnAddTenant);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnUpdateTenant, 0, SpringLayout.WEST, btnAddTenant);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnUpdateTenant, 104, SpringLayout.SOUTH, btnAddTenant);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnUpdateTenant, 456, SpringLayout.WEST, btnAddTenant);
		btnUpdateTenant.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnUpdateTenant);
		
		JButton btnRemoveTenant = new JButton("Remove Tenant");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnRemoveTenant, 38, SpringLayout.SOUTH, btnUpdateTenant);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnRemoveTenant, 0, SpringLayout.WEST, btnAddTenant);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnRemoveTenant, 102, SpringLayout.SOUTH, btnUpdateTenant);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnRemoveTenant, 0, SpringLayout.EAST, btnAddTenant);
		btnRemoveTenant.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnRemoveTenant);
	}

}
