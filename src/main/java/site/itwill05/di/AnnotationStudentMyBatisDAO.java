package site.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Repository : DAO Ŭ������! Spring Bean���� ����ϱ� ���� ������̼�, Ʈ������ ������ ���� ����� ���� �� �����Ƿ� ����(Component�� ������)
@Repository("studentMyBatisDAO")
public class AnnotationStudentMyBatisDAO implements StudentDAO {

	public AnnotationStudentMyBatisDAO() {
		System.out.println("### AnnotationStudentMyBatisDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentMyBatisDAO Ŭ������ insertStudent() �޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentMyBatisDAO Ŭ������ selectStudent() �޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** AnnotationStudentMyBatisDAO Ŭ������ selectStudentList() �޼ҵ� ȣ�� ***");
		return null;
	}

}
