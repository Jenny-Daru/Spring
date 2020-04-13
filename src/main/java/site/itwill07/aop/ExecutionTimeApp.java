package site.itwill07.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Ÿ�̸ӱ�� 
public class ExecutionTimeApp {
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("07-4_timer.xml");
		
		System.out.println("======================================================================================================================");	
		
		ExecutionTimeBean bean=context.getBean("executionTimeBean", ExecutionTimeBean.class);
//		run�޼ҵ尡 ����ɶ� ����ü �󸶳� �ɷȴ��� �˾ƺ��� ���α׷� ���ѱ�
		bean.run();
		
		System.out.println("======================================================================================================================");	
		
		((ClassPathXmlApplicationContext)context).close();			
	}
}
