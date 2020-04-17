package site.itwill10.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

//���� �ٿ�ε� ����� �����ϴ� Ŭ����
// => �� Ŭ������ Spring Bean�� �Ƿ��� �ΰ��� ���� 1) @Component ������̼�  2) Bean������Ʈ ���
// => ������̼� ��� ���� servlet-context.xml���� scan���� util��Ű���� ������  �׷��Ƿ� ������Ʈ ����Ͽ� Spring Bean��� 

// => Bean Configuration File �Ǵ� ������̼�(@Conponent)�� �̿��Ͽ� Spring Bean���� ���
// BeanNameViewResolver�� ���� ����Ǵ� Spring Bean�� Ŭ������ �ݵ�� AbstractView�� ��ӹ޾� �ۼ�
// => renderMergedOutputModel() �޼ҵ带 �������̵� ���� : BeanNameViewResolver �� ���� ȣ��Ǵ� �޼ҵ�
//     >> ��ġ ���α׷� �����Ͽ� ��ġ�����ϵ��� ���� �� ���α׷� ������ �ۼ�(�츮�� ���Ұ�...��� ����)
public class FileDownload extends AbstractView {

//	Ŭ���̾�Ʈ�� ������ ���� ����(MimeType) ���� - �ٿ�ε� ����� �����ϴ�  ������������ ���� �ʰ� �ٿ�ε� �ϼ���?
	public FileDownload() {
//		AbstractView.setContentType(String mimiType) : ���������� �����ϴ� �޼ҵ� , Ŭ���̾�Ʈ���� �̰� ���״ϱ� �ʰ� �˾Ƽ� ������
		setContentType("application/download;UTF-8");
	}

	
//	BeanNameViewResolver �� ���� �ڵ� ȣ��Ǵ� �޼ҵ� ���̰��� �߿��
//	 => model �Ű������� ��ûó�� �޼ҵ忡�� ��ȯ�Ǵ� ModelAndView �ν��Ͻ��� Model ���� �ڵ����� ����
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {
//		���⿡ ���� �ٿ�ε� ��� �ۼ� 
//		��ûó�� �޼ҵ忡�� �����Ǵ� �ٿ�ε� ���������� ��ȯ�޾� ����
		Map<String, String> fileInfo=(Map<String, String>)model.get("downloadFile");
		
//		�ٿ�ε� ���� ������ ��ȯ�޾� ���� (3��)
		String uploadDirPath=fileInfo.get("uploadDirPath");
		String uploadFilename=fileInfo.get("uploadFilename");
		String originFilename=fileInfo.get("originFilename");
		
//		�ٿ�ε� ���������� �̿��Ͽ� File �ν��Ͻ� ����
		File downloadFile=new File(uploadDirPath,uploadFilename);
		
//		Ŭ���̾�Ʈ���� ������ �����ϱ� ���� �������� ���� (body�� �������� ������ �̰Թ���!! ��� head��������)??
		response.setContentType(getContentType());
		response.setContentLength((int)downloadFile.length());
		
//		Ŭ���̾�Ʈ���� �ٿ�ε� ���ϸ�� ���۹���� �����Ͽ� Ŭ���̾�Ʈ���� ���� 
//		 => �տ��� �ٿ�ε� ���ϸ��� �ú��ʸ� �̿��Ͽ����Ƿ� �״�� �����ϸ�ȵ���
		response.setHeader("Content-Disposition", "attachment;filename=\""+originFilename+"\";");
		
//		Ŭ���̾�Ʈ���� ���� �����͸� �����ϱ� ���� ��½�Ʈ�� ��ȯ�޾� ����
		OutputStream out=response.getOutputStream();
		
		FileInputStream in=null;
		
		try {
//			�ٿ�ε� ������ ���õ����ͷ� �б� ���� �Է½�Ʈ�� ����
			in=new FileInputStream(downloadFile);
			
//			�Է½�Ʈ��(����)���� ���õ�����(Ŭ���̾�Ʈ���� ����� ��Ʈ��ũ output Stream)�� �о� ��½�Ʈ������ ���� - �ٿ�ε�
			/*
			while(true) {
				int readByte=in.read();
				if(readByte==-1) break;
				out.write(readByte);
			}
			*/
			
//			Spring���� �����ϴ� FileCopyUtils Ŭ������ copy() �޼ҵ带 ȣ���Ͽ� ���� ���� 
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














