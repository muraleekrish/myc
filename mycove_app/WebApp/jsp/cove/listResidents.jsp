<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.ResidentDTO"%>
<%@page import="com.mycove.vo.Tenant"%>

<%
	Collection<ResidentDTO> residents = (Collection<ResidentDTO>) request.getAttribute("residents");
%>

<html:html>
<body>

<html:form action="/ResidentList.do">
<html:hidden property="formAction" />
 
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<a id="add" href='<%=request.getContextPath()%>/TenantProfile.do?formAction=add'>Add</a></td>
<table id = "resident">
<caption>Resident(s)</caption>
<colgroup>
<col id="name"/>
<col id="building"/>
<col id="apartment"/>
</colgroup>
<thead>
   <th>Name</th>
   <th>Email</th>
   <th>Apartment</th>
</thead>
<tbody>
	<logic:iterate id="tenant" type="ResidentDTO" collection="<%=residents%>">
		<tr>
		   <td>
		   		<a href='<%=request.getContextPath()%>/TenantProfile.do?formAction=update&residentId=<bean:write name="tenant" property="id"/>' >
		   			<bean:write name="tenant" property="firstName"/>&nbsp;<bean:write name="tenant" property="lastName"/>
		   	</a>		
		   			
	   		<td><bean:write name="tenant" property="email"/></td>
		   <td><bean:write name="tenant" property="apartmentNumber"/>/<bean:write name="tenant" property="buildingName"/></td>
		</tr>
	</logic:iterate>

</tbody>
</table>

 </html:form>
</body>
</html:html>
