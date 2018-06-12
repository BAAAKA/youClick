package youClick;

public class w_bombe implements Waffenverhalten{

	@Override
	public int useweapon(enemies enemy) {
		String enemyrace=enemy.getRace();
		if(enemyrace=="ritter"){
			return 10;
		}
		else if(enemyrace=="lehrer"){
			return 5;
		}
		else if(enemyrace=="drache"){
			return 0;
		}		
		else if(enemyrace=="bakterie"){
			return 20;
		}
		return 0;
	}

}
