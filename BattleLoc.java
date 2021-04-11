package adventuregame;

public abstract class BattleLoc extends Location{
	protected Monster monster;
	protected String award;
	
	
	BattleLoc(Player player, String name, Monster monster, String award) {
		super(player);
		// TODO Auto-generated constructor stub
		this.monster = monster;
		this.name = name;
		this.award = award;
	}
	
	public boolean getLocation() {
		int monsCount = monster.count();
		System.out.println("Now you are in this location: " + this.getName());
		System.out.println("Be careful!");
		System.out.println("There are " + monsCount + " " + monster.getName() +"s here.");
		System.out.println("Press 'F' to fight");
		System.out.println("Press 'E' to escape");
		String selectCase = scan.next();
		selectCase = selectCase.toUpperCase();
		if (selectCase.equals("F")) {
			if(fight(monsCount)) {
				System.out.println("You have defeated all enemies in " +this.getName());
				if(this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println("You won " + this.award);
					player.getInv().setFood(true);
				}else if(this.award.equals("FireWood") && player.getInv().isFirewood() == false) {
					System.out.println("You won " + this.award);
					player.getInv().setFirewood(true);
				}else if(this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println("You won " + this.award);
					player.getInv().setWater(true);
				}
				return true;
			}
			if(player.getHealth() <= 0) {
				System.out.println("You died :( ");
			}
		}
		return true;
	}
	
	public boolean fight(int monsCount) {
		for (int i = 0; i < monsCount; i++) {
			int monsterDefaultHealth  = monster.getHealth();
			playerStats();
			enemyStats();
			while(player.getHealth() > 0 && monster.getHealth() > 0 ){
				System.out.println("Press 'F' to fight");
				System.out.println("Press 'E' to escape");
				String selectCase = scan.next();
				selectCase = selectCase.toUpperCase();
				if(selectCase.equals("F")) {
					System.out.println("You have choosen to fight");
					monster.setHealth(monster.getHealth() - player.getTotalDamage());
					statsAfterFight();
					System.out.println();
					if(monster.getHealth() > 0) {
						System.out.println("Monster hit you");
						player.setHealth(player.getHealth() - (monster.getDamage()- player.getInv().getArmor()));
						statsAfterFight();
					}
					//System.out.println("Player's health: " + player.getHealth());
					//System.out.println("Monsters health: " + monster.getHealth());
					System.out.println();	
				}else {
					return false;
				}
				
			}
			
			if (monster.getHealth() < player.getHealth()) { 
				System.out.println("You defeated the enemy");
				player.setMoney(player.getMoney() + monster.getAward());
				System.out.println("Your current money: " + player.getMoney());
				monster.setHealth(monsterDefaultHealth);
			}else {
				return false;
			}
			
			System.out.println("-----");
			System.out.println();
		}
		return true;
	}
	
	public void playerStats() {
		System.out.println("Player stats:      -------- ");
		System.out.println(player.getCharName());
		System.out.println("Health: " + player.getHealth());
		System.out.println("Damage: " + player.getTotalDamage());
		System.out.println("Money: " + player.getMoney());
		if(player.getInv().getDamage() > 0 ) {//damageý varsa silahý da var
			System.out.println("Weapon: " + player.getInv().getWeaponName());
		}
		if(player.getInv().getArmor() > 0 ) {
			System.out.println("Armor: " + player.getInv().getArmorName());
		}
		System.out.println();
	}
	
	public void enemyStats() {
		System.out.println("Enemy stats:       -------- ");
		System.out.println(monster.getName());
		System.out.println("Health: " + monster.getHealth());
		System.out.println("Damage: " + monster.getDamage());
		System.out.println("Award : " + monster.getAward());
	}
	
	public void statsAfterFight() {
		System.out.println("Player's health: " + player.getHealth());
		System.out.println("Monsters health: " + monster.getHealth());
	}
	
}
