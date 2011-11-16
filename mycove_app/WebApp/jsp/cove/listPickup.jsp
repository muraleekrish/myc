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

<html:form action="/PickupList.do">
<html:hidden property="formAction" />
 
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<a id="add" href="<%=request.getContextPath()%>/addPackage.do?formAction=add">Add</a>

<!-- 		<td class="success" align="center" >
				<logic:messagesPresent message="true">  
					<html:messages id="message" message="true">   
					<bean:write name="message"/> 
					</html:messages>
				</logic:messagesPresent>
			</td>-->
	
<table>
<caption>Package(s)</caption>
<thead>
<tr>
	<th>Date</th>
    <th>Apartment</th>
    <th>Carrier</th>
    <th>Pieces</th>
    <th>PickedUp Date</th>
    <th>PickedUp By</th>
</tr>
</thead>
<tbody>
	<logic:iterate id="packages" type="PackageDTO" collection="<%=packageDTOs%>">
		<tr>
		   <td>
   		   <bean:write name="packages" property="packageMonth"/>/<bean:write name="packages" property="packageDay"/>/<bean:write name="packages" property="packageYear"/>
   		   </td>
   		   <td>
	   		  
			   		<bean:write name="packages" property="apartmentNumber"/>
			   
		   </td>
		   <td><bean:write name="packages" property="carrier"/>&nbsp;</td>
		   <td><bean:write name="packages" property="pieces"/>&nbsp;</td>
		   <td><bean:write name="packages" property="pickupDay"/>/<bean:write name="packages" property="pickupMonth"/>
		   /<bean:write name="packages" property="pickupYear"/></td>
		   <td><bean:write name="packages" property="pickupBy"/>&nbsp;<bean:write name="packages" property="lastName"/></td>
		</tr>
	</logic:iterate>
</tbody>
</table>

 </html:form>
</body>
</html:html>
