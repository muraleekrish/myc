<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.PackageDTO"%>

<%
	Collection<PackageDTO> packageDTOs = (Collection<PackageDTO>) request.getAttribute("packages");
%>

<html:html>
<body>

<html:form action="/PackageList.do">
<html:hidden property="formAction" />
 
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<div id="add">
	
	<a href="<%=request.getContextPath()%>/PickupList.do">Pickup&nbsp;List</a>
	<a href="<%=request.getContextPath()%>/addPackage.do?formAction=add">Add</a>
</div>

<table id="#packages">
<caption>Package(s)</caption>
<colgroup>
<col id="date"/>
<col id="apartment"/>
<col id="carrier"/>
<col id="pieces"/>
<col id="location"/>
<col id="resident"/>
</colgroup>

<thead>
<tr>
<th>Date</th>
<th>Apartment</th>
<th>Carrier</th>
<th>Pieces</th>
<th>Location</th>
<th>Resident</th>
<th>Status</th>
</tr>
</thead>
<tbody>
	<logic:iterate id="packages" type="PackageDTO" collection="<%=packageDTOs%>">
		<tr>
		   <td><bean:write name="packages" property="packageMonth"/>/<bean:write name="packages" property="packageDay"/>/<bean:write name="packages" property="packageYear"/></td>
   		   <td><a href='<%=request.getContextPath()%>/addPackage.do?formAction=edit&packageId=<bean:write name="packages" property="id"/>' >			   		
   		   <bean:write name="packages" property="apartmentNumber"/></a>
		   </td>
		   <td><bean:write name="packages" property="carrier"/></td>
		   <td><bean:write name="packages" property="pieces"/></td>
		   <td><bean:write name="packages" property="packageLocation"/></td>
		   <td><bean:write name="packages" property="firstName"/>&nbsp;<bean:write name="packages" property="lastName"/></td>
		   <td class="GridItems"><a href='<%=request.getContextPath()%>/pickupBy.do?formAction=view&packageId=<bean:write name="packages" property="id"/>' >
					   		Update Pickup
					   </a></td>
		</tr>
	</logic:iterate>
</table>

 </html:form>
</body>
</html:html>
