package com.dogtown.domain.tournament;

import java.util.Comparator;

public class TournamentPlayerScorecardScoreComparator implements Comparator<TournamentPlayerScorecard>
{
	private static double HIGH_NUMBER = 9999;
	
	public int compare(TournamentPlayerScorecard o1, TournamentPlayerScorecard o2)
	{	
		return getScore(o1).compareTo(getScore(o2));
	}

	private Double getScore(TournamentPlayerScorecard scorecard)
	{
		Double score;
		try
		{
			score = new Double(Double.parseDouble(scorecard.getTwoDayHandicapTotal()));
		} 
		catch (Exception e)
		{
			score = new Double(HIGH_NUMBER);
		}
		
		return score;
		
	}

}
