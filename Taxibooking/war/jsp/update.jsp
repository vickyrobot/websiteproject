<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="javax.jdo.JDOHelper,com.adaptavant.taxi.*,
    com.google.appengine.api.datastore.*,javax.jdo.JDOObjectNotFoundException,
    javax.jdo.PersistenceManager,javax.jdo.PersistenceManagerFactory"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link  type="text/css" rel="stylesheet" href="/jsp/css/update.css"/>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>viki app</title>
<script type="text/javascript">

function enab(v)
{
	switch(v)
	{
	
	case'name':
		var name=(document.getElementById("namebox").checked==true) && (document.getElementById("filebox").checked===false);
		if(name)
	    {	
			alert("oth");
		document.getElementById("name").disabled=false;
		document.getElementById("submit").disabled=false;
		document.getElementById("myform").action="/Update";
		document.getElementById("myform").removeAttribute("enctype");
		 }	
		else
			{
			 document.getElementById("name").disabled=true;
			 document.getElementById("submit").disabled=true;
			if((document.getElementById("filebox").checked===true))
				{
			document.getElementById("name").disabled=true;
			document.getElementById("submit").disabled=true;
			document.getElementById("myform").action='blobstoreService.createUploadUrl("/Update")';
			document.getElementById("myform").setAttribute("enctype","multipart/form-data");
			document.getElementById("myform").setAttribute("method","post");
				}
			}
		
		break;
	case'pno':
		var pno=(document.getElementById("phonebox").checked==true)&&(document.getElementById("filebox").checked===false);
		if(pno)
	    {
			alert("oth");
		document.getElementById("pno").disabled=false;
		document.getElementById("submit").disabled=false;
		document.getElementById("myform").action="/Update";
		document.getElementById("myform").removeAttribute("enctype");
	    }
	    else
			{
	    	 document.getElementById("pno").disabled=true;
			 document.getElementById("submit").disabled=true;
	    	if((document.getElementById("filebox").checked===true))
			{
	    	alert("blo");
			
			document.getElementById("myform").action='blobstoreService.createUploadUrl("/Update")';
			document.getElementById("myform").setAttribute("enctype","multipart/form-data");
			document.getElementById("myform").setAttribute("method","post");
			}}
		break;

	case'pwd':
		var pwd=(document.getElementById("pwdbox").checked==true)&&(document.getElementById("filebox").checked===false);
		if(pwd)
	    {
			alert("oth");
		document.getElementById("pwd").disabled=false;
		document.getElementById("submit").disabled=false;
		document.getElementById("myform").action="/Update";
		document.getElementById("myform").removeAttribute("enctype");
	    }
		else
		 {
			document.getElementById("pwd").disabled=true;
			document.getElementById("submit").disabled=true;
			
			if((document.getElementById("filebox").checked===true))
			{
			alert("blo");
			
			document.getElementById("myform").action='blobstoreService.createUploadUrl("/Update")';
			document.getElementById("myform").setAttribute("enctype","multipart/form-data");
			document.getElementById("myform").setAttribute("method","post");
		    }
			}
		break;
	case'file':
		if(document.getElementById("filebox").checked==true)
	    {
			alert("blo");
		document.getElementById("file").disabled=false;
		document.getElementById("submit").disabled=false;
		document.getElementById("myform").action='blobstoreService.createUploadUrl("/Update")';
		document.getElementById("myform").setAttribute("enctype","multipart/form-data");
		document.getElementById("myform").setAttribute("method","post");
		    }
		else
			{
			
			alert("oth");
			document.getElementById("file").disabled=true;
			document.getElementById("submit").disabled=true;
			document.getElementById("myform").action="/Update";
			document.getElementById("myform").removeAttribute("enctype");
		
			}
			
		 break;
	 		}
		
	}
function able()
{ 
	document.getElementById("name").disabled=false;
	document.getElementById("pno").disabled=false;
	document.getElementById("pwd").disabled=false;
	document.getElementById("submit").disabled=false;

	}
	function tell()
	{
		
		var ans=confirm("you losse the data permently");
	
		if(ans)
			{
			able();
			}
		
	}
	function sub()
	{
		var check= (document.getElementById("namebox").checked==false)&&(document.getElementById("filebox").checked==false)&&(document.getElementById("pwdbox").checked==false)&&(document.getElementById("phonebox").checked==false)
		
	}
	

</script>

</head>
<%


PersistenceManager pm = PMF.get().getPersistenceManager();
String email = request.getParameter("email");
Details e=(Details)session.getAttribute("details");
BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>
<body>
<form action= "<%= blobstoreService.createUploadUrl("/Update") %>" method="post" enctype="multipart/form-data"  id="myform">
                                         <small>click individual radiobutton to edit </small><br>
                                         
                                  <input type="checkbox"  id="namebox" onclick="enab('name')"> <br>
        <label>userName:</label>  <input type="text"   id="name"  name="name" value="<%=e.getName() %>"disabled />  <br>
        
        <label>E-mail:</label>    <input type="text"    id="mail"   id="email" name="email" value="<%=e.getEmail()%>" disabled/> <br>
                                  
                                  <input type="checkbox"  id="phonebox" onclick="enab('pno')"/> <br>
                                  <br>
                <label>Phone.no:</label>  <input type="text"  id="pno" name="pno" value="<%=e.getPno() %>"disabled/><br>
                                   <br>
                                 
                                  <input type="checkbox"  id="pwdbox" onclick="enab('pwd')"/>  <br>
        <label>pasword:</label>   <input type="text"  id="pwd"  name="pwd" value="<%=e.getPwd() %>"disabled/><br>
                                  <br>
                                
                                  <input type="checkbox"   id="filebox" onclick="enab('file')"/><br>
        <br><input type="file" id ="file" name="photo" onclick="enab()"disabled />
        <br>
       
        <br>  <input type="reset" value="Reset!"/> <input type="button" name="edit" value="enableAll" onclick="tell()"/> <br>
        <br><input type="submit" id="submit" name="Save" disabled " />  <br>
       

</form>
</body>
</html>