package caveExplorer;

import java.util.Scanner;

public class CaveExplorer {

	public static CaveRoom[][] caves;//every room in the cave
	public static Scanner in;//for user input
	public static CaveRoom currentRoom;//changes based on movement
	public static Inventory inventory;//where all objects found in a cave are kept
	public static boolean playing = true;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		in = new Scanner(System.in);
		CaveRoom.setUpCaves();
	}

}
