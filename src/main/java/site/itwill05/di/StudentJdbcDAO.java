package site.itwill05.di;

import java.util.List;

//DAOŬ���� : �����ü[DataSource - DBMS(����Ŭ)]���� ������ ���� ����, ����, ����, �˻� ����� �����ϴ� Ŭ����
//	 		   => �޼ҵ带 ����
//			   => �����ü�� ���� �Ǵ� ����� ���� ���� ���� DAO Ŭ���� ����
//			   => ���α׷����� ����ϴ� DAOŬ������ ����� �� �ֱ� ������ DAO Ŭ������ ����Ǿ �ٸ� Ŭ����(Service)�� ������ �ּ�ȭ �ϱ� ���� �������̽��� ��ӹ޾� �ۼ� �ڱ����

// ���ø����̼��� Service�޼ҵ� ȣ�� => ServiceŬ������ �޼ҵ�� DAOŬ������ �޼ҵ�ȣ�� 
public class StudentJdbcDAO implements StudentDAO {
	
	public StudentJdbcDAO() {
		System.out.println("### StudentJdbcDAO Ŭ������ �⺻ ������ ȣ�� ###");
	}

	@Override
	public int insertStudent(Student student) {
		System.out.println("�ڡڡ� StudentJdbcDAO Ŭ������ insertStudent() �޼ҵ� ȣ�� �ڡڡ�");
		return 0;
	}

	@Override
	public Student selectStudent(int num) {
		System.out.println("�ڡڡ� StudentJdbcDAO Ŭ������ selectStudent() �޼ҵ� ȣ�� �ڡڡ�");
		return null;
	}

	@Override
	public List<Student> selectStudentList() {
		System.out.println("�ڡڡ� StudentJdbcDAO Ŭ������ selectStudentList() �޼ҵ� ȣ�� �ڡڡ�");
		return null;
	}



}
