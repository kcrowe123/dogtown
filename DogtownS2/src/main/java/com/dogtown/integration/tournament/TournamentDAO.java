package com.dogtown.integration.tournament;

import java.util.List;

import com.dogtown.domain.tournament.Tournament;
import com.dogtown.framework.exception.DogtownSystemException;

public interface TournamentDAO
{
	public List<Tournament> retrieveAllTouranements()throws DogtownSystemException;

	public void createTournament(Tournament tournament)throws DogtownSystemException;

	public Tournament retrieveTournamentById(Tournament tournament) throws DogtownSystemException;
}
