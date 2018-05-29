package youClick;

public class test {

	public static void main(String[] args) {
		
		enemies enemy=new e_ritter(100, "Ritter", "ritter", -100, 100, 0, 50);

		clickergame PBD=new clickergame();
		PBD.createEnemy(enemy);
		

	}

}
