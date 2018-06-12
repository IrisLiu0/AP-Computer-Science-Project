import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.Timer;

public class GraphicsEngine extends Component implements ActionListener, MouseListener, MouseMotionListener {
	private Timer t;
	private Player p;
	private Enemy e;
	private Gaem loop;
	private Image back; 

	public GraphicsEngine() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		back = new ImageIcon("src//Pictures//TestBackground.jpg").getImage();
		p = new Player();
		e = new Enemy();
		loop = new Gaem(p, e);
		t = new Timer(10, this);
		t.start();
	}

	private void update()
	{
		//loop.gameLoop();
		repaint();
	}
	
	public void paint(Graphics g)
	{
		//g.fillRect(0, 0, this.getWidth(), this.getHeight());
		/*switch (loop.checkWin())
		{
		
		}*/
		g.drawImage(back, 0, 0, this.getWidth(), this.getHeight(), null);
		p.drawHand(g, this.getWidth());
		e.paint(g, getWidth());
	}

	public void actionPerformed(ActionEvent e) {
		update();
	}

	public void mouseDragged(MouseEvent e) {

	}

	public void mouseMoved(MouseEvent e) {
		p.hovering(e.getX(), e.getY(), this.getWidth());
	}

	public void mouseClicked(MouseEvent e) {

	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {
		p.select(e.getX(), e.getY(), this.getWidth());
	}
}
