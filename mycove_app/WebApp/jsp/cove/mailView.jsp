<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %> 
 <jsp:useBean id="frm" class="com.mycove.cove.form.MailViewForm"/>
<jsp:setProperty name="frm" property="*" />
<script language="Javascript" type="text/Javascript">

function back()
{   
	temp=document.forms[0];
	temp.action='<%=request.getContextPath()%>/MailBox.do';
	temp.submit();

	}
 
</script>
<html:html>
<head>
 <script src="http://code.jquery.com/jquery-1.5.js"></script>
 <script language="Javascript" type="text/Javascript">
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

<html:form action="/MailView.do" focus="replyMessage">
<html:hidden property="formAction" />
<html:hidden property="id"></html:hidden>
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
<div id="add" style="display:<%=readonlytrue%>">
			<a href='<%=request.getContextPath()%>/MailView.do?msgid=<%=request.getParameter("msgid")%>&formAction=change'>Reply&nbsp;</a>
			<a href='<%=request.getContextPath()%>/mailreplyall.do?msgid=<%=request.getParameter("msgid")%>'>Reply&nbsp;All</a> 
	     <%
			if(!((String)session.getAttribute("roleName")).equalsIgnoreCase("resident"))
			{ 	%>
			<a href='<%=request.getContextPath()%>/MailForward.do?msgid=<%=request.getParameter("msgid")%>'>Forward</a>
			<%} %>
	

</div>
<h1>Mail View</h1>
 
				<p style="display:<%=readonlytrue%>">
					<label class="label">Date</label>
					<html:text styleClass="textbox" property="date" readonly="true" />
								</p>
				<p style="display:<%=readonlytrue%>">
					<label class="label">From</label>
					<html:text styleClass="textbox" property="from" readonly="true" />  
				</p>
				<p style="display:<%=readonlyfalse%>">
					<label class="label">To</label>
					<html:text styleClass="textbox" property="from" readonly="true" />  
				</p>
				<p style="display:<%=readonlytrue%>">
					<label class="label">To</label>
					<html:text styleClass="textbox" property="to" readonly="true" />
				</p>
				<p>
					<label class="label">Subject</label>
					<html:text styleClass="textbox" property="subject"></html:text>
				</p>	
				
				<p  style="display:<%=readonlyfalse %>">	                 	
					<label class="label">Message</label><html:textarea  property="replyMessage"  styleClass="big_textarea" ></html:textarea>
				</p>
				<p  style="display:<%=readonlytrue %>">	                 	
					<label class="label">Message</label><html:textarea readonly="true" property="message" styleClass="big_textarea" ></html:textarea>
				</p>
			
		
		   
		   
	<p>
	                       
			<span style="display:<%=readonlyfalse %>"> 
			<html:submit property="action" styleClass="replyAll-button">
				<bean:message key="button.send" />
			</html:submit></span> 
			<span style="display:<%=readonlytrue %>"> 
			<html:submit property="action" styleClass="update-button" onclick="back()">
				<bean:message key="button.back" />
			</html:submit></span>
			<span style="display:<%=readonlytrue %>">
			<html:submit property="action" styleClass="delete-button">
				<bean:message key="button.delete" />
			</html:submit></span>
			 
	</p>
	 

</html:form>
</body>
</html:html>


