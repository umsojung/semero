package kr.co.ikosmo.mvc.model;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DefaultController {
	@RequestMapping(value = {"/","/index"})
	public String defaultPage() {
		return "main/index";
	}
}
