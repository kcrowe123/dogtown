package com.dogtown.domain.tournament;

import java.util.Iterator;

import com.dogtown.domain.flight.Flight;
import com.dogtown.domain.player.Player;
import com.dogtown.domain.scorecard.Scorecard;

public class TournamentPlayerScorecard
{
	private Player player;
	
	private Scorecard dayOneScorecard;
	
	private Scorecard dayTwoScorecard;
	
	public String getHandicap()
	{
		return dayOneScorecard.getHandicap() + "";
	}
	
	public String getTwoDayTotal()
	{
		if(Scorecard.DISQUALIFIED.equals(dayOneScorecard.getScore()) && Scorecard.DISQUALIFIED.equals(dayTwoScorecard.getScore()))
		{
			return Scorecard.DISQUALIFIED;
		}
		
		double day1 = 0;
		double day2 = 0;
		
		if(!Scorecard.DISQUALIFIED.equals(dayOneScorecard.getScore()))
		{
			day1 = Double.parseDouble(dayOneScorecard.getScore());
		}
		
		if(!Scorecard.DISQUALIFIED.equals(dayTwoScorecard.getScore()))
		{
			day2 = Double.parseDouble(dayTwoScorecard.getScore());
		}
		
		return (day1 + day2) + "";
	}
	
	public String getTwoDayHandicapTotal()
	{
		if(Scorecard.DISQUALIFIED.equals(dayOneScorecard.getHandicapScore()) && Scorecard.DISQUALIFIED.equals(dayTwoScorecard.getHandicapScore()))
		{
			return Scorecard.DISQUALIFIED;
		}
		
		double day1 = 0;
		double day2 = 0;
		
		if(!Scorecard.DISQUALIFIED.equals(dayOneScorecard.getHandicapScore()))
		{
			day1 = Double.parseDouble(dayOneScorecard.getHandicapScore());
		}
		
		if(!Scorecard.DISQUALIFIED.equals(dayTwoScorecard.getHandicapScore()))
		{
			day2 = Double.parseDouble(dayTwoScorecard.getHandicapScore());
		}
		
		return (day1 + day2) + "";
	}
	
	public String getFlight()
	{	
		String flights = "";
		
		for (Iterator iterator = dayOneScorecard.getFlights().iterator(); iterator.hasNext();)
		{
			Flight flight = (Flight) iterator.next();
			
			flights = flights + (flight.getName() + ", ");
		}
		
		if(flights != null && flights.length() > 0)
		{
			flights = flights.substring(0, flights.length() - 2);
		}
		
		return flights;
	}
	
	public String getTournamentScore()
	{
		return dayOneScorecard.getHandicapScore() + dayTwoScorecard.getHandicapScore() + "";
	}

	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}

	public Scorecard getDayOneScorecard()
	{
		return dayOneScorecard;
	}

	public void setDayOneScorecard(Scorecard dayOneScorecard)
	{
		this.dayOneScorecard = dayOneScorecard;
	}

	public Scorecard getDayTwoScorecard()
	{
		return dayTwoScorecard;
	}

	public void setDayTwoScorecard(Scorecard dayTwoScorecard)
	{
		this.dayTwoScorecard = dayTwoScorecard;
	}
}
