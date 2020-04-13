package site.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//�α� ����ϰ� ������ log4j.xml�� root������Ʈ���� priority�� warn => info�� �����ϸ� �α���� ���� 
// => info���� ������ ���� ������ �ȵ�... DEBUG �ع����� ������ ���� ����� ���Ƽ� ���� �������� ���� �ּ� info��! 
// => log4.xml�� logger������Ʈ�� ����Ͽ� �߰��ϸ� console�� �αױ���� ����~~~~~~ 

public class Log4jHelloWorld {
	private static final Logger logger = LoggerFactory.getLogger(Log4jHelloWorld.class);

	public String hello(String name) {
		logger.info("����");
		String message=name+"�� �ȳ��ϼ���.";
		logger.info("����");
		return message;
	}
}
