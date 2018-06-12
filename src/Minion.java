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
			super.setImg("Pictures//Sneak Blob.png");
			break;
		case 9:
			super.setImg("Pictures//Absolute Beefcake.png");
			break;
		}
		System.out.println(id);
	}

	public void activate(Player p) {

	}

	public void hpUp(Minion target, int x) {
		target.setDefense(target.getDefense() + 1);
	}

	public void trade(Minion target, int hp, int dmg) {
		target.setAttack(target.getAttack() + dmg);
		target.setDefense(target.getDefense() - hp);
	}

}