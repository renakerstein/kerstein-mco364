package kerstein.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PaintFrame extends JFrame {

	private JButton pencil, line, rectangle, oval, fillBucket, colorButton,
			redo, undo;
	private JPanel panel, undoRedo;
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

		this.color = Color.BLACK;

		pencil = new JButton(new ImageIcon("pencil.png"));
		pencil.addActionListener(pencilListener);
		pencil.setBackground(Color.WHITE);

		line = new JButton(new ImageIcon("line.png"));
		line.addActionListener(lineListener);
		line.setBackground(Color.WHITE);

		rectangle = new JButton(new ImageIcon("rectangle.png"));
		rectangle.addActionListener(rectangleListener);
		rectangle.setBackground(Color.WHITE);

		oval = new JButton(new ImageIcon("oval.png"));
		oval.addActionListener(ovalListener);
		oval.setBackground(Color.WHITE);

		fillBucket = new JButton(new ImageIcon("paintbucket.png"));
		fillBucket.addActionListener(fillListener);
		fillBucket.setBackground(Color.WHITE);

		colorButton = new JButton(new ImageIcon("choosecolor.jpg"));
		colorButton.addActionListener(colorListener);
		colorButton.setBackground(Color.WHITE);

		undoRedo = new JPanel();

		redo = new JButton(new ImageIcon("redo.png"));
		redo.addActionListener(redoListener);
		redo.setBackground(Color.WHITE);

		undo = new JButton(new ImageIcon("undo.png"));
		undo.addActionListener(undoListener);
		undo.setBackground(Color.WHITE);

		undoRedo.add(undo);
		undoRedo.add(redo);
		panel.add(colorButton);
		panel.add(pencil);
		panel.add(line);
		panel.add(rectangle);
		panel.add(oval);
		panel.add(fillBucket);

		add(panel, BorderLayout.PAGE_START);
		add(undoRedo, BorderLayout.PAGE_END);
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
