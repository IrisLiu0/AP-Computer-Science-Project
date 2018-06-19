
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
		case 10:
			super.setImg("Pictures//Pleb.png");
			break;
		}
		super.setType(-1);
		System.out.println(id);
	}

	public void activate(int id, Minion target) {
		Effects e = new Effects();
		switch (id) {
		case 2:
			for (int i = 0; i < Player.getField().size(); i++) {
				Player.getField().get(i).setDefense(Player.getField().get(i).getDefense() + 1);
			}
			break;
		case 3:
			e.dmg(target, 1);
			e.atkUp(target, 2);
			break;
		}
	}

	public void activate(int id, Player p) {
		Effects e = new Effects();
		if (id == 6)
			e.heal(p, 3);

	}

	public void fight(Minion target) {
		this.setDefense(this.getDefense() - target.getAttack());
		target.setDefense(target.getDefense() - this.getAttack());
		// must implement death in player and enemy classes, activated by a
		// check after fight is executed
	}

}