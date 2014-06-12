package com.dogtown.service.day;

import com.dogtown.domain.day.Day;
import com.dogtown.framework.exception.DogtownSystemException;
import com.dogtown.integration.day.DayDAO;

public class DayServiceImpl implements DayService
{

	private DayDAO dayDAO;
	
	
	public Day retrieveDayById(Day day) throws DogtownSystemException
	{
		return getDayDAO().retrieveDayById(day);
	}
	
	public DayDAO getDayDAO()
	{
		return dayDAO;
	}

	public void setDayDAO(DayDAO dayDAO) {
		this.dayDAO = dayDAO;
	}

}
