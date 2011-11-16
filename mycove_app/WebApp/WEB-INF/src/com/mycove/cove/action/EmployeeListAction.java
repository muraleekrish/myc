package com.mycove.cove.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.cove.form.EmployeeListForm;
import com.mycove.dao.EmployeeDAO;
import com.mycove.dto.EmployeeDTO;

public class EmployeeListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {

			if (form instanceof EmployeeListForm) {
				HttpSession session = request.getSession();
				EmployeeDAO employeeDAO = new EmployeeDAO();
				 
				session.setAttribute("formAction", null);
				session.removeAttribute("formAction");
				Collection<EmployeeDTO> employeeDTOs = employeeDAO.getEmployeeByUserName((Long) session.getAttribute("userId"));
				request.setAttribute("employees", employeeDTOs);
				action = "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}
}
