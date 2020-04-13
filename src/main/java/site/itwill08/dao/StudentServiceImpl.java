package site.itwill08.dao;

import java.util.List;

//���������� ���ø����̼ǵ��� ��������� ����� ����� �� 
// �ٽ� => DAOŬ������ �޼ҵ带 ȣ�� => DAOŬ������ �ν��Ͻ��� �ʵ�� ���� => Injection 

public class StudentServiceImpl implements StudentService {
//	Bean Configuration File���� SutdentDAO���� Spring Bean�� �ʵ忡 Injection ó�� 
//	 => Injection ó���� StudentDAO �������̽��� �ڽ� Ŭ���� �޼ҵ� ȣ�� ����, Injectionó�� �ȵǾ��ٸ� NullPointException �߻�!
//	 => �ʵ��� �ڷ����� �������̽��� �����ϸ� Injection�� DAOŬ������ Spring Bean�� ����Ǿ �ҽ� �̺���
//	 => �ʵ��� �ڷ����� �������̽��� �ƴϰ� Ŭ������ ��� Injection�� Spring Bean�� ������ �� �ʵ嵵 �����ؾ��� >> ����
	private StudentDAO studentDAO;
	
	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		this.studentDAO = studentDAO;
	}

	@Override
	public void addStudent(Student student) {
		studentDAO.insertStudent(student);
	}

	@Override
	public void modifyStudent(Student student) {
		studentDAO.updateStudent(student);
	}

	@Override
	public void removeStudent(int no) {
		studentDAO.deleteStudent(no);
	}

	@Override
	public Student getStudent(int no) {
		return studentDAO.selectStudent(no);
	}

	@Override
	public List<Student> getStudentList() {
		return studentDAO.selectStudentList();
	}

}
