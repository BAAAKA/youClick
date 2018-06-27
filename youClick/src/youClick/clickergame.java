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
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class clickergame extends JFrame implements ActionListener, Observer{

	private JProgressBar Bar;
	private JButton ThisButton = new JButton();
	private int anzahlschritte=100;
	private int anzKlicks=0;
	
	//stats
	private int Enemysdefeated=0;
	
	//Defensive tools
	private Waffenverhalten w_schinken=new w_schinken();
	private Waffenverhalten w_bombe=new w_bombe();
	private Waffenverhalten w_bleistift=new w_bleistift();
	private Waffenverhalten w_schwert=new w_schwert();
	
	//Ham button picture
	private String pathtoHam="src/youClick/images/defensive_tools/ham.png";
	private ImageIcon imageHam= new ImageIcon(pathtoHam);
	private JButton w_schinkenButton=new JButton(imageHam);
	
	//Pencil button picture
	private String pathtoPencil="src/youClick/images/defensive_tools/pencil.png";
	private ImageIcon imagePencil= new ImageIcon(pathtoPencil);
	private JButton w_bleistiftButton=new JButton(imagePencil);
	
	//Bomb button picture
	private String pathtoBomb="src/youClick/images/defensive_tools/bomb.png";
	private ImageIcon imageBomb= new ImageIcon(pathtoBomb);
	private JButton w_bombeButton=new JButton(imageBomb);
	
	//Sword button picture
	private String pathtoSword="src/youClick/images/defensive_tools/sword.png";
	private ImageIcon imageSword= new ImageIcon(pathtoSword);
	private JButton w_schwertButton=new JButton(imageSword);
	
	//
	private String pathtotitlebaricon="src/youClick/images/mouse_titlebar.png";
	private ImageIcon imagetitlebar= new ImageIcon(pathtotitlebaricon);
	
	private gameLogic gl=new gameLogic();
	
	private JPanel BarFrame=new JPanel();
	private JPanel Fightbutton=new JPanel();
	private JPanel UI=new JPanel();
	private JPanel Stats=new JPanel();
	private JPanel weapons=new JPanel();
	
	
	private Font statFont = new Font("Verdana", Font.PLAIN, 20);
	private JLabel LabelKPM=new JLabel();
	
	private JLabel LabelEnemysdefeated=new JLabel();
	private JLabel LabelTime=new JLabel();
	private JLabel LabelForThisButton=new JLabel();

	private enemies enemy;

	
	private  Font barFont = new Font("Verdana", Font.BOLD, 30);
	private Color notselectedC=new Color(199, 212, 225);
	private Color selectedC=new Color(154, 171, 189);
	private Color statistic=new Color(147, 173, 198);


	public static void main(String[] args) {

		
	}
	
	public clickergame(){
		enemy=gl.createenemy();
		
		gl.addObserver(this);
		Thread t = new Thread(gl); //Neuer Thread, welche man später für den Timer benötigt
		t.start();	//Der Thread wird bereit gemacht	

		setLayout(new BorderLayout());
		
		Bar = new JProgressBar(0, anzahlschritte);
		Bar.setStringPainted(true);
		Bar.setString(gl.barvalue());
		Bar.setValue(enemy.getHP()); //Set Progressbar
		Bar.setFont(barFont);
		
		
		ThisButton.addActionListener(this);

		ThisButton.setContentAreaFilled(false); //Button mostly transparent. So you can see the image of the "LabelForThisButton"

		// Hintergrundfarben der GUI-Elemente setzen
		BarFrame.setBackground(Color.BLUE);
		Fightbutton.setBackground(Color.BLACK);
		Stats.setBackground(statistic);
		
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
		
		Stats.setLayout(new GridLayout(3, 1));
		Stats.add(LabelEnemysdefeated);
		Stats.add(LabelTime);
		Stats.add(LabelKPM);
		LabelEnemysdefeated.setText("   Enemys defeated: " + Integer.toString(Enemysdefeated)); 	//Update von Enemysdefeated stat welche auf dem GUI angezeigt wird
		
		weapons.setLayout(new GridLayout(2,2));
		weapons.add(w_bleistiftButton);
		weapons.add(w_schinkenButton);
		weapons.add(w_schwertButton);
		weapons.add(w_bombeButton);
		w_bleistiftButton.addActionListener(this);
		w_schinkenButton.addActionListener(this);
		w_schwertButton.addActionListener(this);
		w_bombeButton.addActionListener(this);

		w_bleistiftButton.setBackground(notselectedC); //Setting Background Color if Buttons used / not used
		w_schinkenButton.setBackground(notselectedC);
		w_schwertButton.setBackground(notselectedC);
		w_bombeButton.setBackground(notselectedC);
		
		add(BarFrame, BorderLayout.NORTH);
		add(Fightbutton, BorderLayout.CENTER);
		add(UI, BorderLayout.EAST);
		UI.setLayout(new GridLayout(2,1));
		UI.add(Stats);
		UI.add(weapons);
		
		//^ Aufbau Frame
		LabelTime.setFont(statFont);
		LabelEnemysdefeated.setFont(statFont);
		LabelKPM.setFont(statFont);
		
		setIconImage(imagetitlebar.getImage()); //Setzten des Icons des Fensters

		setLocation(400, 100);
		setTitle("youClick");  
		setSize(940,785);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
	}
	

	//Setzt die Zeit Anzeige auf dem Gui, wird von GameLogic aufgerufen
	public void setTime(int time) {
		LabelTime.setText("   Time passed: " + time + " Seconds");
		setKPM(time);
	}
	//Setzt die KPM Anzeige auf dem Gui, wird von GameLogic aufgerufen (errechnet die KPM anhande der Zeit)
	public void setKPM(int time) {
		LabelKPM.setText("   KPM: " + Math.round(((anzKlicks/(time+ 0.1))*60) * 100.0) / 100.0); // +0.1 Da man nicht durch "0" rechnen darf
	}
	
	//Wird ausgeführt wenn auf den Enemy geklickt wird
	public void attackButton(){ 
		anzKlicks++; //Zähler für wie oft man auf den Enemy geklickt hat geht um 1 hoch
		if(enemy.getHP()>0){ //Falls der Gegner noch HP Üerig hat...
			gl.getDmgDone(enemy); //Macht den Schaden
			Bar.setString(gl.barvalue()); //Setzt den Text in der HP Bar
			Bar.setValue(enemy.getHP()); //Setzt den Blauen Bereich in der HP Bar
			LabelEnemysdefeated.setText("   Enemys defeated: " + Integer.toString(Enemysdefeated)); 	//Update von Enemysdefeated stat welche auf dem GUI angezeigt wird
			}
			else { //Falls der Gegner kein HP mehr uebrig hat
				enemy=gl.createenemy(); //Neuer Gegner erstellen
				Enemysdefeated++; // Erhöht die (Statistik) Variable um 1 
				Bar.setString(gl.barvalue()); //Text
				Bar.setValue(enemy.getHP()); //Set Progressbar (blau)
				LabelForThisButton.setIcon(gl.getIcon()); //Setzt das Gegner Bild
			}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ThisButton){
			attackButton();	// Wenn auf den Gegner geklickt wird so wird die Methode attackButton aufgerufen.		
		}
		if(e.getSource() == this.w_schinkenButton){ //Wechseln der Waffe auf den Schinken
			gl.setWeaponUsing(w_schinken); // Setzt die Waffe in der GameLogic
			w_bleistiftButton.setBackground(notselectedC);
			w_schinkenButton.setBackground(selectedC);
			w_schwertButton.setBackground(notselectedC);
			w_bombeButton.setBackground(notselectedC);

		}
		if(e.getSource() == this.w_bleistiftButton){ //Wechseln der Waffe auf den Bleistift
			gl.setWeaponUsing(w_bleistift);
			w_bleistiftButton.setBackground(selectedC);   
			w_schinkenButton.setBackground(notselectedC);
			w_schwertButton.setBackground(notselectedC);
			w_bombeButton.setBackground(notselectedC);
		}
		if(e.getSource() == this.w_bombeButton){ //Wechseln der Waffe auf die Bombe
			gl.setWeaponUsing(w_bombe);
			w_bleistiftButton.setBackground(notselectedC);    
			w_schinkenButton.setBackground(notselectedC);
			w_schwertButton.setBackground(notselectedC);
			w_bombeButton.setBackground(selectedC);
		}
		if(e.getSource() == this.w_schwertButton){ //Wechseln der Waffe auf das Schwert
			gl.setWeaponUsing(w_schwert);
			w_bleistiftButton.setBackground(notselectedC);    
			w_schinkenButton.setBackground(notselectedC);
			w_schwertButton.setBackground(selectedC);
			w_bombeButton.setBackground(notselectedC);
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {		
	    setTime((int) arg1);
	}
}
