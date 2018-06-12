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

	public void startGame() 
	{
		
	}
	
	public void startTurn() 
	{
		if(Math.random()*2 > 0);
	}
	
	public void paint(Graphics g, int width)
	{
		//field.get(0).paint(g, width-80, 100, 160, (int) (160/Card.aspectRatio));
	}
	
	public boolean isDead()
	{
		if (myDeck.getSize() == 0) return true;
		return false;
	}

}
