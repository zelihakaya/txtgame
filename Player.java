package adventuregame;

import java.util.Scanner;

public class Player {
	private int health, damage, money, originalHealth;
	private String username, charName;
	private Inventory inv;
	Scanner scan = new Scanner(System.in);
	
	public Player(String username) {
		super();
		this.username = username;
		this.inv = new Inventory();
	}
	
	public void selectChar() {
		switch(charMenu()) {
		case 1: 
			initPlayer("Samurai", 5, 21, 15);
			/*setCharName("Samurai");
			setDamage(5);
			setHealth(21);
			setMoney(15);*/
			break;
		case 2: 
			initPlayer("Archer", 7, 18, 20);
			break;
		case 3: 
			initPlayer("Knight", 8, 24, 5);
			break;
		default:
			initPlayer("Samurai", 5, 21, 15);
			break;
		}
		
		System.out.println("Your character is created: "+ getCharName() + "\t Damage: " + getDamage() + 
				"\t Health: " + getHealth() + "\t Money: " +getMoney() );
		//System.out.println(this.toString());
	}
	
	public int charMenu() {
		System.out.println("Please select a character by typing it's number");
		System.out.println("1- Character Type: Samurai \t Damage: 5 \t Health: 21 \t Money: 15");
		System.out.println("2- Character Type: Archer \t Damage: 7 \t Health: 18 \t Money: 20");
		System.out.println("3- Character Type: Knight \t Damage: 8 \t Health: 24 \t Money:  5");
		System.out.println("Please write the number of your character choice: ");
		int charID = scan.nextInt();
		
		while(charID < 1 || charID > 3) {
			System.out.println("Please write a valid character number!");
			charID = scan.nextInt();
		}
		return charID;
	}
	
	public int getTotalDamage() {
		return this.getDamage() + this.getInv().getDamage();
	}
	
	
	public void initPlayer(String charName, int dmg, int health, int money) {
		setCharName(charName);
		setDamage(dmg);
		setHealth(health);
		setMoney(money);
		setOriginalHealth(health);
	}
	

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCharName() {
		return charName;
	}

	public void setCharName(String charName) {
		this.charName = charName;
	}

	public Inventory getInv() {
		return inv;
	}

	public void setInv(Inventory inv) {
		this.inv = inv;
	}

	public int getOriginalHealth() {
		return originalHealth;
	}

	public void setOriginalHealth(int originalHealth) {
		this.originalHealth = originalHealth;
	}
	
	
	
	
}
