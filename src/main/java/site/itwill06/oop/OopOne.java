package site.itwill06.oop;

public class OopOne {
//	�ߺ��� �ڵ� �ּ�ȭ �ϴ� ���
//	�޼ҵ��� �ߺ��� �ڵ尡 ������ ��� : �ߺ��Ǵ� �ڵ尡 �ۼ��� �޼ҵ带 �����Ͽ� ȣ���Ͽ� ��� 
//	 => �ߺ��ڵ带 �ּ�ȭ�Ͽ� ���������� ȿ���� ����
	/*
	public void beforeLog() {
		System.out.println("######### �޼ҵ� ��� ���� �� ��ϵ� ���� ######### ");
	}
	*/
	
//	OopOne�� OopLogger�� is a, has a�� �ƴѰ���!! ���輳���� �� �� ���µ� �ߺ��� �ڵ带 �ּ�ȭ�ϱ� ���ؼ� �Ϻη� �ξ��� ����
//	 => ��ü������ �⺻���� ���踦 �����, ��ü�������� ���� ���°��� ������!!! 
//	 => ��ü������ ���踦 �α����� ������ �����ؾ��� 
//	 => AOP�� ����ϸ� �ߺ��� �ڵ带 �ּ�ȭ�ϰ�, ��ü���� ������ �������� �ʰ� �ۼ��ϴ� ���!!
	private OopLogger logger=new OopLogger();
	
	public void display1() {
//		System.out.println("######### �޼ҵ� ��� ���� �� ��ϵ� ���� ######### ");
		logger.beforeLog();
		System.out.println("*** OopOne Ŭ������ display1()�޼ҵ��� ��� ���� ***");
	}
	
	public void display2() {
//		System.out.println("######### �޼ҵ� ��� ���� �� ��ϵ� ���� ######### ");
		logger.beforeLog();
		System.out.println("*** OopOne Ŭ������ display2()�޼ҵ��� ��� ���� ***");
	}	
	
	public void display3() {
//		System.out.println("######### �޼ҵ� ��� ���� �� ��ϵ� ���� ######### ");
		logger.beforeLog();
		System.out.println("*** OopOne Ŭ������ display3()�޼ҵ��� ��� ���� ***");
	}	
	
}
