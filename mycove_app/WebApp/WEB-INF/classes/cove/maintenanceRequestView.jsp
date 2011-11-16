 <%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<jsp:useBean id="frm" class="com.mycove.cove.form.MaintenanceRequestForm" />
<jsp:setProperty name="frm" property="*" />
<%
	String username = (String)request.getSession().getAttribute("UserName");
	pageContext.setAttribute("username", username);
	
	
%>

<html:html>
<body>
	<html:form action="/maintenanceRequestView.do">
	<html:hidden property="id"></html:hidden>
	<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
		<p class="alert">
			This form is to be used for NON-EMERGENCIES ONLY</font>
		</p>
		
			<p>
			    <label class ="label">Name</label>
			    <html:text maxlength="30" styleClass="Textbox" property="name" readonly="true"></html:text>
			</p>
			
			<p><label class="label">Apartment Number</label>
			    <html:text maxlength="30" styleClass="TextBox" property="apartment" readonly="true"></html:text>
			</p>
			<p>
				<label class="label">Daytime Phone</label>
				<html:text maxlength="30" styleClass="TextBox" property="contactNo" readonly="true"></html:text>
			</p>
			<p>
				<label class="label">Request</label>
				<html:text maxlength="30" styleClass="TextBox" property="maintenanceRequest" readonly="true"></html:text>
			</p>
			<p>
				<label class="label">Location</label>
					<html:text maxlength="30" styleClass="TextBox" property="maintenanceLocation" readonly="true"></html:text>
			</p>
			<p>
				<label class="label">Description</label>
				<html:textarea property="description" rows="3" cols="30" readonly="true" styleClass="TextArea" style="align:right" ></html:textarea>
			</p>
			<p>
					<html:radio property="permission" value="true"/>I give permission to a maintenance representative to enter my apartment
			</p>
			<p>
				<html:radio property="permission" value="false"/>I DO NOT give permission to enter, please call me to schedule maintenance
			</p>
			<p>
					<html:submit property="action" styleClass="close-button">
						<bean:message key="button.close"/>
					</html:submit>
			</p>
	</html:form>
</body>
</html:html>
