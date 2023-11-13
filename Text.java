package skeleton;
import java.awt.*;
//CMSC 330 Advanced Programming Languages
//Matthew Gregorek CMSC 330 Project 1
//Spring 2023
public class Text extends Image {
    public Point location;
    public String text;

    // Constructor to initialize the color, location, and text to be displayed
    public Text(Color color, Point location, String text) {
        super(color);
        this.location = location;
        this.text = text;
    }

    // Overrides the draw method to display text on the screen
    @Override
    public void draw(Graphics graphics) {
        colorDrawing(graphics);
        graphics.drawString(text, location.x, location.y);
    }
}
