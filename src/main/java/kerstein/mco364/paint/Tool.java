package kerstein.mco364.paint;

import java.awt.Graphics2D;

//all methods of interface are public
public abstract class Tool {
	
	protected PaintProperties properties;
	
	public Tool(PaintProperties properties){
		this.properties=properties;
	}

	abstract void mousePressed(Graphics2D g, int x, int y);

	abstract void mouseReleased(Graphics2D g, int x, int y);

	abstract void mouseDragged(Graphics2D g, int x, int y);

	abstract void drawPreview(Graphics2D g);

	
}
