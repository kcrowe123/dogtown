package com.dogtown.integration;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dogtown.domain.PersistentBaseClass;
import com.dogtown.framework.exception.DogtownSystemException;


public abstract class DogtownDAO
{

	
	SessionFactory sessionFactory;
	
	public DogtownDAO()
	{
		//session = HibernateUtil.getSessionFactory().getCurrentSession();
	}
	/**
	 * @return
	 */
	protected Session getSession() 
	{
		return sessionFactory.getCurrentSession();
	}
	
	protected void createEntity(PersistentBaseClass entity) throws DogtownSystemException
	{
		try
		{
			getSession().saveOrUpdate(entity);
		} 
		catch (Exception e)
		{
			throw new DogtownSystemException("Error Creating Entity", e);
		}
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	
	
}

