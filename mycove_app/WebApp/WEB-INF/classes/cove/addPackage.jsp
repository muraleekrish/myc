<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.ResidentDTO"%>
<%@page import="com.mycove.vo.Apartment"%>
<jsp:useBean id="frm" class="com.mycove.cove.form.AddPackageForm" />
<jsp:setProperty name="frm" property="*" />

<%
 

	String displaySaveButton = "none;";
	String displayUpdateButton = "none;";
	String titleadd = "none;";
	String titleedit = "none;";	
	String apartment = "none;";
	String apartmentreadonly = "none;";
	if(request.getParameter("formAction") != null)
	{
		if(request.getParameter("formAction").equalsIgnoreCase("add"))
		{
			displaySaveButton = "block;";
			displayUpdateButton = "none;";
			titleadd ="block;";
			titleedit="none;";
			apartment = "block;";
			apartmentreadonly = "none;";
			
		}
		else if (request.getParameter("formAction").equalsIgnoreCase("edit") || request.getParameter("formAction").equalsIgnoreCase("update"))
		{
			displaySaveButton = "none;";
			displayUpdateButton = "block;";
			titleadd ="none;";
			titleedit="block;";
			apartment = "none;";
			apartmentreadonly = "block;";
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
			apartment = "block;";
			apartmentreadonly = "none;";
			 
		}
		else if (((String)session.getAttribute("formAction")).equalsIgnoreCase("edit") || ((String)session.getAttribute("formAction")).equalsIgnoreCase("update"))
		{
			displaySaveButton = "none;";
			displayUpdateButton = "block;";
			titleadd ="none;";
			titleedit="block;";
			apartment = "none;";
			apartmentreadonly = "block;";
			 
		}
		
	}
	Collection<ResidentDTO> residents = (Collection<ResidentDTO>) request.getAttribute("residents");
	pageContext.setAttribute("residents", residents);
	Collection<Apartment> apartments = (Collection<Apartment>)request.getAttribute("apartments");
	pageContext.setAttribute("apartments", apartments);
	
%>
<html:html>
<body>
<html:form action="/addPackage.do">
<html:hidden property="id" />
	<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
	<h1>Package Details</h1>
	<p>
	<label for="date"  class="label">Date<span class="date-format">(MM/DD/YYYY)</span></label>
	<html:text styleClass ="textbox" property="date"></html:text>
	</p>
	
	<p style="display: <%=apartment%>">
	<label for="apartmentId"  class="label">Apartment</label>
	<html:select property="apartmentId">
					<html:option value="0">Select one</html:option>
					<html:optionsCollection name="residents" label="apartmentNumber" value="id" />
	</html:select>
	</p>
    <p  style="display: <%=apartmentreadonly%>">
	<label for="apartmentId"  class="label">Apartment</label>
	<html:select property="apartmentId">
					<html:option value="0">Select one</html:option>
					<html:optionsCollection name="apartments" label="apartmentNumber" value="id" />
	</html:select>
	</p>
	<p>
	<label for="carrier"  class="label">Carrier</label>
	<html:select property="carrier">
					<html:option value="blue">Blue</html:option>
					<html:option value="fast">Fast exp</html:option>
				</html:select>
	</p>

	<p>
	<label for="pieces"  class="label">Pieces</label>
		<html:text styleClass ="textbox" property="pieces"></html:text>
	</p>	

	<p>
	<label for=packageDescription  class="label">Description</label>
	<html:text styleClass ="textbox" property="packageDescription"></html:text>
	</p>
	
	<p>
		<span class="label">Location(Closet)</span>
		<label><html:radio property="packageLocation" value="Main"/>Main</label>
		<label><html:radio property="packageLocation" value="Back" />Back</label>
	</p>

	<p>
	<label for=residentName  class="label">Resident Name</label>
		<html:text styleClass ="textbox" property="residentName"></html:text>
	</p>	
		
		<p>
		<label for=notes  class="label">Notes</label>
			<html:text  styleClass ="textbox"property="notes"></html:text>
		</p>
		<p>
			<label for=subject  class="label">Subject</label>
			<html:text styleClass ="textbox" property="subject"></html:text>
		</p>
		
		<p>
			<label for=message  class="label">Message</label>
			<html:textarea property="message"  cols="30" rows="4" ></html:textarea>
		</p>
		
		
		<p style="display: <%=displaySaveButton %>">
	    		<html:submit property="action" styleClass="save-button">
							<bean:message key="button.save"/>
		    	</html:submit>
	 	 </p>
	 	 
	 	 <p style="display: <%=displayUpdateButton%>">
			<html:submit property="action" styleClass="update-button">
				<bean:message key="button.update"/>
			</html:submit>
			<html:submit property="action" styleClass="delete-button">
				<bean:message key="button.delete"/>
			</html:submit>
	 	 </p>
</html:form> 
</body>
</html:html>
