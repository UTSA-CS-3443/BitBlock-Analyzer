package bba.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import bba.MainApp;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * @author Josh Thorsson and Irfan Syed 
 */
public class RootLayoutController {
	
	//private Model model;
	
	// declaring close 
	@FXML
	private MenuItem close; 
	
	// declaring Save 
	@FXML 
	private MenuItem save; 
	
	// Declaring SaveAs
	@FXML 
	private MenuItem saveAs;
	
	//Declaring Open 
	
	@FXML
	private MenuItem open;
	
	// Declaring MyTextArea
	@FXML
	  private TextArea myTextArea;
	
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
	
	// Declaring empty datafile 
	File dataFile = null;
	
	/**
	 * Method to open a window which can save Text files 
	 */
	private void handleOpenClick()  {
		//creating JavaFX file chooser 
		FileChooser fc = new FileChooser();
		fc.setTitle("Get Text");
		fc.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"), new ExtensionFilter("All Files", "*.*"));
		
		File phil = fc.showOpenDialog(MainApp.primaryStage);
		
		// checking the file choosen by user 
		
		if (phil != null) {
			try (Scanner scan = new Scanner(phil)) {
				String content = scan.useDelimiter("\\Z").next();
				myTextArea.setText(content);
				
				// saving the file for use by the saveMi
				dataFile = phil;
				
				save.setDisable(false);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Method to do save As click 
	 */
	private void handleSaveAsClick() {
		FileChooser fc = new FileChooser();
		fc.setTitle("Save Text");
		fc.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"), new ExtensionFilter("All Files", "*.*"));
		
		File phil = fc.showSaveDialog(MainApp.primaryStage);
		
		if (phil != null) {
			try (PrintStream ps = new PrintStream(phil)) {
				ps.print(myTextArea.getText());
				// saving the file for use by the save
				save.setDisable(false);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleSaveClick() {
		try (PrintStream ps = new PrintStream(dataFile)) {
			ps.print(myTextArea.getText());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
