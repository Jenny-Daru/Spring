package site.itwill10.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MethodController {
//	�Է��������� ���� ��ûó�� �޼ҵ�
	@RequestMapping("/method_input")
	public String inputOne() {
		return "method_input1";
	}
	
//	����������� ���� ��ûó�� �޼ҵ�
//	 => �Է°��� ���޹޾� View���������� ��µǵ��� ����
//	    �Է°��� �����;�¡ request ���
	@RequestMapping("/method_output")
	public String outputOne(HttpServletRequest request) throws UnsupportedEncodingException {
//		������������ �ѱ��Է� ����� �ް� ����, UTF-8 >> ����ó�� >> ���ѱ��
//		HttpServletRequest.setCharacterEncoding(String encoding) : �Է°��� ���� ĳ���ͼ��� �����ϴ� �޼ҵ� 
//																    UnsupportedEncodingException �߻� >> ���Ѱ�
		request.setCharacterEncoding("UTF-8");
		
//		�Է°� ���޹޾� ���� 
		String name=request.getParameter("name");
		
//		request�̿��Ͽ� ����
		request.setAttribute("name", name);
		
		return "method_output1";
	}
	
	
//	[�ڡڡڿ�û�ϴ� URL �ּҰ� ���� ��� - ��û��ĸ� �ٸ��� �����ڡڡ�]
	
//	�Է��������� ���� ��ûó�� �޼ҵ�
//	method �Ӽ� : ��û����� �Ӽ������� ���� 
//				   => Ŭ���̾�Ʈ ��û��Ŀ� ���� ��ûó�� �޼ҵ� ȣ��
//	������ : RequestMethod(Enum �ڷ���-����ʵ常 ������ ����)�� ����ʵ带 ����Ͽ� �Ӽ������� ����
//	Ŭ���̾�Ʈ�� �޼ҵ�ȣ�� �Ӹ��ƴ϶� GET������� ��û������ ����
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public String inputTwo() {
		return "method_input2";
	}

	
//	����������� ���� ��ûó�� �޼ҵ�
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String outputTwo(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		request.setAttribute("name", name);
//		�Է°��� �߸� �������� ��� method_input2�� �����̷�Ʈ �̵� , ����ó�� ���� �� 
		if(name==null || name.equals("")) {
			request.setAttribute("message", "�̸��� �Է����췡�����������?????");
			return "method_input2";
		}
		return "method_output2";
	}
}







