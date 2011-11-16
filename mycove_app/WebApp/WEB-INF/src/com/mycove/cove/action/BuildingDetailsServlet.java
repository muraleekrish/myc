package com.mycove.cove.action;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mycove.dao.BuildingDAO;
import com.mycove.dto.BuildingDTO;


public class BuildingDetailsServlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		System.out.println("check");
		BuildingDAO buildingDAO= null;
		String propertyId ="";		
		String formAction="";
		StringBuffer sb = new StringBuffer(); 
		String output="";
		//List lstbuildings = null;
		List<BuildingDTO> lstbuildings = null;
		 System.out.println("hiiiiiiiiiiiiiiiiiiiiiiii");
		try
		{
			PrintWriter out = response.getWriter();
			buildingDAO = new BuildingDAO();
			sb.append("<option value=\"0\">Select one</option>");
			 
			formAction = request.getParameter("formAction");
			if(formAction!=null && formAction.equalsIgnoreCase("getBuilding")) 
			{
				propertyId = request.getParameter("propertyId");
				if(propertyId!=null && !propertyId.trim().equalsIgnoreCase("") && !propertyId.trim().equalsIgnoreCase("0"))
				{
					lstbuildings = buildingDAO.getBuildingByPropertyId(Long.parseLong(propertyId));
					for (BuildingDTO buildingDTO : lstbuildings) {
							sb = sb.append("<option value=\""+buildingDTO.getName()+ "\" hiddenValue=\""+buildingDTO.getName()+"\" >"+buildingDTO.getName()+"</option>");
					}
				}
				System.out.println("getBuilding:"+sb.toString());
			}

    
		out.write(sb.toString());
	    out.close();
	}
	catch(Exception ex)
	{
		ex.printStackTrace();
	}
	
}
}

