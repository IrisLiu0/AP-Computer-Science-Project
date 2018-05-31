import java.awt.Graphics;


public class Card {

	private int cost;
	private String type;

	public Card(String type) 
	{
		this.type=type;
	}

	public int getCost() {
		return cost;
	}
	
	public void paint(Graphics g, int x, int y, int width, int height)
	{
		g.drawRect(x,y,width,height);
		g.drawString(type, x+10, y+10);
	}
}
