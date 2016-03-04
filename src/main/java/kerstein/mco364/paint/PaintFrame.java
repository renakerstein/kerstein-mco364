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

	private JButton colorButton,
			redo, undo;
	private JPanel panel, undoRedo;
	private Canvas canvas;
	private Color color;
	private PaintProperties properties;

	public PaintFrame() {
		setTitle("PAINT");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
	
		properties=new PaintProperties();
		canvas = new Canvas(properties);

		add(canvas, BorderLayout.CENTER);
	
		this.panel = new JPanel();

		ToolButton buttons []=new ToolButton[]{
				new ToolButton(new PencilTool(properties),"/pencil.png"),
				new ToolButton(new LineTool(properties),"/line.png"),
				 new ToolButton(new RectangleTool(properties),"/rectangle.png"),
				 new ToolButton(new OvalTool(properties),"/oval.png"),
				 new ToolButton(new BucketFill(properties),
							"/paintbucket.png")
		};
		
		for(ToolButton button: buttons){
			panel.add(button);
			button.setBackground(Color.WHITE);
			button.addActionListener(listener);
		}
	

		colorButton = new JButton(new ImageIcon(getClass().getResource(
				"/choosecolor.jpg")));
		colorButton.addActionListener(colorListener);
		colorButton.setBackground(Color.WHITE);

		undoRedo = new JPanel();

		redo = new JButton(new ImageIcon(getClass().getResource("/redo.png")));
		redo.addActionListener(redoListener);
		redo.setBackground(Color.WHITE);

		undo = new JButton(new ImageIcon(getClass().getResource("/undo.png")));
		undo.addActionListener(undoListener);
		undo.setBackground(Color.WHITE);

		undoRedo.add(undo);
		undoRedo.add(redo);
		panel.add(colorButton);

		add(panel, BorderLayout.PAGE_START);
		add(undoRedo, BorderLayout.PAGE_END);
	}



	ActionListener listener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			ToolButton button=(ToolButton) event.getSource();
			canvas.setTool(button.getTool());
		}

	};

	
	ActionListener colorListener = new ActionListener() {

		public void actionPerformed(ActionEvent event) {
			color = JColorChooser.showDialog(colorButton, "Pick your color",
					color);
			if (color != null) {
				properties.setColor(color);

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
