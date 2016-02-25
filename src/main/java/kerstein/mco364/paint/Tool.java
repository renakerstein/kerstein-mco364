package kerstein.mco364.paint;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

//all methods of interface are public
public interface Tool {

	void mousePressed(Graphics g, int x, int y, BufferedImage buffer);

	void mouseReleased(Graphics g, int x, int y);

	void mouseDragged(Graphics g, int x, int y);

	void drawPreview(Graphics g);
}
