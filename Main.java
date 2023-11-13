package skeleton;
import java.io.*;
import javax.swing.*;

//CMSC 330 Advanced Programming Languages
//Matthew Gregorek CMSC 330 Project 1
//Spring 2023
// Class that defines a hollow right triangle
// STEP 6: ISOSCELES class (Extends SolidPolygon) Has been Added.

class Main {
	// The main method of the whole program, allows the name of the scene definition
	// file to be input on the
	// command line or selected using the file chooser dialog window. It calls the
	// parser to parse the scene
	// definition file and add the graphic objects to the scene.

	public static void main(String[] args) {
		File sceneFile = null;
		Scene scene;
		JFileChooser choice = new JFileChooser(new File("."));
		int option = choice.showOpenDialog(null);

		if (option == JFileChooser.APPROVE_OPTION)
			sceneFile = choice.getSelectedFile();
		try {
			Parser parser = new Parser(sceneFile);
			scene = parser.parseScene();
			scene.draw();
		} catch (SyntaxError error) {
			System.out.println(error.getMessage());
		} catch (LexicalError error) {
			System.out.println(error.getMessage());
		} catch (IOException error) {
			System.out.println("IO Error");
		}
	}
}