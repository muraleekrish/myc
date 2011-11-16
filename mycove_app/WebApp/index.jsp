<%@ page language="java" %>
<script> alert('Index.jsp');</script>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="/WEB-INF/taglibs/taglib.tld" prefix="sbti" %>
<html:html  locale="true">
<html:base/>
	<logic:notPresent name="org.apache.struts.action.MESSAGE" scope="application">
	  <font color="red">
	    ERROR:  Application resources not loaded -- check servlet container logs for error messages.
	  </font>
	</logic:notPresent>
	<jsp:forward page="/sec/Login.do" />
</html:html>


