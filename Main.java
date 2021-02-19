package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage stage) throws Exception {
	      // loads Mortgage.fxml and configures the MortgageController
	      Parent root = 
	         FXMLLoader.load(getClass().getResource("Mortgage.fxml"));

	      Scene scene = new Scene(root); // attach scene graph to scene
	      stage.setTitle("Mortgage Calculator"); // displayed in window's title bar
	      stage.setScene(scene); // attach scene to stage
	      stage.show(); // display the stage
	   }

	public static void main(String[] args) {
		launch(args);
	}
}

