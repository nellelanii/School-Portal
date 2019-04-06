package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.ScrollPane;

public class ViewResults extends JFrame {

	private JPanel contentPane;
	//public static JTextField textFieldidnum;
	//private  JTextArea resultText;
	private JScrollPane scrollPane;
	Login lgscrn = new Login();
	private JTextArea resultText_1;
	private JTextArea ResultsScrn;
	private JScrollPane scrollPane_1;
//	String idnumber = lgscrn.textFieldidnum.getText();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewResults frame = new ViewResults();
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
	public ViewResults() {
		setBackground(new Color(128, 128, 128));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel Result = new JPanel();
		Result.setBounds(0, 0, 662, 358);
		contentPane.add(Result);
		Result.setBackground(new Color(32, 178, 170));
		Result.setLayout(null);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setBounds(35, 304, 117, 29);
		Result.add(btnExit);
		
		JButton logOut = new JButton("Log Out");
		logOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Login login = new Login();
				login.setVisible(true);
			}
		});
		logOut.setBounds(35, 263, 117, 29);
		Result.add(logOut);
		
		JPanel sideMenu = new JPanel();
		sideMenu.setBounds(0, 0, 186, 358);
		contentPane.add(sideMenu);
		sideMenu.setBackground(new Color(32, 178, 170));
		sideMenu.setLayout(null);
		
		JLabel idNum = new JLabel("");
		idNum.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				//idNum.setText(Login.textFieldidnum.getText());
			}
		});
		idNum.setBounds(23, 45, 61, 16);
		sideMenu.add(idNum);
		
		
		
		
		
		
		
		JButton btnTestReport = new JButton("Get Results");
		btnTestReport.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				try {
					scrollPane_1 = new JScrollPane();
					scrollPane_1.setBounds(218, 25, 427, 285);
					Result.add(scrollPane_1);
					ResultsScrn = new JTextArea();
					scrollPane_1.setViewportView(ResultsScrn);
					ResultsScrn.setEditable(false);
					ResultsScrn.setText("STUDENT ID"+ "\t" + "MARK" +"\t" + "SCORE" + "\t" + "REMARKS" + " \n");
					
					
					Scanner sc = new Scanner(new File("resultsheet.txt"));
					BufferedReader br = new BufferedReader(new FileReader("resultsheet.txt"));
					
					int i = 0;	//index
					
					int lines = 0; //Counter for number of lines in file
				
					//scrollPane.setViewportView(resultText_1);
					
					
					
			
			
				while (br.readLine() != null) { //while file line is not empty increment lines
					lines++;
				}
				br.close();
				System.out.println("Number of lines in file: " +lines);
				
				while (sc.hasNextLine() && i < lines) {
					
						String index[] = sc.nextLine().split("\t\t"); //split file into array
						
						if (index[0].equals(lgscrn.idnumber)) { //comparing first record to idnumber
							ResultsScrn.append(index[0].toString() + "\t" + index[1].toString() + "\t" + index[2].toString() + "\t" + index[3].toString()+"\n");
							
						System.out.println("Records:" +"\n"+ index[1].toString() + "\t" + index[2].toString() + "\t" + index[3].toString()+"\n");
							
						}
						i++;
				}
				sc.close();

				}	
			 catch (FileNotFoundException e2) {
				System.err.println("Sorry File was not found");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
				
				
				
				
				
				
				
			}
//				String resultsheet[]=null;
//				String indexId[]=null;
//				Scanner sc = null;
//				
//				scrollPane.setViewportView(resultText);
//				
//		try {
//			Scanner reader = new Scanner(new File("resultsheet.txt"));
//			BufferedReader br = new BufferedReader(new FileReader("resultsheet.txt"));
//	
//				System.out.println("consoleTest Date" + "\t" + "Course Code" + "\t" + "Score" + "\t" + "Remarks" + " \n");
//				
//
//				int lines = 0; //lines in the file
//				int i = 0; //index
//				while (br.readLine() != null) { //Reads lines from text, while line is not empty
//					lines++;
//				}
//				br.close(); 
//				System.out.println(lines); //console
//		
//				while (sc.hasNextLine() && i < lines) { //Reads through the file, while scanner has a next line filled and index has linesfilled
//			//String indexId[] = sc.nextLine().split("\t\t"); // search file tab by tab 
//					
//					indexId= sc.nextLine().split("\t\t");
//					System.out.println(indexId[1].toString() + "\t" + indexId[2].toString() + indexId[3].toString() + "\n");
//					System.out.println(resultsheet.length);
//					String cancatString = "\n";		
//				if (indexId[0].equals(Login.textFieldidnum))
//				{
//					resultText.setText("Test Date" + "\t" + "Course Code" + "\t" + "Score" + "\t" + "Remarks" + " \n");
//					
//		
//					}
//				
//					resultText.append(cancatString);
//					
//				break;	
//					/*if (indexId[0].equals(Login.textFieldidnum)) {
//						resultText.setText(indexId[1].toString() + "\t" + indexId[2].toString() + indexId[3].toString() + "\n"); //print to JtextArea
//						
//					System.out.println(indexId); //IdNumber
//				*/	
//					
//				}	
//					
//				i++;
//				sc.close();	
//				}
//			
//		 catch (FileNotFoundException e2) {
//				System.err.println("Sorry File was not found");
//				
//			} catch (IOException e1) {
//				e1.printStackTrace();
//			}
//			
//			}	
		
		});
		btnTestReport.setBounds(35, 222, 117, 29);
		Result.add(btnTestReport);
		
	

		
	
		
		
	}
}
