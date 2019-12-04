package application.model;

import java.util.ArrayList;

public class Class {
	public String name;
	public int hitDice;
	public int startingHP;
	public ArrayList<Feature> featList = new ArrayList<Feature>();
	public ArrayList<Spell> spellList = new ArrayList<Spell>();
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
	public Class(){}
	
	
	public Class(String name, int hitDice, int startingHP, ArrayList<Feature> featList,
			ArrayList<Spell> spellList, boolean[] savingThrows, boolean[] proficiencies) {
		this.name = name;
		this.hitDice = hitDice;
		this.featList = featList;
		this.spellList = spellList;
		this.savingThrows = savingThrows;
		this.proficiencies = proficiencies;
	}


	public void setName(String name){
		this.name = name;
	}
	public void setHitDice(int hitDice){
		this.hitDice = hitDice;
	}
	public void setProficiencies(boolean acrobatics, boolean animalHandling, boolean arcana, boolean athletics, boolean deception, boolean history, boolean insight, boolean intimidation, boolean investigation,
								 boolean medicine, boolean nature, boolean perception, boolean performance, boolean persuasion, boolean religion, boolean sleightOfHand, boolean stealth, boolean survival,
								 boolean strST, boolean dexST, boolean conST, boolean intST, boolean wisST, boolean chaST){
		proficiencies[0] = acrobatics;
		proficiencies[1] = animalHandling;
		proficiencies[2] = arcana;
		proficiencies[3] = athletics;
		proficiencies[4] = deception;
		proficiencies[5] = history;
		proficiencies[6] = insight;
		proficiencies[7] = intimidation;
		proficiencies[8] = investigation;
		proficiencies[9] = medicine;
		proficiencies[10] = nature;
		proficiencies[11] = perception;
		proficiencies[12] = performance;
		proficiencies[13] = persuasion;
		proficiencies[14] = religion;
		proficiencies[15] = sleightOfHand;
		proficiencies[16] = stealth;
		proficiencies[17] = survival;
		
		savingThrows[0] = strST;
		savingThrows[1] = dexST;
		savingThrows[2] = conST;
		savingThrows[3] = intST;
		savingThrows[4] = wisST;
		savingThrows[5] = chaST;
	}
	public void setFeats(Feature feat){
		this.featList.add(feat);
	}
	public void addFeat(String name, String level, String desc){
		Feature feat = new Feature();
		feat.name = name;
		feat.level = Integer.parseInt(level);
		feat.desc = desc;
		this.featList.add(feat);
	}
	public void setStartingHP(int startingHP){
		this.startingHP = startingHP;
	}
	public void setSpellList(ArrayList<Spell> s){
		this.spellList = s;
	}
	public void addSpell(String level, String name, String desc){
		Spell s = new Spell();
		s.desc = desc;
		s.name = name;
		s.level = Integer.parseInt(level);
		this.spellList.add(s);
	}
	public String getName(){return this.name;}
	public int getHitDice(){return this.hitDice;}
	public int getStartingHP(){return this.startingHP;}
	public ArrayList<Feature> getFeatList(){return this.featList;}
	public ArrayList<Spell> getSpellList(){return this.spellList;}
	public boolean[] getST(){return this.savingThrows;}
	public boolean[] getProficiencies(){return this.proficiencies;}
	
	
}
