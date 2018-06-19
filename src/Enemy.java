import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;

public class Enemy {

	private static ArrayList<Minion> field;

	public Enemy() {
		field = new ArrayList<Minion>();
		field.addAll(Arrays.asList(new Minion("Pleb", 0, 10, 1, 2), new Minion("Pleb", 0, 10, 1, 2),
				new Minion("Pleb", 0, 10, 1, 2), new Minion("Pleb", 0, 10, 1, 2), new Minion("Pleb", 0, 10, 1, 2)));
	}

	public void startGame() {

	}

	public void startTurn() {
		if (Math.random() * 2 > 0)
			;
	}

	public void paint(Graphics g, int width) {
		g.setFont(new Font("ARIAL", 50,50));
		for (int i = 0; i < field.size(); i++) {
			field.get(i).paint(g, width / 2 - (width / 20) * (field.size()) + width / 10 * i, 125, width / 10,
					(int) (width / 10 / Card.aspectRatio));
			g.drawString(field.get(i).getAttack() + "/" + field.get(i).getDefense(), width / 2 - (width / 20) * (field.size()) + width / 10 * i+60, 125+240);
		}
	}

	public boolean isDead() {
		if (field.size() == 0)
			return true;
		return false;
	}

	public void attack(Player p, Minion e) {
		for (Minion m : field) {
			if (p.getField().size() == 0) {
				p.changeLife(e.getAttack() * -1);
			} else {
				Minion target = p.getRandomMinion();
				m.fight(target);
				if (m.getDefense() <= 0)
					destroyCard(m);
				if (target.getDefense() <= 0)
					destroyCard(target);
			}
		}

	}

	public static ArrayList<Minion> getField() {
		return field;
	}

	public void destroyCard(Card c) {
		// Code should remove c from the field and move it to the graveyard
	}

}
