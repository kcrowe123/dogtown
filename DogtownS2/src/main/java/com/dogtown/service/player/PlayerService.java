package com.dogtown.service.player;

import java.util.List;

import com.dogtown.domain.player.Player;
import com.dogtown.framework.exception.DogtownSystemException;

public interface PlayerService 
{
	public List<Player> retrievePlayers() throws DogtownSystemException;
	
	public void updatePlayer(Player player) throws DogtownSystemException ;
	
	public Player retrievePlayerById(Player player) throws DogtownSystemException ;
	
	public void createPlayer(Player player) throws DogtownSystemException ;

	public void deletePlayers(List<Player> players) throws DogtownSystemException;
}
