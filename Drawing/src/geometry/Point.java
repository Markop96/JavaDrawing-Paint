package geometry;

import java.awt.Color;
import java.awt.Graphics;

import drawing.DlgPoint;
import drawing.PnlDrawing;

public class Point extends Shape{
	
	public int x;
	public int y;
	public boolean selected;
	private static int maxX=500;
	private static int maxY=500;

	public Point(int x, int y) {
		this.x = x;	
		this.y = y;
	}
	
	public Point(int x, int y, boolean selected) {
		this(x,y);	
		this.selected = selected;
	}

	public void setX(int x){
		if(x>0)		
			this.x = x;		
		if(x>maxX)
			this.x = maxX; 
		}

	public int getX() {
		return x;
	}
	
	public void setY(int y) {
		if(y>0)
			this.y = y;
		if(y>maxY)
			this.y = maxY;
	}
	
	public int getY() {
		return y;
	}
	
	public static int getMaxX() {
		return maxX;
	}

	public double distance(int x2, int y2) {
		double dx = this.x - x2;
		double dy = this.y - y2;
		double d = Math.sqrt(dx * dx + dy * dy);
		return d;
	}
	
	public boolean contains(int x, int y) {
		if (this.distance(x, y) <= 5) {
			return true;
		} else {
			return false;
		}
	}

	public void draw(Graphics g) {
		g.setColor(getOutline());
		g.drawLine(this.x-1, this.y, this.x+1, this.y);
		g.drawLine(this.x, this.y-1, this.x, this.y+1);
		if(isSelected()==true) {
		g.setColor(Color.GREEN);
		g.drawRect(this.x-3, this.y-3, 6,6);}
	}
	
	public boolean equals(Object obj) {
			if (obj instanceof Point) {
				Point p = (Point) obj;
				if(x == p.getX() && y == p.getY()) {
				return true;
				}
				else 
				return false;
			}
			else 
			return false;
	}
	
	
	public void moveBy(int byX, int byY) {
		x+=byX;
		y+=byY;
			
	}

	public void moveTo(int x, int y) {
		this.x = x;
		this.y = y;

	}
	
	public String toString() {
		return "Point has coordinates(" + x + "," + y + ")";
	}
	
	public void DialogEdit() {
	    DlgPoint dlgPoint = new DlgPoint();
	    for (Shape shape : PnlDrawing.shapesArrList) {
	        if (shape.isSelected()) {
	            String[] split = shape.toString().split("[(),\\s]+"); 
	                dlgPoint.getxCoord().setText(split[3]);
	                dlgPoint.getyCoord().setText(split[4]); 
	        }
	    }
	    dlgPoint.setVisible(true);
	}

	@Override
	public void AreaPainter(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	public double distance(Point p4) {
		// TODO Auto-generated method stub
		return 0;
	}


}
