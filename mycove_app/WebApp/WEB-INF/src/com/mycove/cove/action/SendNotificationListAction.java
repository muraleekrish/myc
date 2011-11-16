package com.mycove.cove.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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
import com.mycove.cove.form.MaintenanceRequestForm;
import com.mycove.cove.form.SendNotificationListForm;
import com.mycove.cove.trans.SendNotification;
import com.mycove.dao.BuildingDAO;
import com.mycove.dao.MessageTemplateDAO;
import com.mycove.dao.PropertyDAO;
import com.mycove.dao.TenantDAO;
import com.mycove.dao.UserDAO;
import com.mycove.dto.BuildingDTO;
import com.mycove.dto.MessageTemplateDTO;
import com.mycove.dto.PropertyDTO;
import com.mycove.dto.ResidentDTO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.MessageTemplate;
import com.mycove.vo.User;

public class SendNotificationListAction extends LookupDispatchAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		SendNotificationListForm sendfrm = (SendNotificationListForm) form;
		String action = "input";
		if (form instanceof SendNotificationListForm) {
			try {
				PropertyDAO propertyDAO = new PropertyDAO();
				Collection<PropertyDTO> properties = propertyDAO.getPropertiesByUserId((Long)request.getSession().getAttribute("userId"));
				request.setAttribute("properties", properties);
				
				TenantDAO tenantDAO = new TenantDAO();
				Collection<ResidentDTO> residentDTOs = tenantDAO.getAllTenantsByPropertyManager((Long)request.getSession().getAttribute("userId"));
				request.setAttribute("residents", residentDTOs);
				
							
				/*BuildingDAO buildingDAO= new BuildingDAO();
				Collection<BuildingDTO> buildings= buildingDAO.getBuildingByPropertyId(Long.parseLong(sendfrm.getPropertyId()));
				request.setAttribute("buildings", buildings);*/
								
				
				
				MessageTemplateDAO templateDAO = new MessageTemplateDAO();
				Collection<MessageTemplateDTO> templateDTOs = templateDAO.getAllTemplateByPropertyManagerId((Long)request.getSession().getAttribute("userId"));
				request.setAttribute("templates", templateDTOs);
				
				 if (FormUtil.isNotNull(request.getParameter(mapping.getParameter())) 
							&& request.getParameter(mapping.getParameter()).equals("Custom")) {
						//return this.s(mapping, form, request, response);
						
					}
				
				if (FormUtil.isNotNull(request.getParameter(mapping.getParameter())) 
						&& request.getParameter(mapping.getParameter()).equals("Send")) {
					return this.send(mapping, form, request, response);
					
				}
			
				else {
					action = "input";
				}
			}
				catch (Exception e) {
					e.printStackTrace();
				}
			} 
			return mapping.findForward(action);
		}

	public ActionForward send(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		SendNotificationListForm sendfrm = (SendNotificationListForm) form;
		if (sendfrm.getTemplateId().equals("custom"))
		{
			String action = "custom";
			ActionErrors actionErrors = sendfrm.validate(mapping, request);
			if(actionErrors.isEmpty())
			{
					try {
					
					ActionMessages messages = new ActionMessages();
					HttpSession session = request.getSession();
					
					session.setAttribute("sendMsg", sendfrm.getSendMessage());
					session.setAttribute("resId", sendfrm.getResidentId());
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("notification.update"));
					
					
					return mapping.findForward("custom");
				} catch (Exception e) {
					action = "custom";
					e.printStackTrace();
				}
			}else
			{
				saveErrors(request, actionErrors);
				return mapping.findForward("input");
			}
						
		}
		else
		if (form instanceof SendNotificationListForm) {
			ActionMessages messages = new ActionMessages();
			
			ActionErrors actionErrors = sendfrm.validate(mapping, request);
			if(actionErrors.isEmpty())
			{
			try {
				TenantDAO tenantDAO = new TenantDAO();
				Long TemplateId = (Long.parseLong((sendfrm.getTemplateId())));
				List<Long> residentId = new ArrayList<Long>();
				if(sendfrm.getSendMessage().equalsIgnoreCase("1"))
				{
					Collection<ResidentDTO> residentDTOs = tenantDAO.getAllTenantsIDByPropertyManager((Long) request.getSession().getAttribute("userId"));
					for (ResidentDTO residentDTO : residentDTOs) {
						residentId.add(residentDTO.getId());
					}
				}
				else
				{
					for (String strResidentId: sendfrm.getResidentId()) {
						residentId.add(Long.parseLong(strResidentId));
					}
				}
				
				SendNotification sendnotification = new SendNotification((Long) request.getSession().getAttribute("userId"), TemplateId, residentId);

				sendnotification.execute();
				
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("notification.update"));
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
	
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.notification", "Send");
	    return map;
	}
}
