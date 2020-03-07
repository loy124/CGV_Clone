package bit.com.a.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.CGVMemberDto;
import bit.com.a.service.CGVMemberService;

@Controller
public class CGVMemberController {

	@Autowired
	CGVMemberService cgvMemberService;

	private static Logger logger = LoggerFactory.getLogger(CGVInfoController.class);

	@RequestMapping(value = "moveLogin.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String moveLogin() {
		logger.info("moveLogin");
		return "login";
	}

	@RequestMapping(value = "moveRegister.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String moveRegister() {
		logger.info("moveRegister");
		return "register";
	}

	@RequestMapping(value = "moveMain.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String moveMain() {
		logger.info("moveMain");
		return "main";
	}

	@ResponseBody
	@RequestMapping(value = "idCheck.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String idCheck(String id) {
		logger.info("idCheck");
		boolean getId = cgvMemberService.getId(id);
		logger.info(getId + "");
		return getId + "";
	}

	@RequestMapping(value = "register.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String register(Model model, CGVMemberDto dto) {
		logger.info("register");
		boolean isSuccess = cgvMemberService.registerMember(dto);
		model.addAttribute("type", "register");
		model.addAttribute("isSuccess", isSuccess);
		
		return "process";

	}
	
	@RequestMapping(value = "login.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String login(Model model, CGVMemberDto dto, HttpSession session) {
		logger.info("register");
		CGVMemberDto cgvMemberDto = cgvMemberService.login(dto);
		model.addAttribute("type", "login");
		
		if(cgvMemberDto != null) {
			model.addAttribute("isSuccess", true);
			model.addAttribute("name", cgvMemberDto.getName());
			session.setAttribute("login", cgvMemberDto);
		}else {
			model.addAttribute("isSuccess", false);
		}
		
		return "process";

	}
	
	@RequestMapping(value = "logout.do", method = { RequestMethod.GET, RequestMethod.POST })
	public String logout(HttpSession session) {
		logger.info("logout");
		session.invalidate();
		
		return "redirect:/moveMain.do";

	}
}














