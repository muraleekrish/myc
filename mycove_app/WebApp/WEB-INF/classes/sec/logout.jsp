<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
 
<%   
response.setHeader("Pragma","no-cache");   
response.setHeader("Cache-Control","no-store");   
response.setHeader("Expires","0");   
response.setDateHeader("Expires",-1);      
%>   
<html:html>
	<head>
	
	
		<title>My Cove</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">   
		<META HTTP-EQUIV="PRAGMA" CONTENT="NO-CACHE">    
		<META HTTP-EQUIV="CACHE-CONTROL" CONTENT="NO-CACHE">   
		<META HTTP-EQUIV="Expires" CONTENT="-1">   
         
		<link href="<%=request.getContextPath() %>/shared/styles/mycove_menu.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath() %>/shared/styles/mycove_style.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath() %>/shared/styles/SpryAccordion.css" rel="stylesheet" type="text/css">
		<link href="<%=request.getContextPath() %>/shared/styles/tenant_style.css" rel="stylesheet" type="text/css">
		<style>
		.form_label {font-family:"trebuchet MS";font-size:11px;	font-weight:bold;	text-align:right;	padding:6px 5px 6px 2px;}
		</style>
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
		<html:form action="/Logout.do" >
			<html:hidden property="screenWidth"></html:hidden>
			<html:hidden property="screenHeigth"></html:hidden>
			<div id="dvCapsMsg" style="position:absolute; left:481px; top:338px; width:269px; height:106px; z-index:1; display:none" onClick="this.style.display='none'">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="23"><img src="<%=request.getContextPath()%>/shared/images/caps_topleft.gif" width="23" height="23"></td>
						<td background="<%=request.getContextPath()%>/shared/images/caps_topborder.gif"><img src="<%=request.getContextPath()%>/shared/images/caps_pointer.gif" width="45" height="23"></td>
						<td width="23"><img src="<%=request.getContextPath()%>/shared/images/caps_topright.gif" width="23" height="23"></td>
					</tr>
					<tr>
						<td background="<%=request.getContextPath()%>/shared/images/caps_leftborder.gif"><img src="<%=request.getContextPath()%>/shared/images/caps_leftborder.gif" width="23" height="57"></td>
						<td class="capslock"><b><img src="<%=request.getContextPath()%>/shared/images/info_icon.gif" align="middle">Caps Lock is On</b><br><br>
							Having Caps Lock on may cause you to enter your password Incorrectly.<br><br>
							You should press Caps Lock to turn it off before entering your password.
						</td>
						<td background="<%=request.getContextPath()%>/shared/images/caps_rightborder.gif"><img src="<%=request.getContextPath()%>/shared/images/caps_rightborder.gif" width="23" height="57"></td>
					</tr>
					<tr>
						<td><img src="<%=request.getContextPath()%>/shared/images/caps_botleft.gif" width="23" height="20"></td>
						<td background="<%=request.getContextPath()%>/shared/images/caps_botborder.gif">&nbsp;</td>
						<td><img src="<%=request.getContextPath()%>/shared/images/caps_botright.gif" width="23" height="20"></td>
					</tr>
				</table>
			</div>
			<div style="position:relative; top:80px">
				<table border="0" cellspacing="5" cellpadding="0" align="center" style="border:0px solid #013463;">
					<tr>
						<td colspan="3" align="center"><img src="<%=request.getContextPath()%>/shared/images/logo1.jpg" width="180px"/></td>
					</tr>
					<tr>
						<td class="label">User&nbsp;Name&nbsp;</td>
						<td width="1">:</td>
						<td class="TextBox"><html:text property="userName" /></td>
					</tr>
					<tr>
						<td class="label">Password&nbsp;</td>
						<td width="1">:</td>
						<td class="TextBox"><html:password property="password" onkeypress="antiLock(event)" /></td>
					</tr>
					<tr><td height="2"></td></tr>
					
					<tr>
						<td colspan="3" align="center">
							<input class="Buttons" type="submit" id="submitbutton" value="Login" >&nbsp;&nbsp;
							<input class="Buttons" type="reset" value="Reset">
						</td>
					</tr>
				</table>
			</div>
		</html:form>
		<script type="text/javascript" language="JavaScript">
			document.getElementById('screenWidth').value = window.screen.availWidth;
			document.getElementById('screenHeigth').value = window.screen.availHeight;
		</script>
	</body>
</html:html>
