<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script language="Javascript" type="text/Javascript">
 
   
 	
	</script>
</head>
<body>
<!--Open IDs login-->&nbsp;
<div style="margin-left: 50px; margin-top: 40px; height: 60px;">
<form action="/servlet/LoginServlet?identifier=https://www.google.com/accounts/o8/id" method="post"> <input class="google openid_large_btn" style="background: #fff url(/shared/images/logo1.jpg); background-position: -1px -1px;" type="image" value=" 1" /></form>
<form action="/servlet/loginServlet?identifier=https://me.yahoo.com" method="post"><input class="google openid_large_btn" style="background: #fff url(/resources/images/login/openid-logos.png?v=3); background-position: -1px -63px;" type="image" value=" " /> </form></div>
<a href='/LoginServlet?identifier=https://www.google.com/accounts/o8/id'>OpenId</a>

</body>
</html>