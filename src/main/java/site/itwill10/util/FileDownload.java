package site.itwill10.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//파일 다운로드 기능을 제공하는 클래스
// => 이 클래스가 Spring Bean이 되려면 두가지 존재 1) @Component 어노테이션  2) Bean엘리먼트 사용
// => 어노테이션 사용 못함 servlet-context.xml에서 scan설정 util패키지는 안해쥼  그러므로 엘리먼트 사용하여 Spring Bean등록 

// => Bean Configuration File 또는 어노테이션(@Conponent)을 이용하여 Spring Bean으로 등록
// BeanNameViewResolver에 의해 실행되는 Spring Bean의 클래스는 반드시 AbstractView를 상속받아 작성
// => renderMergedOutputModel() 메소드를 오버라이드 선언 : BeanNameViewResolver 에 의해 호출되는 메소드
//     >> 설치 프로그램 실행하여 설치가능하도록 설정 및 프로그램 실행명령 작성(우리는 안할고...어렵 구찮)
public class FileDownload extends AbstractView {

//	클라이언트에 응답할 파일 형식(MimeType) 변경 - 다운로드 기능을 제공하는  내가제공해준 파일 너가 다운로드 하세요?
	public FileDownload() {
//		AbstractView.setContentType(String mimiType) : 파일형식을 변경하는 메소드 , 클라이언트한테 이거 줄테니까 너가 알아서 실행해
		setContentType("application/download;UTF-8");
	}

	
//	BeanNameViewResolver 에 의해 자동 호출되는 메소드 ★이것이 중요★
//	 => model 매개변수에 요청처리 메소드에서 반환되는 ModelAndView 인스턴스의 Model 정보 자동으로 전달
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		여기에 파일 다운로드 기능 작성 
//		요청처리 메소드에서 제공되는 다운로드 파일정보를 반환받아 저장
		Map<String, String> fileInfo=(Map<String, String>)model.get("downloadFile");
		
//		다운로드 파일 정보를 반환받아 저장 (3개)
		String uploadDirPath=fileInfo.get("uploadDirPath");
		String uploadFilename=fileInfo.get("uploadFilename");
		String originFilename=fileInfo.get("originFilename");
		
//		다운로드 파일정보를 이용하여 File 인스턴스 생성
		File downloadFile=new File(uploadDirPath,uploadFilename);
		
//		클라이언트에게 파일을 전달하기 위한 응답정보 변경 (body에 응답결과가 가지만 이게뭐다!! 라는 head정보변경)??
		response.setContentType(getContentType());
		response.setContentLength((int)downloadFile.length());
		
//		클라이언트에게 다운로드 파일명과 전송방식을 변경하여 클라이언트에게 전달 
//		 => 앞에서 다운로드 파일명을 시분초를 이용하였으므로 그대로 전달하면안되지
		response.setHeader("Content-Disposition", "attachment;filename=\""+originFilename+"\";");
		
//		클라이언트에게 원시 데이터를 전달하기 위한 출력스트림 반환받아 저장
		OutputStream out=response.getOutputStream();
		
		FileInputStream in=null;
		
		try {
//			다운로드 파일을 원시데이터로 읽기 위한 입력스트림 생성
			in=new FileInputStream(downloadFile);
			
//			입력스트림(서버)에서 원시데이터(클라이언트에게 연결된 네트워크 output Stream)를 읽어 출력스트림으로 전달 - 다운로드
			/*
			while(true) {
				int readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			*/
			
//			Spring에서 제공하는 FileCopyUtils 클래스의 copy() 메소드를 호출하여 파일 복사 
			FileCopyUtils.copy(in, out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (Exception e2) {
			}
		}
	}
	

}














