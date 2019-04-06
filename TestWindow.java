package graphics;
import hai.ProgrammeRecord;
import hai.Test;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import java.beans.PropertyChangeEvent;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class TestWindow extends JFrame {

	private JPanel contentPane;
	public static JComboBox testOptions;
	public JComboBox certificateBox;
	public JComboBox diplomaBox;
	public JComboBox associateBox;
	
	public static String cerCode;
	public static String dipCode;
	public static String asCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow frame = new TestWindow();
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
	public TestWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		
		panel.setBackground(new Color(32, 178, 170));
		panel.setBounds(155, 0, 501, 358);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		ProgrammeRecord testguide = new ProgrammeRecord();

		//testguide.programGuide(Login.textFieldidnum.getText());
		
		certificateBox = new JComboBox(testguide.certificate);
		certificateBox.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				
			}
		});
		certificateBox.setBounds(122, 135, 204, 27);
		panel.add(certificateBox);
		
		diplomaBox = new JComboBox(testguide.diploma);
		diplomaBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		diplomaBox.setBounds(122, 174, 204, 27);
		panel.add(diplomaBox);
		
		associateBox = new JComboBox(testguide.associate);
		associateBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		associateBox.setBounds(122, 213, 204, 27);
		panel.add(associateBox);
		
		certificateBox.setVisible(false);
    	diplomaBox.setVisible(false);
    	associateBox.setVisible(false);
		
		JLabel lblList = new JLabel("Courses currently enrolled in for ID#:");
		lblList.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		lblList.setBounds(42, 55, 253, 16);
		panel.add(lblList);
		
		JButton btnStart = new JButton("START");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 cerCode = (String) certificateBox.getSelectedItem();
				 dipCode = (String) associateBox.getSelectedItem();
				 asCode = (String) associateBox.getSelectedItem();
				
				TestSession test = new TestSession();
				//test.getQuestions(TestWindow.cerCode, TestWindow.dipCode, TestWindow.asCode);
				test.setVisible(true);
			
				
			}
		});
		btnStart.setBounds(308, 294, 117, 29);
		panel.add(btnStart);
		
		JLabel loginId = new JLabel("Welcome!");
		loginId.setFont(new Font("Hoefler Text", Font.ITALIC, 16));
		loginId.setBounds(282, 52, 93, 23);
		panel.add(loginId);
		loginId.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				loginId.setText(Login.textFieldidnum.getText());
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(32, 178, 170));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 161, 358);
		contentPane.add(panel_1);
		
		JButton button = new JButton("Main Menu");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MainMenu menu = new MainMenu();
				menu.setVisible(true);
			}
		});
		button.setBounds(2, 159, 145, 29);
		panel_1.add(button);
		
		JButton button_1 = new JButton("Switch User");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login user = new Login();
				user.setVisible(true);
				
			}
		});
		
		button_1.setBounds(2, 201, 145, 29);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("Exit System");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
			}
		});
		button_2.setBounds(12, 253, 135, 29);
		panel_1.add(button_2);
	}
	
	public void programGuide(String textFieldidnum)
	{
    	
		File read = new File("studentinfo.txt");
		
		Scanner sc = null;
		
		
		
		
		try {
			sc = new Scanner(read);
	
			while(sc.hasNextLine())
			{
				String record[] = sc.nextLine().split("\t"); // split the record into array using tab as the deliminer  
				
				
				
				
	            if (textFieldidnum.equals(record[2]))
	            {
	            	System.out.println(textFieldidnum+" "+record[7]);
	            	
	            	if(record[7].equals("Diploma")) {
	            		
	            		diplomaBox.setVisible(true);
		            	
	            		
	            	}else if(record[7].equals("Certificate")) {
	            		
	            		
		            	certificateBox.setVisible(true);
	            		
	            	}else if(record[7].equals("Associate")) {
	            		
	                	associateBox.setVisible(true);
	            		
	            	}
	            	
	            
	         }
			
		}
			
		}
			
			catch (Exception e)
			{
				JOptionPane.showMessageDialog(rootPane, "Unable to read seletions from file");
				e.printStackTrace();
			}
	}

}
