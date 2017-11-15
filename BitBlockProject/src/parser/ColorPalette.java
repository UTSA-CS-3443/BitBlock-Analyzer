package parser;

import java.util.*;	//map classes
import javafx.scene.paint.Color;

/**
 * A color palette for use in producing a BitBlock. 
 * Contains all the colors and their code equivelents.
 * "needs to have 1 to 1 mapping"
 * @author Triston Scallan
 *
 */
public class ColorPalette {
	//TODO: create a CONSTANT variable, a hash map that sets keys (expressions and literals) to values (colors)
	//TODO: find a list of commonly used java statements. look up generic java files and skim for top 15% used java statements.
		/**A class constant immutable map that contains all the token-color associations*/
	public static final Map<String, Color> PALETTE;
	
	static {		//List of all associations
		Map<String, Color> aMap = new HashMap<String, Color>();
	    //Built in statements
			//types TODO: build logic to recognize casting a type vs declaring a type
	    	aMap.put("int", Color.web("#000"));
	    	aMap.put("Integer", Color.web("#000"));
	    	aMap.put("double", Color.web("#000"));
	    	aMap.put("Double", Color.web("#000"));
	    	aMap.put("boolean", Color.web("#000"));
	    	aMap.put("char", Color.web("#000"));
	    	aMap.put("String", Color.web("#000"));
	    	aMap.put("long", Color.web("#000"));
	    	aMap.put("Long", Color.web("#000"));
	    	aMap.put("void", Color.web("#000"));
	    	aMap.put("Void", Color.web("#000"));
	    		//declarations
	    	aMap.put("private", Color.web("#000"));
	    	aMap.put("public", Color.web("#000"));
	    	aMap.put("protected", Color.web("#000"));
	    	aMap.put("import", Color.web("#000"));
	    	aMap.put("package", Color.web("#000"));
	    	aMap.put("class", Color.web("#000"));
	    	aMap.put("extends", Color.web("#000"));
	    	aMap.put("implements", Color.web("#000"));
	    	aMap.put("static", Color.web("#000"));
	    	aMap.put("final", Color.web("#000"));
	    	aMap.put("new", Color.web("#000"));
	    		//commonly called class-objects
	    	aMap.put("List", Color.web("#000"));
	    	aMap.put("Collections", Color.web("#000"));
	    	aMap.put("Iterator", Color.web("#000"));
	    	aMap.put("Map", Color.web("#000"));
	    	aMap.put("ArrayList", Color.web("#000"));
	    	aMap.put("Array", Color.web("#000"));
	    	aMap.put("args", Color.web("#000"));
	    		//commonly used statements
	    	aMap.put("System", Color.web("#000"));
	    	aMap.put("out", Color.web("#000"));
	    	aMap.put("print", Color.web("#000"));
	    	aMap.put("println", Color.web("#000"));
	    	aMap.put("printf", Color.web("#000"));
	    		//flow control TODO: flow control could use a bit of deterministic logic
	    	aMap.put("if", Color.web("#000"));
	    	aMap.put("else", Color.web("#000"));
	    	aMap.put("while", Color.web("#000"));
	    	aMap.put("do", Color.web("#000"));
	    	aMap.put("for", Color.web("#000")); 
	    	aMap.put("break", Color.web("#000"));
	    	aMap.put("next", Color.web("#000"));
	    	aMap.put("continue", Color.web("#000"));
	    	aMap.put("cancel", Color.web("#000"));
	    	aMap.put("switch", Color.web("#000"));
	    	aMap.put("case", Color.web("#000"));
	    	aMap.put("return", Color.web("#000"));
	    		//logic
	    	aMap.put("true", Color.web("#000"));
	    	aMap.put("false", Color.web("#000"));
	    	aMap.put("==", Color.web("#000"));
	    	aMap.put("!=", Color.web("#000"));
	    	aMap.put("<", Color.web("#000"));
	    	aMap.put(">", Color.web("#000"));
	    	aMap.put("<=", Color.web("#000"));
	    	aMap.put(">=", Color.web("#000"));
	    	aMap.put("&&", Color.web("#000"));
	    	aMap.put("||", Color.web("#000"));
	    		//comments and javadoc  TODO: all tokens after and before comments should be ignored
	    	aMap.put("//", Color.web("#000"));
	    	aMap.put("/*", Color.web("#000"));
	    	aMap.put("/**", Color.web("#000"));
	    	//aMap.put("*", Color.web("#000")); TODO: KEEP IN MIND ABOUT LINES THAT START WITH STAR
	    	aMap.put("*/", Color.web("#000"));
	    	aMap.put("@{word}", Color.web("#000")); //TODO: write logic to ignore tokens of @{words}
	    	aMap.put(">", Color.web("#000"));
	    
	    //List of literals. they are contained in shades _ and _
	    		//alphabet
	    	aMap.put("a", Color.web("#000"));
	    	aMap.put("A", Color.web("#000"));
	    	aMap.put("b", Color.web("#000"));
	    	aMap.put("B", Color.web("#000"));
	    	aMap.put("c", Color.web("#000"));
	    	aMap.put("C", Color.web("#000"));
	    	aMap.put("d", Color.web("#000"));
	    	aMap.put("D", Color.web("#000"));
	    	aMap.put("e", Color.web("#000"));
	    	aMap.put("E", Color.web("#000"));
	    	aMap.put("f", Color.web("#000"));
	    	aMap.put("F", Color.web("#000"));
	    	aMap.put("g", Color.web("#000"));
	    	aMap.put("G", Color.web("#000"));
	    	aMap.put("h", Color.web("#000"));
	    	aMap.put("H", Color.web("#000"));
	    	aMap.put("i", Color.web("#000"));
	    	aMap.put("I", Color.web("#000"));
	    	aMap.put("j", Color.web("#000"));
	    	aMap.put("J", Color.web("#000"));
	    	aMap.put("k", Color.web("#000"));
	    	aMap.put("K", Color.web("#000"));
	    	aMap.put("l", Color.web("#000"));
	    	aMap.put("L", Color.web("#000"));
	    	aMap.put("m", Color.web("#000"));
	    	aMap.put("M", Color.web("#000"));
	    	aMap.put("n", Color.web("#000"));
	    	aMap.put("N", Color.web("#000"));
	    	aMap.put("o", Color.web("#000"));
	    	aMap.put("O", Color.web("#000"));
	    	aMap.put("p", Color.web("#000"));
	    	aMap.put("P", Color.web("#000"));
	    	aMap.put("q", Color.web("#000"));
	    	aMap.put("Q", Color.web("#000"));
	    	aMap.put("r", Color.web("#000"));
	    	aMap.put("R", Color.web("#000"));
	    	aMap.put("s", Color.web("#000"));
	    	aMap.put("S", Color.web("#000"));
	    	aMap.put("t", Color.web("#000"));
	    	aMap.put("T", Color.web("#000"));
	    	aMap.put("u", Color.web("#000"));
	    	aMap.put("U", Color.web("#000"));
	    	aMap.put("v", Color.web("#000"));
	    	aMap.put("V", Color.web("#000"));
	    	aMap.put("w", Color.web("#000"));
	    	aMap.put("W", Color.web("#000"));
	    	aMap.put("x", Color.web("#000"));
	    	aMap.put("X", Color.web("#000"));
	    	aMap.put("y", Color.web("#000"));
	    	aMap.put("Y", Color.web("#000"));
	    	aMap.put("z", Color.web("#000"));
	    	aMap.put("Z", Color.web("#000"));
	    		//numerics
	    	aMap.put("1", Color.web("#000"));
	    	aMap.put("2", Color.web("#000"));
	    	aMap.put("3", Color.web("#000"));
	    	aMap.put("4", Color.web("#000"));
	    	aMap.put("5", Color.web("#000"));
	    	aMap.put("6", Color.web("#000"));
	    	aMap.put("7", Color.web("#000"));
	    	aMap.put("8", Color.web("#000"));
	    	aMap.put("9", Color.web("#000"));
	    	aMap.put("0", Color.web("#000"));
	    		//symbols
	    	aMap.put("-", Color.web("#000"));
	    	aMap.put("_", Color.web("#000"));
	    	aMap.put("=", Color.web("#000"));	//equal is kinda special as assignment, TODO: brainstorm more about logic of = in tokens 
	    	aMap.put("+", Color.web("#000"));
	    	aMap.put("\\", Color.web("#000"));
	    	aMap.put("|", Color.web("#000"));
	    	aMap.put("/", Color.web("#000"));
	    	aMap.put("?", Color.web("#000"));
	    	aMap.put("!", Color.web("#000"));
	    	aMap.put("@", Color.web("#000"));
	    	aMap.put("#", Color.web("#000"));
	    	aMap.put("$", Color.web("#000"));
	    	aMap.put("%", Color.web("#000"));
	    	aMap.put("^", Color.web("#000"));
	    	aMap.put("&", Color.web("#000"));
	    	aMap.put("*", Color.web("#000"));
	    	aMap.put("`", Color.web("#000"));
	    	aMap.put("~", Color.web("#000"));
	    		//delimiters
	    	aMap.put(",", Color.web("#000"));
	    	aMap.put(".", Color.web("#000"));	//TODO: if "." is found in a token, potentially break up the token before and after the periods, to see if any of them match a common method
	    	aMap.put(";", Color.web("#000"));
	    	aMap.put(":", Color.web("#000"));
	    	aMap.put("'", Color.web("#000"));
	    	aMap.put("\"", Color.web("#000"));
	    	aMap.put("(", Color.web("#000"));
	    	aMap.put(")", Color.web("#000"));
	    	aMap.put("{", Color.web("#000"));
	    	aMap.put("}", Color.web("#000"));
	    	aMap.put("[", Color.web("#000"));
	    	aMap.put("]", Color.web("#000"));
	    	aMap.put("\n", Color.web("#000")); 	//newline!
	    	PALETTE = Collections.unmodifiableMap(aMap);
	}
	
}
