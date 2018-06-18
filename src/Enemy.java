import java.awt.Graphics;
import java.util.ArrayList;

public class Enemy {

	private Deck myDeck;
	private ArrayList<Minion> field;

	public Enemy() {
		field = new ArrayList<Minion>();
		Card[] enemies = {};
		myDeck = new Deck(enemies);
	}

	public void startGame() {

	}

	public void startTurn() {
		if (Math.random() * 2 > 0)
			;
	}

	public void paint(Graphics g, int width) {
		if (field.size()>0)
			field.get(0).paint(g, width-80, 100, 160, (int)(160/Card.aspectRatio));
		for (int i = 1)
	}

	public boolean isDead() {
		if (myDeck.getSize() == 0)
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

	public void destroyCard(Card c) {
		// Code should remove c from the field and move it to the graveyard
	}

}
