package site.itwill.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import site.itwill10.dto.Student;
import site.itwill10.service.StudentService;

//�׽�Ʈ Ŭ���������� ���� ���α׷�(ServiceŬ����)�� �˻��ϱ� ���� �������� �ۼ�

// ServiceŬ������ DAO���� Spring Bean�� ��� �ִ��� Bean Configuration File�� ã�� �о���̱� 
//  => ������̼� ���� Bean Configuration File�� �ϳ��� ���� 
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration : WebApplicationContext ��ü(Spring Container)�� �̿��Ͽ� Spring Bean�� �����ϵ��� �����ϴ� ������̼�
//						  => Spring Container�� �⺻������ ���ø����̼� ���ؽ�Ʈ�� �̿������� �̰� ����ϸ� �����ø����̼� ���ؽ�Ʈ ���� 
//   				     �ڡڡ������� �ڿ��̳� ��Ʈ�ѷ� �׽�Ʈ �ϱ����ؼ��� ���� �� ������̼� ���ڡڡ�
//  					
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml",
						"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
public class StudentServiceTest {
	private static final Logger logger=LoggerFactory.getLogger(StudentServiceTest.class);
	
//	SutdnetService �޼ҵ带 �׽�Ʈ�ϰ� ���� => �޼ҵ带 ȣ���ϱ� ���� ���� �޼ҵ� ���尡���� �ʵ� ���� => �������ϱ� 
	@Autowired
	private StudentService studentService;
	
//	����ڿ��� �Է¹޴°��� �ƴϰ� ���� setter�޼ҵ� ȣ���Ͽ� Ȯ�� 
	@Test
	public void testAddStudent() {
		Student student = new Student();
		student.setNo(9000);
		student.setName("������");
		student.setPhone("010-8888-8888");
		student.setAddress("�������¥�� ����");
		student.setBirthday("1000-10-10");
		studentService.addstudent(student);
		logger.info("�л����� �߰� ���� ��� ���� ����!");
	}
	
	@Test
	public void testgetStudentList() {
		List<Student> studentList=studentService.getStudentList();
		for(Student student:studentList) {
			/*
			logger.info(student.getNo()+","+student.getName()+", "+student.getPhone()
							+", "+student.getAddress()+", "+student.getBirthday().substring(0, 10));
			 */
			logger.info(student.toString());
		}
		
		
	}
		

}















