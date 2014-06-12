package com.dogtown.web;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.transaction.UserTransaction;

import org.apache.log4j.Logger;
import org.hibernate.StaleObjectStateException;

import com.dogtown.framework.hibernate.HibernateUtil;

public class HibernateSessionRequestFilter implements Filter
{
	static Logger log = Logger.getLogger(HibernateSessionRequestFilter.class);

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException
	{
		UserTransaction tx = null;
		
		try
		{
			log.debug("Starting a database transaction");
			
			tx = (UserTransaction)new InitialContext().lookup("java:comp/UserTransaction");
			
			beginTransaction(tx);
			
			// Call the next filter (continue request processing)
			chain.doFilter(request, response);
			
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
	
	public void init(FilterConfig filterConfig) throws ServletException
	{
		log.debug("Initializing filter...");
		log.debug("Obtaining SessionFactory from static HibernateUtil singleton");
		//HibernateUtil.getSessionFactory();
	}
	
	

	public void destroy()
	{
	}

}
