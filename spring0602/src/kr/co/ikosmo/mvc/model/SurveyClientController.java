package kr.co.ikosmo.mvc.model;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ikosmo.mvc.dao.SurveyDao;
import kr.co.ikosmo.mvc.vo.SurveyView2VO;


@Controller
public class SurveyClientController {
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping(value = "/surveyClient")
	public ModelAndView surveyClientForm() {
		List<SurveyView2VO> list = surveyDao.surveyView2();
		ModelAndView mav = new ModelAndView();
		mav.setViewName("survey/surveyClientForm");
		System.out.println(list.size());
		mav.addObject("list", list);
		return mav;
	}
	
	@RequestMapping(value = "/surveyUpdate", method = RequestMethod.POST )
	public ModelAndView surveyUpdate(SurveyView2VO vo) {
		surveyDao.surveyClientUpdate3(vo);
		System.out.println("µø¿€!"+vo.getSubcode()+":"+vo.getSurveytype());
		ModelAndView mav = new ModelAndView("redirect:surveyClientDetail?num="+vo.getSubcode());
		return mav;
	}

		@RequestMapping(value = "/surveyClientDetail")
		public ModelAndView surveyDateil(int num) {
			ModelAndView mav = new ModelAndView("survey/surveyClientDetail");
			List<SurveyView2VO> list = surveyDao.adminDetail(num);
			mav.addObject("list", list);
			return mav;
		}

}
