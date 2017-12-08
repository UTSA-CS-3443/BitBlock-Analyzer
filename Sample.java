import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * The Lab1 program uses a scanner to parse a document for the *count of 
 * digit* and *non-digit* values, as well as the *sum of the digit* values.
 * The program then outputs the total of these three value.
 * 
 * @author 	Generalized
 * @version 	1.0
 * @since 	2017-08-28
 */
public class Lab1 {

	public static void main(String [] args) {
		//Prints out the total digit, non-digit, and digit-sum values to stdOut
		Scanner in = null;
		String token = null;
		int nonDigitCount = 0;
		int digitCount = 0;
		double digitSum = 0;
		
		//open the data file to be processed
		try { 
		    in = new Scanner(new File("data.txt"));
		} catch (FileNotFoundException e) {
		    System.err.println("failed to open data.txt");
		    System.exit(1);
		} 
		//process the document against digit versus non-digit values
		while (in.hasNext()) {
		    token = in.next();
		    try {
		        double d = Double.parseDouble(token);
		        digitSum += d;
		        digitCount += 1;
		    } catch (NumberFormatException e) {
		        nonDigitCount += 1;
		    }
		}
		//prints out the totaled values and then closes the document.
		System.out.printf("%d %d %.1f" , digitCount , nonDigitCount , digitSum);
		in.close();
	}

}