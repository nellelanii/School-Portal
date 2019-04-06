package hai;


import java.awt.event.ActionListener;
import java.io.File;
import java.util.Scanner;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

import graphics.TestWindow;

public class ProgrammeRecord extends Test{
	private int maxCourse;
	private String award;
	private String accred;
	
	public String certificate []= {"English Language", "Mathematics", "General Knowledge", "Information Technology"};
	public String diploma [] = {"English Language", "Mathematics", "General Knowledge", "Information Technology", "Project Management", "Principles of Business"};
	public String associate [] = {"English Language", "Mathematics", "General Knowledge", "Information Technology", "Project Management", "Principles of Business", "Principles of Accounts", "Economics"};
	
	
	
	
	//Primary Constructor
	public ProgrammeRecord()
	{
		maxCourse = 3;
		award = "Award given";
		accred=" Accreditation";
		
	}

	public ProgrammeRecord(int maxCourse, String award, String accred) {
		super();
		this.maxCourse = maxCourse;
		this.award = award;
		this.accred = accred;
	}




	public ProgrammeRecord(int code, String courseName, Date testDate, int score, String remarks) {
		super(code, courseName, testDate, score, remarks);
		// TODO Auto-generated constructor stub
	}




	public ProgrammeRecord(Test obj) {
		super(obj);
		// TODO Auto-generated constructor stub
	}




	public int getMaxCourse() {
		return maxCourse;
	}




	public void setMaxCourse(int maxCourse) {
		this.maxCourse = maxCourse;
	}




	public String getAward() {
		return award;
	}




	public void setAward(String award) {
		this.award = award;
	}




	public String getAccred() {
		return accred;
	}




	public void setAccred(String accred) {
		this.accred = accred;
	}


	
	
		

		 
		
		
		//Take test option
				//Read from the file for program student selected. Under each program create list of courses that the student should do. 
				//When the user selects the course, Using inheritance/ polymorhism, I want to call the question bank with the questions for that test.
				//Test Questions can be stored under CourseRecord class.
		
		//Set test option
		//Staff member will pull the file. It will allow the staff to read from the file, make changes to the questions and save it
		
		//Figure how to pass from one JFrame to another
		
		//Search file to see if the ID number exists
		//create an array to search the file for the programme 
		//if statement - if programme = certifcate, create a string array of subjects. return the string to a combobox so the user can select the test they want to do
		//create one file with all questions. use the course code to search for the questions relating to the subject
	
		
	}
