package bba.model;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import parser.Statistic;
import parser.TokenizedPixel;

/*
 * @author Anthony Hoang
 * 
 * Display the statistics on textfield when on click
 */
public class DisplayStatOnClick {
	
	private List<Color> tColorList = new ArrayList<Color>();
	private List<String> tTokenList = new ArrayList<String>();
	private String output;

	public TextField writeText(TextField textField,List<String> tokenList, List<TokenizedPixel> pixelList)
	{
		
		Statistic stat = new Statistic(tokenList, pixelList);
		output = "Number of token: " + stat.countToken() + "\n";
		textField.setText(output);
		
		output = "Number of unique token: " + stat.countUniqToken() + "\n";
		textField.setText(output);
		
		return textField;
	}	
}

