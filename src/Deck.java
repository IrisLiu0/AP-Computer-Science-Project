import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> myDeck;

	public Deck() {
		myDeck = new ArrayList<Card>();
		myDeck.addAll(Arrays.asList(new Spell("Weaken", 1, 0), new Minion("Ego-bloated Blob", 1, 1, 1, 1),
				new Minion("Supportive Blob", 2, 2, 2, 2), new Minion("Cruel Blob", 2, 3, 2, 2),
				new Spell("Drain Life", 3, 4), new Spell("Deadly Shot", 3, 5), new Minion("Healthy Blob", 3, 6, 3, 3),
				new Minion("Sneaky Blob", 3, 7, 4, 2), new Spell("Panem et Circenses", 3, 8),
				new Minion("Absolute Beefcake", 4, 9, 2, 7)));
	}

	public Deck(Card[] cList) {
		//myDeck.addAll(Arrays.asList(cList));
	}

	public void shuffle() {
		Collections.shuffle(myDeck);
	}

	public Card draw() {
		return myDeck.remove(0);
	}
	
	public int getSize()
	{
		return myDeck.size();
	}
}
