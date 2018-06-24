package youClick;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class gameLogic implements Runnable{
	
	private Random ran=new Random();
	private clickergame cg;
	
	private enemyData eD=new enemyData();
	private Waffenverhalten waffe;
	
	/*weaponUsing
	 * 1 ist Schinken
	 * 2 ist bleistift
	 * 3 ist bombe
	 * 4 ist schwert
	 */

	private enemies enemy;
	static long tStart = System.currentTimeMillis();	//Time at start of programm
	
	public gameLogic(clickergame cg) {
		this.cg=cg;
	}

	
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
	
	
	
	public int time() { //Die Zeit welche vergangen ist seit anfang des Programms
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		long time = tDelta/1000;
//		String stringtime = String.valueOf(time);
		int timepassed = (int) time;
		return timepassed;
	}
	

	public void setWeaponUsing(Waffenverhalten waffe) {
		System.out.println("SettingWeapon");
		this.waffe = waffe;
	}

	@Override
	public void run() {
		while (true) {
		    try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}	
		    cg.setTime(time());
		    cg.setKPM(time());
		}
		
	}


	

	
}
