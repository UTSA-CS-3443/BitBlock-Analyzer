package parser;

import java.util.*;
import javafx.scene.paint.Color;

/**
 * Parses the Source Code. 
 * "Needs to parse over the source file"
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
	
	public void parse(Input input) { //DEMO VERSION
		for (String line : input.getSourceCodeLines()) {
			//check for if comment
			if (line.contains("//") ) { //parse line as literals
				LiteralsToPixels(line);
				continue;
			} else if (line.contains("/*")) { //parse lines as literals until "*/"
				LiteralsToPixels(line);
				continue;
			} else if (line.contains("* ")) { //use "^[\\s]*\\*" later
				LiteralsToPixels(line);
				continue;
			} else if (line.contains("*/")) {
				LiteralsToPixels(line);
				continue;
			} //not a comment then
			
			//tokenize the line
			ArrayList<String> tempList = new ArrayList<String>();
			String[] splitLine = line.split(" "); //raw array of tokens
			for (String token : splitLine) {
				tempList.add(token);
			}
			
			ArrayList<String> emptyList = new ArrayList<String>();
			tokenList = recursiveTokenize(tempList, emptyList, 0);
			
			int parseCode = 0; //1 = quote pairs.
			for (String token : tokenList) {
				if (token.contains("\"") || parseCode == 1) { //case: quote pairs
					LiteralsToPixels(token);
					parseCode = (parseCode == 0) ? 1 : 0; //toggle between 0 and 1.
				} //TODO: later split this to JavaPALETTE and LitPALETTE so that single chars don't pass as TRUE
				else if (ColorPalette.PALETTE.containsKey(token)) { //case: token is on the map
					TokenizedPixel pixel = new TokenizedPixel(token, ColorPalette.PALETTE.get(token));
					pixelList.add(pixel);
				} else { //case: token isn't on the map
					LiteralsToPixels(token);
				}
			}	
		}
	}
	
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
