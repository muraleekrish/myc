<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.MessageTemplateDTO"%>

<%
	Collection<MessageTemplateDTO> maintenanceDTOs = (Collection<MessageTemplateDTO>) request.getAttribute("template");
%>

<html:html>

<body>

<html:form action="/TemplateList.do">
<html:hidden property="formAction" />
 
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<a id="add" href="<%=request.getContextPath()%>/addTemplate.do?formAction=add">Add</a>

<table>
<caption> Template(s)</caption>
<colgroup>
<col id="name"/>
<col id="subject"/>
<col id="property"/>
</colgroup>
<thead>
 <th>Name</th>
 <th>Subject</th>
  <th>Property Name</th>
</thead>
<tbody>
<logic:iterate id="temp" type="MessageTemplateDTO" collection="<%=maintenanceDTOs%>">
		<tr>
   		   <td>
	   		   <a href='<%=request.getContextPath()%>/addTemplate.do?formAction=edit&templateId=<bean:write name="temp" property="id"/>' >
			   		<bean:write name="temp" property="templateName"/>
			   </a>
		   </td>
		   <td><bean:write name="temp" property="subject"/></td>
		   <td><bean:write name="temp" property="propertyName"/></td>
		</tr>
	</logic:iterate>
</tbody>
</table>

 </html:form>
</body>
</html:html>
