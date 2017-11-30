package bba.model;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import parser.TokenizedPixel;

/*
 * @author Josh Thorsson
 * 
 * DisplayTextOnClick displays the token associated with a color on the text field
 */
public class DisplayTextOnClick {
	
	private static List<Color> tColorList = new ArrayList<Color>();
	private static List<String> tTokenList = new ArrayList<String>();
	private static String sToken;
	/*
	 * @param textField The text field responsible for displaying token
	 * @param color The color the user clicks on in the bitblock
	 * @param pixelList the list of pixels obtained from SCParser.java.  Each object should contain the token and color associated with it
	 */
	public static TextField writeText(TextField textField, Canvas canvas, List<TokenizedPixel> pixelList)
	{		
		/*
		 * Add bit block tokens to the arrayList used to populate the text field
		 */
		
		/**
		 * @author iffi_ wanted to make an object that correspond to handler in controller  
		  DisplayText text = new DisplayText(pixelList);
		  *  
		  */
		for (int i = 0; i < pixelList.size(); i++)
		{		
			tColorList.add(pixelList.get(i).getColor());
			tTokenList.add(pixelList.get(i).getToken());
		}
		
		//grab coordinates from canvas when you click
		canvas.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) { 
                double x = e.getX();
                double y = e.getY();
                
                x = (int) (x/5)+1;
                y = (int) (y/5)+1;
                
                //x * y = area
                int area = (int) (y * 10 + x);
                String tToken = tTokenList.get(area);
                
                //set the field
                textField.setText("Pixel: " + tToken);
            }
        });
		
		
		
		
		
		/*
		 * Checks whether the color passed in (based on users click) matches the color in the list
		 * if it does, this is written in the text field
		 *//*
		for (int i = 0; i < tColorList.size(); i++)
		{
			if (tColorList.get(i) == color)
			{
				sToken = tTokenList.get(i);
				textField.setText(sToken);
			*//**
			 * @author iffi_ added this method to print it on the text box in the middle
			 * Not sure if this is right, but idea seems right. 
			 
				String out = "you picked: " + text.tColorList.get(i) + "\n" 
						+ "The Code Line: " + text.tTokenList.get(i) + "\n";
				textField.setText(out);
					
			**//*
			}
		} */
		return textField;
	}	
}

