package com.adaptavant.taxi;

import java.io.Serializable;

import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import com.google.appengine.api.blobstore.BlobKey;

@PersistenceCapable()
public class Details implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	@Persistent
	private  String name;
	@PrimaryKey
	private  String email;
    @Persistent
	private  String pwd;
	@Persistent
	private  String pno;
	private  String imgurl;
	private BlobKey imgkey;
	
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	
	
	public BlobKey getImg() {
		return imgkey;
	}
	public  void  setImg(BlobKey imgkey) {
		
this.imgkey=imgkey;

	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getPno() {
		return pno;
	}
	public void setPno(String pno) {
		this.pno = pno;
	}
	
	
	

}
