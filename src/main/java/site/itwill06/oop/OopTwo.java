package site.itwill06.oop;

public class OopTwo {
	/*
	public void beforeLog() {
		System.out.println("######### �޼ҵ� ��� ���� �� ��ϵ� ���� ######### ");
	}
	*/
	
	private OopLogger logger=new OopLogger();
	
	public void display1() {
		logger.beforeLog();
//		System.out.println("######### �޼ҵ� ��� ���� �� ��ϵ� ���� ######### ");
		System.out.println("*** OopTwo Ŭ������ display1()�޼ҵ��� ��� ���� ***");
	}
	
	public void display2() {
		logger.beforeLog();
//		System.out.println("######### �޼ҵ� ��� ���� �� ��ϵ� ���� ######### ");
		System.out.println("*** OopTwo Ŭ������ display2()�޼ҵ��� ��� ���� ***");
	}	
	
	public void display3() {
		logger.beforeLog();
//		System.out.println("######### �޼ҵ� ��� ���� �� ��ϵ� ���� ######### ");
		System.out.println("*** OopTwo Ŭ������ display3()�޼ҵ��� ��� ���� ***");
	}
}
