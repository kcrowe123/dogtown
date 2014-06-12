package com.dogtown.domain.skinGame.comparator;

import com.dogtown.domain.skinGame.SkinScorecard;


public class HoleEightComparator extends HoleComparator
{

	public int compare(SkinScorecard o1, SkinScorecard o2)
	{
		return getScore(o1.getEigthHole()).compareTo(getScore(o2.getEigthHole()));
	}
	


}
