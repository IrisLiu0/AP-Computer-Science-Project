import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> myDeck;

	public Deck() {
		ArrayList<Card> tempList = {new Spell("Weaken", 1, 0), new Minion("")};
		//Trying to work out how to make this array contain the list of cards described in the CARDS document (shared with your school accounts on the goog).
		myDeck = tempList;
	}

	public void shuffle() {

	}
}
