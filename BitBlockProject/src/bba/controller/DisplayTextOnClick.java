package bba.controller;

import java.util.ArrayList;
import java.util.List;

import bba.model.BitBlock;
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
	 * @param canvas canvas associated with clicks
	 * @param pixelList the list of pixels obtained from SCParser.java.  Each object should contain the token and color associated with it
	 * @param bb bitblock associated with text
	 * @return the TextField to be printed out
	 */
	public TextField writeText(TextField textField, Canvas canvas, List<TokenizedPixel> pixelList, BitBlock bb)
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
                
                x = (int) (x /8);
                y = (int) (y /8);
                
                //x * y = area
                int side = bb.getDimension()[0];
                int area = (int) ((y * side) - side + x);
                String tToken = tTokenList.get(area);
                
                //set the field
                textField.setText("Pixel: " + tToken);
            }
        });
		
		return textField;
	}	
}

