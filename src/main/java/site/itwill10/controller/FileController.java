package site.itwill10.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.multipart.MultipartFile;

import site.itwill10.dto.FileBoard;
import site.itwill10.service.FileBoardService;

@Controller
//ApplicationContextAware �������̽��� ��ӹ޾� Ŭ������ Spring Bean���� ��ϵɶ� setApplicationContext() �޼ҵ带 ȣ���Ͽ� �Ű������� ���ް����� �ʵ� �ʱ�ȭ
// => ApplicationContext �ν��Ͻ��� �Ű������� �����Ͽ� �ʵ尪 ����
// => Spring Bean���� ����Ͽ� ������ó�� ���� ��� �������̽� ���
public class FileController implements ApplicationContextAware {
	
	@Autowired
//	@Autowired �� ����Ͽ� �������Ͽ� �ʱ�ȭ ���� 
	private FileBoardService fileBoardService;
	
//	WebApplicationContext : SpringMVC�� Front Controller���� ����ϱ� ���� Spring Bean�� �����ϱ� ���� Spring Container ���� �ν��Ͻ�
//	web�� ���õ� ��� ��������Ǿ� ����!!! 
//	@Autowired ��� �Ұ� => Spring Bean�� �ƴ� Spring Bean�� �����ϴ� Container�̱� ������ ApplicationContext�� ���氡���ϵ��� �ϴ� �������̽� ApplicationContextAware ���
	
	private WebApplicationContext context;
	
//	Spring bean���� ���� �� �ڵ� ȣ��Ǵ� �޼ҵ� 
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//		�θ� �ڽ����� ��ȯ�Ͽ� ����
//		ApplicationContext �ν��Ͻ��� WebApplicationContext �ν��Ͻ��� �θ� �ν��Ͻ� �̹Ƿ� ��ü ����ȯ�� �ؾ߸� �ʵ忡 ���� ����
		context=(WebApplicationContext)applicationContext;
	}
	
	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String upload() {
		return "file/upload";
	}
/*	
//	��� �Է°��� �������°� �ƴ�!!!!

   <<���� ���ε� ���>>
   [1) ���� �������°� ]  
//	����ġ���� multiFile ���̺귯�� ���
	
//	MultipartHttpServletRequest : "multipart/form-data"�� ���޹��� �Է����ϰ� �Է°��� ó���ϴ� �ν��Ͻ�
	@RequestMapping(value ="/upload", method = RequestMethod.POST)
	public String upload(MultipartHttpServletRequest request) throws IllegalStateException, IOException {
		String uploader=request.getParameter("uploader");
//		MultipartServletRequest.getFile(String name) : �Է������� ���޹޾� MultipartFile �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
//		MultipartFile : �Է����� ������ �����ϱ� ���� �ν��Ͻ� (���������� ���Ѱ͵� ���� ex.���ϸ� , ����ũ��, �������� ��) 
//		�̰� �ߴٰ� ������ ���ε� �Ǵ����� �ƴ�
		MultipartFile uploadFile=request.getFile("uploadFile");
		
//		MultipartFile.getContentType() : �Է����� ����(MimeType)�� ��ȯ�ϴ� �޼ҵ� 
		System.out.println(uploadFile.getContentType());
//		MultipartFile.getBytes() : �Է������� Byte �迭�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ� 
		System.out.println(uploadFile.getBytes().length);
		
//		���ε�ó��
//		MultipartFile.isEmpty() : �Է����� ������ �������� ���� ��� true�� ��ȯ�ϴ� �޼ҵ� 
//								  => �Է����Ͽ� ���� ��ȿ�� �˻� ���� - ��������, ����ũ�� ��
		
//		!uploadFile.getContentType().equals("image/jpeg") : ���ε� ���� ����
//		uploadFile.getBytes().length>3000000 : ���ε� ���� ũ�� 
		if(uploadFile.isEmpty()) { //������ ���Է½� �̵��ϴ� jsp
			return "file/upload_fail";
		}
		
//		�Է������� �����ϱ� ���� ���ε� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDirPath=request.getServletContext().getRealPath("/resources/upload");
		
//		�Է������� ���� ���丮�� �����ϱ� ���� File �ν��Ͻ� ����
		//MultipartFile.getOriginalFilename() : �Է������� �̸��� ��ȯ�ϴ� �޼ҵ� 
//												 =>uploadDirPath��ġ�� "uploadFile.getOriginalFilename()"�� �̸��� ���� 
		File file=new File(uploadDirPath, uploadFile.getOriginalFilename());
		
//		���ε� ó��
//		MultipartFile.transferTo(File file) : �Է������� ���� �ý��ۿ� �����Ͽ� �����ϴ� �޼ҵ�
//      => ������ ������ �̸��� ������ �̹� ������ ��� ������ 
		uploadFile.transferTo(file); 
		
		request.setAttribute("uploader", uploader);
		request.setAttribute("originalFilename", uploadFile.getOriginalFilename());
		
		return "file/upload_ok";
	}
*/
	
