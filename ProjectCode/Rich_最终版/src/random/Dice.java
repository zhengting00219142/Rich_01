package random;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class Dice {
	public static int getNum(JLabel dice){
		Map<Integer, String> pic=new HashMap<Integer, String>();
		pic.put(1, "picture/Dice1.gif");
		pic.put(2, "picture/Dice2.gif");
		pic.put(3, "picture/Dice3.gif");
		pic.put(4, "picture/Dice4.gif");
		pic.put(5, "picture/Dice5.gif");
		pic.put(6, "picture/Dice6.gif");
		int number=new Random().nextInt(6)+1;
		dice.setIcon(new ImageIcon(pic.get(number)));
		return number;
	}
}
