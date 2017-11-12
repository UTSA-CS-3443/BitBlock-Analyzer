package gui;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MainController implements Initializable {
		
		//close the application when you hit close in the menu
		public void doClose(ActionEvent event) {
			Platform.exit();  // exit from JAVAFX
			System.exit(0);
		}

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
		}
		

	}