//	[2) �Է������� ��û�ϴ� ��� ] - ������ ���ϸ��� �����Ѵٸ� ������� �ʰ� ��Ģ�� �����Ͽ� �ٸ��̸����� ���尡�� 
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
//	������ MultipartFile�� ��ü�� �־�޶�� ��û 
	public String upload(@RequestParam String uploader, @RequestParam MultipartFile uploadFile, Model model) throws IllegalStateException, IOException {

		if(uploadFile.isEmpty()) { 
			return "file/upload_fail";
		}
		
//		�Է������� �����ϱ� ���� ���ε� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
//		WebApplicationContext�� �̸� ����� ���� ������ �׳� ��û�� �ϸ�ǰ� request�� ��û�� ���� �����ϹǷ� �ӵ��� ����
//		WebApplicationContext �ν��Ͻ��� �̿��Ͽ� ������ ���ε� ���丮�� �ý��� ��θ� ��ȯ�޾� ����
		String uploadDirPath=context.getServletContext().getRealPath("/resources/upload");
		
//		������ �Է����ϰ� ������ �̸��� ������ ������ ��� �Է����ϸ��� �����Ͽ� ������ ����ǵ��� ����
		String originalFilename=uploadFile.getOriginalFilename();
		File file=new File(uploadDirPath, originalFilename);
		
//		���� ������ �����ϱ� ���� ���ϸ��� �����ϱ� ���� ���� ���� 
//		 => �ʱⰪ���� �Է����ϸ��� ���� 
		String uploadFilename=originalFilename;
		
//		<< ������ �̸��� �����ϱ� ���� ��Ģ ���� >>
//		������ �Է����ϸ�� ���� �̸��� ������ ������ ��� �Է����ϸ��� ���� - �ݺ�ó��
		int i=1;
		while(file.exists()) {   //���ε� ���� ������ �����Ѵٸ� ������ ���� �̸��� ������ ���� �Ѵٴ� ���!!! 
			int index=originalFilename.lastIndexOf(".");
//			�Է����ϸ� �ڿ� "_����"�� �߰��Ͽ� ����ó�� �� Ȯ���� ���̱� 
			uploadFilename=originalFilename.substring(0, index) +"_"+i+originalFilename.substring(index);
			file=new File(uploadDirPath, uploadFilename);
			i++;
		}
		
		uploadFile.transferTo(file); 

		model.addAttribute("uploader", uploader);
		model.addAttribute("originalFilename", originalFilename);
		model.addAttribute("uploadFilename", uploadFilename);
		
		return "file/upload_ok";
	}
	
	
