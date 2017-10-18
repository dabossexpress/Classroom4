package arrays;

import arrays.ArraysMain.Borough;

public class Student extends Person {

	public static final String[] grades = {"Freshman","Sophmore","Junior","Senior","Super Senior"};
	
	private String grade;
	
	public Student(String first, String last, Borough home, int gradeLevel) {
		super(first, last, home);
		int index = gradeLevel - 9;
		this.grade = grades[index];
		// super constructor is first bc a person must exist before a student can exist
		// TODO Auto-generated constructor stub
	}
	
	public String toString() {
		//NOTE: if you want to call the parent method, use super.
		return super.toString()+" I am also a "+ grade+".";
	}

}
