package kr.co.ikosmo.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ikosmo.mvc.dao.MemberDao;

//JSON or 커스텀 뷰를 만들 때 사용가능.
//Ajax는 순수하게 값만 전달할 비동기식 표기법이기 때문에 Ajax에 사용하기 적합하다.
//데이터만 표현하기 위해 사용하는 것이다.
@RestController
public class IdChkRestController {
	
	@Autowired
	private MemberDao memberDao;
	
	@RequestMapping(value = "/idChk")
	public int idChk(String id) {
		int cnt = memberDao.idChk(id);
		return cnt;
	}
}
