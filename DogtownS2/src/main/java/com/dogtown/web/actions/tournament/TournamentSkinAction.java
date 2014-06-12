package com.dogtown.web.actions.tournament;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.dogtown.domain.day.Day;
import com.dogtown.domain.scorecard.Scorecard;
import com.dogtown.domain.scorecard.ScorecardPlayerComparator;
import com.dogtown.domain.skin.SkinComparator;
import com.dogtown.domain.skin.Skins;
import com.dogtown.domain.tournament.Tournament;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.service.day.DayService;
import com.dogtown.service.scorecard.ScorecardService;
import com.dogtown.service.tournament.TournamentService;
import com.dogtown.web.actions.BaseAction;



public class TournamentSkinAction extends BaseAction
{
	private static final String DAY_TWO_PLAYER_LISTING = "dayTwoPlayerListing";
	
	private static final String DAY_ONE_PLAYER_LISTING = "dayOnePlayerListing";

	private static final String REDIRECT_URL = "redirectURL";

	public static final String DAY = "day";

	private static final String SKIN_ARRAY = "skinArray";

	public static final String SKIN_GAME_ITEMS = "skinGameItems";

	private Day day;
	
	private Scorecard scorecard;
	
	private Tournament tournament;
	
	private DayService dayService;
	
	private ScorecardService scorecardService;
	
	private long scorecardId;
	
	private long dayId;
	
	private String[] skinArray;
	
	private List<Skins> skinGameItems = new ArrayList<Skins>();
	

	
	public String dayOnePlayerListing() throws Exception
	{	
		tournament = getTournament();
		
		day = tournament.getFirstDay();
		
		session.put(REDIRECT_URL, DAY_ONE_PLAYER_LISTING);
		
		return SUCCESS;
	}
	
	public String dayTwoPlayerListing()throws Exception
	{
		tournament = getTournament();
		
		day = tournament.getSecondDay();
		
		session.put(REDIRECT_URL, DAY_TWO_PLAYER_LISTING);
		
		return SUCCESS;
	}

	private Tournament getTournament()throws DogtownSystemException
	{
		if(tournament.getId()==0){
			tournament = (Tournament) session.get("tournament");
		}
		
		tournament = tournamentService.retrieveTournamentById(tournament);
		
		session.put("tournament", tournament);
		
		return tournament;
	}
	
	public List<Scorecard> getScorecards() throws Exception
	{
		day = dayService.retrieveDayById(day);
		
		List<Scorecard> scorecards = new ArrayList<Scorecard>();
		scorecards.addAll(day.getScorecards());
		
		Collections.sort(scorecards, new ScorecardPlayerComparator());
		
		return scorecards;
		
	}
	
	public String editSkinsGame() throws Exception
	{
		
		scorecard = scorecardService.retrieveScoreacardById(scorecard);
		
		retrieveSkins();
		
		return SUCCESS;
	}
	
	public String saveSkinGames() throws Exception
	{
		
	    List<Skins> selectedSkinGames = getSelectedSkinGames();
	    	
	    scorecardService.addScorecardSkinGames(scorecard, selectedSkinGames);
	    
	    addActionMessage("Save Successful");
	    
	    refreshAction();	    
	    
		return (String) session.get(REDIRECT_URL);
	}
	

	private void refreshAction() {
		

		
	}

	public String playerListing()
	{
		return SUCCESS;
	}
	
	private void retrieveSkins() throws Exception
	{
		skinGameItems = new ArrayList<Skins>();
		
		day = dayService.retrieveDayById(day);
		
    	List<Skins> skins = new ArrayList<Skins>();
    	skins.addAll(day.getSkins());
    	
    	Collections.sort(skins, new SkinComparator());
    
    	for (Iterator<Skins> iterator = skins.iterator(); iterator.hasNext();)
		{
			Skins skin = (Skins) iterator.next();
			
			skinGameItems.add(skin);
		}

	}
	
	private List<Skins> getSelectedSkinGames()
	{
		
		List<Skins> skins = new ArrayList<Skins>();
    	
    	for (int i = 0; i < skinArray.length; i++)
		{
			String skinId = skinArray[i];
			
			Skins skin = new Skins();
			skin.setId(Long.parseLong(skinId));
			skins.add(skin);
		}
    	
    	return skins;
	}

	public List<Skins> getSkinGameItems() throws Exception {
		
		retrieveSkins();
		
		return skinGameItems;
	}

	public void setSkinGameItems(List<Skins> skinGameItems) {
		this.skinGameItems = skinGameItems;
	}

	public Day getDay()
	{
		return day;
	}

	public void setDay(Day day)
	{
		this.day = day;
	}

	public Scorecard getScorecard()
	{
		return scorecard;
	}

	public void setScorecard(Scorecard scorecard)
	{
		this.scorecard = scorecard;
	}


	public DayService getDayService() {
		return dayService;
	}

	public void setDayService(DayService dayService) {
		this.dayService = dayService;
	}

	public ScorecardService getScorecardService() {
		return scorecardService;
	}

	public void setScorecardService(ScorecardService scorecardService) {
		this.scorecardService = scorecardService;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public String[] getSkinArray() {
		return skinArray;
	}

	public void setSkinArray(String[] skinArray) {
		this.skinArray = skinArray;
	}

	public long getScorecardId() {
		return scorecardId;
	}

	public void setScorecardId(long scorecardId) {
		this.scorecardId = scorecardId;
	}

	public long getDayId() {
		return dayId;
	}

	public void setDayId(long dayId) {
		this.dayId = dayId;
	}
	
	public Set<Scorecard> getDayScorecards(){
		return this.day.getScorecards();
	}
	
	
}
