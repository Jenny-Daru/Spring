package site.itwill07.aop;

import java.util.List;

//�ٽɰ����ڵ带 ������ �ִ� ���
//�޼ҵ� ȣ�� =>  DB�����ߵȰŶ�� ���� ����

//�ٽɰ��ɸ�� : �ٽɰ����ڵ尡 �ۼ��� �޼ҵ尡 ����� Ŭ����

public class StudentDAOImpl implements StudentDAO {

	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentDAOImpl Ŭ������ insertStudent(Student student)�޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentDAOImpl Ŭ������ selectStudent(int num)�޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectListStudent() {
		System.out.println("*** StudentDAOImpl Ŭ������ List<Student> selectListStudent()�޼ҵ� ȣ�� ***");
		return null;
	}
	

}
