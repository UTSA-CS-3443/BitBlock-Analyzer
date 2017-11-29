/**
 * 
 */
package bba.controller;

import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import parser.Statistic;
import parser.TokenizedPixel;

/**
 * @author Triston Scallan, Anthony Hoang
 *
 */
public class ControllerUtilHandlers {

	/**
	 * Displays statistics to the statistics text field.
	 * The intended use is for when calls are made to the `handleStartClick()` and `handleRefreshClick()`
	 * @param textField the FXML id for the statistics textArea
	 * @param pixelList
	 * @return the textField to the controller
	 */
	static TextArea displayStats(TextArea statTextArea, List<TokenizedPixel> pixelList)
	{
		//this is honestly just a very fancy `toString` method.
		Statistic stat = new Statistic(pixelList);
		String output = "Number of unique pixels: " + stat.countUniqPixel() + "\n"
				+ "Number of total pixels: " + stat.countPixel() + "\n"
				+ "Most common pixel: " + stat.getMode() + "\n"
				+ "Number of loops in the program: " + stat.countLoop() + "\n"
				+ "";
		statTextArea.setText(output);
		
		return statTextArea;
	}

	/** 
	 * Displays information about this application
	 */
	static void handleAboutClick() {
		Alert alert = new Alert(AlertType.INFORMATION);
		    	alert.setTitle("About");
		    alert.setHeaderText("Bit Block Analyzer");
		    alert.setContentText(
		    		"About: \n"
		    		+ "\t The BitBlock-Analyzer is an application designed\n"
		    		+ "\t to parse Java source code to produce statistics\n"
		    		+ "\t of the code and create a visual representation\n"
		    		+ "\t of the code itself in the form of colored pixels\n"
		    		+ "\n"
		    		+ "\t The app was born out of the idea of novelty,\n"
		    		+ "\t creating new ways of looking at code while\n"
		    		+ "\t also showing the data in an artistic perspective.\n"
		    		+ "\t Given it's consolidated form and visual \n"
		    		+ "\t appearance, it can give a summary of code\n"
		    		+ "\t and make it more physically portable.\n"
		    		+ "\t simply print a color block and scan it later.\n"
		    		+ "\t While QR does this too, you can visually see\n"
		    		+ "\t the code to also have a gist of it as well.\n"
		    		+ "Authors: \n"
		    		+ "\t - Team JavaFox -\n"
		    		+ "\t Triston Scallan, Josh Thorsson,\n "
		    		+ "\t Anthony Hoang, Irfan Syed\n"
		    		+ "Build Information: \n"
		    		+ "\tVersion 1.0.0\n" 
				+ "\tDate: 2017-27-17\n"
		    		+ "\tJava Version: 1.8.0_144-b01, Oracle Corporation");
		alert.showAndWait();
	}
}
