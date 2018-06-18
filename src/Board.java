import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;

public class Board extends JFrame implements KeyListener {
	GraphicsEngine g;

	public Board() {
		g = new GraphicsEngine();
		addKeyListener(g);
		add(g);
		this.setResizable(false);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		Board b = new Board();
	}

	public void keyPressed(KeyEvent e) {
		g.keyPressed(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
