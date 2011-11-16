package com.mycove.cove.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.cove.form.TemplateListForm;
import com.mycove.dao.MessageTemplateDAO;
import com.mycove.dto.MessageTemplateDTO;

public class TemplateListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {

			if (form instanceof TemplateListForm) {
				MessageTemplateDAO templateDAO = new MessageTemplateDAO();
				HttpSession session = request.getSession();
				session.setAttribute("formAction", null);
				session.removeAttribute("formAction");
				Collection<MessageTemplateDTO> templateDTOs = templateDAO.getAllTemplateByPropertyManagerId((Long)request.getSession().getAttribute("userId"));
				request.setAttribute("template", templateDTOs);
				action = "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}
}
