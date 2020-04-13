package site.itwill09.springMVC;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//Command Controller Ŭ���� : ���� �������ʰ� SpringFramework�� �������ִ� Controller �������̽��� ��ӹ޾� �ۼ�
//�갡 ���񽺸� ������ ����ҰŰ� ���񽺴� DAO�� ������ ����Ұ���
public class ListController implements Controller {

	@Override
//	ModelAndView ��ȯ
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
//		serviceŬ������ �޼ҵ带 ȣ���Ͽ� ������ ó�� �� ��� ��ȯ (���� �Է°��� �ִٸ� �Է°��� ���� ó���ؾ���)
//		 => ���(memberList)
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("AAA","��ٷ�","daru@daru.com"));
		memberList.add(new Member("BBB","���ٷ�","yun@daru.com"));
		memberList.add(new Member("CCC","�ٷ��","ruru@daru.com"));
		
//		ModelAndView : ��ûó�� ����� ���� ������ ������ �����ϴ� Ŭ����
		ModelAndView mav=new ModelAndView();
		
//		ModelAndView.addObject(String attributeName, Object attributeValue) 
//		 : ��ûó�� ����� �߰��ϴ� �޼ҵ� (map ���·� ��ü�� �߰����ּ���~)
//		    => request.setAttribute() �޼ҵ�� ������ ����� ����
//		    => ������ ���� ��ü�� �ٲܼ� �����Ƿ� ���� ���� ���������� session�� ����� �� ���� 
		mav.addObject("memberList",memberList);
		
//		ModelAndView.setViewName(String viewName) : ���������� ������ �����ϴ� �޼ҵ�
		mav.setViewName("member_list");
		
		return mav;
	}

}
