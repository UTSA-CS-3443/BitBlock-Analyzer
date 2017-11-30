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
	    	aMap.put("int", Color.web("0x000000"));
	    	aMap.put("Integer", Color.web("0x000000"));
	    	aMap.put("double", Color.web("0x000000"));
	    	aMap.put("Double", Color.web("0x000000"));
	    	aMap.put("boolean", Color.web("0x000000"));
	    	aMap.put("char", Color.web("0x000000"));
	    	aMap.put("String", Color.web("0x000000"));
	    	aMap.put("long", Color.web("0x000000"));
	    	aMap.put("Long", Color.web("0x000000"));
	    	aMap.put("void", Color.web("0x000000"));
	    	aMap.put("Void", Color.web("0x000000"));
	    		//declarations
	    	aMap.put("private", Color.web("0x000000"));
	    	aMap.put("public", Color.web("0x000000"));
	    	aMap.put("protected", Color.web("0x000000"));
	    	aMap.put("import", Color.web("0x000000"));
	    	aMap.put("package", Color.web("0x000000"));
	    	aMap.put("class", Color.web("0x000000"));
	    	aMap.put("extends", Color.web("0x000000"));
	    	aMap.put("implements", Color.web("0x000000"));
	    	aMap.put("static", Color.web("0x000000"));
	    	aMap.put("final", Color.web("0x000000"));
	    	aMap.put("new", Color.web("0x000000"));
	    		//commonly called class-objects
	    	aMap.put("Main", Color.web("0x000000"));
	    	aMap.put("List", Color.web("0x000000"));
	    	aMap.put("Collections", Color.web("0x000000"));
	    	aMap.put("Iterator", Color.web("0x000000"));
	    	aMap.put("Map", Color.web("0x000000"));
	    	aMap.put("ArrayList", Color.web("0x000000"));
	    	aMap.put("Array", Color.web("0x000000"));
	    	aMap.put("args", Color.web("0x000000"));
	    		//commonly used statements
	    	aMap.put("System", Color.web("0x000000"));
	    	aMap.put("out", Color.web("0x000000"));
	    	aMap.put("print", Color.web("0x000000"));
	    	aMap.put("println", Color.web("0x000000"));
	    	aMap.put("printf", Color.web("0x000000"));
	    		//flow control TODO: flow control could use a bit of deterministic logic
	    	aMap.put("if", Color.web("0x000000"));
	    	aMap.put("else", Color.web("0x000000"));
	    	aMap.put("while", Color.web("0x000000"));
	    	aMap.put("do", Color.web("0x000000"));
	    	aMap.put("for", Color.web("0x000000"));
	    	aMap.put("break", Color.web("0x000000"));
	    	aMap.put("next", Color.web("0x000000"));
	    	aMap.put("continue", Color.web("0x000000"));
	    	aMap.put("cancel", Color.web("0x000000"));
	    	aMap.put("switch", Color.web("0x000000"));
	    	aMap.put("case", Color.web("0x000000"));
	    	aMap.put("return", Color.web("0x000000"));
	    	aMap.put("try", Color.web("0x000000"));
	    	aMap.put("catch", Color.web("0x000000"));
	    	aMap.put("finally", Color.web("0x000000"));
	    		//logic
	    	aMap.put("true", Color.web("0x000000"));
	    	aMap.put("false", Color.web("0x000000"));
	    	aMap.put("null", Color.web("0x000000"));
	    	aMap.put("==", Color.web("0x000000"));
	    	aMap.put("!=", Color.web("0x000000"));
	    	aMap.put("<", Color.web("0x000000"));
	    	aMap.put(">", Color.web("0x000000"));
	    	aMap.put("<=", Color.web("0x000000"));
	    	aMap.put(">=", Color.web("0x000000"));
	    	aMap.put("&&", Color.web("0x000000"));
	    	aMap.put("||", Color.web("0x000000"));
	    		//comments and javadoc: all tokens after and before comments should be ignored
	    	aMap.put("//", Color.web("0x000000"));
	    	aMap.put("/*", Color.web("0x000000"));
	    	aMap.put("/**", Color.web("0x000000"));
	    	//aMap.put("*", Color.web("0x000000"));
	    	aMap.put("*/", Color.web("0x000000"));
	    	aMap.put("@{word}", Color.web("0x000000")); //TODO: write logic to ignore tokens of @{words}
	    	aMap.put(">", Color.web("0x000000"));

	    //List of literals. they are contained in shades _ and _
	    		//alphabet
	    	aMap.put("a", Color.web("0xFF2200"));
	    	aMap.put("A", Color.web("0xF92200"));
	    	aMap.put("b", Color.web("0xEF2200"));
	    	aMap.put("B", Color.web("0xE92200"));
	    	aMap.put("c", Color.web("0xDF2200"));
	    	aMap.put("C", Color.web("0xD92200"));
	    	aMap.put("d", Color.web("0xCF2200"));
	    	aMap.put("D", Color.web("0xC92200"));
	    	aMap.put("e", Color.web("0xBF2200"));
	    	aMap.put("E", Color.web("0xB92200"));
	    	aMap.put("f", Color.web("0xAF2200"));
	    	aMap.put("F", Color.web("0xA92200"));
	    	aMap.put("g", Color.web("0x9F2200"));
	    	aMap.put("G", Color.web("0x992200"));
	    	aMap.put("h", Color.web("0x8F2200"));
	    	aMap.put("H", Color.web("0x892200"));
	    	aMap.put("i", Color.web("0x7F2200"));
	    	aMap.put("I", Color.web("0x792200"));
	    	aMap.put("j", Color.web("0xFF2222"));
	    	aMap.put("J", Color.web("0xF92222"));
	    	aMap.put("k", Color.web("0xEF2222"));
	    	aMap.put("K", Color.web("0xE92222"));
	    	aMap.put("l", Color.web("0xDF2222"));
	    	aMap.put("L", Color.web("0xD92222"));
	    	aMap.put("m", Color.web("0xCF2222"));
	    	aMap.put("M", Color.web("0xC92222"));
	    	aMap.put("n", Color.web("0xBF2222"));
	    	aMap.put("N", Color.web("0xB92222"));
	    	aMap.put("o", Color.web("0xAF2222"));
	    	aMap.put("O", Color.web("0xA92222"));
	    	aMap.put("p", Color.web("0x9F2222"));
	    	aMap.put("P", Color.web("0x992222"));
	    	aMap.put("q", Color.web("0x8F2222"));
	    	aMap.put("Q", Color.web("0x892222"));
	    	aMap.put("r", Color.web("0x7F2222"));
	    	aMap.put("R", Color.web("0x792222"));
	    	aMap.put("s", Color.web("0xFF2244"));
	    	aMap.put("S", Color.web("0xF92244"));
	    	aMap.put("t", Color.web("0xEF2244"));
	    	aMap.put("T", Color.web("0xE92244"));
	    	aMap.put("u", Color.web("0xDF2244"));
	    	aMap.put("U", Color.web("0xD92244"));
	    	aMap.put("v", Color.web("0xCF2244"));
	    	aMap.put("V", Color.web("0xC92244"));
	    	aMap.put("w", Color.web("0xBF2244"));
	    	aMap.put("W", Color.web("0xB92244"));
	    	aMap.put("x", Color.web("0xAF2244"));
	    	aMap.put("X", Color.web("0xA92244"));
	    	aMap.put("y", Color.web("0x9F2244"));
	    	aMap.put("Y", Color.web("0x992244"));
	    	aMap.put("z", Color.web("0x8F2244"));
	    	aMap.put("Z", Color.web("0x892244"));
	    		//numerics
	    	aMap.put("1", Color.web("0xFF4400"));
	    	aMap.put("2", Color.web("0xF94400"));
	    	aMap.put("3", Color.web("0xEF4400"));
	    	aMap.put("4", Color.web("0xE94400"));
	    	aMap.put("5", Color.web("0xDF4400"));
	    	aMap.put("6", Color.web("0xD94400"));
	    	aMap.put("7", Color.web("0xCF4400"));
	    	aMap.put("8", Color.web("0xC94400"));
	    	aMap.put("9", Color.web("0xB74400"));
	    	aMap.put("0", Color.web("0xB94400"));
	    		//symbols
	    	aMap.put("-", Color.web("0xAF4400"));
	    	aMap.put("_", Color.web("0xA94400"));
	    	aMap.put("=", Color.web("0xDD22FF"));	//equal is kinda special as assignment, TODO: brainstorm more about logic of = in tokens
	    	aMap.put("+", Color.web("0xFF6644"));
	    	aMap.put("\\", Color.web("0xF96644"));
	    	aMap.put("|", Color.web("0xEF6644"));
	    	aMap.put("/", Color.web("0xE96644"));
	    	aMap.put("?", Color.web("0xDF6644"));
	    	aMap.put("!", Color.web("0xD96644"));
	    	aMap.put("@", Color.web("0xCF6644"));
	    	aMap.put("#", Color.web("0xC96644"));
	    	aMap.put("$", Color.web("0xBF6644"));
	    	aMap.put("%", Color.web("0xB96644"));
	    	aMap.put("^", Color.web("0xAF6644"));
	    	aMap.put("&", Color.web("0xA96644"));
	    	aMap.put("*", Color.web("0x9F6644"));
	    	aMap.put("`", Color.web("0x996644"));
	    	aMap.put("~", Color.web("0x8F6644"));
	    		//delimiters
	    	aMap.put(" ", Color.web("0xFF7700"));
	    	aMap.put("/t", Color.web("0xF97700"));
	    	aMap.put(",", Color.web("0xEF7700"));
	    	aMap.put(".", Color.web("0xE97700"));
	    	aMap.put(";", Color.web("0xDF7700"));
	    	aMap.put(":", Color.web("0xD97700"));
	    	aMap.put("'", Color.web("0xCF7700"));
	    	aMap.put("\"", Color.web("0xC97700"));
	    	aMap.put("(", Color.web("0xFF8800"));
	    	aMap.put(")", Color.web("0xF98800"));
	    	aMap.put("{", Color.web("0xEF8800"));
	    	aMap.put("}", Color.web("0xE98800"));
	    	aMap.put("[", Color.web("0xDF8800"));
	    	aMap.put("]", Color.web("0xD98800"));
	    	aMap.put("\n", Color.web("0xCF8800")); 	//newline!
	    		//to define the end of a string of literals
	    	aMap.put("EOS", Color.web("0xFFFFFF"));	//EOS is End Of String. WHITE.
			aMap.put(null, Color.web("0x000000"))	//any null should be seen as black.
	    	PALETTE = Collections.unmodifiableMap(aMap);
	}

}
