package com.mycove.cove.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.LookupDispatchAction;

import com.mycove.cove.form.AddTemplateForm;
import com.mycove.dao.MessageTemplateDAO;
import com.mycove.dao.PropertyDAO;
import com.mycove.dto.PropertyDTO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.MessageTemplate;



public class TemplateAction extends LookupDispatchAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		if (form instanceof AddTemplateForm) {
			try {
				HttpSession session = request.getSession();
				String formAction = FormUtil.setNullToBlank(request.getParameter("formAction"));
				if(FormUtil.isNotNull(session.getAttribute("formAction")))
					formAction = FormUtil.setNullToBlank((String)session.getAttribute("formAction"));
				      session.setAttribute("formAction", formAction);
				PropertyDAO propertyDAO = new PropertyDAO();
				Collection<PropertyDTO> properties = propertyDAO.getPropertiesByUserId((Long)request.getSession().getAttribute("userId"));
				request.setAttribute("properties", properties);
				System.out.println(request.getParameter(mapping.getParameter()));
				if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Save")) {
					return this.add(mapping, form, request, response);
				} else if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Delete")) {
					return this.delete(mapping, form, request, response);
				} else if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Update")) {
					return this.update(mapping, form, request, response);
				} else {
					return this.view(mapping, form, request, response);
				}
			}catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
		return mapping.findForward("input");
	}
	
		
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		ActionMessages messages = new ActionMessages();
		AddTemplateForm templatefrm = (AddTemplateForm) form;
		ActionErrors actionErrors = templatefrm.validate(mapping, request);
		if(actionErrors.isEmpty())
		{
            MessageTemplateDAO tempDAO = new MessageTemplateDAO();
			MessageTemplate temp = new MessageTemplate();
			temp.setTemplateName(templatefrm.getTemplateName());
			temp.setSubject(templatefrm.getSubject());
			temp.setMessageText(templatefrm.getMessageText());
			temp.setCreatedBy((String) request.getSession().getAttribute("userName"));
			PropertyDAO propertyDAO = new PropertyDAO();
		    temp.setProperty(propertyDAO.findById(Long.parseLong(templatefrm.getPropertyId())));
			tempDAO.save(temp);
			messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("template.add"));
			saveMessages(request, messages); 
			request.setAttribute("message", "message");
			return mapping.findForward("success");
		}
		else
		{
			saveErrors(request, actionErrors);
			return mapping.findForward("input");
		}
		
	}
	
	
	public ActionForward view(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String action = "input";
		
		AddTemplateForm templatefrm = (AddTemplateForm) form;
		Long templateId = 0L;
		if (FormUtil.isNotNull(request.getParameter("templateId"))) {
			templateId = Long.parseLong(request.getParameter("templateId"));

			MessageTemplateDAO templateDAO = new MessageTemplateDAO();
			MessageTemplate template = templateDAO.findById(templateId);
			templatefrm.setTemplateName(FormUtil.setNullToBlank(template.getTemplateName()));
			templatefrm.setPropertyId(String.valueOf(template.getProperty().getId()));
			templatefrm.setId(String.valueOf(templateId));
			templatefrm.setSubject(FormUtil.setNullToBlank(template.getSubject()));
			templatefrm.setMessageText(FormUtil.setNullToBlank(template.getMessageText()));
			action = "input";
		} else {
			action = "input";
		}

		return mapping.findForward(action);
	}
	
	public ActionForward update(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (form instanceof AddTemplateForm) {
			ActionMessages messages = new ActionMessages();
			AddTemplateForm templatefrm = (AddTemplateForm) form;
			ActionErrors actionErrors = templatefrm.validate(mapping, request);
			if(actionErrors.isEmpty())
			{					
				try {
					MessageTemplateDAO tempDAO = new MessageTemplateDAO();
					MessageTemplate temp = tempDAO.findById(Long.parseLong(templatefrm.getId()));
					temp.setTemplateName(templatefrm.getTemplateName());
					PropertyDAO propertyDAO = new PropertyDAO();
				    temp.setProperty(propertyDAO.findById(Long.parseLong(templatefrm.getPropertyId())));
					temp.setSubject(templatefrm.getSubject());
					temp.setMessageText(templatefrm.getMessageText());
					temp.setModifiedBy((String) request.getSession().getAttribute("userName"));
					temp.setModifiedDate(new Timestamp(new Date().getTime()));
					tempDAO.update(temp);
					
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("template.update"));
					saveMessages(request, messages); 
					request.setAttribute("message", "message");
					return mapping.findForward("success");

				} catch (Exception e) {
					log.error(e.getMessage(), e);
				}
			}
			else
			{
				saveErrors(request, actionErrors);
				return mapping.findForward("input");
			}
		}
		return mapping.findForward("input");
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String action = "input";
		
		if (form instanceof AddTemplateForm) {
			try {
				AddTemplateForm templatefrm = (AddTemplateForm) form;
				MessageTemplateDAO templateDAO = new MessageTemplateDAO();
				ActionMessages messages = new ActionMessages();
				templateDAO.delete(templateDAO.findById(Long.parseLong(templatefrm.getId())));
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("template.delete"));
				saveMessages(request, messages); 
				request.setAttribute("message", "message");
				return mapping.findForward("success");
			} catch (Exception e) {
				
				ActionErrors actionErrors = new ActionErrors();
				actionErrors.add("delete", new ActionError("error.delete"));
				saveErrors(request, actionErrors);
				action = "input";
				log.error(e.getMessage(), e);
		}
		}
		return mapping.findForward(action);
	}
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.submit", "submit");
		map.put("button.update","Update");
		map.put("button.delete", "delete");
		return map;
	}
	
 }
