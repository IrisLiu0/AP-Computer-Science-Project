import java.awt.Image;

import javax.swing.ImageIcon;

public class Minion extends Card {
	private int atk, def;

	public Minion(String name, int cost, int id, int atk, int def) {
		super(name, cost, id);
		this.atk = atk;
		this.def = def;
		init(id);
	}

	public int getAttack() {
		return atk;
	}

	public int getDefense() {
		return def;
	}

	public void setAttack(int atk) {
		this.atk = atk;
	}

	public void setDefense(int def) {
		this.def = def;
	}

	private void init(int id) {
		switch (id) {
		case 1:
			super.setImg("Pictures//Ego-bloated Blob.png");
			break;
		case 2:
			super.setImg("Pictures//Supportive Blob.png");
			break;
		case 3:
			super.setImg("Pictures//Cruel Blob.png");
			break;
		case 6:
			super.setImg("Pictures//Healthy Blob.png");
			break;
		case 7:
			super.setImg("Pictures//Sneaky Blob.png");
			break;
		case 9:
			super.setImg("Pictures//Absolute Beefcake.png");
			break;
		}
		System.out.println(id);
	}

	public void activate(int id, Minion target) {
		Effects e = new Effects();
		switch (id) {
		case 1:
			// allow it to attack when it is played
			break;
		case 2:
			// access minion array, give each +1 health

			break;
		case 3:
			e.atkUp(target, 2);
			e.dmg(target, 1);
			break;
		case 6:
			e.hpUp(target, 3);
			break;
		case 7:
			// make it untargetable by the enemy
			break;
		}
	}

	public void fight(Minion target) {
		this.setDefense(this.getDefense() - target.getAttack());
		target.setDefense(target.getAttack() - this.getDefense());
		// must implement death in player and enemy classes, activated by a
		// check after fight is executed
	}

}