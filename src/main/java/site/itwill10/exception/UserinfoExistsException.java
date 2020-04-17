package site.itwill10.exception;

import site.itwill10.dto.Userinfo;

//ȸ���� ����ڰ� �Է��� ���̵� �̹� ������ ��� �߻��Ǵ� ����Ŭ���� 
//���������� �ߺ����� �˻� �ص� ������� 
public class UserinfoExistsException extends Exception {

	private static final long serialVersionUID = 1L;
	
//	Exception�� ���� ó������ �ʰ� ExceptionHandler���� ó�� �ֱ�
	
//	ExceptionHandler(����ó���޼ҵ�) ���� ���� �߻� ���� ������ �����ϱ� ���� �ʵ�
//	�޼����� �Բ� �Է��������� userinfo ������ �����ϱ����� 
	private Userinfo userinfo;
	
	public UserinfoExistsException() {
		// TODO Auto-generated constructor stub
	}
	
	
//	ExceptionHandler���� ����� ������ ���ܸ޼����� ���� => ExceptionHandler�� ����ó���� �������� ����, ����ڿ��� view���� 
	public UserinfoExistsException(Userinfo userinfo, String message) {
		super(message);
		this.userinfo = userinfo;
	}

	public UserinfoExistsException(Userinfo userinfo) {
		super();
		this.userinfo = userinfo;
	}


	public Userinfo getUserinfo() {
		return userinfo;
	}


	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	

}
