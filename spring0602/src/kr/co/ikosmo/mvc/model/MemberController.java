package kr.co.ikosmo.mvc.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.co.ikosmo.mvc.dao.MemberDao;
import kr.co.ikosmo.mvc.vo.MemberDemoVO;
import kr.co.ikosmo.mvc.vo.PageVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDao memberDao;
	
	//ȸ�� ���� �� ����
	@RequestMapping(value = "/memberForm")
	public String memberForm() {
		return "member/memberForm";
	}
	
	//ȸ������ ó�� �ϱ�.
	@PostMapping("/memberIn")
	public ModelAndView addMember(MemberDemoVO vo) {
		ModelAndView mav = new ModelAndView();
		int res= memberDao.memberAdd(vo);
		if (res == 1) { // ���̹�Ƽ�� �۾��� ����
			mav.setViewName("member/success");
			mav.addObject("mid", vo.getId());
		}else {
			mav.setViewName("member/error");
			mav.addObject("mid", vo.getId());
		}
		return mav;
	}
	
	/*
	 * //���̵� �ߺ� üũ�� ���� ����.
	 * 
	 * @RequestMapping(value = "/idChk") //��û public String idChk(Model m) { return
	 * "member/idChk"; //view �̸� }
	 */
	
	@RequestMapping(value = "/memlist")
	public String listSearch(PageVO vo, Model model, 
			@RequestParam(value="nowPage", required=false, defaultValue="1") String nowPage,
			@RequestParam(value="cntPerPage", required=false, defaultValue="5") String cntPerPage){
		
		int total = memberDao.getTotalCount();
		
		vo = new PageVO(total, Integer.parseInt(nowPage), Integer.parseInt(cntPerPage));
		System.out.println("Start : "+vo.getStart());
		System.out.println("End : "+vo.getEnd());
		model.addAttribute("paging", vo);
		model.addAttribute("list", memberDao.getList(vo));
		return "member/memberlist";
	}
	
	@RequestMapping(value = "/memberSearchlist")
	public String memberSearchList(Model model, PageVO vo) {
		System.out.println("vo : "+vo.getSearchValue());
		model.addAttribute("list", memberDao.getSearchList(vo));
		return "member/memberserachlist";
	}
}
