<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.PropertyDTO"%>
<jsp:useBean id="frm" class="com.mycove.cove.form.AddTemplateForm" />
<jsp:setProperty name="frm" property="*" />
<%
Collection<PropertyDTO> properties = (Collection<PropertyDTO>)request.getAttribute("properties");
pageContext.setAttribute("properties", properties);
	String displaySaveButton = "none;";
	String displayUpdateButton = "none;";
	String titleadd = "none;";
	String titleedit = "none;";	
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
			titleadd ="block;";
			titleedit="none;";
		}
		else if (((String)session.getAttribute("formAction")).equalsIgnoreCase("edit") || ((String)session.getAttribute("formAction")).equalsIgnoreCase("update"))
		{
			displaySaveButton = "none;";
			displayUpdateButton = "block;";
			titleadd ="none;";
			titleedit="block;";
		}
		
	}
%>

<html:html>
<body>
<html:form action="/addTemplate.do" method="post">
	<html:hidden property="id" />
	<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
	<h1 style="display: <%=titleadd%>">Add Template</h1>
	<h1 style="display: <%=titleedit%>">Edit Template</h1>
	<p>
	<label for="properties" class="label">Property</label>
	<html:select property="propertyId">
		<html:option value=" ">Select one</html:option>
		<html:optionsCollection name="properties" label="name" value="id" />
 	</html:select>
	</p>
	
	<p>			
	 <label for="templateName" class="label">Template</label>
	 <html:text styleClass="textbox" property="templateName" ></html:text>
	</p>				
 	<p>
	 <label for="subject" class="label">Subject</label>
	 <html:text styleClass="TextBox" maxlength="50" property="subject"></html:text>
	</p>
	<p>
		
		<label for="messageText" class="label">Message</label>
		<html:textarea property="messageText" rows="10" cols="30" styleClass="TextArea" ></html:textarea>
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
