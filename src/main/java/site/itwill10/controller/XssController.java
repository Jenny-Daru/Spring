package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lyncode.jtwig.functions.util.HtmlUtils;

@Controller
public class XssController {
	@RequestMapping(value = "/xss", method = RequestMethod.GET)
	public String xss() {
		return  "xss/input";
	}
	
//	XSS : �Է��±׿� ���������� �ڵ带 �Է��Ͽ� ���α׷��� �����ϴ� ���
//		   => �ݵ�� XSS ���ݿ� ���� �� ���� �����ڵ� �ʿ��
//	   	  [���1] ������ ��!! View���������� ó�� : �±װ��� ���ڸ� Escape ���ڷ� ��ȯ
//				  => Core �±� ���̺귯���� out�±� �̿�  	
//				  => Functions �±� ���̺귯���� escapeXML() EL �Լ��� ��� 
//				  �ڹ����� : ���� �����̾ȵǾ� <br>�±׸� ����Ͽ��� �±װ� ������ �ȵʡ�
	
//		  [���2] ��ûó�� �޼ҵ忡�� ó�� : �±װ��� ���ڸ� Escape ���ڷ� ��ȯ => �����������մϴ٢�����
//				  => Spring���� �����ϴ� HtmlUtils Ŭ������ htmlEscape() �޼ҵ� ȣ��
	@RequestMapping(value = "/xss", method = RequestMethod.POST)
	public String xss(@RequestParam String subject, @RequestParam String content, Model model) {
		/*
		model.addAttribute("subject", subject);
//		���뿡 ���͸� ����ϸ� ������ǹǷ� replace�� ����Ͽ� �����ϱ�
		model.addAttribute("content", content.replace("\n", "<br>"));
		*/
		
//		[�⺻���� ���]
		/*
		model.addAttribute("subject", HtmlUtils.htmlEscape(subject));
		model.addAttribute("content", HtmlUtils.htmlEscape(content).replace("\n", "<br>"));
		*/
		
//		[�ƿ��±׸� ���ִ� ��� => pom.xml�� ���̺귯�� ���� ���� => ���̺� �������丮������ Jtwig-core]
//		 => ���������� �±װ��� ��ȣ�鵵 ������������ ���õ� ���ڵ鵵 ���� �������� ���� �߻� - �����
		model.addAttribute("subject", HtmlUtils.stripTags(subject));
		model.addAttribute("content", HtmlUtils.stripTags(content).replace("\n", "<br>"));
		
		return  "xss/output";
	}

}











