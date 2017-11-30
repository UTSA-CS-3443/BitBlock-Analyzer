package bba.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.shape.Rectangle;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.WritableImage;
import javafx.scene.canvas.GraphicsContext;
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
	 * @param bitBlock the BitBlock containing PixelList and dimensions
	 */
	public Canvas drawPixels(Canvas canvas, BitBlock bitblock)
	{
		int iWidth = (int) canvas.getWidth();
		int iHeight = (int) canvas.getHeight();
		int iStart = 50;
		int iFinish = 50;
		double dStart = 1;
		double dFinish = 1;

		WritableImage bitBlock = new WritableImage(iWidth, iHeight);
		GraphicsContext gc = canvas.getGraphicsContext2D();

		/*
		 * Add bit block tokens to the arrayList used to populate the Canvas
		 */
		for (int i = 0; i < bitblock.getPixelList().size(); i++)
		{		
			tColorList.add(bitblock.getPixelList().get(i).getColor());
			tTokenList.add(bitblock.getPixelList().get(i).getToken());
		}



		for (int x = 0; x < tColorList.size(); x++)
		{
			System.out.println(tColorList.get(x));

			Rectangle rectangle = new Rectangle(iStart,iFinish, 4, 4);
			rectangle.setFill(tColorList.get(x));
			iStart = iStart+5;
			iFinish = iFinish+5;

			rectangle.snapshot(null,bitBlock);
			gc.drawImage(bitBlock,dStart,dFinish);
			dStart = dStart+5;
			dFinish = dFinish+5;

		}

		return canvas;
	}	
}
