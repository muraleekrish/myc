package com.mycove.cove.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.cove.form.TemplateListForm;
import com.mycove.dao.MessageTemplateDAO;
import com.mycove.vo.MessageTemplate;

public class NotificationListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {

			if (form instanceof TemplateListForm) {
				MessageTemplateDAO templateDAO = new MessageTemplateDAO();
				Collection<MessageTemplate> templateDTOs = templateDAO.findAll();
				request.setAttribute("template", templateDTOs);
				action = "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}
}
