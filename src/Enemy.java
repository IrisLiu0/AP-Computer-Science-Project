
public class Enemy {

	private Deck myDeck;

	public Enemy() {
		Card[] enemies = {};
		myDeck = new Deck(enemies);
	}

	public void startGame() 
	{

	}
	
	public void startTurn() 
	{
		
	}
	
	public boolean isDead()
	{
		if (myDeck.getSize() == 0) return true;
		return false;
	}

}
