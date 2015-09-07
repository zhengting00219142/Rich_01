package land;

import javax.swing.JButton;


import user.Player;

public class House extends JButton{
	private Player belongTo=null;//所属人
	private int lever=-1;//房子级别
	private int position;//位置
	private int price;//升级价格
	private boolean isTicket=false;//是否是提供点劵地段
	private int ticket;//地段的点劵
	private boolean isDaoju=false;//是否是道具屋
	private boolean isPrison=false;//监狱
	private boolean isHospital=false;//医院
	private boolean isBomb=false;//是否有炸弹
	private boolean isStart=false;//是否是起点
	private boolean isFence=false;//是否有栅栏
	public boolean isHospital() {
		return isHospital;
	}
	public void setHospital(boolean isHospital) {
		this.isHospital = isHospital;
	}
	
	public boolean isBomb() {
		return isBomb;
	}
	public void setBomb(boolean isBomb) {
		this.isBomb = isBomb;
	}
	public boolean isPrison() {
		return isPrison;
	}
	public void setPrison(boolean isPrison) {
		this.isPrison = isPrison;
	}
	public House(int position,int price){
		this.position=position;
		this.price=price;
	}
	public Player getBelongTo() {
		return belongTo;
	}
	public void setBelongTo(Player belongTo) {
		this.belongTo = belongTo;
	}
	public int getLever() {
		return lever;
	}
	public void setLever(int lever) {
		this.lever = lever;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isTicket() {
		return isTicket;
	}
	public void setTicket(boolean isTicket) {
		this.isTicket = isTicket;
	}
	public int getTicket() {
		return ticket;
	}
	public void setTicket(int ticket) {
		this.ticket = ticket;
	}
	public boolean isDaoju() {
		return isDaoju;
	}
	public void setDaoju(boolean isDaoju) {
		this.isDaoju = isDaoju;
	}
	public boolean isStart() {
		return isStart;
	}
	public void setStart(boolean isStart) {
		this.isStart = isStart;
	}
	public boolean isFence() {
		return isFence;
	}
	public void setFence(boolean ifFence) {
		this.isFence = ifFence;
	}
	
	
}
