package application.model;

import java.util.ArrayList;
public class Race {
	public String name;
	public ArrayList<Feature> featList = new ArrayList<Feature>();
	public int[] statBoosts = new int[6];
	
	public Race(){}
	
	public Race(String name, ArrayList<Feature> featList, int[] statBoosts) {
		this.name = name;
		this.featList = featList;
		this.statBoosts = statBoosts;
	}

	public void setName(String name){
		this.name = name;
	}
	public void setStatBoosts(String str, String dex, String con, String Int, String wis, String cha){
		this.statBoosts[0] = Integer.parseInt(str);
		this.statBoosts[1] = Integer.parseInt(dex);
		this.statBoosts[2] = Integer.parseInt(con);
		this.statBoosts[3] = Integer.parseInt(Int);
		this.statBoosts[4] = Integer.parseInt(wis);
		this.statBoosts[5] = Integer.parseInt(cha);
	}
	public void setFeats(Feature feat){
		this.featList.add(feat);
	}
	public void setFeats(String name, String level, String desc){
		Feature feat = new Feature();
		feat.name = name;
		feat.level = Integer.parseInt(level);
		feat.desc = desc;
		this.featList.add(feat);
	}
	
	public int[] getStatBoosts(){return this.statBoosts;}
	public ArrayList<Feature> getFeatList(){return this.featList;}
	public String getName(){return this.name;}
}
