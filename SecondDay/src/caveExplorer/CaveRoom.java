package caveExplorer;

public class CaveRoom {
	
	private String description;// tells what the room looks like
	private String directions;//tells what you can do
	private String contents;////a symbol representing what's in the room
	private String defaultContents;
	//the rooms are organized by direction, 'null' signifies no room/door in that direction
	private CaveRoom[] borderingRooms;
	private Door[] doors;

	//constants
	public static final int NORTH = 0;
	public static final int EAST = 1;
	public static final int SOUTH = 2;
	public static final int WEST = 3;
	
	
	public CaveRoom(String description) {
		this.description = description;
		setDefaultContents(" ");
		contents = defaultContents;
		//difference between defaultContents and contents is "contents" becomes an X when you're
		//inside the room, but when you leave, it goes back to defaultContents.
		
		//note: by default, arrays will populate with 'null', meaning there are no connections.
		borderingRooms = new CaveRoom[4];
		doors = new Door[4];
		setDirections();
	}

	/**
	 * for every door in doors[], appends a string to 'directions' describing the actions.
	 * for example:
	 *  "there is a door to the north"
	 *
	 *If there are no doors at all, directions should say:
	 * "There are no doors, you're trapped."
	 */
	public void setDirections() {
		directions = "";
		boolean doorFound = false;
		for (int i = 0; i < doors.length; i++)
		{
			if (doors[i]==null)
			{
				continue;
			}
			else
			{
				doorFound = true;
				directions = directions + "\n  You are able to go to "+toDirection(i)+" via a "+doors[i].getDescription()+". "+doors[i].getDetails();;
			}
			if (!doorFound)
			{
				directions = "Way to go dude, you're stuck.";
			}
		}
	}

	/**
	 * converts an int into a direction
	 * for example:
	 * toDirection (0) --> "the North"
	 * @param dir
	 * @return
	 */
	public static String toDirection(int dir) {
		String[] directions = {"the North", "the East", "the South", "the West"};
		return directions[dir];
	}
	
	public void enter() {
		contents = "X";
	}

	public void leave() {
		contents = defaultContents;
	}
	
	// give this room access to another room and vice versa
	// and sets a door btwn them, updating the directions
	public void setConnection(int direction, CaveRoom anotherRoom, Door door) {
		addRoom(direction, anotherRoom, door);
		anotherRoom.addRoom(oppositeDirection(direction), this, door);
	}
	public static int oppositeDirection(int direction) {
		// TODO Auto-generated method stub
		return (direction + 2)%4;
	}

	public void addRoom(int direction, CaveRoom cave, Door door) {
		// TODO Auto-generated method stub
		borderingRooms[direction] = cave;
		doors[direction] = door;
		setDirections();
	}
	
	public void interpretInput(String input) {
		while(!isValid(input)) {
			System.out.println("You can only enter 'w','a','s', or 'd'.");
			input = CaveExplorer.in.nextLine();
		}
		//task : convert user input into a direction
		//DO NOT USE AN IF STATEMENT -- IF YOU MUST, USE ONLY 1
		String dirs = "wdsa";
		goToRoom(dirs.indexOf(input));
	}

	private void goToRoom(int direction) {
		// TODO Auto-generated method stub
		// (user cannot go thru non-existent door)
		if(borderingRooms[direction] != null && doors[direction] != null) {
			CaveExplorer.currentRoom.leave();
			CaveExplorer.currentRoom = borderingRooms[direction];
			CaveExplorer.currentRoom.enter();
			CaveExplorer.inventory.updateMap();
		}
	}
	//This will be where your group sets up all the caves and all the connections
	public static void setUpCaves() {
		//ALL OF THIS CODE CAN BE CHANGED
		// 1. Decide how big your caves should be
		CaveExplorer.caves = new CaveRoom[5][5];
		//2, Populate with caves and a default description : hint : when starting, use coordinates
		
		for(int row = 0;row<CaveExplorer.caves.length;row++) {
			for(int col = 0; col < CaveExplorer.caves[row].length;col++) {
				// create a "default" cave
				CaveExplorer.caves[row][col] = new CaveRoom("This cave has coords ("+row+","+col+")");
			}
		}
		//3. Replace default rooms with custom rooms
		// ---- WE WILL DO LATER
		
		//4. Set your starting room
		CaveExplorer.currentRoom = CaveExplorer.caves[0][1];
		CaveExplorer.currentRoom.enter();
		CaveRoom[][] c = CaveExplorer.caves;
		c[0][1].setConnection(SOUTH, c[1][1], new Door());
		//5. Set up doors
	}

	private boolean isValid(String input) {
		// TODO Auto-generated method stub
		String validEntries = "wdsa";
		return validEntries.indexOf(input) > -1 && input.length() == 1;
	}

	public String getDescription() {
		return description + "\n" + directions;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public void setDefaultContents(String defaultContents) {
		this.defaultContents = defaultContents;
	}

	
	
}