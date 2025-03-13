package geometry;

import java.awt.Color;
import java.awt.Graphics;

import drawing.DlgRectangle;
import drawing.PnlDrawing;

public class Rectangle extends Shape{

	private Point upperLeft;
	private int width;
	private int height;
	
	public Rectangle (Point upperleft, int width, int height) {
		this.upperLeft = upperleft;
		this.width = width;
		this.height = height;
	}

	public Point getUpperleft() {
		return upperLeft;
	}

	public void setUpperleft(Point upperleft) {
		this.upperLeft = upperleft;
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

	
	public Point getCenter() {
		return new Point(upperLeft.getX()+width/2, upperLeft.getY()+width/2);
	}
	
	public int area() {
		return width * height;
	}
	
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawRect(	this.getUpperleft().getX(),
					this.getUpperleft().getY(), 
					this.getWidth(), this.getHeight());
		if (selected) {
			g.setColor(Color.GREEN);
			g.drawRect(	this.getUpperleft().getX()-3,
						this.getUpperleft().getY()-3,6,6);
			g.drawRect(	this.getUpperleft().getX() + width -3,
						this.getUpperleft().getY()-3,6,6);
			g.drawRect(	this.getUpperleft().getX() -3,
						this.getUpperleft().getY() + height-3,6,6);
			g.drawRect(	this.getUpperleft().getX() + width-3,
						this.getUpperleft().getY() + height-3,6,6);
		}
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Rectangle) {
			Rectangle pomocni = (Rectangle) obj;
			if (this.upperLeft.equals(pomocni.getUpperleft()) && this.width == pomocni.getWidth()
					&& this.height == pomocni.getHeight()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public boolean contains(int x, int y) {
		if (upperLeft.getX() <= x && upperLeft.getY() <= y && x <= upperLeft.getX() + width
				&& y <= upperLeft.getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean contains(Point p) {
		if (upperLeft.getX() <= p.getX() && upperLeft.getY() <= p.getY()
				&& p.getX() <= upperLeft.getX() + width && p.getY() <= upperLeft.getY() + height) {
			return true;
		} else {
			return false;
		}
	}
	
	public void moveBy(int byX, int byY) {
		upperLeft.moveBy(byX, byY);	
	}

	public void moveTo(int x, int y) {
		upperLeft.moveTo(x, y);	
	}
	
	public String toString() {
		return "Circle has coordinates(" + upperLeft.getX() + "," + upperLeft.getY() + "),dimensions:(" + width +','+ height +")";
	}
	
	public void DialogEdit() {
		DlgRectangle dlgRectangle = new DlgRectangle();
	    for (Shape shape : PnlDrawing.shapesArrList) {
	        if (shape.isSelected()) {
	            String[] split = shape.toString().split("[(),\\s]+");
	            dlgRectangle.getTxtX().setText(split[3]); 
	            dlgRectangle.getTxtY().setText(split[4]);
	            dlgRectangle.getTxtWidth().setText(split[6]);
	            dlgRectangle.getTxtHeight().setText(split[7]);
	        }
	    }
	    dlgRectangle.setVisible(true);
	}

	@Override
	public void AreaPainter(Graphics g) {
		g.setColor(getFill());
		g.fillRect(this.getUpperleft().getX(), this.getUpperleft().getY(), 
				this.getWidth(), this.getHeight());
	}
	
	public int circumference() {
		return 2*width + 2*height;
	}
	
	public int compareTo(Object obj) {
		if (obj instanceof Rectangle) {
			return this.area() - ((Rectangle) obj).area();
		}
		return 0;
	}
	

}
