import java.util.ArrayList;

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

	public void activate(Minion target) {
		Effects ee = new Effects();
		switch (this.getMyID()) {
		case 0:
			ee.defDown(target, 1);
			break;
		case 4:
			ee.dmg(target, 2);
			break;
		}
	}

	public void activate(ArrayList<Minion> field) {
		switch (this.getMyID()) {
		case 5:
			field.remove((int) (Math.random() * field.size()));
			break;
		case 8:
			field.size();
			break;
		}
	}

	public void activate(Minion m, Player p) {
		Effects ee = new Effects();
		switch (this.getMyID()) {
		case 4:
			ee.heal(p, 1);
			ee.dmg(m, 2);
			break;
		}
	}
}
