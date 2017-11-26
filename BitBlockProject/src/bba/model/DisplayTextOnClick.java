package bba.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import parser.TokenizedPixel;

/*
 * @author Josh Thorsson
 * 
 * WriteText displays the token associated with a color on the text field
 */
public class DisplayTextOnClick {
	
	private List<Color> tColorList = new ArrayList<Color>();
	private List<String> tTokenList = new ArrayList<String>();
	/*
	 * @param textField The text field responsible for displaying token
	 * @param pixelList the list of pixels obtained from SCParser.java.  Each object should contain the token and color associated with it
	 */
	public TextField writeText(TextField textField, List<TokenizedPixel> pixelList)
	{
		TextField tField = new TextField();
		TokenizedPixel tPixel = new TokenizedPixel(null, null);
		
		/*
		 * Add bit block tokens to the arrayList used to populate the text field
		 */
		for (int i = 0; i < pixelList.size(); i++)
		{		
			tColorList.add(pixelList.get(i).getColor());
			tTokenList.add(pixelList.get(i).getToken());
		}
		
		
		return tField;
	}	
}

