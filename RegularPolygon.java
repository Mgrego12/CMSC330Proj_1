package skeleton;
import java.awt.*;
//CMSC 330 Advanced Programming Languages
//Matthew Gregorek CMSC 330 Project 1
//Spring 2023

// Class that defines a hollow right triangle

class RegularPolygon extends SolidPolygon {

    // RegularPolygon that will produce SOLID POLYGON SHAPE, NOT a TRIANGLE SHAPE

    public RegularPolygon(Color color, Point center, int radius, int sides) {
        super(color, sides);
    	
        // h is the distance between the middle line of the hexagon 
        // and the line between the two top points of the hexagon 
        // FORMULA FROM WORD DOC for Polygon Shape has been added.
		int h = (int)(80 * Math.sqrt(3.0/4.0)); 
		  
		int[] xPoints = {center.x - radius/2, center.x + radius/2, center.x + radius, 
				center.x + radius/2, center.x - radius/2, center.x - radius};
		int[] yPoints = {center.y - h, center.y - h, center.y, center.y + h, center.y + h,
		  center.y }; 
		
		createPolygon(xPoints, yPoints);
    }
}