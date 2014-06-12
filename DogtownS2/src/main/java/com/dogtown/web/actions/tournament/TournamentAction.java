package com.dogtown.web.actions.tournament;


import com.dogtown.domain.day.Day;
import com.dogtown.domain.tournament.Tournament;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.web.actions.BaseAction;

public class TournamentAction extends BaseAction
{
    

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String SUCCESS = "success";
    
	private Tournament tournament;
	
	private Day firstDay;
	
	private Day secondDay;

    
    public Tournament getTournamentById(String id) throws DogtownSystemException {
    	tournament.setId(new Long(id));
		return tournamentService.retrieveTournamentById(tournament) ;
	}
 
    private boolean edit;
    

	
	
	public String tournamentForm() throws Exception
	{	

		
//		tournaments = tournamentService.retrieveTournaments();
		
//		tournamentModel.setWrappedData(tournaments);
//		
		return SUCCESS;
	}
	
//    public List<TournamentPlayerScorecard> getTournamentPlayers()throws Exception
//    {	
//    	Tournament tournament = ((TournamentBean)getSessionMap().get("TournamentBean")).getTournament();
//    	
//    	return tournamentService.retrieveTournamentPlayerScorecards(tournament);
//    }
	
	/**
	 * Adds a Tournament
	 * 
	 * @return
	 * @throws DogtownSystemException
	 */
	public String saveTournament() throws Exception
	{
		if(isEdit())
		{
			return updateTournament();
		}
		
		return createTournament();
	}
	
	/**
	 * Creates a Tournament
	 * 
	 * @return
	 * @throws Exception
	 */
	private String createTournament() throws Exception
	{
				
		tournamentService.createTournament(tournament);
		
		addActionMessage("Save Successful");
		//addTournamentToSession();
		
		setEdit(true);
		
		return SUCCESS;
	}
	
    /**
     * Retrieves all Dogtown Invitational Tournaments
     * 
     * @return
     * @throws Exception
     */
    public String updateTournament() throws Exception
    {
    	try
		{	
    		tournamentService.updateTournament(tournament);
    		//reset edit mode
    		setEdit(true);
		} 
    	catch (Exception e)
		{
			e.printStackTrace();
    		addActionError("Error: Saving Tournament");
			
			return "failure";
		}
    	
    	addTournamentToSession();
        addActionMessage("Save Successful");
    	
    	return SUCCESS;
    }
	
	/**
	 * Prepare the tournamentForm to add a new Tournament. This gets executed before we prompt
     * the user to add a new Tournament.
	 * @return
	 */
	public String addNewTournament()
	{
		
		tournament.setId(new Long("0"));
		Day day1 = new Day();
		Day day2 = new Day();
		tournament.addDay(day1);
		tournament.addDay(day2);
		setEdit(false);
		
		return SUCCESS;
	}
	
    /**
     * Edit the Tournament. This get executed before the edit tournamentForm page gets loaded.
     *
     * @return outcome
     */
    public String editTournament() throws Exception
    {    	

    	tournament = (Tournament) tournamentService.retrieveTournamentById(tournament);
    	
    	addTournamentToSession();
        
        setEdit(true);

        return SUCCESS;
    }
   
//    /**
//     * Scorecard Player Listing. This get executed before the scorecardPlayerListing page gets loaded.
//     *
//     * @return outcome
//     */
//    public String scorecardPlayerListing() throws Exception
//    {    
//    	tournament = (Tournament) tournamentModel.getRowData();
//    	tournament = (Tournament) tournamentService.retrieveTournamentById(tournament);
//    	
//        return SUCCESS;
//    }
    
    /**
     * View Scoreboard. This get executed before the scoreboard page gets loaded.
     *
     * @return outcome
     */
//    public String viewScoreboard() throws Exception
//    {    
//    	tournament = (Tournament) tournamentModel.getRowData();
//    	tournament = (Tournament) tournamentService.retrieveTournamentById(tournament);
//    	
//        return SUCCESS;
//    }
    
//	public Tournament getTournament()
//	{
//		return tournament;
//	}
//
//	public void setTournament(Tournament tournament)
//	{
//		this.tournament = tournament;
//	}

//	public DataModel getTournamentModel()
//	{
//		return tournamentModel;
//	}
//
//	public void setTournamentModel(DataModel tournamentModel)
//	{
//		this.tournamentModel = tournamentModel;
//	}

	public boolean isEdit()
	{
		return edit;
	}

	public void setEdit(boolean edit)
	{
		this.edit = edit;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
	

	public Tournament getTournament() {
		return tournament;
	}

	private void addTournamentToSession(){
		session.put("tournament", tournament);
	}
	
}


