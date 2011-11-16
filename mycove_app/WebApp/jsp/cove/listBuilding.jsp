<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.BuildingDTO"%>

<%
	Collection<BuildingDTO> buildings = (Collection<BuildingDTO>) request.getAttribute("buildings");
%>



<html:html>
<body>

<html:form action="/BuildingList.do">
<html:hidden property="propertyId" />
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />



<a id="add" href='<%=request.getContextPath()%>/ModifyBuilding.do?formAction=add&propertyId=<%=request.getAttribute("propertyId")%>'>Add&nbsp;Building</a>


<table>
<caption>Building(s)</caption>
<colgroup>
<col id="name"/>
<col id="count"/>
</colgroup>
<thead>
<tr>
<th scope="col">Building Name</th>
<th scope="col"># Apartments</th>
</tr>
</thead>
<tbody>

	<logic:iterate id="building" type="BuildingDTO" collection="<%=buildings%>">
	<tr>
	   	<td>
			<a href='<%=request.getContextPath() %>/ModifyBuilding.do?formAction=edit&propertyId=<%=request.getAttribute("propertyId")%>&buildingId=<bean:write name="building" property="id"/>' >
				<bean:write name="building" property="name"/>
			</a>
  		</td>
	   <td><bean:write name="building" property="apartmentCount"/></td>
	</tr>
	</logic:iterate>

</tbody>
</table>

 </html:form>
</body>
</html:html>
