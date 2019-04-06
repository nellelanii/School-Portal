package hai;

public class StudentRecord extends Records{
//	private int idNum;
//private String studentFN;
//	private String studentLN;
//private String studentPass;
	
	private String address;
	private Date dateEnrolled;
	private int contactNo;

	//Default constructor
	StudentRecord()
	{
		//idNum=123;
		//studentFN= "Student FirstName";
		//studentLN= "Student Last Name";
		//studentPass="Student Password";
		address="Student Address";
		dateEnrolled= new Date();
		contactNo= 876321324;
		
	}
	

	public StudentRecord(int idNum, String firstName, String lastName) {
		super(idNum, firstName, lastName);
		// TODO Auto-generated constructor stub
	}


	public StudentRecord(Records obj) {
		super(obj);
		// TODO Auto-generated constructor stub
	}


	public StudentRecord(String address, Date dateEnrolled, int contactNo) {
		super();
		this.address = address;
		this.dateEnrolled = dateEnrolled;
		this.contactNo = contactNo;
	}
	
	public StudentRecord(StudentRecord obj) {
		super();
		this.address = obj.address;
		this.dateEnrolled = obj.dateEnrolled;
		this.contactNo = obj.contactNo;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public Date getDateEnrolled() {
		return dateEnrolled;
	}


	public void setDateEnrolled(Date dateEnrolled) {
		this.dateEnrolled = dateEnrolled;
	}


	public int getContactNo() {
		return contactNo;
	}


	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	
	
	
	

}