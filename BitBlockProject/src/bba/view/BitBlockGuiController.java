package bba.view;

import javafx.scene.control.*;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.fxml.FXML;
import bba.MainApp;
import bba.model.*;

/*
 * @author Josh Thorsson
 */

public class BitBlockGuiController {

	@FXML
	private Canvas drawArea;
	private GraphicsContext gc;
	
	private MainApp mainApp;
	
	public BitBlockGuiController()
	{
	}
	
	@FXML
	private void initialize()
	{
		
	}
}
