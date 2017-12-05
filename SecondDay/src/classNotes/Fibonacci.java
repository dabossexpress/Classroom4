package classNotes;

public class Fibonacci {

	public Fibonacci() {
		// TODO Auto-generated constructor stub
	}
	
	public static int fibonacciNum(int n) {
		if(n == 0) {
			return 1;
		}
		if(n == 1) {
			return 1;
		}
		else {
			return fibonacciNum(n-1) + fibonacciNum(n-2);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fibonacciNum(5));
	}

}
