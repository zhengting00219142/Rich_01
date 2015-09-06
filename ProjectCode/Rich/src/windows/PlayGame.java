package windows;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

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
	private JLabel round;//当前回合标志
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
		dice.setEnabled(false);
		dice.setBounds(420, 280, 70, 40);
		gameWindow.add(dice);
		JButton doDice=new JButton();
//		doDice.setFont(new Font("宋体", Font.PLAIN, 12));
		doDice.setText("骰子");
		doDice.setBounds(410, 330, 70, 40);
		doDice.addActionListener(new DiceListener(dice,this));
		gameWindow.add(doDice);
		
		round.setText("当前回合："+players.get(0).getName());
		round.setBounds(390, 200, 200, 40);
		gameWindow.add(round);
		
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
		System.out.println(host.size()==mapHouses.size());
//		for(int i=0;i<host.size();i++){
//			
//			host.get(i).setText(i+"");
//			mapHouses.get(i).setText(i+"");
//		}
		
		start();
		
		gameWindow.setVisible(true);
		gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void initLists(){//初始化房子和路标
		mapHouses=new ArrayList<House>();
		host=new ArrayList<Guidepost>();
		for(int i=0;i<=10;i++){//上
			Guidepost p=new Guidepost();
			p.setEnabled(false);
			p.setBackground(Color.yellow);
			p.setBounds(85+i*75, 70, 70, 30);
			host.add(p);
			House house=new House(i, 100);
			house.setEnabled(false);
			house.setBackground(Color.green);
			house.setBounds(85+i*75, 100, 70, 40);
			mapHouses.add(house);		
		}
		for(int i=11;i<19;i++){//右
			Guidepost p=new Guidepost();
			p.setEnabled(false);
			p.setBackground(Color.yellow);
			p.setBounds(905,145+(i-11)*45, 70, 40);
			host.add(p);
			House house=new House(i, 200);
			house.setEnabled(false);
			house.setBackground(Color.green);
			house.setBounds(835, 145+(i-11)*45, 70, 40);
			mapHouses.add(house);
			
		}
		for(int i=19;i<30;i++){//下
			Guidepost p=new Guidepost();
			p.setEnabled(false);
			p.setBackground(Color.yellow);
			p.setBounds(835-(i-19)*75, 545, 70, 30);
			host.add(p);
			House house=new House(i, 300);
			house.setEnabled(false);
			house.setBackground(Color.green);
			house.setBounds(835-(i-19)*75, 505, 70, 40);
			mapHouses.add(house);
		}
		for(int i=30;i<38;i++)//左
		{
			Guidepost p=new Guidepost();
			p.setEnabled(false);
			p.setBackground(Color.yellow);
			p.setBounds(15, 460-(i-30)*45, 70, 40);
			host.add(p);
			House house=new House(i, 300); 
			house.setEnabled(false);
			house.setBackground(Color.green);
			house.setBounds(85, 460-(i-30)*45, 70, 40);
			mapHouses.add(house);
		}
//		h1.setEnabled(false);
//		h1.setBackground(Color.green);
////		h1.setIcon(new ImageIcon("e:\\startBg.jpg","haha"));//背景
//		h1.setBounds(80, 100, 40, 30);
//		House h2=new House(2, 100);
//		h2.setEnabled(false);
//		h2.setBackground(Color.green);
//		h2.setBounds(150, 150, 40, 30);
//		mapHouses.add(h1);
//		mapHouses.add(h2);
	}
	public void getPlayersInfo(){
		playerName=new ArrayList<JLabel>();
		playerMoney=new ArrayList<JLabel>();
		for(int i=0;i<players.size();i++){
			JLabel name=new JLabel(players.get(i).getName()+":");
			name.setBounds(85+i*180, 30, 60, 30);
			playerName.add(name);
			JLabel money=new JLabel(players.get(i).getMoney()+"");
			money.setBounds(145+i*180, 30, 60, 30);
			playerMoney.add(money);
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
	
	
}
