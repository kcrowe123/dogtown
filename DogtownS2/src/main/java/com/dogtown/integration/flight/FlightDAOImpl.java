package com.dogtown.integration.flight;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.dogtown.domain.flight.Flight;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.integration.DogtownDAO;

public class FlightDAOImpl extends DogtownDAO implements FlightDAO
{
	static Logger log = Logger.getLogger(FlightDAOImpl.class);
	
	public static final String RETRIEVE_ALL_FLIGHTS = "retrieveAllFlights";
	public static final String RETRIEVE_FLIGHT_BY_ID = "retrieveFlightById";
	public static final String RETRIEVE_FLIGHTS = "retrieveFlights";
	
	public List<Flight> retrieveAllFlights() throws DogtownSystemException
	{
		List<Flight> retVal = new ArrayList<Flight>();
		
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_ALL_FLIGHTS);
			
			List<Flight> result = (List<Flight>)query.list();
			
			if(result != null)
			{
				retVal.addAll(result);
			}
		} 
		catch (Exception e)
		{
			String message = "Error Retrieveing all Flights";
			log.debug(message);
			throw new DogtownSystemException(message, e);
		}
		
		return retVal;
	}
	
	public Flight retrieveFlightById(Flight flight) throws DogtownSystemException
	{
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_FLIGHT_BY_ID);
			query.setParameter("id", flight.getId());
			
			return (Flight)query.uniqueResult();
		} 
		catch (Exception e)
		{
			String message = "Error Retrieving Flight by Id";
			throw new DogtownSystemException(message, e);
		}	
	}

	public List<Flight> retrieveFlights(List<Flight> flights)throws DogtownSystemException
	{
		List<Flight> retVal = new ArrayList<Flight>();
		
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_FLIGHTS);
			query.setParameterList("flights", flights);
			
			List<Flight> result = (List<Flight>)query.list();
			
			if(result != null)
			{
				retVal.addAll(result);
			}
		} 
		catch (Exception e)
		{
			throw new DogtownSystemException("Error Retrieveing Flights", e);
		}
		
		return retVal;
	}
	
}
