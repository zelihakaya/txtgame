package adventuregame;

public abstract class NormalLoc extends Location{

	NormalLoc(Player player, String name) {
		super(player);
		// TODO Auto-generated constructor stub
		this.name = name;
	}
	
	public boolean getLocation() {
		return true;
	}
	
	
}
