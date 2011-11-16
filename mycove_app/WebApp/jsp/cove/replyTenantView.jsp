<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %> 
 <jsp:useBean id="frm" class="com.mycove.cove.form.MailViewForm"/>
<jsp:setProperty name="frm" property="*" />
<html:html>
<head>
 <script language="Javascript" type="text/Javascript">
 	
	</script>
<link href="<%=request.getContextPath() %>/shared/styles/tenant_style.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/shared/styles/mycove_style.css" rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath() %>/shared/styles/main.css" rel="stylesheet" type="text/css">
 
</head>
<body>

<html:form action="/inboxTenantView.do">
<html:hidden property="formAction" />


<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
<table><tr><td><input type="button" value="Delete"></td></tr></table>
<table width="100%"  border="0" cellspacing="0" cellpadding="0">


  <tr>
    <td>Date</td>
    <td>&nbsp;</td>
    <td  class="GridItems"><html:text property="subject"></html:text></td>  
    <td>&nbsp;</td>
    <td><html:hidden property="id"></html:hidden></td> 
    
  </tr>
    <tr>
    <td>To</td>
    <td>&nbsp;</td>
    <td  class="GridItems"><html:text  property="to"></html:text></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    
  </tr>
  <tr>
    <td>Subject</td>
    <td>&nbsp;</td>
     <td  class="GridItems"><html:text  property="date"></html:text></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    
  </tr>
  <tr>
    <td></td>
    <td>&nbsp;</td>
    <td><html:textarea property="message" rows="25" cols="50" styleClass="TextArea" ></html:textarea></td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
   
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
    <td>&nbsp;</td>
   
  </tr>
</table>

	
</html:form>
</body>
</html:html>


