package com.dogtown.service.tournament;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.dogtown.domain.day.Day;
import com.dogtown.domain.flight.Flight;
import com.dogtown.domain.player.Player;
import com.dogtown.domain.scorecard.Scorecard;
import com.dogtown.domain.skin.Skins;
import com.dogtown.domain.tournament.Tournament;
import com.dogtown.domain.tournament.TournamentPlayerScorecard;
import com.dogtown.domain.tournament.TournamentPlayerScorecardComparator;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.framework.exception.DogtownSystemValidationException;
import com.dogtown.integration.flight.FlightDAO;
import com.dogtown.integration.player.PlayerDAO;
import com.dogtown.integration.scorecard.ScorecardDAO;
import com.dogtown.integration.tournament.TournamentDAO;


public class TournamentServiceImpl implements TournamentService
{
	private TournamentDAO tournamentDAO;
	private ScorecardDAO scorecardDAO;
	private PlayerDAO playerDAO;
	private FlightDAO flightDAO;

	public List<Tournament> retrieveTournaments() throws DogtownSystemException
	{
		return getTournamentDAO().retrieveAllTouranements();
	}

	public void createTournament(Tournament tournament) throws DogtownSystemException
	{	
		getTournamentDAO().createTournament(tournament);
		
		tournament.getFirstDay().getSkins().addAll(createSkinGames(tournament.getFirstDay()));
		tournament.getSecondDay().getSkins().addAll(createSkinGames(tournament.getSecondDay()));
	}

	public Tournament retrieveTournamentById(Tournament tournament) throws DogtownSystemException
	{	
		return getTournamentDAO().retrieveTournamentById(tournament);
	}

	public List retrieveEligiblePlayers(Tournament tournament) throws DogtownSystemException
	{
		return getPlayerDAO().retrieveEligiblePlayers(tournament);
	}

	public void addTournamentPlayer(Tournament tournament, Player player, List<Flight> flights, int handicap) throws DogtownSystemException
	{	
		try
		{	
			player = getPlayerDAO().retrievePlayerById(player);
			tournament = retrieveTournamentById(tournament);
			flights = getFlightDAO().retrieveFlights(flights);
			
			if(isValidFlight(tournament, player, flights))
			{
				Scorecard scorecard1 = new Scorecard(handicap);
				scorecard1.getFlights().addAll(flights);
				Scorecard scorecard2 = new Scorecard(handicap);
				scorecard2.getFlights().addAll(flights);
				
				player.addScorecard(scorecard1);
				player.addScorecard(scorecard2);
				
				tournament.getFirstDay().addScorecard(scorecard1);
				tournament.getSecondDay().addScorecard(scorecard2);
			}
		} 
		catch (DogtownSystemValidationException e)
		{
			throw e;
		}
	}
	
	public void updateTournamentPlayer(Tournament tournament, Player player, List<Flight> flights, int handicap, TournamentPlayerScorecard tournamentPlayerScorecard) throws DogtownSystemException
	{	
		try
		{	
			Scorecard scorecardOne = tournamentPlayerScorecard.getDayOneScorecard(); 
			Scorecard scorecardTwo = tournamentPlayerScorecard.getDayTwoScorecard(); 
			player = getPlayerDAO().retrievePlayerById(player);
			tournament = retrieveTournamentById(tournament);
			flights = getFlightDAO().retrieveFlights(flights);
			
			if(isValidFlight(tournament, player, flights))
			{
				Scorecard scorecard1 = getScorecardDAO().getScorecardById(scorecardOne);
				scorecard1.setHandicap(handicap);
				scorecard1.setFlights(null);
				scorecard1.getFlights().addAll(flights);
				
				Scorecard scorecard2 = getScorecardDAO().getScorecardById(scorecardTwo);
				scorecard2.setHandicap(handicap);
				scorecard2.setFlights(null);
				scorecard2.getFlights().addAll(flights);
				
				player.addScorecard(scorecard1);
				player.addScorecard(scorecard2);
				
				tournament.getFirstDay().addScorecard(scorecard1);
				tournament.getSecondDay().addScorecard(scorecard2);
			}
		} 
		catch (DogtownSystemValidationException e)
		{
			throw e;
		}
	}

	private boolean isValidFlight(Tournament  tournament, Player player, List<Flight> flights) throws DogtownSystemValidationException
	{
		
		for (Iterator iterator = flights.iterator(); iterator.hasNext();)
		{
			Flight flight = (Flight) iterator.next();
			
			if("Senior".equals(flight.getName()))
			{
				if(!tournament.isSeniorEligiblePlayer(player))
				{
					throw new DogtownSystemValidationException("Error: " + player.getFullName() + " is not eligible for Senior Flight");
				}
			}
		}
		
		return true;
	}

	public List<TournamentPlayerScorecard> retrieveTournamentPlayerScorecards(Tournament tournament) throws DogtownSystemException
	{
		List<TournamentPlayerScorecard> players = new ArrayList<TournamentPlayerScorecard>();
		
		tournament = retrieveTournamentById(tournament);
		
		if(tournament != null)
		{
			players.addAll(tournament.getTournamentPlayerScrorecards());
		}
		
		Collections.sort(players, new TournamentPlayerScorecardComparator());
		
		return players;
	}
	
	public List<Flight> retrieveFlights() throws DogtownSystemException
	{
		return getFlightDAO().retrieveAllFlights();
	}
	
	public void updateTournament(Tournament updatedTournament) throws DogtownSystemException
	{
		Tournament tournament = retrieveTournamentById(updatedTournament);
		
		tournament.setName(updatedTournament.getName());
		tournament.getFirstDay().setDate(updatedTournament.getFirstDay().getDate());
		tournament.getFirstDay().setCourse(updatedTournament.getFirstDay().getCourse());
		tournament.getSecondDay().setDate(updatedTournament.getSecondDay().getDate());
		tournament.getSecondDay().setCourse(updatedTournament.getSecondDay().getCourse());
	}
	
	private Set<Skins> createSkinGames(Day day)
	{
		Set<Skins> skins = new HashSet<Skins>();
		
		Skins champ = new Skins("Champ", day);
		Skins master = new Skins("Master", day);
		Skins a = new Skins("A", day);
		Skins b = new Skins("B", day);
		Skins c = new Skins("C", day);
		
		skins.add(champ);
		skins.add(master);
		skins.add(a);
		skins.add(b);
		skins.add(c);
		
		return skins;
	}
	
	private TournamentDAO getTournamentDAO()
	{
		return this.tournamentDAO;
	}
	
	private PlayerDAO getPlayerDAO()
	{
		return playerDAO;
	}
	
	private FlightDAO getFlightDAO()
	{
		return flightDAO;
	}

	public void setTournamentDAO(TournamentDAO tournamentDAO) {
		this.tournamentDAO = tournamentDAO;
	}

	public void setPlayerDAO(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}

	public void setFlightDAO(FlightDAO flightDAO) {
		this.flightDAO = flightDAO;
	}

	public ScorecardDAO getScorecardDAO() {
		return scorecardDAO;
	}

	public void setScorecardDAO(ScorecardDAO scorecardDAO) {
		this.scorecardDAO = scorecardDAO;
	}
	
	
	
}
