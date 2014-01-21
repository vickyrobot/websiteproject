package com.adaptavant.taxi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Serve extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req,HttpServletResponse resp) throws IOException
    {// used to response ajax request
		try
		{
			PersistenceManagerFactory pmf=PMF.get();
			PersistenceManager pm = pmf. getPersistenceManager();
			
			 PrintWriter out = resp.getWriter();
			 
			String newmail=req.getParameter("mail");
			
			Query q = pm.newQuery(Details.class);
			
			q.setFilter("email == emailParam");
			
			q.declareParameters("String emailParam");
			
			List<Details> results = (List<Details>) q.execute(newmail);
			Iterator<Details> itr=results.iterator();
			
			if(itr.hasNext())
			{
				out.print(true);
			}
			else
			{
				out.print(false);

			}
			System.out.println(results);
       }
		catch(Exception e)
		
		{
			
		}

}
}