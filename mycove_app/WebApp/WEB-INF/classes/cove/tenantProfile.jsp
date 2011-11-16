 <%@page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="com.mycove.util.util.FormUtil"%>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.vo.Apartment"%>
<jsp:useBean id="frm" class="com.mycove.cove.form.TenantProfileForm" />
<jsp:setProperty name="frm" property="*" />
<%

	Collection<Apartment> apartments = (Collection<Apartment>)request.getAttribute("apartments");
	pageContext.setAttribute("apartments", apartments);
	String username = (String)request.getSession().getAttribute("UserName");
	pageContext.setAttribute("username", username);
	String formAction = "";
	String displaySaveButton = "none;";
	String displayUpdateButton = "none;";
	String displayApartment = "none;";
	String titleadd = "none;";
	String titleedit = "none;";	
	String editableadd = "none;";
	String editableedit = "none;";
	String tenantedit = "none;";
	
	
	if(request.getParameter("formAction") != null)
	{
		if(request.getParameter("formAction").equalsIgnoreCase("add"))
		{
			displaySaveButton = "block;";
			displayUpdateButton = "none;";
			titleadd ="block;";
			titleedit="none;";
			editableadd="block;";
			editableedit = "none;";
			
		}
		else if (request.getParameter("formAction").equalsIgnoreCase("edit") || request.getParameter("formAction").equalsIgnoreCase("update")&& request.getParameter("residentId")== null)
		{
			tenantedit ="block;";
			displaySaveButton = "none;";
			displayUpdateButton = "block;";
			titleadd ="none;";
			titleedit="none;";
			editableadd="none;";
			editableedit = "block;";
			
		}
		else if (request.getParameter("formAction").equalsIgnoreCase("edit") || request.getParameter("formAction").equalsIgnoreCase("update"))
		{
			displaySaveButton = "none;";
			displayUpdateButton = "block;";
			titleadd ="none;";
			titleedit="block;";
			editableadd="none;";
			editableedit = "block;";
		}
		
	}
	if(session.getAttribute("formAction") != null)
	{
		if(((String)session.getAttribute("formAction")).equalsIgnoreCase("add"))
		{
			displaySaveButton = "block;";
			displayUpdateButton = "none;";
			titleadd ="block;";
			titleedit="none;";
			editableadd="block;";
			editableedit = "none;";
		}
		else if (((String)session.getAttribute("formAction")).equalsIgnoreCase("edit") || ((String)session.getAttribute("formAction")).equalsIgnoreCase("update") && ((String)session.getAttribute("roleName")).equalsIgnoreCase("resident") )
		{
			tenantedit ="block;";
			displaySaveButton = "none;";
			displayUpdateButton = "block;";
			titleadd ="none;";
			titleedit="none;";
			editableadd="none;";
			editableedit = "block;";
			
		}
		else if (((String)session.getAttribute("formAction")).equalsIgnoreCase("edit") || ((String)session.getAttribute("formAction")).equalsIgnoreCase("update"))
		{
			displaySaveButton = "none;";
			displayUpdateButton = "block;";
			titleadd ="none;";
			titleedit="block;";
			editableadd="block;";
			editableedit = "none;";
		}
		
	}
	
