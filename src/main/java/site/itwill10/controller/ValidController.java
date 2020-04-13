package site.itwill10.controller;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Hewon;

@Controller
public class ValidController {
	
	@RequestMapping(value = "/valid_html", method = RequestMethod.GET )
	public String html() {
		return "valid/html_form";
	}
	
//	��ûó�� �޼ҵ� 
	@RequestMapping(value = "/valid_html", method = RequestMethod.POST)
//	�Է��±��� name �Ӽ��� = �ʵ��
	public String html(@ModelAttribute Hewon hewon, Model model) {
//		��û ó�� �� �Է°��� ���� ��ȿ�� �˻� 
		if(hewon.getId()==null || hewon.getId().equals("")) {
			model.addAttribute("idMsg", "���̵� �Է����Ҷ�!");
			return "valid/html_form";
		}
		String idReg="^[a-zA-Z]\\w{5,19}$";
		if(!Pattern.matches(idReg, hewon.getId())) {
			model.addAttribute("idMsg", "���̵� ���Ŀ� �°� �Է����췩??");
			return "valid/html_form";
		}
		return "valid/html_result";
	}

//		JavaBean �ʵ忡 ����Ǳ����� �ϳ��� ��ȿ�� �˻� ���� => Spring�� ��ȿ�� ������̼� ��� 
//	     : ���̺귯�� �߰� >> Spring���� �������ִ� ������̼��� Ȯ�����ִ� �ܺ� ���̺귯�� ����
//		   https://mvnrepository.com/ >> �ڹٿ��� �������ִ°�(Validation-api) & hibernate-validator(Ȯ����̺귯��)  
	
	@RequestMapping(value = "/valid_spring", method = RequestMethod.GET)
	public String spring(@ModelAttribute Hewon hewon) {
		return "valid/spring_form";
	}
	
//	@Valid : Spring From �±׿� ���� ���޵� ���� Command ��ü�� �ʵ忡 �����ϱ� �� �ʵ��� ��ȿ�� �˻����� Ȱ��ȭ ó���ϱ� ���� ������̼� 
//	          => JavaBean Ŭ������ �ʵ忡 ��ȿ�� �˻� ���� ������̼��� ��� <= � �ʵ带 ��� ��ȿ�� �˻��Ұ��� �˾ƾ� ��ȿ�� �˻縦 ������!!
//	Errors : ��ȿ�� �˻��� ����Ǵ� ��~~~~~~�� Error ������ �����ϱ� ���� �ν��Ͻ� / ������ �ݷ��� 
	@RequestMapping(value = "/valid_spring", method =RequestMethod.POST)
	public String spring(@ModelAttribute @Valid Hewon hewon, Errors errors) {
//		Errors.hasErrors() : Errors �ν��Ͻ��� Error������ ������ ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(errors.hasErrors()) {
			return "valid/spring_form";
		}
		return "valid/spring_result";
	}
	
	
//	��û ó���޼ҵ尡 �ɼ�����~ ������??
//	�޼ҵ��� ��ȯ���� ��� ViewPage�� ��ȯ�ϴ� ����� ����
//	�޼ҵ� ��ȯ���� ��� ��ûó�� �޼ҵ��� View�������� ����
	@ModelAttribute("genderList")
	public List<String> genderList() {
//		Arrays : �迭�� ���� Ŭ����, 
		return Arrays.asList("����","����","�󳪿�");
	}

}
























