package com.mycove.cove.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.dao.CustomerDAO;
import com.mycove.vo.Customer;

public class CustomerListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {
			CustomerDAO customerDAO = new CustomerDAO();
			Collection<Customer> customers = customerDAO.findAll();
			request.setAttribute("customers", customers);
			action = "input";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}
}
