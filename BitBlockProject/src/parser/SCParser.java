package parser;

import java.util.*;

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
	
	//method to parse a string of literals
	//method to parse statements
	//method to determine built in statements vs. user-created statements and parse accordingly
	//TODO: if tokens are initially created with whitespace delimiters, need to further separate tokens with context related delimiters	
	//TODO: if a token match against the hashmap produces no value, then split the token into literals		
	public void parse(Input input) { //DEMO VERSION
		
		//case 1: comments
		//case 2: non-comments
		//break up the tokens
		//test if token is on the hashmap, if so, then do some test cases for literals
		for (String line : input.getSourceCodeLines()) {
			//check for if comment
			if (line.contains("//") ) { //parse line as literals
				continue;
			} else if (line.contains("/*")) { //parse lines as literals until "*/"
				while (!line.contains("*/")) {
				} //since while stops at */, parse this last line as literals
				continue;
			} //not a comment then
			
			//tokenize the line
			String[] splitLine = line.split(" "); //raw array of tokens
			ArrayList<String> tempList = new ArrayList<String>();
			for (String token : splitLine) {
				tempList.add(token);
			}
			tempList = recursiveTokenize(tempList, 0);
			
			//Print out the line for testing
			for(String temp: tempList) {
				System.out.print(temp + " ");
			}
			System.out.print("\n");
			
			//case 3: quote pairs, for first ", process all as literals until " (and not \") 
			
			
		}
	}
	
	public ArrayList<String> recursiveTokenize(ArrayList<String> tempList, int done) {
		if (done == 0) {
			return tempList;
		}
		ArrayList<String> newList = new ArrayList<String>();
		int pass = 1;
		for (String token : tempList) {
			//CASE: token has `Class.methods`
			if (token.matches(".+\\..+") && !token.contains(".txt")) {
				pass = 0;
				String[] tempSplit = token.split(".");
				//add the split tokens to the end of the new list
				for (int i = 0; i < tempSplit.length; i++) { 
					newList.add(tempSplit[i]);
					if (i != tempSplit.length - 1) {
						newList.add(".");
					}
				}
			} else if (token.matches(".+;.*")) { //CASE: ";"
				pass = 0;
				String[] tempSplit = token.split("(?<=;)|(?=;)");
				for (String temp : tempSplit) { 
					newList.add(temp);
				}
			} else if (token.contains("(") && !token.matches(" \\( ")) { //CASE: ( or ), and { or } later
				pass = 0;
				String[] tempSplit = token.split("(?<=\\()|(?=\\()");
				for (String temp : tempSplit) { 
					newList.add(temp);
				}
			} else if (token.contains(")") && !token.matches(" \\) ")) { //CASE: ( or ), and { or } later
				pass = 0;
				String[] tempSplit = token.split("(?<=\\))|(?=\\))");
				for (String temp : tempSplit) { 
					newList.add(temp);
				}
			} else { //CASE: token doesn't need to be split up further.
				newList.add(token);
			}
		}
		//if pass is still 1, then it will end recursion and return the final tokenized version.
		return recursiveTokenize(newList, pass);
	}
	
}
