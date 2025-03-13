package geometry;

import java.awt.Graphics;

import drawing.DlgCircle;
import drawing.PnlDrawing;


public class Circle extends Shape{
    private int radius;
    protected Point center;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) throws Exception {
        if (radius <= 0) {
            throw new Exception("Radius ne moze biti postavljen na 0");
        } else {
            this.radius = radius;
        }
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double area() {
        return radius * radius * Math.PI;
    }

    public boolean contains(int x, int y) {
        return center.distance(x, y) <= radius;
    }

    public boolean contains(Point p) {
        return center.distance(p.getX(), p.getY()) <= radius;
    }

    public void draw(Graphics g) {
        g.setColor(getOutline());
        g.drawOval(this.getCenter().getX() - this.radius, 
                   this.getCenter().getY() - this.radius, 
                   this.radius * 2, this.radius * 2);
        if (selected) {
            g.drawRect(center.getX() - 3,
                       center.getY() - 3, 6, 6);
            g.drawRect(center.getX() + radius - 3, 
                       center.getY() - 3, 6, 6);
            g.drawRect(center.getX() - radius - 3, 
                       center.getY() - 3, 6, 6);
            g.drawRect(center.getX() - 3, 
                       center.getY() + radius - 3, 6, 6);
            g.drawRect(center.getX() - 3, 
                       center.getY() - radius - 3, 6, 6);
        }
    }

    public boolean equals(Object obj) {
        if (obj instanceof Circle) {
            Circle c = (Circle) obj;
            return radius == c.getRadius() && center.equals(c.getCenter());
        }
        return false;
    }

    public void moveBy(int byX, int byY) {
        center.moveBy(byX, byY);
    }

    public void moveTo(int x, int y) {
        center.moveTo(x, y);
    }

    public String toString() {
        return "Circle has coordinates(" + center.getX() + "," + center.getY() + "),radius:(" + radius + ")";
    }

    public void DialogEdit() {
        DlgCircle dlgCircle = new DlgCircle();
        for (Shape shape : PnlDrawing.shapesArrList) {
            if (shape.isSelected()) {
                String[] split = shape.toString().split("[(),\\s]+");
                dlgCircle.getxCoord().setText(split[3]);
                dlgCircle.getyCoord().setText(split[4]);
                dlgCircle.getrValue().setText(split[6]);
            }
        }
        dlgCircle.setVisible(true);
    }

    @Override
    public void AreaPainter(Graphics g) {
        g.setColor(getFill());
        g.fillOval(this.getCenter().getX() - this.getRadius(), 
                   this.getCenter().getY() - this.getRadius(),
                   this.getRadius() * 2, this.getRadius() * 2);
    }

    public double circumference() {
        return 2 * radius * Math.PI;
    }

    public int compareTo(Object obj) {
		if(obj instanceof Circle) {
			Circle temp = (Circle) obj;
			return (int)(area() - temp.area());
		}
		return 0;
	}
}
