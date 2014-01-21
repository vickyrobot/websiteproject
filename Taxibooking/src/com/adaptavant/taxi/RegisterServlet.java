package com.adaptavant.taxi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.blobstore.BlobInfo;
import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;

@SuppressWarnings("serial")
public class RegisterServlet extends HttpServlet 
{
/*	  private static final PersistenceManagerFactory PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");
*/
	 
	 BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	 ImagesService imagesService = ImagesServiceFactory.getImagesService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException 
	{
		
		System.out.println("Inside Upload");
		
    try{
			
	System.out.println("try Inside Upload");
	PrintWriter out=resp.getWriter();
	PersistenceManager pm =PMF.get().getPersistenceManager();

	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	ImagesService imagesService = ImagesServiceFactory.getImagesService();

	
	Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
	
	BlobKey blobkey = blobs.get("photo");
	
	String url=imagesService.getServingUrl(blobkey);
    
   
	
	String name =req.getParameter("name");
	String email=req.getParameter("email");
	String password=req.getParameter("pwd");
	String phone =req.getParameter("pno");

	Details d=new Details();
	
	d.setImg(blobkey);
	d.setName(name);
	d.setPno(phone);
	d.setEmail(email);
	d.setPwd(password);
	d.setImgurl(url);
	
	
	pm.makePersistent(d);

	
	System.out.println(name);
	System.out.println(email);
	System.out.println(password);
	System.out.println(phone);
	resp.setContentType("text/html");
	out.println("<h3>"+"registered"+"</h3>");
	/*RequestDispatcher rd=req.getRequestDispatcher("/jsp/Login.jsp");  
    rd.include(req, resp);*/
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
   
    
    }


}
