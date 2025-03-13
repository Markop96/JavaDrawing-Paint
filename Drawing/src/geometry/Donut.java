package geometry;

import java.awt.Color;
import java.awt.Graphics;

import drawing.DlgDonut;
import drawing.PnlDrawing;

public class Donut extends Circle{
	
	private int innerRadius;
	
	public Donut(Point center, int radius, int innerRadius) {
		super(center, radius); 
		this.innerRadius = innerRadius;
	}
	 
	public Donut(Point center, int radius, int innerRadius, boolean selected) {
		this(center, radius, innerRadius);
		setSelected(selected);
	}
	
	public int getInnerRadius() {
		return innerRadius;
	}

	public void setInnerRadius(int innerRadius) {
		this.innerRadius = innerRadius;
	}
	
	public double area() {
		 return super.area() - innerRadius * innerRadius * Math.PI;
		}

	
	public boolean contains(int x, int y) {
		double dFromCenter = this.getCenter().distance(x, y);
		return super.contains(x, y) && dFromCenter > innerRadius;
	}
	
	public boolean contains(Point p) {
		double dFromCenter = this.getCenter().distance(p.getX(), p.getY());
		return super.contains(p.getX(), p.getY()) && dFromCenter > innerRadius;
	}
	
	public void draw(Graphics g) {
		super.draw(g);
		g.drawOval(	this.getCenter().getX()-this.innerRadius,	
					this.getCenter().getY()-this.innerRadius,
					this.innerRadius*2, this.innerRadius*2);
		if(selected) {
			g.setColor(Color.GREEN);
			g.drawRect(getCenter().getX()-innerRadius-3, getCenter().getY()-3, 6, 6);
			g.drawRect(getCenter().getX()+innerRadius-3, getCenter().getY()-3, 6, 6);
			g.drawRect(getCenter().getX()-3, getCenter().getY()-innerRadius-3, 6, 6);
			g.drawRect(getCenter().getX()-3, getCenter().getY()+innerRadius-3, 6, 6);
		}
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Donut) {
			Donut d = (Donut) obj;
			if (this.getCenter().equals(d.getCenter()) &&
					this.getRadius() == d.getRadius() &&
					this.innerRadius == d.getInnerRadius()) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public String toString() {
		return super.toString() +", inner radius = " + innerRadius;
	}
	
	
	public void DialogEdit() {
	    DlgDonut dlgDonut = new DlgDonut();
	    for (Shape shape : PnlDrawing.shapesArrList) {
	        if (shape.isSelected()) {
	            String[] split = shape.toString().split("[(),\\s]+"); 
	                dlgDonut.getxCoord().setText(split[3]);
	                dlgDonut.getyCoord().setText(split[4]);
	                dlgDonut.getrValue().setText(split[6]); 
	                dlgDonut.getIrValue().setText(split[10]); 
	        }
	    }
	    dlgDonut.setVisible(true);
	}
	

	public int compareTo(Object obj) {
		if (obj instanceof Donut) {
			return (int) (this.area() - ((Donut) obj).area());
		}
		return 0;
	}
}
