package com.dogtown.service.scorecard;

import java.util.List;

import com.dogtown.domain.scorecard.Scorecard;
import com.dogtown.domain.skin.Skins;
import com.dogtown.domain.tournament.TournamentPlayerScorecard;
import com.dogtown.framework.exception.DogtownSystemException;

public interface ScorecardService
{

	public TournamentPlayerScorecard retrieveTournamentPlayerScorecard(TournamentPlayerScorecard playerScorecard) throws DogtownSystemException;

	public TournamentPlayerScorecard savePlayerScorecard(TournamentPlayerScorecard playerScorecard) throws DogtownSystemException;

	public Scorecard retrieveScoreacardById(Scorecard scorecard) throws DogtownSystemException;

	public void addScorecardSkinGames(Scorecard scorecard, List<Skins> selectedSkinGames) throws DogtownSystemException;

}
