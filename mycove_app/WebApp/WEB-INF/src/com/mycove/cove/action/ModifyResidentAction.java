package com.mycove.cove.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.LookupDispatchAction;
import org.apache.struts.upload.FormFile;

import com.mycove.cove.form.ModifyResidentForm;
import com.mycove.dao.BuildingDAO;
import com.mycove.dao.PropertyDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.Apartment;
import com.mycove.vo.Building;
import com.mycove.vo.Tenant;

/*public class ModifyResidentAction extends LookupDispatchAction {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {
			if (form instanceof ModifyResidentForm) {
				ModifyResidentForm modifyResidentForm = (ModifyResidentForm) form;
				if (FormUtil.isNotNull(mapping.getParameter()) 
						&& FormUtil.isNotNull(request.getParameter(mapping.getParameter()))
						&& request.getParameter(mapping.getParameter()).equals("Submit")) {
					return this.submit(mapping, form, request, response);
				} else {
					String formAction = FormUtil.setNullToBlank(request.getParameter("formAction"));
					
					if(FormUtil.isNotNull(request.getParameter("propertyId")))
					{
						modifyResidentForm.setPropertyId(request.getParameter("propertyId"));
					}
					if (formAction.equalsIgnoreCase("edit")) {
						if (FormUtil.isNotNull(request.getParameter("buildingId"))) {
							BuildingDAO buildingDAO = new BuildingDAO();
							Building building = buildingDAO.findById(Long.parseLong(request.getParameter("buildingId")));
							modifyResidentForm.setId(request.getParameter("buildingId"));
							modifyResidentForm.setBuildingName(building.getBuildingName());
							action = "input";
						}
					}
					else if(formAction.equalsIgnoreCase("add"))
					{
						action= "input";
					}
					else
					{
						action= "input";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}

	/**
	 * @param mapping
	 * @param form
	 * @param request
	 * @param response
	 * @return
	 */
	/*private ActionForward submit(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response) {
		String action = "input";
		try {
			ModifyResidentForm modifyResidentForm = (ModifyResidentForm) form;
			FormFile formFile = modifyResidentForm.getResidentFile();
			
			Building building;
			BuildingDAO buildingDAO =new BuildingDAO();
			if(!FormUtil.isNullOrBlank(buildingForm.getId()))
			{
				building = buildingDAO.findById(Long.parseLong(buildingForm.getId()));
				building.setBuildingName(buildingForm.getBuildingName());
				String strFileContent = new String(formFile.getFileData()).trim();
				Set<Apartment> apartments;
				if (strFileContent.length() > 0) {
					apartments = parseApartmentDetails(strFileContent, building);
				} else {
					apartments = new HashSet<Apartment>();
				}
				building.setApartments(apartments);
				
				buildingDAO.update(building);
			}
			else
			{
				//building = new Building();
				//building.setProperty(new PropertyDAO().findById(Long.parseLong(buildingForm.getPropertyId())));
				//building.setBuildingName(buildingForm.getBuildingName());
				String strFileContent = new String(formFile.getFileData()).trim();
				Set<Tenant> tenants;
				if (strFileContent.length() > 0) {
					tenants = parseTenantDetails(strFileContent, building);
				} else {
					tenants = new HashSet<Tenant>();
				}
				building.setApartments(apartments);
				
				buildingDAO.save(building);
			}
			
			
			action = "success";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mapping.findForward(action);
	}*/

	/**
	 * @param strFileContent
	 * @param building 
	 * @return
	 */
/*	private Set<Tenant> parseTenantDetails(String strFileContent,
			Building building) {
		Set<Tenant> tenants = new HashSet<Tenant>();

		String[] tenantArray = strFileContent.split("\n");
		Tenant tenant = null;
		String[] tenantDetail;
		for (int i = 0; i < tenantArray.length; i++) {
			tenantDetail = tenantArray[i].split(",");
			if (tenantDetail.length > 0) {
				tenant = new Tenant();
				tenant.(tenantDetail[0]);
				tenant.setUserId(tenantDetail[1]);
				tenant.setUserPassword(tenantDetail[2]);
				tenant.setEmail(tenantDetail[3]);
				tenant.setFirstName(tenantDetail[3]);
				tenant.setLastName(tenantDetail[4]);
				tenants.add(tenant);
			}
		}
		return tenants;
	}

	/* (non-Javadoc)
	 * @see org.apache.struts.actions.LookupDispatchAction#getKeyMethodMap()
	 */
/*	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.submit", "submit");
		return map;
	}
}
*/