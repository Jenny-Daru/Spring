package site.itwill00.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jHelloWorldApp {
//	Logger : �α� ���α׷��� ����� �����ϱ� ���� �ν��Ͻ�
//	LoggerFactory.getLogger(Class<?> clazz) : �޸𸮿� ����� Ŭ����(Clazz)�� �̿��Ͽ� ����� �����ϱ� ���� Logger �ν��Ͻ��� �����Ͽ� ��ȯ�ϴ� �޼ҵ�
	private static final Logger logger = LoggerFactory.getLogger(Log4jHelloWorldApp.class);
//	���� ����� �������� ����!!
	
	public static void main(String[] args) {
//		���⼭ info�� ����Ͽ� ����� �����ؾ���
//		Logger.info(String message) : �α��̺�Ʈ�� �߻��Ͽ� �޼����� �����ϴ� �޼ҵ�
//		info������ �α��̺�Ʈ�� �߻����Ѽ� �̷� �޼����� �����ϰڴ�!!
		logger.info("����");
		Log4jHelloWorld hw=new Log4jHelloWorld();
		String message=hw.hello("�޴ٷ�");
		System.out.println("message = "+message);
		logger.info("����");
		
	}
}
