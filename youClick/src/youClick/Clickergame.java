package youClick;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

// Hallo Roy
// Hallo Roy Aregger
// Test

public class Clickergame extends JFrame implements ActionListener{

	private JProgressBar Bar;
	private JButton ThisButton = new JButton("Fight Me");
	private int progress = 100;
	private int anzahlschritte=100;
	private int dmg=10;
	
	//stats
	private int Enemysdefeated=0;
	static long tStart = System.currentTimeMillis();	//Time at start of programm

	gameLogic gl=new gameLogic();


	JPanel BarFrame=new JPanel();
	JPanel Fightbutton=new JPanel();
	JPanel UI=new JPanel();
	JPanel Stats=new JPanel();
	JPanel weapons=new JPanel();
	
	JLabel LabelEnemysdefeated=new JLabel();
	JLabel LabelTime=new JLabel();
	
	enemies enemy;

	
	Font barFont = new Font("Verdana", Font.BOLD, 30);
	
	public static void main(String[] args) {
		

		
	}
	
	public Clickergame(){
		setLayout(new BorderLayout());
		
		Bar = new JProgressBar(0, anzahlschritte);
		Bar.setValue(0);
		Bar.setStringPainted(true);
		Bar.setString(barvalue());
		Bar.setFont(barFont);
		


		
		ThisButton.addActionListener(this);
//		ThisButton.setOpaque(false);
//		ThisButton.setContentAreaFilled(false);
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
	

		
		//
		BarFrame.add(Bar, BorderLayout.CENTER);
		Fightbutton.add(ThisButton, BorderLayout.CENTER);
		
		Stats.setLayout(new GridLayout(2, 1));
		Stats.add(LabelEnemysdefeated);
		Stats.add(LabelTime);
		setStats(); //Aktualisierung damit LabelEnemysdefeated den Wert 0 hat
		
		add(BarFrame, BorderLayout.NORTH);
		add(Fightbutton, BorderLayout.CENTER);
		add(UI, BorderLayout.EAST);
		UI.setLayout(new GridLayout(1,2));
		UI.add(Stats);
		UI.add(weapons);
		
		//^ Aufbau Frame
		
		
		
		setLocation(800, 300);
		setTitle("ClickerClickClick");  
		setSize(800,800);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createenemy(){
		System.out.println("Creating new enemy");
		progress = 100;
		Bar.setString(barvalue());
		System.out.println("Enemy HP " + progress);
	}
	
	public String barvalue() {
		String returntext;
		
		returntext="HP: " +Integer.toString(progress);
		
		Bar.setValue(progress); //Set Progressbar
		return returntext;
	}
	public void setStats() {
		LabelTime.setText("Time passed: " + time() + " Seconds");
		LabelEnemysdefeated.setText("Enemys defeated: " + Integer.toString(Enemysdefeated));
	}
	
	public String time() {
		long tEnd = System.currentTimeMillis();
		long tDelta = tEnd - tStart;
		long time = tDelta/1000;
		
		System.out.println("Timer: " + time);
		String stringtime = String.valueOf(time);
		return stringtime;
	}
	public void createEnemy(enemies enemy){
		this.enemy=enemy;
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.ThisButton){
			if(progress>1){
			progress-=gl.getDmgDone(enemy);
			Bar.setString(barvalue());
			System.out.println(progress);
			setStats();

			}
			else {
				createenemy();
				Enemysdefeated++;
			}
			
		}

	}
}