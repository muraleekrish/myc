package com.mycove.cove.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.cove.form.MaintenanceListForm;
import com.mycove.dao.MaintenanceRequestDAO;
import com.mycove.dto.MaintenanceRequestDTO;

public class MaintenanceListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {

			if (form instanceof MaintenanceListForm) {
				MaintenanceRequestDAO maintenancerequestDAO = new MaintenanceRequestDAO();
				Collection<MaintenanceRequestDTO> maintenanceDTOs = maintenancerequestDAO.getMaintenanceByPropertyManagerId((Long)request.getSession().getAttribute("userId"));
				request.setAttribute("maintenance", maintenanceDTOs);
				action = "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}
}
