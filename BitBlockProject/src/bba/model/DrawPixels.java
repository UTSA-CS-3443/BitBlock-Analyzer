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

public class DrawPixels {
	
	public WritableImage drawPixels(Canvas canvas, int width, int height, List<TokenizedPixel> pixelList)
	{
		TokenizedPixel tPixel = new TokenizedPixel(null, null);
		WritableImage wImage = new WritableImage(width, height);
		
		return wImage;
	}
	
	

	
}
