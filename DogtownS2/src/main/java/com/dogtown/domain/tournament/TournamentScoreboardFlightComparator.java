package com.dogtown.domain.tournament;

import java.util.Comparator;

public class TournamentScoreboardFlightComparator implements Comparator<TournamentScoreboard>
{
	public int compare(TournamentScoreboard o1, TournamentScoreboard o2)
	{
		
		String flight1 = o1.getFlight().getName();
		String flight2 = o2.getFlight().getName();
		
		return flight1.compareTo(flight2);
	}
}
