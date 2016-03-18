package kerstein.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JPanel;

@Singleton
public class PaintToolbar extends Container {
	
	private JButton colorButton;
	private JPanel panel;
	private Color color;
	
	@Inject
	public PaintToolbar(final Canvas canvas, final PaintProperties properties) {
		
		setLayout(new FlowLayout());
		this.panel = new JPanel();
		

		ActionListener listener = new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				ToolButton button = (ToolButton) event.getSource();
				canvas.setTool(button.getTool());
			}

		};

		ActionListener colorListener = new ActionListener() {

			public void actionPerformed(ActionEvent event) {
				 color = JColorChooser.showDialog(colorButton,
						"Pick your color", color);
				if (color != null) {
					properties.setColor(color);

				}
			}

		};


		ToolButton buttons[] = new ToolButton[] {
				new ToolButton(new PencilTool(properties), "/pencil.png"),
				new ToolButton(new LineTool(properties), "/line.png"),
				new ToolButton(new RectangleTool(properties), "/rectangle.png"),
				new ToolButton(new OvalTool(properties), "/oval.png"),
				new ToolButton(new BucketFill(properties), "/paintbucket.png") };

		for (ToolButton button : buttons) {
			add(button);
			button.setBackground(Color.WHITE);
			button.addActionListener(listener);
		}

		colorButton = new JButton(new ImageIcon(getClass().getResource(
				"/choosecolor.jpg")));
		colorButton.addActionListener(colorListener);
		colorButton.setBackground(Color.WHITE);

	
		panel.add(colorButton);

		add(panel, BorderLayout.PAGE_START);

	}

}
