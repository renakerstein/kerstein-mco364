package kerstein.mco364.paint;

import java.awt.Graphics2D;
import java.util.logging.Logger;

public class LineTool extends Tool {

	//every class gets its own logger!
	//arg should be unique name for the class
	//loggers will get you the messages
	private static final Logger LOG=Logger.getLogger(LineTool.class.getName());
	
												
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	

	public LineTool(PaintProperties properties) {
		super(properties);
	}

	public void mousePressed(Graphics2D g, int x, int y) {
		this.x1 = x;
		this.y1 = y;
		this.x2 = x;
		this.y2 = y;
	}

	public void mouseReleased(Graphics2D g, int x, int y) {
		g.setColor(properties.getColor());
		g.drawLine(this.x1, this.y1, x, y);

	}

	public void mouseDragged(Graphics2D g, int x, int y) {
		this.x2 = x;
		this.y2 = y;

	}

	public void drawPreview(Graphics2D g) {
		g.setColor(properties.getColor());
		g.drawLine(x1, y1, x2, y2);
		
		String logMessage=String.format("x1=%d, y1=%d, x2=%d, y2=%d", x1, y1, x2, y2);
		LOG.info(logMessage);  //will supply info in console
		
		//LEVELS: SEVERE, WARNING, INFO, CONFIG, FINE, FINER, FINEST
	}


}
