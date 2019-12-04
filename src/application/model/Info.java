package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Info {	
	//Delimiter for files
	private static final String FILE_DELIMITER = "`";
	private static final String SECOND_FILE_DELIMITER = "::";
	
	
	public void loadFeatures(String location, ArrayList<Feature> featList)
	{
		File file = new File(location);
		Scanner scan;
		try {
			scan = new Scanner(file);
			while( scan.hasNext())
			{
				String[] temp;
			    String line = scan.nextLine();
			    //Delimiter!
			    temp = line.split(FILE_DELIMITER);
			    
			    featList.add(new Feature(Integer.parseInt(temp[0]), temp[1], temp[2], temp[3], temp[4]));
			}
			scan.close();
		} catch (FileNotFoundException e) {
		}
	}
	public void saveFeatures(String location, ArrayList<Feature> featList)
	{
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(location);
			for (Feature feature : featList)
			{
				//Appended
				fileWriter.append(String.valueOf(feature.getLevel()));
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(feature.getDesc());
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(feature.getCls());
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(feature.getRace());
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(feature.getName());
				fileWriter.append("\n");
			}
		}
		catch (Exception e)
		{
					
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
			}
		}
	}
	
	
	public void loadSpells(String location, ArrayList<Spell> spellBook)
	{
		File file = new File(location);
		Scanner scan;
		try {
			scan = new Scanner(file);
			while( scan.hasNext())
			{
				String[] temp;
			    String line = scan.nextLine();
			    //Delimiter!
			    temp = line.split(FILE_DELIMITER);
			    
			    spellBook.add(new Spell(Integer.parseInt(temp[0]), temp[1], temp[2]));
			}
			scan.close();
		} catch (FileNotFoundException e) {
		}
	}
	public void saveSpells(String location, ArrayList<Spell> spellBook)
	{
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(location);
			for (Spell spell : spellBook)
			{
				//Appended
				fileWriter.append(String.valueOf(spell.getLevel()));
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(spell.getName());
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(spell.getDesc());
				fileWriter.append("\n");
			}
		}
		catch (Exception e)
		{
					
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
			}
		}
	}
	
	
	public void loadRaces(String location, ArrayList<Race> raceList, ArrayList<Feature> featList)
	{
		
		File file = new File(location);
		Scanner scan;
		try {
			scan = new Scanner(file);
			while( scan.hasNext())
			{
				//Array List to be populated with matching features
				ArrayList<Feature> tempFeatList = new ArrayList<Feature>();
				String[] temp;
			    String line = scan.nextLine();
			    //Delimiter!
			    temp = line.split(FILE_DELIMITER);
			    
			    //Assign matching features
			    for(Feature feat: featList)
			    {
			    	if(feat.getRace().equals(temp[0]))
			    	{
			    		tempFeatList.add(feat);
			    	}
			    }
			    
			    int[] tempIList = new int[6];
			    //Set int list
			    for(int iCount = 0; iCount < 6; iCount++)
			    {
			    	tempIList[iCount] = Integer.parseInt(temp[iCount+1]);
			    }
			    	
			    raceList.add(new Race(temp[0], tempFeatList, tempIList));
			}
			scan.close();
		} catch (FileNotFoundException e) {
		}
	}
	public void saveRaces(String location, ArrayList<Race> raceList)
	{
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(location);
			for (Race race : raceList)
			{
				//Appended
				fileWriter.append(race.getName());
				
				for(int iStat = 0; iStat < 6; iStat++)
				{
					fileWriter.append(FILE_DELIMITER);
					fileWriter.append(String.valueOf(race.getStatBoosts()[iStat]));
				}
				fileWriter.append("\n");
			}
		}
		catch (Exception e)
		{
					
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
			}
		}
	}

	
	public void loadClasses(String location, ArrayList<Class> classList, ArrayList<Feature> featList, ArrayList<Spell> spellBook)
	{
		File file = new File(location);
		Scanner scan;
		try {
			scan = new Scanner(file);
			while( scan.hasNext())
			{
				//Array List to be populated with matching features
				ArrayList<Feature> tempFeatList = new ArrayList<Feature>();
				ArrayList<Spell> tempSpellList = new ArrayList<Spell>();
				String[] tempSpell;
				String[] temp;
			    String line = scan.nextLine();
			    //Delimiter!
			    temp = line.split(FILE_DELIMITER);
			    
			    //Assign matching features
			    for(Feature feat: featList)
			    {
			    	if(feat.getClass().equals(temp[0]))
			    	{
			    		tempFeatList.add(feat);
			    	}
			    }
			    
			    //Boolean assignments
			    boolean[] tempSaveList = new boolean[6];
			    //Set save boolean list
			    for(int iCount = 0; iCount < 6; iCount++)
			    {
			    	tempSaveList[iCount] = Boolean.parseBoolean(temp[iCount+4]);
			    }
			    
			    boolean[] tempProficiencies = new boolean[18];
			    for(int iCount = 0; iCount < 18; iCount++)
			    {
			    	tempProficiencies[iCount] = Boolean.parseBoolean(temp[iCount+10]);
			    }
			    
			    //Get spell list
			    tempSpell = temp[3].split(SECOND_FILE_DELIMITER);
			    for(int iCount = 0; iCount < tempSpell.length; iCount++)
			    {
			    	for(Spell spell:spellBook)
			    	{
				    	if(tempSpell[iCount].equals(spell.getName()))
				    	{
				    		tempSpellList.add(spell);
				    	}
			    	}
			    }
			    
			    classList.add(new Class(temp[0], Integer.parseInt(temp[1]), Integer.parseInt(temp[2]), tempFeatList, tempSpellList, tempSaveList, tempProficiencies));
			}
			scan.close();
		} catch (FileNotFoundException e) {
		}
	}
	public void saveClasses(String location, ArrayList<Class> classList)
	{
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(location);
			for (Class cls : classList)
			{
				//Appended
				fileWriter.append(cls.getName());
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(String.valueOf(cls.getHitDice()));
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(String.valueOf(cls.getStartingHP()));
				fileWriter.append(FILE_DELIMITER);
				int iCount = 1;
				for(Spell spell:cls.getSpellList())
				{
					fileWriter.append(spell.getName());
					if(iCount < cls.getSpellList().size())
					{
						fileWriter.append(SECOND_FILE_DELIMITER);
					}
					iCount++;
				}
				for(int iSave = 0; iSave < 6; iSave++)
				{
					fileWriter.append(FILE_DELIMITER);
					fileWriter.append(String.valueOf(cls.getST()[iSave]));
				}
				for(int iProf = 0; iProf < 18; iProf++)
				{
					fileWriter.append(FILE_DELIMITER);
					fileWriter.append(String.valueOf(cls.getProficiencies()[iProf]));
				}
				fileWriter.append("\n");
			}
		}
		catch (Exception e)
		{
					
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
			}
		}
	}
	
	
	public void loadBackgrounds(String location, ArrayList<Background> bgList, ArrayList<Feature> featList)
	{
		File file = new File(location);
		Scanner scan;
		try {
			scan = new Scanner(file);
			while( scan.hasNext())
			{
				//Feature holder
				Feature tempFeat = new Feature();
				String[] temp;
			    String line = scan.nextLine();
			    //Delimiter!
			    temp = line.split(FILE_DELIMITER);
			    
			    //Find feature
			    for(Feature feature:featList)
			    {
				    if(feature.getName().equals(temp[2]))
				    {
				    		tempFeat = feature;
				    }
			    }
			    
			    //Boolean assignment
			    boolean[] tempProficiencies = new boolean[18];
			    for(int iCount = 0; iCount < 18; iCount++)
			    {
			    	tempProficiencies[iCount] = Boolean.parseBoolean(temp[iCount+3]);
			    }
			    
			    bgList.add(new Background(temp[0], temp[1], tempFeat, tempProficiencies));
			}
			scan.close();
		} catch (FileNotFoundException e) {
		}
	}
	public void saveBackgrounds(String location, ArrayList<Background> bgList)
	{
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(location);
			for (Background background : bgList)
			{
				//Appended
				fileWriter.append(background.getName());
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(background.getDesc());
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(background.getFeat().getName());
				
				for(int iProf = 0; iProf < 18; iProf++)
				{
					fileWriter.append(FILE_DELIMITER);
					fileWriter.append(String.valueOf(background.getProficiencies()[iProf]));
				}
				fileWriter.append("\n");
			}
		}
		catch (Exception e)
		{
					
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
			}
		}
	}
	
	public void loadCharacters(String location, ArrayList<Character> charList, ArrayList<Race> raceList, ArrayList<Class> classList, ArrayList<Background> bgList)
	{
		File file = new File(location);
		Scanner scan;
		try {
			scan = new Scanner(file);
			while( scan.hasNext())
			{
				String[] temp;
			    String line = scan.nextLine();
			    //Delimiter!
			    temp = line.split(FILE_DELIMITER);
			    
			    Race tempRace = new Race();
			    for(Race race:raceList)
			    {
			    	if(race.getName().equals(temp[4]))
			    	{
			    		tempRace = race;
			    	}
			    }
			    Class tempClass = new Class();
			    for(Class cls:classList)
			    {
			    	if(cls.getName().equals(temp[5]))
			    	{
			    		tempClass = cls;
			    	}
			    }
			    Background tempBg = new Background();
			    for(Background background:bgList)
			    {
			    	if(background.getName().equals(temp[6]))
			    	{
			    		tempBg = background;
			    	}
			    }
			    
			    int[] tempStats = new int[6];
			    for(int iCount = 0; iCount < 6; iCount++)
			    {
			    	tempStats[iCount] = Integer.parseInt(temp[iCount+7]);
			    }
			    boolean[] tempSaving = new boolean[6];
			    for(int iCount = 0; iCount < 6; iCount++)
			    {
			    	tempSaving[iCount] = Boolean.getBoolean(temp[iCount+13]);
			    }
			    boolean[] tempProficiencies = new boolean[18];
			    for(int iCount = 0; iCount < 18; iCount++)
			    {
			    	tempProficiencies[iCount] = Boolean.getBoolean(temp[iCount+19]);
			    }
			    
			    charList.add(new Character(temp[0], temp[1], Integer.parseInt(temp[2]), Integer.parseInt(temp[3]), tempRace, tempClass, tempBg, tempStats, tempSaving, tempProficiencies));
			}
			scan.close();
		} catch (FileNotFoundException e) {

		}
		//Call Set Feat List
		for(Character character:charList)
		{
			character.setFeatlist();
		}
	}
	public void saveCharacters(String location, ArrayList<Character> charList)
	{
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter(location);
			for (Character character : charList)
			{
				//Appended
				fileWriter.append(character.getName());
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(character.getAlignment());
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(String.valueOf(character.getMaxHP()));
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(String.valueOf(character.getLevel()));
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(character.getRace().getName());
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(character.getClass().getName());
				fileWriter.append(FILE_DELIMITER);
				fileWriter.append(character.getBackground().getName());
				for(int iCount = 0; iCount < 6; iCount++)
				{
					fileWriter.append(FILE_DELIMITER);
					fileWriter.append(String.valueOf(character.getStats()[iCount]));
				}
				for(int iCount = 0; iCount < 6; iCount++)
				{
					fileWriter.append(FILE_DELIMITER);
					fileWriter.append(String.valueOf(character.getST()[iCount]));
				}
				for(int iCount = 0; iCount < 18; iCount++)
				{
					fileWriter.append(FILE_DELIMITER);
					fileWriter.append(String.valueOf(character.getProficiencies()[iCount]));
				}
				fileWriter.append("\n");
			}
		}
		catch (Exception e)
		{
					
		} finally {
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
			}
		}
	}
}

