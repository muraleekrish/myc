 <%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<jsp:useBean id="frm" class="com.mycove.cove.form.MaintenanceRequestForm" />
<jsp:setProperty name="frm" property="*" />
<%@page import="com.mycove.dao.ApartmentDAO"%>
<%@page import="com.mycove.vo.Apartment"%>

 <script src="http://code.jquery.com/jquery-1.5.js">  </script>
<script language="Javascript" type="text/Javascript">
$(document).ready(function(){  
	var $remaining = $('#remaining'), 
	   $messages = $remaining.next();   
      $('#message').keyup(function(){   
       var chars = this.value.length,  
       messages = Math.ceil(chars / 160),  
     remaining = messages * 160 - (chars % (messages * 160) || messages * 160);   
      $remaining.text(remaining + ' characters remaining');     
      $messages.text(messages + ' message(s)');     }); }); 
</script>
<%
	String username = (String)request.getSession().getAttribute("UserName");
	pageContext.setAttribute("username", username);
	
	if(request.getSession().getAttribute("userId")==null)
    {
		
		System.out.println("userid123"+request.getSession().getAttribute("userId"));
        response.sendRedirect("/sec/Login.do");
    
    }
	
%>

<html:html>
<body>
	<html:form action="/maintenanceRequest.do">
	<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
	<p class="alert">
	This form is to be used for NON-EMERGENCIES ONLY
	</p>
	  
	 
	<p>
	   <label class="label">Name:</label> <label class="read_only_value"><%=request.getSession().getAttribute("firstName") %></label>
	</p>
	<p>   
	   <label class="label">Apartment No:</label> <label class ="read_only_value"><%=request.getSession().getAttribute("ApartmentNo")%></label>
	</p>

	<p>
	<label class="label">Day Phone:</label>
	<html:text maxlength="30" styleClass="textbox" property="contactNo"></html:text>
	</p>
	
	<p>
	<label class="label">Request Type</label>
		<html:select property="maintenanceRequest">
						<html:option value=" ">Select</html:option>
						<html:option value="Water leakage">Water leakage</html:option>
						<html:option value="Electrical Appliance">Electrical Appliance</html:option>
						<html:option value="Air conditioning">Air Conditioning</html:option>
	  					<html:option value="Heater">Heater</html:option>
	</html:select>
	</p>

	<p>
	<label class="label">Location</label>
	<html:select property="maintenanceLocation">
		<html:option value=" ">Select</html:option>
		<html:option value="Living Room">Living Room</html:option>
		<html:option value="Kitchen">Kitchen</html:option>
		<html:option value="Bath Room">Bath Room</html:option>
		<html:option value="Bed Room">Bed Room</html:option>
	</html:select>
	</p>
	
	<p>
		<label class="label">Description</label>
						  
					 <textarea name="description" value="" id="message" maxlength="160"></textarea> 
						    <span id="remaining">160 characters remaining</span>       
	</p>
	
			<p>
				<html:radio property="permission" value="true"/>I give permission to a maintenance representative to enter my apartment
			</p>
			<p>	
				<html:radio property="permission"  value="false" />I DO NOT give permission to enter, please call me to schedule maintenance 
			</p>
			
			<p>
					<html:submit property="action" styleClass="save-button">
						<bean:message key="button.submit"/>
					</html:submit>
			</p>
	</html:form>
</body>
</html:html>
