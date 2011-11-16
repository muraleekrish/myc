<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %> 
<jsp:useBean id="frm" class="com.mycove.cove.form.MaintenanceRequestForm"/>
<%@page import="com.mycove.util.util.FormUtil"%>
<jsp:setProperty name="frm" property="*" />
<%
	String username = (String)request.getSession().getAttribute("UserName");
	pageContext.setAttribute("username", username);
	String formAction = "";
	String displaySaveButton = "none";
	String displayUpdateButton = "none";
	if(FormUtil.isNotNull(request.getParameter("action")) 
			&& request.getParameter("formAction").equalsIgnoreCase("add"))
	{
		displaySaveButton = "block";
		displayUpdateButton = "none";
	}
	else
	{
		displaySaveButton = "none";
		displayUpdateButton = "block";
	}
%>
<html:html>
<body>
<html:form action="/ModifyCustomer.do" >
<html:hidden property="id" />
	<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
	<h1>Customer Details</h1>
				<p> 
					<label class="label">Customer Name</label>
					<html:text styleClass="TextBox" maxlength="50" property="customerName" readonly="true"></html:text>
				</p>
				<p> 
					<label class="label">Address 1</label>
					<html:text maxlength="50" property="address1" styleClass="textbox"/>
				</p>
				<p> 
					<label class="label">Address 2</label>
					<html:text maxlength="50" property="address2" styleClass="textbox"></html:text>
				</p>
				<p>
					<label class="label">City</label>
					<html:text maxlength="50" property="city" styleClass="textbox" />
				</p>
				<p>
					<label class="label">State</label>
					<html:text maxlength="50" property="state" styleClass="TextBox"></html:text>
			  	</p>
				<p>
					<label class="label">Zip Code</label>
					<html:text maxlength="50" property="zipCode" styleClass="textbox"></html:text>
			  </p>
			  <p> 
					<label class="label">Contact First Name</label>
					<html:text maxlength="50" property="primaryContactFirstName" styleClass="textbox"></html:text>
			  </p>
				<p> 
					<label class="label">Last Name</label>
					<html:text maxlength="50" property="primaryContactLastName" styleClass="textbox"></html:text>
			  </p>
				<p> 
					<label class="label">E-mail Address</label>
					<html:text maxlength="50" property="emailAddress" styleClass="textbox"></html:text>
			    </p>
				<p> 
					<label class="label">Phone Number</label>
					<html:text maxlength="50" property="phoneNumber" styleClass="textbox"></html:text>
			  </p>
				<p> 
					<label class="label">Secondary Phone Number</label>
					<html:text property="secondaryPhoneNumber" styleClass="textbox" />
			    </p>
				<p>
					<html:submit property="action" styleClass="save-button">
						<bean:message key="button.submit"/>
					</html:submit>
				</p>
</html:form>
</body>
</html:html>
