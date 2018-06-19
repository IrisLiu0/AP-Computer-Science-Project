import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Player {
	private Deck d;
	private ArrayList<Card> hand;
	private static ArrayList<Minion> field;
	private int currentMana, maxMana;
	private int life;
	private int hover = -1, selected = -1;
	private boolean isSelecting = false;
	private boolean isTakingTurn = false;

	public Player() {
		field = new ArrayList<Minion>();
		d = new Deck();
		d.shuffle();
		hand = new ArrayList<Card>();
		life = 15;
		currentMana = 5;
		maxMana = 5;
		draw(5);
	}

	public static ArrayList<Minion> getField() {
		return field;
	}

	public Minion getRandomMinion() {
		return field.get((int) (Math.random() * field.size()));
	}

	public void startGame() {
		// currentMana = 0;
		d.shuffle();
		hand.add(d.draw());
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
		if (hover != -1) {
			g.fillRect(width / 2 - (width / 16) * (hand.size()) + width / 8 * hover, 800, width / 8,
					(int) (width / 8 / Card.aspectRatio));
			hand.get(hover).paint(g, width / 20, 150, width / 5, (int) (width / 5 / Card.aspectRatio));
		}
		g.setColor(new Color(50, 50, 50, 150));

		if (selected > -1) {
			g.fillRect(width / 2 - (width / 16) * (hand.size()) + width / 8 * selected, 800, width / 8,
					(int) (width / 8 / Card.aspectRatio));
		}
		if (isSelecting == true) {
			g.drawString("Please select a card to play.", 0, 0);
		}

	}

	public void drawField(Graphics g, int width) {
		g.setFont(new Font("ARIAL", 50,50));
		for (int i = 0; i < field.size(); i++) {
			field.get(i).paint(g, width / 2 - (width / 20) * (field.size()) + width / 10 * i, 500, width / 10,
					(int) (width / 10 / Card.aspectRatio));
			g.drawString(field.get(i).getAttack() + "/" + field.get(i).getDefense(), width / 2 - (width / 20) * (field.size()) + width / 10 * i+60, 740);
		}
		if (selected < -1) {
			g.setColor(new Color(50, 50, 50, 150));
			g.fillRect(width / 2 - (width / 20) * (field.size()) + width / 10 * (-2 - selected), 500, width / 10,
					(int) (width / 10 / Card.aspectRatio));
		}
	}

	public void displayMana(Graphics g, int width) {
		g.setColor(new Color(200, 200, 200));
		g.fillRect(width - 310, 825, 275, 200);
		g.setColor(Color.BLACK);
		g.setFont(new Font("ARIAL", 80, 80));
		g.drawString(currentMana + "/" + maxMana, width - 300, 900);
		g.drawString("HP: " + life, width - 300, 1000);

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

	public void select(int x, int y, int width, ArrayList<Minion> eField) {
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

		if (y < 800 && selected > -1) {
			Card c = hand.get(selected);
			if (c.getMyCost() <= currentMana) {
				switch (c.getType()) {
				case -1:
					if (field.size() == 5)
						break;
					field.add((Minion) c);
					hand.remove(selected);
				case 0:
					c.activate();
					currentMana -= c.getMyCost();
					break;
				default:
					for (int i = 0; i < eField.size(); i++) {
						System.out.println(x);
						if (x > width / 2 - (width / 20) * (field.size()) + width / 10 * (i) && y > 125 && x <  width / 2 - (width / 20) * (field.size()) + width / 10 * (i) + width/10 && y < 125 + (int) (width / 10 / Card.aspectRatio))
						{
							if (c.getType()==2) c.activate(eField.get(i), this);
							else
							c.activate(eField.get(i));
							currentMana -= c.getMyCost();
						}
					}
					break;
				}
				
			}
			selected = -1;
		} else if (y < 800 && y > 500) {

			for (int i = 0; i < field.size(); i++) {
				// field.get(i).paint(g, width / 2 - (width / 20) *
				// (field.size()) + width / 10 * i, 500, width / 10,
				// (int) (width / 10 / Card.aspectRatio));
				if (x > width / 2 - (width / 20) * (field.size()) + width / 10 * (i) && y > 500
						&& x < width / 2 - (width / 20) * (field.size()) + width / 10 * (i) + width / 10
						&& y < 500 + (int) (width / 10 / Card.aspectRatio)) {
					selected = -2 - i;
				}
			}
		}
		else if (y<500 && selected < -1)
		{
			for (int i = 0; i < eField.size(); i++)
			{
				if (x > width / 2 - (width / 20) * (field.size()) + width / 10 * (i) && y > 125 && x <  width / 2 - (width / 20) * (field.size()) + width / 10 * (i) + width/10 && y < 125 + (int) (width / 10 / Card.aspectRatio))
				{
					field.get(-2-selected).fight(eField.get(i));
					if (eField.get(i).getDefense() < 1) eField.remove(i);
					if (field.get(-2-selected).getDefense() <= 0) destroyCard(selected);			
				}
			}
		}
	}
	// Modify to return selected card

	public int getLife() {
		return life;
	}

	public void changeLife(int c) {
		life -= c;
	}

	public void destroyCard(int i) {
		// Code should remove c from the field and move it to the graveyard
		field.remove(-2-selected);
		selected = -1;
	}

}
