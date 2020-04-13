package site.itwill09.mvc;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//��Ʈ�ѷ�(Controller) : Ŭ���̾�Ʈ�� ��� ��û�� �޾� URL �ּҸ� �м��Ͽ� ��û�� ���� ó��Ŭ������ �ν��Ͻ��� �����Ͽ� 
//						 ��(ó��)Ŭ����(Model)�� �ν��Ͻ� �޼ҵ带 ȣ���Ͽ� ��û ó�� �� JSP(View) ������ ����ǵ��� �帧�� �����ϱ� ���� ���� Ŭ���� 
// 						 �ڹݵ��!! ���� �������� ���ҡ� <= �길 ��û�� �޾� ó���Ұ���, �ٸ��ְ� ��û�޾� ó���ϸ� �ȴ� 
//							=> ������ web.xml ���Ͽ��� ����Ŭ����(WAS�� ���� ����Ǵ� Ŭ����)�� �������� ����ϰ� 
//									   ���������� ���ҷ� ����� �� �ֵ��� URL �������� ����ó�� ������ - ���ϸ� �ǹ̾���
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	Ŭ���̾�Ʈ ��û�� ó���ϱ� ���� WAS ���α׷��� �ڵ� ȣ���ϴ� �޼ҵ�
//	��û�� ó���ϱ� ���� ����ؾ��ϴ� ��ü �ΰ�(request, response), �̰ŵΰ��� web���ø����̼� ����� �տ�
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. Ŭ���̾�Ʈ�� ��û URL �ּҸ� �м� - �䱸���� �ľ� 
//		    => �갡 ���ϴ� �۾��� ����ü ���?
		String requestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
//		Ŭ���̾�Ʈ�� ��û �䱸������ command�� �м�����
		String command=requestURI.substring(contextPath.length());
		
//		2. ��û�� ���� ��Ʈ�ѷ�(ó��)Ŭ������ �޼ҵ� ȣ���ϰ� ����������(handlerequest�� �ش�) ������ ��ȯ�޾� ����
//		    => ��Ʈ�ѷ�Ŭ������ �����ؾ��ϰ�, Ŭ������ ������ �ν��Ͻ�ȣ��, �޼ҵ� ȣ�� �Ұ�����!!  => ��Ʈ�ѷ�Ŭ���� ����� �Ͷ� => Controller�������̽� �ۼ� Go!
//		    => ��û ó�� Ŭ���� : Model >> Controller
//		    command��û�� ���� �䱸������ ������ϴµ� �ν��Ͻ��� �ʿ��� �ν��Ͻ� ���� ����
		/*
		Controller controller=null;
		if(command.equals("/list.itwill")) {
			controller=new ListController();
		} else if (command.equals("/view.itwill")) {
			controller=new ViewController();
		}
		
		String view=controller.handlerequest(request, response);
		*/
		
//		����ó�� ������� �ʰ�, HandlerMapping Ŭ������ ���� ��������� 
//		��û������ �����Ͽ� ó�� �ν��Ͻ��� ��ȯ�޾� ó�� 
		HandlerMapping handlerMapping=new HandlerMapping();
		Controller controller=handlerMapping.getController(command);
		
//		ó���޼ҵ带 ȣ���ϰ� ���������� ������ ��ȯ�޾� ����
		String view=controller.handlerequest(request, response);
		
		
//		3. ������������ forward �̵��Ͽ� Ŭ���̾�Ʈ���� �������� ����
//		    => ��ȯ���� ���������� ������ View�������� ��ȯ�Ͽ� ������ �̵�
		ViewResolver viewResolver=new ViewResolver();
		String viewPage=viewResolver.getViewPage(view);
		
		request.getRequestDispatcher(viewPage).forward(request, response);
		
	}

}














