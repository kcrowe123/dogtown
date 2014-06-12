package com.dogtown.web.actions.player;

import java.util.ArrayList;
import java.util.List;



import com.dogtown.domain.player.Address;
import com.dogtown.domain.player.Player;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.service.player.PlayerService;
import com.opensymphony.xwork2.ActionSupport;


public class PlayerAction extends ActionSupport
{	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Player player;
    
    List<Player> players;
    
    private PlayerService playerService;
    
    private List<Player> checked;
    
    private boolean edit;
	
    /**
     * Retrieves all Players in the Dogtown Invitational
     * 
     * @return
     * @throws DogtownSystemException
     */
	public String loadPlayers() throws Exception
	{	
		checked = new ArrayList<Player>();
		
		players = playerService.retrievePlayers();
		
		
		return SUCCESS;
	}
	
	/**
	 * Adds a Player to the Dogtown Invitationl
	 * 
	 * @return
	 * @throws DogtownSystemException
	 */
	public String savePlayer() throws Exception
	{
		if(isEdit())
		{
			return updatePlayer();
		}
		
		return createPlayer();
	}
	
    /**
     * Update a Player for Dogtown Invitational
     *
     * @return outcome
     */
    private String updatePlayer() throws Exception
    {
    	try
		{
    		playerService.updatePlayer(player);
    		
    		//reset edit mode
    		setEdit(false);

    		
		} 
    	catch (Exception e)
		{
			addActionError("Error: Updating Player");
			
			return ERROR;
		}
    	
    	return SUCCESS;
    }


	/**
	 * Creates a Player for Dogtown Invitationl
	 * 
	 * @return
	 * @throws DogtownSystemException
	 */
	private String createPlayer() throws Exception
	{
		playerService.createPlayer(player);

		return SUCCESS;
	}
	
	/**
	 * Prepare the playerForm to add a new Player. This gets executed before we prompt
     * the user to add a new Player.
	 * @return
	 */
	public String addNewPlayer()
	{
		player = new Player();
		player.setAddress(new Address());
		
		setEdit(false);
		
		return SUCCESS;
	}
	
    /**
     * Edit the Player. This get executed before the edit playerForm page gets loaded.
     *
     * @return outcome
     */
    public String editPlayer() throws Exception
    {    	
        //player = (Player) playerModel.getRowData();
        player = (Player) playerService.retrievePlayerById(player);
        
        setEdit(true);

        return SUCCESS;
    }
    
    /**
     * Delete Players that are selected for deletion
     *
     * @return
     */
    public String deletePlayer() throws Exception
    {    	
    	try
		{
        	if(checked.size() > 0)
        	{
        		playerService.deletePlayers(checked);
        	}
        	else
        	{
        		addActionError("Error: You must select a Player to Delete.");
        	}
		} 
    	catch (Exception e)
		{
			addActionError("Error: Deleting Player");
		}
    	return SUCCESS;
    }
    
//    public void checkBoxValueChanged(ValueChangeEvent event)
//    {
//    	HtmlSelectBooleanCheckbox checkbox = (HtmlSelectBooleanCheckbox)event.getComponent();
//    	
//    	player = (Player)playerModel.getRowData();
//    	
//    	if(checkbox.isSelected())
//    	{
//    		checked.add(player);
//    	}
//    	else
//    	{
//    		checked.remove(player);
//    	}
//    }
	
	public Player getPlayer()
	{
		return player;
	}


	public void setPlayer(Player player)
	{
		this.player = player;
	}


	public boolean isEdit()
	{
		return edit;
	}

	public void setEdit(boolean edit)
	{
		this.edit = edit;
	}

	public void setPlayerService(PlayerService playerService) {
		this.playerService = playerService;
	}

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}
	
	
}
