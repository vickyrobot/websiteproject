<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.google.appengine.api.blobstore.BlobstoreServiceFactory"%>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService"%>
<%@ page import=" com.google.appengine.api.blobstore.BlobKey"%>
<%@ page import="com.google.appengine.api.images.Image"%>
<%@ page import="com.google.appengine.api.images.ImagesService"%>
<%@ page import=" com.google.appengine.api.images.ImagesServiceFactory"%>
<%@ page import="com.google.appengine.api.images.Transform"%>
<%@ page import="com.adaptavant.taxi.Details"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="cache-control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="0">
<meta http-equiv="pragma" content="no-cache">
<%if(session.getAttribute("details")!=null)
  {
		// System.out.println("login ses check");	
	// System.out.println(session.isNew());	
	%>	
<meta http-equiv="cache-control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="0">
<meta http-equiv="pragma" content="no-cache">

<%  
	
}%> 
<title>viki app</title>
<script>



</script>


<%
	try {
		Details e = (Details) session.getAttribute("details");
		
%>

<link  type="text/css" rel="stylesheet" href="jsp/css/showdetailscss.css"/>

</head>
<body>
<header>
<nav>
<ul>
<li> <a href="#"   class="navbar" id="homelink">Home</a></li>

<li><a href="#"  class="navbar" id="chatlink">Chat</a></li>

<li><a href="#"  class="navbar" id="videolink">Video</a></li>

<li><a href="/logout"  class="navbar" id="aboutlink">Logout</a></li>

</ul>
</nav>
</header>
	<br/><center><img width="200" height="150" src="<%=e.getImgurl()%>"/> </center>
	<table>
		<%
			}

			catch (Exception e) {

				out.println(e);

			}
		%>
		<tr>
			 <td><label>Name:</label></td>
			 <td>${details.name}</td>
		</tr>
		
		<tr>
			<td><label>email:</label></td>
			<td>${details.email }</td>
		</tr>
		
		<tr>
			<td><label>phoneNo:</label></td>
			<td>${details.pno }</td>
		</tr>

		<tr>
			<td><a href="/jsp/update.jsp"><input type="button" value="update"></a></td>
		</tr>
		
	</table>

</body>
</html>