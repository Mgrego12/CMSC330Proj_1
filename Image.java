package skeleton;
import java.awt.*;
//CMSC 330 Advanced Programming Languages
//Matthew Gregorek CMSC 330 Project 1
//Spring 2023

// Abstract base class that defines all image objects

abstract class Image {
    private Color color;

    // Constructor that can only be called by the subclasses to initialize the color
    public Image(Color color) {
        this.color = color;
    }
    // Sets the color of the image to be drawn. Must be called first by 
    // the draw function of the subclasses

    public void colorDrawing(Graphics graphics) {
        graphics.setColor(color);
    }
    abstract void draw(Graphics graphics);
}


