package com.dogtown.domain.flight;

import java.util.Set;

import com.dogtown.domain.PersistentBaseClass;

/**
 * Represents a Flight
 * 
 * @author Z900247
 * 
 * @hibernate.class  table="flight"
 */
public class Flight extends PersistentBaseClass
{
	private String name;
	
	private Set scorecards;
	
	public Flight()
	{
		
	}
	
	/**
	 * The getter method for this Flight's identifier.
	 * 
	 * @hibernate.id column = "FLIGHT_ID" generator-class="native"
	 */
	public long getId()
	{
		return id;
	}
	
	/**
	 * @return
	 * @hibernate.property
	 *  column = "FLIGHT_NM"
	 * @hibernate.column
	 *  name="FLIGHT_NM"
	 *  not-null="true"
	 */
	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * @return
	 * @hibernate.set
	 * table="FLIGHT_SCORECARD"
	 * lazy="true"
	 * @hibernate.collection-key
	 * column="FLIGHT_ID"
	 * @hibernate.collection-many-to-many
	 * column="SCORECARD_ID"
	 * class="com.dogtown.domain.scorecard.Scorecard"
	 */
	public Set getScorecards()
	{
		return scorecards;
	}

	public void setScorecards(Set scorecards)
	{
		this.scorecards = scorecards;
	}
	
}
