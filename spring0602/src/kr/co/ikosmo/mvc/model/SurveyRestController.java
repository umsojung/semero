package kr.co.ikosmo.mvc.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.co.ikosmo.mvc.dao.SurveyDao;
import kr.co.ikosmo.mvc.vo.SurveyView2VO;

@RestController
public class SurveyRestController {
	
	@Autowired
	private SurveyDao surveyDao;
	
	@RequestMapping(value = "/surveyClientJson")
	public List<SurveyView2VO> getList(int num) {
		List<SurveyView2VO> list = surveyDao.adminDetail(num);
		return list;
	}
	
	@RequestMapping(value = "/surveyClientJson2", produces = "application/json; charset=euc-kr")
	public String surveyDetail2(int num) {
		List<SurveyView2VO> list = surveyDao.adminDetail(num);
		Map<String, Integer> map = new HashMap<>();
		for(SurveyView2VO e : list) {
			map.put(e.getSurveytitle(), e.getSurveycnt());
		}
		System.out.println("Size : "+list.size());
		String result = null;
		ObjectMapper mapper = new ObjectMapper();	
			try {
				result = mapper.writeValueAsString(map);
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (JsonGenerationException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(result);
			return result;	
		}
}