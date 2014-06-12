package com.dogtown.web.actions.scorecard;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;


import com.dogtown.domain.tournament.Tournament;
import com.dogtown.domain.tournament.TournamentPlayerScorecard;
import com.dogtown.framework.date.DogtownConstants;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.service.scorecard.ScorecardService;
import com.dogtown.service.tournament.TournamentService;
import com.dogtown.web.actions.BaseAction;
import com.opensymphony.xwork2.ActionSupport;


public class ScorecardAction extends BaseAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TournamentPlayerScorecard playerScorecard;
	
	private ScorecardService scorecardService;
	
	private Tournament tournament;
	
	private long tournamentId;
	
	private long playerId;
	
	private long dayOneScorecardId;
	
	private long dayTwoScorecardId;
	
	private List<TournamentPlayerScorecard> tournamentPlayerScorecards;
	
    public String loadTournamentPlayers()throws Exception
    {	

    	
    	tournament.setId(tournamentId);
    	
    	tournament = tournamentService.retrieveTournamentById(tournament);
		
        session.put("tournament", tournament);
    	
    	tournamentPlayerScorecards = tournamentService.retrieveTournamentPlayerScorecards(tournament);   	
		
		return SUCCESS;
    }
	
    public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	/**
     * Edit the Tournament. This get executed before the edit tournamentForm page gets loaded.
     *
     * @return outcome
     */
    public String editScorecard() throws Exception
    {   
    	resetTournamentId();
    	
    	try{
	    	playerScorecard.getPlayer().setId(playerId);
	    	playerScorecard.getDayOneScorecard().setId(dayOneScorecardId);
	    	playerScorecard.getDayTwoScorecard().setId(dayTwoScorecardId);
	       
	    	playerScorecard = scorecardService.retrieveTournamentPlayerScorecard(playerScorecard); 
    	}
    	catch(Exception e){
    		e.printStackTrace();
    		throw(e);
    	}
    	
        return SUCCESS;
    }

	private void resetTournamentId() {
		tournament = (Tournament) session.get("tournament");
    	setTournamentId(tournament.getId());
	}
   
	/**
	 * Save Scorecards
	 * 
	 * @return
	 * @throws DogtownSystemException
	 */
	public String saveScorecard() throws Exception
	{
		try
		{
			resetTournamentId(); 
			
			playerScorecard = scorecardService.savePlayerScorecard(playerScorecard);
			
			addActionMessage("Save Successful");
			
			return loadTournamentPlayers();
		} 
		catch (DogtownSystemException e)
		{
			addActionError("Error: Updating Scorecard");
			throw e;
		}
		
	}

	public TournamentPlayerScorecard getPlayerScorecard()
	{
		return playerScorecard;
	}

	public void setPlayerScorecard(TournamentPlayerScorecard playerScorecard)
	{
		this.playerScorecard = playerScorecard;
	}

	public TournamentService getTournamentService() {
		return tournamentService;
	}

	public void setTournamentService(TournamentService tournamentService) {
		this.tournamentService = tournamentService;
	}

	public ScorecardService getScorecardService() {
		return scorecardService;
	}

	public void setScorecardService(ScorecardService scorecardService) {
		this.scorecardService = scorecardService;
	}

	public List<TournamentPlayerScorecard> getTournamentPlayerScorecards() {
		return tournamentPlayerScorecards;
	}

	public void setTournamentPlayerScorecards(
			List<TournamentPlayerScorecard> tournamentPlayerScorecards) {
		this.tournamentPlayerScorecards = tournamentPlayerScorecards;
	}

    private String getParameter(String param){
    	return ServletActionContext.getRequest().getParameter(param);
    }

	public long getTournamentId() {
		return tournamentId;
	}

	public void setTournamentId(long tournamentId) {
		this.tournamentId = tournamentId;
	}

	public long getPlayerId() {
		return playerId;
	}

	public void setPlayerId(long playerId) {
		this.playerId = playerId;
	}

	public long getDayOneScorecardId() {
		return dayOneScorecardId;
	}

	public void setDayOneScorecardId(long dayOneScorecardId) {
		this.dayOneScorecardId = dayOneScorecardId;
	}

	public long getDayTwoScorecardId() {
		return dayTwoScorecardId;
	}

	public void setDayTwoScorecardId(long dayTwoScorecardId) {
		this.dayTwoScorecardId = dayTwoScorecardId;
	}
	
	
	

    
}
