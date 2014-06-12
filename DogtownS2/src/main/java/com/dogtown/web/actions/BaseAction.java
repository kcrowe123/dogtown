package com.dogtown.web.actions;


import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;

import com.dogtown.domain.tournament.Tournament;
import com.dogtown.service.tournament.TournamentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;


public class BaseAction extends ActionSupport implements SessionAware
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Tournament> tournaments;
	
	protected Map<String, Object> session;
	
	protected TournamentService tournamentService;
	
	@Override
	public void setSession(Map<String, Object> session) {
		this.session= session;
		
	}	
	
	protected HttpSession getHttpSession(){
		return ServletActionContext.getRequest().getSession();
	}

    /**
     * Retrieves all Dogtown Invitational Tournaments
     * 
     * @return
     * @throws Exception
     */
	public String loadTournaments() throws Exception
	{		
		tournaments = tournamentService.retrieveTournaments();

		return SUCCESS;
	}

	public List<Tournament> getTournaments() {
		return tournaments;
	}

	public void setTournaments(List<Tournament> tournaments) {
		this.tournaments = tournaments;
	}

	public TournamentService getTournamentService() {
		return tournamentService;
	}

	public void setTournamentService(TournamentService tournamentService) {
		this.tournamentService = tournamentService;
	}
	
    protected Map<String, Object> getRequestParams(){
    	return ActionContext.getContext().getParameters();
    }
	
	
	
}
