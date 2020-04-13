package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RedirectController {
	@RequestMapping("/forward_print")
	public String forward(Model model) {
//		View���������� ��µ� ������ ���� - �⺻: Request Scope
		model.addAttribute("name", "���ٷ�");
		
//		View������(JSP)�� forward �̵�
//		 => Ŭ���̾�Ʈ �������� ��û URL �ּ� �̺��� => ???????????????????
//		 => Request Scope�� �����Ǵ� ���� ���
		return "redirect/forward_display";
	}

	/*
	@RequestMapping("/redirect_print")  //�ƴ� ��û URL�ٲ�����????????????
	public String redirect(Model model) {
		model.addAttribute("name", "�ٷ���");
		return "redirect/redirect_display";   //������ �̵� 
	}
	
	@RequestMapping("/redirect")
	public String redirect() {
//		FrontController���� redirect�� �̵�������~ ��û 
//		��ȯ�Ǵ� ViewName�� redirect ���λ�(NameSpace)�� ����ϸ� redirect �̵�
//		 => Ŭ���̾�Ʈ���� 301�ڵ�(���û)�� ��ûURL �����Ͽ� ���û ����
//		 => Ŭ���̾�Ʈ �������� ��û URL �ּ� ����
		return "redirect:/redirect_print";
	}
	*/
	
	
//	������� Request Scope�� ���ؼ� ������ ���޹����� �����̷�Ʈ�� �Ұ�
/*	
	@RequestMapping("/redirect_print")  
	public String redirect(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
//		��ûó�� �޼ҵ��� Request�� �ٸ��Ƿ� name���� ����Ȱ� ��� �Ұ�
//		�����̷�Ʈ �̵��Ǳ� ���� �����Ǵ� ���� ��� �Ұ���
		return "redirect/redirect_display";   
	}
	
//	Request Scope�� �����Ǵ� ����[���ڿ�(String�� ����)]�� �����̷�Ʈ �������� QueryString �������� ����
	@RequestMapping("/redirect")
	public String redirect2(Model model) {
		model.addAttribute("name", "���ٷ�");
		return "redirect:/redirect_print";
	}
*/
	
//	[���� �����̷�Ʈ �̵����]
	@RequestMapping("/redirect_print")  
	public String redirect() {
		return "redirect/redirect_display";   
	}	
	
	@RequestMapping("/redirect")
//	RedirectAttributes : �����̷�Ʈ �̵��� ���� ȣ��� ��ûó�� �޼ҵ��� View������(redirect_display)�� ������ �����ϱ� ���� ����� �ν��Ͻ�
//	RedirectAttributes.addFlashAttribute(String attributeName, Object attributeValue)
//	 : �����̷�Ʈ �̵��� View�������� ��ü�� �����ϴ� �޼ҵ� (���ڽ��� �ƴϰ� �ٸ������� �ٶ� ���)
	public String redirect2(RedirectAttributes attributes) {
		attributes.addFlashAttribute("name", "�ὺ");
		return "redirect:/redirect_print";
	}
}















