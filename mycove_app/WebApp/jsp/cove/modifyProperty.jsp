<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8" isErrorPage="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-html-el.tld" prefix="html"%>
<%@ taglib uri="/WEB-INF/taglibs/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/taglibs/struts-logic.tld" prefix="logic" %> 
<jsp:useBean id="frm" class="com.mycove.cove.form.ModifyPropertyForm"/>
<jsp:setProperty name="frm" property="*" />
<script language = "Javascript" type = "text/Javascript">

function copyTheSameAddressIfChecked() 
{
	temp = document.forms[0];	
	if(temp.sameAddress.checked)
	{		
        temp.billingAddress1.value = temp.mailingAddress1.value;
        temp.billingAddress2.value = temp.mailingAddress2.value;
        temp.billingCity.value = temp.mailingCity.value;
        temp.billingState.value = temp.mailingState.value;
        temp.billingZipCode.value = temp.mailingZipCode.value;
        Disable(true);
     }
}
function fillSameAddress()
{
	temp = document.forms[0];
	
	if(temp.sameAddress.checked)
	{		
		copyTheSameAddressIfChecked();
    }
    else 
    {
    	temp.billingAddress1.value = '';
	    temp.billingAddress2.value = '';
    	temp.billingCity.value='';
	    temp.billingState.value = '';
    	temp.billingZipCode.value = '';
        Disable(false);
    }
}
</script>
<html:html>
<body>



<html:form action="/ModifyProperty.do" >
<html:hidden property="id" />
	<jsp:include page="/jsp/pub/header.jsp"  flush="true" />
	<h1>Property Details</h1>
	
	<p>
	<label for=propertyName class="label">Property Name</label>
	<html:text styleClass="textbox" property="propertyName" readonly="true"></html:text>
	</p>
	
	<h2>Primary Contact</h2>
	
	<p>
	<label for="primaryContactFirstName" class="label">First Name</label>
	<html:text styleClass="textbox" property="primaryContactFirstName" ></html:text>
	</p> 	
	
	<p>
	<label for="primaryContactLastName" class="label">Last Name</label>
	<html:text styleClass="textbox" property="primaryContactLastName" ></html:text>
	</p> 	
		
		<p>
				
			<label for="emailAddress" class="label">Email</label> 
			<html:text styleClass="TextBox" property="emailAddress" ></html:text>
		</p>	
		 <p>
			<label for="phoneNumber" class="label">Contact #</label> 
			<html:text styleClass="TextBox" property="phoneNumber" ></html:text>
		</p>	

		<h2>Mailing Address</h2>
		<p> 
			<label for="mailingAddress1" class="label">Address</label> 
			<html:text styleClass="TextBox" property="mailingAddress1" ></html:text>
		</p>
		
		<p>
			<label for="mailingAddress2" class="label">Address2 (optional)</label>
			<html:text styleClass="TextBox" property="mailingAddress2" ></html:text>
		</p>
		
		<p>
			<label for="mailingCity" class="label">City</label> 
			<html:text styleClass="TextBox" property="mailingCity" ></html:text>
		</p>
		<p>
			<label for="mailingState" class="label">State</label> 
			<html:text styleClass="TextBox" property="mailingState" ></html:text>
		</p>
		<p>
			<label for="mailingZipCode" class="label">Zip Code</label> 
			<html:text styleClass="TextBox" property="mailingZipCode" ></html:text>
		</p>
		 
		<h2>Billing Address</h2>
		
		<p>
		<label for ="sameAddress" class="label">Use mailing address</label>
        <html:checkbox property="sameAddress" styleClass="checkBox"  onclick="fillSameAddress()"> </html:checkbox>
		</p>
		<p> 
			<label for="billingAddress1" class="label">Address</label> 
			<html:text styleClass="TextBox" property="billingAddress1" ></html:text>
		</p>
		<p>
			<label for="billingAddress2" class="label">Address2 (optional)</label>
			<html:text styleClass="TextBox" property="billingAddress2" ></html:text>
		</p>
		<p>
			<label for="billingCity" class="label">City</label> 
			<html:text styleClass="TextBox" property="billingCity" ></html:text>
		</p>
		<p>
			<label for="billingState" class="label">State</label> 
			 <html:text styleClass="TextBox" property="billingState" ></html:text>
		</p> 
		<p>
			<label for="billingZipCode" class="label">Zip Code</label> 
			<html:text styleClass="TextBox" property="billingZipCode" ></html:text>
		</p>
		<p>
			<html:submit property="action" styleClass="save-button">
				<bean:message key="button.update"/>
			</html:submit>
		</p>
	
</html:form>
</body>
</html:html>
