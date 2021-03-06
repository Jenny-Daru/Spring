package site.itwill10.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

//입력값이 저장되는 필드에 유효성 검사 관련 어노테이션을 사용하여 처리 
public class Hewon {
//	@NotEmpty : 입력값 존재를 검사하는 어노테이션 / id가 비어있으면 안되요 ~ 
//				 => 에러 발생시 어노테이션이 제공하는 기본 메세지 전달
//				 => message 속성을 이용하여 전달 메세지 설정 가능
	@NotEmpty(message = "아이디 꼬옥 입력해조")
//	@Size : 입력값 길이를 검사하기 위한 어노테이션
//			min속성 : 최소길이
//			max속성 : 최대길이
	//@Size(min = 6, max = 20, message = "아이디는 최소 6자 이상! 최대 20자 이하! 입력해랑")
//	@Pattern() : 입력값 패턴을 검사하는 어노테이션 - ★단독으로 사용하는 것을 권장★ >> 다른거랑 겹쳐서 이상해짐 
	@Pattern(regexp = "^[a-zA-Z]\\w{5,19}$", message = "아이디좀 형식에 맞게 입력쫌 뷰탁행")
	private String id;
	
	@Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[~!@#$%^&*_-]).{6,20}$", message = "비밀번호 형식에 맞게 입력쫌 뷰탁행")
	private String pw;
	
	@Pattern(regexp = "^[가-힣]{2,10}$", message = "이름 형식에 맞게 입력쫌 뷰탁행")
	private String name;
	
	@NotEmpty(message = "이메일 꼬옥 입력해조")
//	@Email : 이메일의 입력값을 검사하는 어노테이션
	@Email(message = "이메일을 형식에 맞게 입력쫌 뷰탁행")
	private String email;
	
	@NotEmpty(message = "성별을 선택해 쥬세용")
	private String gender;
	
	public Hewon() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
