package site.itwill10.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


//����ó�� �޼ҵ常 ����� Ŭ���� 
// => �ϳ��� Controller�� �ƴ� ��� Controller Ŭ������ ��ûó�� �޼ҵ忡�� �߻��� ����

//@RestController : REST�� �����ϴ� ��Ʈ�ѷ��� ����ó���� �ϱ� ���� ������̼�
//@ControllerAdvice : ����ó�� �޼ҵ常 ����� Ŭ������ ����ϴ� ������̼� , AOP ������ Ⱦ�ܰ��� �ڵ� 
@ControllerAdvice
public class ExceptionController {
	
	@ExceptionHandler(Exception.class)
	public String execeptionHandelr(Exception exception) {
		exception.printStackTrace();
		return "userinfo/user_error";
	}

}
