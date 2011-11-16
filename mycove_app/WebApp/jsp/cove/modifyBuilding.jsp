<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
 
<%
 

	String displayAddtitle = "none;";
	String displayUpdatetitle = "none;";
	
	if(request.getParameter("formAction") != null)
	{
		if(request.getParameter("formAction").equalsIgnoreCase("add"))
		{
			displayAddtitle = "block;";
			displayUpdatetitle = "none;";
			
		}
		else if (request.getParameter("formAction").equalsIgnoreCase("edit") || request.getParameter("formAction").equalsIgnoreCase("update"))
		{
			displayAddtitle = "none;";
			displayUpdatetitle = "block;";
			
		}
		
	}
	
	if(session.getAttribute("formAction") != null)
	{
		if(((String)session.getAttribute("formAction")).equalsIgnoreCase("add"))
		{
			displayAddtitle = "block;";
			displayUpdatetitle = "none;";
		}
		else if (((String)session.getAttribute("formAction")).equalsIgnoreCase("edit") || ((String)session.getAttribute("formAction")).equalsIgnoreCase("update"))
		{
			displayAddtitle = "none;";
			displayUpdatetitle = "block;";
		}
		
	}
	%>
<html:html>
<body>
<html:form action="/ModifyBuilding.do" enctype="multipart/form-data">
<html:hidden property="propertyId"></html:hidden>
<html:hidden property="id"></html:hidden>
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<h1>Building Details</h1>

<div class="help">				
<p>NOTE:-</p>
<p> Use the Following process to create a file for uploading Apartment Details</p>
<p>1) Open an empty Excel Spreadsheet.</p>
<p>2) Enter the apartment number in first column.</p>
<p>3) In second column enter type of apartment (two bedrooms etc..).</p>
<p>4) In 3rd column enter user ID.</p>
<p>5) In 4th column enter password. </p>
<p>6) In 5th and 6th column enter first name and last name respectively. </p>
<p>7) In 7th column enter email address.</p>
<p>8) In 8th and 9th column enter lease start and end date respectively.</p>
<p>9) Repeat steps 2 to 8 for all apartments.</p>
<p>10) Click on Save As button, Select (.csv) as the type of file to save.</p>
<p>11) Click on browse button. Select the file that you created, Click on submit button.</p>
</div>

 


			<p>
				<label class="label">Building Name</label>
				<html:text property="buildingName" styleClass="textbox"/>
			</p>
			<p>
				<label class="label">Upload Apartment(s)</label>
				<html:file property="apartmentFile" styleClass="textbox" />
			</p>
			
			<p>
				
					<html:submit property="action"  styleClass="save-button">
						<bean:message key="button.submit"/>
					</html:submit>
			</p>
</html:form>
</body>
</html:html>
