package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import site.itwill10.dto.Hewon;

@Controller
//@SessionAttributes : ��Ʈ�ѷ��� ��ûó�� �޼ҵ忡�� �����ϴ� ���� ��� ��ûó�� �޼ҵ��� ������������ ����� �� �ֵ��� �����ϴ� ������̼�
//						=> View�������� ���� ������ �� Request Scope�� �ƴ� Session Scope�� ��� >> �ش� ��Ʈ�ѷ������� ��밡��
//						=> Session Scope�� ��������� ���ؽ�Ʈ ��ü�� �ƴ� ��Ʈ�ѷ��� �ڿ��� ��� ���� (�޼ҵ�� JSP �Ѵ� ����)
//						=> ���� ó���� �ٸ� ��ûó�� �޼ҵ忡�� �ʿ��� ������ �����ϰų� �˻��ϴ� �۾��� ����
//						=> ���� �ش� ��û�޼ҵ��� view������������ ���������� �� ������̼� ����ϸ� ��~~ ��밡��
//						value�Ӽ� : Session Scope�� �����Ǳ� ���� �Ӽ����� �Ӽ������� ����
@SessionAttributes(value = "hewon")
public class SessionController {
//	���̵� ���޹޾� ȸ�������� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	private Hewon getHewon(String id) {
		Hewon hewon=new Hewon();
		hewon.setId(id);
		hewon.setPw("123456");
		hewon.setName("��ٷ�");
		hewon.setEmail("daru@daru.com");
		hewon.setGender("����");
		return hewon;
	}
	
//	���̵� ���޹޾� �ش� ���̵��� ȸ�������� view�������� �����ϴ� ��ûó�� �޼ҵ� - serviceŬ������ �޼ҵ�� �����ϰ� �� �ϱ�
//	 => ��ȯ���� ȸ�������� View�������� �Ϲ��±׸� �̿��Ͽ� ���
	@RequestMapping(value = "/hewon_view")
	public String hewonView(Model model) {
//		ȸ�������� �˻��Ͽ� ��ȯ�޾� ���� - service Ŭ������ �޼ҵ� ȣ���ؾ߉� ������!
		Hewon hewon=getHewon("Daru123");
		
//		Model ��ü�� �̿��Ͽ� View���������� ���� ���� - Request Scope
//		Mode.addAttribute(Object attributeValue) 
//		 : view�������� �����Ǵ� �Ӽ����� ������ ��� �����Ǵ� ���� �ڷ����� �Ӽ������� �ڵ� ����, attributeName����
//		   => �⺻��(Wrapper) �Ǵ� ���ڿ�(String)�� �ڷ������� ����
//		@SessionAttribute ������̼ǿ� ���� Session scope�� ����
		model.addAttribute(hewon);
//		model.addAttribute("hewon",hewon);
		return "session/hewon_view";
	}
	
	/*
//	���̵� ���޹޾� �ش� ���̵��� ȸ�������� view�������� �����ϴ� ��ûó�� �޼ҵ� - serviceŬ������ �޼ҵ�� �����ϰ� �� �ϱ�
//	 => ��ȯ���� ȸ�������� View�������� �Է��±׿� ���
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate(@RequestParam String id, Model model) {
		Hewon hewon=getHewon(id);
		model.addAttribute(hewon);
		return "session/hewon_update";
	}
	 */
	
	
//	@SessionAttributes������̼��� ����Ͽ� Session Scope�� ���� ȸ�������� �����ǹǷ� ���̵� �̿��� ȸ������ �˻� ��� ���ʿ�
	@RequestMapping(value = "/hewon_update", method = RequestMethod.GET)
	public String hewonUpdate() {
		return "session/hewon_update";
	}
	
	
//	������ ȸ�������� ���޹޾� ȸ�������� �����ϴ� ��ûó�� �޼ҵ�
//	 => Session Scope�� �����Ǵ� ȸ�������� Command��ü�� �ʵ忡 �ڵ����� �� �Է°��� �����޾� Command ��ü�� �ʵ忡 ���� 
//	      >> ���� �����ϰ��� �ϴ°��� ���氡��
	@RequestMapping(value = "/hewon_update", method = RequestMethod.POST)
//	SessionStatus : @SessionAttribute ������̼ǿ� ���� �����Ǵ� ���� ���������� �����޾� �����ϴ� �ν��Ͻ�
	public String hewonUpdate(@ModelAttribute Hewon hewon, SessionStatus status) {
//		�Է°��� ���޵��� �ʾƵ� Session Scope�� ������ ȸ������ ���
		System.out.println("���̵� ="+hewon.getId());
//		SessionStatus.setComplete() : @SessionAttribute ������̼ǿ� ���� �����Ǵ� ���� �����ϴ� �޼ҵ�
//										���̻� �Ⱦ���~~ �˷���°� session�� remove������
		status.setComplete();
		return "session/hewon_view";
	}

}













