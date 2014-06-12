package com.dogtown.domain.skinGame;

public class Hole
{
	private int score;
	
	private boolean skin;
	
	public Hole(int score)
	{
		this.score = score;
	}
	
	public boolean getSkin()
	{
		return skin;
	}

	public void setSkin(boolean skin)
	{
		this.skin = skin;
	}

	public int getScore()
	{
		return score;
	}

	public void setScore(int score)
	{
		this.score = score;
	}
	
	
}
