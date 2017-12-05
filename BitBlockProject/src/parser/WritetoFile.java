package parser;

import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import bba.model.BitBlock;
import javafx.scene.paint.Color;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
* @author Anthony Hoang
*/
public class WritetoFile {
	
	private List<Color> tColorList = new ArrayList<Color>();
	private Color cPixel;
	
	public WritetoFile(String outfile, BitBlock bitblock, int scale) throws IOException
	{
		
		int side = bitblock.getDimension()[0];
		BufferedImage image = new BufferedImage(side*scale, side*scale, BufferedImage.TYPE_INT_RGB);
		File f = null;
		
		// create array of color
		for (int i = 0; i < bitblock.getPixelList().size(); i++)
			tColorList.add(bitblock.getPixelList().get(i).getColor());
		
		// setting up image
		int j = 0;
		for (int y = 0; y < side; y++)
		{
			for (int x = 0; x < side; x++)
			{
				// get color 
				if (j < tColorList.size())
					cPixel = tColorList.get(j);
				else // padding
					cPixel = ColorPalette.PALETTE.get(null);

				j++;
				
				// convert to RGB
				int red   = (int) (cPixel.getRed() * 256);
				int green = (int) (cPixel.getGreen() * 256);
				int blue  = (int) (cPixel.getBlue() * 256);
						
				int pixel = (red << 16) | (green << 8) | blue; 
				
				// scale each pixel
				for (int ay = y*scale; ay < (y*scale)+scale; ay++)
					for (int ax = x*scale; ax < (x*scale)+scale; ax++)
							image.setRGB(ax, ay, pixel);
				
			}
		}
		
		// write to file
		try {
			f = new File(outfile + ".png");
			ImageIO.write(image, "png", f);
		} catch (IOException e) {
			System.out.println("Error: " + e);
		}
	}

}
