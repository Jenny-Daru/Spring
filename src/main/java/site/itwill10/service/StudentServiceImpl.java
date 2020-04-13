package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.StudentDAO;
import site.itwill10.dto.Student;


//ServiceŬ���� : ��DAO Ŭ������ �޼ҵ�ڸ� ȣ���Ͽ� ���ø����̼ǿ��� �ʿ��� ����� �����ϴ� �޼ҵ尡 ����� Ŭ���� 
// 				  => DB�������ִ� ����
// 				  => Spring Bean���� ��ϵǾ�� DAO�޼ҵ带 ������ ��밡���ϴ� ������̼��� ����Ͽ� Spring Bean���� ��� �ϰ� ������
//   				 servlet-context.xml���� package ����Ͽ� ���

//@Service : Service ���� Ŭ������ Spring Bean���� ����ϴ� ������̼�
@Service
public class StudentServiceImpl implements StudentService {
	
//	DAO���� Spring Bean�� ������ ó���Ͽ� �ʵ忡 ����
//	 => �ʵ��� �ڷ����� �������̽��� �����Ͽ� ��� �ڽ�Ŭ������ �ν��Ͻ��� ������ �ǵ��� �����ϴ°��� ���� 
//	 => �������̽��� ��ӹ��� �ڽ�Ŭ������ Spring Bean�� ���� ���� ��� @Qualifier ������̼��� �̿��Ͽ� ���ϴ� Spring Bean�� ������ �ǵ��� ���� 
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public void addstudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

	

}
