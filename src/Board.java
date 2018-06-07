
import javax.swing.JFrame;

public class Board extends JFrame
{

	public Board()
	{

		add(new GraphicsEngine());
		this.setResizable(false);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);

	}

	public static void main(String[] args) {
		Board bb = new Board();
	}

}
