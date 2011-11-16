<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.vo.Customer"%>

<%
	Collection<Customer> customers = (Collection<Customer>) request.getAttribute("customers");
%>

<html:html>
<body>

<html:form action="/EmployeeList.do">
<html:hidden property="formAction" />
 
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<table border="0" cellspacing="0" cellpadding="0" width="98%" align="center">
<tr><td  class="PageTitle">Customer&nbsp;List</td></tr>
<tr><td>&nbsp;</td></tr>
	<tr>
		<td>
			<table border="1px" cellpadding="0" cellspacing="0" width="100%" >
				<tr>
					<td class="GridHeader">Name</td>
					<td class="GridHeader">Primary Contact</td>
					<td class="GridHeader">Email Address</td>
					<td class="GridHeader">Phone Number</td>
				</tr>
			
			<logic:iterate id="customer" type="Customer" collection="<%=customers%>">
				<tr>
				   <td class="GridItems">
				   		<a href='<%=request.getContextPath()%>/ModifyCustomer.do?formAction=edit&customerId=<bean:write name="customer" property="id"/>' >
				   			<bean:write name="customer" property="clientName"/>&nbsp;
			   			</a>
		   		   </td>
				   <td class="GridItems"><bean:write name="customer" property="primaryContactFirstName"/>&nbsp;<bean:write name="customer" property="primaryContactLastName"/></td>
				   <td class="GridItems"><bean:write name="customer" property="primaryContactEmailAddress"/>&nbsp;</td>
				   <td class="GridItems"><bean:write name="customer" property="primaryContactPhoneNumber"/>&nbsp;</td>
				</tr>
			</logic:iterate>
			</table>
		</td>
	</tr>
</table>

 </html:form>
</body>
</html:html>
