import java.awt.Graphics;
import java.util.ArrayList;
import com.sun.javafx.tk.Toolkit;

public class Player
{
	private Deck d;
	private ArrayList<Card> hand, graveyard;
	private ArrayList<Minion> field;
	private int currentMana, maxMana;
	
	public Player() {
		d = new Deck();
		hand = new ArrayList<Card>();
		graveyard = new ArrayList<Card>();
		draw();
		draw();
		draw();
		draw();
		draw();
		draw();
	}

	public void startGame() {
		currentMana = 0;
		d.shuffle();
		hand.add(d.draw());
	}

	public void startTurn()
	{
		if (maxMana < 5) maxMana++;
		currentMana = maxMana;
		hand.add(d.draw());
	}
	
	public void draw()
	{
		hand.add(d.draw());
	}
	
	public void drawHand(Graphics g, int width)
	{
		for (int i = 0; i < hand.size(); i++)
		{
			hand.get(i).paint(g, width/10+width/10*i*4/hand.size(), 800, width/20, (int) (width/20/Card.aspectRatio));
		}
	}
	
	public void activate(int index)
	{
		Card c = hand.get(index);
		if (c.getMyCost()<currentMana) c.activate();
	}

}
