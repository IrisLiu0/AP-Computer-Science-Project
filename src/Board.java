import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Board extends JFrame 
{

	JPanel settingButton = new JPanel();
	JButton setting;

	JFrame exit = new JFrame();
	JButton exitYes = new JButton("Yes"), exitNo = new JButton("No");

	public Board() {

		add(new GraphicsEngine());
		this.setResizable(false);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setUndecorated(true);
		this.setVisible(true);

	}

	public static void main(String[] args) 
	{
		Board bb = new Board();
	}

}
