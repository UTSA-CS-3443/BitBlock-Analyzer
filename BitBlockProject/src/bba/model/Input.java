package bba.model;

import java.util.*;
import java.io.*;

/**
 * Takes in and stores the source code.
 * "needs to take input from source file" <p>
 * Should be called as `Input file = new Input("fileName", id)`
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
	 * @param file a file's pathname as a string
	 * @param ID an ID to distinguish this input from others. Should start at 1.
	 * @throws FileNotFoundException
	 * @throws NullPointerException if the pathname arguement is null
	 */
	public Input(File file, int ID) throws FileNotFoundException, NullPointerException {
		try (Scanner in = new Scanner(file)){
			while (in.hasNext()) {
				String line = in.nextLine();
				line = line.replaceAll("\n", "");
				line = line.replaceAll("\t", "");
				line = line.trim();
				if (line.isEmpty()) {
					continue;
				}
				this.sourceCodeLines.add(line);
			}
		} 
		
		this.sourceCodeID = ID;
	}
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
