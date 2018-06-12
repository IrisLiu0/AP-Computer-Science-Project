import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import com.sun.javafx.tk.Toolkit;

public class Player
{
	private Deck d;
	private ArrayList<Card> hand, graveyard;
	private ArrayList<Minion> field;
	private int currentMana, maxMana;
	private int life;
	private int hover=-1, selected=-1;
	
	public Player() {
		d = new Deck();
		hand = new ArrayList<Card>();
		graveyard = new ArrayList<Card>();
		life = 15;
		draw(4);
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
	
	public void draw(int num)
	{
		for (int i = 0; i < num && hand.size()<5; i++)
		hand.add(d.draw());
	}
	
	public void drawHand(Graphics g, int width)
	{
		for (int i = 0; i < hand.size(); i++)
		{
			hand.get(i).paint(g, width/2-(width/16)*(hand.size())+width/8*i, 800, width/8, (int) (width/8/Card.aspectRatio));
		}
		g.setColor(new Color(50,50,50,100));
		if (hover!=-1) g.fillRect(width/2-(width/16)*(hand.size())+width/8*hover, 800, width/8, (int) (width/8/Card.aspectRatio));
		g.setColor(new Color(50,50,50,150));
		if (selected!=-1) g.fillRect(width/2-(width/16)*(hand.size())+width/8*selected, 800, width/8, (int) (width/8/Card.aspectRatio));

	}
	
	public void activate(int index)
	{
		Card c = hand.get(index);
		if (c.getMyCost()<currentMana) c.activate();
	}
	
	public void hovering(int x, int y, int width)
	{
		for (int i = 0; i < hand.size(); i++)
		{
			if(width/2-(width/16)*(hand.size())+width/8*i<x && 800<y && width/2-(width/16)*(hand.size())+width/8*i + width/8>x && (int) (width/8/Card.aspectRatio)+800>y)
			{
				hover = i;
			}
		}
	}
	
	public void select(int x, int y, int width)
	{
		for (int i = 0; i < hand.size(); i++)
		{
			if(width/2-(width/16)*(hand.size())+width/8*i<x && 800<y && width/2-(width/16)*(hand.size())+width/8*i + width/8>x && (int) (width/8/Card.aspectRatio)+800>y)
			{
				if (hover == i) selected = i;
				else selected = -1;
			}
		}
	}
	
	public int getLife()
	{
		return life;
	}
	
	public void changeLife(int c)
	{
		life += c;
	}

}
