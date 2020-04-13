package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��ûó�� Ŭ����(Model - CommandController)�� �ݵ�� ��ӹ޾ƾ� �ϴ� �������̽� 
// => �������̽��� ��ӹ��� ��� �ڽ�Ŭ������ ���� ������ �ۼ��ǵ��� ��Ģ�� ���� 
// => ��� �ڽ�Ŭ������ �ν��Ͻ��� �������̽� ���������� �����Ͽ� �޼ҵ� ȣ�� - �ڿ������̵忡 ���� ��������
//    ���ϴ� �޼ҵ带 ȣ���Ͽ� �ڽ�Ŭ������ �޼ҵ� ȣ�� ���� 
// ��û�� FrontController�� ������, ���� ������ CommandController�� ����
public interface Controller {
	String handlerequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
		
}
