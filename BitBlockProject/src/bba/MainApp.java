package bba;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * @author Josh Thorsson and Triston Scallan
 */

public class MainApp extends Application 
{
	private static Stage stage;
		
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("view/BBGui.fxml"));
			primaryStage.setScene(new Scene(root, 1000, 900));
			primaryStage.setTitle("BitBlockAnalyzer");
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Stage getStage() {		//use this to retrieve the stage
		return stage; 
	}
	
	public static void main(String[] args) 
	{
		launch(args);
	}
	
	
	/* Old code for the two separate views
	public static Stage primaryStage;
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
	*/
}
