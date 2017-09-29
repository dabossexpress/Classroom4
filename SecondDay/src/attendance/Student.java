package attendance;

public class Student implements Attendee {

	private boolean presentStatus;
	private String firstName;
	private String lastName;
	
	public Student(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		presentStatus = false;
	}
	
	public boolean isPresent() {
		return presentStatus;
	}

	public void setPresent(boolean present) {
		presentStatus = true;

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public boolean mathces(String first, String last) {
		return first.toLowerCase().equals(firstName.toLowerCase()) && last.toLowerCase().equals(lastName.toLowerCase());
	}

	public boolean matches(String last) {
		return last.toLowerCase().equals(lastName.toLowerCase());
	}

	public String getReportString() {
		String temp = "";
		for (int i = 0; i < lastName.length(); i++)
		{
			if (temp.length()>=20)
			{
				break;
			}
			temp = temp+lastName.substring(i,i+1);
		}
		while (temp.length()<20)
		{
			temp = temp+" ";
		}
		for (int i = 0; i < firstName.length(); i++)
		{
			if (temp.length()>=40)
			{
				break;
			}
			temp = temp+firstName.substring(i,i+1);
		}
		while (temp.length()<40)
		{
			temp = temp+" ";
		}
		if (presentStatus)
			temp = temp+"PRESENT/n";
		else
			temp = temp+"ABESNT/n";
		return temp;
		//test
	}

	@Override
	public boolean matches(String first, String last) {
		// TODO Auto-generated method stub
		return false;
	}

}
/*package attendance;

public class Student implements Attendee{
	private String firstName;
	private String lastName ;
	private boolean present;
	
	public Student(String firstName , String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		present = false;
	}

	@Override
	public boolean isPresent() {
		return present;
	}
	@Override
	public void setPresent(boolean present) {
		present = true;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public boolean matches(String first, String last) {
		return first.toLowerCase().equals(firstName.toLowerCase()) && last.toLowerCase().equals(lastName.toLowerCase());
	}

	@Override
	public boolean matches(String last) {
		return (last.toUpperCase() == this.lastName.toUpperCase());
	}

	@Override
	public String getReportString() {
		if (this.lastName.length() > 20)
			lastName = this.lastName.substring(0, 17) + "...";
		else
			lastName = String.format("%-20s", this.lastName);  //Pad string from right with Max 20 spaces.
		if (this.firstName.length() > 20)
			firstName = this.firstName.substring(0, 17) + "...";
		else
			firstName = String.format("%-20s", this.firstName);  //Pad string from right with Max 20 spaces.
		
		String strPresent;
		if (this.present)
			strPresent = "PRESENT";
		strPresent = "ABSENT";
		
		return (lastName + firstName + strPresent);
	}

	@Override
	public boolean mathces(String first, String last) {
		// TODO Auto-generated method stub
		return false;
	}
}
*/

/* package attendance;

public class Student implements Attendee {
	boolean present = false;
	private String firstName;
	private String lastName;
	public Student(a,b) {
		this.firstName = a;
		this.lastName = b;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isPresent() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPresent(boolean present) {
		// TODO Auto-generated method stub
		this.present = present;
	}

	@Override
	public String getFirstName() {
		// TODO Auto-generated method stub
		return firstName;
	}

	@Override
	public String getLastName() {
		// TODO Auto-generated method stub
		return lastName;
	}

	@Override
	public boolean mathces(String first, String last) {
		// TODO Auto-generated method stub
		return first.toLowerCase().equals(firstName.toLowerCase()) && last.toLowerCase().equals(lastName.toLowerCase())
;
	}

	@Override
	public boolean matches(String last) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getReportString() {
		// TODO Auto-generated method stub
		return null;
	}

}
*/