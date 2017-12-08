package bba.controller;

import java.util.ArrayList;
import java.util.List;

import javafx.event.EventHandler;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import parser.TokenizedPixel;

/**
 * DisplayTextOnClick displays the token associated with a color on the text field
 * @author Josh Thorsson
 * @author Triston Scallan
 * 
 * 
 */
public class DisplayTextOnClick {
	
	private List<Color> tColorList = new ArrayList<Color>();
	private List<String> tTokenList = new ArrayList<String>();
	
	/**
	 * @param textField The text field responsible for displaying token
	 * @param color The color the user clicks on in the bitblock
	 * @param pixelList the list of pixels obtained from SCParser.java.  Each object should contain the token and color associated with it
	 * @return the TextField to be printed out
	 */
	public TextField writeText(TextField textField, Canvas canvas, List<TokenizedPixel> pixelList)
	{		
		//Add bit block tokens to the arrayList used to populate the text field
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
		
		return textField;
	}	
}

