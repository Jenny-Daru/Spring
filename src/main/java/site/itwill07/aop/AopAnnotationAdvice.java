package site.itwill07.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
//@Aspect : Spring Bean���� ��ϵ� Ŭ������ Aspect ����� �����ϱ� ���� ������̼� >> �갡 �־�� ���ӵ� ������̼����� ��� ����
//           => Bean Configuration File�� aspect ������Ʈ�� ������ ������ ����
@Aspect
public class AopAnnotationAdvice {
	private static final Logger logger=LoggerFactory.getLogger(AopAnnotationAdvice.class);
	
//	@Pointcut : PointCut�� �����ϱ� ���� ������̼�  >> �ٸ� Ŭ������ �����Ͽ��� ������! 
//				 => Bean Configuration File�� pointCut ������Ʈ�� ������ ������ ����	
//	     		 => pointCut ������ ���� ������ ���� ����
//				 => �޼ҵ��� �Ű������� PointCut ���������� �νĵǾ� �޼ҵ� ȣ�� ���·� PointCut ������ ���
//				 => �ٸ� Ŭ������ PointCut������ ����
	
//	value�Ӽ� : PointCut������ ���� ����(execution,within)�� �Ӽ������� ����
//				=> �ٸ� �Ӽ��� ���� ��� �Ӽ����� ���� ����
	@Pointcut("within(site.itwill07.aop.AopAnnotationBean)")
	public void aopPointCut() {}
	
//	Aspect ����� ����
//	@Before : Before Advice�޼ҵ带 �����ϴ� ������̼�
//			   => Bean Configuration File�� before ������Ʈ�� ������ ���� ����
//	value�Ӽ� : PointCut������ ���� ����(execution,within)�� �Ӽ������� ����
//	 			=> value�Ӽ������� @Pointcut ������̼��� �޼ҵ带 ȣ���Ͽ� ���
//	@Before(value = "within(site.itwill07.aop.AopAnnotationBean)")
	@Before("aopPointCut()")
	public void beforeLog() {
		logger.info("[Before]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
	}
	
//	@AfterReturning : afterRrturining Advice�޼ҵ带 �����ϴ� ������̼�
//			          => Bean Configuration File�� afterRrturining ������Ʈ�� ������ ���� ����
//				      => value�Ӽ��� ��� pointcut �Ӽ� ��� ���� 
//	returning �Ӽ� : target�޼ҵ��� ��ȯ���� �����ϱ� ���� �Ű��������� �Ӽ������� ����
	@AfterReturning(pointcut = "aopPointCut()", returning = "object")
	public void afterRrturiningLog(Object object) {
		logger.info("[AfterRrturiningLog]�ٽɰ����ڵ� ���� ���� �� ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
		
	}
	
//	@AfterThrowing : AfterThrowing Advice�޼ҵ带 �����ϴ� ������̼�
//			          => Bean Configuration File�� AfterThrowing ������Ʈ�� ������ ���� ����
//				      => value�Ӽ��� ��� pointcut �Ӽ� ��� ���� 
//	throwing �Ӽ� : target�޼ҵ��� ��ȯ���� �����ϱ� ���� �Ű��������� �Ӽ������� ����
//	@AfterThrowing(pointcut = "aopPointCut()", throwing = "exception")
	@AfterThrowing(pointcut = "aopPointCut()", throwing = "exception")
	public void afterThrowingLog(Exception exception) {
		logger.info("[AfterThrowing]�ٽɰ����ڵ忡�� ���� �߻� �� ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
		
	}
	
//	@After : After Advice�޼ҵ带 �����ϴ� ������̼�
//    => Bean Configuration File�� After ������Ʈ�� ������ ���� ����
//	@After(pointcut = "aopPointCut()", throwing = "exception")
	@After("aopPointCut()")
	public void afterLog() {
	logger.info("[After]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
	
	}
	
//	@@Around : Around Advice�޼ҵ带 �����ϴ� ������̼�
//  => Bean Configuration File�� Around ������Ʈ�� ������ ���� ����
	@Around("aopPointCut()")
	public Object aroundLog(ProceedingJoinPoint joinPoint) throws Throwable {
	logger.info("[Around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
	
	Object object=joinPoint.proceed(); 
	
	logger.info("[Around]�ٽɰ����ڵ� ���� �� ���ԵǾ� ����Ǵ� Ⱦ�ܰ����ڵ�");
	
	return object;
	
	}	

}











