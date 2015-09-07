package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import user.CurrentPlayer;
import user.Player;
import windows.PlayGame;
import windows.UseDaoju;

public class UsePropListener implements ActionListener {
	private PlayGame game;
	private Player player;
	public UsePropListener(PlayGame game){
		this.game=game;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		player=game.getPlayers().get(CurrentPlayer.getPlayerLocation()-1);
		
		new UseDaoju(player, game.getMapHouses(), game);
	}

}
