/**
 * 
 */
package com.mycove.common;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Karthikeyan
 * 
 */
public class AppConstant {

	public static String getServerUrl(HttpServletRequest request) {
		/*if (FormUtil.isNotNull(request.getSession())
				&& FormUtil.isNotNull(request.getSession().getServletContext().getAttribute("serverURL")))
		{
			return (String) request.getSession().getServletContext().getAttribute("serverURL");
		}
		else
		{
			return new String();
		}*/
		return "http://stlp5:8201/mycoveservice/mycove?command=tenantapp_";
	}
}
