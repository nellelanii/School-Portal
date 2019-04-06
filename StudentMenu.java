package graphics;

import hai.ProgrammeRecord;
import hai.Test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.beans.PropertyChangeEvent;
import javax.swing.JComboBox;
import javax.swing.JList;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;

public class StudentMenu extends JFrame {

	//private final JCalendar calendar = new JCalendar();
	private JPanel contentPane;
	private JTextField studentId;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentMenu frame = new StudentMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*public StudentMenu(String idnum) {
		
		
		
		// TODO Auto-generated constructor stub
	}

	/**
	 * Create the frame.
	 */
	public StudentMenu() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel studentMenu = new JPanel();
		studentMenu.setBackground(new Color(32, 178, 170));
		studentMenu.setBounds(156, 0, 506, 358);
		contentPane.add(studentMenu);
		studentMenu.setLayout(null);
		
		JLabel lblWelcomeNewAnd = new JLabel("Welcome New and Returning Students!");
		lblWelcomeNewAnd.setBounds(130, 44, 254, 16);
		studentMenu.add(lblWelcomeNewAnd);
		
		JPanel sideMenu = new JPanel();
		sideMenu.setBackground(new Color(32, 178, 170));
		sideMenu.setLayout(null);
		sideMenu.setBounds(0, 0, 159, 358);
		contentPane.add(sideMenu);
		
		JButton Mainmenu = new JButton("Main Menu");
		Mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				MainMenu menu = new MainMenu();
				menu.setVisible(true);
				
			}
		});
		Mainmenu.setBounds(2, 159, 145, 29);
		sideMenu.add(Mainmenu);
		
		JButton switchUser = new JButton("Switch User");
		switchUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login login = new Login();
				login.setVisible(true);
			}
		});
		switchUser.setBounds(2, 201, 145, 29);
		sideMenu.add(switchUser);
		
		JButton btnExitSystem = new JButton("Exit System");
		btnExitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExitSystem.setBounds(12, 253, 135, 29);
		sideMenu.add(btnExitSystem);
		
		JLabel lblLoginid = new JLabel("Welcome!");
		lblLoginid.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				//lblLoginid.setText(Login.textFieldidnum.getText());
			}
		});
		lblLoginid.setBounds(40, 74, 68, 23);
		sideMenu.add(lblLoginid);
		
		JButton takeTest = new JButton("Take Test");
		takeTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				lblLoginid.setText(Login.textFieldidnum.getText());
	
				
				//ProgrammeRecord programmeRecord = new ProgrammeRecord();
			
				
				TestWindow takeTest = new TestWindow();
				takeTest.programGuide(Login.textFieldidnum.getText());
				takeTest.setVisible(true);
				
				
	
				
				
	
			}
		});
		takeTest.setBounds(177, 149, 117, 29);
		studentMenu.add(takeTest);
		
		JButton btnViewTestResult = new JButton("View Test Result");
		btnViewTestResult.addActionListener(new ActionListener() {
			
		public void actionPerformed (ActionEvent e) {
			
			ViewResults studentResult = new ViewResults();
			studentResult.setVisible(true);
		
		}
		});
		btnViewTestResult.setBounds(166, 190, 147, 29);
		studentMenu.add(btnViewTestResult);
		
	/*	studentId = new JTextField();
		studentId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		studentId.setEditable(false);
		studentId.setEnabled(false);
		studentId.setBounds(186, 260, 130, 26);
		studentMenu.add(studentId);
		studentId.setColumns(10);
		studentId.setText("1695084");
  */
		
	
		//txtLoginid.setColumns(10);
		
		
	}
}
