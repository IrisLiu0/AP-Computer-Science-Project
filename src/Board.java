import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.sun.javafx.geom.Line2D;
import com.sun.prism.Graphics;

public class Board extends JFrame implements ActionListener {

	JPanel settingButton = new JPanel();
	JButton setting;

	JFrame exit = new JFrame();
	JButton exitYes = new JButton("Yes"), exitNo = new JButton("No");

	public Board() {
		this.setResizable(false);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setUndecorated(true);
		this.setLayout(new BorderLayout());

//		this.getContentPane();

		settingButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		Icon settingIcon = new ImageIcon(
				"D:/Iris/Documents/GitHub/AP-Computer-Science-Project/src/Pictures/setting.png");
		setting = new JButton(settingIcon);
		settingButton.add(setting);
		this.add(settingButton, BorderLayout.SOUTH);

		setting.addActionListener(this);

		this.setVisible(true);

	}

//	public void paint(Graphics g) {
//
//		g.drawLine(this.getHeight() / 2, 0, this.getHeight() / 2, this.getWidth());
//	}

	public static void main(String[] args) {
		Board bb = new Board();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == setting) {
			exit.setSize(200, 100);
			exit.setLayout(new BorderLayout());

			exit.add(new JLabel("Do you want to exit?", SwingConstants.CENTER));

			JPanel options = new JPanel();
			options.setLayout(new GridLayout(1, 2));
			options.add(exitYes);
			options.add(exitNo);

			exitYes.addActionListener(this);
			exitNo.addActionListener(this);

			exit.add(options, BorderLayout.SOUTH);

			exit.setLocationRelativeTo(null);
			exit.setAlwaysOnTop(true);
			exit.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
			exit.setResizable(false);
			exit.setVisible(true);

		}
		if (e.getSource() == exitYes) {
			exit.dispose();
			this.dispose();
		}
		if (e.getSource() == exitNo) {
			exit.dispose();
		}
	}
}
