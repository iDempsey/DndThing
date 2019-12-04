package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class SpellbookController implements EventHandler<ActionEvent>{
	public Button continueButton;
	public Button continueMain;
	@Override
	public void handle(ActionEvent x){
		if(x.getSource() == continueButton){
			try{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/SpellSheet.fxml"));
				Parent root = loader.load();
				Main.stage.setScene(new Scene(root, 500, 450));
				Main.stage.show();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	
		}
		if(x.getSource() == continueMain){
			try{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/Main.fxml"));
				Parent root = loader.load();
				Main.stage.setScene(new Scene(root, 500, 450));
				Main.stage.show();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	
		}
	}
}
