package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import user.CurrentPlayer;
import user.Player;
import windows.PlayGame;
import windows.SellHouse;

public class SellHouseListener implements ActionListener
{
	private PlayGame game;
	private Player player;
	public SellHouseListener(PlayGame game){
		this.game=game;
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		
		player=game.getPlayers().get(CurrentPlayer.getPlayerLocation()-1);
		new SellHouse(player, game);
		
	}

}
