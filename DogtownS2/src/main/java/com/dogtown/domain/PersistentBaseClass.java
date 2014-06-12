package com.dogtown.domain;

public abstract class PersistentBaseClass
{
	protected long id;

	abstract public long getId();

	public void setId(long id)
	{
		this.id = id;
	}
}
