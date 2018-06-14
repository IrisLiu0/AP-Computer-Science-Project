
public class Spell extends Card {

	public Spell(String name, int cost, int id) {
		super(name, cost, id);
		init(id);
	}

	private void init(int id) {
		switch (id) {
		case 0:
			super.setImg("Pictures//Weaken.png");
			break;
		case 4:
			super.setImg("Pictures//Drain Life (1).png");
			break;
		case 5:
			super.setImg("Pictures//Deadly Shot.png");
			break;
		case 8:
			super.setImg("Pictures//Panem et Circenses.png");
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
			ee.defDown(target, 2);
			break;
		case 5:
			// idk how to do this one
			break;
		case 8:
			// or this one
			break;
		}
	}

	public void activate(int id, Player p) {
		Effects ee = new Effects();
		switch (id) {
		case 4:
			ee.heal(p, 2);
			break;
		}
	}

	public void summon() {

	}

	public void destroy() {

	}

}
