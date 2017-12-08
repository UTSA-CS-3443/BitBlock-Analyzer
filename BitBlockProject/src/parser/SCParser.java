package parser;

import java.util.*;

import bba.model.Input;
import javafx.scene.paint.Color;

/**
 * Parses the Source Code. Builds a TokenizedPixel list by taking in an input file, 
 * scans it into lines, tokenizes it, and adds it to the list token by token.
 * 
 * @author Triston Scallan
 *
 */
public class SCParser {
	
	//variable, arrayList, to hold logically related characters in an expression
		//this is to make it easier to use certain statements to flag for user-created statements
		//consider abstract syntax tree
		/** the arrayList of tokens of a single expression*/
	private List<String> tokenList = new ArrayList<String>();
	
	//variable, 2D arrayList, (to be passed to BitBLock class)
		// first column, hold ALL of the tokens parsed.
		// second column, holds the resulted parsed colors 
		/** the arrayList of TokenizedPixel type to construct a BitBlock */
	private List<TokenizedPixel> pixelList = new ArrayList<TokenizedPixel>();
	
	
	/**
	 * @return the tokenList
	 */
	public List<String> getTokenList() {
		return tokenList;
	}

	/**
	 * @param tokenList the tokenList to set
	 */
	public void setTokenList(List<String> tokenList) {
		this.tokenList = tokenList;
	}
	
	/**
	 * Adds a token to the tokenList
	 * @param index the index of the array
	 * @param token the token to add
	 */
	public void addToken(int index, String token) {
		this.tokenList.add(index, token);
	}
	
	/**
	 * Retrieves a token from the list
	 * @param index the index of the array
	 * @return the pixel at index
	 */
	public String getToken(int index) {
		return this.tokenList.get(index);
	}

	/** @return the pixelList */
	public List<TokenizedPixel> getPixelList() {
		return pixelList;
	}

	/** @param pixelList the pixelList to set */
	public void setPixelList(List<TokenizedPixel> pixelList) {
		this.pixelList = pixelList;
	}
	
	/**
	 * Adds a pixel to the pixelList
	 * @param index the index of the array
	 * @param pixel the pixel to add
	 */
	public void addPixel(int index, TokenizedPixel pixel) {
		this.pixelList.add(index, pixel);
	}
	
	/**
	 * Retrieves a pixel from the list
	 * @param index the index of the array
	 * @return the pixel at index
	 */
	public TokenizedPixel getPixel(int index) {
		return this.pixelList.get(index);
	}
	
	public void parse(Input input) { 
		int isComment = 0;
		for (String line : input.getSourceCodeLines()) {
			
			//check if this line is between /* and */, i.e. a comment
			if (isComment == 1) {
				if (!line.contains("*/")) {
					LiteralsToPixels(line);
					continue;
				}
			}
				
			//tokenize the line
			ArrayList<String> tempList = new ArrayList<String>();
			String[] splitLine = line.split(" "); //raw array of tokens
			for (String token : splitLine) {
				tempList.add(token);
			}
			
			ArrayList<String> emptyList = new ArrayList<String>();
			tokenList = recursiveTokenize(tempList, emptyList, 0);
			
			//TODO: let Statistic.getMode() grab tokens from here.
			
			//TODO: set a flag to determine if parser should use universal tokenizer or crypto tokenizer
			
			int parseCode = 0; //1 = quote pairs. 2 = remainder line comment. 3 = multiline comment.
			for (String token : tokenList) {
				
				if (token.contains("//") || parseCode == 2) { //parse rest of line as literals
					LiteralsToPixels(token);
					parseCode = 2; 
				} else if (token.contains("/*")) { //parse tokens as literals until "*/"
					LiteralsToPixels(token);
					parseCode = 3;
					isComment = 1;
				} else if (token.contains("*/")) { //parse tokens up to this point
					LiteralsToPixels(token);
					isComment = 0;
					parseCode = 0;
				} else if (token.contains("\"")) { //case: quote pairs
					LiteralsToPixels(token);
					parseCode = (parseCode == 0) ? 1 : 0; //toggle between 0 and 1.
				} else if ( parseCode == 1 || parseCode == 3) {
					LiteralsToPixels(token);
				} else if (ColorPalette.PALETTE.containsKey(token)) { //case: token is on the map
					TokenizedPixel pixel = new TokenizedPixel(token, ColorPalette.PALETTE.get(token));
					pixelList.add(pixel);
				} else { //case: token isn't on the map
					LiteralsToPixels(token);
				}
			}	
		}
	}
	
	/**
	 * Takes in a line of strings from tempList and recursively builds a list of more concise tokens.
	 * @param tempList the list it tokenizes from.
	 * @param newList the list it tokenizes to.
	 * @param done a value that tells the function when it's finished
	 * @return an arraylist of strings, the tokenized version of tempList
	 */
	public ArrayList<String> recursiveTokenize(ArrayList<String> tempList, ArrayList<String> newList, int done) { //cant figure out what's wrong
		if (done == 1) {
			return tempList;
		}
		//newList = tempList;
		int pass = 1;
		
		for (int i = 0; i < tempList.size(); i++) {
			String token = tempList.get(i);
			
			//CASE: token has `Class.methods`
			if (token.matches(".+\\..+") && !token.contains(".txt")) {
				pass = 0;
				
				//add the split tokens to the end of the new list
				String[] tempSplit = token.split("(?<=\\.)|(?=\\.)");
				for (String temp : tempSplit) { 
					newList.add(temp);
				} 
			} else if (token.matches(".+;.*")) { //CASE: ";"
				pass = 0;
				String[] tempSplit = token.split("(?<=;)|(?=;)");
				for (String temp : tempSplit) { 
					newList.add(temp);
				}
				
			} else if (token.matches(".*\\(.+") || token.matches(".+\\(.*")) { //CASE: ( or ), and { or } later
				pass = 0;
				String[] tempSplit = token.split("(?<=\\()|(?=\\()");
				for (String temp : tempSplit) { 
					newList.add(temp);
				}
			} else if (token.matches(".*\\).+") || token.matches(".+\\).*")) { //CASE: ( or ), and { or } later
				pass = 0;
				String[] tempSplit = token.split("(?<=\\))|(?=\\))");
				for (String temp : tempSplit) { 
					newList.add(temp);
				}
			} else { //CASE: token doesn't need to be split up further.
				token.trim();
				token.replaceAll("\\s", "");
				if (!token.isEmpty()) {
					newList.add(token);
				}
			}
		}
		//if pass is still 1, then it will end recursion and return the final tokenized version.
		ArrayList<String> emptyList = new ArrayList<String>();
		return recursiveTokenize(newList, emptyList, pass);
	}
	
	/**
	 * Takes a whole token and breaks it into a series of chars and adds it to the pixel list.
	 * @param token a single word string representing a lingual piece of source code
	 */
	public void LiteralsToPixels(String token) {
		String[] tempSplit = token.split("(?<!^)");
		for (String temp: tempSplit) {
			TokenizedPixel pixel = new TokenizedPixel(temp, ColorPalette.PALETTE.get(temp));
			if (ColorPalette.PALETTE.get(temp) == null) {
				pixel.setColor(Color.BLACK);
			}
			pixelList.add(pixel);
		}
	}
}
