package com.dogtown.domain.day;

import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.dogtown.domain.PersistentBaseClass;
import com.dogtown.domain.player.Player;
import com.dogtown.domain.scorecard.Scorecard;
import com.dogtown.domain.skin.Skins;
import com.dogtown.domain.tournament.Tournament;
import com.dogtown.framework.date.DateUtil;

/**
 * Represents a Tournament Day
 * 
 * @author Z900247
 *
 * @hibernate.class  table="day"
 */
public class Day extends PersistentBaseClass
{
	private Tournament tournament;
	
	private Date date;
	
	private String course;
	
	private Set<Scorecard> scorecards;
	
	private Set<Skins> skins;
	
	public Day()
	{
		
	}
	
	/**
	 * The getter method for this Days's identifier.
	 * 
	 * @hibernate.id column = "DAY_ID" generator-class="native"
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * Returns the tournament.
	 * 
	 * @return
	 * @hibernate.many-to-one
	 *  column="TOURNAMENT_ID"
	 *  not-null="true"
	 *  insert="false" 
	 *  update="false"
	 * @hibernate.column
	 *  name="TOURNAMENT_ID"
	 *  not-null="true"
	 */
	public Tournament getTournament()
	{
		return tournament;
	}

	public void setTournament(Tournament tournament)
	{
		this.tournament = tournament;
	}
	
	/**
	 * The getter method for this Days date
	 * 
	 * @return date
	 * 
	 * @hibernate.property column = "DATE"
	 */
	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}
	
	/**
	 * The getter method for this Days Course Name
	 * 
	 * @return course
	 * 
	 * @hibernate.property column = "COURSE_NAME"
	 */
	public String getCourse()
	{
		return course;
	}

	public void setCourse(String course)
	{
		this.course = course;
	}
	
	/**
	 * @hibernate.set 
	 *  inverse="true" 
	 *  cascade="all-delete-orphan" 
	 *  lazy="true"
	 * @hibernate.collection-key 
	 * 	column="DAY_ID" not-null="true"
	 * @hibernate.collection-one-to-many 
	 * 	class="com.dogtown.domain.scorecard.Scorecard"
	 */
	public Set<Scorecard> getScorecards()
	{
		return scorecards;
	}

	public void setScorecards(Set<Scorecard> scorecards)
	{
		this.scorecards = scorecards;
	}
	
	public void addScorecard(Scorecard scorecard)
	{		
		scorecard.setDay(this);
		scorecards.add(scorecard);
	}
	
	/**
	 * @hibernate.set 
	 *  inverse="true" 
	 *  cascade="all-delete-orphan" 
	 *  lazy="true"
	 * @hibernate.collection-key 
	 * 	column="DAY_ID" not-null="true"
	 * @hibernate.collection-one-to-many 
	 * 	class="com.dogtown.domain.skin.Skins"
	 */
	public Set<Skins> getSkins()
	{
		if(skins == null)
		{
			skins = new HashSet<Skins>();
		}
		
		return skins;
	}

	public void setSkins(Set<Skins> skins)
	{
		this.skins = skins;
	}

	public Scorecard getPlayerScorecard(Player player)
	{
		if(scorecards != null && !scorecards.isEmpty())
		{
			for (Iterator<Scorecard> iterator = scorecards.iterator(); iterator.hasNext();)
			{
				Scorecard scorecard = (Scorecard) iterator.next();
				
				if(scorecard.getPlayer().equals(player))
				{
					return scorecard;
				}
			}
		}
		
		return null;
	}
	
	public String toString()
	{
		return DateUtil.toString(date) + " " + course;
	}


}
