package skeleton;
import java.awt.*;
//CMSC 330 Advanced Programming Languages
//Matthew Gregorek CMSC 330 Project 1
//Spring 2023

// Class that defines a hollow right triangle

class Parallelogram extends SolidPolygon {
    // Constructor that initializes the vertices of the right triangle
	// CONSTRUCTOR meets requirements, Color, 2 points, offset 
    public Parallelogram(Color color, Point upperLeft, Point lowerRight, int offset) {
        super(color, 4);
        int[] x_points = {upperLeft.x, upperLeft.x - offset, lowerRight.x, lowerRight.x + offset};
        int[] y_points = {upperLeft.y, lowerRight.y, lowerRight.y, upperLeft.y};
        
        createPolygon(x_points, y_points);
    }
}