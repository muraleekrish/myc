<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.ResidentDTO"%>
<%@page import="com.mycove.dto.MessageTemplateDTO"%>
<%@page import="com.mycove.dto.PropertyDTO"%>
<%@page import="com.mycove.dto.BuildingDTO"%>
<%@page import="com.mycove.vo.MessageTemplate"%>
<jsp:useBean id="frm" class="com.mycove.cove.form.SendNotificationListForm" />
<jsp:setProperty name="frm" property="*" />
<script language="Javascript" type="text/Javascript">

function getBuilding()
{ 
	 

	var temp = document.forms[0];
	var propertyId = temp.propertyId.value;
	//alert(propertyId);
	var url = '<%=request.getContextPath()%>/servlet/BuildingDetailServlet';
	var param = 'propertyId='+propertyId+'&formAction=getBuilding'; 
	 
	
		if (window.XMLHttpRequest) // Non-IE browsers
	{	 
		var req = new Ajax.Request(url,{method: 'get', parameters: param, onComplete: loadBuilding});
		alert(propertyId);
		alert(req);
	}
	else if (window.ActiveXObject) // IE
	{
		var req = new ActiveXObject("Microsoft.XMLHTTP");
		if (req)
		{
			req = new Ajax.Request(url,{method: 'get', parameters: param, onComplete: loadBuilding});
		}
	}
}

function loadBuilding(req)
{
	var tmp = document.forms[0];
	var resString = req.responseText;
	
	document.getElementById("id_build3").innerHTML = "<select name='buildingId' class='selectMandatory' style='width:135px'>" + req.responseText + "</select>";
	/*if(tmp.gradeItemName.options.length == 2)
	{
		tmp.gradeItemName.options[1].selected = true;
		getItemCodes();
	}*/
}
</script>
<%


Collection<ResidentDTO> residents = (Collection<ResidentDTO>) request.getAttribute("residents");
Collection<PropertyDTO> properties = (Collection<PropertyDTO>)request.getAttribute("properties");
Collection<MessageTemplateDTO> templates = (Collection<MessageTemplateDTO>) request.getAttribute("templates");
Collection<BuildingDTO> buildings = (Collection<BuildingDTO>) request.getAttribute("buildings");


pageContext.setAttribute("templates",templates);
pageContext.setAttribute("properties", properties);
pageContext.setAttribute("residents", residents);
pageContext.setAttribute("buildings", buildings);

    
%>

<html:html>
<body>

<html:form action="/notificationList.do">
<html:hidden property="formAction" />
 
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<h1>Send Notification</h1>
<!--  
<p>	
<label class="label">Property Name</label>
		<html:select property="propertyId" onchange="getBuilding()">
		<html:option value=" ">Select one</html:option>
	    <html:optionsCollection name="properties" label="name" value="id" />
		</html:select>
</p>

<p>
<label class="label">Building Name</label>
<span id="id_build3"> <select name="buildingId" >
	<option value="0">Select one</option>
</select></span>
</p>
	-->
<p>
<label class="label">Template Name</label>
		<html:select property="templateId">
		<html:option value="">select</html:option>
		<html:option value="custom">Custom message</html:option>
	    <html:optionsCollection name="templates" label="templateName" value="id" />
		</html:select>
</p>		

<p>
<label class="label">Recipient(s)</label>
 <html:radio property="sendMessage" value="1" /><span class="radio">All</span>
 <html:radio property="sendMessage" value="2" /><span class="radio">Selected Resident(s)</span>
</p>

<p>
<label class="label">Resident List</label>
<html:select  property="residentId" size="5" styleClass="ComboBoxWithsize1" multiple="true">
<html:option value=" ">Select one</html:option>
<html:optionsCollection name="residents" label="apartmentNumber" value="id" />
</html:select>
</p>

<p>
			<html:submit property="action" styleClass="save-button">
				<bean:message key="button.notification"/>
			</html:submit>
</p>
 </html:form>
</body>
</html:html>
