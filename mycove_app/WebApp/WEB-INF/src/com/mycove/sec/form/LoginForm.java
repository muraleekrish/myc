package com.mycove.sec.form;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionError;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;

import com.mycove.dao.TenantDAO;
import com.mycove.dao.UserDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Tenant;
import com.mycove.vo.User;

@SuppressWarnings("serial")
public class LoginForm extends ActionForm {

	private String userName;
	private String password;
	private String screenWidth;
	private String screenHeigth;
	
	/**
	 * @return the screenWidth
	 */
	public String getScreenWidth() {
		return screenWidth;
	}
	/**
	 * @param screenWidth the screenWidth to set
	 */
	public void setScreenWidth(String screenWidth) {
		this.screenWidth = screenWidth;
	}
	/**
	 * @return the screenHeigth
	 */
	public String getScreenHeigth() {
		return screenHeigth;
	}
	/**
	 * @param screenHeigth the screenHeigth to set
	 */
	public void setScreenHeigth(String screenHeigth) {
		this.screenHeigth = screenHeigth;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {

		super.validate(mapping, request);
		ActionErrors errors = new ActionErrors();
		
		if (FormUtil.isNullOrBlank(this.getUserName()))
			errors.add("userName", new ActionError("select.userid"));
		if (FormUtil.isNullOrBlank(this.getPassword()))
			errors.add("password", new ActionError("select.password"));	
		
		if (FormUtil.isNullOrBlank(this.getUserName()))
			errors.add("userName", new ActionError("select.userid"));	
		
			User user= new UserDAO().checkAuthentication(userName,password);
			
			if(user == null)
				errors.add("userName",new ActionError("userid.Invalid"));
		
		
		
		return errors;
	}
}
