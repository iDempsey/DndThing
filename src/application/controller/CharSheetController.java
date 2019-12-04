package application.controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CharSheetController implements EventHandler<ActionEvent>{
	public Button continueMain;
	public Label invalidMessage;
	public TextField strength;
	public TextArea dexterity;
	public TextArea constitution;
	public TextArea intelligence;
	public TextArea wisdom;
	public TextArea charisma;
	
	@Override
	public void handle(ActionEvent x){
		if(x.getSource() == continueMain){
			
				int c = stat();
				if (c == 1){
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
				else{
					invalidMessage.setOpacity(1);
				}
			}
			
		
	}
	
	public int stat(){
		int next = 1;
		String s = "" + strength.getText();
		int i = Integer.parseInt(s);
		if (i <= 0 || i > 20){
			next = 0;
			System.out.println("strength is invalid");
			//invalidMessage.setOpacity(1);
			//strength.setText("invalid");
		}
		return next;
	}
}

