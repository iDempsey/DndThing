package application.model;


public class Spell {
	
	public int level;
	public String name;
	public String desc;
	
	public Spell(){}
	
	public Spell(int level, String name, String desc) {
		this.level = level;
		this.name = name;
		this.desc = desc;
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
	
	public int getLevel(){return this.level;}
	public String getName(){return this.name;}
	public String getDesc(){return this.desc;}
	
}
