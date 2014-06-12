package com.dogtown.service.scorecard;

import java.util.Iterator;
import java.util.List;

import com.dogtown.domain.scorecard.Scorecard;
import com.dogtown.domain.skin.Skins;
import com.dogtown.domain.tournament.TournamentPlayerScorecard;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.integration.player.PlayerDAO;
import com.dogtown.integration.scorecard.ScorecardDAO;
import com.dogtown.integration.skin.SkinDAO;

public class ScorecardServiceImpl implements ScorecardService
{

	PlayerDAO playerDAO;
	
	ScorecardDAO scorecardDAO;
	
	SkinDAO skinDAO;
	
	public TournamentPlayerScorecard retrieveTournamentPlayerScorecard(TournamentPlayerScorecard playerScorecard)throws DogtownSystemException
	{
		playerScorecard.setPlayer(getPlayerDAO().retrievePlayerById(playerScorecard.getPlayer()));
		playerScorecard.setDayOneScorecard(getScorecardDAO().getScorecardById(playerScorecard.getDayOneScorecard()));
		playerScorecard.setDayTwoScorecard(getScorecardDAO().getScorecardById(playerScorecard.getDayTwoScorecard()));
		
		return playerScorecard;
	}
	
	public TournamentPlayerScorecard savePlayerScorecard(TournamentPlayerScorecard playerScorecard) throws DogtownSystemException
	{
		Scorecard scorecard1 = updateScorecard(playerScorecard.getDayOneScorecard());
		Scorecard scorecard2 = updateScorecard(playerScorecard.getDayTwoScorecard());
		

		
		playerScorecard.setDayOneScorecard(scorecard1);
		playerScorecard.setDayTwoScorecard(scorecard2);
		
		//scorecardDAO.save(scorecard1);
		//scorecardDAO.save(scorecard2);
		
		return playerScorecard;
	}

	private Scorecard updateScorecard(Scorecard updatedScorecard) throws DogtownSystemException
	{
		Scorecard scorecard = (getScorecardDAO().getScorecardById(updatedScorecard));
		scorecard.setFirstHole(updatedScorecard.getFirstHole());
		scorecard.setSecondHole(updatedScorecard.getSecondHole());
		scorecard.setThirdHole(updatedScorecard.getThirdHole());
		scorecard.setFourthHole(updatedScorecard.getFourthHole());
		scorecard.setFifthHole(updatedScorecard.getFifthHole());
		scorecard.setSixthHole(updatedScorecard.getSixthHole());
		scorecard.setSeventhHole(updatedScorecard.getSeventhHole());
		scorecard.setEigthHole(updatedScorecard.getEigthHole());
		scorecard.setNinthHole(updatedScorecard.getNinthHole());
		scorecard.setTenthHole(updatedScorecard.getTenthHole());
		scorecard.setEleventhHole(updatedScorecard.getEleventhHole());
		scorecard.setTwelthHole(updatedScorecard.getTwelthHole());
		scorecard.setThirteenthHole(updatedScorecard.getThirteenthHole());
		scorecard.setFourteenthHole(updatedScorecard.getFourteenthHole());
		scorecard.setFifteenthHole(updatedScorecard.getFifteenthHole());
		scorecard.setSixteenthHole(updatedScorecard.getSixteenthHole());
		scorecard.setSeventeenthHole(updatedScorecard.getSeventeenthHole());
		scorecard.setEighteenthHole(updatedScorecard.getEighteenthHole());
		
		return scorecard;
	}

	public Scorecard retrieveScoreacardById(Scorecard scorecard)throws DogtownSystemException
	{
		return getScorecardDAO().getScorecardById(scorecard);
	}
	
	public void addScorecardSkinGames(Scorecard scorecard, List<Skins> skins) throws DogtownSystemException
	{
		scorecard = retrieveScoreacardById(scorecard);
		scorecard.getSkins().clear();
		if(skins.size() > 0)
		{
			skins = getSkinDAO().retrieveSkins(skins);
			scorecard.getSkins().addAll(skins);
		}
	}
	
	
	private PlayerDAO getPlayerDAO()
	{
		return playerDAO;
	}
	
	private ScorecardDAO getScorecardDAO()
	{
		return scorecardDAO;
	}
	
	private SkinDAO getSkinDAO()
	{
		return skinDAO;
	}

	public void setPlayerDAO(PlayerDAO playerDAO) {
		this.playerDAO = playerDAO;
	}

	public void setScorecardDAO(ScorecardDAO scorecardDAO) {
		this.scorecardDAO = scorecardDAO;
	}

	public void setSkinDAO(SkinDAO skinDAO) {
		this.skinDAO = skinDAO;
	}


	
	

}
