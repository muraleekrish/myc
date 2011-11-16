<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.EmployeeDTO"%>

<%
	Collection<EmployeeDTO> employeeDTOs = (Collection<EmployeeDTO>) request.getAttribute("employees");
%>

<html:html>
<body>

<html:form action="/EmployeeList.do">
<html:hidden property="formAction" />
 
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
<a id="add" href="<%=request.getContextPath()%>/EmployeeProfile.do?formAction=add">Add</a>


<table>
<caption>Employee(s)</caption>
<colgroup>
<col id="name"/>
<col id="type"/>
<col id="isActive"/>
<col id="propertyName"/>
</colgroup>
<thead>
<tr>
<th scope="col">Name</th>
<th scope="col">Type</th>
<th scope="col">Active</th>
<th scope="col">Property Name</th>
</tr>
</thead>
<tbody>
	<logic:iterate id="employee" type="EmployeeDTO" collection="<%=employeeDTOs%>">
		<tr>
		   <td>
		   		<a href='<%=request.getContextPath()%>/EmployeeProfile.do?formAction=edit&employeeId=<bean:write name="employee" property="id"/>' >
		   			<bean:write name="employee" property="firstName"/>&nbsp;
		   			<bean:write name="employee" property="lastName"/>
	   			</a>
   		   </td>
		   <td><bean:write name="employee" property="employeeType"/>&nbsp;</td>
		   <td><bean:write name="employee" property="active"/>&nbsp;</td>
		   <td><bean:write name="employee" property="propertyName"/>&nbsp;</td>
		</tr>
	</logic:iterate>
		
</tbody>	
</table>

 </html:form>
</body>
</html:html>
