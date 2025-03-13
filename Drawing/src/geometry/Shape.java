package geometry;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Shape {

	protected boolean selected;
	
	private Color outline = Color.black;
	private Color fill = Color.white;
	public abstract void AreaPainter(Graphics g);

	public Color getOutline() {
		return outline;
	}

	public void setOutline(Color outline) {
		this.outline = outline;
	}

	public Color getFill() {
		return fill;
	}

	public void setFill(Color fill) {
		this.fill = fill;
	}
	
	public Shape() {
		
	}
	
	public Shape(boolean selected) {
		this.selected = selected;
	}
	
	public abstract boolean  contains(int x, int y);

	public abstract void draw (Graphics g);
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public abstract void DialogEdit();

	public abstract void moveTo(int parseInt, int parseInt2);

}
