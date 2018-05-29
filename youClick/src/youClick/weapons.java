package youClick;

public class weapons {
	private String name;
	private int dmg;

	
	public weapons(String name, int dmg){
		this.setName(name);
		this.setDmg(dmg);
	}


	public int getDmg() {
		return dmg;
	}


	public void setDmg(int dmg) {
		this.dmg = dmg;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
	
}
