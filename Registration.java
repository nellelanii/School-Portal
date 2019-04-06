package graphics;
/*This is Student Registration Tab */

// Error unable to print the program from line 175 to file

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.TrayIcon.MessageType;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;


import hai.Records;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JDateChooserBeanInfo;
import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import com.toedter.calendar.JMonthChooser;
import java.awt.Font; //Import Parent Class

public class Registration extends JFrame {

	private JPanel contentPane;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtIdnum;
	private JTextField textField;
	private JPasswordField pwdPassword;
	private JPasswordField pwdConfirmpass;
//	private String enrol[]= { "Cerificate", "Diploma", "Associate"};
	private final JCalendar calendar = new JCalendar();
	private JTextField txtEnroldate;
	private JTextField txtAddress;
	private JComboBox programme;
	private JTextField textContact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1, 1);
		contentPane.add(layeredPane);
		
		JPanel StudentRegister = new JPanel();
		StudentRegister.setBackground(new Color(32, 178, 170));
		StudentRegister.setBounds(147, 0, 680, 358);
		contentPane.add(StudentRegister);
		StudentRegister.setLayout(null);
		
		JLabel lblRegistration = new JLabel("Student Registration");
		lblRegistration.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblRegistration.setBounds(188, 46, 139, 16);
		StudentRegister.add(lblRegistration);
		
		JLabel lblFirstname = new JLabel("First Name");
		lblFirstname.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblFirstname.setBounds(6, 107, 100, 16);
		StudentRegister.add(lblFirstname);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblLastName.setBounds(6, 145, 76, 16);
		StudentRegister.add(lblLastName);
		
		JLabel lblIdNumber = new JLabel("ID Number");
		lblIdNumber.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblIdNumber.setBounds(6, 187, 76, 16);
		StudentRegister.add(lblIdNumber);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblAddress.setBounds(6, 230, 76, 16);
		StudentRegister.add(lblAddress);
		
		JLabel lblContactNumber = new JLabel("Contact Number");
		lblContactNumber.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblContactNumber.setBounds(245, 144, 118, 16);
		StudentRegister.add(lblContactNumber);
		
		txtFname = new JTextField();
		txtFname.setBounds(91, 102, 130, 26);
		StudentRegister.add(txtFname);
		txtFname.setColumns(10);
		
		txtLname = new JTextField();
		txtLname.setBounds(88, 139, 133, 26);
		StudentRegister.add(txtLname);
		txtLname.setColumns(10);
		
		txtIdnum = new JTextField();
		txtIdnum.setBounds(92, 181, 129, 26);
		StudentRegister.add(txtIdnum);
		txtIdnum.setColumns(10);
		
		textContact= new JTextField();		
		textContact.setBounds(362, 141, 139, 21);
		StudentRegister.add(textContact);
		textContact.setColumns(10);
		
		JLabel lblNewPassword = new JLabel("New Password");
		lblNewPassword.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblNewPassword.setBounds(263, 186, 100, 16);
		StudentRegister.add(lblNewPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBounds(362, 181, 139, 26);
		StudentRegister.add(pwdPassword);
		
		JLabel lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblConfirmPassword.setBounds(245, 230, 118, 16);
		StudentRegister.add(lblConfirmPassword);
		
		pwdConfirmpass = new JPasswordField();
		pwdConfirmpass.setBounds(362, 225, 139, 26);
		StudentRegister.add(pwdConfirmpass);
		JLabel lblProgramme = new JLabel("Programme");
		lblProgramme.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblProgramme.setBounds(275, 106, 76, 16);
		StudentRegister.add(lblProgramme);
		calendar.setBounds(455, 57, 46, 29);
	
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBackground(new Color(32, 178, 170));
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateChooser.getCalendarButton().setBounds(111, 0, 28, 26);
		dateChooser.setBounds(-12, 298, 137, 26);
		StudentRegister.add(dateChooser);
		dateChooser.setLayout(null);
		dateChooser.setDateFormatString("dd/MM/yyyy");
	
		
		txtEnroldate = new JTextField();	
		txtEnroldate.setText("DD/MM/YYYY");
		txtEnroldate.setBounds(100, 268, 121, 26);
		StudentRegister.add(txtEnroldate);
		txtEnroldate.setColumns(10);
		
		JButton btnAddDate = new JButton("Get Date");
		btnAddDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Date pickdate = new dateChooser.getDate();
				DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
				txtEnroldate.setText(date.format(dateChooser.getDate()));
			}
		});
		btnAddDate.setBounds(122, 298, 117, 29);
		StudentRegister.add(btnAddDate);
		
		JLabel lblDateEnrolled = new JLabel("Date Enrolled");
		lblDateEnrolled.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblDateEnrolled.setBounds(6, 273, 100, 16);
		StudentRegister.add(lblDateEnrolled);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(94, 224, 130, 22);
		StudentRegister.add(txtAddress);
		txtAddress.setColumns(10);
		
		
		
		JComboBox programme = new JComboBox();
		programme.setBounds(353, 102, 148, 27);
		StudentRegister.add(programme);
		
		programme.addItem("Certificate");
		programme.addItem("Diploma");
		programme.addItem("Associate");
		programme.setSelectedItem(null);
		
		
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				txtFname.setText("  ");
				txtLname.setText(" ");
				txtIdnum.setText("  ");
				txtEnroldate.setText("DD/MM/YYYY");
				txtAddress.setText("  ");
				textContact.setText("  ");;
				pwdPassword.setText(null);
				pwdConfirmpass.setText(null);
				programme.setSelectedItem(null);
				
			}
		});
		btnReset.setBounds(382, 309, 117, 29);
		StudentRegister.add(btnReset);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String studentFN = txtFname.getText().toString(); //This will capture data from user input to store on File
				String studentLN = txtLname.getText().toString();
				String idNum = txtIdnum.getText().toString();
				String dateEnrolled = txtEnroldate.getText().toString();
				String address = txtAddress.getText().toString();
				String contact = textContact.getText().toString();
				String program = (String)programme.getSelectedItem(); 
				String password = pwdPassword.getText().toString();
				String confirmPassword = pwdConfirmpass.getText().toString();
				
			
				
				if (txtFname.getText().isEmpty()|| txtLname.getText().isEmpty() || txtIdnum.getText().isEmpty() || txtEnroldate.getText().equals("DD/MM/YYYY") || txtAddress.getText().isEmpty() || textContact.getText().isEmpty() || programme.getSelectedItem().equals(null) || pwdPassword.getText().isEmpty())
					
				{
					JOptionPane.showMessageDialog(null, "Required Field is empty!! All Fields are required. Please try again");
					
				}
				
				
				if (password.equals(confirmPassword) )
				{
					
			
				
				try
				{
					for (int i = 0; i < 1; i++) {
					
	
					
				FileWriter writer = new FileWriter("studentinfo.txt", true);
					
					writer.write(studentFN+"\t");
					writer.write(studentLN+"\t");
					writer.write(idNum+"\t");
					writer.write(dateEnrolled+"\t");
					writer.write(address+"\t");
					writer.write(contact+"\t");
					writer.write(password+"\t");
					writer.write(program+"\t");
					
					
					writer.write(System.getProperty("line.separator"));
					writer.close();
				
					}
					
					Login login = new Login();
					login.setVisible(true);
				}
					
					catch(Exception d)
					{
						
						JOptionPane.showMessageDialog(rootPane, "Error registering student");
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
		btnLogin.setBounds(372, 268, 117, 29);
		StudentRegister.add(btnLogin);

		
		
		
		
		JButton mainMenu = new JButton("Main Menu");
		mainMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenu menu = new MainMenu();
			menu.setVisible(true);
						
			}
		});
		
		JPanel sideMenu = new JPanel();
		sideMenu.setBackground(new Color(32, 178, 170));
		sideMenu.setLayout(null);
		sideMenu.setBounds(0, 0, 148, 358);
		contentPane.add(sideMenu);
		mainMenu.setBounds(2, 159, 117, 29);
		sideMenu.add(mainMenu);
		
		JButton Login = new JButton("Student Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login studentLogin = new Login ();
				studentLogin.setVisible(true);
		
			}
		});
		Login.setBounds(2, 201, 117, 29);
		sideMenu.add(Login);
		
		JButton ExitSystem = new JButton("Exit System");
		ExitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		ExitSystem.setBounds(2, 237, 117, 29);
		sideMenu.add(ExitSystem);
	}
}
