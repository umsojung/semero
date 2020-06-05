package kr.co.ikosmo.mvc.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import kr.co.ikosmo.mvc.vo.MemberDemoVO;
import kr.co.ikosmo.mvc.vo.PageVO;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate ss;
	
	//�Է�ó��
	public int memberAdd(MemberDemoVO vo) {
		//�Է� ó���� �Ǹ� 1, �����ϸ� 0 ��ȯ �Ѵ�.
		return ss.insert("member.add", vo);
	}
	//id="idChk" resultType="int" parameterType="String"
	public int idChk(String id) {
		return ss.selectOne("member.idchk", id);
	}
	public List<MemberDemoVO> getList(PageVO svo){//nowPage������ ������ �� start, end
		return ss.selectList("member.list", svo);
	}
	public int getTotalCount() { //��ü �����͸� �������� �������� ���� ���̱� ������..
		return ss.selectOne("member.totalCount");
	}
	public List<MemberDemoVO> getSearchList(PageVO svo){
		return ss.selectList("member.serachlist", svo);
	}
}
