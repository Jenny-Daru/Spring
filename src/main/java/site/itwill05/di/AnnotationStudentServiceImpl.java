package site.itwill05.di;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

//value �Ӽ��� �̿��Ͽ� beanName ���� ����, �ٸ� �Ӽ��� ���� ������� ���� ��� ��������
//@Component("studentService")

//@Service : ServiceŬ������ Spring Bean���� ����ϱ� ���� ������̼� 
//			  => ���ӵ� ������̼��� �����ϹǷ� ��� (Controller������̼� - MVC���� ���߿� ���, ���ӵ� ������̼�)
@Service("studentService")
public class AnnotationStudentServiceImpl implements StudentService {
//	@Resource : Spring Bean�� �ڵ� Injection(DI)����� �����ϱ� ���� ������̼�
//				=> JDK ���̺귯������ �����Ǵ� ������̼� - Ư�� Framework�� ���ӵ��� �ʴ´�.
//	@Resource
	
//	@Autowired : Spring Framework�� �����ϴ� ������̼�(Spring������ ��� ����)
//				  => Spring ���̺귯������ �����ϴ� ������̼�, �ٸ� Framework���� ������ ���� ����
//				  => bean ������Ʈ�� autowire �Ӽ��� "byType" �Ӽ����� ���� ������� Injection
//				  => byType�� setter �޼ҵ尡 ������ �����߻� , but Autowired�� setter �޼ҵ带 �������� �ʾƵ� Setter Injection ����
//				  => �����ڸ� �̿��Ͽ� Injection �Ұ���
	
//				  �ڹ������� �ʵ��� �ڷ����� �������̽��� ��� �ڽ�Ŭ������ Spring Bean���� ������ ��ϵǸ� ���� �߻�
//					  �ذ�1) �ڽ�Ŭ������ Spring Bean���� ������ ��ϵ� ��� "byName" �Ӽ����� ���� ������� Injection ó��
//							  => �ڽ�Ŭ���� �� �ϳ��� beanName�� �ʵ��� ������ �̸����� ����
//								 "byType"�� �켱 ���� >> "byName" ���� 
//					  �ذ�2) @Qualifier ������̼��� �̿��Ͽ� Injection ó���� Spring Bean ����
//							 @Qualifier :value �Ӽ��� beanName�� �����Ͽ� SpringBean�� Injection ó���ϴ� ������̼�
//							  => �ݵ��!!! @Autowired������̼� ��� �� @Qualifier �ۼ� , @Autowired ������̼��� ���ӵ� ������̼�
	
	@Autowired
//	@Qualifier(value = "studentJdbcDAO")
	@Qualifier(value = "studentMyBatisDAO")
	private StudentDAO studentDAO;

/*
//	�����񽺴� DAO ������ ó�� �ϹǷ� �ʵ帶�� ���� @Autowired�� ����Ͽ� Injection ó���� 
	@Autowired
	private StudentDAO studentDAO1;
*/
	
	public AnnotationStudentServiceImpl() {
		System.out.println("### AnnotationStudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}

	public AnnotationStudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### AnnotationStudentServiceImpl Ŭ������ �Ű������� ����� ������ ȣ�� ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) �޼ҵ� ȣ�� ***");
		this.studentDAO = studentDAO;
	}
	
	
	@Override
	public void addStudent(Student student) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ addStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** AnnotationStudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudentList();
	}
}


















