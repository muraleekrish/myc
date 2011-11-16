package com.mycove.cove.action;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.LookupDispatchAction;

import com.mycove.cove.form.MailViewForm;
import com.mycove.cove.form.SendNotificationListForm;
import com.mycove.cove.trans.MailForward;
import com.mycove.cove.trans.MailReply;
import com.mycove.cove.trans.MailReplyAll;
import com.mycove.cove.trans.SendNotification;
import com.mycove.dao.MessagesDAO;
import com.mycove.dao.MessagesToDAO;
import com.mycove.dao.TenantDAO;
import com.mycove.dao.UserDAO;
import com.mycove.dto.ResidentDTO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Messages;
import com.mycove.vo.MessagesTo;
import com.mycove.vo.User;

public class MailViewAction extends LookupDispatchAction {
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String action = "input";
		 
		TenantDAO tenantDAO = new TenantDAO();
		Collection<ResidentDTO> residentDTOs = tenantDAO.getAllTenantsByPropertyManager((Long)request.getSession().getAttribute("userId"));
		request.setAttribute("residents", residentDTOs);
		System.out.println(request.getParameter(mapping.getParameter()));
		if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
				&& request.getParameter(mapping.getParameter()).equals("Delete")) {

			return this.delete(mapping, form, request, response);
			} 
		else if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
				&& request.getParameter(mapping.getParameter()).equals("Send")) {
			return this.forward(mapping, form, request, response);
		} else if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
				&& request.getParameter(mapping.getParameter()).equals("Send Reply"))  {
			return this.reply(mapping, form, request, response);
		}else if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
				&& request.getParameter(mapping.getParameter()).equals("Send ReplyAll")) {
			return this.replytoall(mapping, form, request, response);
		}  else {
			if (form instanceof MailViewForm) {
				
				MailViewForm mailViewForm = (MailViewForm) form;
				String msgid = request.getParameter("msgid");
				MessagesDAO messagesDAO = new MessagesDAO();
				Messages messages = messagesDAO.findById(Long.parseLong(msgid));
				 
				StringBuilder msgTobuff = new StringBuilder();
				for (MessagesTo messageTo : messages.getMessagesTos()) {
			          
			          UserDAO userDAO = new UserDAO();
					User mailFromUser = userDAO.findById((Long) request.getSession().getAttribute("userId"));
					if(msgTobuff.length() > 0)
						msgTobuff.append(", ");
					if(messageTo.getUser().getId()!=mailFromUser.getId())
					{
					msgTobuff.append(messageTo.getUser().getFirstName()).append(" ").append(messageTo.getUser().getLastName());
					System.out.println("TO:"+msgTobuff.toString());
				      
					}
					 
				}
				
				msgTobuff.append(", ");
				msgTobuff.append(messages.getFromUser().getFirstName());
				
				mailViewForm.setReplyToAll(msgTobuff.toString());
				mailViewForm = this.mapVOToForm(messages, mailViewForm);
			}
		}

		return mapping.findForward(action);
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String action = "input";
				
		if (form instanceof MailViewForm) {
			try {
				MailViewForm mailViewForm = (MailViewForm) form;
				MessagesDAO messagesDAO = new MessagesDAO();
				messagesDAO.delete(messagesDAO.findById(Long.parseLong(mailViewForm.getId())));
				ActionMessages actionMessages = new ActionMessages();
				actionMessages.add("message", new ActionMessage("delete.mail"));
				saveMessages(request, actionMessages);
				action = "success";
				
			} catch (Exception e) {
				 
				ActionErrors actionErrors = new ActionErrors();
				actionErrors.add("deleteMail", new ActionError("error.delete.mail"));
				saveErrors(request, actionErrors);
				action = "input";
				log.error(e.getMessage(), e);
			}
		}
		return mapping.findForward(action);
	}
	
	public ActionForward forward(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		MailViewForm mailViewForm = (MailViewForm) form;
		mailViewForm.setFormAction("change");
		String action = "input";
		if (form instanceof MailViewForm) {
			ActionMessages messages = new ActionMessages();
			
			ActionErrors actionErrors = mailViewForm.validate(mapping, request);
			if(actionErrors.isEmpty())
			{
						
				TenantDAO tenantDAO = new TenantDAO();
				
				List<Long> residentId = new ArrayList<Long>();
						
					for (String strResidentId: mailViewForm.getResidentId()) {
						residentId.add(Long.parseLong(strResidentId));
					}
			
				
				MailForward mailforward = new MailForward();

				mailforward.execute(mailViewForm,(Long) request.getSession().getAttribute("userId"),residentId);
				 
				messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("reply.mail"));
				saveMessages(request, messages);
				request.setAttribute("message", "message");
				return mapping.findForward("success");
					
			}
			else
			{actionErrors.add("replyMail", new ActionError("error.reply.mail"));
			saveErrors(request, actionErrors);
			}
			
		}
		return mapping.findForward("input");
	}
	 
	public ActionForward reply(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		String action = "input";
		if (form instanceof MailViewForm) {
			MailViewForm mailViewForm = (MailViewForm) form;
			ActionErrors actionErrors = new ActionErrors();
			//ActionErrors actionErrors = mailViewForm.validate(mapping, request);
			if(actionErrors.isEmpty())
			{
				MailReply mailReply = new MailReply();
				mailReply.execute(mailViewForm, (Long) request.getSession().getAttribute("userId"));
				ActionMessages actionMessages = new ActionMessages();
				actionMessages.add("message", new ActionMessage("reply.mail"));
				saveMessages(request, actionMessages);
				action = "success";
			}
			else
			{
				
				saveErrors(request, actionErrors);
			}
		}
		return mapping.findForward(action);
	}
	
	public ActionForward replytoall(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
	throws Exception {
		String action = "input";
		if (form instanceof MailViewForm) {
			MailViewForm mailViewForm = (MailViewForm) form;
		
			
		/*	ActionErrors actionErrors = mailViewForm.validate(mapping, request);
			if(actionErrors.isEmpty())
			{   */
				/*String msgid = request.getParameter("msgid");
				System.out.println("msgid:"+msgid);*/
				MessagesDAO messagesDAO = new MessagesDAO();
				Messages messages = messagesDAO.findById(Long.parseLong(mailViewForm.getId()));
				List<Long> replyallId = new ArrayList<Long>();
				
				for (MessagesTo replyall : messages.getMessagesTos()) {
					System.out.println("rererer:"+replyall.getUser().getId());
					 replyallId.add((replyall.getUser().getId()));
				}
				MailReplyAll mailreplyall = new MailReplyAll();
				mailreplyall.execute(mailViewForm,(Long) request.getSession().getAttribute("userId"),replyallId);
				ActionMessages actionMessages = new ActionMessages();
				actionMessages.add("message", new ActionMessage("reply.mail"));
				saveMessages(request, actionMessages);
				action = "success";
			/*}
			else
			{
				
				saveErrors(request, actionErrors);
			}*/
		}
		return mapping.findForward(action);
	}
	/**
	 * @param messages
	 * @param mailViewForm
	 * @return
	 */
	private MailViewForm mapVOToForm(Messages messages, MailViewForm mailViewForm) {
		DateFormat sdf = new SimpleDateFormat("MM/dd/yy hh:mm:ss a");
       
		if(FormUtil.isNotNull(messages.getCreatedDate()))
			mailViewForm.setDate(sdf.format(new Date(messages.getCreatedDate().getTime())));
		else
			mailViewForm.setDate("");
		mailViewForm.setFrom(messages.getFromUser().getFirstName());
		mailViewForm.setReplyMessage("\n\n"+"\n\n"+messages.getMessageText()); 
		mailViewForm.setMessage(messages.getMessageText());
		mailViewForm.setId(String.valueOf(messages.getId()));
		mailViewForm.setSubject(messages.getSubject());
		//StringBuffer messageToBuff = new StringBuffer();
		StringBuilder messageToBuff = new StringBuilder();
		
		for (MessagesTo messageTo : messages.getMessagesTos()) {
			if(messageToBuff.length() > 0)
				messageToBuff.append(", ");
			messageToBuff.append(messageTo.getUser().getFirstName()).append(" ").append(messageTo.getUser().getLastName());
			System.out.println("to::"+messageToBuff.toString());
			
		}
		mailViewForm.setTo(messageToBuff.toString());
		/*for (MessagesTo messageTo : messages.getMessagesTos()) {
			StringBuffer msgTobuff = new StringBuffer();
			if(msgTobuff.length() > 0)
				messageToBuff.append(", ");
			UserDAO userDAO = new UserDAO();
			User mailFromUser = userDAO.findById((Long) request.getSession().getAttribute("userId"));
			if(messageTo.getUser().getId()!=)
			{
			msgTobuff.append(messageTo.getUser().getFirstName()).append(" ").append(messageTo.getUser().getLastName());
			}
			messageToBuff.append(messages.getFromUser().getFirstName());
		}
		mailViewForm.setReplyToAll(messageToBuff.toString());*/
		return mailViewForm;
	}



	/* (non-Javadoc)
	 * @see org.apache.struts.actions.LookupDispatchAction#getKeyMethodMap()
	 */
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.delete", "delete");
		map.put("button.send", "reply");
		map.put("button.forward","forward");
		map.put("button.replyall","replytoall");
		 
		return map;
	}

}