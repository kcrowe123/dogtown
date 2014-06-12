package com.dogtown.integration.scorecard;

import org.hibernate.Query;

import com.dogtown.domain.scorecard.Scorecard;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.integration.DogtownDAO;

public class ScorecardDAOImpl extends DogtownDAO implements ScorecardDAO
{
	
	public static final String RETRIEVE_SCORECARD_BY_ID = "retrieveScorecardById";
	
	public Scorecard getScorecardById(Scorecard scorecard) throws DogtownSystemException
	{
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_SCORECARD_BY_ID);
			query.setParameter("id", scorecard.getId());
			
			return (Scorecard)query.uniqueResult();
		} 
		catch (Exception e)
		{
			String message = "Error Retrieving Scorecard by Id";
			throw new DogtownSystemException(message, e);
		}	
	}


}
