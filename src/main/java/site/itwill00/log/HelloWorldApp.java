package site.itwill00.log;

public class HelloWorldApp {
//	ȣ������ �ʾƵ� JVM�� ���� �˾Ƽ� ȣ���
//	Java�� Ŭ������ �ν��Ͻ��� ����� �� �ν��Ͻ��� �޼ҵ带 ȣ���Ͽ� ���ϴ� ����� ����ϸ� �װ��� �� 
	public static void main(String[] arg) {
//		�޼ҵ尡 ���۵ǰ� ����Ǵ°��� ��� >> ���������� �������� ������ >> 
		System.out.println("HelloWorldApp Ŭ������ main �޼ҵ� - ����");
		HelloWorld hw=new HelloWorld();
		
		String message = hw.hello("�޴ٷ�");
		System.out.println("message = "+message);
		System.out.println("HelloWorldApp Ŭ������ main �޼ҵ� - ����");
	}

}
