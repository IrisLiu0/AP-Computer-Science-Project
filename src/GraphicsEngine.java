import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;


public class GraphicsEngine extends Component implements ActionListener
{
	private Timer t;
	private Card[] hand = new Card[5];
	
	public GraphicsEngine()
	{
		for (int i = 0; i < hand.length; i++)
		{
			hand[i] = new Card("Card "+i);
		}
		t = new Timer(10, this);
		t.start();
	}
	
	private void update()
	{
		repaint();
	}
	
	public void paint(Graphics g)
	{
		//g.fillRect(0, 0, this.getWidth(), this.getHeight());
		for (int i = 0; i < hand.length; i++)
		{
			hand[i].paint(g, 200+i*110, 800, 100, 120);
		}

	}

	public void actionPerformed(ActionEvent e) 
	{
		update();
	}
}
