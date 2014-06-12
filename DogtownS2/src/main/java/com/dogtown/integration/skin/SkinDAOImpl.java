package com.dogtown.integration.skin;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;

import com.dogtown.domain.player.Player;
import com.dogtown.domain.skin.Skins;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.integration.DogtownDAO;
import com.dogtown.integration.player.PlayerDAOImpl;

public class SkinDAOImpl extends DogtownDAO implements SkinDAO
{
	static Logger log = Logger.getLogger(SkinDAOImpl.class);

	public static final String RETRIEVE_SKINS = "retrieveSkins";
	public static final String RETRIEVE_SKIN_BY_ID = "retrieveSkinById";

	public List<Skins> retrieveSkins(List<Skins> skins)throws DogtownSystemException
	{
		List<Skins> retVal = new ArrayList<Skins>();
		
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_SKINS);
			query.setParameterList("skins", skins);
			
			List<Skins> result = (List<Skins>)query.list();
			
			if(result != null)
			{
				retVal.addAll(result);
			}
		} 
		catch (Exception e)
		{
			throw new DogtownSystemException("Error Retrieveing Skins", e);
		}
		
		return retVal;
	}
	
	public Skins retrieveSkinById(Skins skin)throws DogtownSystemException
	{
		try
		{
			Query query = getSession().getNamedQuery(RETRIEVE_SKIN_BY_ID);
			query.setParameter("id", skin.getId());
			
			return (Skins)query.uniqueResult();
		} 
		catch (Exception e)
		{
			String message = "Error Retrieving Skin by Id";
			log.debug(message);
			throw new DogtownSystemException(message, e);
		}	
	}

}
