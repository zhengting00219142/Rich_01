package user;

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
	public SetPlayers(int number,int startMoney){
		this.number=number;
		this.startMoney=startMoney;
		init();
		setNames();
		System.out.println(players.size());
	}
	public static Map<String, String> getNames(){
		return names;
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
}
