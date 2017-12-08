package bba.model;

import java.util.*;

import parser.SCParser;
import parser.TokenizedPixel;

/**
 * BitBlock type, a visual representation of SourceCode. 
 * The BitBlock is comprised of colored pixels, a pixel for each literal and expression.
 * "Needs to produce a BitBlocks"
 * @author Triston Scallan
 *
 */
public class BitBlock {
	
	/** the arrayList of TokenizedPixel type to construct a BitBlock */
	private List<TokenizedPixel> pixelList = new ArrayList<TokenizedPixel>();
	private SCParser parser;
	
	/** The constructor. <p> takes an input object and creates the associated pixelList from it */
	public BitBlock(Input input) {
		parser = new SCParser();
		parser.parse(input);
		this.pixelList = parser.getPixelList();
	}
	
	/**
	 * @return the parser
	 */
	public SCParser getParser() {
		return parser;
	}

	/**
	 * @return the pixelList
	 */
	public List<TokenizedPixel> getPixelList() {
		return pixelList;
	}

	/**
	 * @param pixelList the pixelList to set
	 */
	public void setPixelList(List<TokenizedPixel> pixelList) {
		this.pixelList = pixelList;
	} 
	
	
	/**
	 * Calculates the dimensions of the BitBlock based on the size of this.pixelList. 
	 * <p>
	 * NOTE: If the returned value's r == 0, then the
	 * final row should be filled, otherwise the final row should have "r" many pixels. <p>
	 * x is width, y is height, r is remainder.
	 * @return an integer array of {x, y, r}.
	 *  result would display x pixels to a row, y total rows, and r added to the y-th row
	 */
	public int[] getDimension() {
		int x = 0; 	//width
		int y = 0; 	//height
		int r = 0;	//remainder
		int area = this.pixelList.size(); //area of our BitBlock
		
		//dimensions of a square is described by the formula: ( x * y ) + r = area
		//finding x is easily done as a true square is x^2 = area, so x = area^0.5 
		//we must make sure x is an integer to make later calculations safer
		assert Math.floor(Math.sqrt(area)) % 1 == 0; 
		int temp = (int) Math.floor(Math.sqrt(area));
		
		//if area <= x^2 + x then x = area^0.5, otherwise x = x + 1
		x = (area <= Math.pow(temp, 2) + temp) ? temp : temp + 1; 
		
		//if area is a perfect square then y = x, otherwise y = x + 1 if there is a remainder
		y = (this.pixelList.size() == Math.pow(temp, 2)) ? temp : temp + 1;
		
		//the remainder will be area - (filled rows). 
		r = area - temp * x;
		
		//result would display x pixels to a row, y total rows, and r added to the y-th row.
		int[] result = {x, y, r}; 
		return result;
	}
	
}
