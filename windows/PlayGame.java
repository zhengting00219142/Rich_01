package windows;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

import random.Dice;
import user.Player;
import user.SetPlayers;
import land.Guidepost;
import land.House;
import listener.DiceListener;

public class PlayGame {
	private List<House> mapHouses=null;//地图上的房子
	private List<Guidepost> host;//房子所属人
	private List<Player> players;//玩家
	private List<JLabel> playerName;//玩家名标签
	private List<JLabel> playerMoney;//玩家当前钱数
	private List<JLabel> playerTicket;//玩家的点劵数
	private JLabel round;//当前回合标志
	private JTextArea reminder;//提示语
	public PlayGame() {
		// TODO 自动生成的构造函数存根
		round=new JLabel();
		players=SetPlayers.getPlayers();
		init();
	}
	public void init(){
		initLists();
		getPlayersInfo();
		
		JFrame gameWindow=new JFrame("大富翁");
		gameWindow.setLayout(null);
		gameWindow.setBounds(300, 40, 1000, 650);
		JLabel dice=new JLabel();//骰子点数
		dice.setBounds(420, 320, 70, 40);
		gameWindow.add(dice);
		JButton doDice=new JButton();
//		doDice.setFont(new Font("宋体", Font.PLAIN, 12));
		doDice.setText("骰子");
		doDice.setBounds(410, 370, 70, 40);
		
		
		gameWindow.add(doDice);
		
		round.setText("当前回合："+players.get(0).getName());
		round.setBounds(390, 285, 200, 30);
		gameWindow.add(round);

		reminder=new JTextArea();
		reminder.setEditable(false);
		reminder.setBounds(350, 190, 200, 90);
		gameWindow.add(reminder);
		for(Guidepost post:host){
			gameWindow.add(post);
		}
		for(House house:mapHouses){
			gameWindow.add(house);
		}
		for(JLabel label:playerName){
			gameWindow.add(label);
		}
		for(JLabel label:playerMoney){
			gameWindow.add(label);
		}
		for(JLabel label:playerTicket){
			gameWindow.add(label);
		}
		start();
		
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			doDice.addActionListener(new DiceListener(dice,this));
		
	}
	
	
	public void initLists(){//初始化房子和路标
		mapHouses=new ArrayList<House>();
		host=new ArrayList<Guidepost>();
		for(int i=0;i<=10;i++){//上
			Guidepost p=new Guidepost();
			p.setBackground(Color.white);
			p.setBounds(85+i*75, 70, 70, 30);
			host.add(p);
			House house=new House(i, 200);//
			house.setBackground(Color.green);
			house.setBounds(85+i*75, 100, 70, 40);
			if(i==1){
				house.setBackground(Color.cyan);
				house.setText("S20");
				house.setTicket(true);
				house.setTicket(20);
			}
			if(i==6){
				house.setBackground(Color.cyan);
				house.setText("S60");
				house.setTicket(true);
				house.setTicket(60);
			}
			if(i==10){
				house.setDaoju(true);
				house.setIcon(new ImageIcon("picture/douju.jpg"));
			}
			mapHouses.add(house);

		}
		for(int i=11;i<19;i++){//右
			Guidepost p=new Guidepost();
			p.setBackground(Color.white);
			p.setBounds(905,145+(i-11)*45, 70, 40);
			host.add(p);
			House house=new House(i, 500);
			house.setBackground(Color.green);
			house.setBounds(835, 145+(i-11)*45, 70, 40);
			if(i==11){
				house.setBackground(Color.cyan);
				house.setText("S60");
				house.setTicket(true);
				house.setTicket(60);
			}
			if(i==18){
				house.setBackground(Color.cyan);
				house.setText("S80");
				house.setTicket(true);
				house.setTicket(80);
			}
			
			mapHouses.add(house);
			
		}
		for(int i=19;i<30;i++){//下
			Guidepost p=new Guidepost();
			p.setBackground(Color.white);
			p.setBounds(835-(i-19)*75, 545, 70, 30);
			host.add(p);
			House house=new House(i, 300);
			house.setBackground(Color.green);
			house.setBounds(835-(i-19)*75, 505, 70, 40);
			if(i==19){
				house.setPrison(true);
				house.setIcon(new ImageIcon("picture/jianyu.jpg"));
			}
			if(i==24){
				house.setBackground(Color.cyan);
				house.setText("S40");
				house.setTicket(true);
				house.setTicket(40);
			}
			if(i==28){
				house.setBackground(Color.cyan);
				house.setText("S20");
				house.setTicket(true);
				house.setTicket(20);
			}
			if(i==29){
				house.setHospital(true);
				house.setIcon(new ImageIcon("picture/yiyuan.jpg"));
			}
			mapHouses.add(house);
		}
		for(int i=30;i<38;i++)//左
		{
			Guidepost p=new Guidepost();
			p.setBackground(Color.white);
			p.setBounds(15, 460-(i-30)*45, 70, 40);
			host.add(p);
			House house=new House(i, 400); 
			house.setBackground(Color.green);
			house.setBounds(85, 460-(i-30)*45, 70, 40);
			if(i==33){
				house.setBackground(Color.cyan);
				house.setText("S40");
				house.setTicket(true);
				house.setTicket(40);
			}
			if(i==37){
				house.setBackground(Color.cyan);
				house.setText("S60");
				house.setTicket(true);
				house.setTicket(60);
			}
			mapHouses.add(house);
		}
	}
	public void getPlayersInfo(){
		playerName=new ArrayList<JLabel>();
		playerMoney=new ArrayList<JLabel>();
		playerTicket=new ArrayList<JLabel>();
		for(int i=0;i<players.size();i++){
			JLabel name=new JLabel(players.get(i).getName()+":");
			name.setBounds(85+i*220, 30, 60, 30);
			playerName.add(name);
			JLabel money=new JLabel("资金"+players.get(i).getMoney());
			money.setBounds(145+i*220, 30, 80, 30);
			playerMoney.add(money);
			JLabel ticket=new JLabel("点劵"+players.get(i).getTicket());
			ticket.setBounds(225+i*220, 30, 100, 30);
			playerTicket.add(ticket);
		}
		
	}
	public void start(){
		mapHouses.get(0).setText("起点");
		for(Player player:players){
			player.setPosition(0);
			host.get(0).setText(host.get(0).getText()+SetPlayers.getNames().get(player.getName()));;
		}
		
		System.out.println(host.get(0).getText());
	}
	public List<House> getMapHouses() {
		return mapHouses;
	}
	public void setMapHouses(List<House> mapHouses) {
		this.mapHouses = mapHouses;
	}
	public List<Guidepost> getHost() {
		return host;
	}
	public void setHost(List<Guidepost> host) {
		this.host = host;
	}
	public List<Player> getPlayers() {
		return players;
	}
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	public List<JLabel> getPlayerName() {
		return playerName;
	}
	public void setPlayerName(List<JLabel> playerName) {
		this.playerName = playerName;
	}
	public List<JLabel> getPlayerMoney() {
		return playerMoney;
	}
	public void setPlayerMoney(List<JLabel> playerMoney) {
		this.playerMoney = playerMoney;
	}
	public JLabel getRound() {
		return round;
	}
	public void setRound(JLabel round) {
		this.round = round;
	}
	public JTextArea getReminder() {
		return reminder;
	}
	public void setReminder(JTextArea reminder) {
		this.reminder = reminder;
	}
	
	
}
