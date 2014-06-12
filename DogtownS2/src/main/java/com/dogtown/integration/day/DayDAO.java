package com.dogtown.integration.day;

import com.dogtown.domain.day.Day;
import com.dogtown.framework.exception.DogtownSystemException;

public interface DayDAO
{

	public Day retrieveDayById(Day day) throws DogtownSystemException;

}
