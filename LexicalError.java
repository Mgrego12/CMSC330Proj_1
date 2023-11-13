package skeleton;

//CMSC 330 Advanced Programming Languages
//Matthew Gregorek CMSC 330 Project 1
//Spring 2023
// Class that defines a hollow right triangle
// STEP 6: ISOSCELES class (Extends SolidPolygon) Has been Added.
// Class that defines a lexical error

class LexicalError extends Exception{
    // Constructor that creates a lexical error object given the line number and error
    public LexicalError(int line, String description)    {
        super("Lexical Error on Line: " + line + " " + description);
    }
}