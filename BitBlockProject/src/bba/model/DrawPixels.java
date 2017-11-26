package bba.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import parser.TokenizedPixel;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;


/*
 * @author Josh Thorsson
 * 
 * DrawPixels is used to take the list of pixels obtained from SCParser, and create and image that is drawn onto the canvas
 * 
 */

public class DrawPixels {
	
	private List<Color> tColorList = new ArrayList<Color>();
	private List<String> tTokenList = new ArrayList<String>();
	private Color cPixel;
	/*
	 * @param canvas The canvas we will work on to draw the BitBlock
	 * @param width The width of each pixel
	 * @param height The height of each pixel
	 * @param pixelList the list of pixels obtained from SCParser.java.  Each object should contain the token and color associated with it
	 */
	public Canvas drawPixels(Canvas canvas, List<TokenizedPixel> pixelList)
	{
		int iWidth = (int) canvas.getWidth();
		int iHeight = (int) canvas.getHeight();
		final int iBitHeight = 1;
		//Canvas pixelCanvas = new Canvas(iWidth, iHeight);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		PixelWriter pixelWriter = gc.getPixelWriter();
		//TokenizedPixel tPixel = new TokenizedPixel(null, null);
		
		
		/*
		 * Add bit block tokens to the arrayList used to populate the Canvas
		 */
		for (int i = 0; i < pixelList.size(); i++)
		{		
			tColorList.add(pixelList.get(i).getColor());
			tTokenList.add(pixelList.get(i).getToken());
		}
		
		/*
		 * Cycle through the ArrayList of colors and add them to the canvas
		 */
		for (int y = 0; y < tColorList.size(); y++)
		{
			for (int x = 1; x < iWidth; x++)
			{
				cPixel = tColorList.get(y);
				pixelWriter.setColor(x, iBitHeight, cPixel);
			}
		}
		
		return canvas;
	}	
}
