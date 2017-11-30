package parser;

import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
* @author Anthony Hoang
*/
public class WritetoFile {

	private List<String> sourceCodeLines = new ArrayList<String>();
	
	
	/**
	 * 
	 * !!! NEED: check existence of file
	 * 			 prompt user to overwrite
	 * 
	 */
	public WritetoFile(List<TokenizedPixel> pixelList, String outfile) throws IOException
	{
		
		int width = 640;
		int height = 320;
		
		BufferedImage imgage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		
		File f = null;
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				int red = (int) (Math.random() * 256); 
				int green = (int) (Math.random() * 256); 
				int blue = (int) (Math.random() * 256); 

				int pixel = (red << 16) | (green << 8) | blue; 

				imgage.setRGB(x, y, pixel);
			}
		}
		
		try {
			f = new File(outfile + ".png");
			ImageIO.write(imgage, "png", f);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}

}
