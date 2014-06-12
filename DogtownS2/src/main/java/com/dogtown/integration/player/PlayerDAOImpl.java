package com.dogtown.integration.player;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.dogtown.domain.player.Player;
import com.dogtown.domain.tournament.Tournament;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.integration.DogtownDAO;

public class PlayerDAOImpl extends DogtownDAO implements PlayerDAO
{
	static Logger log = Logger.getLogger(PlayerDAOImpl.class);
	
	public static final String RETRIEVE_ALL_PLAYERS = "retrieveAllPlayers";
	public static final String RETRIEVE_PLAYER_BY_ID = "retrievePlayerById";
	public static final String RETRIEVE_ELIGIBLE_PLAYERS = "retrieveEligiblePlayers";
	
	@SuppressWarnings("unchecked")
	public List<Player> retrieveAllPlayers() throws DogtownSystemException
	{
		List retVal = new ArrayList();
		
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_ALL_PLAYERS);;
			
			List result = (List<Player>)query.list();
			
			if(result != null)
			{
				retVal.addAll(result);
			}
		} 
		catch (Exception e)
		{
			String message = "Error Retrieveing all Players";
			log.debug(message);
			throw new DogtownSystemException(message, e);
		}
		
		return retVal;
	}

	public void createPlayer(Player player) throws DogtownSystemException
	{
		createEntity(player);
	}

	public Player retrievePlayerById(Player player)throws DogtownSystemException
	{
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_PLAYER_BY_ID);
			query.setParameter("id", player.getId());
			
			return (Player)query.uniqueResult();
		} 
		catch (Exception e)
		{
			String message = "Error Retrieving Player by Id";
			log.debug(message);
			throw new DogtownSystemException(message, e);
		}	
	}

	public void deletePlayers(List<Player> players) throws DogtownSystemException
	{
		try
		{
			for (Iterator iterator = players.iterator(); iterator.hasNext();)
			{
				Player player = (Player) iterator.next();
				
				getSession().delete(player);
				
			}
		} 
		catch (Exception e)
		{
			String message = "Error Retrieving Player by Id";
			log.debug(message);
			throw new DogtownSystemException(message, e);
		}	
	}
	
	public List<Player> retrieveEligiblePlayers(Tournament tournament) throws DogtownSystemException
	{
		List<Player> retVal = new ArrayList<Player>();
		
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_ELIGIBLE_PLAYERS);
			query.setParameter("id", tournament.getId());
			
			List<Player> result = (List<Player>)query.list();
			
			if(result != null)
			{
				retVal.addAll(result);
			}
		} 
		catch (Exception e)
		{
			String message = "Error Retrieving Eligible Players for Tournament";
			log.debug(message);
			throw new DogtownSystemException(message, e);
		}
		
		return retVal;
	}

}
