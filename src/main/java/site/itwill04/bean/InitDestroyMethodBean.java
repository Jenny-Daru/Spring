package site.itwill04.bean;

public class InitDestroyMethodBean {
	public InitDestroyMethodBean() {
		System.out.println("�ڡڡ� InitDestroyMethodBean() Ŭ������ �⺻ ������ ȣ�� �ڡڡ�");
	}
	
//	�ν��Ͻ� ���� �� �ʱ�ȭ �۾��� ���� �ѹ��� ȣ���ϱ� ���� �޼ҵ� ~ ~ �� ����ϰ� �ʹ�.
	public void init() {
		System.out.println("�ܡܡ� InitDestoryMethodBean�� init() �޼ҵ� ȣ�� �ܡܡ�");
	}
	
//	�ν��Ͻ� �Ҹ� �� ���� �۾��� ���� �ѹ��� ȣ���ϱ� ���� �޼ҵ� ~ ~ �� ����ϰ� �ʹ�.
	public void destroy() {
		System.out.println("�ܡܡ� InitDestoryMethodBean�� destroy() �޼ҵ� ȣ�� �ܡܡ�");
	}
	
	public void display() {
		System.out.println("�ܡܡ� InitDestoryMethodBean�� display() �޼ҵ� ȣ�� �ܡܡ�");
	}

}
