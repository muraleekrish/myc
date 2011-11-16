package com.mycove.cove.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.cove.form.ModifyPropertyForm;
import com.mycove.dao.PropertyDAO;
import com.mycove.dto.PropertyDTO;
import com.mycove.util.util.FormUtil;

public class PropertyListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {
			if (form instanceof ModifyPropertyForm) {
				PropertyDAO propertyDAO = new PropertyDAO();
				String roleName = FormUtil.setNullToBlank((String)request.getSession().getAttribute("roleName"));
				Long userId = (Long)request.getSession().getAttribute("userId");
				Collection<PropertyDTO> properties = null ;
				if(roleName.equalsIgnoreCase("admin"))
					properties = propertyDAO.getAllProperties();
				else
				{
					if(userId != 0L)
					properties = propertyDAO.getPropertiesByUserId(userId);
				}
				if(properties == null)
					properties = new ArrayList<PropertyDTO>();
				
				request.setAttribute("properties", properties);
				action = "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}
}
