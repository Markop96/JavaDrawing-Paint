package test;

import geometry.Point;

public class PointTest {

	public static void main(String[] args) {

		Point p1 = new Point(5,2);
		Point p2 = new Point(5,7);
		
		
		//UPDATE VREDNSOTI:
		p1.x = 100;
		p1.y = 200;
		p1.selected = true; 
		
		p2.x = -100;
		p2.y = 100;
		
		p1.setX(200);
		p1.setX(20);	
		p2.setSelected(true);
		
		p1.setX(-20);	
		p1.setX(1000); 
		
		
		Point p3= new Point(10,2);
		Point p4= new Point(20,2);
		
		double distance = p3.distance(p4);
		System.out.println(distance);
		
		System.out.println(p1.x);
		System.out.println(p1.y);
		System.out.println(p1.selected);
		System.out.println(p2.x);
		System.out.println(p2.y);
		System.out.println(p2.selected);
	}
}
