package kr.co.ikosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ikosmo.mvc.vo.TBoardVO;
//DAO�� ������ ������ִ� ������̼� (@controller�� ����ϴ�.)
//kosmo-spring1.xml�� scanning��� ������̼� �̱� ������, ������ �����̳ʿ� <bean>����  ����� �ȴ�.
@Repository
public class TvoDao {
	@Autowired
	private SqlSessionTemplate ss;
	public void addTvo(TBoardVO vo) {
		//spring + mybatis ����, commit() ����, closed() ���� �Ѵ�.
		//tvo.add => namespace.id
		ss.insert("tvo.add",vo);
	}
	
	//selectList�۾�
	public List<TBoardVO> listTvo(){
		return ss.selectList("tvo.list");
	}
	
	//��︮�� �޼��带 ���� �غ���. tvo.pwdChk	
	public String pwdChk(int num){
		return ss.selectOne("tvo.pwdChk", num);
	}
	
	public TBoardVO detailTvo(int num) {
		return ss.selectOne("tvo.detail", num);
	}
	
}
