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
import javax.swing.JOptionPane;

import daoju.Prop;
import daoju.PropFactory;
import user.Player;
import user.SetPlayers;


public class DaojuHouse {
	private JFrame shop;
	private JButton sure;
	private JButton cancel;
	private JComboBox setDaoju;
	private Player player;
	private PlayGame game;
	public DaojuHouse(Player player,PlayGame game){
		this.player=player;
		this.game=game;
		init();
	}
	public void init(){
		shop=new JFrame("道具商城");
		shop.setSize(400, 300);
		shop.setLocation(500, 120);
//		setWindowFrame.setLayout(null);
		Icon icon=new ImageIcon("picture/startBg.jpg","hah");
		JLabel bg=new JLabel(icon, JLabel.CENTER);
		//人数
		String[] name={"炸弹","路障","机器娃娃"};
		setDaoju =new JComboBox(name);
		setDaoju.setBorder(BorderFactory.createTitledBorder("选择道具"));
		setDaoju.setBounds(150, 40, 100, 50);
		sure=new JButton("确定购买");
		sure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// 购买道具	
				String daoju=(String) setDaoju.getSelectedItem();
				Prop prop=PropFactory.getProp(daoju);
				System.out.println(prop.getName());
				if(player.getTicket()<prop.getPrice()){//点劵不足
					String[] options={"确定"};
					JOptionPane.showOptionDialog(null, "你的点劵不足!", "Warning", 
							JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
							null, options, options[0]);
				}
				else{//购买
					player.setTicket(player.getTicket()-prop.getPrice());//付款
					game.flushPlayeInfo(player);
					player.getProps().put(prop.getName(), (player.getProps().get(prop.getName())+1));//道具加一	
					game.getReminder().append(player.getName()+"成功购买了"+prop.getName()+"道具!\r\n");
				}
				shop.setVisible(false);
				
			}
		});
		sure.setBounds(110, 160, 90, 50);
		cancel=new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				shop.setVisible(false);
			}
		});
		cancel.setBounds(210, 160, 90, 50);
		shop.add(cancel);
		shop.add(setDaoju);
		shop.add(sure);
		shop.add(bg);
		shop.setVisible(true);
		
	}
}

