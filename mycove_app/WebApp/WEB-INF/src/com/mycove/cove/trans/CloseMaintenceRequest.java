/**
 * 
 */
package com.mycove.cove.trans;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;

import com.mycove.dao.EmployeeDAO;
import com.mycove.dao.TenantDAO;
import com.mycove.util.email.EmailUtil;
import com.mycove.vo.Employee;
import com.mycove.vo.MaintenanceRequest;
import com.mycove.vo.Property;
import com.mycove.vo.Tenant;

/**
 * @author Karthikeyan
 *
 */
public class CloseMaintenceRequest extends MessageHandler {
	
	private final static Logger log = Logger.getLogger(CloseMaintenceRequest.class);
	
	private MaintenanceRequest maintenanceRequest;
	private Long userId;
	
	public CloseMaintenceRequest(MaintenanceRequest maintenanceRequest, Long userId) {

		this.maintenanceRequest = maintenanceRequest;
		this.userId = userId;
	}
	
	public void execute() throws Exception {
		log.info("CloseMaintenceRequest execution Starts");
		try {
			EmailUtil emailUtil = new EmailUtil();
			Employee employee = (Employee)new EmployeeDAO().findById(userId);
			emailUtil.setEmailFrom(employee.getEmail());
			TenantDAO tenantDAO = new TenantDAO();
			List<Tenant> tenants = tenantDAO.findTenantByProperty(TenantDAO.APARTMENT_ID, maintenanceRequest.getApartment().getId());
			Tenant tenant = null;
			if(tenants.size() > 0)
			{
				tenant = tenants.get(0);
				List<String> emailTo = new ArrayList<String>();
				Property property = maintenanceRequest.getApartment().getBuilding().getProperty();
				emailTo.add(tenant.getEmail());
				emailUtil.setEmailTo(emailTo);
				
				String subject = "Maintenance Request Closed";
				emailUtil.setSubject(getProblemSummary(subject));
				
				String mailBody = getMailBody(employee, tenant);
				emailUtil.setBody(mailBody, EmailUtil.MIME_TYPE_TEXT);
				log.info("Storing the message");
				saveEmail(property, employee, tenant, emailTo, mailBody, subject);
				log.info("Message stored successfully");
				Thread thread = new Thread(emailUtil);
				thread.start();
			}
			
			log.info("CreateMaintenceRequest execution Ends");
		} catch (Exception e) {
			log.error("Error on CreateMaintenceRequest execution. ", e);
			throw e;
		}
	}

	/**
	 * @param property
	 * @param employee
	 * @param tenant 
	 * @return
	 */
	private String getMailBody(Employee employee, Tenant tenant) {
		DateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
		StringBuilder messageBody = new StringBuilder();
		
		
		messageBody.append("Dear ").append(tenant.getFirstName()).append(" ").append(tenant.getLastName()).append(",").append("\n\n")
		.append("Subject: Maintenance Req-Closed-").append(maintenanceRequest.getMaintenanceLocation()).append("/").append(maintenanceRequest.getMaintenanceRequest()).append("\n\n")
		.append("This is to confirm that your maintenance request has been updated. The details are as follows:-").append("\n")
		.append(" Date : "+sdf.format(new Date())).append("\n Status: Closed\n\nThanks & Regards,\n")
		.append(employee.getFirstName()).append(" ").append(employee.getLastName()).append("\n")
		.append("Email : ").append(employee.getEmail()).append("\n")
		.append("Phone : ").append(employee.getWorkPhone());

		return messageBody.toString();
	}
}
