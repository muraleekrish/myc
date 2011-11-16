<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<jsp:useBean id="frm" class="com.mycove.cove.form.AddSurveyForm" />
<jsp:setProperty name="frm" property="*" />
<%
 String username = (String)request.getSession().getAttribute("UserName");
pageContext.setAttribute("username", username);
%>
  
<html:html>
<head>
<!-- 
<link href="shared/styles/tenant_style.css" rel="stylesheet" type="text/css">
<link href="shared/styles/mycove_style.css" rel="stylesheet" type="text/css">
<link href="shared/styles/main.css" rel="stylesheet" type="text/css">
 -->

<script language="Javascript" type="text/Javascript">
 
function onclick()
{
	document.forms[0].action = "/jsp/cove/maintenanceRequest.jsp";
	document.forms[0].submit();
	 
}
function save()
{
	temp = document.forms[0];
	temp.formAction.value = "save";
	temp.submit();
}	
 
	function sento()
	{
		temp = document.forms[0];
		temp.formAction.value = "add";
		temp.submit();

		
	}
	</script>
</head>
<body>
<html:form action="/pmAddSurvey.do">
<html:hidden property="formAction" />
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />

<table width="100%"  border="0" cellspacing="0" cellpadding="0">
  <tr>
  <br>
  <td align="center"><label>Start&nbsp;Date&nbsp;:</label></td>
    <td class="ComboBox"><html:select property="startYear" >
					<html:option value="G1">2001</html:option>
					<html:option value="G2">2002</html:option>
					<html:option value="G3">2003</html:option>
					<html:option value="G4">2004</html:option>
				</html:select></td>
	 <td class="ComboBox"><html:select property="startMonth" >
					<html:option value="G1">1</html:option>
					<html:option value="G2">2</html:option>
					<html:option value="G3">3</html:option>
					<html:option value="G4">4</html:option>
				</html:select></td>
	 <td class="ComboBox"><html:select property="startDate" >
					<html:option value="G1">1</html:option>
					<html:option value="G2">2</html:option>
					<html:option value="G3">3</html:option>
					<html:option value="G4">4</html:option>
				</html:select></td>
	<td width="70%"></td>
  </tr>
  <tr><td align="center" ><label>End&nbsp;Date&nbsp;:</label></td>
 <td class="ComboBox"><html:select property="endYear" >
					<html:option value="G1">2001</html:option>
					<html:option value="G2">2002</html:option>
					<html:option value="G3">2003</html:option>
					<html:option value="G4">2004</html:option>
				</html:select></td>
	 <td class="ComboBox"><html:select property="endMonth" >
					<html:option value="G1">1</html:option>
					<html:option value="G2">2</html:option>
					<html:option value="G3">3</html:option>
					<html:option value="G4">4</html:option>
				</html:select></td>
	 <td class="ComboBox"><html:select property="endDate" >
					<html:option value="G1">1</html:option>
					<html:option value="G2">2</html:option>
					<html:option value="G3">3</html:option>
					<html:option value="G4">4</html:option>
				</html:select></td>
	<td width="70%"></td>
	</tr>
  </table>
<br>


<table width="100%"  border="0" cellspacing="0" cellpadding="1">

<tr>
    <td width="5%">&nbsp;</td>
    <td><label>Select&nbsp;Property</label></td>
    <td>&nbsp;</td>
    <td class="ComboBox"><html:select property="property" styleClass="ComboBoxWithsize">
					<html:option value="0">Select</html:option>
					</html:select></td>
    <td width="60%">&nbsp;</td>
  </tr>
<tr>
   <td>&nbsp;</td>
    <td><label>Message</label></td>
    <td>&nbsp;</td>
    
    <td><html:textarea property="message" rows="3" styleClass="TextArea" ></html:textarea></td>
    <td>&nbsp;</td>
  </tr>  
  <tr>
     <td>&nbsp;</td>
    <td><label>Option&nbsp;1</label></td>
    <td>&nbsp;</td>
    <td class="TextField"><html:text property="option1" styleClass="TextBoxMandatory"></html:text></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><label>Option&nbsp;2</label></td>
    <td>&nbsp;</td>
    <td class="TextField"><html:text property="option2" styleClass="TextBoxMandatory"></html:text></td>
    <td>&nbsp;</td>
  </tr>
 <tr>
    <td>&nbsp;</td>
    <td><label>Option&nbsp;3</label></td>
    <td>&nbsp;</td>
    <td class="TextField"><html:text property="option3" styleClass="TextBoxMandatory"></html:text></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><label>Option&nbsp;4</label></td>
    <td>&nbsp;</td>
    <td class="TextField"><html:text property="option4" styleClass="TextBoxMandatory"></html:text></td>
    <td>&nbsp;</td>
  </tr>
  <tr>
    <td>&nbsp;</td>
    <td><label>Option&nbsp;5</label></td>
    <td>&nbsp;</td>
    <td class="TextField"><html:text property="option5" styleClass="TextBoxMandatory"></html:text></td>
    <td>&nbsp;</td>
  </tr>
  
  
  
</table>
<table><tr>
				<td colspan="2" align="center">
					<html:submit property="action" styleClass="Buttons">
						<bean:message key="button.submit"/>
					</html:submit>
				</td>
			</tr>
			<tr><td></td>
<br>
<td width="60%"><td><img src='<%=request.getContextPath() %>/shared/images/send_to.jpg'onclick="sento();"></img>
</td></tr>
</table>

</html:form> 
</body>
</html:html>
