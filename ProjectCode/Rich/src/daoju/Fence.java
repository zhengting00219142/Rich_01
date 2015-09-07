package daoju;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import land.GetHousePicturel;
import land.House;
import user.Player;

public class Fence implements Prop {

	private int price=50;
	private String name="路障";
	@Override
	public void affect(Player player, List<House> houses, int position) {
		// TODO 自动生成的方法存根
		if(player.getProps().get(this.getName())>0){//是否有栅栏
			int distance=player.getPosition()+position;
			if(distance<0){
				distance+=38;
			}
			if(distance>37){
				distance-=38;
			}
			House house=houses.get(distance);//获取目标房子
			if(house.isTicket()||house.isPrison()||house.isHospital()||house.isDaoju()||house.isStart()||house.isBomb()){
				String[] options={"确定"};
				JOptionPane.showOptionDialog(null, "目标地段不能放置栅栏,请重新使用!", "Warning", 
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE,
						null, options, options[0]);
			}
			else{//放置炸弹
				house.setFence(true);
				String image=GetHousePicturel.getFence().get(house.getLever());
				System.out.println(image+"-------"+house.getLever());
				house.setIcon(new ImageIcon(image));//图片
				player.getProps().put(this.getName(), (player.getProps().get(this.getName())-1));			
			}	
		}
	}
	@Override
	public int getPrice() {
		// TODO 自动生成的方法存根
		return price;
	}
	@Override
	public String getName() {
		// TODO 自动生成的方法存根
		return name;
	}

}
