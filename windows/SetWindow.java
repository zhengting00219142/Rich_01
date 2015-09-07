package windows;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import user.SetPlayers;


public class SetWindow {
	private JFrame setWindowFrame;
	private JButton start;
	private JComboBox setPlayerNum;
	private JComboBox setStartMoney;
	public SetWindow(){
		init();
	}
	public void init(){
		setWindowFrame=new JFrame("大富翁设置");
		setWindowFrame.setSize(400, 300);
		setWindowFrame.setLocation(500, 120);
//		setWindowFrame.setLayout(null);
		Icon icon=new ImageIcon("picture/startBg.jpg","hah");
		JLabel bg=new JLabel(icon, JLabel.CENTER);
		//人数
		Integer[] aModel={2,3,4};
		setPlayerNum =new JComboBox(aModel);
		setPlayerNum.setBorder(BorderFactory.createTitledBorder("选择游戏人数"));
		setPlayerNum.setBounds(150, 40, 100, 50);
		//钱数
		Integer[] money={200000,300000,400000};
		setStartMoney =new JComboBox(money);
		setStartMoney.setBorder(BorderFactory.createTitledBorder("选择开始钱数"));
		setStartMoney.setBounds(150, 100, 100, 50);
		//开始
		start=new JButton("开始游戏");
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 开始游戏按钮				
				int playerNumber=(int) setPlayerNum.getSelectedItem();
				int startMoney=(int) setStartMoney.getSelectedItem();
				System.out.println(playerNumber+"\n"+startMoney);
				setWindowFrame.setVisible(false);
				new SetPlayers(playerNumber, startMoney);//初始化玩家
				new PlayGame();
			}
		});
		start.setBounds(160, 160, 90, 50);
		setWindowFrame.add(setPlayerNum);
		setWindowFrame.add(setStartMoney);
		setWindowFrame.add(start);
		setWindowFrame.add(bg);
		setWindowFrame.setVisible(true);
		setWindowFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
