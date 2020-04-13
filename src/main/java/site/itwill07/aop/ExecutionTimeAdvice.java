package site.itwill07.aop;

import java.sql.Timestamp;

import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StopWatch;

//Ⱦ�ܰ����ڵ带 ������ �ִ� AdviceŬ����
public class ExecutionTimeAdvice {
	private static final Logger logger=LoggerFactory.getLogger(ExecutionTimeAdvice.class);
	
//	target�޼ҵ��� ����� ����Ǵ� ó���ð�(m)�� ����Ͽ� ����ϱ� ���� �޼ҵ� >> target�޼ҵ� �������� �������� ����� ����ؾ���
//	 => Around Advice�޼ҵ�
	public Object timeWatch(ProceedingJoinPoint joinPoint) throws Throwable {
//		run�޼ҵ� ȣ���� �ð� ����  / target�޼ҵ� ������ �ð� ���� => TimeStamp �ð� Ȱ�� => ����� logger
//		�ٽɰ����ڵ尡 ����ǵ��� ��� �� ó�� 
		
//		target�޼ҵ��� ��� ���� �� �ý����� ���� �ð�����(TimeStamp)�� ��ȯ�޾� ����
//		1)DateŬ���� 
//		2)currenctTimeŬ����
		
		/*
//		��� 1) Java���� �����ϴ� SystemŬ���� ��� 
		long startTime=System.currentTimeMillis();
		
//		target�޼ҵ��� ��� ����
		Object object=joinPoint.proceed();
		
//		target�޼ҵ� ���� �� �ý����� ���� �ð�����(StopStamp)�� ��ȯ�޾� ����
		long stopTime=System.currentTimeMillis();
		
		logger.info("����ð� = "+(stopTime-startTime)+"ms �ɷ����!");
		
		return object;
		*/
		
//		��� 2) SpringFramework���� �����ϴ� StopWatchŬ���� ��� 
//		�ٸ� �����忡 ������ ���� �ʰ� �����ϴ� ���
//		 => bean���� �̸������ ������ ����ϴ°� �� ����
//		StopWatch : �ð��� �����ϱ� ���� ����� �����ϴ� Ŭ����
		StopWatch stopWatch=new StopWatch();
		
//		StopWatch.start() : �ð� ���� ���� �޼ҵ�
		stopWatch.start();
		
		Object object=joinPoint.proceed();
		
//		stopWatch.stop() : �ð� ���� ���� �޼ҵ�
		stopWatch.stop();
		
		logger.info("����ð� = "+stopWatch.getTotalTimeMillis()+"ms �ɷ����!");
		
		return object;
		
		/* ������
		Timestamp timestamp1=new Timestamp(System.currentTimeMillis());
		long time1=timestamp1.getTime();
		logger.info("target�޼ҵ� ���� �� �ɸ��ð��³���?="+time1);
		
		Object object=joinPoint.proceed();
		
		Timestamp timestamp2=new Timestamp(System.currentTimeMillis());
		logger.info("target�޼ҵ� ���� �� �ɸ��ð��³���?="+timestamp2.getTime());
		
		System.out.println("[�� �ɸ��ð�] = ");
		
		return object;
		*/
		
	}

}








