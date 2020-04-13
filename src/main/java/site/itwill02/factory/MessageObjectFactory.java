package site.itwill02.factory;

// Factory ������ ������ ����� Ŭ���� : Factory Ŭ���� �Ǵ� provider Ŭ����
// => �����ڰ� ���ϴ� Ŭ������ ��� �ν��Ͻ��� �����Ͽ� ��ȯ���ִ� Ŭ���� 
// => �̱��� Ŭ������ �ۼ��ϴ� ���� ���� (������ ������ִ� ������ �ϳ��� �־ �Ǵ°�ó��... )
public class MessageObjectFactory {
	public static MessageObjectFactory _factory;
	
	public MessageObjectFactory() {
		// TODO Auto-generated constructor stub
	}
	
	static {
		_factory=new MessageObjectFactory();
	}
	
	public static MessageObjectFactory getFactory() {
		return _factory;
	}

	
//	�����ڰ� ���ϴ� Ŭ������ �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
//	 => �������̽��� ��ȯ������ ������ ��� �ڽ��ν��Ͻ��� ��ȯ 
//  �ν��Ͻ��� �ڽ����� ���������� ������ �θ���� �� 
	
//	static�޼ҵ�� �ص� ��������� �������� ������ => �Ϲݸ޼ҵ�� �ۼ� => �̱��� ��õ
	
	public MessageObject getMessageObject() {
//		�갡 ��ü�� ��� ������� => �̰��� IOC
		//MessageObject object=new HelloMessageObject();
		//MessageObject object=new HiMessageObject();
		MessageObject object=new ByeMessageObject();
		return object;
	}
	
	
}
