package site.itwill10.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//ModelAndView = ó����� + ViewName

//[ ��ûó�� �޼ҵ忡�� View������(JSP)���� ����� �� �ֵ��� ó������� �����ϴ� ��� ] 
// 1. ModelAndView �ν��Ͻ�(��ü)�� �̿��Ͽ� ó������� ���� => ��ȯ�� : ModelAndView 
// 2. HttpServletRequest �ν��Ͻ�(��ü)�� �̿��Ͽ� ó������� ���� => ��ȯ�� : String(ViewName)
// 3. Model �ν��Ͻ�(��ü)�� �̿��Ͽ� ó������� ���� => ��ȯ�� : String(ViewName)
// 4. ModelMap �ν��Ͻ�(��ü)�� �̿��Ͽ� ó������� ���� => ��ȯ�� : String(ViewName)
@Controller
public class ResultController {
	/*
	@RequestMapping("/resultMAV")
//	ModelAndView : ��ûó���� ���� ������� ViewName�� �����ϱ� ���� Ŭ���� 
//					=> request�� �����ؼ� JSP �������� ������ ���
	public ModelAndView modelAndView() {
		ModelAndView modelAndView=new ModelAndView("result_display");
		
//		ModelAndView.addObject(String attributeName, Object attributeValue)
//		 : ViewPage���� ���ǵ��� �������� �߰��ϴ� �޼ҵ� , �⺻ : Request Scope
//		   �Ӽ��� �̿��Ͽ� ���� �߰�
		modelAndView.addObject("Daru", "��ٷ�");
		
		return modelAndView;
	}
	*/
	
	
//	��ûó�� �޼ҵ�� Front Controller�� ���� �ڵ� ȣ��
//	��ûó�� �޼ҵ忡 �Ű������� �����Ͽ� Spring Container�κ��� �ν��Ͻ��� �����޾� �ڵ����� �Ű������� �����Ͽ� ����(������ ������ ������ �شٿ�)
//	 => �Ű������� �� �̰��ʿ��ؿ�~ ��û�ϸ� �ִ°�!! ������ �� �ִ°͵鸸 �ִ°��Դϴ�, �ʿ��� �������� �������޵� ����µ� ������ �ٲٰ� ������ setter�� �����ؼ� �����
	@RequestMapping("/resultMAV")
	public ModelAndView modelAndViewResult(ModelAndView modelAndView) {
//		setter ��� ����
//		 => �Ű������� ���޵� �ν��Ͻ����� �ʱ⿡ ���� �������� ���� ������ setter�޼ҵ� ȣ���Ͽ� �����ؾ��� 
		modelAndView.setViewName("result_display");
		modelAndView.addObject("Daru", "��ٷ�����");
		return modelAndView;
	}
	
	
	
	@RequestMapping("/resultRequest")
//	ViewName�� ��ȯ�ϴ� ���� String�� ������~ �ٵ� ���ް��� ��� �޴�? HttpServletRequest ����ϸ� ����!!
//	���� viewPage�� �����Ͽ��� ����Scope�� �ٸ��� ������ ������� ���� ��µ�
	public String requestResult(HttpServletRequest request) {
		request.setAttribute("Dream", "��Ǫ������");
		return "result_display";
	}
	
	
//	������ ���� ������ ���帹�� ��� ������ => �Ű����� ������ص� ������
//	Model �ν��Ͻ� : ó������� �����ϱ� ���� �ν��Ͻ�
//	ModelAndView.addAttribute(String attributeName, Object attributeValue)
//	 : ViewPage ���ǵ��� �������� �����ϴ� �޼ҵ� , �⺻ : Request Scope
	@RequestMapping("/resultModel")
	public String modelResult(Model model) {
//		�⺻������ request Scope
		model.addAttribute("DreamDaru", "��ٷ�������Ǫ������");
		return "result_display";
	}
	
	
//	ModelMapŬ���� : Model �������̽��� ��ӹ޾� �ۼ��� Ŭ���� - Model �ν��Ͻ��� ����� ���� 
	@RequestMapping("/resultMap")
	public String modelMapResult(ModelMap map) {
//		�⺻������ request Scope
		map.addAttribute("DaruDream", "��ٷ����������ʹ٢�");
		return "result_display";
	}
	
}



















