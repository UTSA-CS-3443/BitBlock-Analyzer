package bba.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/*
 * @author Josh Thorsson
 */
public class RootLayoutController {
	
	//private Model model;
	
	@FXML
	private MenuItem close; 
	
	@FXML
	void quitAction(ActionEvent event) {
		Platform.exit(); 
		System.exit(0);
	}
}
