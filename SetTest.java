package graphics;
import java.awt.Container;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.beans.PropertyChangeEvent;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class SetTest extends JFrame {

	private JPanel contentPane;
	private JTextField questionField;
	private JTextField ansField;
	private JButton btnResetFields;
	private JPanel panel;
	private JButton btnLogOut;
	private JButton btnExitSystem;
	private JButton btnDone;
	private JLabel lblQuestion;
	private JLabel lblSelections;
	private JLabel lblAnswer;
	private JTextField selection;
	private JLabel lblCourseCode;
	private JComboBox certificateBox;
	private JComboBox diplomaBox;
	private JComboBox associateBox;
	
	public String certificate []= {"Select One", "ENG101", "MATH23", "GENKNO45", "INFOTECH86"};
	public String diploma [] = {"Select One", "ENG101", "MATH23", "GENKNO45", "INFOTECH86", "PROGMAN45", "POB44"};
	public String associate [] = {"Select One", "ENG101", "MATH23", "GENKNO45", "INFOTECT86", "PROGMAN45", "POB44", "POA47", "ECON33"};
	private JLabel lblSetTestDate;
	private JTextField txtTestdate;
	private JButton btnStaffMenu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetTest frame = new SetTest();
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
	public SetTest() {
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel setTest = new JPanel();
		setTest.setBackground(new Color(32, 178, 170));
		setTest.setBounds(0, 0, 662, 358);
		contentPane.add(setTest);
		setTest.setLayout(null);
		
		questionField = new JTextField();
		questionField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		questionField.setBounds(195, 125, 348, 29);
		setTest.add(questionField);
		questionField.setColumns(10);
		
		ansField = new JTextField();
		ansField.setBounds(195, 258, 348, 26);
		setTest.add(ansField);
		ansField.setColumns(10);
		
		
		
		btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				staffLogin login = new staffLogin();
				login.setVisible(true);
			}
		});
		btnLogOut.setBounds(17, 258, 117, 29);
		setTest.add(btnLogOut);
		
		btnExitSystem = new JButton("Exit System");
		btnExitSystem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
			}
		});
		btnExitSystem.setBounds(17, 299, 117, 29);
		setTest.add(btnExitSystem);
		
		certificateBox = new JComboBox(certificate);
		certificateBox.setBounds(248, 13, 158, 27);
		setTest.add(certificateBox);
		
		diplomaBox = new JComboBox(diploma);
		diplomaBox.setBounds(248, 39, 158, 27);
		setTest.add(diplomaBox);
		
		associateBox = new JComboBox(associate);
		associateBox.setBounds(248, 63, 158, 27);
		setTest.add(associateBox);
		
		
		certificateBox.setVisible(false);
    	diplomaBox.setVisible(false);
    	associateBox.setVisible(false);
    	

		JLabel lblCurrentlyLoggedIn = new JLabel("Currently logged in as:");
		lblCurrentlyLoggedIn.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblCurrentlyLoggedIn.setBounds(6, 44, 158, 16);
		setTest.add(lblCurrentlyLoggedIn);
		
		JLabel staffID = new JLabel("");
		staffID.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		staffID.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				staffID.setText(staffLogin.txtIdnumber.getText());
				
			}
		});
		staffID.setBounds(39, 67, 61, 16);
		setTest.add(staffID);
		selection = new JTextField();
		selection.setBounds(195, 200, 348, 26);
		setTest.add(selection);
		selection.setColumns(10);
		
		lblCourseCode = new JLabel("Course Code");
		lblCourseCode.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblCourseCode.setBounds(152, 18, 84, 16);
		setTest.add(lblCourseCode);
		
		lblSetTestDate = new JLabel("Set Test Date");
		lblSetTestDate.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblSetTestDate.setBounds(430, 44, 84, 16);
		setTest.add(lblSetTestDate);
		
		txtTestdate = new JTextField();
		txtTestdate.setBounds(526, 38, 130, 26);
		setTest.add(txtTestdate);
		txtTestdate.setColumns(10);
		txtTestdate.setText("DD/MM/YYYY");
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setBounds(6, 0, 28, 26);
		dateChooser_1.setBounds(511, 63, 32, 26);
		setTest.add(dateChooser_1);
		dateChooser_1.setLayout(null);
		
		JButton btnGetDate = new JButton("Get Date");
		btnGetDate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DateFormat date = new SimpleDateFormat("dd/MM/yyyy");
				txtTestdate.setText(date.format(dateChooser_1.getDate()));
			}
		});
		btnGetDate.setBounds(539, 62, 117, 29);
		setTest.add(btnGetDate);

		btnResetFields = new JButton("Reset Fields");
		btnResetFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				questionField.setText("  ");
				selection.setText("  ");
				ansField.setText("  ");
				
				certificateBox.setSelectedItem(null);
				diplomaBox.setSelectedItem(null);
				associateBox.setSelectedItem(null);
				
				txtTestdate.setText("DD/MM/YYYY");
			}
		});
		btnResetFields.setBounds(17, 209, 117, 29);
		setTest.add(btnResetFields);
    	
		btnDone = new JButton("Add Question");
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String newQuestion = questionField.getText().toString();
				String newSelect = 	selection.getText().toString();	
				String newAnswer = ansField.getText().toString();
				String certCode = (String) certificateBox.getSelectedItem();
				String dipCode = (String) diplomaBox.getSelectedItem();
				String asCode = (String) associateBox.getSelectedItem();
				String staffID = staffLogin.txtIdnumber.getText();
				String testDate = txtTestdate.getText().toString();
				
				
				if (questionField.getText().isEmpty() || txtTestdate.getText().equals("DD/MM/YYYY") || /*certificateBox.getSelectedItem().equals("Select One")|| diplomaBox.getSelectedItem().equals("Select One")|| associateBox.getSelectedItem().equals("Select One") ||*/ selection.getText().isEmpty() || ansField.getText().isEmpty())
				{
					JOptionPane.showMessageDialog(null, "Required Field is empty!! All Fields are required");
				}
				
				else 
				{
					for (int i = 0; i < 1; i++) {
						
						try {
							FileWriter writer = new FileWriter("questionbank.txt", true);
							
							
							writer.write(certCode+"\t\t");
							writer.write(dipCode+"\t\t");
							writer.write(asCode+"\t\t");
							writer.write(testDate+"\t\t");
							
							writer.write(staffID+"\t\t");
							writer.write(newQuestion+"\t\t");
							writer.write(newSelect+"\t\t");
							writer.write(newAnswer+"\t\t");
							
							
							writer.write(System.getProperty("line.separator"));
							writer.close();
							JOptionPane.showMessageDialog(null, "Question successfully added!");
							
							questionField.setText("  ");
							selection.setText("  ");
							ansField.setText("  ");
							
							certificateBox.setSelectedItem(null);
							diplomaBox.setSelectedItem(null);
							associateBox.setSelectedItem(null);
							
							txtTestdate.setText("DD/MM/YYYY");
							
						
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							JOptionPane.showMessageDialog(rootPane, "File not found");
							e1.printStackTrace();
						}
					}
				}
				
			}
		});
		btnDone.setBounds(512, 310, 117, 29);
		setTest.add(btnDone);
		
		lblQuestion = new JLabel("Question:");
		lblQuestion.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblQuestion.setBounds(152, 97, 61, 16);
		setTest.add(lblQuestion);
		
		lblSelections = new JLabel("Selections:");
		lblSelections.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblSelections.setBounds(152, 172, 84, 16);
		setTest.add(lblSelections);
		
		lblAnswer = new JLabel("Answer:");
		lblAnswer.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblAnswer.setBounds(152, 243, 84, 16);
		setTest.add(lblAnswer);
		
		btnStaffMenu = new JButton("Staff Menu");
		btnStaffMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				StaffMenu menu = new StaffMenu();
				menu.setVisible(true);
			}
		});
		btnStaffMenu.setBounds(17, 166, 117, 29);
		setTest.add(btnStaffMenu);
		
		JLabel lblSetTestQuestion = new JLabel("Set Test Question");
		lblSetTestQuestion.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblSetTestQuestion.setBounds(17, 17, 117, 16);
		setTest.add(lblSetTestQuestion);
		
		
		
		
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 152, 358);
		contentPane.add(panel);
	}	
		public void getCode(String program)
		{
//			 if (textFieldidnum.equals(record[2]))
//	            {
//	            	System.out.println(textFieldidnum+" "+record[7]);
//	            	
	            	if(program.equals("Diploma")) {
	            		
	            		diplomaBox.setVisible(true);
		            	
	            		
	            	}else if(program.equals("Certificate")) {
	            		
	            		
		            	certificateBox.setVisible(true);
	            		
	            	}else if(program.equals("Associate")) {
	            		
	                	associateBox.setVisible(true);
	            		
	            	}
	            	
		
		}
	}

