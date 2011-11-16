package com.mycove.sec.action;

import javax.naming.AuthenticationException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.dao.TenantDAO;
import com.mycove.dao.UserDAO;
import com.mycove.sec.form.LoginForm;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Role;
import com.mycove.vo.Tenant;
import com.mycove.vo.User;

public class LoginAction extends Action {

	private Logger log = Logger.getLogger(LoginAction.class);

	public ActionForward execute(ActionMapping actionMapping,
			ActionForm actionForm, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		super.execute(actionMapping, actionForm, request, response);
		ActionForward fw = null;
		LoginForm form = (LoginForm) actionForm;
		 

		log.debug("Redirecting in LoginAction...");

		String rd = request.getParameter("redirect");

		if (FormUtil.isNull(form.getUserName())
				|| FormUtil.isNull(form.getPassword())) {
			log.debug("This form is not a submit but an access...");
			fw = actionMapping.findForward("input");
			if (FormUtil.isNotNull(rd)) {
				request.getSession().setAttribute("originalRequestURI", rd);
			}
			return fw;
		}

		Object ouri = request.getSession().getAttribute("originalRequestURI");
		if (ouri != null) {
			ouri = ouri.toString().substring(ouri.toString().indexOf('/', 1));
			fw = new ActionForward(ouri.toString());
			fw.setRedirect(true);
			fw.setContextRelative(true);
			log.debug("Redirecting to " + ouri.toString());
		}

		if (request.getParameter("submit") != null)
			log.debug("form submitted...");

		try {
			if (actionForm instanceof LoginForm) {

				LoginForm frm = (LoginForm) actionForm;
				HttpSession session = request.getSession();
				 
				if(!FormUtil.isNullOrBlank(frm.getScreenWidth()))
				{
					session.setAttribute("screenWidth", Integer.parseInt(frm.getScreenWidth()));
					session.setAttribute("screenHeight", frm.getScreenHeigth());
				}
				ActionErrors actionErrors = form.validate(actionMapping, request);
				if(actionErrors.isEmpty())
				{
				if (!FormUtil.isNullOrBlank(frm.getUserName())
						&& !FormUtil.isNullOrBlank(frm.getPassword())) {
					 
					UserDAO dao = new UserDAO();
					User user = dao.checkAuthentication(frm.getUserName().trim(), frm.getPassword());
					
					if (FormUtil.isNotNull(user)) {
						Role role = user.getRole();
						session.setAttribute("firstName", user.getFirstName()+" "+user.getLastName());
						session.setAttribute("userId", user.getId());
						session.setAttribute("userName", user.getUserId());
						session.setAttribute("roleName", role.getName().toLowerCase());
						session.setAttribute("userObject", user);
						
						if (role.getName().equalsIgnoreCase("resident")) {
							TenantDAO tenantDAO = new TenantDAO();
							Tenant tenant = tenantDAO.findById(user.getId());
							
							session.setAttribute("aptID", tenant.getApartment().getId());
							session.setAttribute("buildID", tenant.getApartment().getBuilding().getId());
							
							UserDAO passdao = new UserDAO();
							User passuser = passdao.findById(user.getId());
							System.out.println(passuser.getTemppwdChanged());
							if(passuser.getTemppwdChanged()!=null && !passuser.getTemppwdChanged())
							{
								return actionMapping.findForward("resetPassword");
							}
						}
						
						else if (role.getName().equalsIgnoreCase("employee")) {

						} 
						else  if (role.getName().equalsIgnoreCase("Property Manager")) {

						}
						else  if (role.getName().equalsIgnoreCase("Support")) {
							
						}
						else  if (role.getName().equalsIgnoreCase("Admin")) {
							
						}
						else
						{   saveErrors(request, actionErrors);						 
							throw new AuthenticationException("You are not authorised to use this application");
							
						}
						
						
						return actionMapping.findForward("success");
					} 
					else 
					{
						throw new AuthenticationException("Invalid User");
						 
						
						
					}
				}
				}else{
					saveErrors(request, actionErrors);
					return actionMapping.findForward("input");
				}

			}
		} catch (AuthenticationException ae) {
			fw = new ActionForward();
			fw.setPath("/Login.do");
			fw.setRedirect(true);
			log.debug("Authentication Failed. User Name: " + form.getUserName());
			return fw;
		} catch (Exception e) {
			fw = new ActionForward();
			/*if (e.getMessage().indexOf("getSingleResult() did not retrieve any entities") == -1)
				fw.setPath("/Login.do?sError=Unexpected Error");
			else*/
			e.printStackTrace();
				fw.setPath("/Login.do?sError=Authentication Failed");

			fw.setRedirect(true);
			log.debug("Authentication Failed. User Name: " + form.getUserName());
			return fw;
		}

		request.getSession().setAttribute("UserName", form.getUserName());

		if (fw == null) {
			fw = actionMapping.findForward("success");
		} else {
			request.getSession().removeAttribute("originalRequestURI");
		}
		if (fw == null)
			fw = actionMapping.findForward("input");
		return fw;
	}
}
