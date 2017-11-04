package parser;

import java.util.*;

/**
 * BitBlock type, a visual representation of SourceCode. 
 * The BitBlock is comprised of colored pixels, a pixel for each literal and expression.
 * "Needs to produce a BitBlocks"
 * @author Triston Scallan
 *
 */
public class BitBlock {
	
	/** the arrayList of TokenizedPixel type to construct a BitBlock */
	List<TokenizedPixel> pixelList = new ArrayList<TokenizedPixel>();

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
	
	
	
	//method to retrieve the parsed data from SCParser
	
}
