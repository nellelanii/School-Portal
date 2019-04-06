package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;

public class staffLogin extends JFrame {

	private JPanel contentPane;
	public static JTextField txtIdnumber;
	private JPasswordField pwdPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffLogin frame = new staffLogin();
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
	public staffLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel staffLogin = new JPanel();
		staffLogin.setBackground(new Color(32, 178, 170));
		staffLogin.setBounds(189, 0, 473, 358);
		contentPane.add(staffLogin);
		staffLogin.setLayout(null);
		
		JLabel lblStaffLogin = new JLabel("Staff Login");
		lblStaffLogin.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblStaffLogin.setBounds(197, 89, 93, 16);
		staffLogin.add(lblStaffLogin);
		
		JLabel lblIdentificationNumber = new JLabel("Identification Number");
		lblIdentificationNumber.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblIdentificationNumber.setBounds(53, 135, 167, 16);
		staffLogin.add(lblIdentificationNumber);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblPassword.setBounds(115, 189, 105, 16);
		staffLogin.add(lblPassword);
		
		txtIdnumber = new JTextField();
		txtIdnumber.setBounds(232, 130, 130, 26);
		staffLogin.add(txtIdnumber);
		txtIdnumber.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(226, 184, 136, 26);
		staffLogin.add(pwdPassword);
		
		JCheckBox chckbxShowPassword = new JCheckBox("Show Password");
		chckbxShowPassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (chckbxShowPassword.isSelected()) //This if statement allows the user to see the password if selected
				{
					pwdPassword.setEchoChar((char)0);
				}
				else
				{
					pwdPassword.setEchoChar('*');
				}
				
			}
		});
		chckbxShowPassword.setBounds(220, 222, 128, 23);
		staffLogin.add(chckbxShowPassword);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String staffPass = pwdPassword.getText().toString();
				String staffID = txtIdnumber.getText().toString().toLowerCase();
				
				if(staffPass.length() == 0 || staffID.length() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Please ensure you enter a password and a Id number.");
					
				}else {

					File file = new File("staffinfo.txt");
					
					Scanner sc = null;
					boolean isSuccess = false;  //If login is successful
					try {
						sc = new Scanner(file);
						
						while(sc.hasNextLine()){
				            String record[] = sc.nextLine().split("\t"); // split the record into array using tab as the deliminer 
				            if (staffPass.equals(record[5]) && staffID.equals(record[2].toLowerCase()) ) // password is stored at index 6 and username at index 0
								{
				            	    isSuccess = true;
									StaffMenu menu = new StaffMenu();
									menu.setVisible(true);
									
								}
				            record = null; 
				        }
						sc.close();	
						
						if(isSuccess == false) {
							JOptionPane.showMessageDialog(rootPane, "Invalid Login Credentials"); //Error Message if Login info is incorrect
							pwdPassword.setText(null);
							
						}
				
					}
					catch (Exception d) {
						JOptionPane.showMessageDialog(rootPane, "Error reading from file");
						d.printStackTrace();
					}
				}
				
			}
				
			
		});
		btnLogin.setBounds(322, 284, 117, 29);
		staffLogin.add(btnLogin);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtIdnumber.setText("  ");
				pwdPassword.setText(null);
			}
		});
		btnReset.setBounds(193, 284, 117, 29);
		staffLogin.add(btnReset);
		
	
		JPanel sideMenu = new JPanel();
		sideMenu.setBackground(new Color(32, 178, 170));
		sideMenu.setBounds(0, 0, 193, 358);
		contentPane.add(sideMenu);
		sideMenu.setLayout(null);
		
		JButton Mainmenu = new JButton("Main Menu");
		Mainmenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				MainMenu menu = new MainMenu();
				menu.setVisible(true);
			}
		});
		Mainmenu.setBounds(29, 185, 117, 29);
		sideMenu.add(Mainmenu);
		
		JButton Staffreg = new JButton("Staff Registration");
		Staffreg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				staffReg reg = new staffReg ();
				reg.setVisible(true);
				
			}
		});
		Staffreg.setBounds(6, 226, 172, 29);
		sideMenu.add(Staffreg);
		
		JButton exit = new JButton("Exit System");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		exit.setBounds(29, 270, 117, 29);
		sideMenu.add(exit);
	}
}
