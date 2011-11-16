<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>

<html:html>
	<head>
		<title>My Cove</title>
		<meta http-equiv="expires" content="0">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
		
	
	<link type="text/css" rel="stylesheet"	href="<%=request.getContextPath() %>/shared/styles/iPhone.css">
	
	<!-- <link type="text/css" rel="stylesheet"	href="<%=request.getContextPath() %>/shared/styles/web.css">-->
	 
		<script>
			function antiLock(e) {
				var whichKey=0;
				var gotShift=false;
				var myMsg='Caps Lock is On.\n\nHaving Caps Lock on may cause you to enter your password incorrectly.\n\nYou should press Caps Lock to turn it off before entering your password.';
				if(document.all) {whichKey=e.keyCode;gotShift=e.shiftKey;}
				else if(document.layers) {whichKey=e.which;	gotShift=(whichKey == 16) ? true : false;}
				else if (document.getElementById) {whichKey=e.which;gotShift=(whichKey == 16) ? true : false;}
				// Upper case letters are seen without depressing the Shift key, therefore Caps Lock is on
				if((whichKey >= 65 && whichKey <= 90) && !gotShift) {
					document.getElementById('dvCapsMsg').style.display = 'block';
					// Lower case letters are seen while depressing the Shift key, therefore Caps Lock is on
				} 
				else if ((whichKey >= 97 && whichKey <= 122) && gotShift) {
					document.getElementById('dvCapsMsg').style.display = 'block';
				}
				setTimeout('document.getElementById("dvCapsMsg").style.display = "none"',5000);
			}
			
		</script>
		<script type="text/javascript">
	 	window.history.forward(1);
	 </script>
		<script language="JavaScript" type="text/JavaScript">
			//<!--
			function MM_reloadPage(init) {  //reloads the window if Nav4 resized
			  if (init==true) with (navigator) {if ((appName=="Netscape")&&(parseInt(appVersion)==4)) {
			    document.MM_pgW=innerWidth; document.MM_pgH=innerHeight; onresize=MM_reloadPage; }}
			  else if (innerWidth!=document.MM_pgW || innerHeight!=document.MM_pgH) location.reload();
			}
			MM_reloadPage(true);
			//-->
		</script>
	</head>
	<body>
	<img src="<%=request.getContextPath()%>/shared/images/logo1.jpg" width="180px"/>

	    <div align="center" class="error_message"> <html:errors/></div>  

		<div id="login">
			<html:form action="/Login.do" focus="userName">
			<html:hidden property="screenWidth"></html:hidden>
			<html:hidden property="screenHeigth"></html:hidden>
			<div class="clearance"></div>
					<p id="user_label">
					<label for="userName">User Name:</label>
					</p>
					
					<div id="input_container">
					<input type="text" value="" class="textbox" name="userName" id="userName">
					</div>
					
					<p id="password_label">
					<label for="userName">Password:</label>
					</p>
					
					<div id="password_container">
					<input type="password" value="" class="textbox"  name="password" id="password">
					</div>
					
					<div id="login_action">
					<input id="login-button" type="submit" value="Login"/>
					</div>
				    
				</html:form>		    
			</div>
		
		<script type="text/javascript" language="JavaScript">
			document.getElementById('screenWidth').value = window.screen.availWidth;
			document.getElementById('screenHeigth').value = window.screen.availHeight;
		</script>
	</body>
</html:html>
