package site.itwill09.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ʈ�ѷ� Ŭ����(Model) : Ŭ���̾�Ʈ�� ��û�� ó���ϴ� �޼ҵ尡 �ۼ��� Ŭ����
//							=> ��Ŭ���� ��� ��Ʈ�ѷ�Ŭ����(Command Class)�� ǥ��
public class ListController implements Controller {

	@Override
//	��ûó�� �޼ҵ�
	public String handlerequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		serviceŬ������ �޼ҵ带 ȣ���Ͽ� ������ ó�� �� ��� ��ȯ (���� �Է°��� �ִٸ� �Է°��� ���� ó���ؾ���)
//		 => ���(memberList)
		List<Member> memberList=new ArrayList<Member>();
		memberList.add(new Member("AAA","��ٷ�","daru@daru.com"));
		memberList.add(new Member("BBB","���ٷ�","yun@daru.com"));
		memberList.add(new Member("CCC","�ٷ��","ruru@daru.com"));
		
		
//		ó�����(�ν��Ͻ�)�� request �ν��Ͻ��� �Ӽ����� ���� 
		request.setAttribute("memberList", memberList);
		
//		ó������� �����ϴ� ���������� ��ȯ
//		 => JSP����(member_list)�� ����
//		* redirect: ���̸� redirect�̵� ���� *
//		return "redirect:member_list";
		return "member_list";
	}

}
