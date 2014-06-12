package com.dogtown.integration.scorecard;

import com.dogtown.domain.scorecard.Scorecard;
import com.dogtown.framework.exception.DogtownSystemException;

public interface ScorecardDAO
{

	Scorecard getScorecardById(Scorecard scorecard) throws DogtownSystemException;
	
	//void save(Scorecard updatedScorecard) throws DogtownSystemException;

}
