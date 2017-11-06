package org.collection;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import math.geom2d.*;
import math.geom2d.line.LineSegment2D;
import math.geom2d.point.KDTree2D;

/**
 * Demo of range search using a kd-tree in 2 dimensions.
 */
public class RangeSearchKDTree2DRandomDemo extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private static int nbPoints = 500;
	
	ArrayList<Point2D> points;
	KDTree2D tree;
	Box2D range;
	
	public RangeSearchKDTree2DRandomDemo() {
		super();
		
		// Point coordinate are multiplied by 10 for better drawing
		points = new ArrayList<Point2D>(nbPoints);
		for(int i=0; i<nbPoints; i++){
		    points.add(new Point2D(
		            Math.random()*300+50,
		            Math.random()*300+50));
		}
		
		tree = new KDTree2D(points);
		
		range = new Box2D(100, 200, 200, 300);
		
		this.setBackground(Color.WHITE);
	}
	
	public void paintComponent(Graphics g){
	    super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		
		drawTree(g2, tree.getRoot(), 0, 50, 350, 50, 350);
		
		g2.setColor(Color.BLACK);
		new Box2D(50, 350, 50, 350).draw(g2);
        
        g2.setColor(Color.RED);
        for(Point2D point : tree.rangeSearch(range)){
            point.draw(g2, 1.5);
        }
        range.draw(g2);
	}

	private void drawTree(Graphics2D g2, KDTree2D.Node node, int step,
	        double xmin, double xmax, double ymin, double ymax) {
	    if(node==null)
	        return;
	    
	    int dir = step%2;
	    Point2D point = node.getPoint();
        double x = point.getX();
        double y = point.getY();
        
	    if(dir==0){
	        // Draw vertical line
	        g2.setColor(Color.BLUE);
            new LineSegment2D(x, ymin, x, ymax).draw(g2);
	        
	        // reduce x range for each sub tree
	        drawTree(g2, node.getLeftChild(), step+1, 
	                xmin, x, ymin, ymax);
	        drawTree(g2, node.getRightChild(), step+1, 
	                x, xmax, ymin, ymax);
	    } else {
	        // Draw horizontal line
	        g2.setColor(Color.BLUE);
	        new LineSegment2D(xmin, y, xmax, y).draw(g2);
	        
	        // reduce y range for each sub tree
	        drawTree(g2, node.getLeftChild(), step+1, 
	                xmin, xmax, ymin, y);
	        drawTree(g2, node.getRightChild(), step+1, 
	                xmin, xmax, y, ymax);
	    }
	    
	    g2.setColor(Color.BLACK);
        point.draw(g2, 1.5);
	}

	public final static void main(String[] args){
		
            if(args.length>0 ) {
                nbPoints = Integer.parseInt(args[0]);
            }
            
            JPanel panel = new RangeSearchKDTree2DRandomDemo();
		JFrame frame = new JFrame("Draw KD Tree Demo");
		frame.setContentPane(panel);
		frame.setSize(500, 400);
                
                
                
		frame.setVisible(true);
	}
}