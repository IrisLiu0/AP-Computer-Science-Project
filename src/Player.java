import java.awt.Graphics;
import java.util.ArrayList;

public class Player {
	private Deck d;
	private ArrayList<Card> hand, graveyard;
	private ArrayList<Minion> field;
	private int currentMana;

	public Player() {
		d = new Deck();
		hand = new ArrayList<Card>();
		graveyard = new ArrayList<Card>();
	}

	public void startGame() {
		currentMana = 0;
		d.shuffle();
		hand.add(d.draw());
	}

	public void startTurn() {
		if (currentMana < 5)
			currentMana++;
		hand.add(d.draw());
	}

	public void drawHand(Graphics g) {

	}

}
