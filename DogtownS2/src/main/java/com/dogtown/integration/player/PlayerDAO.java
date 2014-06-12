package com.dogtown.integration.player;

import java.util.List;

import com.dogtown.domain.player.Player;
import com.dogtown.domain.tournament.Tournament;
import com.dogtown.framework.exception.DogtownSystemException;

public interface PlayerDAO
{
	public List<Player> retrieveAllPlayers() throws DogtownSystemException;
	
	public void createPlayer(Player player) throws DogtownSystemException;
	
	public Player retrievePlayerById(Player player)throws DogtownSystemException;

	public void deletePlayers(List<Player> players) throws DogtownSystemException;
	
	public List retrieveEligiblePlayers(Tournament tournament) throws DogtownSystemException;
}
