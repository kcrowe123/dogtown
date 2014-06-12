package com.dogtown.integration.tournament;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.dogtown.domain.tournament.Tournament;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.integration.DogtownDAO;

public class TournamentDAOImpl extends DogtownDAO implements TournamentDAO
{
	static Logger log = Logger.getLogger(TournamentDAOImpl.class);
	
	public static final String RETRIEVE_ALL_TOURNAMENTS = "retrieveAllTournaments";
	public static final String RETRIEVE_TOURNAMENT_BY_ID = "retrieveTournamentById";
	
	@SuppressWarnings("unchecked")
	public List<Tournament> retrieveAllTouranements() throws DogtownSystemException
	{
		List retVal = new ArrayList();
		
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_ALL_TOURNAMENTS);
			
			List result = (List<Tournament>)query.list();
			
			if(result != null)
			{
				retVal.addAll(result);
			}
		} 
		catch (Exception e)
		{
			throw new DogtownSystemException("Error Retrieveing all Tournaments", e);
		}
		
		return retVal;
	}

	public void createTournament(Tournament tournament) throws DogtownSystemException
	{
		createEntity(tournament);	
		
		getSession().flush();
	}

	public Tournament retrieveTournamentById(Tournament tournament) throws DogtownSystemException
	{
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_TOURNAMENT_BY_ID);
			query.setParameter("id", tournament.getId());
			
			return (Tournament)query.uniqueResult();
		} 
		catch (Exception e)
		{
			String message = "Error Retrieving Tournament by Id";
			log.debug(message);
			throw new DogtownSystemException(message, e);
		}	
	}

}
