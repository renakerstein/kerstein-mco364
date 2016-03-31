package kerstein.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class PencilTool extends Tool {

	private int x;
	private int y;

	public PencilTool(PaintProperties properties) {
		super(properties);
	}

	public void mousePressed(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.setStroke(properties.getWeight());
		g.fillOval(x, y, 1, 1);
		this.x = x;
		this.y = y;
	}

	public void mouseReleased(Graphics2D g, int x, int y) {

	}

	public void mouseDragged(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.setStroke(properties.getWeight());
		g.drawLine(this.x, this.y, x, y);
		this.x = x;
		this.y = y;
	}

	public void drawPreview(Graphics2D g) {

	}


}
