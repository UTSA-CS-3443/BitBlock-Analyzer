/**
 * 
 */
package bba.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import bba.MainApp;
import bba.model.Input;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * This class contains even handles dealing with file IO relative to the view
 * @author Triston Scallan
 * @author Irfan Syed
 *
 */
public class ControllerFileHandlers {
	/**
	 * Method to do save As click and open the window with some functionality 
	 * @param docTextArea
	 * @param dataFile
	 * @param save
	 * @return an Object, the parameter save 
	 */
	static Object handleSaveAsClick(TextArea docTextArea, File dataFile, MenuItem save) {
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
		return save;
	}
	
	/**
	 * Saves the current file
	 * @param docTextArea
	 * @param dataFile
	 * printstream is JavaFx function
	 */
	static void handleSaveClick(TextArea docTextArea, File dataFile) {
		try (PrintStream ps = new PrintStream(dataFile)) {
			ps.print(docTextArea.getText());
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to open a window which can load Text files
	 * @param docTextArea
	 * @param dataFile
	 * @param idIndex
	 * @param inputM 
	 * @return an object array wrapper. <p> Wrapper: Object[] {TextArea, File, List&ltInput&gt, Boolean}@return
	 */
	static Object[] handleOpenClick(TextArea docTextArea, File dataFile, int idIndex, List<Input> inputM)  {
		//creating JavaFX file chooser 
		FileChooser fc = new FileChooser();
		fc.setTitle("Get Text");
		fc.getExtensionFilters().addAll(new ExtensionFilter("Java Files", "*.java"), new ExtensionFilter("All Files", "*.*"));
		File file = fc.showOpenDialog(MainApp.getStage());
		Boolean success = false; //defines if this function was successful
		
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
				//idIndex++; the id will at 0, i.e. only one input at a given time.
				
				success = true;
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
		return new Object[] {docTextArea, dataFile, inputM, success};
	}

}

