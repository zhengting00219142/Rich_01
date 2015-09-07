package user;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import daoju.Prop;
import land.House;

public class Player {
	private String name;//玩家姓名
	private int money;//现金
	private int position;//所在路段位置
	private List<House> myHouses;//房子
	private int houseProperty;//房产
	private Map<String,Integer> props;//道具
	private int stayRound=0;	//进医院、监狱等停留回合数
	private int ticket;//点劵
	private boolean isToPrison=false;//是否在监狱
	private boolean isToHospotal=false;//是否被炸进医院
	public Player(String name,int money){
		this.name=name;
		this.money=money;
		ticket=50;
		position=0;
		myHouses=new ArrayList<House>();
		props=new HashMap<String, Integer>();
		props.put("炸弹", 0);
		props.put("路障", 0);
		props.put("机器娃娃", 0);
	}
	@Override
	public boolean equals(Object obj) {
		// TODO 自动生成的方法存根
		Player user=(Player)obj;
		return this.getName().equals(user.getName());
	}
	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getHouseProperty() {
		return houseProperty;
	}
	public void setHouseProperty(int houseProperty) {
		this.houseProperty = houseProperty;
	}
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}

	public List<House> getMyHouses() {
		return myHouses;
	}

	public void setMyHouses(List<House> myHouses) {
		this.myHouses = myHouses;
	}

	public Map<String, Integer> getProps() {
		return props;
	}

	public void setProps(Map<String, Integer> props) {
		this.props =  props;
	}

	public int getStayRound() {
		return stayRound;
	}

	public void setStayRound(int stayRound) {
		this.stayRound = stayRound;
	}

	public boolean isToPrison() {
		return isToPrison;
	}

	public void setToPrison(boolean isToPrison) {
		this.isToPrison = isToPrison;
	}

	public boolean isToHospotal() {
		return isToHospotal;
	}
	public void setToHospotal(boolean isToHospotal) {
		this.isToHospotal = isToHospotal;
	}
	
}
