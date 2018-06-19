import java.util.ArrayList;

public class Minion extends Card {
	private int atk, def;
	private boolean stun = true;

	public Minion(String name, int cost, int id, int atk, int def) {
		super(name, cost, id);
		this.atk = atk;
		this.def = def;
		init(id);
	}

	public void setStun(boolean stun) {
		this.stun = stun;
	}

	public boolean getStun() {
		return stun;
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
		case 10:
			super.setImg("Pictures//Pleb.png");
			break;
		}
		super.setType(-1);
		System.out.println(id);
	}

	public void activate(ArrayList<Minion> field) {
		Effects e = new Effects();
		switch (this.getMyID()) {
		case 2:
			for (int i = 0; i < field.size(); i++) {
				field.get(i).setAttack(field.get(i).getAttack() + 1);
			}
			break;
		case 3:
			Minion m = field.get((int) (Math.random() * field.size()));
			e.dmg(m, 1);
			e.atkUp(m, 2);
			break;
		}
	}

	public void activate(Minion m, Player p) {
		Effects e = new Effects();
		if (this.getMyID() == 6)
			e.heal(p, 3);
	}

	public void fight(Minion target) {
		this.setDefense(this.getDefense() - target.getAttack());
		target.setDefense(target.getDefense() - this.getAttack());
	}

}