package land;

import javax.swing.JButton;


import user.Player;

public class House extends JButton{
	private Player belongTo=null;//所属人
	private Lever lever=null;//房子级别
	private int position;//位置
	private int price;//升级价格
	private boolean isTicket=false;//是否是提供点劵地段
	
	public House(int position,int price){
		this.position=position;
		this.price=price;
	}
	
}
