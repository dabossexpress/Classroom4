package classNotes;

public class HIV {
	
	static int count = 0;
	
	public static void main(String[] args) {
		/*int value = 12;
		System.out.println(value + "!is equal to " + factorial(value));
		System.out.println(value + " has " +countPrimeFactors(value,2)+ " prime factors.");*/
		move(2,"A","B","C");
	}
	
	public static void move(int disc, String from, String other, String to) {
		String placeholder = "";
		String placeholder2 = "";
		System.out.println(from +" to "+ to);
		if(disc == 1) {
			return;
		}
		else {
			placeholder = other;
			other = to;
			to = placeholder;
			move(disc-1,from,other, to);
			placeholder2 = other;
			from = other;
			
			move(disc-1,other,from,to);
			System.out.println(from +" to "+ other);
			//move(disc-1,other,to, from);
			//move(disc-1,other, from, to);
			//System.out.println(from +" to "+ to);
		}
	}
	
	public static int countPrimeFactors(int value, int testPrime) {
		if(value%testPrime == 0 && (value > testPrime)) {
			keepCount();
			return countPrimeFactors(value/testPrime, testPrime);
		}
		else {
			return count;
		}
	}
	
	public static void keepCount() {
		count++;
	}

	public static int factorial(int value) {
		if(value == 1) {
			return 1;
		}
		else {
			return value*factorial(value-1);
		}
	}

	
	
	public HIV() {
		// TODO Auto-generated constructor stub
	}
	/*3:7
	 *4:16
	 *5:
	 * start with discs
	 * get disks onto another pole
	 * large cannot be on top of small
	 * bring each disc to a different pole
	 * explain why each decision was made
	 * 1.remove first two discs onto two separate poles
	 * 2. stack smaller disc onto larger disc 
	 * 3. remove disc on original pole to another pole
	 * 4. take topmost disc from pole with the larger disc and place it on a different pole]
	 * 5.take bottom disc and place it on the pole with the largest disc
	 * 6. take disc on original pole and place it on new pole
	 * */


}
