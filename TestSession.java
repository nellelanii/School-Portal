package graphics;
import java.awt.Container;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import java.awt.List;
import java.awt.Font;
import javax.swing.JComboBox;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JScrollPane;

public class TestSession extends JFrame {

	private JPanel contentPane;
	public static JTextArea txtrQuestion;
	private JPanel sideMenu;
	private int offset;
	private String answer; 
	public JTextArea firstQuestionbox;
	public JTextField txtQue;
	String[] ans = {"A", "B", "C", "D"}; 
	public int mark = 0;
	private float score = 0.0f;
	private JScrollPane scrollPane;
	 

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestSession frame = new TestSession();
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
	public TestSession() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel test = new JPanel();
		test.setBackground(new Color(32, 178, 170));
		test.setBounds(0, 0, 656, 364);
		contentPane.add(test);
		test.setLayout(null);
		
		txtQue = new JTextField(); //Hidden question number field
		if(this.getOffset() == 0) {
			txtQue.setText("0");
		}else {
			txtQue.setText(String.valueOf(getOffset()));
		}
		txtQue.setBounds(205, 282, 130, 26);
		test.add(txtQue);
		txtQue.setColumns(10);
		
		txtQue.setVisible(false);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(173, 35, 346, 166);
		test.add(scrollPane);
		
		
		
		firstQuestionbox = new JTextArea();
		scrollPane.setViewportView(firstQuestionbox);
		firstQuestionbox.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		firstQuestionbox.setEditable(false);
		getQuestion(0);
		
		JComboBox selectAns = new JComboBox(ans);
		selectAns.setBounds(531, 56, 117, 27);
		test.add(selectAns);
		
