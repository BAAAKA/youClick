package youClick;

public class gameLogic {
	
	int weaponDmg=10;
	int weaponUsing=4;
	/*weaponUsing
	 * 1 ist Schinken
	 * 2 ist bleistift
	 * 3 ist bombe
	 * 4 ist schwert
	 */
	
	weapons schinken=new w_schinken();
	weapons bleistift=new w_bleistift();
	weapons bombe=new w_bombe();
	weapons schwert=new w_schwert();

	
	public int getDmgDone(enemies enemy){
		int dmgdone=0;
		if(weaponUsing==1){
			int resistance=enemy.getResistanceToSchinken();
			dmgdone= schinken.getDmg()-resistance*weaponDmg/100;
		}
		else if(weaponUsing==2){
			int resistance=enemy.getResistanceToBleistift();
			dmgdone= bleistift.getDmg()-resistance*weaponDmg/100;
		}
		else if(weaponUsing==3){
			int resistance=enemy.getResistanceToBombe();
			dmgdone= bombe.getDmg()-resistance*weaponDmg/100;
		}
		else if(weaponUsing==4){
			int resistance=enemy.getResistanceToSchwert();
			dmgdone= schwert.getDmg()-resistance*weaponDmg/100;
		}
		
		return dmgdone;
	}
	
	
	
	
	
	
	
	
	
	
	public int getWeaponDmg() {
		return weaponDmg;
	}

	public void setWeaponDmg(int weaponDmg) {
		this.weaponDmg = weaponDmg;
	}

	public void setWeaponUsing(int weaponUsing) {
		if(weaponUsing==1){
			weaponDmg=10;
		}
	}

	
}
