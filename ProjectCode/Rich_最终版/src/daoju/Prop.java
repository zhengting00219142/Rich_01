package daoju;

import java.util.List;

import land.House;
import user.Player;

public interface Prop {
	public abstract void affect(Player player,List<House> houses,int position);
	public abstract int getPrice();
	public abstract String getName();
}
