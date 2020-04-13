package site.itwill10.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.itwill10.dto.RestMemberJSON;
import site.itwill10.dto.RestMemberListXML;
import site.itwill10.dto.RestMemberXML;
import site.itwill10.service.RestMemberService;

//Spring 3.0 ����   MVC ��� ��ȭ 
//Spring 4.0 ����  Rest ��� ��ȭ  => ������̼� �� ������ 
//Spring 5.0 ���� cloud ��� �߰�

//Rest(Representational State Transfer) ����� �����ϴ� ��Ʈ�ѷ� 
// => �ϳ��� ��û URL �ڿ��� �ϳ��� ���ҽ��� ��ǥ�ϵ��� ���� 
// => ���� : �پ��� ��⿡�� ��û�� ���� �������� ���������� ó���� �� �ִ� ������ �ؽ�Ʈ �����͸� �����ϴ� ��
//           ���������� ó���� �� �ִ� ������ �ؽ�Ʈ ������ >> JSON �Ǵ� XML(��뷮)
// => ������Ʈ ������ Ajax ������� ��û�Ͽ� �������� �����޾� DHTML�� ���� 
@Controller
public class RestFulController {
	
	@Autowired
	private RestMemberService restMemberService;
/*	
//	[ �Ϲ������� ���α׷��� ����� ��� ]
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String rest() {
		return "rest/input";
	}
	
//	�Է°��� ���޹޾� ���� => �Ű����� �̿�
//	Model�� �̿��Ͽ� ���������� �Ӽ����� ���� 
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public String rest(@RequestParam String id, @RequestParam String name, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("name", name);
		return "rest/output";
	}
	
*/	
//	�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�[�� �߿�]�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
//	[ JSP�� ������ �ʰ� ���������� ��û�� ���� ������ ���ִ� ��� ]
	@RequestMapping(value = "/rest", method = RequestMethod.GET)
	public String rest() {
		return "rest/input";
	}
/*	
//  [ 1) @ResponseBody������̼� ��� ]
//	Ŭ���̾�Ʈ�� REST������� POST ��û�ߴٸ� JSP�� �����ϸ� �ȵ�!!
//	@ResponseBody : ��ȯ����� ViewResolver���� �������� �ʰ� ��ûó�� �޼ҵ忡�� ���� ���� ó�� �ϵ��� �����ϴ� ������̼� 
//					 => ��ûó�� �޼ҵ��� ��ȯ���� ViewName�� �ƴ� Ŭ���̾�Ʈ���� �����ϴ� ���(XML �Ǵ� JSON)�� ���
//	 @RequestBody : �ڿ��� ���� ��û�� POST, PUT, DELETE ���� ��û�� ���� ���޵� ��� �Է°��� JSON ������ �ؽ�Ʈ ������(JavaScript ��ü)�� ���޹޾� �����ϱ� ���� ������̼�
//					 => ��, GET ������� ��û�Ͽ� ���޵� ������ ���� �Ұ���
//	 				 => Ajax ��û�� ���� ���޵� �Է°��� �����ϱ� ���� ��� , ��� ������� ��°�� �����ͼ� ���
//	�����ϸ� �����ڵ�� ��ȯ��� ����.
	 => @RequestBody�� ����Ͽ� JavaScript ��ü�� �Է°����� ���޹��� 
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	@ResponseBody
	public String rest(@RequestBody String input) {
		return input;
	}	
 */ 

//	�������� ���ڿ��� �޾� �׳� ����ϸ� �Ǵϱ� ���� �ȳ�
	@RequestMapping(value = "/rest", method = RequestMethod.POST)
	public @ResponseBody String rest(@RequestBody String input) {
		return input;
	}

