package arrays;

public class ObjectArrays {
	
	public ObjectArrays() {
		/*
		Person jeff = new Person("Jeff","Smith",new Borough("Brooklyn"));
		System.out.println(jeff);
		*/
		
		Object[] people = new Object[20];
		populate(people);
		people[0] = new Thing("coffee maker");
		for(Object p: people) {
			System.out.println(p);
		}
	}

	private void populate(Object[] people) {
		// TODO Auto-generated method stub
		for(int i = 0; i < people.length;i++) {
			String firstName = randomNameFrom(Person.FIRST_START, Person.FIRST_MIDDLE,Person.FIRST_END);
			String lastName = randomNameFrom(Person.LAST_START, Person.LAST_MIDDLE,Person.LAST_END);
			Borough b = randomBorough();
			//BIG IDEA!!!
			//In Object[] (but no primitive arrays like int[] or double[])
			// You can have multiple data types (sub-classes of the declared type)
			if(Math.random() < .6) {
				// 60% of the time...
				int grade = (int)(Math.random()*5)+9;
				people[i] = new Student(firstName, lastName, b);

			}
			else {
				people[i] = new Person(firstName, lastName, b);
			}
			people[i] = new Person(firstName, lastName, b);
		}
	}

	private Borough randomBorough() {
		return Borough.NY_BOROUGHS[(int)(Math.random()*Borough.NY_BOROUGHS.length)];
	}

	private String randomNameFrom(String[] a, String[] b, String[] c) {
		// TODO Auto-generated method stub
		return get(a)+get(b)+get(c);
	}

	private String get(String[] a) {
		// TODO Auto-generated method stub
		return a[(int)(Math.random()*a.length)];
	}
	
}
