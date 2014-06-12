package com.dogtown.domain.scorecard;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.swing.plaf.SliderUI;

import com.dogtown.domain.PersistentBaseClass;
import com.dogtown.domain.day.Day;
import com.dogtown.domain.flight.Flight;
import com.dogtown.domain.player.Player;
import com.dogtown.domain.skin.Skins;

/**
 * Represents a Scorecard
 * 
 * @author Z900247
 * 
 * @hibernate.class  table="scorecard"
 */
public class Scorecard extends PersistentBaseClass
{
	public static final String DISQUALIFIED = "DQ";
	
	private int handicap;
	private int firstHole;
	private int secondHole;
	private int thirdHole;
	private int fourthHole;
	private int fifthHole;
	private int sixthHole;
	private int seventhHole;
	private int eigthHole;
	private int ninthHole;
	private int tenthHole;
	private int eleventhHole;
	private int twelthHole;
	private int thirteenthHole;
	private int fourteenthHole;
	private int fifteenthHole;
	private int sixteenthHole;
	private int seventeenthHole;
	private int eighteenthHole;
	private Day day;
	private Player player;
	private Set flights;
	private Set skins;

	
	
	public Scorecard()
	{
		
	}
	
	public Scorecard(int handicap)
	{
		this.handicap = handicap;
	}
	
	/**
	 * The getter method for this Scorecard's identifier.
	 * 
	 * @hibernate.id column = "SCORECARD_ID" generator-class="native"
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * The getter method for this Scorecards Hanicap
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "HANDICAP"
	 */
	public int getHandicap()
	{
		return handicap;
	}

	public void setHandicap(int handicap)
	{
		this.handicap = handicap;
	}
	
	/**
	 * The getter method for this First Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "FIRST_HOLE"
	 */
	public int getFirstHole()
	{
		return firstHole;
	}

	public void setFirstHole(int firstHole)
	{
		this.firstHole = firstHole;
	}
	
	/**
	 * The getter method for this Second Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "SECOND_HOLE"
	 */
	public int getSecondHole()
	{
		return secondHole;
	}
	
	public void setSecondHole(int secondHole)
	{
		this.secondHole = secondHole;
	}
	
	/**
	 * The getter method for this Third Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "THIRD_HOLE"
	 */
	public int getThirdHole()
	{
		return thirdHole;
	}
	
	public void setThirdHole(int thirdHole)
	{
		this.thirdHole = thirdHole;
	}
	
	/**
	 * The getter method for this Fourth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "FOURTH_HOLE"
	 */
	public int getFourthHole()
	{
		return fourthHole;
	}

	public void setFourthHole(int fourthHole)
	{
		this.fourthHole = fourthHole;
	}
	
	/**
	 * The getter method for this Fifth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "FIFTH_HOLE"
	 */
	public int getFifthHole()
	{
		return fifthHole;
	}

	public void setFifthHole(int fifthHole)
	{
		this.fifthHole = fifthHole;
	}
	
	/**
	 * The getter method for this Sixth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "SIXTH_HOLE"
	 */
	public int getSixthHole()
	{
		return sixthHole;
	}

	public void setSixthHole(int sixthHole)
	{
		this.sixthHole = sixthHole;
	}
	
	/**
	 * The getter method for this Seventh Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "SEVENTH_HOLE"
	 */
	public int getSeventhHole()
	{
		return seventhHole;
	}

	public void setSeventhHole(int seventhHole)
	{
		this.seventhHole = seventhHole;
	}
	
	/**
	 * The getter method for this Eighth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "EIGHTH_HOLE"
	 */
	public int getEigthHole()
	{
		return eigthHole;
	}

	public void setEigthHole(int eigthHole)
	{
		this.eigthHole = eigthHole;
	}
	
	/**
	 * The getter method for this Ninth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "NINTH_HOLE"
	 */
	public int getNinthHole()
	{
		return ninthHole;
	}

	public void setNinthHole(int ninthHole)
	{
		this.ninthHole = ninthHole;
	}
	
