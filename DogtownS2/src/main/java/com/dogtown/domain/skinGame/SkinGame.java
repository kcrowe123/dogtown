package com.dogtown.domain.skinGame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.dogtown.domain.scorecard.Scorecard;
import com.dogtown.domain.skin.Skins;
import com.dogtown.domain.skinGame.comparator.HoleEightComparator;
import com.dogtown.domain.skinGame.comparator.HoleEighteenComparator;
import com.dogtown.domain.skinGame.comparator.HoleElevenComparator;
import com.dogtown.domain.skinGame.comparator.HoleFifteenComparator;
import com.dogtown.domain.skinGame.comparator.HoleFiveComparator;
import com.dogtown.domain.skinGame.comparator.HoleFourComparator;
import com.dogtown.domain.skinGame.comparator.HoleFourteenComparator;
import com.dogtown.domain.skinGame.comparator.HoleNineComparator;
import com.dogtown.domain.skinGame.comparator.HoleOneComparator;
import com.dogtown.domain.skinGame.comparator.HoleSevenComparator;
import com.dogtown.domain.skinGame.comparator.HoleSeventeenComparator;
import com.dogtown.domain.skinGame.comparator.HoleSixComparator;
import com.dogtown.domain.skinGame.comparator.HoleSixteenComparator;
import com.dogtown.domain.skinGame.comparator.HoleTenComparator;
import com.dogtown.domain.skinGame.comparator.HoleThirteenComparator;
import com.dogtown.domain.skinGame.comparator.HoleThreeComparator;
import com.dogtown.domain.skinGame.comparator.HoleTwelveComparator;
import com.dogtown.domain.skinGame.comparator.HoleTwoComparator;

public class SkinGame
{
	private Skins skin;
	
	private int skinsOut;
	
	private List<SkinScorecard> skinScorecards;
	
	public SkinGame(Skins skin)
	{
		this.skin = skin;
		
		skinScorecards = new ArrayList<SkinScorecard>();
		
		if(skin.getScorecards().size() > 1)
		{
			for (Iterator<Scorecard> iterator = skin.getScorecards().iterator(); iterator.hasNext();)
			{
				Scorecard scorecard = (Scorecard) iterator.next();
				
				skinScorecards.add(new SkinScorecard(scorecard));
			}
			
			processScorecards();
		}
	}
	
	private void processScorecards()
	{
		processHoleOne();
		processHoleTwo();
		processHoleThree();
		processHoleFour();
		processHoleFive();
		processHoleSix();
		processHoleSeven();
		processHoleEight();
		processHoleNine();
		processHoleTen();
		processHoleEleven();
		processHoleTwelve();
		processHoleThirteen();
		processHoleFourteen();
		processHoleFifteen();
		processHoleSixteen();
		processHoleSeventeen();
		processHoleEighteen();
		
	}
	
	private void processHoleOne()
	{
		Collections.sort(skinScorecards, new HoleOneComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getFirstHole();
		Hole scorecard2 = (skinScorecards.get(1)).getFirstHole();
		
		setSkin(scorecard1, scorecard2);		
	}
	
	private void processHoleTwo()
	{
		Collections.sort(skinScorecards, new HoleTwoComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getSecondHole();
		Hole scorecard2 = (skinScorecards.get(1)).getSecondHole();
		
		setSkin(scorecard1, scorecard2);		
	}
	
	private void processHoleThree()
	{
		Collections.sort(skinScorecards, new HoleThreeComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getThirdHole();
		Hole scorecard2 = (skinScorecards.get(1)).getThirdHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleFour()
	{
		Collections.sort(skinScorecards, new HoleFourComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getFourthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getFourthHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleFive()
	{
		Collections.sort(skinScorecards, new HoleFiveComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getFifthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getFifthHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleSix()
	{
		Collections.sort(skinScorecards, new HoleSixComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getSixthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getSixthHole();
		
		setSkin(scorecard1, scorecard2);	
		
	}
	
	private void processHoleSeven()
	{
		Collections.sort(skinScorecards, new HoleSevenComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getSeventhHole();
		Hole scorecard2 = (skinScorecards.get(1)).getSeventhHole();
		
		setSkin(scorecard1, scorecard2);	
		
	}
	
	private void processHoleEight()
	{
		Collections.sort(skinScorecards, new HoleEightComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getEigthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getEigthHole();
		
		setSkin(scorecard1, scorecard2);		
	}
	
	private void processHoleNine()
	{
		Collections.sort(skinScorecards, new HoleNineComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getNinthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getNinthHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleTen()
	{
		Collections.sort(skinScorecards, new HoleTenComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getTenthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getTenthHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleEleven()
	{
		Collections.sort(skinScorecards, new HoleElevenComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getEleventhHole();
		Hole scorecard2 = (skinScorecards.get(1)).getEleventhHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleTwelve()
	{
		Collections.sort(skinScorecards, new HoleTwelveComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getTwelthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getTwelthHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleThirteen()
	{
		Collections.sort(skinScorecards, new HoleThirteenComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getThirteenthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getThirteenthHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleFourteen()
	{
		Collections.sort(skinScorecards, new HoleFourteenComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getFourteenthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getFourteenthHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleFifteen()
	{
		Collections.sort(skinScorecards, new HoleFifteenComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getFifteenthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getFifteenthHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleSixteen()
	{
		Collections.sort(skinScorecards, new HoleSixteenComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getSixteenthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getSixteenthHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleSeventeen()
	{
		Collections.sort(skinScorecards, new HoleSeventeenComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getSeventeenthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getSeventeenthHole();
		
		setSkin(scorecard1, scorecard2);	
	}
	
	private void processHoleEighteen()
	{
		Collections.sort(skinScorecards, new HoleEighteenComparator());
		
		Hole scorecard1 = (skinScorecards.get(0)).getEighteenthHole();
		Hole scorecard2 = (skinScorecards.get(1)).getEighteenthHole();
		
		setSkin(scorecard1, scorecard2);	
	}

	private void setSkin(Hole scorecard1, Hole scorecard2)
	{
		if(scorecard1.getScore() < scorecard2.getScore())
		{
			scorecard1.setSkin(true);
			skinsOut++;
		}
		
	}
	
	public String getTotalPlayers()
	{
		return skinScorecards.size() + "";
	}

	public Skins getSkin()
	{
		return skin;
	}

	public void setSkin(Skins skin)
	{
		this.skin = skin;
	}

	public int getSkinsOut()
	{
		return skinsOut;
	}

	public void setSkinsOut(int skinsOut)
	{
		this.skinsOut = skinsOut;
	}
	
	public List<SkinScorecard> getSkinScorecards()
	{
		return skinScorecards;
	}

	public void setSkinScorecards(List<SkinScorecard> skinScorecards)
	{
		this.skinScorecards = skinScorecards;
	}
}
