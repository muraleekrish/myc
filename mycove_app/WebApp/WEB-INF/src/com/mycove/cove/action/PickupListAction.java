package com.mycove.cove.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.cove.form.PackageListForm;
import com.mycove.dao.PackageDAO;
import com.mycove.dto.PackageDTO;

public class PickupListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {

			if (form instanceof PackageListForm) {
				PackageDAO packageDAO = new PackageDAO();
				Collection<PackageDTO> packageDTOs = packageDAO.getPackagesByPropertyManagerId((Long)request.getSession().getAttribute("userId"), true);
				request.setAttribute("packages", packageDTOs);
				action = "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}
}