	/**
	 * The getter method for this Tenth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "TENTH_HOLE"
	 */
	public int getTenthHole()
	{
		return tenthHole;
	}

	public void setTenthHole(int tenthHole)
	{
		this.tenthHole = tenthHole;
	}
	
	/**
	 * The getter method for this Eleventh Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "ELEVENTH_HOLE"
	 */
	public int getEleventhHole()
	{
		return eleventhHole;
	}

	public void setEleventhHole(int eleventhHole)
	{
		this.eleventhHole = eleventhHole;
	}
	
	/**
	 * The getter method for this Twelth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "TWELTH_HOLE"
	 */
	public int getTwelthHole()
	{
		return twelthHole;
	}

	public void setTwelthHole(int twelthHole)
	{
		this.twelthHole = twelthHole;
	}
	
	/**
	 * The getter method for this Thirteenth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "THIRTEENTH_HOLE"
	 */
	public int getThirteenthHole()
	{
		return thirteenthHole;
	}

	public void setThirteenthHole(int thirteenthHole)
	{
		this.thirteenthHole = thirteenthHole;
	}
	
	/**
	 * The getter method for this Fourteenth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "FOURTEENTH_HOLE"
	 */
	public int getFourteenthHole()
	{
		return fourteenthHole;
	}

	public void setFourteenthHole(int fourteenthHole)
	{
		this.fourteenthHole = fourteenthHole;
	}
	
	/**
	 * The getter method for this Fifteenth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "FIFTEENTH_HOLE"
	 */
	public int getFifteenthHole()
	{
		return fifteenthHole;
	}

	public void setFifteenthHole(int fifteenthHole)
	{
		this.fifteenthHole = fifteenthHole;
	}
	
	/**
	 * The getter method for this Sixteenth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "SIXTEENTH_HOLE"
	 */
	public int getSixteenthHole()
	{
		return sixteenthHole;
	}

	public void setSixteenthHole(int sixteenthHole)
	{
		this.sixteenthHole = sixteenthHole;
	}
	
	/**
	 * The getter method for this Seventeenth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "SEVENTEENTH_HOLE"
	 */
	public int getSeventeenthHole()
	{
		return seventeenthHole;
	}

	public void setSeventeenthHole(int seventeenthHole)
	{
		this.seventeenthHole = seventeenthHole;
	}
	
	/**
	 * The getter method for this Eightteenth Hole
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "EIGHTEENTH_HOLE"
	 */
	public int getEighteenthHole()
	{
		return eighteenthHole;
	}

	public void setEighteenthHole(int eighteenthHole)
	{
		this.eighteenthHole = eighteenthHole;
	}
	
	/**
	 * Returns the day.
	 * 
	 * @return
	 * @hibernate.many-to-one
	 *  column="DAY_ID"
	 *  not-null="true"
	 * @hibernate.column
	 *  name="DAY_ID"
	 *  not-null="true"
	 */
	public Day getDay()
	{
		return day;
	}

	public void setDay(Day day)
	{
		this.day = day;
	}
	
	/**
	 * Returns the player.
	 * 
	 * @return
	 * @hibernate.many-to-one
	 *  column="PLAYER_ID"
	 *  not-null="true"
	 * @hibernate.column
	 *  name="PLAYER_ID"
	 *  not-null="true"
	 */
	public Player getPlayer()
	{
		return player;
	}

	public void setPlayer(Player player)
	{
		this.player = player;
	}
	
	/**
	 * @return
	 * @hibernate.set
	 * table="FLIGHT_SCORECARD"
	 * lazy="false"
	 * @hibernate.collection-key
	 * column="SCORECARD_ID"
	 * @hibernate.collection-many-to-many
	 * column="FLIGHT_ID"
	 * class="com.dogtown.domain.flight.Flight"
	 */
	public Set getFlights()
	{
		if(flights == null)
		{
			flights = new HashSet();
		}
		
		return flights;
	}

