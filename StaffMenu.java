package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

public class StaffMenu extends JFrame {

	private JPanel contentPane;
	private String option[] = {"Select One", "Certificate", "Associate", "Diploma"};
	public static String program;;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StaffMenu frame = new StaffMenu();
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
	public StaffMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel sideMenu = new JPanel();
		sideMenu.setBackground(new Color(32, 178, 170));
		sideMenu.setBounds(156, 0, 500, 358);
		contentPane.add(sideMenu);
		sideMenu.setLayout(null);
		
		JLabel lblWelcomeNewAnd = new JLabel("Welcome New and Returning members of Staff!");
		lblWelcomeNewAnd.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblWelcomeNewAnd.setBounds(95, 47, 306, 16);
		sideMenu.add(lblWelcomeNewAnd);
		
		JComboBox programme = new JComboBox(option);
		/*
		programme.addItem("Certificate");
		programme.addItem("Associate");
		programme.addItem("Diploma");
		programme.setSelectedItem(null);
		
		*/
		
		
		
		JButton btnSetTest = new JButton("Set Test");
		btnSetTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 program = (String)programme.getSelectedItem(); //Cast Selected item to a string variable
		
				if (program.equals("Certificate"))
				{
					System.out.println(program);
					
					SetTest test = new SetTest();
					test.getCode(StaffMenu.program);
					test.setVisible(true);
					
				}
				
				else if  (program.equals("Diploma"))
				{
					SetTest test = new SetTest();
					test.getCode(StaffMenu.program);
					test.setVisible(true);
					
				}
				else if (program.equals("Associate"))
				{
					SetTest test = new SetTest();
					test.getCode(StaffMenu.program);
					test.setVisible(true);
					
					
				}
				
				else if  (program.equals("Select One"))
				{
					JOptionPane.showMessageDialog(null, "Select Programme to Set Test!");
				}
				
				
				
			}
		});
		btnSetTest.setBounds(194, 172, 117, 29);
		sideMenu.add(btnSetTest);
		
		JButton btnViewTestResult = new JButton("View Test Result");
		btnViewTestResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StaffReport result = new StaffReport();
				result.setVisible(true);
			}
		});
		btnViewTestResult.setBounds(184, 227, 142, 29);
		sideMenu.add(btnViewTestResult);
		
		JLabel lblSelectProgrammeFrom = new JLabel("Select Programme from the drop down menu to set test.");
		lblSelectProgrammeFrom.setFont(new Font("Hoefler Text", Font.PLAIN, 16));
		lblSelectProgrammeFrom.setBounds(33, 105, 396, 16);
		sideMenu.add(lblSelectProgrammeFrom);
		
		
			
		programme.setBounds(161, 133, 186, 27);
		sideMenu.add(programme);
		
		JPanel staffMenu = new JPanel();
		staffMenu.setBackground(new Color(32, 178, 170));
		staffMenu.setLayout(null);
		staffMenu.setBounds(0, 0, 153, 358);
		contentPane.add(staffMenu);
		
		JButton logOut = new JButton("Log Out");
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenu menu = new MainMenu();
				menu.setVisible(true);
			}
		});
		logOut.setBounds(6, 173, 127, 29);
		staffMenu.add(logOut);
		
		JButton button_1 = new JButton("Switch User");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				staffLogin login = new staffLogin();
				login.setVisible(true);
			}
		});
		button_1.setBounds(2, 221, 131, 29);
		staffMenu.add(button_1);
		
		JButton exitSys = new JButton("Exit System");
		exitSys.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitSys.setBounds(6, 273, 127, 29);
		staffMenu.add(exitSys);
	}
}
