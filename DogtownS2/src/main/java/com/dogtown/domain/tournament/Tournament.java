package com.dogtown.domain.tournament;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.dogtown.domain.PersistentBaseClass;
import com.dogtown.domain.day.Day;
import com.dogtown.domain.flight.Flight;
import com.dogtown.domain.player.Player;
import com.dogtown.domain.scorecard.Scorecard;
import com.dogtown.framework.date.DateConstants;
import com.dogtown.framework.date.DateUtil;

/**
 * Represents a Tournament
 * 
 * @author Z900247
 *	
 * @hibernate.class  table="tournament"
 */
public class Tournament extends PersistentBaseClass
{
	private String name;
	
	private List days;
	
	/**
	 * The getter method for this Tournament's identifier
	 * 
	 * @hibernate.id column = "TOURNAMENT_ID" generator-class="native"
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * The getter method for this Tournaments Name
	 * 
	 * @return firstName
	 * 
	 * @hibernate.property column = "TOURNAMENT_NAME" 
	 *                     unique = "true"
	 */
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Its a persistent relationship. its getting included in the mapping file
	 * from hibernate-properties-Tournament.xml
	 * @return
	 */
	public List getDays()
	{
		if(days == null)
		{
			days = new ArrayList();
		}
		
		return days;
	}

	public void setDays(List days)
	{
		this.days = days;
	}
	
	public void addDay(Day day)
	{
		if(days == null)
		{
			days = new ArrayList();
		}
		
		days.add(day);
	}
	
	public Day getFirstDay()
	{
		Day day1 = null;
		
		if(days != null)
		{
			for (Iterator iterator = days.iterator(); iterator.hasNext();)
			{
				day1 = (Day) iterator.next();
				break;
			}
		}

		return day1;
	}
	
	public Day getSecondDay()
	{
		Day day2 = null;
		
		if(days != null)
		{
			for (Iterator iterator = days.iterator(); iterator.hasNext();)
			{
				day2 = (Day) iterator.next();
			}
		}
		
		return day2;
	}
	
	public List getTournamentPlayerScrorecards()
	{
		List list = new ArrayList();
		
		if(getFirstDay() != null && getFirstDay().getScorecards() != null)
		{
			for (Iterator iterator = getFirstDay().getScorecards().iterator(); iterator.hasNext();)
			{
				Scorecard scorecard1 = (Scorecard) iterator.next();
				
				TournamentPlayerScorecard tournamentPlayerScorecard = new TournamentPlayerScorecard();
				tournamentPlayerScorecard.setPlayer(scorecard1.getPlayer());
				tournamentPlayerScorecard.setDayOneScorecard(scorecard1);
				tournamentPlayerScorecard.setDayTwoScorecard(getSecondDay().getPlayerScorecard(scorecard1.getPlayer()));
				
				list.add(tournamentPlayerScorecard);
			}
		}
		
		return list;
	}
	
	public List getTournamentScoreboard()
	{
		Map tournamentScorecards = new HashMap();
		
		List tournamentPlayerScorecards = getTournamentPlayerScrorecards();
		
		for (Iterator iterator = tournamentPlayerScorecards.iterator(); iterator.hasNext();)
		{
			TournamentPlayerScorecard tournamentPlayerScorecard = (TournamentPlayerScorecard) iterator.next();
			
			Set flights = tournamentPlayerScorecard.getDayOneScorecard().getFlights();
			
			for (Iterator iterator2 = flights.iterator(); iterator2.hasNext();)
			{
				Flight flight = (Flight) iterator2.next();
				
				TournamentScoreboard scoreboard = (TournamentScoreboard)tournamentScorecards.get(flight);
				
				if(scoreboard == null)
				{
					scoreboard = new TournamentScoreboard();
					scoreboard.setFlight(flight);
				}
				
				scoreboard.addScorecard(tournamentPlayerScorecard);
				tournamentScorecards.put(flight, scoreboard);
			}
		}
		
		List scoreboards = new ArrayList();
		
		for (Iterator iterator = tournamentScorecards.keySet().iterator(); iterator.hasNext();)
		{
			Flight flight = (Flight) iterator.next();
			
			TournamentScoreboard scoreboard = (TournamentScoreboard)tournamentScorecards.get(flight); 
			
			scoreboards.add(scoreboard);
		}
		
		return scoreboards;
	}
	
	public TournamentScoreboard getTournamentScoreboardByFlight(Flight flight)
	{
		List tournamentPlayerScorecards = getTournamentPlayerScrorecards();
		
		TournamentScoreboard scoreboard = new TournamentScoreboard();
		
		for (Iterator iterator = tournamentPlayerScorecards.iterator(); iterator.hasNext();)
		{
			TournamentPlayerScorecard tournamentPlayerScorecard = (TournamentPlayerScorecard) iterator.next();
			
			Set flights = tournamentPlayerScorecard.getDayOneScorecard().getFlights();
			
			for (Iterator iterator2 = flights.iterator(); iterator2.hasNext();)
			{
				Flight playerFlight = (Flight) iterator2.next();

				if(playerFlight.getName().equals(flight.getName()))
				{
					scoreboard.setFlight(playerFlight);
					scoreboard.addScorecard(tournamentPlayerScorecard);
				}
			}
		}
		
		return scoreboard;
	}
	
	public int getTotalNumberOfPlayers()
	{
		return getTournamentPlayerScrorecards().size();
	}
	
	public boolean isSeniorEligiblePlayer(Player player)
	{
		Date seniorEligible = DateUtil.add(DateConstants.YEAR, -60, getSecondDay().getDate());
		
		return player.getDateOfBirth().before(seniorEligible);	
	}
	
	public boolean equals(Object obj)
	{
		Tournament tournament = (Tournament) obj;
		
		return this.getId() == tournament.getId() && this.name.equals(tournament.getName());
	}

	public String toString()
	{
		return this.getName();
	}
	
}
