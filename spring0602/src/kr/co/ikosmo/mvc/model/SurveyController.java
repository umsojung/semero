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
		//parameter값이 배열로 전송 되고, 그것을 실제 값이 존재 할때만 List에 저장한다.
		List<SurveyContentVO> list = new ArrayList<>();
		int i = 0;
		char stype ='A'; //A지정
		for(String e : surveytitle) {
			//타이틀리스트 값이 내가 선택한 코드 만큼만 출력할수 있게 처리한 로직.
			if (i < vo.getCode()) {
				SurveyContentVO sv = new SurveyContentVO();
				sv.setSurveytype(String.valueOf(stype));//A값 세팅
				System.out.println(stype);
				sv.setSurveytitle(e);
				list.add(sv);
			} else {
				break;
			}
			stype++;
			i++;;
		}
		
		System.out.println("확인 : "+list.size());
		surveyService.addSurvey(vo, list);
		ModelAndView mav = new ModelAndView("redirect:surveyList");
		return mav;
	}
	
	//관리자 리스트
	@RequestMapping(value = "/surveyList")
	public ModelAndView surveyList() {
		ModelAndView mav = new ModelAndView("survey/surveyList");
		List<SurveyVO> list = surveyDao.adminList();
		mav.addObject("list", list);
		return mav;
	}
	//관리자 detail페이지 구현
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
