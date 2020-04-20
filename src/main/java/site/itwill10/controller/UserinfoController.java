package site.itwill10.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import site.itwill10.dto.Userinfo;
import site.itwill10.exception.LoginAuthFailException;
import site.itwill10.exception.UserinfoExistsException;
import site.itwill10.exception.UserinfoNotFoundException;
import site.itwill10.service.UserinfoService;

@Controller
//��ûó�� �޼ҵ� ��û�� ���� ���丮�� �� 
@RequestMapping("/userinfo")
public class UserinfoController {
	
	@Autowired
	private UserinfoService userinfoService;

/*	
//	�����ڰ� �������� ��û�� ��쿡�� ��û�޼ҵ��� ����� ����ǵ��� ���� ����
//	 => �α��� ������ ����ڰ� �ƴ� ��� �Ǵ� �����ڰ� �ƴ� ��� ������ ���� �߻��Ͽ� ���������� ����
//	 => �� �޼ҵ带 ��û�� Ŭ���̾�Ʈ�� ���������� �ƴ��� Ȯ���ؾ���
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(HttpSession session) {
//		session�� "loginUserinfo"�� ����� ������ �ִٸ�~~~ ���� ������ null�����
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
//		�α��� ����ڰ� �ƴϰų� �����ڰ� �ƴ϶��
		if(loginUserinfo==null || loginUserinfo.getStatus()!=9) {
			//return "userinfo/user_error";
//			������ ���� �߻� - ����ó�� �޼ҵ尡 �����ϴ� ��� , ��ϱ��� ���� �� 
			throw new RuntimeException();      
		}
		return "userinfo/user_write";
	}
*/

//	4/20 AdminAuthInterceptor.java ����Ϸ��� �ٽ� �ۼ�
//	���ͼ��͸� �̿��Ͽ� �����ڰ� �ƴ� ����ڰ� ��û�� ��� ��ûó�� �޼ҵ尡 ȣ����� �ʵ��� ����
//	���ͼ���(Interceptor) : FrontController�� ���� ��ûó�� �޼ҵ� ȣ�� �� �ʿ��� ����� �����ϴ� ��� => �� ���� ó���� ���� ��� ��
//							������ AOP �̹Ƿ� BeanConfiguration���� ��� �����ؾ��� => ���ͼ��͸� ����Ϸ��� Ŭ������ �ʿ� util ��Ű���� Ŭ���� ���� => servlet-context.xml
	
//	                         => ���ʹ� ��Ʈ�ѷ��� ������ Ŭ���̾�Ʈ���� ����Ǳ����� ���� �����ϰų� ó�������
//	 							���ͼ��ʹ� ����Ʈ��Ʈ�ѷ� ���ο� �����Ͽ� ��ûó���޼ҵ� ������ �ɷ��ִ� ���� , ���и� ������ 
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "userinfo/user_write";
	}
	
//	try ~ cathch�� ����ϸ� �������Ƿ� ExceptionHandler �̿�
	/*
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Userinfo userinfo, Model model) {
		try {
			userinfoService.addUserinfo(userinfo);
		} catch (UserinfoExistsException e) {
			model.addAttribute("message", e.getMessage());
//			���̵� �ߺ�
			return "userinfo/user_write";
		} catch (Exception e) {
			e.printStackTrace();          //  �����ڰ� �������� �ְ� ����α�~
			return "userinfo/user_error";
		}
		return "redirect:/userinfo/login";
	}
	*/
	
//	Service Ŭ������ �޼ҵ� ����� ���ܰ� �߻��� ��� �߻��� ���ܸ� ó������ �ʰ� FrontController ���� ����
//	 => FrontController�� ���ܰ� ���Ѱ� ������ ����ó��(ExceptionHandler) �޼ҵ带 ȣ���Ͽ� ���� ó��
//	 => ExceptionHandler�� ���ܸ� ó���ϴ� ��� 2���� 
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Userinfo userinfo) throws UserinfoExistsException {
		userinfoService.addUserinfo(userinfo);
		return "";
	}
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "userinfo/user_login";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute Userinfo userinfo, HttpSession session) throws LoginAuthFailException, UserinfoNotFoundException {
//		�������� - ���ܹ߻� 
		userinfoService.loginAuth(userinfo);
		
//		�������� - session�� �̿��Ͽ� ��������(ȸ������) ���� => ���Ѽ��� ,  "loginUserinfo"�� id�� ����
		session.setAttribute("loginUserinfo", userinfoService.getUserinfo(userinfo.getUserid()));
		
		if(session.getAttribute("destURI")!=null) {
			String destURI=(String)session.getAttribute("destURI");
			session.removeAttribute("destURI");
			return "redirect:"+destURI;
		}
		return "userinfo/user_login";
	}
	
	
	@RequestMapping(value = "/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/userinfo/login";
	}
	
