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
</head>
<body>

			<html:form action="/Log.do" focus="userName">
			 
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
			
</body>
</html:html>