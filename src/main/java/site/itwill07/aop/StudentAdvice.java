package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//Ⱦ�ܰ��ɸ�� : Ⱦ�ܰ����ڵ�� �ۼ��� �޼ҵ尡 ����� Ŭ���� - Advice Ŭ����(�ٽɰ��ɿ� ���ԵǾ�� Advice Ŭ������ �Ҹ���)
public class StudentAdvice {
	
//	����� Log4j�̿�
//	�Ŭ������ ���� ������ ����ҰŴ�? StudentAdvice��!
	private static final Logger logger=LoggerFactory.getLogger(StudentAdvice.class);
	
//	before �޼ҵ� : target�޼ҵ� ���� �� ���Ե� �ڵ带 �ۼ��ϱ� ���� �޼ҵ�
	public void beforeLog() {
		logger.info("[before]�ٽɰ����ڵ� ������ ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
//	���𰡰� �Ͼ�� ��ĥ�� �ֱ� ������ �����ڵ鿡�� ���� �߿��ϰ�, �� ����⸦ �����ϸ� �� ���� �������� ������Ʈ ����
//	���α׷� ����� ���ܰ� �߻� >> ����ó�� ���(try~catch~finally)�� ���� ������ �Ѵ�
//	afterReturning : try , ��������忡�� �߿�(LogFile)
//	 afterThrowing : catch
//	         after : finally

//	afterReturning �޼ҵ� : target�޼ҵ��� �������� ���� �� ���Ե� �ڵ带 �ۼ��ϱ� ���� �޼ҵ�
	public void afterReturningLog() {
		logger.info("[after-returning]�ٽɰ����ڵ��� �������� ���� ��(try) ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
//	afterThrowing �޼ҵ� : target�޼ҵ� ����� ���ܰ� �߻��� ��� ���Ե� �ڵ带 �ۼ��ϱ� ���� �޼ҵ�
	public void afterThrowingLog() {
		logger.info("[after-throwing]�ٽɰ����ڵ� ����� ���ܰ�(catch) �߻��� ��� ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
	}	
	
//	after �޼ҵ� : target�޼ҵ� ���� �� ���Ե� �ڵ带 �ۼ��ϱ� ���� �޼ҵ�
	public void afterLog() {
		logger.info("[after]�ٽɰ����ڵ� ���� �� ������(finally) ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
//	JoinPoint : arround >> ��ȯ�� void ���Ұ�, Object��� ���� >> �Ű����� ProceedingJoinPoint ����
	
//	Around Advice �޼ҵ� : target�޼ҵ� ���� �� �Ǵ� ���� �� ���Ե� �ڵ带 �ۼ��ϱ� ���� �޼ҵ�
//						   ��ȯ�� => Object Ÿ�� // �ڸŰ�����(�ʼ�)�� => ProceedingJoinPoint Ÿ������ ���� // Throwable����(������ �θ�) �߻� - ���α׷����� �߻��ϴ� ��� ���� ó��
//							>>  WHY?? Ÿ�ٸ޼ҵ尡 ��ȯ�ϴ� �ڷ����� ���� �𸣱� ����
//	 ProceedingJoinPoint : target�޼ҵ忡 ���� ������ �����ϴ� �ν��Ͻ�
//						   Spring Container�� ���� �ν��Ͻ��� ���޹޾� �Ű������� �ڵ� ����
	public Object arround(ProceedingJoinPoint joinPoint) throws Throwable {
//		�����������̳�(Aspect)�� ȣ������°� �ƴϰ� �����ڰ� �Ű������� �̿��Ͽ� target�޼ҵ带 ȣ���ؾ��� 
		logger.info("[arround]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
		
//		target�޼ҵ� ȣ��(ProceedingJoinPoint�� ȣ��)
//		ProceedingJoinPoint.proceed() : target�޼ҵ带 ȣ���ϴ� �޼ҵ�
//										target�޼ҵ��� ��ȯ���� �����޾� ����  >> ���尪 ��ȯ
//										target�޼ҵ忡�� �߻��Ǵ� ���� ó��    >> target�޼ҵ嵵 �𸣴µ� � ���ܰ� �߻��ϴ����� ��~ ���Ѱ� throwó��
		Object object=joinPoint.proceed();
		
		logger.info("[arround]�ٽɰ����ڵ� ���� �Ŀ� ���ԵǾ� ���۵Ǵ� Ⱦ�ܰ����ڵ�");
		
		return object;
	}
}

















