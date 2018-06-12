
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

	// wtf am I doing
	// I don't even really understand how this ripoff works
	// -Iris
	public void defDown(Minion target, int x) {
		target.setDefense(x);
	}

	public void trade(/* target */ int dmg, int heal) {
		/*
		 * how to target enemy instead of enemy minion? how to heal player?
		 */
	}

	public void summon() {
		/*
		 * count the enemies on the board summon more minions
		 */
	}

	public void destroy() {
		// how to count enemies????
	}

}
