package com.mycove.cove.action;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.LookupDispatchAction;

import com.mycove.cove.form.AddTemplateForm;
import com.mycove.cove.form.EmployeeProfileForm;
import com.mycove.dao.BaseDAO;
import com.mycove.dao.EmployeeDAO;
import com.mycove.dao.PropertyDAO;
import com.mycove.dao.RoleDAO;
import com.mycove.dto.PropertyDTO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Employee;
import com.mycove.vo.Role;

public class EmployeeProfileAction extends LookupDispatchAction  {
	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		
		
		String action = "failure";
		
		if (form instanceof EmployeeProfileForm) {
			try {
				EmployeeProfileForm employeeFrm = (EmployeeProfileForm) form;
				HttpSession session = request.getSession();
				String formAction = FormUtil.setNullToBlank(request.getParameter("formAction"));
				if(FormUtil.isNotNull(session.getAttribute("formAction")))
					formAction = FormUtil.setNullToBlank((String)session.getAttribute("formAction"));
				      session.setAttribute("formAction", formAction);
				      String user = (String) request.getSession().getAttribute("userName");	    
				      
				                 	if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
										&& request.getParameter(mapping.getParameter()).equals("Save")) {
				                 		ActionMessages messages = new ActionMessages();
				                 		ActionErrors actionErrors = employeeFrm.validate(mapping, request);
				                		if(actionErrors.isEmpty())
				                		{
									BaseDAO<Employee> base = new BaseDAO<Employee>();
									Employee employee = this.mapFormToVO(employeeFrm, new Employee(), user);
									employee.setCreatedDate(new Timestamp(new Date().getTime()));
									employee.setCreatedBy(user);
									Role role = new RoleDAO().findById(2L);
									employee.setRole(role);
									base.save(employee);
									action = "success";
									messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("employee.add"));
									saveMessages(request, messages); 
									request.setAttribute("message", "message");
				                		}else
				                		{
				                			saveErrors(request, actionErrors);
				            			return mapping.findForward("input");
				                		}

						} else if (FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
								&& request.getParameter(mapping.getParameter()).equals("Update")) {
							ActionMessages messages = new ActionMessages();
							ActionErrors actionErrors = employeeFrm.validate(mapping, request);
							if(actionErrors.isEmpty())
	                		{
							BaseDAO<Employee> base = new BaseDAO<Employee>();
							EmployeeDAO employeeDAO = new EmployeeDAO();
							Employee employee = this.mapFormToVO(employeeFrm, employeeDAO.findById(employeeFrm.getId()), user);
							employee.setId(employeeFrm.getId());
							base.update(employee);
							action = "success";
							messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("employee.update"));
							saveMessages(request, messages); 
							request.setAttribute("message", "message");
	                		}else
	                		{
	                			saveErrors(request, actionErrors);
	            			return mapping.findForward("input");
	                		}
						}else
						{
							if(FormUtil.isNotNull(request.getParameter("employeeId")))
								employeeFrm.setId(Long.parseLong(request.getParameter("employeeId"))); 
							EmployeeDAO employeeDAO = new EmployeeDAO();
						Employee employee = employeeDAO.findById(employeeFrm.getId());
						employeeFrm = this.mapVOToForm(employee, employeeFrm);

						}
					
				} catch (Exception me) {
					me.printStackTrace();
				}
		}
				return mapping.findForward(action);
			}
		

	/*	String action = "failure";
		try {
			if (form instanceof EmployeeProfileForm) {
				 
				EmployeeProfileForm employeeFrm = (EmployeeProfileForm) form;
			if(FormUtil.isNotNull(request.getParameter("formAction")) 
						&& FormUtil.setNullToBlank(employeeFrm.getFormAction()).equalsIgnoreCase("edit"))
				{
					employeeFrm.setFormAction("view");
					if(FormUtil.isNotNull(request.getParameter("employeeId")))
						employeeFrm.setId(Long.parseLong(request.getParameter("employeeId"))); 
				}
				String user = (String) request.getSession().getAttribute("userName");
				HttpSession session = request.getSession();
				String formAction = FormUtil.setNullToBlank(request.getParameter("formAction"));
				if(FormUtil.isNotNull(session.getAttribute("formAction")))
					formAction = FormUtil.setNullToBlank((String)session.getAttribute("formAction"));
				      session.setAttribute("formAction", formAction);
				if (FormUtil.isNullOrBlank(employeeFrm.getFormAction())) {

				} else if (employeeFrm.getFormAction().equalsIgnoreCase("view")) {

					EmployeeDAO employeeDAO = new EmployeeDAO();
					Employee employee = employeeDAO.findById(employeeFrm.getId());
					employeeFrm = this.mapVOToForm(employee, employeeFrm);

				} else if (employeeFrm.getFormAction().equalsIgnoreCase("Update")) {
					BaseDAO<Employee> base = new BaseDAO<Employee>();
					EmployeeDAO employeeDAO = new EmployeeDAO();
					Employee employee = this.mapFormToVO(employeeFrm, employeeDAO.findById(employeeFrm.getId()), user);
					employee.setId(employeeFrm.getId());
					base.update(employee);
					action = "success";

				} else if (employeeFrm.getFormAction().equalsIgnoreCase("add")) {
					BaseDAO<Employee> base = new BaseDAO<Employee>();
					Employee employee = this.mapFormToVO(employeeFrm, new Employee(), user);
					employee.setCreatedDate(new Timestamp(new Date().getTime()));
					employee.setCreatedBy(user);
					Role role = new RoleDAO().findById(2L);
					employee.setRole(role);
					base.save(employee);
					action = "success";

				}
			}
		} catch (Exception me) {
			me.printStackTrace();
		}
		return mapping.findForward(action);
	}*/

	/**
	 * 
	 */
	private EmployeeProfileForm mapVOToForm(Employee employee,EmployeeProfileForm employeeFrm) {
		employeeFrm.setUserName(FormUtil.setNullToBlank(employee.getUserId()));
		employeeFrm.setPassword(FormUtil.setNullToBlank(employee.getUserPassword()));
		employeeFrm.setEmail(FormUtil.setNullToBlank(employee.getEmail()));
		employeeFrm.setGender(FormUtil.setNullToBlank(employee.getGender()));
		employeeFrm.setFirstName(FormUtil.setNullToBlank(employee.getFirstName()));
		employeeFrm.setMiddleName(FormUtil.setNullToBlank(employee.getMiddleName()));
		employeeFrm.setLastName(FormUtil.setNullToBlank(employee.getLastName()));
		employeeFrm.setHomePhone(FormUtil.setNullToBlank(employee.getHomePhone()));
		employeeFrm.setCellPhone(FormUtil.setNullToBlank(employee.getCellPhone()));
		employeeFrm.setWorkPhone(FormUtil.setNullToBlank(employee.getWorkPhone()));
		employeeFrm.setCarrier(FormUtil.setNullToBlank(employee.getCellularProvider()));
		employeeFrm.setEmailsms(employee.getSendEmailSms());
		employeeFrm.setAddress1(FormUtil.setNullToBlank(employee.getAddress1()));
		employeeFrm.setAddress2(FormUtil.setNullToBlank(employee.getAddress2()));
		employeeFrm.setEmployeeType(FormUtil.setNullToBlank(employee.getEmployeeType()));
		employeeFrm.setActiveFlag(employee.getActiveFlag());
		return employeeFrm;
	}

	/**
	 * @param userName
	 * @throws ParseException
	 * 
	 */
	private Employee mapFormToVO(EmployeeProfileForm employeeFrm,
			Employee employee, String userName) throws ParseException {

		employee.setFirstName(employeeFrm.getFirstName());
		employee.setLastName(employeeFrm.getLastName());
		employee.setUserId(employeeFrm.getUserName());
		employee.setUserPassword(employeeFrm.getPassword());
		employee.setGender(employeeFrm.getGender());
		employee.setEmail(employeeFrm.getEmail());
		employee.setMiddleName(employeeFrm.getMiddleName());
		employee.setHomePhone(employeeFrm.getHomePhone());
		employee.setWorkPhone(employeeFrm.getWorkPhone());
		employee.setCellPhone(employeeFrm.getCellPhone());
		employee.setSendEmailSms(employeeFrm.getEmailsms());
		employee.setCellularProvider(employeeFrm.getCarrier());
		employee.setActiveFlag(employeeFrm.getActiveFlag());
		employee.setAddress1(employeeFrm.getAddress1());
		employee.setAddress2(employeeFrm.getAddress2());
		employee.setEmployeeType(employeeFrm.getEmployeeType());

		employee.setModifiedDate(new Timestamp(new Date().getTime()));
		employee.setModifiedBy(userName);

		return employee;
	}
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.update", "update");
		map.put("button.save","Save");
		
		return map;
	}
}
