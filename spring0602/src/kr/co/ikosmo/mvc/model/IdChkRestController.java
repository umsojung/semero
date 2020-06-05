package kr.co.ikosmo.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.co.ikosmo.mvc.dao.MemberDao;

//JSON or Ŀ���� �並 ���� �� ��밡��.
//Ajax�� �����ϰ� ���� ������ �񵿱�� ǥ����̱� ������ Ajax�� ����ϱ� �����ϴ�.
//�����͸� ǥ���ϱ� ���� ����ϴ� ���̴�.
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
