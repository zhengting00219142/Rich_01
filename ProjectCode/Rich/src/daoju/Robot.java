package daoju;

import java.util.List;

import javax.swing.ImageIcon;



import land.GetHousePicturel;
import land.House;
import user.Player;

public class Robot implements Prop{
	private int price=30;
	private String name="机器娃娃";
	@Override
	public void affect(Player player, List<House> houses, int position) {
		// TODO 自动生成的方法存根
		if(player.getProps().get(this.getName())>0){//是否有机器娃娃
			position=10;
			for(int i=1;i<=10;i++){
				House clearHouse=houses.get(player.getPosition()+i);
				if(clearHouse.isBomb()){
					clearHouse.setBomb(false);
					clearHouse.setIcon(new ImageIcon(GetHousePicturel.getPicture().get(clearHouse.getLever())));
				}
				if(clearHouse.isFence()){
					clearHouse.setFence(false);
					clearHouse.setIcon(new ImageIcon(GetHousePicturel.getPicture().get(clearHouse.getLever())));
				}			
			}
			player.getProps().put(this.getName(), (player.getProps().get(this)-1));//机器娃娃-1	
			
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
