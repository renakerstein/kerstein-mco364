package kerstein.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class BucketFill implements Tool {

	public BucketFill() {

	}

	public void mousePressed(Graphics g, int x, int y, BufferedImage buffer) {
		boundaryFill(x, y, buffer);

	}

	public void mouseReleased(Graphics g, int x, int y) {

	}

	public void mouseDragged(Graphics g, int x, int y) {

	}

	public void drawPreview(Graphics g) {

	}

	public void boundaryFill(int x, int y, BufferedImage buffer) {
		Queue<Point> queue = new LinkedList<Point>();
		queue.add(new Point(x, y));

		while (!queue.isEmpty()) {
			// take the nearest point out of the queue
			Point p = queue.remove();
			int x1 = p.getX();
			int y1 = p.getY();

			if (x1 > 0 && x1 < buffer.getWidth() - 1 && y1 > 0
					&& y1 < buffer.getHeight() - 1) {
				int pixelColor = buffer.getRGB(x1, y1);
				buffer.setRGB(x1, y1, pixelColor);

				// test left
				if (buffer.getRGB(x1 - 1, y1) == pixelColor) {
					queue.add(new Point(x1 - 1, y1));
					buffer.setRGB(x1 - 1, y1, Color.RED.getRGB());

				}
				// test right
				if (buffer.getRGB(x1 + 1, y1) == pixelColor) {
					queue.add(new Point(x1 + 1, y1));
					buffer.setRGB(x1 + 1, y1, Color.RED.getRGB());

				}
				// test up
				if (buffer.getRGB(x1, y1 - 1) == pixelColor) {
					queue.add(new Point(x1, y1 - 1));
					buffer.setRGB(x1, y1 - 1, Color.RED.getRGB());

				}
				// test down
				if (buffer.getRGB(x1, y1 + 1) == pixelColor) {
					queue.add(new Point(x1, y1 + 1));
					buffer.setRGB(x1, y1 + 1, Color.RED.getRGB());

				}

			}

		}

	}

}
