package site.itwill06.oop;

//�ν��Ͻ��� �޼ҵ带 ȣ���� ��� �޼ҵ��� ��� ������ �޼ҵ� ȣ�� �αװ� ��ϵǵ��� ���� 
public class AopApp {
	public static void main(String[] args) {
		/*
		AopOne one=new AopOne();
		AopTwo twp=new AopTwo();
		
		one.display1();
		one.display2();
		one.display3();
		
		twp.display1();
		twp.display2();
		twp.display3();
		*/
		
		AopProxy proxyOne=new AopProxy(new AopOne());
		AopProxy proxyTwo=new AopProxy(new AopTwo());
		
		proxyOne.display1();
		proxyOne.display2();
		proxyOne.display3();
		
		proxyTwo.display1();
		proxyTwo.display2();
		proxyTwo.display3();
		
	}

}
