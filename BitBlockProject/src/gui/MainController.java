package gui;
import javafx.event.ActionEvent;

import java.awt.event.InputEvent;
import java.net.URL;
import java.util.ResourceBundle;

import com.sun.glass.events.KeyEvent;
import com.sun.glass.ui.MenuBar;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * Controller class to interact with GUI 
 * @author Irfan Syed 
 *
 */

public class MainController implements Initializable {
	@FXML
	private MenuBar menuBar;
	
		@FXML
		//close the application when you hit close in the menu
		public void doClose(ActionEvent event) {
			Platform.exit();  // exit from JAVAFX
			System.exit(0);
		}
		
		@FXML
		private void handleAboutAction(final ActionEvent event) {
			provideAboutFunctionality();
		}

		/**
		@FXML
		working to see if I can create a short cuts for the keys  
		private void handleKeyInput( final InputEvent event) {
			if (event instanceof KeyEvent)
			{
				final KeyEvent keyEvent = (KeyEvent) event; 
				if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.X)	
			}
		}
		
		**/
		
		private void provideAboutFunctionality() {
			System.out.println("You clicked on About!");
		}
		
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			// menuBar.setFocusTraversable(true);
			
		}
		

	}
