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
	public void addTokenList(int index, String token) {
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
	public void addPixelList(int index, TokenizedPixel pixel) {
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
}
