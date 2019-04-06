package graphics;

/*This is Student Login Tab */
import hai.Test;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Font;

public class Login extends JFrame {

	private JPanel contentPane;
	private JPanel loginPanel;
	private JLabel lblLogin;
	private JPanel sideMenu;
	private JButton mainMenu;
	private JButton Studentreg;
	private JButton exitSystem;
	private JLabel lblIdNumber;
	private JPasswordField passwordField;
	public static JTextField textFieldidnum;
	public static String idnumber;
	private String[] studentRecord;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public String[] getStudentRecord() {
		return studentRecord;
	}
	public void setStudentRecord(String studentRecord[]) {
		this.studentRecord = studentRecord;
	}
 
	/**
	 * Create the frame.
	 */
	public Login() {
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		loginPanel = new JPanel();
		loginPanel.setBackground(new Color(32, 178, 170));
		loginPanel.setBounds(251, 0, 411, 358);
		contentPane.add(loginPanel);
		loginPanel.setLayout(null);
		
		lblLogin = new JLabel("Student Login");
		lblLogin.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblLogin.setBounds(175, 79, 112, 16);
		loginPanel.add(lblLogin);
		
		lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblIdNumber.setBounds(109, 124, 79, 16);
		loginPanel.add(lblIdNumber);
		
		JLabel lblNewPassword = new JLabel("Password");
		lblNewPassword.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblNewPassword.setBounds(109, 166, 79, 16);
		loginPanel.add(lblNewPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(200, 161, 154, 26);
		loginPanel.add(passwordField);
		
		textFieldidnum = (new JTextField());
		textFieldidnum.setBounds(200, 119, 154, 26);
		loginPanel.add(textFieldidnum);
		textFieldidnum.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String password = passwordField.getText().toString();
				String idNum = textFieldidnum.getText().toString().toLowerCase();
				
				if(password.length() == 0 || idNum.length() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Please ensure you enter a password and a Id number.");
					
				}else {

					File file = new File("studentinfo.txt");
					
					Scanner sc = null;
					boolean isSuccess = false;  //If login is successful
					try {
						sc = new Scanner(file);
						
						while(sc.hasNextLine()){
				            String record[] = sc.nextLine().split("\t"); // split the record into array using tab as the deliminer 
				            if (password.equals(record[6]) && idNum.equals(record[2].toLowerCase()) ) // password is stored at index 6 and username at index 0
								{
				            	    setStudentRecord(record);
				            	    isSuccess = true;
									StudentMenu menu = new StudentMenu();	
									idnumber = record[2];							
									menu.setVisible(true);
									
								}
				            record = null; 
				        }
						sc.close();	
						
						if(isSuccess == false) {
							JOptionPane.showMessageDialog(rootPane, "Invalid Login Credentials"); //Error Message if Login info is incorrect
							passwordField.setText(null);
						}
				
					}
					catch (Exception d) {
						d.printStackTrace();
					}
				}
				
			}
				
		});
		btnLogin.setBounds(157, 270, 117, 29);
		loginPanel.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldidnum.setText("   ");
				passwordField.setText(null);
			}
		});
		btnReset.setBounds(273, 270, 117, 29);
		loginPanel.add(btnReset);
		
		JCheckBox chckbxShowpass = new JCheckBox("Show Password");
		chckbxShowpass.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		chckbxShowpass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 
				if (chckbxShowpass.isSelected()) //This if statement allows the user to see the password if selected
				{
					passwordField.setEchoChar((char)0);
				}
				else
				{
					passwordField.setEchoChar('*');
				}
				
			}
		});
		chckbxShowpass.setBounds(200, 199, 138, 23);
		loginPanel.add(chckbxShowpass);
		
		sideMenu = new JPanel();
		sideMenu.setBackground(new Color(32, 178, 170));
		sideMenu.setLayout(null);
		sideMenu.setBounds(0, 0, 272, 369);
		contentPane.add(sideMenu);
		
		mainMenu = new JButton("Main Menu");
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenu menu = new MainMenu();
				menu.setVisible(true);
			
			}
		});
		mainMenu.setBounds(68, 201, 117, 29);
		sideMenu.add(mainMenu);
		
		Studentreg = new JButton("Student Registration");
		Studentreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			Registration reg = new Registration ();
			reg.setVisible(true);
			
			}
		});
		Studentreg.setBounds(50, 242, 152, 29);
		sideMenu.add(Studentreg);
		
		exitSystem = new JButton("Exit System");
		exitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		exitSystem.setBounds(60, 283, 134, 29);
		sideMenu.add(exitSystem);
		exitSystem.setMnemonic(KeyEvent.VK_F1);
		
		Image img = new ImageIcon(this.getClass().getResource("/gradhat.png")).getImage();
		
	}
//edit the test file and write A B C with the solutions. So the user can only enter A B or C
	
}
