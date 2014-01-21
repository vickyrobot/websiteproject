<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="javax.jdo.JDOHelper,
    com.adaptavant.taxi.*,
    com.google.appengine.api.datastore.*,
    javax.jdo.JDOObjectNotFoundException,
    javax.jdo.PersistenceManager,
    javax.jdo.PersistenceManagerFactory"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="cache-control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="0">
<meta http-equiv="pragma" content="no-cache">

<title>viki app</title>
<link  type="text/css" rel="stylesheet" href="/jsp/css/login.css"/>

<script type="text/javascript">
setInterval(checkform, 1000);
function checkform()
{
var test=((document.getElementById("email").value!="")&&(document.getElementById("pwd").value!=""));

if(test)
	{
	
	document.getElementById("submit").disabled=false;
	
	}
	
	}


</script>
<% 
  if(session.getAttribute("details")!=null)
  {
	
	%>	
<meta http-equiv="cache-control" content="no-cache, must-revalidate">
<meta http-equiv="expires" content="0">
<meta http-equiv="pragma" content="no-cache">

<%  
	response.sendRedirect("/jsp/showDetials.jsp");
}%> 


 <%
 try
 {
	 
if(session.getAttribute("details")!=null)	 
{
   PersistenceManagerFactory PMF = JDOHelper.getPersistenceManagerFactory("transactions-optional");
   PersistenceManager pm = PMF.getPersistenceManager();
   Cookie[] c=request.getCookies();

   for(Cookie cookie:c)
   {
	 
	 String emailName=cookie.getName();

 if(emailName.equals("mail1"))
 {
	  session=request.getSession(false);
	  
	  String email = cookie.getValue();

	
     Details e = pm.getObjectById(Details.class, email);
	
	 System.out.println(e);

	 System.out.println("top login");	

	 
	session.setAttribute("details", e);
	response.sendRedirect("/jsp/showDetials.jsp");
	}
 }
 }
 }
catch(Exception e)
{
		System.out.println(e);
	}
 
 
%>
</head>
<body>
    
    <fieldset style="border: thin;">

     <form action="/CheckRegistered" method="Get"   >
        <label> Email:</label> <input type="text"  id="email" name="email" placeholder="enter your mail"><br>
        <label> pasword:</label><input type="password" id="pwd" name="pwd" placeholder="enter your pasword"/>   <br>
        <input type="submit" id="submit" name="Login" value="Login" style="width: 63px; "disabled/>
       
        <a href="/jsp/register.jsp">
         <input type="button" value="SignUp!" style="width: 71px; "></a>
         <br><input type="checkbox" name="remember" value="remember">RememberMe!
     </form>
   </fieldset>
</body>
</html> 