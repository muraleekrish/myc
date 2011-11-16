<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.PropertyDTO"%>

<%
	Collection<PropertyDTO> properties = (Collection<PropertyDTO>) request.getAttribute("properties");
%>


<html:html>
<body>

<html:form action="/PropertyList.do">
 
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<table>
<caption>Properties</caption>
<colgroup>
<col id="name"/>
<col id="contact"/>
<col id="building"/>
</colgroup>
<thead>
<tr>
<th scope="col">Property Name</th>
<th scope="col">Primary Contact</th>
<th scope="col">Building</th>
</tr>
</thead>
<tbody>
 <logic:iterate id="property" type="PropertyDTO" collection="<%=properties%>">
	<tr>
	   <td class="GridItems">
	   		<a href='<%=request.getContextPath()%>/ModifyProperty.do?formAction=edit&propertyId=<bean:write name="property" property="id"/>' >
	   			<bean:write name="property" property="name"/>
   			</a>
  		   </td>
	   <td class="GridItems"><bean:write name="property" property="primaryContactFirstName"/>&nbsp;<bean:write name="property" property="primaryContactLastName"/></td>
	   <td class="GridItems">
	   		<a href='<%=request.getContextPath()%>/BuildingList.do?propertyId=<bean:write name="property" property="id"/>' >
	   			View Buildings
   			</a>
  		   </td>
	</tr>
 </logic:iterate>
</tbody>
</table>

 </html:form>
</body>
</html:html>
