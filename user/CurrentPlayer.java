package user;

import java.util.List;

public class CurrentPlayer
{
	private List<Player> allPlayers;
	private static int which = 0;// 当前第几个玩家

	public CurrentPlayer(List<Player> players)
	{
		allPlayers = players;
	}

	public Player getCurrentPlayer()
	{// 返回当前玩家
		if (which >= allPlayers.size())
			which = 0;
		return allPlayers.get(which++);

	}

	public static int getPlayerLocation()
	{
		return which;
	}
	public void setWhich(int which)
	{
		this.which=which;
	}
}
