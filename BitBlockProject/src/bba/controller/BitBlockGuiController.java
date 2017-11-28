package bba.controller;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.canvas.*;
//import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import bba.model.*;
import parser.BitBlock;
import parser.Input;
import parser.TokenizedPixel;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import bba.MainApp;
//import bba.model.*;

/**
 * @author Josh Thorsson
 * @author Triston Scallan
 */
public class BitBlockGuiController {

	/////MENU BAR IDs
	@FXML
	private MenuItem close;		// declaring close
	
	@FXML 
	private MenuItem save; 		// declaring Save
	
	@FXML 
	private MenuItem saveAs;		// Declaring SaveAs
	
	@FXML
	private MenuItem open;		// Declaring Open
	
	@FXML 
	private MenuItem about;
	
	@FXML
	//////LEFT PANEL
	private TextArea docTextArea;
	
	@FXML
	//////MIDDLE PANEL
	private Button start;
	
	@FXML
	private Button refresh;
	
	@FXML
	//////RIGHT PANEL
	private Canvas canvas;
	
	@FXML
	private TextField codeField;
	
	@FXML
	private TextField statTextArea;
	
	////variables for the controller class
	private File dataFile = null;	//temporarily hold a file
	private BitBlock bb = null;		//holds a single bitBlock's data TODO: convert this to an arrayList
	
	////variables for storing the inputs and id'ing them
	private int idIndex = 0;			//start at 0
	private List<Input> inputM = new ArrayList<Input>();
	
	
	
	public BitBlockGuiController()
	{
		
	}
	
	@FXML
	private void initialize()
	{
		start.setDisable(true);
		refresh.setDisable(true);
		save.setDisable(true);
		saveAs.setDisable(true);
	}
	
	/**
	 * Method to use close click on Menubar 
	 * @param event
	 */
	@FXML
	void quitAction(ActionEvent event) {
		Platform.exit(); 
		System.exit(0);
	}
	
	/**
	 * Handle event for Start button 
	 * @param event
	 */
	@FXML
	void startAction(ActionEvent event) {
		handleStartClick();
	}
	
	/**
	 * Handle event for Refresh button 
	 * @param event
	 */
	@FXML
	void refreshAction(ActionEvent event) {
		handleRefreshClick();
	}
	
	
	@FXML 
	void aboutAction(ActionEvent event) {
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
		    		+ "\t Anthony Hoang, Irfen Syed\n"
		    		+ "Build Information: \n"
		    		+ "\tVersion 1.0.0\n" 
				+ "\tDate: 2017-27-17\n"
		    		+ "\tJava Version: 1.8.0_144-b01, Oracle Corporation");
		alert.showAndWait();
	}
	
	/**
	 * Handle event for Open option 
	 * @param event
	 */
	@FXML
	void openAction(ActionEvent event) {
		handleOpenClick();
	}
	
	/**
	 * Handle event for SaveAs
	 * @param event
	 */
	@FXML 
	void saveAsAction(ActionEvent event) {
		handleSaveAsClick();
	}
	
	/**
	 * Handle for Save
	 * @param event
	 */
	
	@FXML
	void saveAction(ActionEvent event) {
		handleSaveClick();
	}
	
	/**
	 * Method to open a window which can load Text files 
	 */
	private void handleOpenClick()  {
		//creating JavaFX file chooser 
		FileChooser fc = new FileChooser();
		fc.setTitle("Get Text");
		fc.getExtensionFilters().addAll(new ExtensionFilter("Java Files", "*.java"), new ExtensionFilter("All Files", "*.*"));
		
		File file = fc.showOpenDialog(MainApp.getStage());
		
		// checking the file chosen by user  
		
		if (file != null) {
			//display the file to the GUI
			try (Scanner scan = new Scanner(file)) {
				String content = scan.useDelimiter("\\Z").next();
				docTextArea.setText(content);
				
				// saving the file for use by the saveMi
				dataFile = file;
				
				//add the file into an input instance and add it to the input-array
				Input input = null;
				try {
					input = new Input(file, idIndex);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} 
				inputM.add(idIndex, input);
				idIndex++;
				
				//update the buttons that can be pushed
				open.setDisable(true); //TODO: until we can handle multiple files, the app is only allowed to open a single file.
				refresh.setDisable(true);
				start.setDisable(false);
				save.setDisable(false);
				saveAs.setDisable(false);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				Alert alert = new Alert(AlertType.WARNING);
			        	alert.setTitle("File not found");
			        alert.setHeaderText("File not found");
			        alert.setContentText("Please try again or use a different file");
		        alert.showAndWait();
			}	
		} else {
			Alert alert = new Alert(AlertType.WARNING);
		        	alert.setTitle("File not found");
		        alert.setHeaderText("File not found");
		        alert.setContentText("Please try again or use a different file");
		    alert.showAndWait();
		}
	}

	/**
	 * Method to do save As click and open the window with some functionality 
	 */
	private void handleSaveAsClick() {
		FileChooser fc = new FileChooser();
		fc.setTitle("Save Text");
		fc.getExtensionFilters().addAll(new ExtensionFilter("Java Files", "*.java"), new ExtensionFilter("All Files", "*.*"));
		
		File file = fc.showSaveDialog(MainApp.getStage());
		
		if (file != null) {
			try (PrintStream ps = new PrintStream(file)) {
				ps.print(docTextArea.getText());
				// saving the file for use by the save
				save.setDisable(false);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleSaveClick() {
		try (PrintStream ps = new PrintStream(dataFile)) {
			ps.print(docTextArea.getText());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void handleStartClick() {
		bb = new BitBlock(inputM.get(0));
		for (TokenizedPixel pixel : bb.getPixelList()) {
			String token = pixel.getToken();
			System.out.println(token);
		} 
		DrawPixels pixels = new DrawPixels();
		canvas = pixels.drawPixels(canvas, bb.getPixelList());
		//update the buttons abled to be clicked
		start.setDisable(true);
		refresh.setDisable(false);
	}
	
	private void handleRefreshClick() {
		String content = docTextArea.getText();
		File temp = null;
		Input tempInput = null;
		
		//create a temporary file based on the docTextArea
		try {
		    // Create temp file.
		    temp = File.createTempFile("temp-" + dataFile.getName(), ".java");

		    // Delete temp file when program exits.
		    temp.deleteOnExit();

		    // Write to temp file
		    BufferedWriter out = new BufferedWriter(new FileWriter(temp));
		    out.write(content);
		    out.close();
		} catch (IOException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
		        	alert.setTitle("IO error");
		        alert.setHeaderText(null);
		        alert.setContentText("Was unable to create temp file from TextArea.");
	        alert.showAndWait();
			return;				//stop the function early
		}
		
		//create an input object from the temp file
		try {
			tempInput = new Input(temp, idIndex);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			Alert alert = new Alert(AlertType.ERROR);
		        	alert.setTitle("IO error");
		        alert.setHeaderText(null);
		        alert.setContentText("Was unable to create input from temp file. Try Again.");
		    alert.showAndWait();		
			return;				//stop the function early
		} 
		
		//pass it to BitBlock and draw the pixels
		bb = new BitBlock(tempInput);
		DrawPixels pixels = new DrawPixels();
		canvas = pixels.drawPixels(canvas, bb.getPixelList());
	}
}
