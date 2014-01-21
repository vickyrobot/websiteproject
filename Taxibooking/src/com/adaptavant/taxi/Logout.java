package com.adaptavant.taxi;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

public class Logout extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	 public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	 {
		try{
             HttpSession sess=req.getSession(false);
		     System.out.println("logout start");
		   /* if( sess.getAttribute("details")!=null)
		      {*/
			      System.out.println(sess);
                  sess.invalidate();		 
                  Cookie[]cookies=req.getCookies();
			      for(Cookie cookie:cookies)
			        {	
			    	  cookie.setValue("");
			          cookie.setMaxAge(0);
				      resp.addCookie(cookie);
				      System.out.println("out for"+cookie);

			        }
			System.out.println("out end");

			
			resp.sendRedirect("/jsp/Login.jsp");

	 }
		
		
		catch(Exception e)
		{
			
		}
}
	 }
	
	

