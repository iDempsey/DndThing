/*
 * @author Alexandra Garcia  kgd962
 * 
 * class Main loads and sets up the scene display for the app
 */
package application;
import application.*;	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	public static Stage stage;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {//throws Exception {
		try{
        // just load fxml file and display it in the stage:
        Parent root = FXMLLoader.load(getClass().getResource("/application/view/Main.fxml"));
        
        primaryStage.setTitle("DnD Thing");
        primaryStage.setScene(new Scene(root, 500, 450));
        primaryStage.setMaxWidth(800);
        primaryStage.setMaxHeight(800);
        primaryStage.show();
        stage = primaryStage;
		}catch(Exception e) {
			e.printStackTrace();
		}
    }
	
	
}

