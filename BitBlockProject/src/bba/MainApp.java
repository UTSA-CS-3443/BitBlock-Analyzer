package bba;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import bba.model.*;

/*
 * @author Josh Thorsson
 */

public class MainApp extends Application 
{
	
	private Stage primaryStage;
	private BorderPane rootLayout;

	@Override
	public void start(Stage primaryStage) 
	{
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("Bit Block Analyzer");
		this.primaryStage.setResizable(false);
		
		initRootLayout();
		showBitBlockGUI();
		
	}
	
	public void initRootLayout() 
	{
		try 
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			rootLayout = (BorderPane) loader.load();
			
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			primaryStage.show();			
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void showBitBlockGUI()
	{
		try
		{
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/BitBlockGUI.fxml"));
			AnchorPane bitBlockGUI = (AnchorPane) loader.load();
			
			rootLayout.setCenter(bitBlockGUI);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Stage getPrimaryStage()
	{
		return primaryStage;
	}

	public static void main(String[] args) 
	{
		launch(args);
	}
}
