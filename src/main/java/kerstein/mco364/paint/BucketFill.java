package kerstein.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketFill implements Tool {

	private Color color;
	private BufferedImage image;

	public BucketFill(Canvas canvas, Color color) {
		this.color = color;
		this.image = canvas.getBuffer();
	}

	public void mousePressed(Graphics g, int x, int y) {
		boundaryFill(x, y, image, image.getRGB(x, y), color.getRGB());

	}

	public void mouseReleased(Graphics g, int x, int y) {

	}

	public void mouseDragged(Graphics g, int x, int y) {

	}

	public void drawPreview(Graphics g) {

	}

	public void boundaryFill(int x, int y, BufferedImage buffer, int srcColor,
			int targetColor) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			// take the nearest point out of the queue
			Point p = queue.remove();
			int x1 = p.getX();
			int y1 = p.getY();

			if (x1 > 0 && x1 < buffer.getWidth() && y1 > 0
					&& y1 < buffer.getHeight()
					&& buffer.getRGB(x1, y1) == srcColor) {

				buffer.setRGB(x1, y1, targetColor);

				// add left
				queue.add(new Point(x1 - 1, y1));

				// add right
				queue.add(new Point(x1 + 1, y1));

				// add up
				queue.add(new Point(x1, y1 - 1));

				// add down
				queue.add(new Point(x1, y1 + 1));

			}

		}

	}

	public void setColor(Color color) {
		this.color = color;

	}

}
