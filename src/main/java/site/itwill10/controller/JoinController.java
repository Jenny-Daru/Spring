package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Member;

//�Է°��� ���޹޾� join_display.jsp���� ��� 
@Controller
public class JoinController {
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join() {
		return "join_form";
	}
	
//	����ϱ� ���ؼ��� ��ûó�� �޼ҵ忡���� �Է°��� ���޹޾� ViewPage���� ���� 
//	�Է��±��� name�Ӽ����� �Ű������� �̸��� �ٸ��� ���� => 400�����ڵ� �̹߻�
//	�Ű����� �������� ��� �Է°�(���ް�)����, ��ü���� �Ǵ��ϱ� ����
/*	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(String id, String passwd, String name, String email, String phone1, String phone2, String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_display";
	}
*/
	
	
//	�� �Է°��� ���޹޾� ���� => �Ű����� : @RequestParam ������̼� �����ϴ� �� ���� ��
//	�Է��±��� name�Ӽ����� �Ű������� �̸��� �ٸ� ��� 400���� �߻� 
//	�Ӽ��� ���� �پ��� ������ �����ϴ� �Ⱦ��°� ���ٴ� ���°� ������
/*	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@RequestParam String id, @RequestParam String passwd, @RequestParam String name, @RequestParam String email,
			              @RequestParam String phone1, @RequestParam String phone2, @RequestParam String phone3, Model model) {
		model.addAttribute("id", id);
		model.addAttribute("passwd", passwd);
		model.addAttribute("name", name);
		model.addAttribute("email", email);
		model.addAttribute("phone1", phone1);
		model.addAttribute("phone2", phone2);
		model.addAttribute("phone3", phone3);
		return "join_display";
	}
*/
	
//	@ModelAttribute : ViewPage���� ��°��� �����ϴ� ������̼� => �������޼ҵ��� ��ȯ�� �Ǵ� �Է°� ���������� 
//	�Է°��� ���޹޾� ���޹޾� �����ϴ� �Ű����� => @ModelAttribute ���� : �Է°��� ViewPage�� �ڵ����� ����
//	 => Model�� �ʿ���� model.addAttribute�� �ʿ���� >> ������ �ȶ��������� ���� ������ �ȵ�!!!
//	 => @ModelAttribute ������̼� value �Ӽ� : ����Ӽ����� �Ӽ������� ���� - �ٸ� �Ӽ�X  >>  �Ӽ����� ���� ����
	// 											�Է��±��� name �Ӽ����� ������ �̸����� �����ؾ߸� �Ű������� �Է°� ����
	//  										�Է��±��� name �Ӽ��� value �Ӽ����� �ٸ� ��� �Ű������� �Է°� ������
//	                                             value�Ӽ� ���� - �Ű������� �ڷ����� �ڵ����� �Ӽ������� ���� - ù���ڴ� �ҹ��ڷ� ����Ǿ� ����
//																  �Ű������� �ڷ��� �⺻��(Wrapper), String  >> �Ӽ��� ������ ��� ViewPage���� ������
//	�Է��±��� name�Ӽ����� @ModelAttribute ������̼��� value �Ӽ����� �ٸ� ��� 
/*	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("id") String id, @ModelAttribute("passwd") String passwd, @ModelAttribute("name") String name, @ModelAttribute("email") String email,
							@ModelAttribute("phone1") String phone1, @ModelAttribute("phone2") String phone2, @ModelAttribute("phone3") String phone3) {
		return "join_display";
	}
*/
	
//	�Է°��� �ʹ����� ����~~�ذ� ���
//	[ �Է°��� ���޹޴� �Ű������� ���� ��� >> Map�� �̿��Ͽ� ���� �������� + @RequestParam ]
//	�Ű������� �ڷ��� => Map ���� : �Է°��� Map�� ��Ʈ��(Key�� Value)�� �ڵ� ���� 
//	 				  => �Է��±�  name �Ӽ��� : MapKey
//										�Է°� : MapValue
//	Map �Ű������� �Է°��� ����Ǳ� ���ؼ��� �ݵ�� @RequestParam ������̼� ���� 
//	 => ����, @RequestParam ������̼� ���� >> �Ű������� ��(Empty) Map��ü�� ���� 
//	�Է°��� Map�� ����Ǳ� ���ؼ��� ������̼� ���������������� ����ؾ��Ѵ�!!! @RequestParam => �Է°��� �Ű������� �������꼼��
/*	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
//	Map�� ���´� String�� Ojbect������ ~~ ������ ���� String���� �����ðŴϱ�!! String �ᵵ��
	public String join(@RequestParam Map<String, String> memberMap, Model model) {
		model.addAttribute("map",memberMap);
		return "join_display";
	}
*/
	
//	[ �Է°��� ���޹޾� DB ���� ]
//	��� DB������ ������ DTO�� ���� �̿���~ �̰��� ���帹�� ��� 
//  Model�� ��� @ModelAttribute�� �Է°��� �����ٰ� ViewPage���� ���� 
	
//	�Ű������� �ڷ����� JavaBean���� ������ ��� �Է°���  JavaBean��ü�� �ʵ忡 �ڵ�����
//	 => ��, JavaBeanŬ������ �ʵ�� = �Է��±��� name�Ӽ���
//	JavaBean �Ű����� : @ModelAttribute ������̼� ����
//	 => @ModelAttribute ������ ���� 
//	 => value �Ӽ��� �̿��Ͽ� ViewPage�� �����Ǵ� �Ӽ��� �������� >> value �Ӽ� : ���� >> Ŭ�������� �ڵ����� �Ӽ������� ����
//	Command ��ü : �Է°��� �����Ͽ� View�������� �����ϴ� ��ü 
/*	
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute Member member) {
		member.setId("id");
		member.setId("passwd");
		member.setId("name");
		member.setId("email");
		member.setId("phone1");
		member.setId("phone2");
		member.setId("phone3");
		return "join_display";
	}	
*/
	
//	@RequestMapping�� �Ӽ����� ����ϴ� ��� 
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String join(@ModelAttribute("mem") Member member, Model model) {
//		�Է¿� ���� ��ȿ�� �˻� => form�±� ������� �ʰ�, Spring���� �������ִ� �±׻�� 
		if(member.getId().equals("Daru")) {
			model.addAttribute("message", "�ߵ�!!!�̹� ���O�� ���̵�����~");
			return "join_form";
		}
		return "join_display";
	}		
	
	

}
















