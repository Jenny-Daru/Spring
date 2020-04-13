package site.itwill10.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Hewon;

@Controller
public class LoginController {
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
//		/ : ��θ� ������ �� ���丮�� ������ �����ϴ� �� 
//		    => WEB-INF(����) >> view >> session���� >> Login_form.jsp
//		    => views�ؿ� ������ ���� ��� 
		return "session/login_form";
	}
	
	
	/*
	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	�Է°��� ������ ��� �Ű������� �̿��� �� ���޹ޱ� 
//	��� View�������� ���� �����ϱ� ���ؼ��� session�� ���
//	�Ű������� �ڷ����� HttpSession�� ��� �ڵ����� ������ ���ε��Ǿ� ����
	public String login(@RequestParam String id, @RequestParam String password, Model model, HttpSession session) {
		if(!id.equals("Daru") || !password.equals("123456")) {     //��������
//			forward�̵��Ǵ� View������(JSP����)���� ���� - Request Scope
			model.addAttribute("message", "�Ƶ�� ��� Ʋ����~ ũũ");
			model.addAttribute("id", id);
			return "session/login_form";
		}
		
//		���ؽ�Ʈ�� �����ϴ� ��� �ڿ����� ���� - Session Scope
//		 => �α��� ����
		session.setAttribute("loginId", id);
		return "session/login_result";
	}
	*/
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute  Hewon hewon, Model model, HttpSession session) {
		if(!hewon.getId().equals("Daru") || !hewon.getPw().equals("123456")) {     //��������
			model.addAttribute("message", "�Ƶ�� ��� Ʋ����~ ũũ");
			return "session/login_form";
		}
		
		session.setAttribute("loginId", hewon.getId());
		return "session/login_result";
	}	

}














