package com.dogtown.service.scoreboard;

import java.util.List;

import com.dogtown.domain.flight.Flight;
import com.dogtown.domain.skin.Skins;
import com.dogtown.domain.skinGame.SkinGame;
import com.dogtown.domain.tournament.Tournament;
import com.dogtown.domain.tournament.TournamentScoreboard;
import com.dogtown.framework.exception.DogtownSystemException;

public interface ScoreboardService
{
	public List<TournamentScoreboard> retrieveTournamentScoreboard(Tournament tournament) throws DogtownSystemException;

	public TournamentScoreboard retrieveTournamentScoreboardByFlight(Tournament tournament, TournamentScoreboard scoreboard) throws DogtownSystemException;

	public SkinGame retrieveSkinGame(Skins skin) throws DogtownSystemException;
}
