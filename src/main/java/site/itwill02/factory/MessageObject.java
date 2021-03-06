package site.itwill02.factory;

//값을 처리하는 기능(메소드)을 제공하는 클래스가 상속받아야 되는 인터페이스
// => 클래스에서 반드시 선언해야 되는 메소드를 추상메소드 제공 (규칙제공)
// => 인터페이스를 상속받은 자식클래스는 모든 추상메소드를 무조건 오버라이드 선언해야함

// 인터페이스를 이용하면 자식 인스턴스를 저장하여 인스턴스의 메소드 호출 - 오버라이드에 의한 다형성 
// => 결합도를 낮추는 방법, 클래스는 강제성이 없기 때문에 인터페이스 사용
public interface MessageObject {
	String getMessage();

}
