package bba.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import parser.ColorPalette;

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

		GraphicsContext gc = canvas.getGraphicsContext2D();


		/*
		 * Add bit block tokens to the arrayList used to populate the Canvas
		 */
		for (int i = 0; i < bitblock.getPixelList().size(); i++)
		{		
			tColorList.add(bitblock.getPixelList().get(i).getColor());
			tTokenList.add(bitblock.getPixelList().get(i).getToken());
		}

		int[] cArea = bitblock.getDimension();
		int iSquareSize = cArea[0];


			int j = 0;
			cPixel = tColorList.get(j);

			for (int y = 1; y <= iSquareSize;y++)
			{
				for (int x = 1; x <= iSquareSize;x++)
				{
					if (j < tColorList.size())
					{
						cPixel = tColorList.get(j);
					}

					gc.setFill(cPixel);
					gc.fillRect(x*10, y*10, 10, 10);
					if (!(j < tColorList.size()))
					{
						cPixel = ColorPalette.PALETTE.get(null);
					} else {
						j++;
					}
				}
			}
		return canvas;
	}	
}
