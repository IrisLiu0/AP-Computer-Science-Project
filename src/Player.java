import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import com.sun.javafx.tk.Toolkit;
import javax.swing.JOptionPane;

public class Player {
	private Deck d;
	private ArrayList<Card> hand, graveyard;
	private ArrayList<Minion> field;
	private int currentMana, maxMana;
	private int life;
	private int hover = -1, selected = -1;
	private boolean isSelecting = false;
	private boolean isTakingTurn = false;

	public Player() {
		field = new ArrayList<Minion>();
		d = new Deck();
		hand = new ArrayList<Card>();
		graveyard = new ArrayList<Card>();
		life = 15;
		maxMana =1;
		draw(4);
	}

	public ArrayList<Minion> getField() {
		return field;
	}

	public Minion getRandomMinion() {
		return field.get((int) (Math.random() * field.size()));
	}

	public void startGame() {
		currentMana = 0;
		d.shuffle();
		hand.add(d.draw());
	}

	public void startTurn() {
		if (maxMana < 5)
			maxMana++;
		currentMana = maxMana;
		hand.add(d.draw());
		
		
		while(true) {
			isTakingTurn = true;
			
			Object[] Options = {"Minion", "Card", "None"};
		
			int option = JOptionPane.showOptionDialog(null, "Please select one", "Selection",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
					null, Options,null);
		
			if(option ==  JOptionPane.CLOSED_OPTION || option == 2) {
				isTakingTurn = false;
				break;
			
			}
			else if(option == 1) {
				isSelecting = true;
				selected = -1;
				
				// Display text prompting player to select a card to play from their
				// hand
				
				// Code to wait for player to select a card in hand, then activate
				// selected card once selected (use .activate and .select methods)
				while (selected != -1) {
					
				}
				isSelecting = false;
				
				this.activate(selected);
				selected = -1;
			
			}
			else {
				Options = (Object[])field.toArray();	
				
			
			}
			}
			
		
		// Loop below lines until NONE is selected
		// Display text prompting player to select a minion to attack, or select
		// NONE
		
		// Code to wait for player to select a minion or NONE button
		// If minion selected:
		// Display text prompting player to select an enemy minion as target
		// Code to wait for player to select an enemy minion
		// Selected player minion uses the .fight method with the target as an
		// argument
		// Check defense of both minions, if either one is dead use the
		// .destroyCard method in either the player or enemy class to move it
		// from the field to the graveyard
		// If player minion survives, disable its ability to attack again this
		// turn
	}

	public void draw(int num) {
		for (int i = 0; i < num && hand.size() < 5; i++)
			hand.add(d.draw());
	}

	public void drawHand(Graphics g, int width) {
		for (int i = 0; i < hand.size(); i++) {
			hand.get(i).paint(g, width / 2 - (width / 16) * (hand.size()) + width / 8 * i, 800, width / 8,
					(int) (width / 8 / Card.aspectRatio));
		}
		g.setColor(new Color(50, 50, 50, 100));
		if (hover != -1)
		{
			g.fillRect(width / 2 - (width / 16) * (hand.size()) + width / 8 * hover, 800, width / 8,
					(int) (width / 8 / Card.aspectRatio));
			hand.get(hover).paint(g, width/20, 150, width/5, (int) (width/5/Card.aspectRatio));
		}
		g.setColor(new Color(50, 50, 50, 150));
		if (selected != -1)
		{
			g.fillRect(width / 2 - (width / 16) * (hand.size()) + width / 8 * selected, 800, width / 8,
					(int) (width / 8 / Card.aspectRatio));
		}
		if(isSelecting == true) {
		g.drawString("Please select a card to play.",0,0);		
		}	
		

	}
	
	public void drawField(Graphics g, int width)
	{
		for (int i = 0; i < field.size(); i++) {
			field.get(i).paint(g, width / 2 - (width / 20) * (field.size()) + width / 10 * i, 500, width / 10,
					(int) (width / 10 / Card.aspectRatio));
		}
	}
	
	public void displayMana(Graphics g, int width)
	{
		g.setColor(new Color(200,200,200));
		g.fillRect(width-310, 825, 275, 200);
		g.setColor(Color.BLACK);
		g.setFont(new Font("ARIAL", 80,80));
		g.drawString(currentMana+"/"+maxMana, width-300, 900);
		g.drawString("HP: "  +life, width-300, 1000);
	}

	public void activate(int index) {
		Card c = hand.get(index);
		if (c.getMyCost() < currentMana)
			c.activate();
	}

	public void hovering(int x, int y, int width) {
		for (int i = 0; i < hand.size(); i++) {
			if (width / 2 - (width / 16) * (hand.size()) + width / 8 * i < x && 800 < y
					&& width / 2 - (width / 16) * (hand.size()) + width / 8 * i + width / 8 > x
					&& (int) (width / 8 / Card.aspectRatio) + 800 > y) {
				hover = i;
			}
		}
	}

	public void select(int x, int y, int width) {
		for (int i = 0; i < hand.size(); i++) {
			if (width / 2 - (width / 16) * (hand.size()) + width / 8 * i < x && 800 < y
					&& width / 2 - (width / 16) * (hand.size()) + width / 8 * i + width / 8 > x
					&& (int) (width / 8 / Card.aspectRatio) + 800 > y) {
				if (hover == i)
					selected = i;
				else
					selected = -1;
			}
		}
		if (y<800 && selected != -1)
		{
			Card c = hand.get(selected);
			switch (c.getType())
			{
			case -1:
				field.add((Minion) c);
				hand.remove(selected);
			case 0:
				c.activate();
				break;
			}
			selected = -1;
		}
	}
	// Modify to return selected card

	public int getLife() {
		return life;
	}

	public void changeLife(int c) {
		life -= c;
	}

	public void destroyCard(Card c) {
		// Code should remove c from the field and move it to the graveyard
	}

}
