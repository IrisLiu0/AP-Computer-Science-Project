import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Card {

	private int myCost, myID;
	private Image img;
	private String myName;
	private int type;

	public static double aspectRatio = 5.0 / 7.0;
	public static int WEAKEN = 0, EGO_BLOB = 1, SUPPORT_BLOB = 2, CRUEL_BLOB = 3, DRAIN_LIFE = 4, DEADLY_SHOT = 5,
			HEALTHY_BLOB = 6, SNEAKY_BLOB = 7, BREAD = 8, UNIT = 9;

	public Card(String name, int cost, int id) {
		myName = name;
		myCost = cost;
		myID = id;
	}

	public void paint(Graphics g, int x, int y, int width, int height) {
		g.drawImage(img, x, y, width, height, null, null);
	}

	public void activate() 
	{

	}
	
	public void activate(Minion m)
	{
		
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}

	public int getMyCost() {
		return myCost;
	}

	public int getMyID() {
		return myID;
	}

	public String toString() {
		return myName;
	}

	public void setImg(String loc) {
		img = new ImageIcon("src//" + loc).getImage();
	}

	public void activate(Minion minion, Player player) 
	{

	}

}
