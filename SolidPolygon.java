package skeleton;
import java.awt.*;
//CMSC 330 Advanced Programming Languages
//Matthew Gregorek CMSC 330 Project 1
//Spring 2023

// Abstract class that defines all solid polygons
// STEP 5: SolidePoloygon(extends Polygon) has Been Added. 

abstract class SolidPolygon extends Polygon_ {
    // Constructor that calls super constructor
    public SolidPolygon(Color color, int vertexCount) {
        super(color, vertexCount);
    }
    @Override 
    public void draw(Graphics graphics) { 
		colorDrawing(graphics);
		graphics.drawPolygon(polygon); 
		graphics.fillPolygon(polygon); 
	}
	 
}