public class inventory {
	public static int consoles = 23; //generating data for simulation purposes
	public static int games = 121;
	public static int controllers = 42;
	public static int accessories = 56;
	public static int memoribilia = 32;
	
	public static void addConsole (int aC){ //add console
		consoles = consoles + aC;
	}
	
	public static void addGames (int aG){ //add games
		games = games + aG;
	}
	
	public static void addControllers (int aCo){ //add controllers
		controllers = controllers + aCo;
	}
    
	public static void addAccessories (int aA){ //add accessories
		accessories = accessories + aA;
	}
	
	public static void addMemoribilia (int aM){ //add memoribilia
		memoribilia = memoribilia + aM;
	}
	
	public static void removeConsole (int aC){ //remove console
		consoles = consoles - aC;
	}
	
	public static void removeGames (int aG){ //remove games
		games = games - aG;
	}
	
	public static void removeControllers (int aCo){ //remove controllers
		controllers = controllers - aCo;
	}
	
	public static void removeAccessories (int aA){ //remove accessories
		accessories = accessories - aA;
	}
	
	public static void removeMemoribilia (int aM){ //remove memoribilia
		memoribilia = memoribilia - aM;
	}
	
	public static void getInventory() { //inventory system
	System.out.println("\nConsoles: " + consoles + 
						"\nGames: " + games + 
						"\nControllers: " + controllers + 
						"\nAccessories: " + accessories + 
						"\nMemoribilia: " + memoribilia);
	}
}