package adventuregame;

public class ToolStore extends NormalLoc{

	ToolStore(Player player) {
		super(player, "Shop");
		// TODO Auto-generated constructor stub
	}
	
	public boolean getLocation() {
		System.out.println();
		System.out.println("----------");
		System.out.println("Please select by typing the number");
		System.out.println("Money: " + player.getMoney());
		System.out.println("1. Weapons");
		System.out.println("2. Armors");
		System.out.println("3. Exit");
		int selectTool = scan.nextInt();
		int selectItemID;
		switch (selectTool) {
		case 1:
			selectItemID = weaponMenu();
			buyWeapon(selectItemID);
			break;
		case 2:
			selectItemID = armorMenu();
			buyArmor(selectItemID);
			break;
		default:
			break;
		}
		
		return true;
	}

	public int armorMenu() {
		System.out.println("Select an armor to purchase");
		System.out.println("1. Light Armor  \t Price: 15 \t Damage : 1");
		System.out.println("2. Medium Armor \t Price: 25 \t Damage : 3");
		System.out.println("3. Heavy Armor  \t Price: 40 \t Damage : 5");
		System.out.println("4. Exit");
		int selectArmorID = scan.nextInt();
		return selectArmorID;
	}
	
	public void buyArmor(int itemID) {
		int avoidDamage = 0, price = 0;
		String armorName  = null;
		switch (itemID) {
		case 1:
			armorName = "Light Armor";
			avoidDamage = 1;
			price = 15;
			break;
		case 2:
			armorName = "Medium Armor";
			avoidDamage = 3;
			price = 25;
			break;
		case 3:
			armorName = "Heavy Armor";
			avoidDamage = 5;
			price = 40;
			break;
		case 4:
			System.out.println("Exited");
			break;
		default: 
			System.out.println("Invalid number!");
			break;
	}
		 if(price > 0) {
			if(player.getMoney() >= price) {
				player.getInv().setArmor(avoidDamage);
				player.getInv().setArmorName(armorName);
				player.setMoney(player.getMoney() - price); //kalan parasi
				System.out.println("You have purchased a " + armorName );
				System.out.println("Damage you avoid:  " + player.getInv().getArmor());
				System.out.println("Remaining money :  "+ player.getMoney());
			}else {
				System.out.println("You don't have enough money to purchase");
			}
	}
		
	
		
	}
	
	public int weaponMenu() {
		System.out.println("Select a weapon to purchase");
		System.out.println("1. Pistol \t Price: 25 \t Damage : 2");
		System.out.println("2. Sword  \t Price: 35 \t Damage : 3");
		System.out.println("3. Rifle  \t Price: 45 \t Damage : 7");
		System.out.println("4. Exit");
		int selectWeaponID = scan.nextInt();
		return selectWeaponID;
	}
	
	public void buyWeapon(int itemID) {
		int damage = 0, price = 0;
		String weaponName  = null;
		switch (itemID) {
		case 1:
			weaponName = "Pistol";
			damage = 2;
			price = 25;
			break;
		case 2:
			weaponName = "Sword";
			damage = 3;
			price = 35;
			break;
		case 3:
			weaponName = "Rifle";
			damage = 7;
			price = 45;
			break;
		case 4:
			System.out.println("Exited");
			break;
		default: 
			System.out.println("Invalid number!");
			break;
	}
		 if(price > 0) {
			if(player.getMoney() >= price) {
				player.getInv().setDamage(damage);
				player.getInv().setWeaponName(weaponName);
				player.setMoney(player.getMoney() - price); //kalan parasi
				System.out.println("You have purchased a " + weaponName );
				System.out.println("Your ex damage:  " + player.getDamage());
				System.out.println("Your new damage: " + (player.getTotalDamage()));
				System.out.println("Remaining money: "+ player.getMoney());
			}else {
				System.out.println("You don't have enough money to purchase");
			}
	}
		
	}
}
