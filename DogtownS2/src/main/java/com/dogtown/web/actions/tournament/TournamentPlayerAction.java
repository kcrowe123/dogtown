package com.dogtown.web.actions.tournament;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.dogtown.domain.flight.Flight;
import com.dogtown.domain.player.Player;
import com.dogtown.domain.tournament.Tournament;
import com.dogtown.domain.tournament.TournamentPlayerScorecard;
import com.dogtown.framework.exception.DogtownSystemValidationException;
import com.dogtown.web.actions.BaseAction;
import com.dogtown.service.player.PlayerService;


public class TournamentPlayerAction extends BaseAction
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    
    private int handicap;
    
    private List<Player> playerItems;
    
    private String[] flightArray;
    
    private List<Flight> flightItems;
    
    private boolean edit;
    
    private Tournament tournament;
    
    private Player player;
    
    private TournamentPlayerScorecard tournamentPlayerScorecard;
    
    private PlayerService playerService;
    
    /**
     * Forwards to the add Players to the Tournament Form and Fethces Eligible Players
     *
     * @return outcome
     */
    public String addTournamentPlayer() throws Exception
    {   
    	
    	retrieveEligiblePlayers();
    	
    	retrieveFlights();
    	
    	handicap = 0;
    	
    	setEdit(false);
    	
        return SUCCESS;
    }
    
	/**
     * Saves a player to the tournament
     * @return
     * @throws Exception
     */
    public String saveTournamentPlayer() throws Exception
    {
    	try
		{
    	  	Player selectedPlayer = getSelectedPlayer();
        	
        	List<Flight> selectedFlights = getSelectedFlights();
        	
        	if(isEdit()){
        		tournamentService.updateTournamentPlayer(tournament, selectedPlayer, selectedFlights, handicap, tournamentPlayerScorecard);
        	}else{
        		tournamentService.addTournamentPlayer(tournament, selectedPlayer, selectedFlights, handicap);
        	}
        	
        	addActionMessage("Save Successful");
        	
		} 
    	catch (DogtownSystemValidationException e)
		{
    		addActionError(e.getMessage());
		}
    	
    	
    	return SUCCESS;
    }

	private Player getSelectedPlayer()
	{
    	
    	return player;
	}

	private List<Flight> getSelectedFlights()
	{
		
		List<Flight> flights = new ArrayList<Flight>();
    	
    	for (int i = 0; i < flightArray.length; i++)
		{
			String flightId = flightArray[i];
			
			Flight flight = new Flight();
			flight.setId(Long.parseLong(flightId));
			flights.add(flight);
		}
    	
    	return flights;
	}

	private void retrieveEligiblePlayers() throws Exception
	{
		playerItems = new ArrayList<Player>();
		
	    tournament = (Tournament) session.get("tournament");
	    
	    tournament = tournamentService.retrieveTournamentById(tournament);
		
    	List<Player> players = tournamentService.retrieveEligiblePlayers(tournament);
    	
    	for (Iterator<Player> iterator = players.iterator(); iterator.hasNext();)
		{
			Player player = (Player) iterator.next();
			
			playerItems.add(player);
		}
	}
	
    private void retrieveFlights() throws Exception
	{
		flightItems = new ArrayList<Flight>();
		
    	List<Flight> tournamentFlights = tournamentService.retrieveFlights();
    	
    	for (Iterator<Flight> iterator = tournamentFlights.iterator(); iterator.hasNext();)
		{
			Flight flight = (Flight) iterator.next();
			
			flightItems.add(flight);
		}
	}
    
    public String editPlayerScorecard() throws Exception{
    	
    	player = playerService.retrievePlayerById(getSelectedPlayer());
    	
        retrieveFlights();
    	
    	handicap = 0;
    	
    	setEdit(true);
    	
    	return SUCCESS;
    }


	public boolean isEdit()
	{
		return edit;
	}

	public void setEdit(boolean edit)
	{
		this.edit = edit;
	}

	public int getHandicap()
	{
		return handicap;
	}

	public void setHandicap(int handicap)
	{
		this.handicap = handicap;
	}

	public List<Player> getPlayerItems()
	{
		return playerItems;
	}

	public void setPlayerItems(List<Player> playerItems)
	{
		this.playerItems = playerItems;
	}

	public List<Flight> getFlightItems()
	{
		return flightItems;
	}

	public void setFlightItems(List<Flight> flightItems)
	{
		this.flightItems = flightItems;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public String[] getFlightArray() {
		return flightArray;
	}

	public void setFlightArray(String[] flightArray) {
		this.flightArray = flightArray;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public TournamentPlayerScorecard getTournamentPlayerScorecard() {
		return tournamentPlayerScorecard;
	}

	public void setTournamentPlayerScorecard(
			TournamentPlayerScorecard tournamentPlayerScorecard) {
		this.tournamentPlayerScorecard = tournamentPlayerScorecard;
	}

	public PlayerService getPlayerService() {
		return playerService;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	
}
