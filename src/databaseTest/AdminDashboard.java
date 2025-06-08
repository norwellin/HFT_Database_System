package databaseTest;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SpringLayout;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class AdminDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDashboard frame = new AdminDashboard();
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
	public AdminDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1080, 681);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		SpringLayout sl_contentPane = new SpringLayout();
		contentPane.setLayout(sl_contentPane);
		
		JLabel lblNewLabel = new JLabel("Admin Dashboard");
		sl_contentPane.putConstraint(SpringLayout.NORTH, lblNewLabel, 10, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, lblNewLabel, 10, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.EAST, lblNewLabel, -5, SpringLayout.EAST, contentPane);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 38));
		lblNewLabel.setForeground(new Color(255, 128, 0));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Contract Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					goToAddContractDetailsPage(e);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}


		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnNewButton);
		
		JButton btnViewTenantDetails = new JButton("View Tenant Details");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnViewTenantDetails, 97, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnNewButton, 0, SpringLayout.WEST, btnViewTenantDetails);
		btnViewTenantDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToTenantViewPage(e);
			}

		});
		btnViewTenantDetails.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnViewTenantDetails);
		
		JButton btnManageTenantDetails = new JButton("Manage Tenant Details");
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnNewButton, -15, SpringLayout.NORTH, btnManageTenantDetails);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnManageTenantDetails, 187, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnManageTenantDetails, 97, SpringLayout.WEST, contentPane);
		btnManageTenantDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToManageTenantPage(e);
			}
		});
		btnManageTenantDetails.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnManageTenantDetails);
		
		JButton btnScheduleMonthlyMaintenance = new JButton("Schedule Monthly Maintenance");
		sl_contentPane.putConstraint(SpringLayout.WEST, btnScheduleMonthlyMaintenance, 97, SpringLayout.WEST, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnViewTenantDetails, 73, SpringLayout.SOUTH, btnScheduleMonthlyMaintenance);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnScheduleMonthlyMaintenance, 253, SpringLayout.NORTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnScheduleMonthlyMaintenance, -328, SpringLayout.SOUTH, contentPane);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnViewTenantDetails, 28, SpringLayout.SOUTH, btnScheduleMonthlyMaintenance);
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnManageTenantDetails, -18, SpringLayout.NORTH, btnScheduleMonthlyMaintenance);
		btnScheduleMonthlyMaintenance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToScheduleMaintenancePage(e);
			}
		});
		btnScheduleMonthlyMaintenance.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnScheduleMonthlyMaintenance);
		
		JButton btnManagePayments = new JButton("Manage Payments");
		btnManagePayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToManagePaymentPage(e);
			}

	
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnManagePayments, 26, SpringLayout.SOUTH, btnViewTenantDetails);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnManagePayments, 97, SpringLayout.WEST, contentPane);
		btnManagePayments.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnManagePayments);
		
		JButton btnRenewContractsmanagePayments = new JButton("Renew ContractsManage Payments");
		btnRenewContractsmanagePayments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToRenewPaymentsPage(e);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnRenewContractsmanagePayments, 64, SpringLayout.SOUTH, lblNewLabel);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnNewButton, 0, SpringLayout.NORTH, btnRenewContractsmanagePayments);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnNewButton, -28, SpringLayout.WEST, btnRenewContractsmanagePayments);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnRenewContractsmanagePayments, -23, SpringLayout.EAST, contentPane);
		btnRenewContractsmanagePayments.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnRenewContractsmanagePayments);
		
		JButton btnTerminateContract = new JButton("Terminate Contract");
		btnTerminateContract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToTerminateContractPage(e);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.SOUTH, btnRenewContractsmanagePayments, -19, SpringLayout.NORTH, btnTerminateContract);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnManageTenantDetails, -33, SpringLayout.WEST, btnTerminateContract);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnTerminateContract, 0, SpringLayout.EAST, btnRenewContractsmanagePayments);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTerminateContract, 4, SpringLayout.NORTH, btnManageTenantDetails);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTerminateContract, 0, SpringLayout.WEST, btnRenewContractsmanagePayments);
		btnTerminateContract.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnTerminateContract);
		
		JButton btnTerminateContract_1 = new JButton("View Repair Bill");
		btnTerminateContract_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToViewRepairBillPage(e);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.EAST, btnScheduleMonthlyMaintenance, -28, SpringLayout.WEST, btnTerminateContract_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTerminateContract_1, 6, SpringLayout.NORTH, btnScheduleMonthlyMaintenance);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTerminateContract_1, 0, SpringLayout.WEST, btnRenewContractsmanagePayments);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnTerminateContract_1, 0, SpringLayout.EAST, btnRenewContractsmanagePayments);
		btnTerminateContract_1.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnTerminateContract_1);
		
		JButton btnTerminateContract_1_1 = new JButton("Search Available Room");
		btnTerminateContract_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToSearchAvailableRoom(e);
			}
			
		});
		sl_contentPane.putConstraint(SpringLayout.EAST, btnViewTenantDetails, -28, SpringLayout.WEST, btnTerminateContract_1_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTerminateContract_1_1, 2, SpringLayout.NORTH, btnViewTenantDetails);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTerminateContract_1_1, 0, SpringLayout.WEST, btnRenewContractsmanagePayments);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnTerminateContract_1_1, 0, SpringLayout.EAST, btnRenewContractsmanagePayments);
		btnTerminateContract_1_1.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnTerminateContract_1_1);
		
		JButton btnTerminateContract_1_1_1 = new JButton("View Maintenance History");
		btnTerminateContract_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goToHistoryPage(e);
			}
		});
		sl_contentPane.putConstraint(SpringLayout.EAST, btnManagePayments, -28, SpringLayout.WEST, btnTerminateContract_1_1_1);
		sl_contentPane.putConstraint(SpringLayout.NORTH, btnTerminateContract_1_1_1, 0, SpringLayout.NORTH, btnManagePayments);
		sl_contentPane.putConstraint(SpringLayout.WEST, btnTerminateContract_1_1_1, 0, SpringLayout.WEST, btnRenewContractsmanagePayments);
		sl_contentPane.putConstraint(SpringLayout.EAST, btnTerminateContract_1_1_1, 0, SpringLayout.EAST, btnRenewContractsmanagePayments);
		btnTerminateContract_1_1_1.setFont(new Font("Arial", Font.PLAIN, 28));
		contentPane.add(btnTerminateContract_1_1_1);
	}
	

	protected void goToHistoryPage(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		MaintenanceHistory page = new MaintenanceHistory();
		page.setVisible(true);
	}

	protected void goToSearchAvailableRoom(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		SearchAvailableRoom page = new SearchAvailableRoom();
		page.setVisible(true);
	}

	protected void goToViewRepairBillPage(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		ViewRepairBill page = new ViewRepairBill();
		page.setVisible(true);
	}

	protected void goToTerminateContractPage(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		TerminateContract page = new TerminateContract();
		page.setVisible(true);
	}

	protected void goToRenewPaymentsPage(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		RenewPayments page = new RenewPayments();
		page.setVisible(true);
	}

	//create functions
	protected void goToManagePaymentPage(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		ManagePayments page = new ManagePayments();
			page.setVisible(true);
		}
		private void goToAddContractDetailsPage(ActionEvent e) throws SQLException {
			// TODO Auto-generated method stub
			this.dispose();
			AddContractDetails page = new AddContractDetails();
			page.setVisible(true);
			
		}
		private void goToTenantViewPage(ActionEvent e) {
			// TODO Auto-generated method stub
			this.dispose();
			TenantViewPage page  = new TenantViewPage();
			page.setVisible(true);
		}
		protected void goToManageTenantPage(ActionEvent e) {
			// TODO Auto-generated method stub
			this.dispose();
			ManageTenantDetails page  = new ManageTenantDetails();
			page.setVisible(true);
		}
	protected void goToScheduleMaintenancePage(ActionEvent e) {
		// TODO Auto-generated method stub
		this.dispose();
		ScheduleMaintenance page  = new ScheduleMaintenance();
		page.setVisible(true);
	}
	
}
