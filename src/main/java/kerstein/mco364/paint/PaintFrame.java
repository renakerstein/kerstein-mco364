package kerstein.mco364.paint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

public class PaintFrame extends JFrame {

	private JButton redo, undo;
	private JPanel undoRedo;
	private Canvas canvas;

	@Inject
	public PaintFrame(Canvas canvas, PaintToolbar toolbar) {
		setTitle("PAINT");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container container = getContentPane();
		container.setLayout(new BorderLayout());
		this.canvas = canvas;

		add(canvas, BorderLayout.CENTER);
		add(toolbar, BorderLayout.NORTH);

		this.undoRedo = new JPanel();

		redo = new JButton(new ImageIcon(getClass().getResource("/redo.png")));
		redo.addActionListener(redoListener);
		redo.setBackground(Color.WHITE);

		undo = new JButton(new ImageIcon(getClass().getResource("/undo.png")));
		undo.addActionListener(undoListener);
		undo.setBackground(Color.WHITE);

		undoRedo.add(undo);
		undoRedo.add(redo);

		add(undoRedo, BorderLayout.PAGE_END);
		
		setVisible(true);

	}

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

		//changing log level
		Logger logger =Logger.getLogger("kerstein.mco364.paint");
		logger.setLevel(Level.FINE); //only display fine and above
		Handler handler =new ConsoleHandler();
		handler.setLevel(Level.FINE);
		logger.addHandler(handler);
		
		Injector injector = Guice.createInjector(new PaintModule());
		PaintFrame frame = injector.getInstance(PaintFrame.class); // getting a
																	// list of
																	// constructors
																	// and then
																	// looks to
																	// use the
																	// constructor
																	// w/
																	// @Inject
	}

}
