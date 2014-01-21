package com.adaptavant.taxi;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.jdo.PersistenceManager;
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

public class Getimg extends HttpServlet {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest req, HttpServletResponse resp)throws IOException, ServletException 
	{
//	PrintWriter out=resp.getWriter();
	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	ImagesService imagesService = ImagesServiceFactory.getImagesService();

	try{
		
		HttpSession session=req.getSession(false);
		//PersistenceManager pm =PMF.get().getPersistenceManager();
		//Details user=(Details)session.getAttribute("details");
	  //  String email=user.getEmail();
	 //   Details e = pm.getObjectById(Details.class, email);
			
			
	   
	Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
	
	BlobKey blobkey = blobs.get("photo");
	
	String url=imagesService.getServingUrl(blobkey);
	
	//out.print(url);
	session.setAttribute("urlimg", url);
	System.out.print("img uploded");
	
	
	}//try
	catch(Exception er){
		System.out.println(er);
	}//catch
	
	
	
	//dopost
    }


}//class