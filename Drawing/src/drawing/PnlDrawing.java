package drawing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JPanel;

import geometry.Line;
import geometry.Point;
import geometry.Rectangle;
import geometry.Circle;
import geometry.Donut;
import geometry.Shape;


public class PnlDrawing extends JPanel implements MouseListener{
	
	private static final long serialVersionUID = 1L;
	static int obj = 0;
	public int msx;
	public int msy;
	public static ArrayList<Shape> shapesArrList = new ArrayList<Shape>();
	private Point startLine = null;
	private Color selectedOutlineColor = DrawingFrm.outline;
	private Color selectedAreaColor = DrawingFrm.area;
	
	public PnlDrawing() {
		addMouseListener(this);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2d = (Graphics2D) g;

	    g2d.setColor(selectedOutlineColor);

	    for (Shape shape : shapesArrList) {
	        shape.draw(g2d);
	    }
	}

	
	public void paint(Graphics g) {
		super.paint(g);
		for (Shape shape : shapesArrList) {
			shape.AreaPainter(g);
			shape.draw(g);
		}
		repaint();
	}
	
	public Color getSelectedOutlineColor() {
		return selectedOutlineColor;
	}

	public Color getSelectedAreaColor() {
		return selectedAreaColor;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		msx = e.getX();
		msy = e.getY();
		
		switch (obj) {
		case 1:
			Point p = new Point(msx, msy, false);
			//p.setOutline(DrawingFrm.outline);
			shapesArrList.add(p);
			System.out.println(shapesArrList);
			break;
		case 2:
			if (startLine == null) {
				startLine = new Point(msx, msy, false);
			} else {
				Point endLine = new Point(msx, msy);
				Line line = new Line(startLine, endLine, false);
				line.setOutline(DrawingFrm.outline);
				shapesArrList.add(line);
				startLine = null;
			}
			break;
		case 3:
			DlgRectangle dlgRectangle = new DlgRectangle();
			dlgRectangle.getTxtX().setText(String.valueOf(msx));
			dlgRectangle.getTxtX().setEditable(false);
			dlgRectangle.getTxtY().setText(String.valueOf(msy));
			dlgRectangle.getTxtY().setEditable(false);
			dlgRectangle.setVisible(true);
			if (dlgRectangle.isOk == true) {
				Rectangle r = new Rectangle(new Point(msx, msy), Integer.parseInt(dlgRectangle.getTxtWidth().getText()),
						Integer.parseInt(dlgRectangle.getTxtHeight().getText()));
				r.setOutline(DrawingFrm.outline);
				r.setFill(DrawingFrm.area);
				System.out.println(r);
				shapesArrList.add(r);
			}
			break;
		case 4:
			DlgCircle dlgCircle = new DlgCircle();
			dlgCircle.getxCoord().setText(String.valueOf(msx));
			dlgCircle.getyCoord().setText(String.valueOf(msy));
			dlgCircle.getxCoord().setEditable(false);
			dlgCircle.getyCoord().setEditable(false);
			dlgCircle.setVisible(true);
			if (dlgCircle.isOk == true) {
				Circle c = new Circle(new Point(msx, msy), Integer.parseInt(dlgCircle.getrValue().getText()));
				c.setOutline(DrawingFrm.outline);
				c.setFill(DrawingFrm.area);
				shapesArrList.add(c);
			}
			break;
		case 5:
			DlgDonut dlgDonut = new DlgDonut();
			dlgDonut.getxCoord().setText(String.valueOf(msx));
			dlgDonut.getxCoord().setEditable(false);
			dlgDonut.getyCoord().setText(String.valueOf(msy));
			dlgDonut.getyCoord().setEditable(false);
			dlgDonut.setVisible(true);
			if (dlgDonut.isOk == true) {
				Donut d = new Donut(new Point(msx, msy), Integer.parseInt(dlgDonut.getrValue().getText()),
						Integer.parseInt(dlgDonut.getIrValue().getText()));
				d.setOutline(DrawingFrm.outline);
				d.setFill(DrawingFrm.area);
				shapesArrList.add(d);
			}
			break;
		case 6:
			boolean match = false;
			Collections.reverse(shapesArrList);
			for (Shape shape : shapesArrList) {
				shape.setSelected(false);
				if (match == false) {
					if (shape.contains(msx, msy)) {
						shape.setSelected(true);
						match = true;
					}
				}
			}
			Collections.reverse(shapesArrList);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

	public void setSelectedOutlineColor(Color outline) {
		// TODO Auto-generated method stub
		
	}

	public void setSelectedAreaColor(Color area) {
		// TODO Auto-generated method stub
		
	}

}