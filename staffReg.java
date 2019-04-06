package graphics;

//This is the Staff Registration GUI

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import com.toedter.calendar.JDateChooser;
import java.awt.Font;

public class staffReg extends JFrame {

	private JPanel contentPane;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtIdnumber;
	private JTextField txtFaculty;
	private JTextField txtDepartment;
	private JPasswordField pwdPassword;
	private JPasswordField pwdConfirmpass;
	private JTextField txtDateemploy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					staffReg frame = new staffReg();
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
	public staffReg() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);;
		
		JPanel StaffRegistration = new JPanel();
		StaffRegistration.setBackground(new Color(32, 178, 170));
		StaffRegistration.setBounds(184, 0, 478, 358);
		contentPane.add(StaffRegistration);
		StaffRegistration.setLayout(null);
		
		JLabel lblStaffRegistration = new JLabel("Staff Registration");
		lblStaffRegistration.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblStaffRegistration.setBounds(165, 37, 124, 25);
		StaffRegistration.add(lblStaffRegistration);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblFirstName.setBounds(20, 91, 88, 16);
		StaffRegistration.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblLastName.setBounds(20, 127, 71, 16);
		StaffRegistration.add(lblLastName);
		
		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblIdNumber.setBounds(20, 167, 88, 16);
		StaffRegistration.add(lblIdNumber);
		
		JLabel Faculty = new JLabel("Faculty");
		Faculty.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		Faculty.setBounds(20, 206, 76, 16);
		StaffRegistration.add(Faculty);
		
		JLabel lblDepartment = new JLabel("Department");
		lblDepartment.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblDepartment.setBounds(20, 246, 88, 16);
		StaffRegistration.add(lblDepartment);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblPassword.setBounds(298, 104, 61, 16);
		StaffRegistration.add(lblPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblConfirmPassword.setBounds(296, 181, 139, 16);
		StaffRegistration.add(lblConfirmPassword);
		
		txtFname = new JTextField();
		txtFname.setBounds(104, 86, 130, 26);
		StaffRegistration.add(txtFname);
		txtFname.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setBounds(103, 119, 130, 26);
		StaffRegistration.add(txtLname);
		txtLname.setColumns(10);
		
		txtIdnumber = new JTextField();
		txtIdnumber.setBounds(104, 162, 130, 26);
		StaffRegistration.add(txtIdnumber);
		txtIdnumber.setColumns(10);
		
		txtFaculty = new JTextField();
		txtFaculty.setBounds(104, 201, 139, 26);
		StaffRegistration.add(txtFaculty);
		txtFaculty.setColumns(10);
		
		txtDepartment = new JTextField();
		txtDepartment.setBounds(104, 241, 139, 26);
		StaffRegistration.add(txtDepartment);
		txtDepartment.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(296, 122, 148, 26);
		StaffRegistration.add(pwdPassword);
		
		pwdConfirmpass = new JPasswordField();
		pwdConfirmpass.setBounds(296, 201, 139, 26);
		StaffRegistration.add(pwdConfirmpass);
		
		JLabel lblDateEmployed = new JLabel("Date Employed");
		lblDateEmployed.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblDateEmployed.setBounds(6, 284, 102, 16);
		StaffRegistration.add(lblDateEmployed);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(32, 178, 170));
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.getCalendarButton().setBounds(85, 0, 28, 26);
		dateChooser.setBounds(38, 305, 119, 26);
		StaffRegistration.add(dateChooser);
		dateChooser.setLayout(null);
		
		JButton btnGetDate = new JButton("Get Date");
		btnGetDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				DateFormat date = new SimpleDateFormat("dd/MM/yyyy"); //Generates Date
				txtDateemploy.setText(date.format(dateChooser.getDate())); //Sets Date in textfield after it has been selected
			}
		});
		btnGetDate.setBounds(153, 305, 117, 29);
		StaffRegistration.add(btnGetDate);
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFname.setText("  ");
				txtLname.setText("  ");
				txtIdnumber.setText("   ");
				txtFaculty.setText("  ");
				txtDepartment.setText("   ");
				pwdPassword.setText(null);
				pwdConfirmpass.setText(null);
				txtDateemploy.setText("DD/MM/YYYY");
				
			}
		});
		btnReset.setBounds(327, 268, 117, 29);
		StaffRegistration.add(btnReset);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String fName = txtFname.getText().toString(); //Gets user input and store to string variable
				String lName = txtLname.getText().toString();
				String staffID = txtIdnumber.getText().toString();
				String faculty = txtFaculty.getText().toString();
				String department = txtDepartment.getText().toString();
				String staffPass = pwdPassword.getText().toString();
				String confrimPass= pwdConfirmpass.getText().toString();
				String dateEmployed = txtDateemploy.getText().toString();
			
				if (txtFname.getText().isEmpty() || txtLname.getText().isEmpty() || txtIdnumber.getText().isEmpty() || txtFaculty.getText().isEmpty() || txtDepartment.getText().isEmpty() || pwdPassword.getText().isEmpty()|| txtDateemploy.getText().equals("DD/MM/YYYY"))
				{
					JOptionPane.showMessageDialog(null, "Required Field is empty!! All Fields are required");
					

					
				}
				
				else if (staffPass.equals(confrimPass))
			{		
				try
				{
					for (int i = 0; i < 1; i++) {
					FileWriter writer = new FileWriter("staffinfo.txt", true); //opens file for writing mode
					
					writer.write(fName+"\t"); 
					writer.write(lName+"\t");
					writer.write(staffID+"\t");
					writer.write(faculty+"\t");
					writer.write(department+"\t");
					writer.write(staffPass+"\t");
					writer.write(dateEmployed+"\t");
					writer.write(System.getProperty("line.separator"));
					writer.close();
					
				}
					staffLogin login = new staffLogin(); //creates an object of Staff Login
					login.setVisible(true);   //By the click of the Login button, this will call Staff Login window
					 
				}
				
					catch (Exception d)
					{
						JOptionPane.showMessageDialog(rootPane, "Error registering staff");
						
					}
			}
					
				else 
				{
					JOptionPane.showMessageDialog(null, "Passwords Do Not Match! Try again");
					pwdPassword.setText(null);
					pwdConfirmpass.setText(null);
				}
				
				
				
			}
			
		});
		btnLogin.setBounds(327, 305, 117, 29);
		StaffRegistration.add(btnLogin);
		
		txtDateemploy = new JTextField();
		txtDateemploy.setBounds(104, 278, 139, 26);
		StaffRegistration.add(txtDateemploy);
		txtDateemploy.setColumns(10);
		txtDateemploy.setText("DD/MM/YYYY");
		
		
		JPanel sideMenu = new JPanel();
		sideMenu.setBackground(new Color(32, 178, 170));
		sideMenu.setBounds(0, 0, 188, 358);
		contentPane.add(sideMenu);
		sideMenu.setLayout(null);
		
		JButton mainMenu = new JButton("Main Menu");
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MainMenu menu = new MainMenu (); //Brings MainMenu
				menu.setVisible(true);
			}
		});
		mainMenu.setBounds(29, 160, 117, 29);
		sideMenu.add(mainMenu);
		
		JButton staffLogin = new JButton("Staff Login");
		staffLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				staffLogin login = new staffLogin();
				login.setVisible(true);
			}
		});
		staffLogin.setBounds(29, 196, 117, 29);
		sideMenu.add(staffLogin);
		
		JButton exit = new JButton("Exit System");
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		exit.setBounds(29, 237, 117, 29);
		sideMenu.add(exit);
	}
}
