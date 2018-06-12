package youClick;

public class w_bleistift implements Waffenverhalten{

	@Override
	public int useweapon(enemies enemy) {
		String enemyrace=enemy.getRace();
		if(enemyrace=="ritter"){
			return 0;
		}
		else if(enemyrace=="lehrer"){
			return 20;
		}
		else if(enemyrace=="drache"){
			return 5;
		}		
		else if(enemyrace=="bakterie"){
			return 10;
		}
		return 0;
	}

}
