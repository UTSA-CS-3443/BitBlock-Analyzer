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
	
		/**A class constant immutable map that contains all the token-color associations*/
		@SuppressWarnings("unused")
	private static final Map<String, Color> PALETTE;
	
	static {		//List of all associations
		Map<String, Color> aMap = new HashMap<String, Color>();
	    	aMap.put("if", Color.web("#000"));
	    	aMap.put("else", Color.web("#000"));
	    
	    //List of literals. they are contains in shades _ and _
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
	    	aMap.put("=", Color.web("#000"));
	    	aMap.put("+", Color.web("#000"));
	    	aMap.put(";", Color.web("#000"));
	    	aMap.put(":", Color.web("#000"));
	    	aMap.put("'", Color.web("#000"));
	    	aMap.put("\"", Color.web("#000"));
	    	aMap.put("\\", Color.web("#000"));
	    	aMap.put("|", Color.web("#000"));
	    	aMap.put("/", Color.web("#000"));
	    	aMap.put("?", Color.web("#000"));
	    	aMap.put("<", Color.web("#000"));
	    	aMap.put(">", Color.web("#000"));
	    	aMap.put(",", Color.web("#000"));
	    	aMap.put(".", Color.web("#000"));
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
	    	aMap.put("(", Color.web("#000"));
	    	aMap.put(")", Color.web("#000"));
	    	aMap.put("{", Color.web("#000"));
	    	aMap.put("}", Color.web("#000"));
	    	aMap.put("[", Color.web("#000"));
	    	aMap.put("]", Color.web("#000"));
	    	PALETTE = Collections.unmodifiableMap(aMap);
	}
	
}
