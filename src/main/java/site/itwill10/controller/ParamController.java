package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParamController {
	@RequestMapping(value = "/param", method = RequestMethod.GET)
	public String form() {
		return "param_form";
	}
	
/*	
//  Ŭ���̾�Ʈ�� ��� ������ ����ִµ� ���� �ʿ��Ѱ͸� �������� ���� => �Ű����� ���
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
		
		return "param_display";
	}
*/	
	
//	�Ű������� �����ϸ� ���ް��� �ڵ����� �����޾� ���� >> �˾Ƽ� �������� �ʰ� ��Ģ�� ����
//	 => ���Է��±��� name �Ӽ����� �Ű������� �̸��� ���� ��� ����� Front Controller�� Container���ؼ� �˾Ƽ� ���� 
//	      ����1) �Է��±��� name �Ӽ����� �Ű������� �̸��� �ٸ� ��� �Ű������� Null���� 
//		  ����2) �Է°��� ���� ĳ���ͼ� ���� �Ұ��� - �ѱ� �Է� �Ұ��� 
//	   			  => ���ڵ� ���͸� ����Ͽ� �Է°��� �����޾� �����ϱ� ���� ĳ���ͼ� ���� >> web.xml ���Ͽ��� ����
//	 	request�� Ư���� ��츸 ��� WHY??? ��������� �� ������ �����ϱ� ~ ~ ~ �ʿ���°� �����ϰ���� 
/*	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
*/
	
	
//	4/3 �߰� ��� 
//	@RequestParam : �Է°��� ���޹޾� �����ϱ� ���� �Ű������� �����ϴ� ������̼� �ڱ����
//	�Է��±׿��� �Է¹��� name�Ӽ����� ���޹޾� �����ϴ� �Ű��������� �ٸ��� ������ ��� => Error���� null���� ����
//	 but, @RequestParam ������̼��� ����� ��� 400���� (�߸��ȿ�û)
//	 => �Է°��� �ݵ�� �Ű������� ���޹޾� �����ϱ� ���� ����ϴ� ������̼�
/*	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
*/

//	����, form�±׿��� name�Ӽ����� ���޹޴� �Ű��������� �ٸ���� 400������ �߻�
//	 => RequestParam �Ӽ����� ���
//	@RequestParam ������̼��� �Ӽ��� �̿��Ͽ� �Է°��� ���� ���� ����
//	              value �Ӽ� : �Է��±��� ������(name�Ӽ���)�� �Ӽ������� ����
//								=> �Է��±��� name�Ӽ����� �Ű������� �̸��� �ٸ� ��� ��� 
//								=> �Է��±��� name�Ӽ����� �����Ͽ� �Է°��� �Ű������� ���� ����
/*	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam("username") String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
*/
	
//	@RequestParam �� required �Ӽ� : false �Ǵ� true�� �Ӽ������� ����
//								     false(�ʼ�) => name�Ӽ����� �Ű������� �̸��� �����ʾƵ� 400�����ڵ� �̹߻� => �̰Ż���ҹٿ��� �� ��!! �� �����ʴ°� ����
//													ex) �Խ��ǿ��� pageNum�� �˻�Ű���带 ���޹�����, �˻�Ű���带 �ȹ��� ��쵵 �������� �׷��� ���
//									        true => name�Ӽ����� �Ű������� �̸��� �������� ��� 400�����ڵ� �߻�
/*	
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(required = false) String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}
*/
	
//	@RequestParam �� defaultValue �Ӽ� : �Ű������� ����� �⺻���� �Ӽ������� ����
//										  => �Ű������� �Է°��� ������� ���� ��� �ڵ� ����Ǵ� �� ����
//											 1.�Է��±׿��� ���� �Է����� �ʾ��� ��� 
//											 2.400���� �̹߻� �ϱ� ���� name�Ӽ����� �Ű������� �̸��� �������� ��쿡 ��� 
//											 ex) pageNum�� �����ؾ��ϴµ� �ȳѾ�� ��� �����߻��ϴµ� �⺻������ 1�� ������ ��� �����߻����� ����
//	�Է°��� ����   => �Է°��� ���
//			 ������ => �⺻���� ���
	@RequestMapping(value = "/param", method = RequestMethod.POST)
	public String form(@RequestParam(value = "username", defaultValue = "����ٷ�") String name, Model model) {
		model.addAttribute("name", name);
		return "param_display";
	}	
}















