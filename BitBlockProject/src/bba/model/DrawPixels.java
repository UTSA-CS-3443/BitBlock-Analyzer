package bba.model;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import parser.TokenizedPixel;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import javafx.scene.image.WritableImage;

/*
 * @author Josh Thorsson
 * 
 * DrawPixels is used to take the list of pixels obtained from SCParser, and create and image that is drawn onto the canvas
 * 
 */

public class DrawPixels {
	
	/*
	 * @param canvas The canvas we will work on to draw the BitBlock
	 * @param width The width of each pixel
	 * @param height The height of each pixel
	 * @param pixelList the list of pixels obtained from SCParser.java.  Each object should contain the token and color associated with it
	 */
	public WritableImage drawPixels(Canvas canvas, int width, int height, List<TokenizedPixel> pixelList)
	{
		//Getting height/width of the canvas and converting to integer so it meets WritableImage constructor
		int imageWidth = (int) canvas.getWidth();
		int imageHeight = (int) canvas.getHeight();
		
		TokenizedPixel tPixel = new TokenizedPixel(null, null);
		WritableImage wImage = new WritableImage(imageWidth, imageHeight);
		
		return wImage;
	}
	
	

	
}
