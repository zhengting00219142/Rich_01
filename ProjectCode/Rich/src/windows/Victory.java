package windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import user.Player;

public class Victory {

	private JFrame use;
	private JTextField tip;
	private JButton sure;
	private JButton cancel;
	private Player player;
	private PlayGame playGame;
	private PlayGame game;
	public Victory(Player player,PlayGame playGame){
		this.player=player;
		this.playGame=playGame;
		init();
	}
	public void init(){
		use=new JFrame("使用道具");
		use.setSize(400, 300);
		use.setLocation(500, 120);
		Icon icon=new ImageIcon("picture/startBg.jpg","hah");
		JLabel bg=new JLabel(icon, JLabel.CENTER);
		
		tip=new JTextField("恭喜玩家"+player.getName()+"获得了本局的胜利");
		tip.setBackground(Color.yellow);
		tip.setEditable(false);
		tip.setBounds(100, 100, 210, 30);
		sure=new JButton("退出游戏");
		sure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(-1);
				use.setVisible(false);
			}
		});
		sure.setBounds(110, 160, 90, 50);
		cancel=new JButton("再来一局");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 System.gc();
				 playGame.getGameWindow().setVisible(false);
				new SetWindow();
				
				use.setVisible(false);
			}
		});
		cancel.setBounds(210, 160, 90, 50);
		use.add(cancel);
		use.add(sure);
		use.add(tip);
		use.add(bg);
		use.setVisible(true);
	}
	
}
