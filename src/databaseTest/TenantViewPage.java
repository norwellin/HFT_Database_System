package databaseTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TenantViewPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TenantViewPage frame = new TenantViewPage();
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
	public TenantViewPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 857, 575);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Please select a query method");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 0, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -156, SpringLayout.EAST, contentPane);
		lblNewLabel.setForeground(new Color(255, 128, 64));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 36));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Tenant List");
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 28));
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 83, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, -634, SpringLayout.EAST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, 167, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -193, SpringLayout.EAST, contentPane);
		contentPane.add(btnNewButton);
		
		JButton btnTenantSearch = new JButton("Tenant Search");
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTenantSearch, 69, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTenantSearch, 0, SpringLayout.WEST, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnTenantSearch, 153, SpringLayout.SOUTH, btnNewButton);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnTenantSearch, -188, SpringLayout.EAST, contentPane);
		btnTenantSearch.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnTenantSearch);
		
		JButton btnNewButton_1 = new JButton("<- Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToAdminDashboard(e);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton_1, 0, SpringLayout.NORTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton_1, 0, SpringLayout.WEST, contentPane);
		btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnNewButton_1);
	}

	protected void goToAdminDashboard(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		AdminDashboard page = new AdminDashboard();
		page.setVisible(true);
	}
}
