import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

public class Enemy {

	private ArrayList<Minion> field;

	public Enemy() {
		field = new ArrayList<Minion>();
		field.addAll(Arrays.asList(new Minion("Pleb", 0, 10, 1, 2), new Minion("Pleb", 0, 10, 1, 2),
				new Minion("Pleb", 0, 10, 1, 2), new Minion("Pleb", 0, 10, 1, 2), new Minion("Pleb", 0, 10, 1, 2)));
	}

	public void attack(Player p) {
		for (Minion m : field) {
			p.changeLife(1);
		}
	}

	public void paint(Graphics g, int width) {
		g.setFont(new Font("ARIAL", 50, 50));
		for (int i = 0; i < field.size(); i++) {
			field.get(i).paint(g, width / 2 - (width / 20) * (field.size()) + width / 10 * i, 125, width / 10,
					(int) (width / 10 / Card.aspectRatio));
			g.drawString(field.get(i).getAttack() + "/" + field.get(i).getDefense(),
					width / 2 - (width / 20) * (field.size()) + width / 10 * i + 60, 125 + 240);
		}
	}

	public boolean isDead() {
		if (field.size() == 0)
			return true;
		return false;
	}

	public ArrayList<Minion> getField() {
		return field;
	}
}
