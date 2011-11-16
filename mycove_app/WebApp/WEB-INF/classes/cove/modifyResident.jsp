<%@ page language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %>
<html:html>
<body>
<html:form action="/ModifyResident.do" enctype="multipart/form-data">
<html:hidden property="propertyId"></html:hidden>
<html:hidden property="id"></html:hidden>
<jsp:include page="/jsp/pub/header.jsp"  flush="true" />


<h1>Resident Details</h1>

			<p>
					<html:text property="buildingName" styleClass="Textbox"/>
			</p>
			<p>
				<label class="label">Upload Resident</label>
				<html:file property="apartmentFile" styleClass="textbox" />
			</p>
			<p>
					<html:submit property="action"  styleClass="save-button">
						<bean:message key="button.submit"/>
					</html:submit>
			</p>
</html:form>
</body>
</html:html>
