<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<jsp:useBean id="inbox" class="com.mycove.cove.form.MailBoxForm" />
<jsp:setProperty name="inbox" property="*" />
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.Message"%>

<%
Collection<Message> messageList = (Collection<Message>) request.getAttribute("messages");


%>
<script language="Javascript" type="text/Javascript">
      
	var folderName = '<%=request.getParameter("folderName")%>';
	if(folderName == 'SEND ITEMS')
	{
		document.getElementById('senditem').style.display = 'block';
		document.getElementById('inbox').style.display = 'none';
		 
	}
	else
	{
		document.getElementById('inbox').style.display = 'block';
		document.getElementById('senditem').style.display = 'none';
	}
</script>
<html:html>
<body>

<script language="Javascript" type="text/Javascript">

function viewId(msgid)
	{
		temp=document.forms[0];
		temp.action='<%=request.getContextPath()%>/inboxTenantView.do?msgid='+msgid;
		temp.submit();
	}
function re()
{
	window.location.reload();
	 
}

</script>
<html:form action="/MailBox.do">
<html:hidden property="formAction" />
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
<div class="appMessage">
	<!--<logic:messagesPresent message="true">  
	<html:messages id="message" message="true">   
	<bean:write name="message"/><br/>   
	</html:messages>
	</logic:messagesPresent>-->
</div>

<div class = "messageHeader">
	<div>
		 <a id="inbox" href='<%=request.getContextPath()%>/MailBox.do'>Inbox</a>
		<span>
		 <a id="sent" href='<%=request.getContextPath()%>/MailBox.do?folderName=SEND ITEMS'>Sent Items</a>
		 
		</span>
	</div>	
	
	<!-- <div id="senditem">
		Sent Items
		<span class = "sent">
		<a href='<%=request.getContextPath()%>/MailBox.do'>Inbox</a>
		</span>
	</div> -->
</div>

		
	<div class="messages">
	 <logic:iterate id="message" type="Message" collection="<%=messageList%>">
		<div class= "message">
			<div class = "messageImage">
				<img src="<%=request.getContextPath()%>/shared/images/icon_no.jpg" border="0" />
			</div>
			
		<div class= "messageContent">
			<div class="messageRow, userName"><bean:write name="message" property="fromUserName"/></div>
			
			<div class= "messageRow">
				<a href='<%=request.getContextPath()%>/MailView.do?msgid=<bean:write name="message" property="id"/>' >
				<bean:write name="message" property="subject"/>
				</a>
			</div>
			
			<div class = "messageRow">
			<bean:write name="message" property="mailDate"/>
			</div>
			
		</div>
			
		
		
		</div>
		</logic:iterate>
	</div>

 

</html:form>
</body>
</html:html>
