/*
 * @author Alexandra Garcia  kgd962
 * 
 * class MainController handles the events of the main.fxml
 */
package application.controller;
import application.Main;
import application.model.*;//DisneyMovies;
import application.model.Character;
import application.model.Class;
import application.model.Load;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.Event;
import javafx.event.ActionEvent;
import java.util.*;

//@FunctionalInterface
//public interface EventHandler<T extends Event> extends EventListener

public class MainController implements EventHandler<ActionEvent>{

	//buttons/objects in Main.fxml (Main Screen Page)
	public TextField tf;
	public TextArea printRandom;
	public Button b4;
	public Button b6;
	public Button b8;
	public Button b10;
	public Button b12;
	public Button b20;
	public Button b100;
	public Button charButton;
	public Button monstersButton;
	public Button spellButton;
	
	/*
	public static ArrayList<Race> raceList = new ArrayList<Race>();
	public static ArrayList<Character> charList = new ArrayList<Character>();
	public static ArrayList<Class> classList = new ArrayList<Class>();
	public static ArrayList<Background> bgList = new ArrayList<Background>();
	public static ArrayList<Spell> spellBook = new ArrayList<Spell>();
	public static ArrayList<Feature> featList = new ArrayList<>();
	
	public static ArrayList<Race> getRaceList(){
		return raceList;
	}
	public static ArrayList<Character> getCharList(){
		return charList;
	}
	public static ArrayList<Class> getClassList(){
		return classList;
	}
	public static ArrayList<Background> getBgList(){
		return bgList;
	}
	public static void createChar(){
		Character character = new Character();
		//character.setName();
		//character.setRace();
		//character.setClass();
		//character.setBackground();
		charList.add(character);
	}*/
	//public static Info Data = new Info();
	public void initialize(){
		Load.loadData();
		/*
		Info Data = new Info();
		
		Data.loadFeatures("data/Features.csv", featList);
		Data.loadSpells("data/Spells.csv", spellBook);
		Data.loadRaces("data/Races.csv", raceList, featList);
		Data.loadClasses("data/Classes.csv", classList, featList, spellBook);
		Data.loadBackgrounds("data/Backgrounds.csv", bgList, featList);
		Data.loadCharacters("data/Characters.csv", charList, raceList, classList, bgList);
		//loadData();*/
		
	}
	
	@Override
	public void handle(ActionEvent x){
		if(x.getSource() == charButton){
			try{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/CharPage.fxml"));
				Parent root = loader.load();
				Main.stage.setScene(new Scene(root, 500, 450));
				Main.stage.show();
			}
			catch(Exception e){
				e.printStackTrace();
			}
	
		}
		if(x.getSource() == monstersButton){
			try{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/MonsterPage.fxml"));
				Parent root = loader.load();
				Main.stage.setScene(new Scene(root, 500, 450));
				Main.stage.show();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		if(x.getSource() == spellButton){
			try{
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/application/view/SpellbookPage.fxml"));
				Parent root = loader.load();
				Main.stage.setScene(new Scene(root, 500, 450));
				Main.stage.show();
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		
	}
	
	Random rand = new Random();
	public void random(ActionEvent rb){
		int i;
		if(rb.getSource() == b4){
			try{
				i = rand.nextInt(4);		//random number 0-3
				i++;						//add 1 random number 1-4
				String text = Integer.toString(i);
				printRandom.setText(text);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(rb.getSource() == b6){
			try{
				i = rand.nextInt(6);		
				i++;
				String text = Integer.toString(i);
				printRandom.setText(text);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(rb.getSource() == b8){
			try{
				i = rand.nextInt(8);		
				i++;
				String text = Integer.toString(i);
				printRandom.setText(text);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(rb.getSource() == b10){
			try{
				i = rand.nextInt(10);		
				i++;
				String text = Integer.toString(i);
				printRandom.setText(text);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(rb.getSource() == b12){
			try{
				i = rand.nextInt(12);		
				i++;
				String text = Integer.toString(i);
				printRandom.setText(text);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(rb.getSource() == b20){
			try{
				i = rand.nextInt(20);		
				i++;
				String text = Integer.toString(i);
				printRandom.setText(text);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(rb.getSource() == b100){
			try{
				i = rand.nextInt(100);		
				i++;
				String text = Integer.toString(i);
				printRandom.setText(text);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	/*when app first runs, info is loaded to buttons
	public void initialize(){
		d.loadChar("data/characters.csv");
		for(int i = 0; i < d.charArr.size(); i++){
			String option = d.charArr.get(i).getName();
			MenuItem m = new MenuItem(option);
			//harButton.getItems().add(m);
		}
		d.loadMonsters("data/monsters.csv");
		for(int i = 0; i < d.monsterArr.size(); i++){
			String option = d.monsterArr.get(i).getName();
			MenuItem m = new MenuItem(option);
			monstersButton.getItems().add(m);
		}
	}*/
	
	
	
	
}
