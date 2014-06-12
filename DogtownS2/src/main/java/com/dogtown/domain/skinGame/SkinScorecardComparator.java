package com.dogtown.domain.skinGame;

import java.util.Comparator;

public class SkinScorecardComparator implements Comparator<SkinScorecard>
{

	public int compare(SkinScorecard o1, SkinScorecard o2)
	{
		return o1.getPlayer().getFullName().compareTo(o2.getPlayer().getFullName());
	}

}
