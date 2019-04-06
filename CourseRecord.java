package hai;

import java.util.Formatter;



public class CourseRecord extends Test {
	
	
	private String description;
	private int credit;
	private String duration;


	
	//Default Constructor
	CourseRecord()
	{
		description=" Description of Course";
		credit= 4;
		duration = "Duration of Course";
			
	}



	public CourseRecord(int code, String courseName, Date testDate, int score, String remarks) {
		super(code, courseName, testDate, score, remarks);
		// TODO Auto-generated constructor stub
	}



	public CourseRecord(Test obj) {
		super(obj);
		// TODO Auto-generated constructor stub
	}



	public CourseRecord(String description, int credit, String duration) {
		super();
		this.description = description;
		this.credit = credit;
		this.duration = duration;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public int getCredit() {
		return credit;
	}



	public void setCredit(int credit) {
		this.credit = credit;
	}



	public String getDuration() {
		return duration;
	}



	public void setDuration(String duration) {
		this.duration = duration;
	}

	
	
}
