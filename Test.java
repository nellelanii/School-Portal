package hai;

public class Test {

	protected int code;
	protected String Name; 
	protected Date testDate;
	protected int score;
	protected String remarks;

	public Test ()
	{
		code = 123;
		Name= "Maths";
		testDate =new Date();
		score = 100;
		remarks = "Test Remarks";
	}

	public Test(int code, String courseName, Date testDate, int score, String remarks) {
		super();
		this.code= code;
		this.Name= "Course Name";
		this.testDate = testDate;
		this.score = score;
		this.remarks = remarks;
	}
	
	public Test(Test obj) {
		super();
		this.code= obj.code;
		this.Name= obj.Name;
		this.testDate = obj.testDate;
		this.score = obj.score;
		this.remarks = obj.remarks;
	}

	public Date getTestDate() {
		return testDate;
	}

	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	
	
	
	
	
	
	
}
