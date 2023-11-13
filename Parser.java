package skeleton;
import java.awt.*;
import java.io.*;
//CMSC 330 Advanced Programming Languages
//Matthew Gregorek CMSC 330 Project 1
//Spring 2023

class Parser {
    private Token token;
    private Lexer lexer;
    // Constructor to create new lexical analyzer from input file
    public Parser(File file) throws IOException {
        lexer = new Lexer(file);
    }

    // Parses the production
    // scene -> SCENE IDENTIFIER number_list images END '.'
    public Scene parseScene() throws LexicalError, SyntaxError, IOException {
        verifyNextToken(Token.SCENE);
        verifyNextToken(Token.IDENTIFIER);
        String window = lexer.getLexeme();        
        int[] dimensions = getNumberList(2);
        Scene scene = new Scene(window, dimensions[0], dimensions[1]);    
        parseImages(scene, lexer.getNextToken());
        verifyNextToken(Token.PERIOD);
        return scene;
    }
    // Parses the following productions
    // images -> image images | image
    // image -> right_triangle | rectangle
    // right_triangle -> RIGHT_TRIANGLE COLOR number_list AT number_list HEIGHT NUMBER WIDTH NUMBER ';'
    // rectangle -> RECTANGLE_ COLOR number_list AT number_list HEIGHT NUMBER WIDTH NUMBER ';'
    private void parseImages(Scene scene, Token imageToken) throws LexicalError,
    	SyntaxError, IOException {
    	int height, width, offset, radius;
        verifyNextToken(Token.COLOR);
        int[] colors = getNumberList(3);
        Color color = new Color(colors[0], colors[1], colors[2]);
        verifyNextToken(Token.AT);
        int[] location = getNumberList(2);
        Point point = new Point(location[0], location[1]);
        // STEP 3: RIGHT_TRIANGLE code has been added.
        if (imageToken == Token.RIGHT_TRIANGLE) {
        	verifyNextToken(Token.HEIGHT);
            verifyNextToken(Token.NUMBER);
            height = lexer.getNumber();
            verifyNextToken(Token.WIDTH);
            verifyNextToken(Token.NUMBER);
            width = lexer.getNumber();
            RightTriangle triangle = new RightTriangle(color, point, height, width);
            scene.addImage(triangle);   	   
        }	        
        else if (imageToken == Token.RECTANGLE) {
            verifyNextToken(Token.HEIGHT);
            verifyNextToken(Token.NUMBER);
            height = lexer.getNumber();
            verifyNextToken(Token.WIDTH);
            verifyNextToken(Token.NUMBER);
            width = lexer.getNumber();
            Rectangle rectangle = new Rectangle(color, point, height, width);
            scene.addImage(rectangle);
        }
		else if (imageToken == Token.ISOSCELES) {			
			verifyNextToken(Token.HEIGHT); 
			verifyNextToken(Token.NUMBER); 
			height = lexer.getNumber(); 
			verifyNextToken(Token.WIDTH);
			verifyNextToken(Token.NUMBER); 
			width = lexer.getNumber(); 
			
			Isosceles isosceles = new Isosceles(color, point, height, width);
			scene.addImage(isosceles); 
		} 
		else if (imageToken == Token.PARALLELOGRAM) {
			int[] lowerRight = getNumberList(2);
			Point lowerPoint = new Point(lowerRight[0], lowerRight[1]);
            verifyNextToken(Token.OFFSET);
            token = lexer.getNextToken();
            offset = lexer.getNumber();
            
            Parallelogram parallelogram = new Parallelogram(color, point, lowerPoint, offset);
            scene.addImage(parallelogram);
		}
		else if (imageToken == Token.REGULARPOLYGON) {
			verifyNextToken(Token.SIDES);
			token = lexer.getNextToken();
			int sides = lexer.getNumber();
			verifyNextToken(Token.RADIUS);
			token = lexer.getNextToken();
			radius = lexer.getNumber();
			
            RegularPolygon regularPolygon = new RegularPolygon(color, point, radius, sides);
            scene.addImage(regularPolygon);
		}
		else if (imageToken == Token.TEXT) {
            lexer.getNextToken();
            String textOutput = lexer.getLexeme();            
            Text text = new Text(color, point, textOutput);
            scene.addImage(text);
		}
        else {
             throw new SyntaxError(lexer.getLineNo(), "Unexpected image name " + imageToken);
        }
        verifyNextToken(Token.SEMICOLON);
        token = lexer.getNextToken();
        
        if (token != Token.END)
            parseImages(scene, token);
    }
    // Parses the following productions
    // number_list -> '(' numbers ')'
    // numbers -> NUMBER | NUMBER ',' numbers
    // Returns an array of the numbers in the number list

    private int[]  getNumberList(int count) throws LexicalError, SyntaxError, IOException {
        int[] list = new int[count];
        verifyNextToken(Token.LEFT_PAREN);
        for (int i = 0; i < count; i++) {
            verifyNextToken(Token.NUMBER);
            list[i] = lexer.getNumber();
            token = lexer.getNextToken();
            if (i < count - 1)
                verifyCurrentToken(Token.COMMA);
            else
                verifyCurrentToken(Token.RIGHT_PAREN);
        }
        return list;
    }
    // Verifies that the next token is the expected token
    private void verifyNextToken(Token expectedToken) throws LexicalError, SyntaxError, IOException {
        token = lexer.getNextToken();
        
        verifyCurrentToken(expectedToken);
    }
    // Verifies that the current token is the expected token
    private void verifyCurrentToken(Token expectedToken) throws SyntaxError {
    	
        if (token != expectedToken)
            throw new SyntaxError(lexer.getLineNo(), "Expecting token " + expectedToken + 
            		" not " + token);
    }
}