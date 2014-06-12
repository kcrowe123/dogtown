package com.dogtown.domain.tournament;

import java.util.Comparator;

public class TournamentPlayerScorecardComparator implements Comparator<TournamentPlayerScorecard>
{

	public int compare(TournamentPlayerScorecard o1, TournamentPlayerScorecard o2)
	{
		String fullName1 = o1.getPlayer().getFullName();
		String fullName2 = o2.getPlayer().getFullName();
		
		return fullName1.compareTo(fullName2);
	}

}
