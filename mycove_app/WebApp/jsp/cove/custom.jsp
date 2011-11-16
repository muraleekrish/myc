 <%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.vo.Apartment"%>
<%@page import="com.mycove.dao.ApartmentDAO"%>
<jsp:useBean id="frm" class="com.mycove.cove.form.AddTemplateForm" />
<jsp:setProperty name="frm" property="*" />
<%
Collection<Apartment> apartments = (Collection<Apartment>)request.getAttribute("apartments");
pageContext.setAttribute("apartments", apartments);
%>

  
<html:html>
<head>

<script language="Javascript" type="text/Javascript">
 
 
	
	</script>
</head>
<body>
<html:form action="/custom.do">
<html:hidden property="formAction" />
<html:hidden property="sendMessage"/>
<html:hidden property="residentId"/>
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<h1>Add Custom Message</h1>
 <p>
    <label for="customsubject" class="label">Subject</label>
    <html:text maxlength="50" property="customsubject" styleClass="textbox"></html:text>
  </p>
  <p>
    <label for="custommessageText" class="label">Message</label>
 	<html:textarea property="custommessageText" rows="3" styleClass="TextArea" ></html:textarea>
  </p>
  
  <p>
  	<html:submit property="action" styleClass="save-button">
	<bean:message key="button.notification"/>
	</html:submit>
 </p>
</html:form> 
</body>
</html:html>