	public void setFlights(Set flights)
	{
		this.flights = flights;
	}
	
	/**
	 * @return
	 * @hibernate.set
	 * table="SKIN_SCORECARD"
	 * lazy="true"
	 * @hibernate.collection-key
	 * column="SCORECARD_ID"
	 * @hibernate.collection-many-to-many
	 * column="SKIN_ID"
	 * class="com.dogtown.domain.skin.Skins"
	 */
	public Set getSkins()
	{
		if(skins == null)
		{
			skins = new HashSet();
		}
		
		return skins;
	}

	public void setSkins(Set skins)
	{
		this.skins = skins;
	}
	
	public void addSkin(Skins skin)
	{
		getSkins().add(skin);
	}
	
	public String getScorecardSkinsGames()
	{	
		String skinGames = "";
		
		for (Iterator iterator = getSkins().iterator(); iterator.hasNext();)
		{
			Skins skin = (Skins) iterator.next();
			
			skinGames = skinGames + (skin.getName() + ", ");
		}
		
		if(skinGames != null && skinGames.length() > 0)
		{
			skinGames = skinGames.substring(0, skinGames.length() - 2);
		}
		System.out.println("******************** getScorecardSkinsGames() "+System.getProperty("java.version"));
		return skinGames;
	}
	
	public String getScorecardFlights()
	{	
		String flights = "";
		
		for (Iterator iterator = getFlights().iterator(); iterator.hasNext();)
		{
			Flight flight = (Flight) iterator.next();
			
			flights = flights + (flight.getName() + ", ");
		}
		
		if(flights != null && flights.length() > 0)
		{
			flights = flights.substring(0, flights.length() - 2);
		}
		
		System.out.println("******************** getScorecardFlights() "+System.getProperty("java.version"));
		
		return flights;
	}
	
	public String getScore()
	{
		double total = 0;
		
		if(isDisqualified())
		{
			return DISQUALIFIED;
		}
		
		return firstHole
			+ secondHole
			+ thirdHole 
			+ fourthHole
			+ fifthHole
			+ sixthHole
			+ seventhHole
			+ eigthHole
			+ ninthHole
			+ tenthHole
			+ eleventhHole
			+ twelthHole
			+ thirteenthHole
			+ fourteenthHole
			+ fifteenthHole
			+ sixteenthHole
			+ seventeenthHole
			+ eighteenthHole
			+"";
	}
	
	private boolean isDisqualified()
	{
		if(firstHole < 1)
		{
			return true;
		}
		else if(secondHole < 1)
		{
			return true;
		}
		else if(thirdHole < 1)
		{
			return true;
		}
		else if(fourthHole < 1)
		{
			return true;
		}
		else if(fifthHole < 1)
		{
			return true;
		}
		else if(sixthHole < 1)
		{
			return true;
		}
		else if(seventhHole < 1)
		{
			return true;
		}
		else if(eigthHole < 1)
		{
			return true;
		}
		else if(ninthHole < 1)
		{
			return true;
		}
		else if(tenthHole < 1)
		{
			return true;
		}
		else if(eleventhHole < 1)
		{
			return true;
		}
		else if(twelthHole < 1)
		{
			return true;
		}
		else if(thirteenthHole < 1)
		{
			return true;
		}
		else if(fourteenthHole < 1)
		{
			return true;
		}
		else if(fifteenthHole < 1)
		{
			return true;
		}
		else if(sixteenthHole < 1)
		{
			return true;
		}
		else if(seventeenthHole < 1)
		{
			return true;
		}
		else if(eighteenthHole < 1)
		{
			return true;
		}
		
		return false;
	}
	

	public String getHandicapScore()
	{
		if(DISQUALIFIED.equals(getScore()))
		{
			return DISQUALIFIED;
		}
		
		double total = Double.parseDouble(getScore());
		
		double handicap = this.handicap;
		
		Double handicapScore = new Double(total - (handicap / 2));
		
		return handicapScore.toString();
	}

}
