package com.dogtown.domain.player;

public class Address
{
	private String street;
	private String city;
	private String state;
	private String zipCode;

	public Address()
	{

	}
	
	public Address(String street, String city, String state, String zipCode)
	{
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
	}

	public String getMailingAddress()
	{
		return street + " " + city + ", " + state + " " + zipCode;
	}


	/**
	 * The getter method for this Player's street
	 * 
	 * @return street
	 * 
	 * @hibernate.property column = "STREET"
	 */
	public String getStreet()
	{
		return street;
	}

	public void setStreet(String street)
	{
		this.street = street;
	}

	/**
	 * The getter method for this Player's city
	 * 
	 * @return city
	 * 
	 * @hibernate.property column = "CITY"
	 */
	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	/**
	 * The getter method for this Player's state
	 * 
	 * @return state
	 * 
	 * @hibernate.property column = "STATE"
	 */
	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	/**
	 * The getter method for this Player's zipCode
	 * 
	 * @return zipCode
	 * 
	 * @hibernate.property column = "ZIP_CODE"
	 */

	public String getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(String zip)
	{
		this.zipCode = zip;
	}
}
