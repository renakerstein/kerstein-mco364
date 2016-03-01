package kerstein.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.util.Stack;

import javax.swing.JPanel;

//done using polymorphism=code works with an interface/base class. 
//you can treat objects of different types in a similar manner
//code here works with any tool - not just a pencil tool.

public class Canvas extends JPanel {

	private Stack<BufferedImage> undo;
	private Stack<BufferedImage> redo;
	private BufferedImage buffer;
	private Tool tool;

	public Canvas() {
		undo = new Stack<BufferedImage>();
		redo = new Stack<BufferedImage>();
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		tool = new PencilTool(Color.BLACK); // tool set to pencil by default????

		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {

			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent event) {

			}

			public void mousePressed(MouseEvent event) {
				getImageCopy(undo);
				tool.mousePressed(buffer.getGraphics(), event.getX(),
						event.getY());
				repaint();
			}

			public void mouseReleased(MouseEvent event) {
				tool.mouseReleased(buffer.getGraphics(), event.getX(),
						event.getY());
				repaint();
			}
		});

		addMouseMotionListener(new MouseMotionListener() {

			public void mouseDragged(MouseEvent event) {
				tool.mouseDragged(buffer.getGraphics(), event.getX(),
						event.getY()); // graphics from long term storage -
				// buffer

				repaint();
			}

			public void mouseMoved(MouseEvent arg0) {

			}

		});
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(buffer, 0, 0, null);
		tool.drawPreview(g);// graphics from container - can only draw to
		// graphics object in paintComponent.

	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	public void setColor(Color color) {
		tool.setColor(color);

	}

	public BufferedImage getBuffer() {
		return buffer;
	}

	public void redo() {
		if (!redo.isEmpty()) {
			buffer = redo.pop();
			getImageCopy(undo);

		}
		repaint();
	}

	public void undo() {
		if (!undo.isEmpty()) {
			getImageCopy(redo);
			buffer = undo.pop();

		}
		repaint();
	}

	public void getImageCopy(Stack<BufferedImage> stack) {
		BufferedImage clone = new BufferedImage(buffer.getWidth(),
				buffer.getHeight(), buffer.getType());
		Graphics2D g2d = clone.createGraphics();
		g2d.drawImage(buffer, 0, 0, null);
		g2d.dispose();
		stack.push(clone);
	}

}
