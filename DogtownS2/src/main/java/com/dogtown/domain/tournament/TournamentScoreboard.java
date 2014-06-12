package com.dogtown.domain.tournament;

import java.util.ArrayList;
import java.util.List;

import com.dogtown.domain.flight.Flight;

public class TournamentScoreboard
{
	private Flight flight;
	
	private List scorecards;
	
	public String getTotalPlayers()
	{
		if(scorecards != null)
		{
			return scorecards.size() + "";
		}
		
		return "0";
	}

	public Flight getFlight()
	{
		return flight;
	}

	public void setFlight(Flight flight)
	{
		this.flight = flight;
	}

	public List getScorecards()
	{
		return scorecards;
	}

	public void setScorecards(List scorecards)
	{
		this.scorecards = scorecards;
	}
	
	public void addScorecard(TournamentPlayerScorecard scorecard)
	{
		if(scorecards == null)
		{
			scorecards = new ArrayList();
		}
		
		scorecards.add(scorecard);
		
	}
	
	
}
