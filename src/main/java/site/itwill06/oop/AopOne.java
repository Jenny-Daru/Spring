package site.itwill06.oop;


//	핵심관심모듈 : 핵심관심코드로만 작성된 메소드가 선언된 클래스

//AOP는 횡단관심 , 핵심관심 두가지로 코드를 나눠준다.
// => 메소드,클래스로 따로 만들어서 사용 (객체지향을 위반)
// => 횡단관심코드는 분리해서 사용하자!!!
//인터페이스의 추상메소드를 오버라이드 선언하여 핵심관심코드 작성
public class AopOne implements AopInterface {
	@Override
	public void display1() {
//		횡단관심코드 : 로그,보안,트랜젝션,예외처리 등을 구현하기 위한 명령
//					   메소드의 기능과 별개로 동작될수 있도록 만드는 명령   ex.너 회원가입 했구나~  
//		System.out.println("######### 메소드 명령 실행 전 기록될 내용 ######### ");
//		핵심관심코드(Core) : 메소드로 기능을 제공하기 위해 반드시 필요한 명령 ex.회원가입명령
		System.out.println("*** AopOne 클래스의 display1()메소드의 명령 실행 ***");
	}

	@Override
	public void display2() {
//		System.out.println("######### 메소드 명령 실행 전 기록될 내용 ######### ");
		System.out.println("*** AopOne 클래스의 display1()메소드의 명령 실행 ***");
	}

	@Override
	public void display3() {
//		System.out.println("######### 메소드 명령 실행 전 기록될 내용 ######### ");
		System.out.println("*** AopOne 클래스의 display1()메소드의 명령 실행 ***");
	}
	

}
