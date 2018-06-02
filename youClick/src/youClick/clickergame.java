package youClick;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

//Pull, Commit, Push

public class clickergame extends JFrame implements ActionListener{

	private JProgressBar Bar;
	private JButton ThisButton = new JButton();
	private int progress = 100;
	private int anzahlschritte=100;
	private int dmg=10;
	private int anzKlicks=0;
	
	//stats
	private int Enemysdefeated=0;
	
	//Defensive tools
	
	//Ham button
	private String pathtoHam="C:/Users/MK/git/youClick/youClick/src/youClick/images/defensive_tools/ham.png";
	private ImageIcon imageHam= new ImageIcon(pathtoHam);
	private JButton w_schinkenButton=new JButton(imageHam);
	
	//Pencil button
	private String pathtoPencil="C:/Users/MK/git/youClick/youClick/src/youClick/images/defensive_tools/pencil.png";
	private ImageIcon imagePencil= new ImageIcon(pathtoPencil);
	private JButton w_bleistiftButton=new JButton(imagePencil);
	
	//Bomb button
	private String pathtoBomb="C:/Users/MK/git/youClick/youClick/src/youClick/images/defensive_tools/bomb.png";
	private ImageIcon imageBomb= new ImageIcon(pathtoBomb);
	private JButton w_bombeButton=new JButton(imageBomb);
	
	//Sword button
	private String pathtoSword="C:/Users/MK/git/youClick/youClick/src/youClick/images/defensive_tools/sword.png";
	private ImageIcon imageSword= new ImageIcon(pathtoSword);
	private JButton w_schwertButton=new JButton(imageSword);
	


	private gameLogic gl=new gameLogic();
	
	
	private JPanel BarFrame=new JPanel();
	private JPanel Fightbutton=new JPanel();
	private JPanel UI=new JPanel();
	private JPanel Stats=new JPanel();
	private JPanel weapons=new JPanel();
	
	private JLabel LabelKPM=new JLabel();
	private JLabel LabelEnemysdefeated=new JLabel();
	private JLabel LabelTime=new JLabel();
	private JLabel LabelForThisButton=new JLabel();

	private enemies enemy;

	
	private  Font barFont = new Font("Verdana", Font.BOLD, 30);
	

	public static void main(String[] args) {

		
	}
	
	public clickergame(){
		enemy=gl.createenemy();
		
		
		setLayout(new BorderLayout());
		
		Bar = new JProgressBar(0, anzahlschritte);
		Bar.setStringPainted(true);
		Bar.setString(gl.barvalue());
		Bar.setValue(enemy.getHP()); //Set Progressbar
		Bar.setFont(barFont);
		


		
		ThisButton.addActionListener(this);
//		ThisButton.setOpaque(true);
		ThisButton.setContentAreaFilled(false); //Button mostly transparent. So you can see the image of the "JLabelforThisButton"
//		ThisButton.setBorderPainted(false);
		
//		BarFrame.setOpaque(true); 
//		Fightbutton.setOpaque(true);
//		UI.setOpaque(true);
//		Stats.setOpaque(true);
//		weapons.setOpaque(true);

		BarFrame.setBackground(Color.BLUE);
		Fightbutton.setBackground(Color.GRAY);
		
		BarFrame.setLayout(new BorderLayout());
		Fightbutton.setLayout(new BorderLayout());
		
		LabelForThisButton.setLayout( new BorderLayout() );
		LabelForThisButton.add(ThisButton, BorderLayout.CENTER);
		LabelForThisButton.setOpaque(true);
		LabelForThisButton.setVisible(true);
		LabelForThisButton.setIcon(gl.getIcon());

		//
		BarFrame.add(Bar, BorderLayout.CENTER);
		Fightbutton.add(LabelForThisButton, BorderLayout.CENTER);
		
		Stats.setLayout(new GridLayout(2, 1));
		Stats.add(LabelEnemysdefeated);
		Stats.add(LabelTime);
		setStats(); //Aktualisierung damit LabelEnemysdefeated den Wert 0 hat
		
		weapons.setLayout(new GridLayout(2,2));
		weapons.add(w_bleistiftButton);
		weapons.add(w_schinkenButton);
		weapons.add(w_schwertButton);
		weapons.add(w_bombeButton);
		w_bleistiftButton.addActionListener(this);
		w_schinkenButton.addActionListener(this);
		w_schwertButton.addActionListener(this);
		w_bombeButton.addActionListener(this);

		
		add(BarFrame, BorderLayout.NORTH);
		add(Fightbutton, BorderLayout.CENTER);
		add(UI, BorderLayout.EAST);
		UI.setLayout(new GridLayout(2,1));
		UI.add(Stats);
		UI.add(weapons);
		
		//^ Aufbau Frame
		
		setLocation(800, 300);
		setTitle("youClick");  
		setSize(940,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
//	public void createenemy(){
//		System.out.println("Creating new enemy");
//		progress = enemy.getHP();
//		Bar.setString(barvalue());
//		System.out.println("Enemy HP " + progress);
//	}
	
//	public String barvalue() {
//		String returntext;
//		
//		returntext="HP: " +Integer.toString(progress);
//		
//		Bar.setValue(progress); //Set Progressbar
//		return returntext;
//	}
	public void setStats() { //Updatedate von allen stats welche auf dem GUI angezeigt werden
		LabelTime.setText("Time passed: " + gl.time() + " Seconds");
		LabelEnemysdefeated.setText("Enemys defeated: " + Integer.toString(Enemysdefeated));
		LabelKPM.setText("KPM: " + (anzKlicks/(Integer.parseInt(gl.time())+ 0.1))*60); // +0.1 Da man nicht durch "0" rechnen darf
	}
	
//	public String time() {
//		long tEnd = System.currentTimeMillis();
//		long tDelta = tEnd - tStart;
//		long time = tDelta/1000;
//		String stringtime = String.valueOf(time);
//		return stringtime;
//	}

	public void attackButton(){ 
		anzKlicks++;
		if(enemy.getHP()>1){ //Falls der Gegner noch HP übrig hat...
			System.out.println(gl.getDmgDone(enemy));
			progress=enemy.getHP();
			
			Bar.setString(gl.barvalue());
			Bar.setValue(enemy.getHP()); //Set Progressbar

			System.out.println("progress "+progress);
			setStats();

			}
			else { //Falls der Gegner kein HP mehr übrig hat
				enemy=gl.createenemy(); //Neuer Gegner erstellen
				Enemysdefeated++;
				Bar.setString(gl.barvalue());
				Bar.setValue(enemy.getHP()); //Set Progressbar
				LabelForThisButton.setIcon(gl.getIcon()); //Hintergrund auf den neuen Gegner anpassen
			}
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ThisButton){
			attackButton();			
		}
		if(e.getSource() == this.w_schinkenButton){ //Wechseln der Waffe auf den Schinken
			gl.setWeaponUsing(1);
		}
		if(e.getSource() == this.w_bleistiftButton){ //Wechseln der Waffe auf den Bleistift
			gl.setWeaponUsing(2);
		}
		if(e.getSource() == this.w_bombeButton){ //Wechseln der Waffe auf die Bombe
			gl.setWeaponUsing(3);
		}
		if(e.getSource() == this.w_schwertButton){ //Wechseln der Waffe auf das Schwert
			gl.setWeaponUsing(4);
		}
	}
}
