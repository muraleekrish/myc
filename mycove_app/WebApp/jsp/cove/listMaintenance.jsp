<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.MaintenanceRequestDTO"%>

<%
	Collection<MaintenanceRequestDTO> maintenanceDTOs = (Collection<MaintenanceRequestDTO>) request.getAttribute("maintenance");
%>
<html:html>
<body>

<html:form action="/MaintenanceList.do">
<html:hidden property="formAction" />
 
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<table>
<caption>Maintenance Issues</caption>
<thead>
	<tr>
		<th>Date</th>
		<th>Apartment</th>
		<th>Request</th>
        <th>Location</th>
        
    </tr>
</thead>                
<tbody>			
	<logic:iterate id="main" type="MaintenanceRequestDTO" collection="<%=maintenanceDTOs%>">
				<tr>
				   <td>
				   	<bean:write name="main" property="maintenanceMonth"/>/<bean:write name="main" property="maintenanceDay"/>/<bean:write name="main" property="maintenanceYear"/>
		   		   </td>
		   		   <td>
			   		   <a href='<%=request.getContextPath()%>/maintenanceRequestView.do?formAction=view&requestId=<bean:write name="main" property="id"/>' >
			   		   	<bean:write name="main" property="apartmentNumber"/>&nbsp;
			   		   </a>
		   		   </td>
		  			<td><bean:write name="main" property="request"/></td>
				   <td><bean:write name="main" property="location"/></td>

				</tr>
			</logic:iterate>
</tbody>
</table>
 </html:form>
</body>
</html:html>
