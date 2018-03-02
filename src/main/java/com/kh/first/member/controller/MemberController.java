package com.kh.first.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kh.first.member.model.service.MemberService;
import com.kh.first.member.model.vo.Member;

@Controller
public class MemberController {
	
	//private MemberService memberService = new MemberService();
	@Autowired
	private MemberService memberService;
	//IoC(제어반전) = DI(Dependancy injection : 의존성 주입) + AOP
	
	@RequestMapping(value="login.do",method=RequestMethod.POST)
	/*public String loginMethod(
			@RequestParam(value = "member_id") String userid,
			@RequestParam(value = "member_pwd") String userpwd,
			HttpSession session) {
		Member member = new Member();
		member.setMember_id(userid);
		member.setMember_pwd(userpwd);
		
		session.setAttribute("loginUser", memberService.loginCheck(member));
		return "home";
	}*/
	
	/*public String loginMethod(HttpServletRequest request) {
	String userid = request.getParameter("member_id");
	String userpwd = request.getParameter("member_pwd");
	Member member = new Member();
	member.setMember_id(userid);
	member.setMember_pwd(userpwd);

	Member loginUser = memberService.loginCheck(member);
	String viewName = null;
	
	if(loginUser != null) {
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", loginUser);
		viewName = "home";
	}else {
		viewName = "loginFail";
	}
	return viewName;
}*/
	
	public String loginMethod(Member member, HttpSession session) {
		Member loginUser = memberService.loginCheck(member);
		session.setAttribute("loginUser", loginUser);
		return "home";
	}
	
	@RequestMapping("/logout.do")
	public String logoutMethod(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		if(session != null) {
			session.invalidate();
		}
		
		return "home";
	}
	
	@RequestMapping(value = "/minsert.do", method = RequestMethod.POST)
	public String insertMember(Member member, Model model) {
		int result = memberService.insertMember(member);
		String viewName = null;
		if(result > 0)
			viewName = "home";
		else {
			model.addAttribute("message", "회원가입 실패");
			viewName = "minsertFail";
		}
		return viewName;
	}
	
	@RequestMapping("/enrollForm.do")
	public String enrollFormMethod() {
		
		return "member/minsertForm";
		
	}
}
