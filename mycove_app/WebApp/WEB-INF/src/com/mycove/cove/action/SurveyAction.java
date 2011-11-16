package com.mycove.cove.action;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.LookupDispatchAction;

import com.mycove.cove.form.AddSurveyForm;
import com.mycove.dao.SurveyDAO;
import com.mycove.util.util.FormUtil;
import com.mycove.vo.SurveyOptions;

public class SurveyAction extends LookupDispatchAction {
	
@Override
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		 
		if (FormUtil.isNotNull(request.getParameter(mapping.getParameter())) 
				&& request.getParameter(mapping.getParameter()).equals("add")) {
			
			return this.add(mapping, form, request, response);
		} 
		
		else
		{
			return mapping.findForward("input");
		}
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
		    HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		if (form instanceof AddSurveyForm) {
			ActionMessages messages = new ActionMessages();
			AddSurveyForm surveyfrm = (AddSurveyForm) form;
			ActionErrors actionErrors = surveyfrm.validate(mapping, request);
			if(actionErrors.isEmpty())
			{
				String userName =  (String) request.getSession().getAttribute("userName");
								try {
					SurveyDAO surveyDAO = new SurveyDAO();
									
					com.mycove.vo.Survey survey= new com.mycove.vo.Survey();
					survey.setStartDay(surveyfrm.getStartDate());
					survey.setStartMonth(surveyfrm.getStartMonth());
					survey.setStartYear(surveyfrm.getStartYear());
					survey.setEndDay(surveyfrm.getEndDate());
					survey.setEndMonth(surveyfrm.getEndMonth());
					survey.setEndYear(surveyfrm.getEndYear());
					survey.setQuestion(survey.getQuestion());
					Set<SurveyOptions> surveyOptions = new HashSet<SurveyOptions>();
					surveyOptions.add(new SurveyOptions(survey, surveyfrm.getOption1(), userName));
					surveyOptions.add(new SurveyOptions(survey, surveyfrm.getOption2(), userName));
					surveyOptions.add(new SurveyOptions(survey, surveyfrm.getOption3(), userName));
					surveyOptions.add(new SurveyOptions(survey, surveyfrm.getOption4(), userName));
					surveyOptions.add(new SurveyOptions(survey, surveyfrm.getOption5(), userName));
					survey.setSurveyOptionses(surveyOptions);
					survey.setProperty(surveyfrm.getProperty());
				 	surveyDAO.save(survey);
					
					messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("main.Updated"));
					saveMessages(request, messages); 
					request.setAttribute("message", "message");
					return mapping.findForward("success");

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else
			{
				saveErrors(request, actionErrors);
				return mapping.findForward("input");
			}
		}
		return mapping.findForward("input");
	}
		
	
	@Override
	protected Map<String, String> getKeyMethodMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("button.submit", "submit");
		return map;
	}
}
