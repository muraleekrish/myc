package com.mycove.cove.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.mycove.cove.form.SurveyListForm;
import com.mycove.dao.SurveyDAO;
import com.mycove.vo.Survey;

public class SurveyListAction extends Action {

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			{
		String action = "failure";
		try {

			if (form instanceof SurveyListForm) {
				SurveyDAO surveyDAO = new SurveyDAO();
				Collection<Survey> surveyDTOs = surveyDAO.findAll();
				request.setAttribute("surveys", surveyDTOs);
				action = "input";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mapping.findForward(action);
	}
}
