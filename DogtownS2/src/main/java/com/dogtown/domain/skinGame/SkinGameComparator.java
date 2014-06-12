package com.dogtown.domain.skinGame;

import java.util.Comparator;

public class SkinGameComparator implements Comparator<SkinGame>
{

	public int compare(SkinGame o1, SkinGame o2)
	{
		return o1.getSkin().getName().compareTo(o2.getSkin().getName());
	}

}
