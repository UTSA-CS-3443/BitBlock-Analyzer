package bba.model;

import java.nio.ByteBuffer;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import parser.*;

/*
 * @author Josh Thorsson
 * 
 * Model class for Pixels 
 */

public class Pixel {
	
	private static final int RECT_WIDTH = 20;
	private static final int RECT_HEIGHT = 20;
	private final StringProperty token;
	private final ObjectProperty<Color> tokenColor;
	
	public Pixel(String token, Color tokenColor)
	{
		this.token = new SimpleStringProperty(token);
		this.tokenColor = new SimpleObjectProperty(tokenColor);
	}
	
	
	private void drawBitBlock(GraphicsContext gc)
	{
		int spacing = 3;
		int bitWidth = 30;
		int bitHeight = 10;
		int numRows = bitHeight/(RECT_HEIGHT + spacing);
		int numColumns = bitWidth/(RECT_WIDTH + spacing);
		
		byte[] pixels = this.getBitBlockData();
		
		PixelWriter pixelWriter = gc.getPixelWriter();
		PixelFormat<ByteBuffer> pixelFormat = PixelFormat.getByteRgbInstance();
		
		for (int i = 0; i < numRows; i++)
		{
			for (int j = 0; j < numColumns; j++)
			{
				int xCoord = 50 + j * (RECT_WIDTH + spacing);
				int yCoord = 50 + i * (RECT_HEIGHT + spacing);
				
				pixelWriter.setPixels(xCoord, yCoord, RECT_WIDTH, RECT_HEIGHT, pixelFormat, pixels, 0, RECT_WIDTH*3);
			}
		}
	}
	
	private byte[] getBitBlockData()
	{
		byte[] pixels = new byte[RECT_WIDTH * RECT_HEIGHT * 3];
		double ratio = 1.0 * RECT_HEIGHT/RECT_WIDTH;
		
		for (int i = 0; i < RECT_HEIGHT; i++)
		{
			for (int j = 0; j < RECT_WIDTH; j++)
			{
				int x = i * RECT_WIDTH * 3 + j * 3;
				if (j <= i/ratio)
				{
					pixels[x] = -1;
					pixels[x+1] = 1;
					pixels[x+2] = 0;
				}
				else
				{
					pixels[x] = 1;
					pixels[x+1] = 1;
					pixels[x+2] = 0;
					
				}
			}
		}
		return pixels;
	}

}
