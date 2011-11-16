<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %> 
 <jsp:useBean id="frm" class="com.mycove.cove.form.MailViewForm"/>
 <%@page import="com.mycove.dto.ResidentDTO"%>
 <%@page import="java.util.Collection"%>
<jsp:setProperty name="frm" property="*" />
<% 
 
 //String displayReplyButton = "none;";
	//String displayDeleteButton = "none;";
Collection<ResidentDTO> residents = (Collection<ResidentDTO>) request.getAttribute("residents");
pageContext.setAttribute("residents", residents);
 %>
 
<html:html>
<head>
 <script src="http://code.jquery.com/jquery-1.5.js"></script>
 <script language="Javascript" type="text/Javascript">
 
 

 //function forw()
 {
 	 temp=document.forms[0];
 	temp.action='<%=request.getContextPath()%>/MailView.do?formAction=forw';
     temp.submit();
 }
  
<%
 


String formAction = "";
String readonlyfalse = "none;";
String readonlytrue="block;";
 
if(request.getParameter("formAction") != null)
{
if(request.getParameter("formAction").equalsIgnoreCase("change"))
{
	 
	readonlyfalse = "block;";
	readonlytrue = "none;";
    
	
}
}

%>
     
	
	</script>
	  
 
</head>
<body>

<html:form action="/MailForward.do" focus="replyMessage" >
<html:hidden property="formAction" />
<html:hidden property="id"></html:hidden>
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<h1>Mail Forward</h1>
                  
				
				<p> 
                   <label class="label">To</label>
                    <html:select  property="residentId" size="5" styleClass="ComboBoxWithsize1" multiple="true">
					
					<html:optionsCollection name="residents" label="firstName" value="id" />
					</html:select>
               </p>
              
                   
				<p>
					<label class="label">Subject</label>
					<html:text styleClass="textbox" property="subject"></html:text>
				</p>	
				
				<p >	                 	
					<label class="label">Message</label><html:textarea   property="replyMessage" styleClass="big_textarea" ></html:textarea>
				</p>
							
		 
		   
	<p>
	                       
			 
			<html:submit property="action" styleClass="update-button" onclick="forw()">
				<bean:message key="button.forward" />
			</html:submit> 
		
	</p>
	 

</html:form>
</body>
</html:html>


