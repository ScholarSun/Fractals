
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.Event;
import java.awt.geom.GeneralPath;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class koch extends JPanel {
	// Number of Generations
	static int gens = 0;

	// Main Method
	public static void main(String[] a) {
		
		// Declares new object JFrame
		JFrame f = new JFrame();
		f.setLayout(new BorderLayout());

		// Sets Canvas Size
		f.setSize(325, 500);
		JPanel ko = new koch();

		// Displays output
		f.add(ko, BorderLayout.CENTER);

		JPanel pane = new JPanel();
		JButton up = new JButton("Up");
		up.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gens++;
				ko.repaint();
				f.repaint();
			}
		});
		JButton down = new JButton("Down");
		down.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gens--;
				ko.repaint();
				f.repaint();
			}
		});
		
		pane.add(up);
		pane.add(new JLabel("   "));
		pane.add(down);
		f.add(pane, BorderLayout.SOUTH);

		// Allows user to see and close it
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	// Paint Method, Draws images
	public void paint(Graphics g) {
		// Passes Initial Parameters to Recursive Method

		// Coordinates for Triangle Vertices
		drawKoch(g, gens, 20, 280, 280, 280);
		drawKoch(g, gens, 280, 280, 150, 20);
		drawKoch(g, gens, 150, 20, 20, 280);
	}

	public void drawKoch(Graphics g, int a, int x1, int y1, int x5, int y5) {
		int deltax, deltay, x2, x3, x4, y2, y3, y4;
		// Draws shape and stops recursion
		if (a == 0) {
			g.drawLine(x1, y1, x5, y5);
		}
		// Divides line into three segments,
		else {
			deltax = x5 - x1;
			deltay = y5 - y1;

			x2 = x1 + (deltax / 3);
			y2 = y1 + (deltay / 3);

			x4 = x5 - (deltax / 3);
			y4 = y5 - (deltay / 3);

			x3 = (int) (0.5 * (x1 + x5) + Math.sqrt(3) * (y1 - y5) / 6);
			y3 = (int) (0.5 * (y1 + y5) + Math.sqrt(3) * (x5 - x1) / 6);

			drawKoch(g, a - 1, x1, y1, x2, y2);
			drawKoch(g, a - 1, x2, y2, x3, y3);
			drawKoch(g, a - 1, x3, y3, x4, y4);
			drawKoch(g, a - 1, x4, y4, x5, y5);

		}
	}
}