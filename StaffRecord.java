package hai;

public class StaffRecord extends Records{
	
	//private int staffID;
	//private String staffPass;
	//private String fName;
	//private String lName;
	
	private String faculty;
	private String department;
	private Date dateEmployed;
	
	
	
	//Default Constructor
	StaffRecord()
	{
		//staffPass="Staff Password";
		//staffID=123;
		//fName="First Name";
		//lName="Last Name";
		
		faculty="Faculty of Staff Member";
		department="Department of  Staff Member";
		dateEmployed = new Date(); // composite class 'Date'
		
	}



	public StaffRecord(int idNum, String firstName, String lastName) {
		super(idNum, firstName, lastName);
		// TODO Auto-generated constructor stub
	}



	public StaffRecord(Records obj) {
		super(obj);
		// TODO Auto-generated constructor stub
	}



	public StaffRecord(String faculty, String department, Date dateEmployed) {
		super();
		this.faculty = faculty;
		this.department = department;
		this.dateEmployed = dateEmployed;
	}
	
	public StaffRecord(StaffRecord obj) {
		super();
		this.faculty = obj.faculty;
		this.department = obj.department;
		this.dateEmployed = obj.dateEmployed;
	}



	public String getFaculty() {
		return faculty;
	}



	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public Date getDateEmployed() {
		return dateEmployed;
	}



	public void setDateEmployed(Date dateEmployed) {
		this.dateEmployed = dateEmployed;
	}
	
	
	
	
}