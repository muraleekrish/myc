package com.mycove.cove.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.cove.form.PackageListForm;
import com.mycove.dao.PackageDAO;
import com.mycove.dto.PackageDTO;

public class PackageListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {

			if (form instanceof PackageListForm) {
				PackageDAO packageDAO = new PackageDAO();
				HttpSession session = request.getSession();
				session.setAttribute("formAction", null);
				session.removeAttribute("formAction");
				Collection<PackageDTO> packageDTOs = packageDAO.getPackagesByPropertyManagerId((Long)request.getSession().getAttribute("userId"), false);
				request.setAttribute("packages", packageDTOs);
				action = "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}
}
