package com.dogtown.integration.skin;

import java.util.List;

import com.dogtown.domain.player.Player;
import com.dogtown.domain.skin.Skins;
import com.dogtown.framework.exception.DogtownSystemException;

public interface SkinDAO
{

	List<Skins> retrieveSkins(List<Skins> skins) throws DogtownSystemException;
	
	public Skins retrieveSkinById(Skins skin)throws DogtownSystemException;
}
