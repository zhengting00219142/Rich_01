package windows;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

import land.GetHousePicturel;
import land.House;
import user.Player;

public class SellHouse
{
	private JFrame use;
	private JButton sure;
	private JButton cancel;
	private JComboBox position;
	private Player player;
	private PlayGame game;
	public SellHouse(Player player,PlayGame game){
		this.player=player;
		this.game=game;
		init();
	}
	public void init(){
		use=new JFrame("出售房产");
		use.setSize(400, 300);
		use.setLocation(500, 120);
		Icon icon=new ImageIcon("picture/startBg.jpg","hah");
		JLabel bg=new JLabel(icon, JLabel.CENTER);
		//人数
		
		List<House> houses=player.getMyHouses();//玩家拥有的房产
		List<Integer> positions=new ArrayList<Integer>();
		for(int i=0;i<houses.size();i++)
		{
			positions.add(houses.get(i).getPosition());
		}
		
		
		
		Object[] positionArrays=(Object[]) positions.toArray();
		position =new JComboBox(positionArrays);
		position.setBorder(BorderFactory.createTitledBorder("选择出售的房产的位置"));
		position.setBounds(150, 100, 100, 50);
		
		sure=new JButton("确定出售");
		sure.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//出售房产
				int location=(int) position.getSelectedItem();
				House house=game.getMapHouses().get(location);
				player.getMyHouses().remove(house);
				int getmoney=(house.getLever()+1)*house.getPrice()*2;
				player.setMoney(player.getMoney()+getmoney);
				game.flushPlayeInfo(player);
				house.setLever(-1);
				house.setBelongTo(null);
				house.setIcon(new ImageIcon(GetHousePicturel.getPicture().get(house.getLever())));
				game.getHost().get(house.getPosition()).setBackground(Color.WHITE);//所属者颜色为白色
				
				
				game.getReminder().append(player.getName()+"出售了一套房产!!！\r\n");
				use.setVisible(false);
			}
		});
		sure.setBounds(110, 160, 90, 50);
		cancel=new JButton("取消");
		cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				use.setVisible(false);
			}
		});
		cancel.setBounds(210, 160, 90, 50);
		use.add(cancel);
		use.add(position);
		use.add(sure);
		use.add(bg);
		use.setVisible(true);
	}
}
