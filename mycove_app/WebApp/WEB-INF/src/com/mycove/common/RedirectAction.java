package com.mycove.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

public class RedirectAction extends Action {

public ActionForward execute(ActionMapping actionMapping, ActionForm actionForm, HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		if (request.getRequestURI().indexOf("Home.do") != -1)
		{
			// log.debug("Redirecting to home...");
			return actionMapping.findForward("/FwdHome");
		}
		else if (request.getRequestURI().indexOf("Error.do") != -1)
		{
			return actionMapping.findForward("gerror");
		}
		else
			return actionMapping.findForward(request.getParameter("fkey"));

	}
}
