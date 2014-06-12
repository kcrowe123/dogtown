package com.dogtown.domain.skinGame.comparator;

import com.dogtown.domain.skinGame.SkinScorecard;


public class HoleFiveComparator extends HoleComparator
{

	public int compare(SkinScorecard o1, SkinScorecard o2)
	{
		return getScore(o1.getFifthHole()).compareTo(getScore(o2.getFifthHole()));
	}
	


}
