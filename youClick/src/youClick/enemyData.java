package youClick;

import javax.swing.ImageIcon;

public class enemyData {

	private String pathtolehrer="src/youClick/images/lehrer.jpg";
	private String pathtodrache="src/youClick/images/drache.jpg";
	private String pathtobakterie="src/youClick/images/Bakterium.jpg";
	private String pathtoritter="src/youClick/images/ritter.jpg";
	
	private ImageIcon imagedrachen = new ImageIcon(pathtodrache);
	private ImageIcon imagelehrer= new ImageIcon(pathtolehrer);
	private ImageIcon imagebakterie = new ImageIcon(pathtobakterie);
	private ImageIcon imageritter = new ImageIcon(pathtoritter);

	
public enemies getEnemy(int randomwahl){ //Zufällige auswahl eines neuen Gegners
		enemies enemy=null;
		System.out.println("Creating new enemy");
		switch (randomwahl) {
			case 1: enemy=new e_ritter(100, "Sir Lanzenlord", "ritter", -100, 100, 50, 0, imageritter);  break;		
			case 2: enemy=new e_lehrer(100, "Böser Lehrer", "lehrer", 100, -100, 0, 50, imagelehrer);  break;		
			case 3: enemy=new e_drache(100, "The Fable of the Dragon Tyrant", "drache", 0, 50, -100, 100, imagedrachen);  break;		
			case 4: enemy=new e_bakterie(100, "Michael Mike Glotzkovski", "bakterie", 50, 0, 100, -100, imagebakterie);  break;		

		}
		System.out.println("Enemy HP "+enemy.getHP());
		System.out.println("Enemy Name " + enemy.getName());
		return enemy;
	}
}
