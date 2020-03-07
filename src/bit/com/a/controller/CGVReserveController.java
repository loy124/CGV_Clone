package bit.com.a.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mysql.cj.Session;

import bit.com.a.model.CGVMemberDto;
import bit.com.a.model.CGVPayDto;
import bit.com.a.model.CGVReserveDto;
import bit.com.a.service.CGVPayService;
import bit.com.a.service.CGVReserveService;

@Controller
public class CGVReserveController {

	@Autowired
	CGVReserveService cgvReserveService;
	
	@Autowired
	CGVPayService cgvPayService;
	
	private static Logger logger = LoggerFactory.getLogger(CGVInfoController.class);
	@RequestMapping(value="moveReserve.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String moveReserve() {
		logger.info("moveReserve");
		return "reserve";
	}
	
	
	@RequestMapping(value="moveSeat.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String moveSeat(Model model, CGVReserveDto dto) {
		
		System.out.println(dto.toString());
		logger.info("moveSeat");
		model.addAttribute("reserve", dto);
		
		return "seat";
	}
	

	@RequestMapping(value="moveKakao.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String moveKakao(Model model, CGVReserveDto dto, CGVPayDto payDto, HttpSession session) {	
		System.out.println(dto.toString());
		logger.info("moveKakao");
		CGVMemberDto login =(CGVMemberDto)session.getAttribute("login");
		
		dto.setId(login.getId());
		boolean isSuccess = cgvReserveService.CGVReserve(dto);
		System.out.println(isSuccess);
		model.addAttribute("reserve", dto);
		model.addAttribute("pay", payDto);
		if(isSuccess == false) {
			System.out.println("오류가 났어요...");
			return "redirect:/moveMain.do";
		}
		return "kakao";
	}
	
	@RequestMapping(value="payKakao.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String payKakao(Model model, CGVReserveDto dto, CGVPayDto payDto, HttpSession session) {	
		
		logger.info("moveKakao");
		CGVMemberDto login =(CGVMemberDto)session.getAttribute("login");
	
		 dto.setId(login.getId());
		 System.out.println(dto.toString() +"이것이 dto다");
		 List<CGVReserveDto> list = cgvReserveService.getCGVReserve(dto);
		/* CGVReserveDto cgvReserveDto = cgvReserveService.getCGVReserve(dto); */
//		if(cgvReserveDto != null) {
			System.out.println("여기있다");
//			System.out.println(cgvReserveDto.toString());
//		}
		payDto.setId(list.get(0).getId());
		payDto.setReserveSequence(list.get(0).getReserveSequence());
		System.out.println("문제찾기");
		System.out.println(payDto.toString());
		boolean isSuccess = cgvPayService.payTicket(payDto);
		System.out.println(isSuccess);
		if(isSuccess == false) {
			System.out.println("오류가 났어요...");
			return "redirect:/moveMain.do";
		}
		model.addAttribute("type", "reserve");
		model.addAttribute("isSuccess", isSuccess);
		/*
		 * model.addAttribute("reserve", dto); model.addAttribute("pay", payDto);
		 */
		
		return "process";
	}
	
	@RequestMapping(value="moveMypage.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String moveMain(Model model, CGVReserveDto reserveDto, CGVPayDto payDto, HttpSession session) {
		CGVMemberDto login =(CGVMemberDto)session.getAttribute("login");
		
		 
		reserveDto.setId(login.getId());
		List<CGVReserveDto> list = cgvReserveService.getPayJoinTable(reserveDto);
		
		if(list != null) {
			for(CGVReserveDto dto : list) {
				System.out.println(dto.toString());
				model.addAttribute("reserveList", list);
			}
		}else {
			System.out.println("이것이 오류다");
		}
		
		return "myPage";
	}
}