	//	[ 2) @ResponseBody�� ��ġ�� ��ȯ�� �տ� ���� ����(�����) - XML�� �����ϴ� ��ûó�� �޼ҵ� ]
//	 Ŭ���̾�Ʈ ��û�� ���� ȸ�������� XML �ؽ�Ʈ �����ͷ� �����ϴ� ��ûó�� �޼ҵ� 
//	  => String�� �ƴ� ��ü�� ������ ��� 500���� �߻� => ����ü �������� ��� �޾Ƽ� ������� ���� XML�� ��ȯ�Ͽ� ��ȯ�ϴ� ���α׷� �ʿ� 
//	     Java��ü�� XML �Ǵ� JSON ������ �ؽ�Ʈ ������(String)�� �ڵ� ��ȯ�Ͽ� ����ǵ��� ���� >> ���� Ŭ���̾�Ʈ���� �����ϱ� ���� �߰��� String���� ���� Ŭ���̾�Ʈ���� ����
//		 ��1) XMLBinder ���α׷� �ʿ�(JDK���ο� �̹� ����-���̺귯�� �ʿ���� �ִ°� ���), JDK1.9�������� �������� => XMLBinder ã�Ƽ� �����Ͽ� ��� 	
//	     2) JSONBinder ���α׷� �ʿ�(������ - ���̺귯�� �����Ͽ� ���) 
	
//	@ResponseBody�� ����Ͽ� Ŭ���̾�Ʈ���� RestMemberXML�� �������ٰԿ�.

//	 �̰��� ����!!! String���� ��ȯ�ϴϱ�~~~~~
	/*
	@RequestMapping("/Xml_member")
	@ResponseBody
	public String restMemberXML() {
		return restMemberService.getRestMemberListXML().get(0).getId();
	}
	*/
	
//	[ Java ��ü�� XML ������ ���ڿ��� �����ϴ� �޼ҵ� ]
//	 => [���� ���1)]��ȯ�Ǵ� Ŭ���� �ڷ������� JAXB(Java Architecture form XML Binding) ��� �̿��Ͽ� ��ȯó�� => RestMemberXML.java ���!!
	@RequestMapping("/Xml_member")
	@ResponseBody
	public RestMemberXML restMemberXML() {
//		ȸ������ ������ִٸ� ���߿� 0��° ����� RestMemberXML�� ��ü(ȸ������)�� ��ȯ���ٰԿ�!
//		 => �������� ���ڿ��� �ƴ� Java��ü(RestMemberXML�� ��ü,�迭)�� �޾Ƽ� ����ؾ� �ϴϱ� �νĸ��� 500���� 
//		 => Spring���� ��ȯ�����ִ� ��ȯ���α׷��� �����Ƿ� ���� �߻� 
		return restMemberService.getRestMemberListXML().get(0);
	}
	/*
//	ȸ������� ��ȯ�ϴ� �޼ҵ�
//	 => ����� ��ȯ���ִ� Java��ü�� ����.
	@RequestMapping("/Xml_list")
	@ResponseBody
	public List<RestMemberXML> restMemberListXML() {
		return restMemberService.getRestMemberListXML();
	}	
	*/
	
//	�ذ� ��� 1) ȸ�������� �����ϴ� List�ʵ尡 ����� Ŭ���� �ʿ�
//	Ŭ���̾�Ʈ ��û�� ���� ȸ�������� XML�ؽ�Ʈ �����ͷ� �����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping("/Xml_list")
	@ResponseBody
	public RestMemberListXML restMemberListXML() {
//		
		RestMemberListXML listXML=new RestMemberListXML();
		listXML.setRestMemberList(restMemberService.getRestMemberListXML());
		return listXML;
	}	
	
//	@ResponseBody�� ������� ���� => JSP�� ����(display_xml.jsp)
//	ȸ������� AJAX ������� ��û�Ͽ� ����ó���ϴ� �޼ҵ�
	@RequestMapping("/xml_print")
	public String displayXML() {
		return "rest/display_xml";
	}
	
//**************************************************  JSON���  ************************************************************
//	[ Java ��ü�� JSON ������ ���ڿ��� �����ϴ� �޼ҵ� ]	
//	�ذ� ��� 2) Java��ü�� JSON���� ���� �� ���� 
//	Ŭ���̾�Ʈ ��û�� ���� ȸ�������� JSON �ؽ�Ʈ �����ͷ� �����ϴ� ��ûó�� �޼ҵ�
//	 �����߻� => JSON �ؽ�Ʈ �����ͷ� �������ִ� ���̺귯�� �ʿ� => maven�̿� => pom.xml
//			  => jackson-databind ����� �̿��Ͽ� Java ��ü�� JSON ������ ���ڿ��� �ڵ���ȯ�Ͽ� ����ó�� 
//	  		  => Maven�� �̿��Ͽ� jackson-databind ���̺귯�� ���� ó��
//			  => ���̺귯���� �����Ͽ� �����ϸ� ������! ��������~~
	@RequestMapping("/json_member")
	@ResponseBody
	public RestMemberJSON restMemberJSON() {
		return restMemberService.getRestMemberListJSON().get(0);
	}	
	
//	Ŭ���̾�Ʈ ��û�� ���� ȸ�������� JSON �ؽ�Ʈ �����ͷ� �����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping("/json_list")
	@ResponseBody
	public List<RestMemberJSON> restMemberListJSON() {
		return restMemberService.getRestMemberListJSON();
	}	
	
//	ȸ������� AJAX ������� ��û�Ͽ� JSON���� ����޾� ����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping("/json_print")
	public String displayJSON() {
		return "rest/display_json";
	}	
	
	
//	************************************ JSON�� ���� : dto �������� �ʰ� �ϴ� ��� ************************************
	@RequestMapping(value = "/json_map", method = RequestMethod.GET)
	public String input() {
		return "rest/input";
	}
	
//	��� �Է°��� Map��ü�� ��Ʈ���� ����޾� ����ó�� (�Է��±��� name �Ӽ� : key, �Է��±��� �Է°� : value)
//	 => Map��ü(JavaScript��ü)�� ��ȯ�ϸ� jackson-databind ����� �̿��Ͽ� JSON Ÿ���� ���ڿ��� ����
//	 => JavaBean(DTO)Ŭ������ ���� ��� Map ��ü�� �̿��Ͽ� ����ó�� 
	@RequestMapping(value = "/json_map", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> input(@RequestParam Map<String, String> map) {
		return map;
	}
	
//	ResponseEntity : ��û�� ���� ������ ��ûó�� �޼ҵ忡�� ���� �����ϱ� ���� Ŭ����
//					 => @ResponseBody ������̼� ������ �����ϴ� Ŭ����
//					 => ���׸��� ���� ��ü�� �ڷ����� ����
//	������������ ���� ���� ResponseEntity�� �������ٰ�~~ �Ҷ� ���
	@RequestMapping(value = "/member_list")
	public ResponseEntity<List<RestMemberJSON>> restMemberList() {
		ResponseEntity<List<RestMemberJSON>> entity=null;
		try {
//			ResponseEntity ��ü ������ ��û�� ���� �������� �����ڵ� ����
			entity=new ResponseEntity<List<RestMemberJSON>>(restMemberService.getRestMemberListJSON(),HttpStatus.OK);
		} catch (Exception e) {
//			ResponseEntity ��ü ������ ��û�� ���� ����[����]�ڵ� ����
			entity=new ResponseEntity<List<RestMemberJSON>>(HttpStatus.BAD_REQUEST);
		}
		return entity;
	}
	
//	************************************************************************
	
	@RequestMapping("/handlebars")
	public String handlebars() {
		return "rest/handlebars";
	}
	
	
	
	
	
	
}






















