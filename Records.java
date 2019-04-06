package hai;

public class Records {
	
	
	protected int idNum;
	protected String firstName;
	protected String lastName;

	Records ()
	{
		idNum=123;
		firstName="First Name";
		lastName="Last Name";
	}

	public Records(int idNum, String firstName, String lastName) {
		super();
		this.idNum = idNum;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Records(Records obj) {
		super();
		this.idNum = obj.idNum;
		this.firstName = obj.firstName;
		this.lastName = obj.lastName;
	}

	public int getIdNum() {
		return idNum;
	}

	public void setIdNum(int idNum) {
		this.idNum = idNum;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
