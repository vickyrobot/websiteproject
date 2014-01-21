
    <%@ page import="com.google.appengine.api.blobstore.BlobstoreServiceFactory" %>
<%@ page import="com.google.appengine.api.blobstore.BlobstoreService" %>

<html>
<head>
<link  type="text/css" rel="stylesheet" href="/jsp/css/register.css"/>
<%
    BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
%>

<script>
try{
	var result;
	var url;
function create()
{
	var r=new XMLHttpRequest();
	return r;
	}//create

function loadXml()
{
var req=new create();
if(req!==null)
{
	var mail=document.getElementById("mail").value
	var url="/serve?mail="+mail;
	req.onreadystatechange=doit;
	req.open("GET",url,true);
	req.send(null);
	}
	
	
	
	
	function doit()
	{
		if(req.readyState==4)
			{
			if(req.status==200)
				{
				if(req.responseText=="true")
				{
					result=true;
					document.getElementById("emailresult").innerHTML="email already registered";
					document.getElementById("emailresult").style.color="red";
				}	
				else
					{
					result=false;
					document.getElementById("emailresult").innerHTML="ok";
					document.getElementById("emailresult").style.color="green";
					
					}
				}
			}
	}//doit

}//loadxml

function pattern()
{
	var namereg=/{[\w\d]+}/;
	var pwdreg=/{[\w\d]+}/
	
	
	
	}//patrn

function checkform()
{
var test=((document.getElementById("name").value!="")&&(document.getElementById("mail").value!="")&&(document.getElementById("pno").value!="")&&(document.getElementById("pwd").value!=""))&&(result!==true);

if(test)
	{
	
	document.getElementById("submit").disabled=false;
	
	
	}
	
	}//checkform

function dis()
{
	document.getElementById("submit").disabled=true;

	
	}//dis
	 
        
	
	


		  function shw()
            {
			  var preview = document.querySelector('img');
			  var file    = document.querySelector('input[type=file]').files[0];
			  var reader  = new FileReader();

			  reader.onloadend = function () {
			    preview.src = reader.result;
			  }

			  if (file) {
			    reader.readAsDataURL(file);
			  } else {
			    preview.src = "";
			  }
            }
}///try



catch(err)
{
	console.log(err);
	
	}






</script>
</head>

<body onload="dis()" style="text-align: center;">
<br>
<br>
<br>
<form action= "<%= blobstoreService.createUploadUrl("/upload") %>" method="post" enctype="multipart/form-data">
       <fieldset style="border: thin;">
       <legend> Register Here!</legend>
  
       <label>userName:</label>  <input id="name" type="text" name="name" placeholder="enter your name" /><br>
       <br> <label>E-mail:</label>    <input  id="mail"  type="text" name="email" placeholder="eg.yourID@mail.com" onblur="loadXml()"/> <br>
       <span><small id="emailresult"></small></span>
       <br> <label>Phone.no:</label>  <input id="pno"  type="text" name="pno" placeholder="enter your phone n.o"/> <br>
       <br> <label>pasword:</label>   <input id="pwd"  type="text" name="pwd" placeholder="enter your pasword" />   <br>
       <br> <label>photo:  </label>   <input id="photo" type="file" name="photo"  onblur="checkform()"  onchange="shw()" /><br>
                                  
                                       <img src="" height="100" alt="Image preview...">
       <br> <input type="reset" value="Reset!"/><br>
       <br> <div ><input id="submit" type="submit" name="Register" value="submit"   /></div><br>
      </fieldset>
   </form>   
      
    
 
</body>
</html>    