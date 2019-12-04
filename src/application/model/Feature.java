package application.model;


public class Feature {
	public int level;
	public String desc;
	public String cls;
	public String race;
	public String name;
	
	public Feature(){}
	
	public Feature(int level, String desc, String cls, String race, String name) {
		this.level = level;
		this.desc = desc;
		this.cls = cls;
		this.race = race;
		this.name = name;
	}

	public void setLevel(int level){
		this.level = level;
	}
	public void setName(String name){
		this.name = name;
	}
	public void setDesc(String desc){
		this.desc = desc;
	}
	public void setRace(String race){
		this.race = race;
	}
	public void setCls(String cls){
		this.cls = cls;
	}
	
	public int getLevel(){return this.level;}
	public String getName(){return this.name;}
	public String getDesc(){return this.desc;}
	public String getRace(){return this.race;}
	public String getCls(){return this.cls;}
}