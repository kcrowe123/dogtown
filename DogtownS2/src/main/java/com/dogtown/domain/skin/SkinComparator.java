package com.dogtown.domain.skin;

import java.util.Comparator;

public class SkinComparator implements Comparator<Skins>
{
	public int compare(Skins o1, Skins o2)
	{	
		return o1.getName().compareTo(o2.getName());
	}

}
