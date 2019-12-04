package application.model;

import java.util.*;
/*
 * Object that contains all the information for an individual character
 * 
 * 
 */
public class Character {
	
	public Scanner scnr = new Scanner(System.in);
	
	public String name; //Character's in-game name
	public String alignment; //What the character's moral compass is (ie lawful good, chaotic evil, neutral chaotic, etc...)
	public int maxHP; //The highest a character's hp can be
	public int currHP; //The character's current hp (goes down if damage is taken)
	public int level = 0; //The character's current level
	public Race race; //The race for the character (elf,dwarf,tiefling,etc.)
	public Class cls; //The character's class (sorcerer,warrior,etc)
	public Background bg; //The character's background (criminal, charlatan, etc.)
	public ArrayList<Feature> featList = new ArrayList<Feature>(); //The character's features, from their class/background/race
	public int[] stats = new int[6];//Character's stats in order: Strength, Dexterity, Constitution, Intelligence, Wisdom, and Charisma
	public boolean[] savingThrows = new boolean[6];//List of saving throws in order: Strength, Dexterity, Constitution, Intelligence, Wisdom, and Charisma
	/*List of proficiencies in order:
	 * 0:Acrobatics
	 * 1:Animal Handling
	 * 2:Arcana
	 * 3:Athletics
	 * 4:Deception
	 * 5:History
	 * 6:Insight
	 * 7:Intimidation
	 * 8:Investigation
	 * 9:Medicine
	 * 10:Nature
	 * 11:Perception
	 * 12:Performance
	 * 13:Persuasion
	 * 14:Religion
	 * 15:Sleight of Hand
	 * 16:Stealth
	 * 17:Survival
	*/
	public boolean[] proficiencies = new boolean[18];
	public Character(){} //Empty constructor for the character
	
	//Constructor when the user has inputed all the information/loading previous characters
	public Character(String name, String alignment, int maxHP, int level, Race race, Class cls, Background bg, int[] stats, boolean[] savingThrows, boolean[] proficiencies){
		this.name = name;
		this.alignment = alignment;
		this.maxHP = maxHP;
		this.level = level;
		this.race = race;
		this.cls = cls;
		this.bg = bg;
		this.stats = stats;
		this.savingThrows = savingThrows;
		this.proficiencies = proficiencies;
	}
	
	/*
	 * Different setters for the character's variables
	 */
	public void statString(int index){
		
	}
	public void setName(String name){
		this.name = name;
	}
	public void setRace(Race newRace){
		this.race = newRace;
	}
	public void updateLevel(){      //On character creation, run updateLevel() once for every level.
		Random rand = new Random(); //If the user puts their level as 1, keep it as 0.
		this.level++;
		if(level == 1)
			this.maxHP = cls.startingHP;
		else
			this.maxHP = maxHP + (rand.nextInt(cls.hitDice)+1);
		
		//Checks the character's class features and adds any new ones that fit the character's new level
		for(int i = 0; i < cls.featList.size();i++){
			if(cls.featList.get(i).level == this.level)
				featList.add(cls.featList.get(i));
		}
		
	}
	public void setBackground(Background newBG){
		this.bg = newBG;
	}
	public void setClass(Class newClass){
		this.cls = newClass;
	}
	public void setMaxHP(int newMHP){
		this.maxHP = newMHP;
	}
	public void setAlignment(String align){
		this.alignment = align;
	}
	public void setLevel(String level){
		this.level = Integer.parseInt(level);
	}
	public void setFeatlist(){
		this.featList.addAll(race.featList);
		this.featList.add(bg.feat);
	}
	public int setStats(String str, String dex, String con, String Int, String wis, String cha){
		if(Integer.parseInt(str) < 0 || Integer.parseInt(str) > 21)
			return -1;
		else if(Integer.parseInt(dex) < 0 || Integer.parseInt(dex) > 21)
			return -2;
		else if(Integer.parseInt(con) < 0 || Integer.parseInt(con) > 21)
			return -3;
		else if(Integer.parseInt(Int) < 0 || Integer.parseInt(Int) > 21)
			return -4;
		else if(Integer.parseInt(wis) < 0 || Integer.parseInt(wis) > 21)
			return -5;
		else if(Integer.parseInt(cha) < 0 || Integer.parseInt(cha) > 21)
			return -6;
		else{
			this.stats[0] = Integer.parseInt(str) + race.statBoosts[0];
			this.stats[1] = Integer.parseInt(dex) + race.statBoosts[1];
			this.stats[2] = Integer.parseInt(con) + race.statBoosts[2];
			this.stats[3] = Integer.parseInt(Int) + race.statBoosts[3];
			this.stats[4] = Integer.parseInt(wis) + race.statBoosts[4];
			this.stats[5] = Integer.parseInt(cha) + race.statBoosts[5];
			return 1;
		}
	}
	
	public String getName(){return this.name;}
	public String getAlignment(){return this.alignment;}
	public int getMaxHP(){return this.maxHP;}
	public int getLevel(){return this.level;}
	public Race getRace(){return this.race;}
	public Class getCls(){return this.cls;}
	public Background getBackground(){return this.bg;}
	public ArrayList<Feature> getFeatList(){return this.featList;}
	public int[] getStats(){return this.stats;}
	public boolean[] getST(){return this.savingThrows;}
	public boolean[] getProficiencies(){return this.proficiencies;}
	
	

}
