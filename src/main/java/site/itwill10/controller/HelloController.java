package site.itwill10.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//Command Controller : �ݵ�� Controller�������̽� ���, ��Spring Bean���� ��� => �߿� => ������̼� ���� 
//@Component => Controller �������̽��� ��ӹ޾ƾ���, @RequestMapping ��� �Ұ���  

//@Controller : Command Controller ������ Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
//				 => �⺻������ Ŭ�������� beanName���� ���� - �Ӽ��� �̿��Ͽ� ���氡�� (Injection ��Ű�ų� ������ ������� ������ ���� �������)
//				 => Controller �������̽��� ��ӹ��� �ʾƵ� Command Controller Ŭ������ �۵����� 
//				 => Command Controller�� �θ��� ����, @Controller ������̼��� ���� ���� �޶��� 
//				 => Command Controller�� �ϳ��� ��û�� �޾Ƽ� ó���ϴ°� ������!
//				 => Ŭ���̾�Ʈ�� ��û�� ���� ó�� �޼ҵ带 ������ ���� ���� => Controller�� �θ� => HandlerMapping ��������ʾƵ� ����
//                   >> ��@RequestMapping�� ������� ��û�� �޼ҵ� ������ ó��  
//				 FrontController�� ��û�� �ް� Command Controller�� ������ ó�������� ��û�� ó�� �Ѵ� �ϱ� ������ Controller�� �Ҹ��� 
@Controller
public class HelloController {
//	��ϰ�ü ���� >> �̺�Ʈ �߻� >> ��ϱ���ü�� catch�Ͽ� ��ϰ��� 
	private static final Logger logger=LoggerFactory.getLogger(HelloController.class);
	
//	Ŭ���̾�Ʈ�� ��û�� ó���ϱ� ���� �޼ҵ�(������ ����)
//	@RequestMapping : Ŭ���̾�Ʈ ��û������ �����޾� �޼ҵ带 ȣ���Ͽ� �����ϴ� ������̼�  => @Controller�� ���ӵǾ� �����Ƿ� @Controller�� ��� �� ���� ����
//					  => ��value�Ӽ�(�ʼ�) : Ŭ���̾�Ʈ ��û������ �Ӽ������� ���� - �ٸ� �Ӽ��� ���� ��� value�����ϰ� �Ӽ����� ���� ���� 
//					  => web.xml���� Ȯ���� ���� /(����û)���� ��û�޴°� �����Ǿ� �����Ƿ� Ŭ���̾�Ʈ�� Ȯ���ھ��� hello��� ��û�ϸ� �����̳ʰ� �̸޼ҵ带 ȣ������
	
//	��ûó�� �޼ҵ�� �ڹݵ�� View Name�� ��ȯ�ؾ� �Ѵ١�
//	 => Front Controller�� ViewName�� ���޹޾� ViewResolver Ŭ������ �̿��Ͽ� JSP ���ϰ�η� ��ȯ�Ͽ� ������ �̵� 
//		��, viewName�� ������ viewResolver���� ������ ������ ����, JSP ������ ���� ��..
	

//	[������ ��ûó�� �޼ҵ忡�� Front Controller���� viewName(JSP�� ����� ���� Name)�� �����ϴ� ��� - 3���� ������] 
//	 => �����ϰ��� �ϴ� JSP������ ��
//	1. ��û ó�� �޼ҵ��� ��ȯ�� void ���� : �޼ҵ���� ViewName���� ���� 
//	2. ��û ó�� �޼ҵ��� ��ȯ�� String ���� : ��ȯ��(���ڿ�String �ν��Ͻ�)�� ViewName���� ���� => JSP�� ������ ��� ���, ���帹�� ���
//	3. ��û ó�� �޼ҵ��� ��ȯ�� ModelAndView ���� : ��ȯ��(ModelAnd��View���ν��Ͻ�)�� ViewName���� ����
//													  => Ư���� ��� ���,  ����������getter�޼ҵ� ȣ���Ͽ� view�� ������ ����ؼ� ����
//	�������޼ҵ���� �ƹ����� �ص� ��������� ��ȯ���� �Ű������� ��Ģ�� ���� !! �Ű����� : �����̳ʿ��� �ʿ��� ��ü�� �����ޱ� ���� �ʿ䢾����
	
	
	@RequestMapping(value = "/hello")
	public void hello() {
//		[1]
//		Command Controller�� ModelAndView�� ��ȯ�Ͽ����� ���⼭�� void !!!
//		��ûó�� ��� ���� - Servie Ŭ������ �޼ҵ� ȣ�� / service =>  DAOȣ�� / DAO => MyBatis
		logger.info("/hello ��û >> HelloControllerŬ������ hello() �޼ҵ� ȣ��");
		
	}
	
	
	@RequestMapping("/helloViewName")
	public String helloViewName() {
//		[2]
//		�޼ҵ��� Ŭ�������� ���Ƶ� ��������� �Ű������� �ٸ��� �����ؾ��� 
		logger.info("/helloViewName ��û >> HelloControllerŬ������ helloViewName() �޼ҵ� ȣ��");
		return "hello";
	}
	
	
	@RequestMapping("/helloMAV")
//	ModelAndView : ��ûó���� ���� ������� ViewName�� �����ϱ� ���� Ŭ���� 
	public ModelAndView helloModelAndView() {
//		[3]
		logger.info("/helloMAV ��û >> HelloControllerŬ������ helloModelAndView() �޼ҵ� ȣ��");
		/*
		ModelAndView modelAndView=new ModelAndView();
//		ModelAndView.setViewName(String ViewName) : ViewName�� �����ϴ� �޼ҵ�
		modelAndView.setViewName("hello");
		*/
		
//		�����ڸ� �̿��Ͽ� ViewName �ʱ�ȭ�Ͽ� ����
		ModelAndView modelAndView=new ModelAndView("hello");
		return modelAndView;
	}
	
	
}














