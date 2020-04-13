package site.itwill03.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container�� �̿��Ͽ� �ν��Ͻ��� �����޾� ���
// => �ν��Ͻ� ����, ���, �Ҹ� LifeCycle�� ���� 
// => �����ڰ� �ƴ� Spring Container�� �ν��Ͻ��� �����Ͽ� ���� - IoC

// ��Ŭ�� >> Spring Bean Configuration File(XML)�� �̿��Ͽ� �ν��Ͻ� ������ ����(����)�� ���� ����
//  => src/main/resources �����ȿ� �ۼ� (xml)
public class MessagePrintApp {
	public static void main(String[] args) {
		
		/*
		[IOC�� �ƴ� �����ڰ� ���� �ν��Ͻ� ������ ���輳��]
		HelloMessageObject object=new HelloMessageObject();
		MessagePrint print=new MessagePrint();
//		���԰��� ����
		print.setObject(object);
		print.messagePrint();
		*/
		
//		xml ���� �ۼ� ��
//		ApplicationContext �ν��Ͻ� ���� - Spring Container
//		 => Spring Bean Configuration File(XML)�� �о� Spring Bean ����
//		��� �������̽��� �ν��Ͻ� ��������!! �긦 ��ӹ޴� �ڽĵ��� �̴� ����
//		ClassPath : Ŭ������ ���� ������ ���丮 => src/main�ΰ��� ���� 
		ApplicationContext context = new ClassPathXmlApplicationContext("03_message.xml");
		
//		Spring Container�� ���� Spring Bean�� �����޾� ����
//		 => bean ������Ʈ�� ������(messagePrint�� ������� ������Ʈ�� �ּ���)�� �����Ͽ� ��ȯ
//		Spring Container�� ������ �ϴ� ���̾ƴ϶� �ʿ��� ���� ������ ����
		MessagePrint print=(MessagePrint)context.getBean("messagePrint");
		print.messagePrint();
		
//		Spring Container ����
		((ClassPathXmlApplicationContext)context).close();
		
		
	}

}





