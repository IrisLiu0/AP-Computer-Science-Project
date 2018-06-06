import java.awt.Graphics;


public class Card {

	private int myCost, myID;
	private String myName;
	public static int WEAKEN = 0, EGO_BLOB = 1, SUPPORT_BLOB = 2, CRUEL_BLOB = 3, DRAIN_LIFE = 4, DEADLY_SHOT = 5, HEALTHY_BLOB = 6, SNEAKY_BLOB = 7, BREAD = 8, UNIT = 9;
	

	public Card(String name, int cost, int id) 
	{
		myName = name;
		myCost = cost;
		myID = id;
	}

	public int getCost() {
		return myCost;
	}
	
	public void paint(Graphics g, int x, int y, int width, int height)
	{
		g.drawRect(x,y,width,height);
		g.drawString(myName, x+10, y+10);
	}
}
