package skeleton;
import java.awt.*;
//CMSC 330 Advanced Programming Languages
//Matthew Gregorek CMSC 330 Project 1
//Spring 2023
// Class that defines a hollow right triangle
// STEP 6: ISOSCELES class (Extends SolidPolygon) Has been Added.

class Isosceles extends SolidPolygon {

    // Constructor that initializes the vertices of the right triangle

    public Isosceles(Color color, Point upperLeft, int height, int width) {
        super(color, 3);
    	
        int[] x_points = {upperLeft.x, upperLeft.x - width/2, upperLeft.x + width/2};
        int[] y_points = {upperLeft.y, upperLeft.y + height, upperLeft.y + height};
        createPolygon(x_points, y_points);
    }
}