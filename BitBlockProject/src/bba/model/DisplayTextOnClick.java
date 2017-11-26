package bba.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import parser.TokenizedPixel;

/*
 * @author Josh Thorsson
 * 
 * DisplayTextOnClick displays the token associated with a color on the text field
 */
public class DisplayTextOnClick {
	
	private List<Color> tColorList = new ArrayList<Color>();
	private List<String> tTokenList = new ArrayList<String>();
	private String sToken;
	/*
	 * @param textField The text field responsible for displaying token
	 * @param color The color the user clicks on in the bitblock
	 * @param pixelList the list of pixels obtained from SCParser.java.  Each object should contain the token and color associated with it
	 */
	public TextField writeText(TextField textField, Color color, List<TokenizedPixel> pixelList)
	{		
		/*
		 * Add bit block tokens to the arrayList used to populate the text field
		 */
		for (int i = 0; i < pixelList.size(); i++)
		{		
			tColorList.add(pixelList.get(i).getColor());
			tTokenList.add(pixelList.get(i).getToken());
		}
		
		/*
		 * Checks whether the color passed in (based on users click) matches the color in the list
		 * if it does, this is written in the text field
		 */
		for (int i = 0; i < tColorList.size(); i++)
		{
			if (tColorList.get(i) == color)
			{
				sToken = tTokenList.get(i);
				textField.setText(sToken);
			}
		}
		return textField;
	}	
}

