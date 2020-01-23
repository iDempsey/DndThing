package application.controller;

import java.util.ArrayList;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import application.controller.MainController;
import application.model.Load;
import application.model.Race;
import application.model.Background;
import application.model.Character;
import application.model.Class;
import application.model.Feature;

public class CharController implements EventHandler<ActionEvent>{
	public Button continueButton;//issa button
	
	
	public GridPane grid;
	public TextArea display;
	
	
	public void initialize(){
		
		int charSize = Load.getCharList().size();
		//System.out.println(Load.charList().toString());
		/*grid.setPadding(new Insets(5));
        grid.setHgap(5);
        grid.setVgap(5);
        int c = 0;
		 for (int r = 0; r < charSize; r++) {
	            
	           Button button = new Button(Load.charList.get(r).getName());
	           button.setPrefSize(50, 220);;
	           button.setId(Load.charList.get(r).getName());
	           button.onMouseClickedProperty();
	           //button.setOnAction(value);
	           grid.add(button, c, r);
	           
	        }
	        public int maxHP; //The highest a character's hp can be
	public int currHP; //The character's current hp (goes down if damage is taken)
	public int level = 0; //The character's current level
	public Race race; //The race for the character (elf,dwarf,tiefling,etc.)
	public Class cls; //The character's class (sorcerer,warrior,etc)
	public Background bg; //The character's background (criminal, charlatan, etc.)
	public ArrayList<Feature> featList = new ArrayList<Feature>(); //The character's features, from their class/background/race
	public int[] stats = new int[6];//Character's stats in order: Strength, Dexterity, Constitution, Intelligence, Wisdom, and Charisma
	public boolean[] savingThrows = new boolean[6];/
		 */
		
		String format = "";
		for (Character character: Load.charList){
			display.appendText(String.format("Character name: %s\n\tAlignment: %s\n\tmaxHP: %d\n\tstats:\n\t\tStrength: %d \n\t\tDexterity: %d\n\t\tConstitution: %d\n\t\tIntelligence: %d\n\t\tWisdom: %d \n\t\tCharisma: %d\n", character.getName(), character.alignment, character.maxHP, character.stats[0],character.stats[1], character.stats[2],character.stats[3],character.stats[4], character.stats[5]));
			display.appendText(String.format("\tRace: %s\n\tClass: %s\n\tBackground: %s\n\n", character.race.name, character.cls.name, character.bg.name));
		}
		//display.setText(Load.charList.get(1).getName());
		 
	     
	}
	@Override
	public void handle(ActionEvent x){
		if(x.getSource() == continueButton){
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
		/*if(x.toString().equals("John")){
			System.out.println("john buton was pressed");
			for (int i = 0; i < Load.charList.size(); i++){
				if (Load.charList.get(i).equals("John")){
					display.setText(Load.charList.get(i).toString());
				}
			}
		}*/
		
	}
	
	
	
	
}
