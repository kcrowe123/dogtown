package com.dogtown.domain.player;

import java.util.Date;
import java.util.Set;

import com.dogtown.domain.PersistentBaseClass;
import com.dogtown.domain.scorecard.Scorecard;

/**
 * Represents a Player
 * 
 * @author Z900247
 * 
 * @hibernate.class  table="player"
 */
public class Player extends PersistentBaseClass
{
	private String firstName;
	private String lastName;
	private String suffix;
	private Address address;
	private String phoneNumber;
	private String emailAddress;
	private Date dateOfBirth;
	private Set scorecards;

	public Player()
	{

	}

	public Player(String firstName, String lastName, String suffix,
			Address address, String phoneNumber, String emailAddress)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.suffix = suffix;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.emailAddress = emailAddress;
	}
	
	/**
	 * The getter method for this Player's identifier.
	 * 
	 * @hibernate.id column = "PLAYER_ID" generator-class="native"
	 */
	public long getId()
	{
		return id;
	}

	/**
	 * The getter method for this Player's firstName
	 * 
	 * @return firstName
	 * 
	 * @hibernate.property column = "FIRST_NAME"
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * The setter method for this Player's firstName
	 */
	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	/**
	 * The getter method for this Player's lastName
	 * 
	 * @return lastName
	 * 
	 * @hibernate.property column = "LAST_NAME"
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * The setter method for this Player's lastName
	 */
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	/**
	 * The getter method for this Player's suffix
	 * 
	 * @return suffix
	 * 
	 * @hibernate.property column = "SUFFIX"
	 */
	public String getSuffix()
	{
		return suffix;
	}

	/**
	 * The setter method for this Player's suffix
	 */
	public void setSuffix(String suffix)
	{
		this.suffix = suffix;
	}

	/**
	 * The getter method for this Player's address
	 * 
	 * @return address
	 * 
	 * @hibernate.component class = com.dogtown.domain.player.Address
	 */
	public Address getAddress()
	{
		return address;
	}

	/**
	 * The setter method for this Player's address
	 */
	public void setAddress(Address address)
	{
		this.address = address;
	}

	/**
	 * The getter method for this Player's phoneNumber
	 * 
	 * @return phoneNumber
	 * 
	 * @hibernate.property column = "PHONE_NUMBER"
	 */
	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	/**
	 * The setter method for this Player's phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	/**
	 * The getter method for this Player's emailAddress
	 * 
	 * @return emailAddress
	 * 
	 * @hibernate.property column = "EMAIL_ADDRESS"
	 */
	public String getEmailAddress()
	{
		return emailAddress;
	}

	/**
	 * The setter method for this Player's emailAddress
	 */
	public void setEmailAddress(String emailAddress)
	{
		this.emailAddress = emailAddress;
	}

	/**
	 * The getter method for this Player's dateOfBirth
	 * 
	 * @return dateOfBirth
	 * 
	 * @hibernate.property column = "DATE_OF_BIRTH"
	 */
	public Date getDateOfBirth()
	{
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
	}
	
	/**
	 * @hibernate.set 
	 *  inverse="true" 
	 *  cascade="all" 
	 *  lazy="true"
	 * @hibernate.collection-key 
	 * 	column="PLAYER_ID" not-null="true"
	 * @hibernate.collection-one-to-many 
	 * 	class="com.dogtown.domain.scorecard.Scorecard"
	 */
	public Set getScorecards()
	{
		return scorecards;
	}

	public void setScorecards(Set scorecards)
	{
		this.scorecards = scorecards;
	}
	
	public void addScorecard(Scorecard scorecard)
	{	
		scorecard.setPlayer(this);
		scorecards.add(scorecard);
		
	}

	public String getFullName()
	{
		StringBuffer fullName = new StringBuffer();
		
		fullName.append(lastName);

		if (suffix != null && suffix.length() > 0)
		{
			fullName.append(" "); 
			fullName.append(suffix);
		}
		
		fullName.append(", ");
		fullName.append(firstName);

		return fullName.toString();
	}

	public boolean equals(Object obj)
	{
		Player player = (Player) obj;
		
		return this.getId() == player.getId() && this.getFullName().equals(player.getFullName());
	}

	public String toString()
	{
		return this.getFullName();
	}
	
	



}
