package kerstein.mco364.paint;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.image.BufferedImage;

import javax.inject.Inject;
import javax.inject.Singleton;

/*Singleton = only one instance of it and everything has access to it**/
@Singleton
public class PaintProperties {

	private Color color;
	private BasicStroke stroke;
	private boolean fill;
	private int width;
	private int height;
	private BufferedImage image;
	
	@Inject
	public PaintProperties(){
		this.width=800;
		this.stroke=new BasicStroke(8);
		this.height=600;
		image=new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		this.color=Color.BLACK;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public BasicStroke getWeight() {
		return stroke;
	}
	public void setWeight(int weight) {
		this.stroke=new BasicStroke(weight);
	}
	public boolean isFill() {
		return fill;
	}
	public void setFill(boolean fill) {
		this.fill = fill;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public BufferedImage getImage() {
		return image;
	}
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	
}
