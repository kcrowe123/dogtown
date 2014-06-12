package com.dogtown.service.player;

import java.util.List;

import com.dogtown.domain.player.Player;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.integration.player.PlayerDAO;

public class PlayerServiceImpl implements PlayerService
{
    private PlayerDAO playerDAO;
    
	public List<Player> retrievePlayers() throws DogtownSystemException 
	{
		return getPlayerDAO().retrieveAllPlayers();
	}

	public void createPlayer(Player player)throws DogtownSystemException  
	{
		getPlayerDAO().createPlayer(player);
	}
	
	public Player retrievePlayerById(Player player) throws DogtownSystemException 
	{	
		return getPlayerDAO().retrievePlayerById(player);
	}

	public void updatePlayer(Player updatedPlayer) throws DogtownSystemException 
	{
		Player player = getPlayerDAO().retrievePlayerById(updatedPlayer);
		
		player.setFirstName(updatedPlayer.getFirstName());
		player.setLastName(updatedPlayer.getLastName());
		player.setSuffix(updatedPlayer.getSuffix());
		player.setPhoneNumber(updatedPlayer.getPhoneNumber());
		player.setEmailAddress(updatedPlayer.getEmailAddress());
		player.setDateOfBirth(updatedPlayer.getDateOfBirth());
		
		player.getAddress().setStreet(updatedPlayer.getAddress().getStreet());
		player.getAddress().setCity(updatedPlayer.getAddress().getCity());
		player.getAddress().setState(updatedPlayer.getAddress().getState());
		player.getAddress().setZipCode(updatedPlayer.getAddress().getZipCode());
	}

	public void deletePlayers(List<Player> players) throws DogtownSystemException
	{		
		playerDAO.deletePlayers(players);
		
	}
	
	public void setPlayerDAO(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}

	private PlayerDAO getPlayerDAO()
	{
		return playerDAO;
	}

}
