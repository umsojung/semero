package kr.co.ikosmo.mvc.model;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ikosmo.mvc.dao.SurveyDao;
import kr.co.ikosmo.mvc.service.SurveyService;
import kr.co.ikosmo.mvc.vo.SurveyContentVO;
import kr.co.ikosmo.mvc.vo.SurveyVO;
import kr.co.ikosmo.mvc.vo.SurveyView2VO;

@Controller
public class SurveyController {
	@Autowired
	private SurveyService surveyService;
	
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping(value = "surveyForm")
	public String surform() {
		return "survey/surveyAddform";
	}
	
	@RequestMapping(value = "/addsurvey", method = RequestMethod.POST)
	public ModelAndView addsurvey(SurveyVO vo,HttpServletRequest request) {
		
		System.out.println(vo.getSub());
		String[] surveytitle = request.getParameterValues("surveytitle");
		//parameter���� �迭�� ���� �ǰ�, �װ��� ���� ���� ���� �Ҷ��� List�� �����Ѵ�.
		List<SurveyContentVO> list = new ArrayList<>();
		int i = 0;
		char stype ='A'; //A����
		for(String e : surveytitle) {
			//Ÿ��Ʋ����Ʈ ���� ���� ������ �ڵ� ��ŭ�� ����Ҽ� �ְ� ó���� ����.
			if (i < vo.getCode()) {
				SurveyContentVO sv = new SurveyContentVO();
				sv.setSurveytype(String.valueOf(stype));//A�� ����
				System.out.println(stype);
				sv.setSurveytitle(e);
				list.add(sv);
			} else {
				break;
			}
			stype++;
			i++;;
		}
		
		System.out.println("Ȯ�� : "+list.size());
		surveyService.addSurvey(vo, list);
		ModelAndView mav = new ModelAndView("redirect:surveyList");
		return mav;
	}
	
	//������ ����Ʈ
	@RequestMapping(value = "/surveyList")
	public ModelAndView surveyList() {
		ModelAndView mav = new ModelAndView("survey/surveyList");
		List<SurveyVO> list = surveyDao.adminList();
		mav.addObject("list", list);
		return mav;
	}
	//������ detail������ ����
	@RequestMapping(value = "/surveyDetail")
	public ModelAndView surveyDateil(int num) {
		ModelAndView mav = new ModelAndView("survey/surveyDetail");
		List<SurveyView2VO> list = surveyDao.adminDetail(num);
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/surveydelete")
	public ModelAndView surveyDelete(int num) {		
		surveyService.delSurvey(num);
		ModelAndView mav = new ModelAndView("redirect:surveyList");
		return mav;
	}
}
