package user;

import java.util.List;

import daoju.Prop;
import land.House;

public class Player {
	private String name;//玩家姓名
	private int money;//现金
	private int position;//所在路段位置
	private List<House> myHouses;//房子
	private int houseProperty;//房产
	private List<Prop> props;//道具
	private int stayRound;	//进医院、监狱等停留回合数
	private int ticket;//点劵
	public Player(String name,int money){
		this.name=name;
		this.money=money;
		ticket=50;
		position=0;
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
	
}
