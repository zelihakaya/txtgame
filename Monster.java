package adventuregame;

import java.util.Random;

public class Monster {
	private String name;
	private int damage, award, health, maxNum;
	
	public Monster(String name, int damage, int health, int award, int maxNum) {
		this.name = name;
		this.damage = damage;
		this.award = award;
		this.health = health;
		this.maxNum = maxNum;
	}

	public int count() {
		Random r = new Random();
		return r.nextInt(this.maxNum) + 1;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getAward() {
		return award;
	}

	public void setAward(int award) {
		this.award = award;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	
	
	
}
