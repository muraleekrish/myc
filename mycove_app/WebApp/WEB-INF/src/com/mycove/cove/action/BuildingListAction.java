package com.mycove.cove.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.cove.form.ModifyBuildingForm;
import com.mycove.dao.BuildingDAO;
import com.mycove.dto.BuildingDTO;
import com.mycove.util.util.FormUtil;

public class BuildingListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {
			if (form instanceof ModifyBuildingForm) {
				if(FormUtil.isNotNull(request.getParameter("propertyId")))
				{
					BuildingDAO buildingDAO= new BuildingDAO();
					Collection<BuildingDTO> buildings= buildingDAO.getBuildingByPropertyId(Long.parseLong(request.getParameter("propertyId")));
					request.setAttribute("buildings", buildings);
					request.setAttribute("propertyId", request.getParameter("propertyId"));
					action = "input";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}
}
