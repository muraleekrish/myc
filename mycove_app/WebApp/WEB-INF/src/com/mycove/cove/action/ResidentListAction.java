package com.mycove.cove.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.cove.form.ResidentListForm;

import com.mycove.dao.TenantDAO;
import com.mycove.dto.ResidentDTO;

public class ResidentListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {

			if (form instanceof ResidentListForm) {
				TenantDAO tenantDAO = new TenantDAO();
				HttpSession session = request.getSession();
				session.setAttribute("formAction", null);
				session.removeAttribute("formAction");
				session.setAttribute("residentId", null);
				session.removeAttribute("residentId");
				Collection<ResidentDTO> residentDTOs = tenantDAO.getAllTenantsByPropertyManager((Long)request.getSession().getAttribute("userId"));
				request.setAttribute("residents", residentDTOs);
				action = "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(action);
	}
}
