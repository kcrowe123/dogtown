package com.dogtown.domain.skinGame.comparator;

import java.util.Comparator;

import com.dogtown.domain.skinGame.Hole;
import com.dogtown.domain.skinGame.SkinScorecard;

public abstract class HoleComparator implements Comparator<SkinScorecard>
{
	private static int HIGH_NUMBER = 9999;
	
	public abstract int compare(SkinScorecard o1, SkinScorecard o2);
	
	protected Integer getScore(Hole hole)
	{
		if(hole.getScore() == 0)
		{
			return new Integer(HIGH_NUMBER);
		}
		
		return new Integer(hole.getScore());
	}
}
