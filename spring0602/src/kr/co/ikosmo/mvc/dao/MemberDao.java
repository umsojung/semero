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
	
	//입력처리
	public int memberAdd(MemberDemoVO vo) {
		//입력 처리가 되면 1, 실패하면 0 반환 한다.
		return ss.insert("member.add", vo);
	}
	//id="idChk" resultType="int" parameterType="String"
	public int idChk(String id) {
		return ss.selectOne("member.idchk", id);
	}
	public List<MemberDemoVO> getList(PageVO svo){//nowPage등으로 연산이 된 start, end
		return ss.selectList("member.list", svo);
	}
	public int getTotalCount() { //전체 데이터를 기준으로 페이지를 나눌 것이기 때문에..
		return ss.selectOne("member.totalCount");
	}
	public List<MemberDemoVO> getSearchList(PageVO svo){
		return ss.selectList("member.serachlist", svo);
	}
}
