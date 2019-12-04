/*package application.model;

import java.util.*;

public class Main {
	
	//Lists of objects
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
	
	//Creates a new character by calling all the Character class setters
	public static void createChar(){
		Character character = new Character();
		//character.setName();
		//character.setRace();
		//character.setClass();
		//character.setBackground();
		charList.add(character);
	}
	
	//public static void main(String[] args){
		Info Data = new Info();
		
		Data.loadFeatures("Data/Features.csv", featList);
		Data.loadSpells("Data/Spells.csv", spellBook);
		Data.loadRaces("Data/Races.csv", raceList, featList);
		Data.loadClasses("Data/Classes.csv", classList, featList, spellBook);
		Data.loadBackgrounds("Data/Backgrounds.csv", bgList, featList);
		Data.loadCharacters("Data/Characters.csv", charList, raceList, classList, bgList);
		
		//Examples of saving
		//Data.saveFeatures("Data/Features.csv", featList);
		//Data.saveSpells("Data/Spells.csv", spellBook);
		//Data.saveRaces("Data/Races.csv", raceList);
		//Data.saveClasses("Data/Classes.csv", classList);
		//Data.saveBackgrounds("Data/Backgrounds.csv", bgList);
		//Data.saveCharacters("Data/Characters.csv", charList);
	}
	
}*/
