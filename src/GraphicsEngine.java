import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.Timer;


public class GraphicsEngine extends Component implements ActionListener, MouseListener, MouseMotionListener
{
	private Timer t;
	private Player p;
	
	public GraphicsEngine()
	{
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		p = new Player();
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
		p.drawHand(g);
		
	}

	public void actionPerformed(ActionEvent e) 
	{
		update();
	}

	public void mouseDragged(MouseEvent e)
	{

	}

	public void mouseMoved(MouseEvent e)
	{

	}

	public void mouseClicked(MouseEvent e)
	{

	}

	public void mouseEntered(MouseEvent e)
	{

	}

	public void mouseExited(MouseEvent e)
	{

	}

	public void mousePressed(MouseEvent e)
	{

	}

	public void mouseReleased(MouseEvent e)
	{

	}
}
