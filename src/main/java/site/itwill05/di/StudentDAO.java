package site.itwill05.di;

import java.util.List;

//�л������� ���� DAOŬ������ �ݵ�� ��ӹ޾ƾ� �ϴ� �������̽�
// => �ν��Ͻ�(��ü)���� ���յ��� ���� ���������� ȿ������ ������Ű�� ���� ����
// => �߻�޼ҵ带 ����� �޼ҵ��� ��Ģ�� ����
public interface StudentDAO {
	int insertStudent(Student student);
	Student selectStudent(int num);
	List<Student> selectStudentList();
	

}
