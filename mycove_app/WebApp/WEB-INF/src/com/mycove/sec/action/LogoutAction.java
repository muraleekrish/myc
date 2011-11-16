/**
 * 
 */
package com.mycove.sec.action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.omg.CORBA.Request;

/**
 * @author Karthikeyan
 * 
 */
public class LogoutAction extends Action {

	private Logger log = Logger.getLogger(LoginAction.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @seeorg.apache.struts.action.Action#execute(org.apache.struts.action.
	 * ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		super.execute(mapping, form, request, response);
		ActionForward fw = null;
		log.debug("Redirecting in LogoffAction...");
		System.out.println("logoutsess1");
		HttpSession session = request.getSession();
		if (request.getSession().getAttribute("userId") != null)
		{  
			System.out.println("logoutsess");
			session.removeAttribute("userId");
			session.removeAttribute("firstName");
			session.setAttribute("userId", null);
			session.setAttribute("firstName", null);
			session.setAttribute("lee","lee");
			session.removeAttribute("formAction");
			session.removeAttribute("userId");
			session.removeAttribute("msgid");
			session.removeAttribute("firstName");
			session.removeAttribute("userName");
			session.removeAttribute("roleName");
			session.removeAttribute("userObject");
			session.setAttribute("userName", null);
			session.setAttribute("msgid",null);
			session.setMaxInactiveInterval(1);   
			session.invalidate();
			System.out.println("usercheck"+request.getSession().getAttribute("userId"));
			fw = mapping.findForward("success");
		}
		else
		{			
			throw new ServletException("Please log in before trying to log out.");			
		}
		return fw;
	}
}
