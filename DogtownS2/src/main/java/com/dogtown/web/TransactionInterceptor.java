package com.dogtown.web;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;
import org.hibernate.StaleObjectStateException;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class TransactionInterceptor implements Interceptor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Logger log = Logger.getLogger(TransactionInterceptor.class);
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		
			UserTransaction tx = null;
			String location = "";
			try
			{
				log.debug("Starting a database transaction");
				
				tx = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
				
				beginTransaction(tx);
				
				// Call the next filter (continue request processing)
				location = invocation.invoke();
				
				closeTransaction(tx);
		
			} 
			catch (StaleObjectStateException staleEx)
			{
				log.debug("This interceptor does not implement optimistic concurrency control!");
				log.debug("Your application will not work until you add compensation actions!");
				// Rollback, close everything, possibly compensate for any permanent
				// changes
				// during the conversation, and finally restart business
				// conversation. Maybe
				// give the user of the application a chance to merge some of his
				// work with
				// fresh data... what you do here depends on your applications
				// design.
				throw staleEx;
			} catch (Throwable ex)
			{
				// Rollback only
				ex.printStackTrace();
				
				rollbackTransaction(tx);
		
				// Let others handle it... maybe another interceptor for exceptions?
				throw new ServletException(ex);
			}
		return location;
	
		}
	
	/**
	 * 
	 */
	private void beginTransaction(UserTransaction tx) throws ServletException
	{
		try 
		{				
			log.debug("Beginning Hibernate Transaction");
			
			tx.begin();
		} 
		catch (Exception e) 
		{
			String message = "Problem trying to begin Hibernate Transaction";
			log.debug(message);
			throw new ServletException(message, e);
		}
	}
	
	/**
	 * 
	 */
	private void closeTransaction(UserTransaction tx) throws ServletException
	{
		try 
		{
			log.debug("Commiting Hibernate Transaction");
			
			tx.commit();
		} 
		catch (Exception e) 
		{	
			String message = "Problem Committing Hibernate Transaction";
			log.debug(message);
			e.printStackTrace();
			throw new ServletException(message, e);
		}
				
	}
	
	/**
	 * 
	 */
	private void rollbackTransaction(UserTransaction tx) throws ServletException
	{
		try 
		{
			log.debug("Rollingback Hibernate Transaction");
			
			tx.rollback();
		} 
		catch (Exception e) 
		{
			String message = "Problem Rollingback Hibernate Transaction";
			log.debug(message, e);
			throw new ServletException(message, e);
		}
	}

}
