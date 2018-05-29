package youClick;

public class enemies {
	
	private int HP;
	private String name;
	private String race;
	private int resistanceToSchinken;
	private int resistanceToBleistift;
	private int resistanceToBombe;
	private int resistanceToSchwert;

	public enemies(int HP, String name, String race, int resistanceToSchinken, int resistanceToBleistift, int resistanceToBombe, int resistanceToSchwert){
		this.setHP(HP);
		this.name=name;
		this.race=race;
		this.resistanceToSchinken=resistanceToSchinken;
		this.resistanceToBleistift=resistanceToBleistift;
		this.resistanceToBombe=resistanceToBombe;
		this.resistanceToSchwert=resistanceToSchwert;

	}

	public int getHP() {
		return HP;
	}
	public void setHP(int HP) {
		HP = HP;
	}

	public int getResistanceToSchinken() {
		return resistanceToSchinken;
	}

	public void setResistanceToSchinken(int resistanceToSchinken) {
		this.resistanceToSchinken = resistanceToSchinken;
	}

	public int getResistanceToBleistift() {
		return resistanceToBleistift;
	}

	public void setResistanceToBleistift(int resistanceToBleistift) {
		this.resistanceToBleistift = resistanceToBleistift;
	}

	public int getResistanceToBombe() {
		return resistanceToBombe;
	}

	public void setResistanceToBombe(int resistanceToBombe) {
		this.resistanceToBombe = resistanceToBombe;
	}

	public int getResistanceToSchwert() {
		return resistanceToSchwert;
	}

	public void setResistanceToSchwert(int resistanceToSchwert) {
		this.resistanceToSchwert = resistanceToSchwert;
	}


	
	
	
	
}
