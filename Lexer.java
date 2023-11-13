package skeleton;
import java.io.*;
//CMSC 330 Advanced Programming Languages
//Matthew Gregorek CMSC 330 Project 1
//Spring 2023

// Class that defines a hollow right triangle
// STEP 6: ISOSCELES class (Extends SolidPolygon) Has been Added.
// This class provides the lexical analyzer for project 1

class Lexer {
    private static final int KEYWORDS = 23;
    private StreamTokenizer tokenizer;
    private String punctuation = ",;.()";
    private Token[] punctuationTokens = {Token.COMMA, Token.SEMICOLON, Token.PERIOD, 
    		Token.LEFT_PAREN, Token.RIGHT_PAREN };

    // Constructor that creates a lexical analyzer object given the source file
    public Lexer(File file) throws FileNotFoundException {
        tokenizer = new StreamTokenizer(new FileReader(file));
        tokenizer.ordinaryChar('.');
        tokenizer.quoteChar('"');
    }
    // Returns the next token in the input stream
    public Token getNextToken() throws LexicalError, IOException {
    	/*("TT_NUMBER = "+ StreamTokenizer.TT_NUMBER );
		("TT_WORD = "+ StreamTokenizer.TT_WORD );
		("TT_EOF = "+ StreamTokenizer.TT_EOF );
		("TT_EOL = "+ StreamTokenizer.TT_EOL );*/
		
        int token = tokenizer.nextToken();
        // TOKENIZERS nval/sval printed for TT_NUMBER and TT_WORD, EOF
        switch (token) {
            case StreamTokenizer.TT_NUMBER:
            	System.out.println("Number = " + tokenizer.nval);
                return Token.NUMBER;
            case StreamTokenizer.TT_WORD:
            	System.out.println("String = " + tokenizer.sval);
                for (Token aToken : Token.values()) {
                    if (aToken.ordinal() == KEYWORDS) {                    
                        break;
                        }
                    if (aToken.name().replace("_","").equals(tokenizer.sval.toUpperCase())) {                    	
                        return aToken;
                        }
                    }
                return Token.IDENTIFIER;
            case StreamTokenizer.TT_EOF:
                return Token.EOF;
            default:
                for (int i = 0; i < punctuation.length(); i++)
                    if (token == punctuation.charAt(i)) {
                    	System.out.println("Symbol = " + (char)token);
                        return punctuationTokens[i];
                    }    
        }
        return Token.EOF;
    }
    // Returns the lexeme associated with the current token
    public String getLexeme() {
        return tokenizer.sval;
    }
    // Returns the numeric value of the current token for numeric tokens
    public int getNumber() {
        return (int) tokenizer.nval;
    }
    // Returns the current line of the input file
    public int getLineNo() {
        return tokenizer.lineno();
    }
}
