package site.itwill03.container;

public class MessagePrint {
//	MessageObject �������̽��� ��ӹ��� �ڽ��ν��Ͻ��� �����ϱ� ���� �ʵ�
//	 => ���԰���(���԰��谡 �Ǳ����ؼ��� �ʵ忡 �ν��Ͻ�(�ڽ��ν��Ͻ�)�� ����Ǿ� �־���Ѵ�!!)
//	 => ������ �ʵ忡 null ������ setter �޼ҵ带 ���� ����
	private MessageObject object;

	public MessageObject getObject() {
		return object;
	}

	public void setObject(MessageObject object) {
		this.object = object;
	}
	
	public void messagePrint() {
		String message=object.getMessage();
		System.out.println("message : "+message);
	}


}
