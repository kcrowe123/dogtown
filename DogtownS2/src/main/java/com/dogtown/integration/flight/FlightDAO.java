package com.dogtown.integration.flight;

import java.util.List;

import com.dogtown.domain.flight.Flight;
import com.dogtown.framework.exception.DogtownSystemException;

public interface FlightDAO
{
	public List<Flight> retrieveAllFlights() throws DogtownSystemException;
	public Flight retrieveFlightById(Flight flight) throws DogtownSystemException;
	public List<Flight> retrieveFlights(List<Flight> flights) throws DogtownSystemException;
}
