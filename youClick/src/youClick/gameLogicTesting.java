package youClick;

import javax.swing.ImageIcon;

import org.junit.jupiter.api.Test;

import junit.framework.TestCase;

public class gameLogicTesting extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	int value1;
	int value2;
	gameLogic gl=new gameLogic();
	private Waffenverhalten w_schwert=new w_schwert();
	private Waffenverhalten w_bleistift=new w_bleistift();

	enemies enemy=gl.createenemy();;

	
	// assigning the values


	@Test
	/*
	 * Test ob beim erstellen eines enemies kein Problem auftritt.
	 */
	public void testCreateenemy() {
		enemy=null;
		enemy=gl.createenemy();
		assertTrue(enemy!=null);
	}
	@Test
	/*
	 * Testet ob man die Waffe wechseln kann. Dazu wird die Waffe gewechselt und geschaut ob man dann den korrekten Schaden am Gegner zufügt.
	 */
	public void testSetWeaponUsing() {
		String pathtolehrer="src/youClick/images/lehrer.jpg";
		ImageIcon imagelehrer= new ImageIcon(pathtolehrer);
		gl.setWeaponUsing(w_bleistift); 		
		enemies enemy=new e_lehrer(100, "Böser Lehrer", "lehrer", imagelehrer);	
		enemy.setHP(100);
		gl.getDmgDone(enemy);
		assertTrue(enemy.getHP()==80);
		

	}
	@Test
	/*
	 * Testet ob man mit dem Schwert den korrekten Schaden am Gegner zufügt.
	 */
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
	/*
	 * Testet ob der Text4 in der Bar auf korrekte Art zusammengebaut wird.
	 */
	public void testBarvalue() {
		enemy.setHP(40);
		enemy.setName("theName");
		String shouldBeText="theName HP: 40";
		assertTrue(gl.barvalue().equals(shouldBeText));	
	}

	@Test
	/*
	 * Testet ob Zeit beim Timer vergeht.
	 */
	public void testTime() {
		int starttime=gl.time();
		System.out.println("starttime: " + starttime);
	    try {Thread.sleep(1000);} catch (InterruptedException e) {} //sleep for 1000
		int nowtime=gl.time();
		System.out.println("nowtime: " + nowtime);
		assertTrue(starttime<nowtime);
	}


}
