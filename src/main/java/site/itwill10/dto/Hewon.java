package site.itwill10.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//�Է°��� ����Ǵ� �ʵ忡 ��ȿ�� �˻� ���� ������̼��� ����Ͽ� ó�� 
public class Hewon {
//	@NotEmpty : �Է°� ���縦 �˻��ϴ� ������̼� / id�� ��������� �ȵǿ� ~ 
//				 => ���� �߻��� ������̼��� �����ϴ� �⺻ �޼��� ����
//				 => message �Ӽ��� �̿��Ͽ� ���� �޼��� ���� ����
	@NotEmpty(message = "���̵� ���� �Է�����")
//	@Size : �Է°� ���̸� �˻��ϱ� ���� ������̼�
//			min�Ӽ� : �ּұ���
//			max�Ӽ� : �ִ����
	//@Size(min = 6, max = 20, message = "���̵�� �ּ� 6�� �̻�! �ִ� 20�� ����! �Է��ض�")
//	@Pattern() : �Է°� ������ �˻��ϴ� ������̼� - �ڴܵ����� ����ϴ� ���� ����� >> �ٸ��Ŷ� ���ļ� �̻����� 
	@Pattern(regexp = "^[a-zA-Z]\\w{5,19}$", message = "���̵��� ���Ŀ� �°� �Է��� ��Ź��")
	private String id;
	
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$", message = "��й�ȣ ���Ŀ� �°� �Է��� ��Ź��")
	private String pw;
	
	@Pattern(regexp = "^[��-�R]{2,10}$", message = "�̸� ���Ŀ� �°� �Է��� ��Ź��")
	private String name;
	
	@NotEmpty(message = "�̸��� ���� �Է�����")
//	@Email : �̸����� �Է°��� �˻��ϴ� ������̼�
	@Email(message = "�̸����� ���Ŀ� �°� �Է��� ��Ź��")
	private String email;
	
	@NotEmpty(message = "������ ������ �꼼��")
	private String gender;
	
	public Hewon() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
