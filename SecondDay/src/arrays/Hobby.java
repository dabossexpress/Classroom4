package arrays;

public class Hobby extends Thing{

	public Hobby(String description) {
		super(description);
		// TODO Auto-generated constructor stub
	}

	public static Hobby randomHobby() {
		// TODO Auto-generated method stub
		Hobby[] someHobbies = {new Hobby("Programming"), new Hobby("dancing"),
				new Hobby("playing video games")};
		return someHobbies[(int)(Math.random()*someHobbies.length)];
	}
	
}
