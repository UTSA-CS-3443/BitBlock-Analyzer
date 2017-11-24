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
	/*
	 * @param canvas The canvas we will work on to draw the BitBlock
	 * @param width The width of each pixel
	 * @param height The height of each pixel
	 * @param pixelList the list of pixels obtained from SCParser.java.  Each object should contain the token and color associated with it
	 */
	public Canvas drawPixels(Canvas canvas, int width, int height, List<TokenizedPixel> pixelList)
	{
		Canvas pixelCanvas = new Canvas(canvas.getWidth(), canvas.getHeight());
		GraphicsContext gc = pixelCanvas.getGraphicsContext2D();
		PixelWriter pixelWriter = gc.getPixelWriter();
		TokenizedPixel tPixel = new TokenizedPixel(null, null);
		
		/*
		 * Add bit block tokens to the arrayList used to populate the WritableImage
		 */
		for (int i = 0; i < pixelList.size(); i++)
		{		
			tColorList.add(pixelList.get(i).getColor());
			tTokenList.add(pixelList.get(i).getToken());
		}
		
		
		
		for (int y = 0; y < canvas.getHeight(); y++) 
		{
			
		}
		
		return pixelCanvas;
	}	
}
