package com.adaptavant.taxi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;

@SuppressWarnings("serial")
public class Update extends HttpServlet
{  
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException
	{
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try{
			
			  HttpSession session=req.getSession(false);
			  
			  Details details=(Details) session.getAttribute("details");
		
			  Details enty = pm.getObjectById(Details.class, details.getEmail());
		  	  ImagesService imagesService = ImagesServiceFactory.getImagesService();
		  	  BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
		  	try{
		  		//if no blobuplod action occur in jsp illegal state exception occur
		  	   
		  	Map<String, BlobKey> blobmap = blobstoreService.getUploadedBlobs(req);
		     	
		     	}// innner try
		  	
		  	catch(IllegalStateException  i)
		  	{
		  		//do nothing
		  	}
		  	
			finally{//innner try finally
				
      Map<String , String[]> map =req.getParameterMap();
	    	 
			
		    if(map!=null)
			{
	
			 if(map.containsKey("name"))	
 			 {
 				 if(  !(map.get("name").equals(null)) )
 						{
 					 System.out.println("name");
 					 
 					 String []name=( (map.get("name")));
 					 enty.setName(name[0]);
 					System.out.println(name[0]);
 						}
 				
 			}
					
					
			 if(map.containsKey("pno"))	
 			 {
 				 if(  !(map.get("pno").equals(null)) )
 						{
 					String[] pno= (map.get("pno"));
 					  enty.setPno(pno[0]);
 					
 					System.out.println("updated phone number"+map.get("pno")[0]);
 						}
 				
 			}
			
			 if(map.containsKey("pwd"))	
 			 {
 				 if(  !(map.get("pwd").equals(null)) )
 						{
 					String pwd[]= (map.get("pwd"));
 					 enty.setPwd(pwd[0]);
 					System.out.println((map.get("pwd")));
 						}
 				
 			 }
			 
			  pm.makePersistent(enty);
			  System.out.println(enty.getName());
		      session.setAttribute("details", enty);
			
		      PrintWriter out=resp.getWriter();
		      resp.setContentType("text/html");
		     
		      out.print("uptdated!<br>");
		      System.out.println("test");
		      RequestDispatcher rd=req.getRequestDispatcher("/jsp/showDetials.jsp");  
		      rd.include(req, resp);
		  
		  	}
		  
		
			  
	   
		  	
		  	
		  	
		// if param map null
		else
		{
			RequestDispatcher rd=req.getRequestDispatcher("/jsp/update.jsp");  
            rd.forward(req, resp);
		   }
		}  //finally end
		  	
	}//outr try
		
		catch(Exception e){
			System.out.println("outside ");
			System.out.println(e);
		}
		finally
		{
			
			pm.close();
		}//outer finlly
	
	}//dopost

}//class end
