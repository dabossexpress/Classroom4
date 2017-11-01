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
	
	public static void startExploring() {
		while(playing) {
			npcActions();
			print(inventory.getDescription());
			print(currentRoom.getDescription());
			print("Whtat would you like to do?");
			String input = in.nextLine();
			currentRoom.interpretInput(input);
		}
	}
	
	private static void npcActions() {
		for(NPC n: npcs) {
			n.interact();
		}
	}

}
