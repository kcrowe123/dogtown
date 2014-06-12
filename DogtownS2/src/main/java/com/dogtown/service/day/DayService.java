package com.dogtown.service.day;

import com.dogtown.domain.day.Day;
import com.dogtown.framework.exception.DogtownSystemException;

public interface DayService
{

	public Day retrieveDayById(Day day) throws DogtownSystemException;

}
