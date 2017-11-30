package view;

import java.awt.*;
import javax.swing.*;

class PainelDesenhaFormas extends JPanel {
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.blue);
		g.drawRect(10, 10, 80, 80);
		g.drawRoundRect(100, 10, 80, 30, 15, 15);
		g.setColor(Color.red);
		for (int i = 0; i < 100; i += 3)
			g.drawOval(100, 100, i, i);
	}
}
