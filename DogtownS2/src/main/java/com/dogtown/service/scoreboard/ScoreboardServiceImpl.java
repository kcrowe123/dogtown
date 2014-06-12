package com.dogtown.service.scoreboard;

import java.util.Collections;
import java.util.List;

import com.dogtown.domain.skin.Skins;
import com.dogtown.domain.skinGame.SkinGame;
import com.dogtown.domain.skinGame.SkinScorecardComparator;
import com.dogtown.domain.tournament.Tournament;
import com.dogtown.domain.tournament.TournamentPlayerScorecardScoreComparator;
import com.dogtown.domain.tournament.TournamentScoreboard;
import com.dogtown.domain.tournament.TournamentScoreboardFlightComparator;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.integration.skin.SkinDAO;
import com.dogtown.integration.tournament.TournamentDAO;


public class ScoreboardServiceImpl implements ScoreboardService
{
	
	private SkinDAO skinDAO;
	
	private TournamentDAO tournamentDAO;
	
	public List<TournamentScoreboard> retrieveTournamentScoreboard(Tournament tournament) throws DogtownSystemException
	{
		tournament = getTournamentDAO().retrieveTournamentById(tournament);
		
		List<TournamentScoreboard> tournamentScoreboard = tournament.getTournamentScoreboard();
		
		Collections.sort(tournamentScoreboard, new TournamentScoreboardFlightComparator());
		
		return tournamentScoreboard;
	}
	
	public TournamentScoreboard retrieveTournamentScoreboardByFlight(Tournament tournament, TournamentScoreboard scoreboard)throws DogtownSystemException
	{
		tournament = getTournamentDAO().retrieveTournamentById(tournament);
		
		scoreboard = tournament.getTournamentScoreboardByFlight(scoreboard.getFlight());
		
		Collections.sort(scoreboard.getScorecards(), new TournamentPlayerScorecardScoreComparator());
		
		return scoreboard;
	}
	
	public SkinGame retrieveSkinGame(Skins skin) throws DogtownSystemException
	{
		skin = getSkinDAO().retrieveSkinById(skin);
		
		SkinGame game = new SkinGame(skin);
		
		Collections.sort(game.getSkinScorecards(), new SkinScorecardComparator());
		
		return game;
	}
	
	private TournamentDAO getTournamentDAO()
	{
		return tournamentDAO;
	}
	
	private SkinDAO getSkinDAO()
	{
		return skinDAO;
	}

	public void setSkinDAO(SkinDAO skinDAO) {
		this.skinDAO = skinDAO;
	}

	public void setTournamentDAO(TournamentDAO tournamentDAO) {
		this.tournamentDAO = tournamentDAO;
	}
	
	
}
