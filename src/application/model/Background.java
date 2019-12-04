package application.model;


public class Background {
	public String name;
	public String desc;
	public Feature feat;
	
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
	
	public Background(){}
	
	public Background(String name, String desc, Feature feat, boolean[] proficiencies) {
		this.name = name;
		this.desc = desc;
		this.feat = feat;
		this.proficiencies = proficiencies;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setDesc(String desc){
		this.desc = desc;
	}
	public void setbgFeat(Feature feat){
		this.feat = feat;
	}
	public void setProficiencies(){
		
	}
	public String getName(){return this.name;}
	public String getDesc(){return this.desc;}
	public Feature getFeat(){return this.feat;}
	public boolean[] getProficiencies(){return this.proficiencies;}
}
