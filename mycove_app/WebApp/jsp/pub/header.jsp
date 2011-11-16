<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="com.mycove.util.util.FormUtil"%>
<%

	String residentMenu = "none;";	
	String propertyManagerMenu = "none;";	
	String adminMenu = "none;";
	Integer screenWidth = 0;
	String menuSpliter = "";
	String menuSpliterEnd = "";
	if(FormUtil.isNotNull(session.getAttribute("screenWidth")))
		screenWidth = (Integer)session.getAttribute("screenWidth");
	if(screenWidth < 500)
	{
		menuSpliter = "<td>&nbsp;</td></tr><tr><td colspan=\"18\">&nbsp;</td></tr><tr><td width=\"5px\">&nbsp;</td>";
		menuSpliterEnd = "<td colspan=\"5\"></td>";
	}
	if(FormUtil.isNotNull(session.getAttribute("userId")) && FormUtil.isNotNull(session.getAttribute("roleName")))
	{
		String role = (String) session.getAttribute("roleName");
		if(role.equalsIgnoreCase("resident"))
		{
			residentMenu = "block;";
			propertyManagerMenu = "none;";
			//adminMenu = "none;";
		}
		else if(role.equalsIgnoreCase("Property Manager"))
		{
			residentMenu = "none;";
			propertyManagerMenu = "block;";
			//adminMenu = "none;";
		}
		//else if(role.equalsIgnoreCase("admin"))
		//{
			//residentMenu = "none;";
			//propertyManagerMenu = "none;";
			//adminMenu = "block;";
		//}
	}
	else
		response.sendRedirect("/sec/Logout.do");
%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=no" />
<title>My Cove</title>
<link href="<%=request.getContextPath()%>/shared/styles/iPhone.css" rel="stylesheet" type="text/css">
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.5.1/jquery.min.js" type="text/javascript"></script>
<script src="<%=request.getContextPath()%>/shared/scripts/app.js" type="text/javascript"></script>
</head>

<body>
<div class="header">
<img id="logo" src="<%=request.getContextPath()%>/shared/images/mycoveLogo.png" border="0" />
<span class ="greeting">
Hello <%=request.getSession().getAttribute("firstName")%>
<a href="<%=request.getContextPath()%>/sec/Logout.do">Logout</a>
</span>
<span class ="support">
<a href="<%=request.getContextPath()%>/jsp/pub/open.jsp">Support</a>
</span>
</div>

	
	<div style="display:<%=residentMenu%>">
	<ul>
	<li><a href="<%=request.getContextPath()%>/TenantProfile.do?formAction=update">Profile</a></li>
	<li><html:link page="/maintenanceRequest.do">Maintenance</html:link></li>
	<li><a href="<%=request.getContextPath()%>/MailBox.do">Mailbox</a></li>
	</ul>
	</div>
	
	
	<div style="display:<%=adminMenu%>">
	<ul>
	<li><a href="<%=request.getContextPath()%>/CustomerList.do">Customer</a></li>
	<li><a href="<%=request.getContextPath()%>/PropertyList.do">Property</a></li>
	<li><a href="<%=request.getContextPath()%>/MailBox.do">Mailbox</a></li>
	</ul>
	</div>
	
	<div style="display:<%=propertyManagerMenu%>" >
	<ul>
	<li><a href="<%=request.getContextPath()%>/MailBox.do">Mailbox</a></li>
	<li><a href="<%=request.getContextPath()%>/PropertyList.do">Properties</a></li>
	<li><a href="<%=request.getContextPath()%>/EmployeeList.do">Employees</a></li>
	<li><a href="<%=request.getContextPath()%>/ResidentList.do">Residents</a></li>
	<li><a href="<%=request.getContextPath()%>/TemplateList.do">Templates</a></li>
	<li><a href="<%=request.getContextPath()%>/PackageList.do">Packages</a></li>
	<!-- <li><a href="<%=request.getContextPath()%>/SurveyList.do">Survey</a></li> -->
	<li><a href="<%=request.getContextPath()%>/MaintenanceList.do">Maintenance</a></li>
	<li><a href="<%=request.getContextPath()%>/notificationList.do">Notification</a></li>
	</ul>
	</div>

	<div align="center" class="success_message">
		  <logic:messagesPresent message="true">  
		  <html:messages id="message" message="true">   
		  <bean:write name="message"/> 
		  </html:messages>
		  </logic:messagesPresent>
   </div>

   <div align="center" class="error_message"><html:errors/></div>

