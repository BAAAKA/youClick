package youClick;

public class w_schinken implements Waffenverhalten{
		
	@Override
	public int useweapon(enemies enemy) {
		String enemyrace=enemy.getRace();
		if(enemyrace=="ritter"){
			return 20;
		}
		else if(enemyrace=="lehrer"){
			return 0;
		}
		else if(enemyrace=="drache"){
			return 10;
		}		
		else if(enemyrace=="bakterie"){
			return 5;
		}
		return 0;
	}

}

