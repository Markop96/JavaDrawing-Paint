package test;

import java.awt.Graphics;

import javax.swing.JPanel;

import geometry.Circle;
import geometry.Donut;
import geometry.Line;
import geometry.Point;
import geometry.Rectangle;

public class DrawingPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Object[] shapes = new Object[10];
	public DrawingPanel() {
		
        shapes[0] = new Circle(new Point(200, 60), 30);
        shapes[1] = new Rectangle(new Point(185, 90), 30, 60);
        shapes[2] = new Line(new Point(185, 90), new Point(155, 130));
        shapes[3] = new Line(new Point(215, 90), new Point(245, 130));
        shapes[4] = new Line(new Point(185, 150), new Point(170, 190));
        shapes[5] = new Line(new Point(215, 150), new Point(230, 190));
        shapes[6] = new Donut(new Point(190, 50), 5, 2);
        shapes[7] = new Donut(new Point(210, 50), 5, 2);
        shapes[8] = new Line(new Point(190, 70), new Point(210, 70));
	}
	
	public void paint (Graphics g) {
		super.paint(g);
		for (int i=0; i<shapes.length; i++) 
		{
			Object obj= shapes[i];
			if(obj!=null){
				if (obj instanceof Point) {
					Point p = (Point) obj;
					p.draw(g);
				}
				else if (obj instanceof Line) {
					Line l = (Line) obj;
					l.draw(g);
				}
				else if (obj instanceof Circle) {
					Circle c = (Circle) obj;
					c.draw(g);
				}
				else if (obj instanceof Rectangle) {
					Rectangle r = (Rectangle) obj;
					r.draw(g);
				}
				else if (obj instanceof Donut) {
					Donut d = (Donut) obj;
					d.draw(g);
				}
			}
		}
	}
}
