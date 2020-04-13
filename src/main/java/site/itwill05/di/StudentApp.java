package site.itwill05.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentApp {
	public static void main(String[] args) {
		
		ApplicationContext context=new ClassPathXmlApplicationContext("05-1_di.xml");
		System.out.println("============================================================");
		
//		05-1_di.xml���� Spring Bean �ν��Ͻ��� ������ studetn1�̶�� �̸��� �ν��Ͻ��� Sutdent��� Ŭ������ ����ȯ�ؼ� �ּ���~
		Student student1=context.getBean("student1", Student.class);
//		student1.setNum(num); //�̷��� ��������� ���߿� �� ����Ǿ����� �ٽ� �缳���ؾ��ϹǷ� ����.... �������..
//		 => xml ���� �ʱ�ȭ �۾��ض�
		System.out.println(student1); 
		
		System.out.println("============================================================");
		
		Student student2=context.getBean("student2", Student.class);
		System.out.println(student2); 
		
		System.out.println("============================================================");
		
		Student student3=context.getBean("student3", Student.class);
		System.out.println(student3); 
		
		System.out.println("============================================================");
		
		Student student4=context.getBean("student4", Student.class);
		System.out.println(student4); 
		
		System.out.println("============================================================");
		
		Student student5=context.getBean("student5", Student.class);
		System.out.println(student5);
		System.out.println("============================================================");
		
		/*
//		StudentServiceImpl studentserviceImpl=context.getBean("studentServiceImpl", StudentServiceImpl.class);
		
//		System.out.println(studentserviceImpl.getSutdentJdbcDAO());
		studentserviceImpl.addStudent(null);
		studentserviceImpl.getStudent(0);
		studentserviceImpl.getStudentList();
		*/
		
//		ServiceŬ������ ���������� ����°��� ��ȿ���� => �������̽�
//		�ʳ� ���񽺰� �ٲ��� �θ� ��� �ڽ��� �� ���� ��������
		StudentService stuentService=context.getBean("studentService", StudentService.class);
		stuentService.addStudent(null);
		stuentService.getStudent(0);
		stuentService.getStudentList();		
		
		System.out.println("============================================================");
		
		((ClassPathXmlApplicationContext)context).close();
	}

}


















