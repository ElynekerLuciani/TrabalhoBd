package view;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import javax.swing.JPanel;
public class JGradientPanel extends JPanel {
	private Color finalColor;
    private Color initialColor;
    private double gradiente1;
    private double gradiente2;
    public JGradientPanel(Color initialColor,double gradiente1, Color finalColor,double gradiente2) {
        if (initialColor == null)
            throw new IllegalArgumentException("Invalid initial color!");
        if (finalColor == null)
            throw new IllegalArgumentException("Invalid final color!");
        this.initialColor = initialColor;
        this.finalColor = finalColor;
        this.gradiente1=gradiente1;
        this.gradiente2=gradiente2;
    }
    public void setInitialColor(Color color) {
        this.initialColor = color;
        invalidate();
    }
    public void setFinalColor(Color color) {
    this.finalColor = color;
    invalidate();
}

public Color getInitialColor() {
    return initialColor;        
}

public Color getFinalColor() {
    return finalColor;
}

public double getGradiente1() {
	return gradiente1;
}
public double getGradiente2() {
	return gradiente2;
}

@Override
protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    if (!isOpaque()) {
        return;
    }
    GradientPaint paint = new GradientPaint(
            new Point2D.Float(getWidth() / 2, (int)(getHeight()*getGradiente1())), initialColor, 
            new Point2D.Float(getWidth() / 2, (int)(getHeight()*getGradiente2())), finalColor);
    g2d.setPaint(paint);
    g2d.fillRect(0, 0, getWidth(), getHeight());
    g2d.dispose();
}
}

