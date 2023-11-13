package skeleton;
import java.awt.*;
// CMSC 330 Advanced Programming Languages
// Matthew Gregorek Project 1
// Spring 2023
// Class that defines a hollow right triangle

class RightTriangle extends HollowPolygon {
    // Constructor that initializes the vertices of the right triangle
	// THIS TRIANGLE WILL BE HOLLOW 

    public RightTriangle(Color color, Point upperLeft, int height, int width) {
        super(color, 3);
        int[] x_points = {upperLeft.x, upperLeft.x, upperLeft.x + width};
        int[] y_points = {upperLeft.y, upperLeft.y + height, upperLeft.y + height};
        createPolygon(x_points, y_points);
    }
}
