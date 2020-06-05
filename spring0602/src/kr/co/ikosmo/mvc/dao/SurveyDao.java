package kr.co.ikosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ikosmo.mvc.vo.SurveyContentVO;
import kr.co.ikosmo.mvc.vo.SurveyVO;
import kr.co.ikosmo.mvc.vo.SurveyView2VO;

@Repository
public class SurveyDao {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	public void addSurvey(SurveyVO vo) {
		ss.insert("survey.add", vo);
	}
	
	public void addSurveyContent(List<SurveyContentVO> list) {
		ss.insert("survey.addcontent", list);
	}
	
	public List<SurveyVO> adminList(){
		return ss.selectList("survey.adminList");
	}
	
	public void upcnt(int surveycnt) {
		ss.update("survey.upcnt");
	}
	
	public List<SurveyView2VO> adminDetail(int num) {
		return ss.selectList("survey.adminDetail", num);		
	}
	//surveyclientform : 설문지 폼에 출력 될 데이터 값
	public List<SurveyView2VO> surveyView2(){
		return ss.selectList("survey.surveyclient");
	}
	//MyBatis에 정의한 update구문을 실행
	public void surveyClientUpdate3(SurveyView2VO vo) {
		int res = ss.update("survey.update1", vo);
		System.out.println("res : "+res);
	}
	
	public void delscontent(int num) {
		ss.delete("survey.sc", num);
	}
	
	public void delsurvey(int num) {
		ss.delete("survey.s", num);
	}
}
