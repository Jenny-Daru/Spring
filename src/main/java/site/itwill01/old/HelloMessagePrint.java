package site.itwill01.old;

//helloMessage�� ����ϴ� �޼ҵ�
// ���ø����̼� �ۼ��� �ʿ��� ����� �����ϱ� ���� Ŭ���� => ���
// => ����� ������ ���ִ� ����ü => ���۳�Ʈ (�پ��� ����� ����)

// DAO���� �߻��ϴ� ���� �������� �ֱ� ������ ���ø����̼ǿ����� DAO�� ������ ������� �ʰ�
//  serviceŬ������ ������ �����!!
//  => ����� �������� ������ ����ó��~~ MVC�����ض� 
public class HelloMessagePrint {
	public void helloMessagePrint() {
		HelloMessageObject hello=new HelloMessageObject();
		String message=hello.getHelloMessage();
		System.out.println("message : "+message);
	}

}

