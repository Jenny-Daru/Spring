package site.itwill10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//�������� �̰��� main�̴�!!!!!!!!!!!!!
@Controller
public class TilesController {
//	����Ʈ�� main �������� ��û�� ��� ȣ��Ǵ� �޼ҵ� 
//	 => ������ ������ GET�̾�~ value�� method ��������~
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String template() {
//		������ JSP�� return ����������� ������(Template�������� �̸�)�� return����Ŵ�~
//		tiles.xml ���Ͽ� ����� definition ������Ʈ�� ������(name�Ӽ���)�� ViewName���� ��ȯ�ϸ� ������ ���ø� ������(JSP)�� ���� ó��
//		 >> ����Ʈ ��Ʈ�ѷ��� �޾Ƽ� �丮�������� ���� >> �丮������ JSPã�Ƽ� ���~   ��tiles.xml ���� ������
		
//		�����ø����̼� ���ؽ�Ʈ�� ���� ������ ���� WEB-INF�� ���� �����ϹǷ� ������ ����� xml�� �������� 
		return "main";
	}
	
	
	@RequestMapping(value = "/tiles1")
	public String tiles1() {
//		��ȯ�Ǵ� ViewName�� definition ������Ʈ�� �������� JSP���ϸ����� ���� 
		return "hello_tiles";
	}
	
	
//	���丮 �����ڰ� ������ tiles.xml���� �ν����� ���� => ���ڿ��� �ν��ϴϱ�~~ �߰��� �����ϰ� ������
	@RequestMapping(value = "/tiles2")
	public String tiles2() {
//		���丮�̸�/JSP���ϸ��� �Ǵ°�~~~~~~~~ xml�� definition */*�� �߰��ؼ� ����ϸ��
		return "tiles/hi_tiles";
	}
	
	@RequestMapping(value = "/tiles3")
	public String tiles3() {
		return "tiles/good/by_tiles";
	}	
	
	
	@RequestMapping(value = "/admin")
	public String admin() {
		return "admin";
	}	
	
	
	@RequestMapping(value = "/admin_hello")
	public String adminHello() {
		return "admin/hello";
	}	
}












