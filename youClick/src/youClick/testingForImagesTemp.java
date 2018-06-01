package youClick;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class testingForImagesTemp extends JFrame{
	String URL="caroon.jpg";
	JLabel a=new JLabel("Hey im a JLABEL");
	ImageIcon imagedrachen = new ImageIcon(URL);

	
	public static void main(String[] args) {
		testingForImagesTemp a=new testingForImagesTemp();
		
	
	}
	public testingForImagesTemp() {
	    setSize(774,720);
		a.setIcon(imagedrachen);
		a.setIcon(new ImageIcon("//faintapzid1/udata$/u212514/Documents/Stuff/Dokumente/java-workspace/youClickTemp/src/youClick/caroon.png"));
		a.setOpaque(true);
		a.setVisible(true);
		add(a);
		setLocation(800, 300);
		setTitle("ClickerClickClick");  
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	}

}
