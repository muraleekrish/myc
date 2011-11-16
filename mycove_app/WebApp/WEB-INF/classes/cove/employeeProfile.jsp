 <%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<jsp:useBean id="frm" class="com.mycove.cove.form.EmployeeProfileForm" />
<jsp:setProperty name="frm" property="*" />
<%
 String username = (String)request.getSession().getAttribute("UserName");
pageContext.setAttribute("username", username);
String formAction = "";
String displaySaveButton = "none;";
String displayUpdateButton = "none;";

if(request.getParameter("formAction") != null)
{
	if(request.getParameter("formAction").equalsIgnoreCase("add"))
	{
		displaySaveButton = "block;";
		displayUpdateButton = "none;";
		
		
	}
	
	else if (request.getParameter("formAction").equalsIgnoreCase("edit") || request.getParameter("formAction").equalsIgnoreCase("update"))
	{
		displaySaveButton = "none;";
		displayUpdateButton = "block;";
		
	}
	
}
if(session.getAttribute("formAction") != null)
{
	if(((String)session.getAttribute("formAction")).equalsIgnoreCase("add"))
	{
		displaySaveButton = "block;";
		displayUpdateButton = "none;";
		
	}
	else if (((String)session.getAttribute("formAction")).equalsIgnoreCase("edit") || ((String)session.getAttribute("formAction")).equalsIgnoreCase("update"))
	{
		displaySaveButton = "none;";
		displayUpdateButton = "block;";
		
	}
	
} %>

  
<html:html>
<head>

<script language="Javascript" type="text/Javascript">
 
   
 	function update()
	{
		temp = document.forms[0];
		temp.formAction.value = "update";
		temp.submit();
		
	}
	</script>
</head>
<body>
<html:form action="/EmployeeProfile.do">
<html:hidden property="formAction" />
<html:hidden property="id" />
		<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
		<h1>Employee Details</h1>
		<p>
				<label for="" class="label">Employee Type</label>
				<html:select property="employeeType">
					<html:option value="Concierge">Concierge</html:option>
					<html:option value="Leasing Agent">Leasing Agent</html:option>
					<html:option value="Property Manager">Property Manager</html:option>
					<html:option value="Custom">Custom</html:option>
				</html:select>
		</p>
		<p> 
			<label for="userName" class="label">User Name</label>
    		<html:text maxlength="50" property="userName" styleClass="textbox" ></html:text>
    	</p>
		<p> 
			<label for="password" class="label">Password</label>
			<html:password maxlength="50" property="password" styleClass="textbox" />
		</p>
		<p> 
			<label for="email" class="label">Email</label>
			<html:text maxlength="50" property="email" styleClass="textbox"></html:text>
		</p>	
		<p>
			<label for="gender" class="label">Gender</label>
				<html:radio property="gender" value="Male" />Male                      
                   	<html:radio property="gender" value="Female" />Female
		</p>
		<p> 
			<label for="firstName" class="label">First Name</label>
				<html:text maxlength="50" property="firstName" styleClass="textbox"></html:text>
		</p>
		<p>
			<label for="middleName" class="label">Middle Name</label>
			 <html:text maxlength="50" property="middleName" styleClass="textbox"></html:text>
		</p>
		<p> 
			<label for="lastName" class="label">Last Name</label>
			<html:text maxlength="50" property="lastName" styleClass="textbox"></html:text>
		</p>
		<p>
			<label for="address1" class="label">Address1</label>
		    <html:text maxlength="50" property="address1" styleClass="textbox"></html:text>
		</p>
		<p> 
			<label for="address2" class="label">Address2</label>
			<html:text maxlength="50" property="address2" styleClass="textbox"></html:text>
		</p>
		<p> 
			<label for="homePhone" class="label">Home Phone</label>
			<html:text maxlength="50" property="homePhone" styleClass="textbox"></html:text>
		</p>
		<p> 
			<label for="workPhone" class="label">Work Phone</label>
			<html:text maxlength="50" property="workPhone" styleClass="textbox"></html:text>
		</p>
		<p> 
			<label class="label">Cell Phone</label>
			<html:text maxlength="50" property="cellPhone" styleClass="textbox"></html:text>
		</p>
		<p> 
			<label for="emailsms" class="label">E-mail SMS</label>
			<html:checkbox property="emailsms" value="true"/>Send
		</p>
		<p>
		<label for="carrier" class="label">Cell Provider</label>
		<html:text maxlength="50" property="carrier" styleClass="TextBox"></html:text>
		</p>	
		<p>
			<label  for="activeFlag" class="label">Active</label>
			<html:checkbox property="activeFlag" value="true"/>
		</p>
		 
		<p  style="display:<%=displayUpdateButton %>">
		 		
					
			<html:submit property="action" styleClass="update-button">
				<bean:message key="button.update"/>
			</html:submit>
		 </p>	
		<p  style="display:<%=displaySaveButton %>">		 	
			
			<html:submit property="action" styleClass="save-button">
				<bean:message key="button.save"/>
			</html:submit>
			
		
		</p>
			
</html:form> 
</body>
</html:html>