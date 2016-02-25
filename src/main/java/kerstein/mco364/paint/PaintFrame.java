package kerstein.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private JButton pencil, line, rectangle, oval, fillBucket;
	private JPanel panel;
	private Canvas canvas;

	public PaintFrame() {
		setTitle("PAINT");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());

		canvas = new Canvas();
		add(canvas, BorderLayout.CENTER);
		this.panel = new JPanel();

		pencil = new JButton("PENCIL");
		pencil.addActionListener(pencilListener);
		line = new JButton("LINE");
		line.addActionListener(lineListener);
		rectangle = new JButton("RECTANGLE");
		rectangle.addActionListener(rectangleListener);
		oval = new JButton("OVAL");
		oval.addActionListener(ovalListener);
		fillBucket = new JButton("FILL");
		fillBucket.addActionListener(fillListener);

		panel.add(pencil);
		panel.add(line);
		panel.add(rectangle);
		panel.add(oval);
		panel.add(fillBucket);

		add(panel, BorderLayout.PAGE_START);

	}

	ActionListener pencilListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			PencilTool pencil = new PencilTool();
			canvas.setTool(pencil);
		}

	};

	ActionListener lineListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			LineTool line = new LineTool();
			canvas.setTool(line);
		}

	};

	ActionListener rectangleListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			RectangleTool rectangle = new RectangleTool();
			canvas.setTool(rectangle);
		}

	};

	ActionListener ovalListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			OvalTool oval = new OvalTool();
			canvas.setTool(oval);
		}

	};

	ActionListener fillListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			BucketFill bucket = new BucketFill();
			canvas.setTool(bucket);

		}

	};

	public static void main(String[] args) {
		PaintFrame p = new PaintFrame();
		p.setVisible(true);
	}

}
