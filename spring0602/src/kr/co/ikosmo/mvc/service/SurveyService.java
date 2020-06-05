package kr.co.ikosmo.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ikosmo.mvc.dao.SurveyDao;
import kr.co.ikosmo.mvc.vo.SurveyContentVO;
import kr.co.ikosmo.mvc.vo.SurveyVO;

@Service
//트랜잭션 처리를 실행 해주는 어노테이션
@Transactional
public class SurveyService {
	
	@Autowired
	private SurveyDao surveyDao;
	
	public void addSurvey(SurveyVO vo, List<SurveyContentVO> list) {
		//@Transactional을 사용하지 않으면 vo 값들어가고  커밋처리 되고 list 들어가서 커밋처리 된다.
		//@Transactional 처리를 해주어야 list까지 정상적으로 값이 다 들어간 후에 커밋처리 된다.
		//예) vo에서 오류없이 정상 처리 되고 list에서 오류가 나게 되면 vo에 값만 들어가고 list값은 들어가지 않아서
		//DB 단에서 NULL이 뜨게 된다.
		//vo 수행하고 list수행할때까지 커밋을 안하고 기다렸다가 문제가 생기면 롤백시킨다.
		surveyDao.addSurvey(vo);
		surveyDao.addSurveyContent(list);
	}
	
	public void delSurvey(int num) {
		surveyDao.delscontent(num);
		surveyDao.delsurvey(num);
	}
	
}
