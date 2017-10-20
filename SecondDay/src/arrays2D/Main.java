package arrays2D;

import java.util.Arrays;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
		System.out.println(Arrays.toString(changeNeighbors([1,2,3],1)));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	// THE IDEA OF A AVOIDING AN ArrayIndexOutOfBoundsException is
	// another major topic in AP CSP
	// YOU WILL SEE IT ON QUIZZES, TESTS, AND PROJECT RUBRICS
	// SO ALWAYS BE MINDFUL
	public static void changeNeighbors(int[] arr, int psn) {
		if((arr[psn] != (Integer) null)) {
			arr[psn] = arr[psn] + 1;
		}
		arr[psn-1] = arr[psn] -1;
		arr[psn+1] = arr[psn] -1;
	}

}
