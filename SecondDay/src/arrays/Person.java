package arrays;

import arrays.ArraysMain.Borough;

public class Person {
	
		public static final String[] FIRST_START = {"Chr","M","L","Gr","Ph","B","Th"};
		public static final String[] FIRST_MIDDLE = {"isti","icha","era","eta","ala","ina","ara"};
		public static final String[] FIRST_END = {"","na","n","r","tian","s","rs","mp","les"};

		public static final String[] LAST_START = {"Tr","Br","L","Gr","Sh","B","Th"};
		public static final String[] LAST_MIDDLE = {"om","o","an","ola","et","e","is"};
		public static final String[] LAST_END = {"","son","ers","rian","ston","ck","sk"};
		
		
		private String firstName;
		private String lastName;
		private Borough home;
		private String nickname;
		private Hobby hobby;
		private Person[] friends;
		
		public Person(String first, String last, Borough home) {
			this.firstName = first;
			this.lastName = last;
			this.home = home;
			this.nickname = createNickname(firstName);
			this.hobby = Hobby.randomHobby();
			friends = new Person[3];
		}
		
		// chooses friends from People based on who is of the same class
		// as this instance and who has the same hobbies
		
		
		//JAVA IS PASS-BY-VALUE
		//meaning the parameters of a method are just values, not references
		// so if you change those values, the original object is not affected
		// in this case, name will not be changed.
		///In fact, nothing can change this.firstName via name
		public static String createNickname(String name) {
			int vowelCount = 0;
			int pos = 0;
			String newName = "";
			for(int i = 0;i<name.length()-1;i++) {
				if(name.substring(i,i+1).equals("a") || name.substring(i,i+1).equals("e") || name.substring(i,i+1).equals("i") || name.substring(i,i+1).equals("o") || name.substring(i,i+1).equals("u")) {
					vowelCount++;
					if(vowelCount == 2) {
						pos = i;
						break;
					}
				}
			}
			newName = name.substring(0,pos);
			return newName;
		}
		
		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
			nickname = createNickname(firstName);
		}

		public void mingle(Person[] people) {
			for(Person p: people) {
				if(p != this) {
					// reassign p to the better of the two friends: your current
					// best friend or p
					p = betterFriend(p, friends[0]);
					
					addFriendToFirstPlace(p);
				}
			}
		}
		
		private Person betterFriend(Person p, Person q) {
			// TODO Auto-generated method stub
			if(p == null) {
				return q;
			}
			if(q == null) {
				return p;
			}
			if(p.getClass() == this.getClass() && q.getClass() == this.getClass()) {
				if(p.hobby == this.hobby) {
					return p;
				}
				if(q.hobby == this.hobby) {
					return q;
				}
				return p;
			}
			if(p.getClass() == this.getClass()) {
				return p;
			}
			if(q.getClass() == this.getClass()) {
				return q;
			}
			return p;
		}

		public void printFriends() {
			System.out.println("My name is"+firstName+lastName+ " and these are my friends");
			for(Person f: friends) {
				if(f != null) System.out.println(f);
			}
		}
		// moves all Person in friends back one index and puts p at index 0
		public void addFriendToFirstPlace(Person p) {
			for(int i = friends.length-1; i>0;i--) {
				friends[i] = friends[i-1];
			}
			friends[0] = p;
		}
		
		public String toString(){
			return "My name is "+firstName+""+lastName+"and I live in" +home+"." + "Call me "+nickname;
		}
	}
