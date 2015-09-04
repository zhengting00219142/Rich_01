package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import land.House;
import random.Dice;
import user.CurrentPlayer;
import user.Player;
import user.SetPlayers;
import windows.PlayGame;

public class DiceListener implements ActionListener{
	private PlayGame game;
	private JLabel dice;
	private int point;//骰子的点数
	private CurrentPlayer currentPlayer;
	private House toHouse;//到达的房子
	private Player current;//当前玩家
	public DiceListener(JLabel dice,PlayGame game){
		this.dice=dice;
		this.game=game;
		currentPlayer=new CurrentPlayer(game.getPlayers());
		current=currentPlayer.getCurrentPlayer();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		point =Dice.getNum(dice);
		
		
		game.getHost().get(current.getPosition()).setText(new StringBuffer(game.getHost().get(current.getPosition()).getText()).delete(0, 1).toString());
		int location=current.getPosition()+point;
		if(location>37){
			location-=38;
		}
		current.setPosition(location);//设置玩家投掷骰子后的位置
		JOptionPane.showConfirmDialog(null, "是否买房", "提示", JOptionPane.YES_NO_OPTION); 
		game.getHost().get(current.getPosition()).setText(game.getHost().get(current.getPosition()).getText()+SetPlayers.getNames().get(current.getName()));
		current=currentPlayer.getCurrentPlayer();//当前玩家
		game.getRound().setText("当前回合："+current.getName());
	}
	

}
