package youClick;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class gameLogic {
	
	private Random ran=new Random();
	
	private enemyData eD=new enemyData();
	private Waffenverhalten waffe;
	
	/*weaponUsing
	 * 1 ist Schinken
	 * 2 ist bleistift
	 * 3 ist bombe
	 * 4 ist schwert
	 */
	


	private enemies enemy;
	
	
	// !IMPORTANT VOR DEM NUTZEN DIE PFÄDE ZU DEN BILDERN ANPASSEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// !IMPORTANT VOR DEM NUTZEN DIE PFÄDE ZU DEN BILDERN ANPASSEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// !IMPORTANT VOR DEM NUTZEN DIE PFÄDE ZU DEN BILDERN ANPASSEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	// !IMPORTANT VOR DEM NUTZEN DIE PFÄDE ZU DEN BILDERN ANPASSEN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//Roy
	/*private String pathtolehrer="U:/git/youClick/youClick/src/youClick/images/lehrer.jpg";
	private String pathtodrache="U:/git/youClick/youClick/src/youClick/images/drache.jpg";
	private String pathtobakterie="C:\Users\MK\git\youClick\youClick\src\youClick\images\Bakterium.jpg";
	private String pathtoritter="U:/git/youClick/youClick/src/youClick/images/ritter.gif";
	*/
	

	
	static long tStart = System.currentTimeMillis();	//Time at start of programm

	
	public int getDmgDone(enemies enemy){
		int dmgdone=0;
		dmgdone=waffe.useweapon(enemy);
		enemy.descreaseHP(dmgdone);
		return dmgdone;
	}
	
	public enemies createenemy(){ //Zufällige auswahl eines neuen Gegners
		int randomwahl=ran.nextInt(4)+1;
		enemy = eD.getEnemy(randomwahl);
		return enemy;
	}
	
	public String barvalue() { //Was für ein Text in der Healthbar stehen sollte
		String returntext;
		
		returntext=enemy.getName() + " HP: " +Integer.toString(enemy.getHP());
		
		return returntext;
	}
	public Icon getIcon() { //Welches der Bilder angezeigt werden sollte
		return enemy.getIcon();
	}
	
	
	
	public String time() { //Die Zeit welche vergangen ist seit anfang des Programms
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		long time = tDelta/1000;
		String stringtime = String.valueOf(time);
		return stringtime;
	}
	




	public void setWeaponUsing(Waffenverhalten waffe) {
		System.out.println("SettingWeapon");
		this.waffe = waffe;
	}


	

	
}
