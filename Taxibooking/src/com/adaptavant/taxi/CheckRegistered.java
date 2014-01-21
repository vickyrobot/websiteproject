package com.adaptavant.taxi;

import java.io.IOException;
import java.io.PrintWriter;

import javax.jdo.JDOHelper;
//import javax.jdo.JDOObjectNotFoundException;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.RequestDispatcher;
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import com.google.appengine.api.blobstore.BlobstoreService;
//import com.google.appengine.api.blobstore.BlobstoreServiceFactory;

public class CheckRegistered extends HttpServlet 
{

	HttpSession session; 

  private static final long serialVersionUID = 1L;
//  private static final PersistenceManagerFactory PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");
// DO GET
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
  throws IOException, ServletException
    {
	  
	    PrintWriter out = resp.getWriter();
	    

		     PersistenceManager pm = PMF.get().getPersistenceManager();
		    
		    
            
		     if(req.getParameter("email")=="")
		     {
		     	resp.setContentType("text/html");
		    	out.println("typeSomething Dude");
		    	RequestDispatcher rd=req.getRequestDispatcher("/jsp/Login.jsp");  
		        rd.include(req, resp);
				
		     	 
		     	    	 
		      }
		     	     
		    	 
		     
         else{	 
		       String email = req.getParameter("email");

		    
		
		   	try{
             //validation
		   		
		   		
		   		
		   	 Details e = pm.getObjectById(Details.class, email);
				
				
		       System.out.println(e.getName());
		       System.out.println(e.getEmail());
		       System.out.println(e.getImgurl());
		       System.out.println(e.getPno());
		       
		        if (e.getEmail().equals(req.getParameter("email")))
		          {

			          if (e.getPwd().equals(req.getParameter("pwd")))
			            {
			        	  //rememberMe check box clicked
				          if("remember".equals(req.getParameter("remember")))
				          {
				       
				        	  System.out.println("top check");	
				
				        	  Cookie mail=new Cookie("mail1",email);
			   
				        	  mail.setMaxAge(30*60);
				
				        	  Cookie pssword=new Cookie("p",(req.getParameter("pwd")));
				
				        	  pssword.setMaxAge(30*60);
				
				        	  resp.addCookie(mail);
				
				        	  resp.addCookie(pssword);
				
				
				        	  System.out.println(req.getCookies());
				
				        	  System.out.println("created coook");



				           }//remeberme 
				          
	                      System.out.println("make session");

	                      
    
	                      session=req.getSession(true);
	                  
                          session.setAttribute("details", e);
                          System.out.println("while login"+e.getPno());              		
					     RequestDispatcher rd=req.getRequestDispatcher("/jsp/showDetials.jsp");  
	                       rd.forward(req, resp);
			
			      
	            
			}
			
		    
		    else
		    {
		    	 out.println("wrong password");
			     resp.setContentType("text/html");
		    	 RequestDispatcher rd=req.getRequestDispatcher("/jsp/Login.jsp");  
		         rd.include(req, resp);
		    	
		    }
		    
	
		    }
		    
		    else{
		    	//if email is wrong
		    	 out.println("wrong email");
			     resp.setContentType("text/html");

		    	 RequestDispatcher rd=req.getRequestDispatcher("/jsp/Login.jsp");  
		         rd.include(req, resp);
		    }
		    
}//end of not null check
		   	
			
		catch(Exception e1)
		{
			
			    	 out.println("no such  user/email<br>");
				     resp.setContentType("text/html");

					RequestDispatcher rd=req.getRequestDispatcher("/jsp/Login.jsp");  
			        rd.include(req, resp);
					System.out.println("------exce-----------"+e1);
		}
		   finally{
			   pm.close();
		   }

    
	
 }
    }
}//end of class
