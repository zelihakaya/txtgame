package adventuregame;

public class safeHouse extends NormalLoc {

	safeHouse(Player player) {
		super(player, "safeHouse");
		// TODO Auto-generated constructor stub
	}
	
	public boolean getLocation() {
		player.setHealth(player.getOriginalHealth());
		System.out.println("You are healed");
		System.out.println("Now you are in safe house");
		if(player.getInv().isFirewood() && player.getInv().isFirewood() && player.getInv().isWater()) {
			System.out.println("Congratulations");
			System.out.println("YOU WIN");
		}
		return true;
	}
	
	

}
