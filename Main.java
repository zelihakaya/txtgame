package adventuregame;

import java.util.Scanner;

public class Main {
	public static void main(String []args) {
		/*Scanner scan = new Scanner(System.in);
		System.out.println("Welcome to the adventure game");
		System.out.println("Please type your name:");
		String playerName = scan.nextLine();
		*/
		
		Game game = new Game();
		game.login();
	}
	
}
