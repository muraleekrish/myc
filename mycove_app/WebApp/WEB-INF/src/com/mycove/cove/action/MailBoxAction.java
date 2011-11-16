package com.mycove.cove.action;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.dao.MessagesDAO;
import com.mycove.dto.Message;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Messages;

public class MailBoxAction extends Action {
	
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HttpSession session = request.getSession();
		Long userId = 0L;
		if (FormUtil.isNotNull(session.getAttribute("userId"))) {
			userId = (Long)session.getAttribute("userId");
		}
		String folderName = ""; 
		if(FormUtil.isNotNull(request.getParameter("folderName")) 
				&& request.getParameter("folderName").equalsIgnoreCase("SEND ITEMS"))
			folderName= "SENT ITEMS";
		else
			folderName = "INBOX";
		
		MessagesDAO messagesDAO = new MessagesDAO();
		Collection<Messages> messages = messagesDAO.getMessages(userId, folderName);
		Collection<Message> messageDTOs = new ArrayList<Message>();
		for (Messages message : messages) {
			messageDTOs.add(new Message(message)); 
		}
		request.setAttribute("messages", messageDTOs);

		return mapping.findForward("input");
	}
}