//	[ ������ �뷮�� Ŭ��� �ڵ����� �뷮�� ���̴� ��� ]
	@RequestMapping(value = "/thumbnail", method = RequestMethod.GET)
	public String thumbnail() {
		return "file/thumbnail";
	}
	
	
	@RequestMapping(value = "/thumbnail", method = RequestMethod.POST)
	public String thumbnail(@RequestParam MultipartFile imageFile, Model model) throws IllegalStateException, IOException {
		if(!imageFile.getContentType().equals("image/jpeg")) {
			return "file/thumbnail_fail";
		}
		
		String uploadDirPath=context.getServletContext().getRealPath("/resources/upload");
		String imageFilename=imageFile.getOriginalFilename();
		File file=new File(uploadDirPath, imageFilename);
		imageFile.transferTo(file);
		
//		���ε� ó���� �̹��� ������ �̿��Ͽ� ����� ���� ���� 
//		1.�̹��� ������ �о� �̹����� �޸𸮿� ����
//		BufferedImage : �̹��� ������ ������ �����ϴ� Ŭ����
//		ImageIO.read(File file) : �̹��� ���� ������ �о� BufferedImage �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ� 
		BufferedImage sourceImage=ImageIO.read(file);
		
//		2.�޸𸮿� ����� �̹����� ũ�⸦ �����Ͽ� ����� �̹��� ���� => ���ϻ����ϴ� ���� �ƴϰ� �޸𸮿� ���� 
//		  => �̹��� ũ�⸦ �����ϱ� ���ؼ��� Spring�̳� JDK�� �̹��� ũ�⸦ �����ϴ� Ŭ������ ������ 
//		     pom.xml�� ���̺귯�� �����Ͽ� ��� 
		
//		Scalr.resize(BufferedImage src, Method scalingMethod, Mode resizeMode, int targetSize) 
//		 : �޸𸮿� ����� �̹����� ũ�⸦ �����ϴ� �޼ҵ� , ���̳� �� ���� �ϳ��� �����Ͽ� �ڵ����� ��ȯ�ǰ� ����
//		   => Scalr.Method.AUTOMATIC : �̹����� �� �Ǵ� ���̸� �ڵ����� ����
//		   => FIT_TO_WIDTH : �̹����� �� ����
		BufferedImage thumbnailImage=Scalr.resize(sourceImage, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_WIDTH, 400);
		
//		3.�޸𸮿� ����� ����� �̹����� �̿��Ͽ� ���� ����
//		  *����* ����� ������ �̸� �����ؾ���
		int index=imageFilename.lastIndexOf(".");
		String thumbnailFilename=imageFilename.substring(0, index)+"_s"+imageFilename.substring(index);
		
		index=thumbnailFilename.lastIndexOf(".");
//		ImageIO.write(RenderedImage im, String formatName, File output) : ����� �̹��� ������ �о� �̹��� ���Ϸ� �����ϴ� �޼ҵ�
		ImageIO.write(thumbnailImage, thumbnailFilename.substring(index+1),new File(uploadDirPath,thumbnailFilename));

		model.addAttribute("imageFilename",imageFilename);
		model.addAttribute("thumbnailFilename",thumbnailFilename);

		return "file/thumbnail_ok";
	}
	
	
//	******************************* DB �����Ͽ� ���� ���ε� �ϴ� ��� **********************************
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.GET)
	public String fileUpload() {
		
		return "file/file_upload"; //���� �Է�������
	}
	
	@RequestMapping(value = "/file_upload", method = RequestMethod.POST)
	public String fileUpload(@ModelAttribute FileBoard fileBoard) throws IllegalStateException, IOException {
//		�Է����Ͽ� ���� ��ȿ�� �˻� - ���İ� ũ�� �� �˻�
		if(fileBoard.getFile().isEmpty()) {
			return "file/file_upload";
		}
		
//		���� ���ε� ó�� - �켱 DB���̺� ������ ������ �����;��� 
//		������ Front Controller �� ���� ���ε� �ǰ� ���� => ���� ���� �Ұ� �� Front Controller ���ؼ��� ���� ����
		String uploadDirPath= context.getServletContext().getRealPath("/WEB-INF/upload");
		
//		�Է����ϸ��� ��ȯ�޾� ����
		String origin=fileBoard.getFile().getOriginalFilename();
//		���ε� ���ϸ��� TimeStamp(����ð��� 1/1000 s ������ ����)�� �̿��Ͽ� ���� => �׷��Ƿ� �ߺ��Ұ� �� �̸��� ���� �������� �˱� �����(���Ȱ�ȭ)
//		 => ���ε� ���ϸ��� �ߺ����� �ʵ��� ���� 
		String upload=System.currentTimeMillis()+"";
		
//		���� ���ε� ó�� (TimpeStamp�� ������ �̸����� ����) 
		fileBoard.getFile().transferTo(new File(uploadDirPath, upload));
		
//		���̺� �����ϱ����� �ʵ尪 ����(Setter�޼ҵ���)
		fileBoard.setOrigin(origin);
		fileBoard.setUpload(upload);
		
//		FILE_BOARD ���̺� ���ϰԽñ� ���� ������ ���� 
		fileBoardService.addFileBoard(fileBoard);
		
//		�����̷�Ʈ �̵�
		return "redirect:/file_list"; 
	}
	
	@RequestMapping(value = "/file_list")
	public String fileList(Model model) {
		model.addAttribute("fileBoardList", fileBoardService.getFileBoardList());
		return "file/file_list";
	}
	
	
	
}












