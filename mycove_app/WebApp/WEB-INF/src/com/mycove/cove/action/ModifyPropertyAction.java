package com.mycove.cove.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import com.mycove.cove.form.ModifyPropertyForm;
import com.mycove.dao.PropertyDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Property;

public class ModifyPropertyAction extends LookupDispatchAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {
			if (form instanceof ModifyPropertyForm) {
				ModifyPropertyForm propertyForm = (ModifyPropertyForm) form;
				if (FormUtil.isNotNull(mapping.getParameter()) 
						&& FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Submit")) {
					return this.submit(mapping, form, request, response);
				}
				else if (FormUtil.isNotNull(mapping.getParameter()) 
						&& FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Update")) {
					return this.update(mapping, form, request, response);
				} 
				else {
					String formAction = FormUtil.setNullToBlank(request.getParameter("formAction"));
					if (formAction.equalsIgnoreCase("edit")) {
						if(FormUtil.isNotNull(request.getParameter("propertyId")))
						{
							
							PropertyDAO propertyDAO = new PropertyDAO();
							Property property = propertyDAO.findById(Long.parseLong(request.getParameter("propertyId")));
							propertyForm = this.mapVOToForm(propertyForm, property);
						}
						action= "input";
					}
					else if(formAction.equalsIgnoreCase("add"))
					{
						action= "input";
					}
					else
					{
						action= "input";
					}
				}
			}
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		
		return mapping.findForward(action);
	}

	/**
	 * @param propertyForm
	 * @param findById
	 * @return
	 */
	private ModifyPropertyForm mapVOToForm(ModifyPropertyForm propertyForm,
			Property property) {
		propertyForm.setId(String.valueOf(property.getId()));
		propertyForm.setPropertyName(FormUtil.setNullToBlank(property.getPropertyName()));
		propertyForm.setBillingAddress1(FormUtil.setNullToBlank(property.getBillingAddressLine1()));
		propertyForm.setBillingAddress2(FormUtil.setNullToBlank(property.getBillingAddressLine2()));
		propertyForm.setBillingCity(FormUtil.setNullToBlank(property.getBillingAddressCity()));
		propertyForm.setBillingState(FormUtil.setNullToBlank(property.getBillingAddressState()));
		propertyForm.setBillingZipCode(FormUtil.setNullToBlank(property.getBillingAddressZipcode()));
		propertyForm.setEmailAddress(FormUtil.setNullToBlank(property.getPrimaryContactEmailAddress()));
		propertyForm.setMailingAddress1(FormUtil.setNullToBlank(property.getMailingAddressLine1()));
		propertyForm.setMailingAddress2(FormUtil.setNullToBlank(property.getMailingAddressLine2()));
		propertyForm.setMailingCity(FormUtil.setNullToBlank(property.getMailingAddressCity()));
		propertyForm.setMailingState(FormUtil.setNullToBlank(property.getMailingAddressState()));
		propertyForm.setMailingZipCode(FormUtil.setNullToBlank(property.getMailingAddressZipcode()));
		propertyForm.setPhoneNumber(FormUtil.setNullToBlank(property.getPrimaryContactPhoneNumber()));
		propertyForm.setPrimaryAdminUserName(FormUtil.setNullToBlank(property.getAdminUserName()));
		propertyForm.setPrimaryContactFirstName(FormUtil.setNullToBlank(property.getPrimaryContactFirstName()));
		propertyForm.setPrimaryContactLastName(FormUtil.setNullToBlank(property.getPrimaryContactLastName()));
		propertyForm.setSecondaryPhoneNumber(FormUtil.setNullToBlank(property.getPrimaryContactSecondaryPhone()));
		return propertyForm;
	}

	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 */
	private ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		String action = "input";
		ModifyPropertyForm propertyForm = (ModifyPropertyForm) form;
		PropertyDAO propertyDAO = new PropertyDAO();
		Property property = propertyDAO.findById(Long.parseLong(propertyForm.getId()));
		property = this.mapFormToVO(property, propertyForm);
		property.setModifiedBy((String) request.getSession().getAttribute("userName"));
		property.setModifiedDate(new Timestamp(new Date().getTime()));
		propertyDAO.update(property);
		action = "success";
		return mapping.findForward(action);
	}

	/**
	 * @param property
	 * @param propertyForm
	 * @return
	 */
	private Property mapFormToVO(Property property,
			ModifyPropertyForm propertyForm) {
		property.setPropertyName(propertyForm.getPropertyName());
		property.setPrimaryContactFirstName(propertyForm.getPrimaryContactFirstName());
		property.setPrimaryContactLastName(propertyForm.getPrimaryContactLastName());
		property.setPrimaryContactEmailAddress(propertyForm.getEmailAddress());
		property.setPrimaryContactPhoneNumber(propertyForm.getPhoneNumber());
		property.setMailingAddressLine1(propertyForm.getMailingAddress1());
		property.setMailingAddressLine2(propertyForm.getMailingAddress2());
		property.setMailingAddressCity(propertyForm.getMailingCity());
		property.setMailingAddressState(propertyForm.getMailingState());
		property.setMailingAddressZipcode(propertyForm.getMailingZipCode());
		property.setBillingAddressLine1(propertyForm.getBillingAddress1());
		property.setBillingAddressLine2(propertyForm.getBillingAddress2());
		property.setBillingAddressCity(propertyForm.getBillingCity());
		property.setBillingAddressState(propertyForm.getBillingState());
		property.setBillingAddressZipcode(propertyForm.getBillingZipCode());
		return property;
	}

	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward submit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = "input";
		try {
			ModifyPropertyForm propertyForm = (ModifyPropertyForm) form;
			Property property = new Property();
			property = this.mapFormToVO(property, propertyForm);
			PropertyDAO propertyDAO = new PropertyDAO();
			propertyDAO.save(property);
			action = "success";
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		}
		return mapping.findForward(action);
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.actions.LookupDispatchAction#getKeyMethodMap()
	 */
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.submit", "submit");
		map.put("button.update", "update");
		return map;
	}
}
