package site.itwill07.aop;

//�ٽɰ��ɸ��
public class ExecutionTimeBean {
//	�ٽɰ��ɸ���� �ٽ��ڵ�(�޼ҵ�) - �� �޼ҵ尡 ����ɶ� �ɸ��� �ð�
	public void run() {
//		for�� 20��� ����!
		int count=0;
		for(int i=1; i<=2000000000; i++ ) {
			count++;
		}
		System.out.println("count = "+count);
	}
}
