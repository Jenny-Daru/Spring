package site.itwill10.exception;

//ȸ������ �˻��� ���̵��� ȸ�������� �������� ���� ��� �߻��Ǵ� ���� Ŭ����  
// Mapper���� ���̵� ���޹޾� ȸ�������� �˻��ϴµ� �ش� ȸ���� �˻����� ������� �߻� => ������ �˻��̳� ������ �˻��� ���
public class UserinfoNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UserinfoNotFoundException() {
	}
	
	public UserinfoNotFoundException(String message) {
		super(message);
	}	
	

}
