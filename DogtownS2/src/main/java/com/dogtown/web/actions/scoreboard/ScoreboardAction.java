package com.dogtown.web.actions.scoreboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.dogtown.domain.day.Day;
import com.dogtown.domain.skin.Skins;
import com.dogtown.domain.skinGame.SkinGame;
import com.dogtown.domain.skinGame.SkinGameComparator;
import com.dogtown.domain.tournament.Tournament;
import com.dogtown.domain.tournament.TournamentScoreboard;
import com.dogtown.service.scoreboard.ScoreboardService;
import com.dogtown.web.actions.BaseAction;


public class ScoreboardAction extends BaseAction
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TournamentScoreboard scoreboard;
	
	private SkinGame skinGame;

	private Tournament tournament;
	
	private ScoreboardService scoreboardService;
	
//	public String displayScoreboard() throws Exception
//	{
//		scoreboard = (TournamentScoreboard)scoreboardModel.getRowData();
//		
//		Tournament tournament = ((TournamentBean)getSessionMap().get("TournamentBean")).getTournament();
//		
//		scoreboard = scoreboardService.retrieveTournamentScoreboardByFlight(tournament, scoreboard);
//		
//		return WebConstants.SUCCESS;
//	}
	
//	public String displayDayOneSkinGame() throws Exception
//	{
//		skinGame = (SkinGame) dayOneModel.getRowData();
//		skinGame = scoreboardService.retrieveSkinGame(skinGame.getSkin());
//		
//		return WebConstants.SKIN_GAME;
//	}
	
//	public String displayDayTwoSkinGame() throws Exception
//	{
//		skinGame = (SkinGame) dayTwoModel.getRowData();
//		skinGame = scoreboardService.retrieveSkinGame(skinGame.getSkin());
//		
//		return WebConstants.SKIN_GAME;
//	}
	
	
//    public DataModel getTournamentScoreboard()throws Exception
//    {	
//    	Tournament tournament = ((TournamentBean)getSessionMap().get("TournamentBean")).getTournament();
//    	
//    	List<TournamentScoreboard> scoreboards = scoreboardService.retrieveTournamentScoreboard(tournament);
//    	
//    	scoreboardModel.setWrappedData(scoreboards);
//    	
//    	return scoreboardModel;
//    }
    
//    public DataModel getDayOneSkinGame()throws Exception
//    {	
//    	Tournament tournament = ((TournamentBean)getSessionMap().get("TournamentBean")).getTournament();
//    	
//    	List<SkinGame> skinGames = getSkinGames(tournament.getFirstDay());
//    	
//    	dayOneModel.setWrappedData(skinGames);
//    	
//    	return dayOneModel;
//    }
    

//	public List<SkinGame> getDayTwoSkinGame()throws Exception
//    {	
//    	tournament = ((TournamentBean)getSessionMap().get("TournamentBean")).getTournament();
//    	
//    	List<SkinGame> skinGames = getSkinGames(tournament.getSecondDay());
//    	
//    	
//    	return skinGames;
//    }
	
    private List<SkinGame> getSkinGames(Day day)
	{
    	List<SkinGame> skinGames = new ArrayList<SkinGame>();
    	
		for (Iterator<Skins> iterator = day.getSkins().iterator(); iterator.hasNext();)
		{
			Skins skins = (Skins) iterator.next();
			
			if(skins.getScorecards().size() > 0)
			{
				skinGames.add(new SkinGame(skins));	
			}
		}
		
		Collections.sort(skinGames, new SkinGameComparator());
		
		return skinGames;
	}


	public TournamentScoreboard getScoreboard()
	{
		return scoreboard;
	}


	public void setScoreboard(TournamentScoreboard scoreboard)
	{
		this.scoreboard = scoreboard;
	}


	public SkinGame getSkinGame()
	{
		return skinGame;
	}


	public void setSkinGame(SkinGame skinGame)
	{
		this.skinGame = skinGame;
	}


	public Tournament getTournament() {
		return tournament;
	}


	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}


	public ScoreboardService getScoreboardService() {
		return scoreboardService;
	}


	public void setScoreboardService(ScoreboardService scoreboardService) {
		this.scoreboardService = scoreboardService;
	}
	
	

}
