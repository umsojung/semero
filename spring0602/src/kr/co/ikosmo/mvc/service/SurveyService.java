package kr.co.ikosmo.mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.ikosmo.mvc.dao.SurveyDao;
import kr.co.ikosmo.mvc.vo.SurveyContentVO;
import kr.co.ikosmo.mvc.vo.SurveyVO;

@Service
//Ʈ����� ó���� ���� ���ִ� ������̼�
@Transactional
public class SurveyService {
	
	@Autowired
	private SurveyDao surveyDao;
	
	public void addSurvey(SurveyVO vo, List<SurveyContentVO> list) {
		//@Transactional�� ������� ������ vo ������  Ŀ��ó�� �ǰ� list ���� Ŀ��ó�� �ȴ�.
		//@Transactional ó���� ���־�� list���� ���������� ���� �� �� �Ŀ� Ŀ��ó�� �ȴ�.
		//��) vo���� �������� ���� ó�� �ǰ� list���� ������ ���� �Ǹ� vo�� ���� ���� list���� ���� �ʾƼ�
		//DB �ܿ��� NULL�� �߰� �ȴ�.
		//vo �����ϰ� list�����Ҷ����� Ŀ���� ���ϰ� ��ٷȴٰ� ������ ����� �ѹ��Ų��.
		surveyDao.addSurvey(vo);
		surveyDao.addSurveyContent(list);
	}
	
	public void delSurvey(int num) {
		surveyDao.delscontent(num);
		surveyDao.delsurvey(num);
	}
	
}
