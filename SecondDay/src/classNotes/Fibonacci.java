package classNotes;

public class Fibonacci {

	public Fibonacci() {
		// TODO Auto-generated constructor stub
	}
	
	public void fibonacciNum(int n) {
		int sum = 0;
		if(n == 0) {
			sum = 1;
		}
		if(n == 1) {
			sum = 1;;
		}
		else {
			sum = sum + fibonacciNum(n-1) + fibonacciNum(n-2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fibonacciNum(0);
	}

}
