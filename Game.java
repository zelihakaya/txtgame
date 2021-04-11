package adventuregame;

import java.util.Scanner;

public class Game {
	Player player;
	Location location;
	Scanner scan = new Scanner(System.in);
	
	public void login() {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the adventure game ");
		System.out.println("Please type your name:");
		//String playerName = scan.nextLine();
		player = new Player("zel");
		player.selectChar();
		start();
	}	
	
	public void start(){
		while (true) {
			System.out.println();
			System.out.println("----------------");
			System.out.println();
			System.out.println("Please choose a location to attend by typing its number");
			System.out.println("1. House : Safe place without any enemies");
			System.out.println("2. Cave  : You might see a zombie here");
			System.out.println("3. Forest: You might see a vampire here");
			System.out.println("4. River : You might see a bear here");
			System.out.println("5. Shop  : You can buy a weapon or armor here");
			int selectLoc = scan.nextInt();
			while(selectLoc < 1 || selectLoc > 5 ) {
				System.out.println("Please choose a valid location!");
				selectLoc= scan.nextInt();
			}
			
			switch (selectLoc) {
			case 1:
				location = new safeHouse(player);
				break;
			case 2:
				location = new Cave(player);
				break;
			case 3:
				location = new Forest(player);
				break;
			case 4:
				location = new River(player);
				break;
			case 5: 
				location = new ToolStore(player);
				break;
			default:
				location = new safeHouse(player);
				break;
			}
			
			if(location.getClass().getName().equals("safeHouse")) {
				if(player.getInv().isFirewood() && player.getInv().isFirewood() && player.getInv().isWater()) {
					System.out.println("Congratulations");
					System.out.println("YOU WIN");
					break;
				}
			}
			
			if (!location.getLocation()) {
				System.out.println("Game is over");
				break;
			}			
		}
	}
	
	
}
