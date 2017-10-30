package caveExplorer;

public class TwoDArrayPractice {
	
	
	public static void main(String[] args) {
		String[][]pic = new String[6][10]; //6 rows and 10 columns
		for(int row = 0; row<pic.length;row++) {
			for(int col = 0;col<pic[row].length; col++) {
				pic[row][col] = "";
			}
		}
		//drawHorizontalLine(pic,1);
		//drawHorizontalLine(pic,3);
		//drawHorizontalLine(pic,5);
		//drawVerticalLine(pic,2);
		//drawSlot(pic,4,5);
		drawBox(pic,4,5);
		print(pic);
	}
	
	/*
	 * A slot looks like this
	 * | |
	 * It is two vertical lines with a space between them
	 * The coordinates,i,j are the coordinates of the space
	 * In other words, a slot is a vertical line in front of i,j and after i,j
	 * CATCH: NoArrayIndexOutOfBoundsExceptions
	 * */
	
	
	/*
	 * Box looks like this
	 * ___
	 * |*|
	 * |_|
	 * */
	private static void drawBox(String[][] pic, int i, int j) {
		// TODO Auto-generated method stub
		/*
		pic[i][j] = "*";
		if(i < pic.length) {
			pic[i+1][j] = "_";
		}
		for(int col = 0;col<3;col++) {
			pic[i-1][j-1] = "_";
			j++;
		}*/
		drawSlot(pic,i,j);
		drawSlot(pic,i+1,j);
		drawIfInBounds("_",pic,i,j);
		for(int col = j -1; col<=j+1,col++) {
			drawIfInBounds("_",pic,i-1,col);
		}
	}

	private static void drawIfInBounds(String string, String[][] pic, int i, int j) {
		// TODO Auto-generated method stub
		//SPECIAL NOTE: Always check row before column
		// In other words, check if row exists before checking if a column exists
		if(i >= 0 && i < pic.length && j >= 0 && j < pic[i].length) {
			pic[i][j] = string;
		}
	}

	private static void drawSlot(String[][] pic, int i, int j) {
		// TODO Auto-generated method stub
		if(i>=0 && i < pic.length) {
		if(j>0) {
			pic[i][j-1] = "|";
		}
		if(j < pic[i].length-1) {
			pic[i][j+1] = "";
		}
	}
		}

	private static void drawVerticalLine(String[][] pic, int col) {
		for(int row = 0; row<pic.length;col++) {
			pic[row][col] = "|";
		}
	}

	private static void drawHorizontalLine(String[][] pic, int row) {
		// TODO Auto-generated method stub
		for(int col = 0;col < pic[row].length;col++) {
			pic[row][col] = "-";
		}
	}

	private static void print(String[][] pic) {
		String line = "";
		for(int row = 0; row<pic.length;row++) {
			for(int col = 0;col<pic[row].length; col++) {
				line += pic[row][col];
			}
			line +="\n";
		}
		System.out.println(line);
	}
}
