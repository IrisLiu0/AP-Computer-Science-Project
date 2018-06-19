
public class Spell extends Card {

	public Spell(String name, int cost, int id) {
		super(name, cost, id);
		init(id);
	}

	private void init(int id) {
		switch (id) {
		case 0:
			super.setImg("Pictures//Weaken.png");
			super.setType(1);
			break;
		case 4:
			super.setImg("Pictures//Drain Life (1).png");
			super.setType(2);
			break;
		case 5:
			super.setImg("Pictures//Deadly Shot.png");
			super.setType(0);
			break;
		case 8:
			super.setImg("Pictures//Panem et Circenses.png");
			super.setType(0);
			break;
		}
	}

	public void activate(int id, Minion target) {
		Effects ee = new Effects();
		switch (id) {
		case 0:
			ee.defDown(target, 1);
			break;
		case 4:
			ee.dmg(target, 2);
			break;
		case 5:
			int rand = (int) Math.random() * Enemy.getField().size();
			break;
		case 8:
			Enemy.getField().size(); // idk what this is for
			break;
		}
	}

	public void activate(int id, Player p) {
		Effects ee = new Effects();
		if (id == 4)
			ee.heal(p, 1);

	}

	public void summon() {

	}

	public void destroy() {

	}

}
