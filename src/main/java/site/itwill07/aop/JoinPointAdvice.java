package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

//advice�޼ҵ� 
public class JoinPointAdvice {
//	[ JoinPoint ] 
	
//	Around Advice �޼ҵ� ��ȯ�� => Object Ÿ������ ����, ProceedingJoinPoint �Ű������� �̿��Ͽ� �޼ҵ� ����
//								=> target�޼ҵ忡�� �߻��Ǵ� ���ܸ� Throwable Ÿ������ �����Ͽ� ���� ó��     >>  Proceeding�� ȣ���� �� �߻��Ǵ� �����̱� ����  
	
//	Before, After, After-Returning, After-Throwing�� Advice�޼ҵ� ��ȯ�� => void, �Ű����� ���� ����
//	=> JoinPoint�� Advice�޼ҵ忡 ���� �ٸ� �ڷ����� �Ű������� ���� 
//	=> Around Advice�޼ҵ带 ������ �ٸ� Advice �޼ҵ�� ��JoinPoint �ڷ����� �Ű������� �����
//	=> ����� �Ű��������� Spring Container�� ���� �ν��Ͻ��� �ڵ� ����
	
//	JoinPoint : Ÿ�� �޼ҵ��� ������ �����ϴ� �ν��Ͻ�
//				=> Advice �޼ҵ忡�� target�޼ҵ� ������ �̿��Ͽ� Ⱦ�ܰ����ڵ� �ۼ�
//				=> ProceedingJoinPoint �ν��Ͻ��� target�޼ҵ� ȣ�� ����
	
//	Before Advice �޼ҵ�
//	joinPoint �Ű������� target�޼ҵ忡 ���� ���� ���� => Ⱦ�ܰ����ڵ� �޼ҵ忡�� ���, ������ ������ ����ϴ°�!!!
//	Ⱦ�ܰ����ڵ忡�� �ٽɰ����ڵ��� target�޼ҵ� ������ ������ ����Ѵٸ� JoinPoint��� 
	public void displayTarget(JoinPoint joinPoint) {
		/*
//		�� �Ŭ�������� ��޼ҵ带 ȣ���� �� � ���ܰ� �߻��ߴ��� �˷��� JoinPoint ����ؾ��� ��
//		System.out.println("[before]�ٽɰ����ڵ� ���� ���� ���ԵǾ� ���۵� ��Ⱦ�ܡڰ����ڵ�");
		
//		JoinPoint.getTarget() : Object��ȯ, target�޼ҵ带 ȣ���ϴ� �ٽɰ��ɸ��(�ν��Ͻ�)�� ��ȯ�޼ҵ�  >> target�޼ҵ�� JoinPoint�� ȣ���ϰ� �ִ�. App����
//		    Object.getClass() : �ٽɰ��ɸ��(�ν��Ͻ�)�� Ŭ����(Clazz)�� ��ȯ�ϴ� �޼ҵ�
//		      Class.getName() : Ŭ����(Clazz)�� ��Ű���� ������ Ŭ�������� ��ȯ�ϴ� �޼ҵ�
//		target�޼ҵ尡 ����� Ŭ������ ������???
//		System.out.println(joinPoint.getTarget().getClass().getName());
		String className=joinPoint.getTarget().getClass().getSimpleName();
		
//		JoinPoint.getSignature() : target�޼ҵ��� ����(Signature�ν��Ͻ�)�� ��ȯ�ϴ� �޼ҵ�
//		Signature.getName() : target�޼ҵ��� �̸��� ��ȯ�ϴ� �޼ҵ�
		String methodName=joinPoint.getSignature().getName();
		System.out.println("[before]"+className+"Ŭ������ "+methodName+" �޼ҵ� ȣ���̿�");
		*/
		
//		joinPoint.getArgs() : target�޼ҵ��� �Ű������� Object �迭�� ��ȯ�ϴ� �޼ҵ� >> target�޼ҵ��� �ڷ����� �޼ҵ� ������ �𸣴� Object�迭�� �޾������
		String className=joinPoint.getTarget().getClass().getSimpleName();
		String methodName=joinPoint.getSignature().getName();
		Object[] objects=joinPoint.getArgs();
//		Ÿ�ٸ޼ҵ忡 ���� ������ ������ Ⱦ�ܰ��ɸ�⿡�� ����Ϸ��� ����Ѵ�!!! >> �Ű������� ���޵� ���� �̿��Ͽ� ��ȿ���˻� ���� 
		System.out.println("[before]"+className+"Ŭ������ "+methodName+" �޼ҵ��� �Ű����� ���� = "+objects.length);
		
	}
	
//	After Returning Advice �޼ҵ� => ���������� ����� �� ���۵Ǵ� �޼ҵ�
//	�α�,����� ��쿡 ���� ���
//	 => Object Ÿ���� �Ű������� �����Ͽ� target�޼ҵ��� ��ȯ���� ���޹޾� ����
//	 => target�޼ҵ��� ��ȯ���� �������� ���� ��� �Ű������� Object Ÿ������ ����
	public void displayName(Object object) {
//		System.out.println("[after-returning]�ٽɰ����ڵ� ���� ���� �� ���Ե� Ⱦ�ܰ����ڵ�");
		
//		[�ٽɰ����ڵ��� ��ȯ���� Ⱦ�ܰ����ڵ尡 ���޹޾� ����ϴ� ���]
//		��ȯ���� ���� ���ڿ��� ��� >> ��ȯ���� �� ���ڿ��� ��ȯ�Ͽ� ����
		if(object instanceof String) {
			String name=(String)object;
			System.out.println("[after-returning]"+name+"��, �氡�袾");
		}
	}
	
//	After Throwing Advice �޼ҵ�
//	����ó���� ���� ���� ���(�����/������)
//	 => �Ű������� �����Ͽ� target�޼ҵ��� ���������� ���޹޾� ����
//	 => target�޼ҵ��� ���ܸ� �������� ���� ��� �Ű������� Exception Ÿ������ ����
	public void displayException(Exception exception) {
//		System.out.println("[after-Throwing]�ٽɰ����ڵ� ���� �� ���ܰ� �߻��� ��� ���ԵǾ� ���ߵ� Ⱦ�ܰ����ڵ�");
//		�Ŭ������ ��޼ҵ忡�� ����ܰ� �߻��Ǿ����� ������°� ������ => JoinPoint����ؾ��ϴµ� ����ܴ� JoinPoint�� �����
//		 => target�޼ҵ尡 � ���ܰ� �߻����� �������ϴϱ� exception ��� >> �ڵ尡 ��������ʰ� ���ܹ߻� >> exception�� Container�� ���޸�����ϱ� 
//		     >> xml�� aop������Ʈ���� throwing�Ӽ� ����Ͽ� ��Ű������� ������ �ּ���~ ����  
		System.out.println("[after-Throwing] ���ܸ޼����� =>"+exception.getMessage());
		
		
	}
	
	
}















