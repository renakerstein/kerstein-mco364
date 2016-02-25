package kerstein.mco364.paint;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

//done using polymorphism=code works with an interface/base class. 
//you can treat objects of different types in a similar manner
//code here works with any tool - not just a pencil tool.

public class Canvas extends JPanel {

	private BufferedImage buffer;
	private Tool tool;

	public Canvas() {
		buffer = new BufferedImage(800, 600, BufferedImage.TYPE_INT_ARGB);
		tool = new PencilTool(); // tool set to pencil by default????
		this.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent event) {

			}

			public void mouseEntered(MouseEvent event) {

			}

			public void mouseExited(MouseEvent event) {

			}

			public void mousePressed(MouseEvent event) {
				tool.mousePressed(buffer.getGraphics(), event.getX(),
						event.getY(), buffer);
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

}
