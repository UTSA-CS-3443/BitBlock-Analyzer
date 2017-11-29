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

	private List<TokenizedPixel> pixelList = new ArrayList<TokenizedPixel>();
	private static String output;

	public TextField DisplayStatOnClick(TextField textField, List<TokenizedPixel> pixelList)
	{

		Statistic stat = new Statistic();
		stat.setPixelList(pixelList);
		output = "Number of pixel: " + stat.countPixel() + "\n";
		textField.setText(output);
		
		output = "Number of unique pixel: " + stat.countUniqPixel() + "\n";
		textField.setText(output);
		
		return textField;
	}	
}

