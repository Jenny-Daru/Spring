package site.itwill05.di;

import java.util.List;

//Impl : �����ڵ鳢�� �������̽��� ��ӹ޴� Ŭ������ ���� �� ���

//Service Ŭ���� : ���α׷� �ۼ��� �ʿ��� ����� �����ϱ� ���� Ŭ���� - ���
//					=> DAO Ŭ������ �޼ҵ带 ȣ���Ͽ� ���α׷��� �ʿ��� ����� �����ϴ� �޼ҵ带 �ۼ�
//					=> Service Ŭ������ ����Ǿ ���α׷�(�����ø����̼�-��)�� ������ �ּ�ȭ �ϱ� ���� �������̽��� ��ӹ޾� �ۼ�

//DAOŬ������ �߻��Ǵ� ���� ó��
// * �����������ӿ�ũ : ���۳�Ʈ���� ����ü  //  * ���۳�Ʈ : ����� ����ü
public class StudentServiceImpl implements StudentService {
	
//	��Service Ŭ������ DAOŬ������ �޼ҵ� ȣ�� �̰��� �ٽɡ� >> ��ü �ʿ�(�ν��Ͻ�) >> �ʵ�� ����������(�׷��� ��� �޼ҵ尡 �� ��밡��)
//	Ŭ������ ������� ��ü�� ����Ǿ�� �Ѵ�. => setter,getter / �����ڸ� �̿�
//	StudentJdbcDAO �ν��Ͻ��� �����Ͽ� ���԰��� ����(�Ϲ����� association ����)
	
//	�ʵ尪���� StudentJdbcDAO �ν��Ͻ��� �����Ͽ� ���԰��� ����
// 	=> ������ �Ǵ� Setter �޼ҵ带 �̿��Ͽ� �ν��Ͻ� ���� 
//	private StudentJdbcDAO sutdentJdbcDAO;
//	private StudentMyBatisDAO studentMyBatisDAO;
	
	
	/*
//	�ʵ��� Ŭ����(�ڷ���)�� ����� ��� ��� �����ڿ� ��� �޼ҵ带 �����ؾ��ϴ� ������ => ������� �������
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}
	
	public StudentServiceImpl(StudentJdbcDAO sutdentJdbcDAO) {
		super();
		this.sutdentJdbcDAO = sutdentJdbcDAO;
		System.out.println("### StudentServiceImpl Ŭ������ �Ű������� ����� ������ ȣ�� ###");
	}
	

	public StudentJdbcDAO getSutdentJdbcDAO() {
		return sutdentJdbcDAO;
	}


	public void setSutdentJdbcDAO(StudentJdbcDAO sutdentJdbcDAO) {
		this.sutdentJdbcDAO = sutdentJdbcDAO;
		System.out.println("*** StudentServiceImpl Ŭ������ setSutdentJdbcDAO(StudentJdbcDAO sutdentJdbcDAO) �޼ҵ� ȣ�� ***");
	}


	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ addStudent(Student student) �޼ҵ� ȣ�� ***");
		sutdentJdbcDAO.insertStudent(student);
		
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ�� ***");
		return sutdentJdbcDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return sutdentJdbcDAO.selectStudentList();
	}
*/	
	

//	�θ� �������̽��� �����ϸ� �ڽĵ��� ��� ���尡�� 
//	�θ� �������̽��� �̿��Ͽ� �����ʵ� �����ϸ� ��� �ڽ� �ν��Ͻ� ����
//	 => �ڽ� �ν��Ͻ��� ����� ��� Ŭ������ �̿���
	
//	�������̽��� �ʵ带 ����� �ڽ��ν��Ͻ��� ���� >> ������ , setter �̿� 
	private StudentDAO studentDAO;
	
	public StudentServiceImpl() {
		System.out.println("### StudentServiceImpl Ŭ������ �⺻ ������ ȣ�� ###");
	}

	public StudentServiceImpl(StudentDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
		System.out.println("### StudentServiceImpl Ŭ������ �Ű������� ����� ������ ȣ�� ###");
	}

	public StudentDAO getStudentDAO() {
		return studentDAO;
	}

	public void setStudentDAO(StudentDAO studentDAO) {
		System.out.println("*** StudentServiceImpl Ŭ������ setStudentJdbcDAO(StudentJdbcDAO studentJdbcDAO) �޼ҵ� ȣ�� ***");
		this.studentDAO = studentDAO;
	}
	
	
	@Override
	public void addStudent(Student student) {
		System.out.println("*** StudentServiceImpl Ŭ������ addStudent(Student student) �޼ҵ� ȣ�� ***");
		studentDAO.insertStudent(student);
	}

	@Override
	public Student getStudent(int num) {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudent(int num) �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudent(num);
	}

	@Override
	public List<Student> getStudentList() {
		System.out.println("*** StudentServiceImpl Ŭ������ getStudentList() �޼ҵ� ȣ�� ***");
		return studentDAO.selectStudentList();
	}
}


















