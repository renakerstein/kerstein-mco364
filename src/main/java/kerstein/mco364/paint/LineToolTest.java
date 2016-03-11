package kerstein.mco364.paint;

import java.awt.Color;
import java.awt.Graphics;

import org.junit.Test;
import org.mockito.Mockito;

public class LineToolTest {

	@Test
	//you only want to test one class in each test
	public void testMouseReleased() {

		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);

		LineTool tool = new LineTool(properties);
		
		//mocking graphics class through Mockito 
		//it will return to you subclass of graphics object
		//method of Mock class returns default value of a method (ex:Integer-0)
		Graphics g=Mockito.mock(Graphics.class);
		tool.mousePressed(g, 3,7);
		tool.mouseReleased(g, 11,13);
	
		//verify that color was set properly
		Mockito.verify(g).setColor(Color.RED);
		//check to make sure that g.drawLine(3,7,11,13) was called
		Mockito.verify(g).drawLine(3,7,11,13);
	}

	@Test
	public void testDrawPreview() {
		
		PaintProperties properties = Mockito.mock(PaintProperties.class);
		Mockito.when(properties.getColor()).thenReturn(Color.RED);
		LineTool tool = new LineTool(properties);
		
		Graphics g=Mockito.mock(Graphics.class);
		tool.mousePressed(g,6,1);
		tool.mouseReleased(g, 9,7);
		Mockito.verify(g).setColor(Color.RED);
		Mockito.verify(g).drawLine(6, 1, 9, 7);
	
	}
}
