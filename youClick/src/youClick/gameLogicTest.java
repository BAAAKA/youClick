package youClick;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class gameLogicTest extends TestCase{
	int value1;
	int value2;
	gameLogic gl=new gameLogic(null);
	private Waffenverhalten w_schwert=new w_schwert();
	private Waffenverhalten w_bleistift=new w_bleistift();

	enemies enemy=gl.createenemy();;

	
	// assigning the values


	@Test
	void testCreateenemy() {
		enemy=null;
		enemy=gl.createenemy();
		assertTrue(enemy!=null);
	}
	@Test
	void testSetWeaponUsing() {
		String pathtolehrer="src/youClick/images/lehrer.jpg";
		ImageIcon imagelehrer= new ImageIcon(pathtolehrer);
		gl.setWeaponUsing(w_bleistift); 		
		enemies enemy=new e_lehrer(100, "Böser Lehrer", "lehrer", imagelehrer);	
		enemy.setHP(100);
		gl.getDmgDone(enemy);
		assertTrue(enemy.getHP()==80);
		

	}
	@Test
	public void testGetDmgDone() {
		int enemyStartHp=enemy.getHP();
		String enemyrace=enemy.getRace();
		gl.setWeaponUsing(w_schwert); //Schinken as default weapon
		gl.getDmgDone(enemy);

		if(enemyrace=="ritter"){
			assertTrue(enemy.getHP()==enemyStartHp-5);
		}
		else if(enemyrace=="lehrer"){
			assertTrue(enemy.getHP()==enemyStartHp-10);
		}
		else if(enemyrace=="drache"){
			assertTrue(enemy.getHP()==enemyStartHp-20);
		}		
		else if(enemyrace=="bakterie"){
			assertTrue(enemy.getHP()==enemyStartHp);
		}
	}
	@Test
	public void testBarvalue() {
		enemy.setHP(40);
		enemy.setName("theName");
		String shouldBeText="theName HP: 40";
		assertTrue(gl.barvalue().equals(shouldBeText));	
	}

	@Test
	void testTime() {
		int starttime=gl.time();
		System.out.println("starttime: " + starttime);
	    try {Thread.sleep(1000);} catch (InterruptedException e) {} //sleep for 1000
		int nowtime=gl.time();
		System.out.println("nowtime: " + nowtime);
		assertTrue(starttime<nowtime);
	}




}
