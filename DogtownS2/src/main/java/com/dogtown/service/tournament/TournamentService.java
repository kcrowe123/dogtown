package com.dogtown.service.tournament;

import java.util.List;

import com.dogtown.domain.flight.Flight;
import com.dogtown.domain.player.Player;
import com.dogtown.domain.tournament.Tournament;
import com.dogtown.domain.tournament.TournamentPlayerScorecard;
import com.dogtown.framework.exception.DogtownSystemException;

public interface TournamentService
{
	public List<Tournament> retrieveTournaments() throws DogtownSystemException;

	public void createTournament(Tournament tournament) throws DogtownSystemException;

	public Tournament retrieveTournamentById(Tournament tournament) throws DogtownSystemException;

	public List<Player> retrieveEligiblePlayers(Tournament tournament) throws DogtownSystemException;

	public void addTournamentPlayer(Tournament tournament, Player player, List<Flight> flights, int handicap) throws DogtownSystemException;
	
	public void updateTournamentPlayer(Tournament tournament, Player player, List<Flight> flights, int handicap, TournamentPlayerScorecard tournamentPlayerScorecard) throws DogtownSystemException;

	public List<TournamentPlayerScorecard> retrieveTournamentPlayerScorecards(Tournament tournament) throws DogtownSystemException;

	public List<Flight> retrieveFlights() throws DogtownSystemException;

	public void updateTournament(Tournament tournament) throws DogtownSystemException;
}
