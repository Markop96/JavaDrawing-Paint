package geometry;

import java.awt.Color;
import java.awt.Graphics;

import drawing.DlgLine;
import drawing.PnlDrawing;

public class Line extends Shape{
	private Point startPoint;
	private Point endPoint;
	
	public Line() {
		
	}
	
	public Line(Point startPoint, Point endPoint) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
	}
	
	public Line(Point startPoint, Point endPoint, boolean selected) {
		this(startPoint, endPoint);
		this.selected = selected;
	}
	
	public Point getStartPoint() {
		return startPoint;
	}
	
	public void setStartPoint(Point startPoint) {
		this.startPoint = startPoint;
	}
	
	public Point getEndPoint() {
		return endPoint;
	}
	
	public void setEndPoint(Point endPoint) {
		this.endPoint = endPoint;
	}
	
	@Override
	public boolean contains(int x, int y) {
		if (startPoint.distance(x, y) + endPoint.distance(x, y) - length() <= 0.05) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawLine(this.getStartPoint().getX(), this.getStartPoint().getY(),
				this.getEndPoint().getX(), this.getEndPoint().getY());
		if (isSelected()==true) {
			g.setColor(Color.GREEN);
			g.drawRect(this.getStartPoint().getX()-3, this.getStartPoint().getY()-3,6,6);
			g.drawRect(this.getEndPoint().getX()-3, this.getEndPoint().getY()-3,6,6);
			g.drawRect(this.middleOfLine().getX()-3,
					this.middleOfLine().getY()-3,6,6);
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Line) {
			Line l = (Line) obj;
			if (this.startPoint.equals(l.getStartPoint()) && this.getEndPoint().equals(l.endPoint)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	public Point middleOfLine () {
		int middleX = (this.getStartPoint().getX() + this.getEndPoint().getX())/2;
		int middleY = (this.getStartPoint().getY() + this.getEndPoint().getY())/2;
		Point middle = new Point (middleX, middleY);
		return middle;
	}
	
	public void moveBy(int byX, int byY) {
		startPoint.moveBy(byX, byY);
		endPoint.moveBy(byX, byY);	
	}

	public void moveTo(int x, int y) {
			
	}
	
	public double length() {
		return startPoint.distance(endPoint.getX(), endPoint.getY());
	}
	
	public int compareTo(Object obj) {
		if (obj instanceof Line) {
			return (int) (this.length() - ((Line) obj).length());
		}
		return 0;
	}
	
	@Override
	public String toString() {
		return "Line has coordinates(" + startPoint.getX() + "," + startPoint.getY() + ")" + ",(" + endPoint.getX() + "," + endPoint.getY() ;
	}
	@Override
	public void DialogEdit() {
	    DlgLine dlgLine = new DlgLine();
	    for (Shape shape : PnlDrawing.shapesArrList) {
	        if (shape.isSelected() && shape instanceof Line) {
	            String[] split = shape.toString().split("[(),\\s]+");
	                dlgLine.getSxValue().setText(split[3]);
	                dlgLine.getSyValue().setText(split[4]);
	                dlgLine.getExValue().setText(split[5]);
	                dlgLine.getEyValue().setText(split[6]);
	            
	        }
	    }
	    dlgLine.setVisible(true);
	}

	@Override
	public void AreaPainter(Graphics g) {
		// TODO Auto-generated method stub
		
	}
	
}