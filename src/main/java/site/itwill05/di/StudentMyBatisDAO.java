package site.itwill05.di;

import java.util.List;

public class StudentMyBatisDAO implements StudentDAO {

	public StudentMyBatisDAO() {
		System.out.println("### StudentMyBatisDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** StudentMyBatisDAO Ŭ������ insertStudent() �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** StudentMyBatisDAO Ŭ������ selectStudent() �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** StudentMyBatisDAO Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		return null;
	}

}
