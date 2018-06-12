package youClick;

public class w_schwert implements Waffenverhalten{

	@Override
	public int useweapon(enemies enemy) {
		String enemyrace=enemy.getRace();
		if(enemyrace=="ritter"){
			return 5;
		}
		else if(enemyrace=="lehrer"){
			return 10;
		}
		else if(enemyrace=="drache"){
			return 20;
		}		
		else if(enemyrace=="bakterie"){
			return 0;
		}
		return 0;
	}

}
