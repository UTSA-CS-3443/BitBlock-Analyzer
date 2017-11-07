package parser;

import java.util.*;

/**
 * Takes in and stores the source code.
 * "needs to take input from source file"
 * @author crimsonfig
 *
 */
public class Input {
		/** ArrayList for holding the source code. 
		 * Each index being a line and allowing it to be iterated. */ 
	private List<String> sourceCodeLines = new ArrayList<String>();
		/** int for holding the id of the source code, 
		 * to help differentiate between multiple inputs. */
	private int sourceCodeID;
	
	
	/**
	 * @return the sourceCodeLines
	 */
	public List<String> getSourceCodeLines() {
		return sourceCodeLines;
	}
	/**
	 * @param sourceCodeLines the sourceCodeLines to set
	 */
	public void setSourceCodeLines(List<String> sourceCodeLines) {
		this.sourceCodeLines = sourceCodeLines;
	}
	/**
	 * @return the sourceCodeID
	 */
	public int getSourceCodeID() {
		return sourceCodeID;
	}
	/**
	 * @param sourceCodeID the sourceCodeID to set
	 */
	public void setSourceCodeID(int sourceCodeID) {
		this.sourceCodeID = sourceCodeID;
	}
	
	
}
