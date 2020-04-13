package site.itwill10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import site.itwill10.dto.Student;
import site.itwill10.service.StudentService;

//Controller Ŭ���� : Ŭ���̾�Ʈ�� ��û�� �޾� ��ServiceŬ������ �޼ҵ带 ȣ����Ͽ� ��û ó�� �� ViewName�� ��ȯ�Ͽ� JSP ������ ����ó�� �ϴ� �޼ҵ尡 ����� Ŭ����
//					   => Service Ŭ������ �޼ҵ带 ȣ���Ͽ� Ŭ���̾�Ʈ�� ��û ó�� (�̰��� �ٽ� �ڵ�) �Ҷ�� @Controller ������̼� ����
//@Controller : Controller ���� Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
@Controller
//��Ʈ�ѷ� Ŭ������ @RequestMapping ������̼��� ����Ͽ� ��� ��ûó���޼ҵ忡 ���������� �պκп� ���ԵǾ� ����Ǵ� URL �ּҸ� ���� 
@RequestMapping("/student")
public class StudentController {
//	Service Ŭ���� ���� Spring Bean�� ������ ó���Ͽ� �ʵ忡 ����
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String add() {
		return "student/add_student";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(@ModelAttribute Student student, Model model) {
		try {
//			����� ����� ������� ���� �� ������ ���� �߻� ���ɼ� ���� 
			studentService.addstudent(student);
		} catch (Exception e) {
			model.addAttribute("message", "�̹� ������� �й�������~");
			return "student/add_student";
		}
		return "redirect:/student/display";
	}
	@RequestMapping("/display")
	public String display(Model model) {
		model.addAttribute("studentList", studentService.getStudentList());
		return "student/display_student";
	}
}



















