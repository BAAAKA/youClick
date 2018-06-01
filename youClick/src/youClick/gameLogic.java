package youClick;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class gameLogic {
	
	private Random ran=new Random();
	
	private int weaponDmg=1;
	private int weaponUsing=1;
	/*weaponUsing
	 * 1 ist Schinken
	 * 2 ist bleistift
	 * 3 ist bombe
	 * 4 ist schwert
	 */
	
	private weapons schinken=new w_schinken();
	private weapons bleistift=new w_bleistift();
	private weapons bombe=new w_bombe();
	private weapons schwert=new w_schwert();

	private enemies enemy;
	
	
	// !IMPORTANT VOR DEM NUTZEN DIE PFÄDE ZU DEN BILDERN ANPASSEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// !IMPORTANT VOR DEM NUTZEN DIE PFÄDE ZU DEN BILDERN ANPASSEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// !IMPORTANT VOR DEM NUTZEN DIE PFÄDE ZU DEN BILDERN ANPASSEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// !IMPORTANT VOR DEM NUTZEN DIE PFÄDE ZU DEN BILDERN ANPASSEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	private String pathtolehrer="U:/git/youClick/youClick/src/youClick/images/lehrer.jpg";
	private String pathtodrache="U:/git/youClick/youClick/src/youClick/images/drache.jpg";
	private String pathtobakterie="U:/git/youClick/youClick/src/youClick/images/Bakterium.jpg";
	private String pathtoritter="U:/git/youClick/youClick/src/youClick/images/ritter.gif";

	
	private ImageIcon imagedrachen = new ImageIcon(pathtodrache);
	private ImageIcon imagelehrer= new ImageIcon(pathtolehrer);
	private ImageIcon imagebakterie = new ImageIcon(pathtobakterie);
	private ImageIcon imageritter = new ImageIcon(pathtoritter);

	
	static long tStart = System.currentTimeMillis();	//Time at start of programm

	
	public int getDmgDone(enemies enemy){
		int dmgdone=0;

		if(weaponUsing==1){ 		//Je nach dem welche Waffe genutzt wird, wird eine andere resistance stat genutzt
			int resistance=enemy.getResistanceToSchinken();
			dmgdone= schinken.getDmg()-resistance*schinken.getDmg()/100;
		}
		else if(weaponUsing==2){
			int resistance=enemy.getResistanceToBleistift();
			dmgdone= bleistift.getDmg()-resistance*bleistift.getDmg()/100;
		}
		else if(weaponUsing==3){
			int resistance=enemy.getResistanceToBombe();
			dmgdone= bombe.getDmg()-resistance*bombe.getDmg()/100;
		}
		else if(weaponUsing==4){
			int resistance=enemy.getResistanceToSchwert();
			dmgdone= schwert.getDmg()-resistance*schwert.getDmg()/100;
		}
		System.out.println("Enemy Hp: " + enemy.getHP()); 
		System.out.println("DMGDone: " + dmgdone);

		enemy.descreaseHP(dmgdone); //Dem Gegner wird HP abgezogen
		return dmgdone;
	}
	
	public enemies createenemy(){ //Zufällige auswahl eines neuen Gegners
		
		int randomwahl=ran.nextInt(4)+1;
		System.out.println("Creating new enemy");
		switch (randomwahl) {
			case 1: enemy=new e_ritter(100, "Sir Lanzenlord", "ritter", -100, 100, 50, 0);  break;		
			case 2: enemy=new e_lehrer(100, "Böser Lehrer", "lehrer", 100, -100, 0, 50);  break;		
			case 3: enemy=new e_drache(100, "The Fable of the Dragon Tyrant", "drache", 0, 50, -100, 100);  break;		
			case 4: enemy=new e_bakterie(100, "Michael Mike Glotzkovski", "bakterie", 50, 0, 100, -100);  break;		

		}
		System.out.println("Enemy HP "+enemy.getHP());
		System.out.println("Enemy Name " + enemy.getName());
		return enemy;
	}
	
	public String barvalue() { //Was für ein Text in der Healthbar stehen sollte
		String returntext;
		
		returntext=enemy.getName() + " HP: " +Integer.toString(enemy.getHP());
		
		return returntext;
	}
	public Icon getIcon() { //Welches der Bilder angezeigt werden sollte
		if(enemy.getRace()=="ritter"){
			return imageritter;
		}
		else if(enemy.getRace()=="lehrer"){
			return imagelehrer;
		}
		else if(enemy.getRace()=="drache"){
			return imagedrachen;
		}
		else if(enemy.getRace()=="bakterie"){
			return imagebakterie;
		}
		else{
		System.out.println("Error, no Image for enemy race found! gameLogic - getIcon");
		return null;
		}
	}
	
	
	
	public String time() { //Die Zeit welche vergangen ist seit anfang des Programms
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		long time = tDelta/1000;
		String stringtime = String.valueOf(time);
		return stringtime;
	}
	
	
	public int getWeaponDmg() {
		return weaponDmg;
	}

	public void setWeaponDmg(int weaponDmg) {
		this.weaponDmg = weaponDmg;
	}

	public void setWeaponUsing(int weaponUsing) {
		System.out.println("Setting weapon using to " + weaponUsing);
		this.weaponUsing=weaponUsing;
	}


	

	
}