%>
<html:html>
<body>
<html:form action="/TenantProfile.do">
<html:hidden property="id" />
		<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

		
		<h1>Resident Profile</h1>
	    
		

		<%
			if(!((String)session.getAttribute("roleName")).equalsIgnoreCase("resident"))
			{ 
		%>
		<p> 
			<label class="label">Apartment Number</label>
			<html:select property="apartmentId">
					<html:option value="0">Select one</html:option>
					<html:optionsCollection name="apartments" label="apartmentNumber" value="id" />
   		   </html:select>
		</p>
		<%} else
			{
		%>
		<html:hidden property="apartmentId"></html:hidden>
		<%} %>
		<p> 
		  <label class="label">User Name</label>
				<html:text maxlength="50" property="userName" styleClass="textbox"></html:text>
		</p>
		<p>
			<label class="label">Password</label>
			<html:password maxlength="50" property="password" styleClass="textbox" />
		</p>
		<p> 
			<label class="label">Email</label>
			<html:text maxlength="50" property="emailAddress" styleClass="textbox"></html:text>
		</p>
		<p>
			<label class="label">Gender</label>
			
				<html:radio property="gender" value="Male" />Male                      
              	<html:radio property="gender" value="Female" />Female
		  </p>
		<p> 
			<label class="label">First&nbsp;Name</label>
			<html:text maxlength="50" property="firstName" styleClass="textbox"></html:text>
		  </p>
		<p>
			<label class="label">Middle Name</label>
			<html:text maxlength="50" property="middleName" styleClass="textbox"></html:text>
		  </p>
		<p>
			<label class="label">Last Name</label>
			<html:text maxlength="50" property="lastName" styleClass="textbox"></html:text>
		 </p>
		<p>
		<label class="label">Home Phone</label>
		<html:text maxlength="50" property="homePhone" styleClass="textbox"></html:text>
		</p>
		<p>
			<label class="label">Work Phone</label>
			 <html:text maxlength="50" property="workPhone" styleClass="textbox"></html:text>
		  </p>
		<p>
			<label class="label">Cell Phone</label>
			<html:text maxlength="50" property="cellPhone" styleClass="textbox"></html:text>
		  </p>
		<p>
			<label class="label">Email SMS</label>
			<html:checkbox property="sendEmailSms" value="true"/>Send
		  </p>
		<p>
			<label class="label">Cellular Provider</label>
            <html:text maxlength="50" property="carrier" styleClass="textbox"></html:text>
		</p>
		<p style="display:<%=editableadd %>"> 
			<label class="label">Lease Start Date</label>
			<html:text maxlength="50" property="leaseStartDate" styleClass="textbox" > </html:text>
	  	</p>
		<p style="display:<%=editableadd %>">
			<label class="label">Lease End Date</label>
			<html:text maxlength="50" property="leaseEndDate" styleClass="textbox"></html:text> (MM/DD/YY)
		</p>
		<p style="display:<%=editableadd %>">
			<label class="label">Parking</label>
			<html:text maxlength="50" property="parking" styleClass="textbox"></html:text>
	   </p>
		<p style="display:<%=editableadd %>">
			<label class="label">Tag Number</label>
			<html:text maxlength="50" property="tagnumber" styleClass="textbox"></html:text>
	  	</p>
		  <p style="display:<%=editableedit %>">
			<label class="label">Lease Start Date</label>
			<html:text maxlength="50" property="leaseStartDate" readonly="true" styleClass="textbox" > </html:text> (MM/DD/YY)
	  	</p>
		<p style="display:<%=editableedit %>"> 
			<label class="label">Lease End Date</label>
			<html:text maxlength="50" property="leaseEndDate" readonly="true" styleClass="textbox"></html:text> (MM/DD/YY)
		</p>
		<p style="display:<%=editableedit %>">
			<label class="label">Parking</label>
			<html:text maxlength="50" property="parking" readonly="true" styleClass="textbox"></html:text>
    	</p>
		<p style="display:<%=editableedit %>">
			<label class="label">Tag Number</label>
			<html:text maxlength="50" property="tagnumber" readonly="true" styleClass="textbox"></html:text>
		  </p>
		  <%
			if(!((String)session.getAttribute("roleName")).equalsIgnoreCase("resident"))
			{ 
		%>
		  <p>
		    <label class="label">Is Active</label>
			<html:checkbox property="activeFlag" styleClass="checkBox"></html:checkbox>
		  </p>
		  <%} else {%>
		  	<html:hidden property="activeFlag"></html:hidden>
		  <%} %>
		<p style="display:<%=displayUpdateButton %>">
			<html:submit property="action" styleClass="save-button">
				<bean:message key="button.update"/>
			</html:submit>
		</p>
		<p style="display:<%=displaySaveButton %>">
			<html:submit property="action" styleClass="save-button">
				<bean:message key="button.save"/>
			</html:submit>
		</p>
</html:form> 
</body>
</html:html>