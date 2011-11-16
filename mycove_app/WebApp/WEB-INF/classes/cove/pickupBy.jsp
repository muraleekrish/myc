<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.vo.Apartment"%>
<jsp:useBean id="frm" class="com.mycove.cove.form.AddPackageForm" />
<jsp:setProperty name="frm" property="*" />

<%
Collection<Apartment> apartments = (Collection<Apartment>)request.getAttribute("apartments");
pageContext.setAttribute("apartments", apartments);

	%>
 

<html:html>
<body>
<html:form action="/pickupBy.do">
<html:hidden property="id" />

	<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
		
		<p>
			<label class="label">Date</label>
			<html:text property="date" styleClass="TextBox" readonly="true"></html:text>
		</p>
		 
		<p>
			<label class="label">Apartment</label>
			<html:select property="apartmentId" disabled="true">
					<html:option value="0" >Select one</html:option>
					<html:optionsCollection name="apartments"  label="apartmentNumber" value="id" />
 		   </html:select>
		</p>
		<p>
			<label class="label">Carrier</label>
				<html:select property="carrier" styleClass="ComboBoxWithsize" >
					<html:option value="blue">Blue</html:option>
					<html:option value="fast">Fast exp</html:option>
				</html:select>
		</p>
		<p>
			<label class="label">Pieces</label>
			<html:text property="pieces" styleClass="textbox" readonly="true"></html:text>
		</p>
		<p>
			<label class="label">Description</label>
			<html:text property="packageDescription" styleClass="textbox" readonly="true"></html:text>
		</p>
		<p>
			<label class="label">Location(Closet)</label>
				<html:radio disabled="true" property="packageLocation" value="Main"/>Main
				<html:radio  disabled="true" property="packageLocation" value="Back" />Back
		</p>
		<p>
			<label class="label">Resident Name</label>
			<html:text property="residentName" styleClass="TextBox" readonly="true"></html:text>
		</p>
		<p>
			<label class="label">Notes</label>
			<html:text property="notes" styleClass="textbox" readonly="true" ></html:text>
		</p>
		<p>
			<label class="label">Subject</label>
			<html:text property="subject" styleClass="textbox" readonly="true"></html:text>
		</p>   
		
		<p>
			<label class="label">Pickup Date</label>
			<html:text property="pickupDate" styleClass="TextBox"></html:text>
		</p>
		<p>
			<label class="label">Pickup By</label>
			<html:text property="pickupBy" styleClass="TextBox"></html:text>
		</p>
		<p>	
		<html:submit property="action" styleClass="save-button">
			<bean:message key="button.submit"/>
		</html:submit>
		</p>

</html:form> 
</body>
</html:html>