		JLabel idNum = new JLabel("");
		idNum.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				
				idNum.setText(Login.textFieldidnum.getText());
			}
		});
		idNum.setBounds(23, 45, 61, 16);
		test.add(idNum);
		
		
		
		JButton btnSubmitAnswer = new JButton("Submit Answer");
		btnSubmitAnswer.setBounds(512, 213, 138, 29);
		btnSubmitAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//String quest = null;
				String answer = (String)selectAns.getSelectedItem(); //Cast Selected item to a string variable
				String[] question = null;
				Scanner sc = null;
				char grade = 0;
				String remarks = null;
				
				
			
				
				  try
		            {
					  
		                FileReader reader = new FileReader( "questionbank.txt" );
		                BufferedReader br = new BufferedReader(reader);
		                FileWriter writer = new FileWriter("resultsheet.txt", true);
		                
						
						
						
		                sc = new Scanner(reader);
		    			while(sc.hasNextLine()){ // to compare selected answers to ones that is on the file
		    				
		    				question= sc.nextLine().split("\t\t");
		    				if(answer.equals(question[7]))	
		    				{
		    						mark++;	
		    						System.out.println(mark);
		    						System.out.println("Answer Correeectooo");
		    				}
		    				else {
		    					System.out.println("Answer inCorreeectooo");
		    				}
		    						
		    				
		    				 
		    				
			    			score = (mark/10.0f) * 100;
	    					double roundOff = Math.round(score *100.0f)/100.0f; //round off score to nearest 100.
	    					System.out.println("Score:"+ score);
    					System.out.println("Roundoff:"+ roundOff);

	    					
	   					 
	   					 if (score >= 50.0)
		    					{
		    						 grade = 'P';
		    						 remarks= "Pass";
		    					}
		    					else
		    					{
		    						grade = 'F';
		    						remarks="Fail";
		    					}
	   					System.out.println("Grade:"+ grade);
    					break;
		    			}
		    			
		    	  	
   					String idNum = Login.textFieldidnum.getText();
   					
   					writer.write(idNum+"\t\t");
   					writer.write(score+"\t\t");
   					writer.write(grade+"\t\t");
   					writer.write(remarks+"\t\t");
   					writer.write(System.getProperty("line.separator"));
   					writer.close();
		    			
		         }      
		            
		    			catch(IOException e1)
		    			{
		    				JOptionPane.showMessageDialog(rootPane, "Error found while recording result");
		    				e1.printStackTrace();
		    			}
   					
   					
   			
   			

				
				JOptionPane.showMessageDialog(rootPane, "Answer was submitted successfully!"); // Message if Login info is correct
				if(getOffset() == 0) {
					txtQue.setText("0");
				}else {
					txtQue.setText(String.valueOf(getOffset()));
				}
				
				String text = txtQue.getText().toString();
				int val = Integer.parseInt(text);
			
				getQuestion(val);
			
			//	firstQuestionbox.setText("  ");
		            
		            		
			}
		});
		test.add(btnSubmitAnswer);
		
		
		
	
		
		sideMenu = new JPanel();
		sideMenu.setBounds(0, 0, 155, 364);
		contentPane.add(sideMenu);
		
	}
	
	
	public void getQuestion(int offset) {
		//System.out.println(offset);
		firstQuestionbox.setText("");
		int i = 0;
		String[] question = null;
		String[] answer = null;
		Scanner sc = null;
		  try
            {
			  
                FileReader reader = new FileReader( "questionbank.txt" );
                BufferedReader br = new BufferedReader(reader);
                
                
                sc = new Scanner(reader);
    			
    			while(sc.hasNextLine()){
    				
    				question= sc.nextLine().split("\t\t");
//    			int number =0; //Number of questions
//    				while ( number >=10)
//    			{
    				
    				//System.out.println(question[5]);
    				if(offset == i && (question[0].equals("MATH23") || question[1].equals("MATH23") || question[2].equals("MATH23"))) {
    					firstQuestionbox.setText(question[5]);
    					answer = question[6].split("&"); //splits answers by the operand sign when Staff sets test so the answers can be printed with selection beside them
    					//System.out.println(answer.length);
    					//System.out.println(question[6]); 
    					String[] letters = {"A", "B", "C", "D"};
    					String cancatString = "\n";
    						for(int a = 0; a < answer.length ; a++) {
    							cancatString += letters[a] + ") " + answer[a] + "\n";
    						}
    						firstQuestionbox.append(cancatString);
		                    br.close();
		                    break;
        		         }
    				i++;
    				
    				if (i == 10) //10 Questions per Test
    				{
    					JOptionPane.showMessageDialog(rootPane, "End of test!");
    	    			Login endtest= new Login();
    	    			endtest.setVisible(true);
    				}
    			//	break;
//    				}
//    				number++;
//    				break;
    			}
    			
    			
    		/*	
    		 
    			JOptionPane.showMessageDialog(rootPane, "End of test!");
    			StudentMenu endtest= new StudentMenu();
    			endtest.setVisible(true);*/
    			
    			
            }
		  catch (Exception t)
		  
		  {
			  JOptionPane.showMessageDialog(rootPane, "Unable to read question from file");

			  System.out.println(t);
		  }
		  
		  this.setOffset(offset + 1);
	
	}
	
	/*public static void shuffleArray(Object[] question)
	{
		int elements = question.length;
		for (int i = 0; i < elements; i++)
		{
			int shuffle = i + (int)(Math.random() + (elements-i));
			
			Object temp = question[shuffle];
			question[shuffle]= question[i];
			question[i]= temp;
		}
	}*/
	
	
	
	public static int checkLength()
	{
		int count = 0;
		Scanner sc = null;
		
		try {
			
			FileReader reader = new FileReader( "questionbank.txt" );
			 BufferedReader br = new BufferedReader(reader);
             
             sc = new Scanner(reader);
 			
			
			while(sc.hasNextLine())
			{
				
				count++;
				break;
			}
		
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			
			e.printStackTrace();
		}
		
		
		return count;
		
	}
	
	public static int generateRandom() {
		
		Random random = new Random();
		int count = checkLength();
		return 0 + random.nextInt(count);
		
	}
}
	
//	public static void getQuestions() 
//	{
//		
//		
//		Scanner sc = null;
//		
//		
//        
//		  try
//          {
//			  
//              FileReader reader = new FileReader( "questionbank.txt" );
//              BufferedReader br = new BufferedReader(reader);
//              
//              sc = new Scanner(reader);
//  			
//  			while(sc.hasNextLine()){
//  				
//  				
//  	          String  question[] = sc.nextLine().split("\t\t"); // split the record into array using tab as the deliminer 
//  	            
//  	   //    shuffleArray(question);
//  	       //     
//        	//      for (int i = 0; i < question.length; i++)
//        	  //  {
//  	          
//  	            
//  	            int elements= question.length;
//  	            
//  	             
//              
//  	            if(question[0].equals("ENG101") || question[1].equals("ENG101") || question[2].equals("ENG101"))
//  		         {
//	                    txtrQuestion.append( question[5]+"\n" );
//	                 //   System.out.print(question[i]);
//	                    br.close();
//  		         }
//  	         //   break;
//  	            
//        	  //  }
//        	      break;
//  			}    
// 	         
//          }
//		  catch (Exception t)
//		  {
//			  System.out.println(t);
//		  }
//	}
//}

//make combobox static to call to function. Use if statement to compare cousecode 
//Link questions to label
