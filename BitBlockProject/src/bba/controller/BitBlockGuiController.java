package bba.controller;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.scene.canvas.*;
import bba.MainApp;
import bba.model.*;
import parser.TokenizedPixel;
import parser.WritetoFile;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	private MenuItem printBB;
	
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
	private TextArea statTextArea;
	
	////variables for the controller class
	private File dataFile = null;	//temporarily hold a file
	private BitBlock bb = null;		//holds a single bitBlock's data TODO: convert this to an arrayList
	private int scale = 8;			//an int value that scales the bitblock pixels visually
	
	////variables for storing the inputs and id'ing them
	private int idIndex = 0;			//start at 0
	private List<Input> inputM = new ArrayList<Input>();
	
	public BitBlockGuiController() {
		
	}
	
	@FXML
	private void initialize() {
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
	void printBBAction(ActionEvent event) {
		handlePrintClick();
	}
	
	/**
	 * Handle event for About option
	 * @param event
	 */
	@FXML 
	void aboutAction(ActionEvent event) {
		ControllerUtilHandlers.handleAboutClick();
	}
	
	/**
	 * Handle event for Open option 
	 * @param event
	 */
	@SuppressWarnings("unchecked")
	@FXML
	void openAction(ActionEvent event) {
		Object[] temp = ControllerFileHandlers.handleOpenClick(docTextArea, dataFile, idIndex, inputM);
		Boolean success = (Boolean) temp[3];
		
		if (success) {
			//set our variables that were changed within the method
			docTextArea = (TextArea) temp[0];
			dataFile = (File) temp[1];
			inputM = (List<Input>) temp[2];
			//update the buttons that can be pushed
			//open.setDisable(true); Since the app holds only one file and replaces it on new open, ignore this.
			refresh.setDisable(true);
			start.setDisable(false);
			save.setDisable(false);
			saveAs.setDisable(false);
			//Setup or reset the canvas
			GraphicsContext gc = canvas.getGraphicsContext2D();
		    gc.setFill(Color.WHITE);
		    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		}
	}
	
	/**
	 * Handle event for SaveAs
	 * @param event
	 */
	@FXML 
	void saveAsAction(ActionEvent event) {
		save = (MenuItem) ControllerFileHandlers.handleSaveAsClick(docTextArea, dataFile, save);
	}
	
	/**
	 * Handle for Save
	 * @param event
	 */
	@FXML
	void saveAction(ActionEvent event) {
		ControllerFileHandlers.handleSaveClick(docTextArea, dataFile);
	}

	///////////////////////////////////// Event Handlers ///////////////////////////////
	////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Event handler for the start button. sets up the stat box, the bit block, and the refresh button
	 */
	private void handleStartClick() {
		//create a BitBlock object, which takes the input and parses it into a pixelList
		bb = new BitBlock(inputM.get(0));
		
		// test printing token
		int i = 0;
		for (TokenizedPixel pixel : bb.getPixelList()) {
			String token = pixel.getToken();
			System.out.print(token + ",");
			if (i % 10 == 9) {
				System.out.print("\n");
			}
			i++;
		}
		
		ControllerUtilHandlers.displayStats(statTextArea, bb.getPixelList());
		DrawPixels pixels = new DrawPixels();
		pixels.drawPixels(canvas, bb, scale);
		//so that we don't have the pixel list persist between refreshes, create as object.
		DisplayTextOnClick textDisplayer = new DisplayTextOnClick();
		textDisplayer.writeText(codeField, canvas, bb.getPixelList());
		
		//update the buttons able to be clicked
		start.setDisable(true);
		refresh.setDisable(false);
		printBB.setDisable(false);
		
	}
	
	/**
	 * Event handler for the refresh button. cleans up the canvas and resets the bit block and stats.
	 */
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
		
		//reset the canvas
		GraphicsContext gc = canvas.getGraphicsContext2D();
	    gc.setFill(Color.WHITE);
	    gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
		
		//pass it to BitBlock and draw the pixels
		bb = new BitBlock(tempInput);
		ControllerUtilHandlers.displayStats(statTextArea, bb.getPixelList());
		DrawPixels pixels = new DrawPixels();
		pixels.drawPixels(canvas, bb, scale);
		DisplayTextOnClick textDisplayer = new DisplayTextOnClick();
		textDisplayer.writeText(codeField, canvas, bb.getPixelList());
	}
	
	private void handlePrintClick() {
		if (bb != null) {
			FileChooser fc = new FileChooser();
			fc.setTitle("Print BitBlick");
			fc.getExtensionFilters().addAll(new ExtensionFilter("PNG Files", "*.png"));
			
			File fileName = fc.showSaveDialog(MainApp.getStage());
			
			if (fileName != null) {
				try {
					@SuppressWarnings("unused")
					WritetoFile wf = new WritetoFile(fileName, bb, scale);
					
				} catch (IOException e) {
					e.printStackTrace();
					Alert alert = new Alert(AlertType.ERROR);
				        	alert.setTitle("IO error");
				        alert.setHeaderText(null);
				        alert.setContentText("Was unable to create png file. Try again!");
			        alert.showAndWait();
			        return;
				}
			} 
		} else {
			Alert alert = new Alert(AlertType.WARNING);
		        	alert.setTitle("No BitBlock created yet");
		        alert.setHeaderText("No BitBlock created yet");
		        alert.setContentText("The BitBlock needs to be created before it can be printed.");
		    alert.showAndWait();
		    return;
		}
	}
}
