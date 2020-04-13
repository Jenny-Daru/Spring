package site.itwill10.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ModelController {
	
	@RequestMapping("/display1")
	public String display1(Model model) {
		model.addAttribute("name", "���ٷ�");
//		�Ű������� Date Ŭ���� ����Ͽ��� ��� ��� NO
//		model.addAttribute("now", date);
/*		
		model.addAttribute("now",new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
*/		
		return "model_display1";
	}
	
	
	@RequestMapping("/display2")
	public String display2(Model model) {
		model.addAttribute("name", "������");
/*		
		model.addAttribute("now",new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
*/		
		return "model_display2";
	}
	
	
	@RequestMapping("/display3")
	public String display3(Model model) {
		model.addAttribute("name", "�ὺ");
/*		
		model.addAttribute("now",new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date()));
*/		
		return "model_display3";
	}

	
//	��¥�� �ð������� ����� �ڵ� ��� �ݺ�!
//	����� �ڵ尡 �ݺ��ǰ� �޼ҵ忡 ���� ������� ��ȯ�� ��� ����ϴ� => ������̼� ��� : @ModelAttribute
//	@ModelAttribute : �޼ҵ忡 ����� ��� ���� ��Ʈ�ѷ��� ����� ��� View�������� �޼ҵ��� ��ȯ���� �����Ͽ� �����ϱ� ���� ������̼�
//	  				  ��value(name)�Ӽ� : View�������� ����ϱ� ���� �������� �Ӽ������� ���� 
	@ModelAttribute("now")
	public String getNow() {
		return new SimpleDateFormat("yyyy�� MM�� dd�� HH�� mm�� ss��").format(new Date());
	}
	
	
}




















