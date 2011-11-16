<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@page import="java.util.Collection"%>
<%@page import="com.mycove.dto.MaintenanceDTO"%>
<%@page import="com.mycove.vo.Survey"%>
<%
	Collection<Survey> surveyDTOs = (Collection<Survey>) request.getAttribute("surveys");
%>

<html:html>
<body>

<html:form action="/SurveyList.do">
<html:hidden property="formAction" />
 
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<table>
<caption>Survey(s)</caption>
<thead>
<tr>
	<th>Question</th>
    <th>StartDate</th>
    <th>EndDate</th>
 </tr>  
</thead>
<tbody>
		<logic:iterate id="sur" type="Survey" collection="<%=surveyDTOs%>">
			<tr>
			   <td>
			   		
			   			<bean:write name="sur" property="question"/>
			   			
		   					   		   </td>
		       <td><bean:write name="sur" property="startYear"/>/
		       <bean:write name="sur" property="startMonth"/>/
		       <bean:write name="sur" property="startDay"/></td>
			   <td><bean:write name="sur" property="endYear"/>/
			   <bean:write name="sur" property="endMonth"/>/
			   <bean:write name="sur" property="endDay"/></td>
			   
			   
			</tr>
		</logic:iterate>
</tbody>
</table>

 </html:form>
</body>
</html:html>
