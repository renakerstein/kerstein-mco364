package kerstein.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private JButton pencil, line, rectangle, oval, fillBucket, colorButton,
	redo, undo;
	private JPanel panel;
	private Canvas canvas;
	private Color color;

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

		colorButton = new JButton("Choose a Color");
		colorButton.addActionListener(colorListener);

		redo = new JButton("REDO");
		redo.addActionListener(redoListener);

		undo = new JButton("Undo");
		undo.addActionListener(undoListener);

		panel.add(redo);
		panel.add(undo);
		panel.add(colorButton);
		panel.add(pencil);
		panel.add(line);
		panel.add(rectangle);
		panel.add(oval);
		panel.add(fillBucket);

		add(panel, BorderLayout.PAGE_START);

	}

	ActionListener pencilListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			PencilTool pencil = new PencilTool(color);
			canvas.setTool(pencil);
		}

	};

	ActionListener lineListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			LineTool line = new LineTool(color);
			canvas.setTool(line);
		}

	};

	ActionListener rectangleListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			RectangleTool rectangle = new RectangleTool(color);
			canvas.setTool(rectangle);
		}

	};

	ActionListener ovalListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			OvalTool oval = new OvalTool(color);
			canvas.setTool(oval);
		}

	};

	ActionListener fillListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			BucketFill bucket = new BucketFill(canvas, color);
			canvas.setTool(bucket);

		}

	};

	ActionListener colorListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			color = JColorChooser.showDialog(colorButton, "Pick your color",
					color);
			if (color != null) {
				canvas.setColor(color);

			}
		}

	};

	ActionListener redoListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			canvas.redo();
		}

	};

	ActionListener undoListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			canvas.undo();
		}

	};

	public static void main(String[] args) {
		PaintFrame p = new PaintFrame();
		p.setVisible(true);
	}

}
