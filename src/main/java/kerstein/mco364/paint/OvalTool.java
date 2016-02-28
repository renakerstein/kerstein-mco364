package kerstein.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

public class OvalTool implements Tool {

	private int x1, y1, x2, y2, width, height;
	private Color color;

	public OvalTool(Color color) {
		this.color = color;
	}

	public void mousePressed(Graphics g, int x, int y) {
		g.setColor(color);
		x1 = x;
		y1 = y;
		x2 = x;
		y2 = y;
		width = 0;
		height = 0;

	}

	public void mouseReleased(Graphics g, int x, int y) {
		g.setColor(color);
		x2 = x;
		y2 = y;
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);
		g.drawOval(Math.min(x1, x2), Math.min(y1, y2), width, height);

	}

	public void mouseDragged(Graphics g, int x, int y) {
		x2 = x;
		y2 = y;
		width = Math.abs(x2 - x1);
		height = Math.abs(y2 - y1);

	}

	public void drawPreview(Graphics g) {
		g.setColor(color);
		g.drawOval(Math.min(x1, x2), Math.min(y1, y2), width, height);

	}

	public void setColor(Color color) {
		this.color = color;

	}

}
