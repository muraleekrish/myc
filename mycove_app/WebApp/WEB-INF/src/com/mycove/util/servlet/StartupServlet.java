package com.mycove.util.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.log4j.Logger;

import com.mycove.dao.BaseDAO;
import com.mycove.util.email.EmailUtil;

@SuppressWarnings("serial")
public class StartupServlet extends HttpServlet {

	static Logger log = Logger.getLogger(StartupServlet.class);

	public void init(ServletConfig config) throws ServletException {

		super.init(config);
		ServletContext ctx = config.getServletContext();

		String serverURL = config.getInitParameter("serverUrl");
		System.out.println(serverURL);
		if (serverURL == null || serverURL == "") {
			log.warn("Server URL (serverUrl) parameter missing: serverUrl=" + serverURL);
		} else {
			log.debug("serverUrl=" + serverURL);
			ctx.setAttribute("serverUrl", serverURL);
		}
		
		try {
			BaseDAO<Integer> baseDao = new BaseDAO<Integer>();
			baseDao.checkDatabaseConnection();
		} catch (Exception e) {
			try {
				EmailUtil emailUtil = new EmailUtil();
				emailUtil.emailAdmin("Databast connection issue", "Unable to connect database. Error : "+e.getMessage());
			} catch (IOException ioe) {
				log.error(ioe.getMessage(), ioe);
			}
		}
	}

	public void destroy(ServletConfig config) throws ServletException {
		log.info(" ----------------  Startup Servlet Destroyed  ------------------");
	}
}
