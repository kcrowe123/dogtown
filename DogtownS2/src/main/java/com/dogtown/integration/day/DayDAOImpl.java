package com.dogtown.integration.day;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.dogtown.domain.day.Day;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.integration.DogtownDAO;

public class DayDAOImpl extends DogtownDAO implements DayDAO
{
	public static final String RETRIEVE_DAY_BY_ID = "retrieveDayById";
	
	public Day retrieveDayById(Day day) throws DogtownSystemException
	{
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_DAY_BY_ID);
			query.setParameter("id", day.getId());
			
			return (Day)query.uniqueResult();
		} 
		catch (Exception e)
		{
			String message = "Error Retrieving Day by Id";
			throw new DogtownSystemException(message, e);
		}	
	}
	


}
