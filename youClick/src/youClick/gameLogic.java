package youClick;

import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class gameLogic implements Runnable{
	
	private Random ran=new Random();
	private clickergame cg;
	
	private enemyData eD=new enemyData();
	private Waffenverhalten waffe;
	
	private enemies enemy;
	static long tStart = System.currentTimeMillis();	//Time at start of programm
	
	public gameLogic(clickergame cg) {
		this.cg=cg;
	}

	//Fügt Schaden am Gegner an, welcher per Parameter mitgegeben wird
	public void getDmgDone(enemies enemy){ //Welcher Enemy angegriffen wird
		int dmgdone=0;
		dmgdone=waffe.useweapon(enemy); //Nutzt momentan ausgerüstete waffe und fügt damit Schaden am Gegner an
		enemy.descreaseHP(dmgdone); //Wie viel abgezogen wird
		System.out.println("Dmg done at enemy: " + dmgdone);	
	}
	//Zufällige Auswahl eines neuen Gegners
	public enemies createenemy(){ 
		int randomwahl=ran.nextInt(4)+1; //Random Zahl von 1-4
		enemy = eD.getEnemy(randomwahl); //Je nach Zahl wird einer von 4 verschiedenen Gegnern zurückgegeben
		return enemy;
	}
	
	//Was für ein Text in der Healthbar stehen sollte
	public String barvalue() { 
		String returntext=enemy.getName() + " HP: " +Integer.toString(enemy.getHP());
		return returntext;
	}
	//Welches der Bilder als Gegner angezeigt werden sollte
	public Icon getIcon() { 
		return enemy.getIcon();
	}
	
	
	//Gibt zurück wie viel Zeit seit dem Start vergangen ist
	public int time() { 
		long tEnd = System.currentTimeMillis(); //Momentane Zeit
		long tDelta = tEnd - tStart; //Wie viel Zeit vergangen ist
		long time = tDelta/1000;
		int timepassed = (int) time; //Von long zu int ¯\_(ツ)_/¯
		return timepassed;
	}
	
	//Setzt Waffe, welche als Parameter mitgegeben wurde
	public void setWeaponUsing(Waffenverhalten waffe) { 
		System.out.println("SettingWeapon");
		this.waffe = waffe;
	}
	
	//Der zweite Thread, welche eine unendliche Schlaufe ist, welche jede 0.1 Sekunde die vergangene Zeit, sowie die KPM auf dem GUI anpasst.
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
