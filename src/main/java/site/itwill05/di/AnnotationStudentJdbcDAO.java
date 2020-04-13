package site.itwill05.di;

import java.util.List;

import org.springframework.stereotype.Repository;

//@Component : Ŭ������ Spring Bean���� ����ϱ� ���� ������̼�
//				=> �⺻������ Ŭ�������� beanName�� ���������� value �Ӽ��� �̿��Ͽ� beanName ���� ����
//				=> value �Ӽ� ��������
//@Component("studentDAO") => DAOŬ������ Component ������� ����!!

//@Repository : DAO Ŭ������! Spring Bean���� ����ϱ� ���� ������̼�, Ʈ������ ������ ���� ����� ���� �� �����Ƿ� ����(Component�� ������)
//				=> �⺻���� ���� �Ȱ�����, �� ������̼ǿ� ���ӵ� ������̼��� �� ����!! �޼ҵ忡 �پ��� ������̼��� �� ����
//				=> Component : �θ� , Repository : �ڽ� 
@Repository("studentJdbcDAO")
public class AnnotationStudentJdbcDAO implements StudentDAO {
	private StudentDAO studentDAO;
	
	public AnnotationStudentJdbcDAO() {
		System.out.println("### AnnotationStudentJdbcDAO�� �⺻ ������ ȣ�� ###");
	}
	
	@Override
	public int insertStudent(Student student) {
		System.out.println("*** AnnotationStudentJdbcDAO�� insertStudent(Student student)�޼ҵ� ȣ�� ***");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("*** AnnotationStudentJdbcDAO�� selectStudent(int num)�޼ҵ� ȣ�� ***");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("*** AnnotationStudentJdbcDAO�� List<Student> selectStudentList()�޼ҵ� ȣ�� ***");
		return null;
	}

}