//	4/20 ���� �߰����
//	�α��� ������ ����ڰ� ��û�� ��쿡�� ��û�޼ҵ��� ����� ����ǵ��� ����
	/*
	@RequestMapping(value = "/list")
	public String list(Model model, HttpSession session, HttpServletRequest request) {
//		�α��� ������ ����ڰ� �ƴ� ��� ������ ���� �߻� - ���������� ����
		//if(session.getAttribute("loginUserinfo")==null) {
//			throw new RuntimeException();
//		}
		
//		�α��� ������ ����ڰ� �ƴ� ��� - �α��� �Է������� ���û
//		 => �α��� ���� �� ���� ��û�������� ����ǵ��� ����  ================> ��� view���������� ����ؾ��ϹǷ� ���ͼ��� Ŭ���� ���� 
		if(session.getAttribute("loginUserinfo")==null) {
			String url=request.getRequestURI().substring(request.getContextPath().length());
			String query=request.getQueryString();
			if(query==null) {
				query="";
			} else {
				query="?"+query;
			}
			
			if(request.getMethod().equals("GET")) {
				session.setAttribute("destURI", url+query);
			}
			return "redirect:/userinfo/login";
		}
		
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		
		return "userinfo/user_list";
	}
	*/
	
//	���ͼ���Ŭ���� LoginAuthInterceptor.java �ۼ� �� �ٽ� ���ۼ�
//	���ͼ��͸� �̿��Ͽ� �α��� ����ڰ� �ƴ� ��� ��ûó�� �޼ҵ尡 ȣ��ǵ��� ����
	@RequestMapping(value = "/list")
	public String list(Model model) {
		model.addAttribute("userinfoList", userinfoService.getUserinfoList());
		return "userinfo/user_list";
	}
	
	
//	���ͼ��͸� �̿��Ͽ� �α��� ����ڰ� �ƴ� ��� ��ûó�� �޼ҵ尡 ȣ��ǵ��� ����
	@RequestMapping(value = "/view")
	public String view(@RequestParam String userid, Model model) throws UserinfoNotFoundException {
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_view";
	}
	
	
//	���ͼ��͸� �̿��Ͽ� �α��� ����ڰ� �ƴ� ��� ��ûó�� �޼ҵ尡 ȣ��ǵ��� ����
	@RequestMapping(value = "/modify", method = RequestMethod.GET)
	public String modify(@RequestParam String userid, Model model, HttpSession session) throws UserinfoNotFoundException {
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
//		�����ڰ� �ƴϰ� �α��λ���ڰ� ���� �������ڰ� �ƴ� ���
//		���ͼ��� �̿� ���� 
		if(loginUserinfo.getStatus()!=9 && !loginUserinfo.getUserid().equals(userid)) {
			return "userinfo/user_error";
		}
		model.addAttribute("userinfo", userinfoService.getUserinfo(userid));
		return "userinfo/user_modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(@ModelAttribute Userinfo userinfo, HttpSession session) throws UserinfoNotFoundException {
		userinfoService.modifyUserinfo(userinfo);
//		�������� ����
		session.setAttribute("loginUserinfo", userinfo);
		return "redirect/userinfo/view?userid="+userinfo.getUserid();
	}
	
	@RequestMapping("/remove")
	public String remove(@RequestParam String userid, HttpSession session) throws UserinfoNotFoundException {
		userinfoService.removeUserinfo(userid);
		Userinfo loginUserinfo=(Userinfo)session.getAttribute("loginUserinfo");
		if(loginUserinfo.getUserid().equals(userid)) {
			return "redirect:/userinfo/logout";
		} else {
			return "redirect:/userinfo/list";
		}
			
	}
	
	
//	@ExceptionHandler 
//	 : Controller Ŭ������ ��ûó�� �޼ҵ忡�� ���ܰ� �߻��� ��� ���ܸ� ó���ϱ� ���� �޼ҵ带 �����ϱ� ���� ������̼�
//	    => ����ܸ� ó���� ������!!  value �Ӽ� : ���� Ŭ����(Clazz)�� �Ӽ������� ����
//	 ����ó�� ���� ������ ����ó�� �޼ҵ��� �Ű������� �����Ͽ� �����޾� ���
	@ExceptionHandler(UserinfoExistsException.class)
	public String execeptionHandelr(UserinfoExistsException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userinfo", exception.getUserinfo());
		return "userinfo/user_write";
	}
	
	@ExceptionHandler(LoginAuthFailException.class)
	public String execeptionHandelr(LoginAuthFailException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		model.addAttribute("userid", exception.getUserid());
		return "userinfo/user_login";
	}
	
	/*
//	Exeception�� ó���ϴ� ����ó�� �޼ҵ尡 ������ ��� ���� ����
	@ExceptionHandler(UserinfoNotFoundException.class)
	public String execeptionHandelr(UserinfoNotFoundException exception, Model model) {
		model.addAttribute("message", exception.getMessage());
		return "userinfo/user_error";
	}
	*/
	
	
	/*
	��� ��Ʈ�ѷ����� �߻��� �� �ִ� ���� �̹Ƿ� 
	 => ����ó�� ��Ʈ�ѷ��� ���� ���� ���
	@ExceptionHandler(Exception.class)
	public String execeptionHandelr(Exception exception) {
		exception.printStackTrace();
		return "userinfo/user_error";
	}
	*/

}















