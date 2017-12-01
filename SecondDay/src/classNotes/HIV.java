package classNotes;

public class HIV {
	
	static int count = 0;
	
	public static void main(String[] args) {
		int value = 12;
		System.out.println(value + "!is equal to " + factorial(value));
		System.out.println(value + " has " +countPrimeFactors(value,2)+ " prime factors.");
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
