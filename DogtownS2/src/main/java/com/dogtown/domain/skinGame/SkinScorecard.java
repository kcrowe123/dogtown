package com.dogtown.domain.skinGame;

import com.dogtown.domain.player.Player;
import com.dogtown.domain.scorecard.Scorecard;

public class SkinScorecard
{
	private Player player;
	
	private Hole firstHole;
	private Hole secondHole;
	private Hole thirdHole;
	private Hole fourthHole;
	private Hole fifthHole;
	private Hole sixthHole;
	private Hole seventhHole;
	private Hole eigthHole;
	private Hole ninthHole;
	private Hole tenthHole;
	private Hole eleventhHole;
	private Hole twelthHole;
	private Hole thirteenthHole;
	private Hole fourteenthHole;
	private Hole fifteenthHole;
	private Hole sixteenthHole;
	private Hole seventeenthHole;
	private Hole eighteenthHole;
	
	public SkinScorecard(Scorecard scorecard)
	{
		player = scorecard.getPlayer();
		
		firstHole = new Hole(scorecard.getFirstHole());
		secondHole = new Hole(scorecard.getSecondHole());
		thirdHole = new Hole(scorecard.getThirdHole());
		fourthHole = new Hole(scorecard.getFourthHole());
		fifthHole = new Hole(scorecard.getFifthHole());
		sixthHole = new Hole(scorecard.getSixthHole());
		seventhHole = new Hole(scorecard.getSeventhHole());
		eigthHole = new Hole(scorecard.getEigthHole());
		ninthHole = new Hole(scorecard.getNinthHole());
		tenthHole = new Hole(scorecard.getTenthHole());
		eleventhHole = new Hole(scorecard.getEleventhHole());
		twelthHole = new Hole(scorecard.getTwelthHole());
		thirteenthHole = new Hole(scorecard.getThirteenthHole());
		fourteenthHole = new Hole(scorecard.getFourteenthHole());
		fifteenthHole = new Hole(scorecard.getFifteenthHole());
		sixteenthHole = new Hole(scorecard.getSixteenthHole());
		seventeenthHole = new Hole(scorecard.getSeventeenthHole());
		eighteenthHole = new Hole(scorecard.getEighteenthHole());
	}
	
	public Player getPlayer()
	{
		return player;
	}
	public void setPlayer(Player player)
	{
		this.player = player;
	}
	public Hole getFirstHole()
	{
		return firstHole;
	}
	public void setFirstHole(Hole firstHole)
	{
		this.firstHole = firstHole;
	}
	public Hole getSecondHole()
	{
		return secondHole;
	}
	public void setSecondHole(Hole secondHole)
	{
		this.secondHole = secondHole;
	}
	public Hole getThirdHole()
	{
		return thirdHole;
	}
	public void setThirdHole(Hole thirdHole)
	{
		this.thirdHole = thirdHole;
	}
	public Hole getFourthHole()
	{
		return fourthHole;
	}
	public void setFourthHole(Hole fourthHole)
	{
		this.fourthHole = fourthHole;
	}
	public Hole getFifthHole()
	{
		return fifthHole;
	}
	public void setFifthHole(Hole fifthHole)
	{
		this.fifthHole = fifthHole;
	}
	public Hole getSixthHole()
	{
		return sixthHole;
	}
	public void setSixthHole(Hole sixthHole)
	{
		this.sixthHole = sixthHole;
	}
	public Hole getSeventhHole()
	{
		return seventhHole;
	}
	public void setSeventhHole(Hole seventhHole)
	{
		this.seventhHole = seventhHole;
	}
	public Hole getEigthHole()
	{
		return eigthHole;
	}
	public void setEigthHole(Hole eigthHole)
	{
		this.eigthHole = eigthHole;
	}
	public Hole getNinthHole()
	{
		return ninthHole;
	}
	public void setNinthHole(Hole ninthHole)
	{
		this.ninthHole = ninthHole;
	}
	public Hole getTenthHole()
	{
		return tenthHole;
	}
	public void setTenthHole(Hole tenthHole)
	{
		this.tenthHole = tenthHole;
	}
	public Hole getEleventhHole()
	{
		return eleventhHole;
	}
	public void setEleventhHole(Hole eleventhHole)
	{
		this.eleventhHole = eleventhHole;
	}
	public Hole getTwelthHole()
	{
		return twelthHole;
	}
	public void setTwelthHole(Hole twelthHole)
	{
		this.twelthHole = twelthHole;
	}
	public Hole getThirteenthHole()
	{
		return thirteenthHole;
	}
	public void setThirteenthHole(Hole thirteenthHole)
	{
		this.thirteenthHole = thirteenthHole;
	}
	public Hole getFourteenthHole()
	{
		return fourteenthHole;
	}
	public void setFourteenthHole(Hole fourteenthHole)
	{
		this.fourteenthHole = fourteenthHole;
	}
	public Hole getFifteenthHole()
	{
		return fifteenthHole;
	}
	public void setFifteenthHole(Hole fifteenthHole)
	{
		this.fifteenthHole = fifteenthHole;
	}
	public Hole getSixteenthHole()
	{
		return sixteenthHole;
	}
	public void setSixteenthHole(Hole sixteenthHole)
	{
		this.sixteenthHole = sixteenthHole;
	}
	public Hole getSeventeenthHole()
	{
		return seventeenthHole;
	}
	public void setSeventeenthHole(Hole seventeenthHole)
	{
		this.seventeenthHole = seventeenthHole;
	}
	public Hole getEighteenthHole()
	{
		return eighteenthHole;
	}
	public void setEighteenthHole(Hole eighteenthHole)
	{
		this.eighteenthHole = eighteenthHole;
	}
}
