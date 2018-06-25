package youClick;

import javax.swing.ImageIcon;

public class enemies {
	
	private int HP; //this.HP
	private String name;
	private String race;
	private ImageIcon icon;

	public enemies(int HP, String name, String race,ImageIcon icon){
		this.HP=HP; //HP
		this.name=name;
		this.race=race;

		this.icon=icon;
		// Alle Methoden und Variablen sind in der Oberklasse weil es dadurch simpler ist. Und sowieso nur getter und setter in dieser Klasse existieren.

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

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}


	
	
	
	
	
}
