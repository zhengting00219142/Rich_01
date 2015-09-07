package user;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JLabel;

public class SetPlayers {
	private int number;//人数
	private int startMoney;//钱数
	private static List<Player> players;
	private static Map<String, String> names;
	private static Map<String, Color> color;
	public SetPlayers(int number,int startMoney){
		this.number=number;
		this.startMoney=startMoney;
		init();
		setNames();
		setColor();
		System.out.println(players.size());
	}
	
	public static List<Player> getPlayers(){//取得所有玩家的集合
		return players;
	}
	public void init(){//初始化游戏玩家
		players=new ArrayList<Player>();
		switch (number) {
		case 2:
			players.add(new Player("钱夫人(Q)", startMoney));
			players.add(new Player("阿土伯(A)", startMoney));
			
			break;
		case 3:
			players.add(new Player("钱夫人(Q)", startMoney));
			players.add(new Player("阿土伯(A)", startMoney));
			players.add(new Player("孙小美(S)", startMoney));
			break;
		case 4:
			players.add(new Player("钱夫人(Q)", startMoney));
			players.add(new Player("阿土伯(A)", startMoney));
			players.add(new Player("孙小美(S)", startMoney));
			players.add(new Player("金贝贝(J)", startMoney));
			break;
		default:
			throw new RuntimeException("游戏人数出错!");
		}
	}
	public void setNames(){
		names=new HashMap<String,String>();
		names.put("钱夫人(Q)", "Q");
		names.put("阿土伯(A)", "A");
		names.put("孙小美(S)", "S");
		names.put("金贝贝(J)","J");
	}
	public static Map<String, String> getNames(){
		return names;
	}
	public void setColor(){
		color=new HashMap<String,Color>();
		color.put("钱夫人(Q)", Color.red);
		color.put("阿土伯(A)", Color.gray);
		color.put("孙小美(S)", Color.pink);
		color.put("金贝贝(J)",Color.yellow);
	}
	public static Map<String, Color> getColor(){
		return color;
	}
}





