package site.itwill10.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import site.itwill10.dto.Student;
import site.itwill10.mapper.StudentMapper;

//DAOŬ���� : DBMS ������ SQL ���(Mapper�� ��ϵ�)�� �����Ͽ� �����ϰ� ����� ���(JavaType)�� ��ȯ�ϴ� ����� �޼ҵ带 �����ϴ� Ŭ����
//             => Spring Bean���� ��������߸� ��밡��   1.Bean������Ʈ   2.������̼� => ����Ʈ��Ʈ�ѷ��� �о���̴� xml���Ͽ����� ������̼� �о���̴� ����
//			
//@Repository : DAO���� Ŭ������ Spring Bean���� ����ϴ� ������̼� / ���ӵ� ������̼��� �� ���� ������ @Component ���� �� ���
@Repository
public class StudentDAOImpl implements StudentDAO {
	
//	@Autowired : �ڵ����� ������ , setter �ʿ����, ������ ������̼� ����ؼ� ������ ������ �굵 ������̼����� ������ �������
//	SqlSession ���� Spring Bean�� ������ ó���Ͽ� �ʵ忡 ���� => root-context.xml�� ��ϵ� sqlsession ��� ���� => �޼ҵ� ��밡��
	@Autowired
	private SqlSession sqlsession;

	@Override
	public int insertStudent(Student student) {
//		�߻�޼ҵ�� ����ȭ �Ǿ��ִ� �޼ҵ带 ȣ���ؼ� ó���ϰ� ��ȯ���� ����
		return sqlsession.getMapper(StudentMapper.class).insertStudent(student);
	}

	@Override
	public List<Student> selectStudentList() {
		return sqlsession.getMapper(StudentMapper.class).selectStudentList();
	}

}
