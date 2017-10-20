package arrays;

import java.util.Arrays;

public class ArraysMain {
	
	private String[] testArray;
	private int[] intRay;
	
	public ArraysMain() {
		intRay = new int[100];
		//populate(intRay);
		//checkOccurences(intRay,3,18);
		//populate1ToN(intRay);
		//shuffle(intRay);
		//Arrays is a Utility class included in Java for formatting output
		//System.out.println(Arrays.toString(intRay));
		/*
		int[] consecTest1 = {1,2,3,6,7,8,9,10,11,45,46,47};
		int[] consecTest2 = {10,11,12,13,14,15,6,7,8,9,10,11,45,46,47};
		System.out.println("The longest sequence in the first test is " + longestConsecutiveSequence(consecTest1));
		System.out.println("The longest sequence in the second test is " + longestConsecutiveSequence(consecTest1));
		*/
		int[] randomRolls = new int[1000];
		populate(randomRolls);
		int[] result = longestConsecSeqAndPos(randomRolls);
		System.out.println("The longest sequencee of dice rolls is " + result[0] + " it happened on the " + (result[1] + 1) + "th roll. Starting with a roll of "+ randomRolls[result[1]]);
		
	}
	
	public class Borough{
		
	}
	/*
	 moves the front to the back repeatedly, exactly n times
	 * */
	public void cycleThrough(int[] arr,int n) {
		for(int i = 0;i<n;i++) {
			arr = frontToBack(arr);
		}
		return arr;
	}
	/*
	 returns the length of the longest consecutive integers. For example, LCS({1,2,3,7,8,9,10}) returns 4
	 */
	public int longestConsecutiveSequence(int[] arr) {
		int numToReturn;
		numToReturn = 0;
		int placeholder;
		placeholder = 0;
		
		for(int i = 0;i<arr.length-1;i++) {
			if(arr[i+1] - arr[i] == 1) {
				numToReturn++;
				if(numToReturn > placeholder) {
					placeholder = numToReturn;
				}
			}
			else {
				numToReturn = 0;
			}
		}
		return placeholder+1;
	}
	
	public int positionOfLCS(int[] arr) {
		int pos = 0;
		int large = longestConsecutiveSequence(arr);
		
		for(int i = 0;i<arr.length-1;i++) {
			if(arr[i+1] == arr[i]) {
				pos++;
				if(pos == large) {
					return pos;
				}
				else {
					pos = 1;
				}
			}
		}
		return 0;
	}
	
	public int[] longestConsecSeqAndPos(int[] arr) {
		int[] data  = new int[2];
		data[0] = longestConsecutiveSequence(arr);
		data[1]  = positionOfLCS(arr);
		return data;
	}
	
	public boolean nextElementIsInSequence(int[] arr, int pos) {
		
	}
	
	public void reverseOrder(int[] arr) {
		int[] newArr  = new int[arr.length];
		for(int i = 0;i<arr.length;i++) {
			newArr[i] = arr[arr.length-i-1];
		}
		return newArr;
	}
	/*
	public void countLessThan(int[] arr,int n) {
		int placeIndex;
		placeIndex = 0;
		int[] finalArr;
		
		for(int i = 0;i<arr.length;i++) {
			if(arr[i] < n) {
				finalArr[placeIndex] = arr[i];
				placeIndex++;
			}
		}
		return finalArr;
	}*/
	/*
	 remove the element at index zero, push every other element up by one
	 Put the element that was at zero at the end of arr
	 * */
	public frontToBack(int[] arr) {
		int placeholder;
		placeholder = arr[0];
		
		for(int i =0;i<arr.length-1;i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length-1] = placeholder;
		
		return arr;
	}
	
	public int countLessThan(int[] arr, int n) {
		int count = 0;
		for(int value: arr) {
			if(value < n)
				count++;
		}
		return count;
	}
	
	private void shuffle(int[] arr) {
		for(int i =0;i< arr.length;i++) {
			swap(arr,(int)(Math.random()*arr.length),(int)(Math.random()*arr.length));
		}
	}
	
	private void swap(int[] arr, int i, int j) {
		int placeholder = arr[i];
		arr[i] = arr[j];
		arr[j] = placeholder;
	}

	private void populate1ToN(int[] arr) {
		for(int i = 1;i<=arr.length;i++) {
			arr[i-1] = i;
		}
	}

	private void checkOccurences(int[] arr, int start, int end) {
		int[] counter = new int[end-start+1];
		for(int value: arr) {
			counter[value-start]++;
		}
		for(int i = 0; i>counter.length;i++) {
			System.out.println("A " +(start + i)+" was rolled" +counter[i]+ "times.");
		}
	}

	private void populate(int[] intRay) {
		 for(int i = 0; i < intRay.length;i++) {
			 intRay[i]  = diceRoll(3);
		 }
	}

	public void notes() {
		//1. collection of primitives or objects
		//SPECIAL NOTE: This is the ONLY collection of primitives
		
		//2. size cannot be modified
		
		//3. Elements of an array are REFERENCEs(indices) to objects.
		//In other words, changing an element of an array changes the
		//REFERENCE, not the object(more on this later)
		
		//There are two types of constructors, the first we've seen already:
		int[] firstType = {3,14,-9};
		// this constructor can only be used at the declaration. Error:
		//firstType = {12,13,14,15};
		
		//the 2nd type:
		testArray = new String[50];
		//SPECIAL NOTE: for primitive arrays, when they are instantiated, they are automatically
		//populated with 0s(booleans would be populated with false). This is not the case with Object arrays.
		// which are populated with null(An array of Strings would be populated with null.)
		
		// standard 'for' loop
		for(int i = 0;i<testArray.length;i++) {
			 System.out.println("The " + i +"th item is: "+ testArray[i]);
		}
		
		// for each loop (useful only when you don't need to keep track of an index)
		for (String value:testArray) {
			//"for each int in testArray"
			System.out.println(value);
		}
	}
	
	public static void main(String[] args) {
		ArraysMain arrayPractice = new ArraysMain();
	}
	
	public int diceRoll (int numberOfDice) {
		int sum;
		sum = 0;
		
		for(int i = 0; i<numberOfDice;i++) {
			sum = sum + 1+(int)(Math.random()*6);
		}
		return sum;
	}
}
