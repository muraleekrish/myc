package com.mycove.cove.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;

import com.mycove.cove.form.ModifyCustomerForm;
import com.mycove.dao.CustomerDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Customer;

public class ModifyCustomerAction extends LookupDispatchAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {
			if (form instanceof ModifyCustomerForm) {
				
				ModifyCustomerForm customerForm = (ModifyCustomerForm) form;
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
						if(FormUtil.isNotNull(request.getParameter("customerId")))
						{
							Long customerId = Long.parseLong(request.getParameter("customerId"));
							CustomerDAO customerDAO = new CustomerDAO();
							customerForm = this.mapVOToForm(customerForm, customerDAO.findById(customerId));
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
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}

	/**
	 * @param customerForm
	 * @param findById
	 * @return
	 */
	private ModifyCustomerForm mapVOToForm(ModifyCustomerForm customerForm,
			Customer customer) {

		customerForm.setAddress1(FormUtil.setNullToBlank(customer.getStreetAddress()));
		customerForm.setAddress2(FormUtil.setNullToBlank(customer.getAddress2()));
		customerForm.setCity(FormUtil.setNullToBlank(customer.getCity()));
		customerForm.setCustomerName(FormUtil.setNullToBlank(customer.getClientName()));
		customerForm.setEmailAddress(FormUtil.setNullToBlank(customer.getPrimaryContactEmailAddress()));
		customerForm.setId(FormUtil.setNullToBlank(customer.getId()));
		customerForm.setPhoneNumber(FormUtil.setNullToBlank(customer.getPrimaryContactPhoneNumber()));
		customerForm.setPrimaryContactFirstName(FormUtil.setNullToBlank(customer.getPrimaryContactFirstName()));
		customerForm.setPrimaryContactLastName(FormUtil.setNullToBlank(customer.getPrimaryContactLastName()));
		customerForm.setState(FormUtil.setNullToBlank(customer.getState()));
		customerForm.setZipCode(FormUtil.setNullToBlank(customer.getZipCode()));

		return customerForm;
	}

	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	private ActionForward update(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = "input";
		try {
			
			action = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(action);
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
			
			action = "success";
		} catch (Exception e) {
			e.printStackTrace();
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
