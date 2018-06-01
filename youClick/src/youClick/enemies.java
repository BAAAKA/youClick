package youClick;

public class enemies {
	
	private int HP;
	private String name;
	private String race;
	private int resistanceToSchinken;
	private int resistanceToBleistift;
	private int resistanceToBombe;
	private int resistanceToSchwert;

	public enemies(int HP, String name, String race, int resistanceToSchinken, int resistanceToBleistift, int resistanceToSchwert, int resistanceToBombe){
		this.HP=HP;
		this.name=name;
		this.race=race;
		this.resistanceToSchinken=resistanceToSchinken;
		this.resistanceToBleistift=resistanceToBleistift;
		this.resistanceToSchwert=resistanceToSchwert;
		this.resistanceToBombe=resistanceToBombe;

	}

	public int getHP() {
		return HP;
	}
	public void setHP(int HP) {
		this.HP = HP;
	}
	public void descreaseHP(int dmgdone){
		HP=HP-dmgdone;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}


	
	
	
	
	
}
