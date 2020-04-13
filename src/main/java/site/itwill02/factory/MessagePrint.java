package site.itwill02.factory;

public class MessagePrint {
	public void messagePrint() {
//		FactoryŬ�����κ��� �ν��Ͻ��� �����޾� ���� - IOC
//		 => �������̽��� ��ӹ��� �ڽ��ν��Ͻ��� ��ȯ
		MessageObject object=MessageObjectFactory.getFactory().getMessageObject();
		
//		�������̽��� �̿��Ͽ� �޼ҵ带 ȣ���� ��� �ڽ� �ν��Ͻ��� �޼ҵ� ȣ��
//		 => ��ü�� ����ȯ, �������̵忡 ���� ������
		String message=object.getMessage();
		System.out.println("message : "+message);
	}

}
