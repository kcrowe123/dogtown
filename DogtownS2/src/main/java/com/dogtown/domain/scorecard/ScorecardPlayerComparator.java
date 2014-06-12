package com.dogtown.domain.scorecard;

import java.util.Comparator;

public class ScorecardPlayerComparator implements Comparator
{

	public int compare(Object o1, Object o2)
	{
		Scorecard scorecard1 = (Scorecard)o1;
		Scorecard scorecard2 = (Scorecard)o2;
		
		String fullName1 = scorecard1.getPlayer().getFullName();
		String fullName2 = scorecard2.getPlayer().getFullName();
		
		return fullName1.compareTo(fullName2);
	}

}
