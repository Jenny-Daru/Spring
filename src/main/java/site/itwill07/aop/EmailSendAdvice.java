package site.itwill07.aop;

import org.aspectj.lang.JoinPoint;

//�̸��� ���۰��� �޼���(���) ����� �����ϴ� Ŭ���� - Ⱦ�ܰ��ɸ��
public class EmailSendAdvice {
//	�̸��� ������(�ٽɰ����ڵ���� ��)�� ����� ����� ������ �޼ҵ� - Before Advice �޼ҵ�
//	 => target�޼ҵ��� �Ű��������� JoinPoint �ν��Ͻ��� �����޾� �޼��� ó��
	public void beforeMessage(JoinPoint joinPoint) {
// 		target�޼ҵ忡 ���� ������ ������ => JoinPoint, target�޼ҵ忡 ���� ������ �Ű������� �������ֿ�		
//		target�޼ҵ��� ù��° �Ű������� ���� ������ ���� 
		String email=(String)joinPoint.getArgs()[0];
		String subject=(String)joinPoint.getArgs()[1];
		
//		���� Logger�̿��ؾ��ϴ��� �� sys�̿�
//		~ �Կ���(�޴»�� �̸����ּ�) ������ �����ϲ��� ��� �����ʹ�. 
		System.out.println("[Message]<"+email+">�Կ���! <"+subject+">������ �̸����� �����ϲ����.");
	}
	
	
//	�̸��� ������ ������ ��� ����� ����� ������ �޼ҵ� - After-Returning �޼ҵ� 
//	 => target�޼ҵ��� ��ȯ���� �Ű�����(xml�� returning�Ӽ���)�� �����޾� �޼��� ó��
	public void successMessage(String email) {
//		��� 1) Joinpoint�� �̿��Ͽ� target�޼ҵ��� ������ ��������
//		��� 2) �޴� ����� �̸����ּҸ� ��ȯ�ϰ� ������� ������ �Ű������� ����ǰ� �ϱ� 
		System.out.println("[Message]<"+email+">�Կ��� �̸����� �߰�����.");
		
	}
	
	
//	�̸��� ������ ������ ��� ����� ����� ������ �޼ҵ� - After-Throwing �޼ҵ�
//	 => target�޼ҵ忡�� �߻��� ���� �ν��Ͻ��� �Ű������� �����޾� �޼��� ó��
	public void failMessage(Exception exception) {
//		����ó�� ���
		System.out.println("[Error]�̸��� ���۽��п���...WHY??"+exception.getMessage());
		
	}

}








