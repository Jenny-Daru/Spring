package site.itwill10.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.HtmlUtils;

import site.itwill10.dto.RestBoard;
import site.itwill10.service.RestBoardService;
import site.itwill10.util.Pager;


// REST ����� �����ϴ� ��ûó�� �޼ҵ忡 ���� JSON �������� Ȯ���� ���� Advanced REST Client ũ�Ҿ��� ��ġ�Ͽ� �׽�Ʈ
// => �������� ���帹�� ����ϴ� �׽�Ʈ ���α׷� 

// AJAX ��û�� ���� ȣ��Ǵ� ��ûó�� �޼ҵ��� method �Ӽ��� : RequestMethod(Enum)�� ����ʵ�(��û���) 
// => GET(�˻���ɱ���), POST(�����ɱ���), PUT(��ü ����), PATCH(�κк���), DELETE(����) �� 
@Controller
//@RestController
// : ��� ��ûó�� �޼ҵ��� ��ȯ������ ����ǵ��� �����ϴ� ������̼� 
//   => ��ûó�� �޼ҵ忡�� @ResponseBody ������̼��� ������� �ʾƵ� �޼ҵ� ��ȯ������ ����ó�� 
//   => Restful ����� �����ϴ� ��Ʈ�ѷ� Ŭ������ �ۼ��� ��� ���(����Ʈ ��⿡�� �ʿ��� ���� ���� ���� �����ϴ� ��Ʈ�ѷ��� ���� �� ��� ���� ���)
//      ��ûó�� �޼ҵ尡 ������ ������ ResponseBody�� ��!! ��, ��ûó�� �޼ҵ忡 @ResponseBody�� ������� �ʾƵ���.
//@RestController
public class RestBoardController {
	
	@Autowired
	private RestBoardService restBoardService;
	
	@RequestMapping("/board")
	public String restBoard() {
		return "rest/board";
	}
	
//	�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
//	�Խñ� ����� Ajax�� ��û
//	REST_BOARD ���̺� ����� �Խñ� ����� �˻��Ͽ� JSON ���·� �����ϴ� ��ûó�� �޼ҵ�
//	 => �Խñ� ����� ����¡ ó���Ͽ� ����ǵ��� ����(������ ��ȣ ���޹޴� ���� �߿�) 
//	 => defaultValue = "1"�� ����Ͽ� ��������ȣ�� ���޹��� �ʾƵ� �⺻������ 1�� ���޹޾� �������� ��µǵ��� ����
//	 => �ѰԽñ��� ������ �˾ƾ� ����¡ ó�� ����
	@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	@ResponseBody //�������� �������� ������ , �ڵ����� ��ü�� ��ȯ
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
//		System.out.println("pageNum = "+pageNum);
		
//		REST_BOARD ���̺� ����� �Խñ��� ������ �˻��Ͽ� ��ȯ�޾� ����
		int totalBoard=restBoardService.getRestBoardCount();
		
		int pageSize=5;    //  ���������� �˻��Ǵ� �Խñ��� ������ ���Ƿ� ����
		
		int blockSize=5;   //  ������ ���� ��µ� �������� ������ ���Ƿ� ����
		
		Pager pager=new Pager(pageNum, totalBoard, pageSize, blockSize);
		
//		Service Ŭ������ �޼ҵ�(getRestBoardList�� startRow�� endRow�� �޾� Map�� ����)�� ȣ���ϱ� ���� �Ű������� ���޵� Map ��ü 
		Map<String, Object> pagerMap = new HashMap<String, Object>();
		pagerMap.put("startRow", pager.getStartRow());  // ��û������ ���� ��ȣ 
		pagerMap.put("endRow", pager.getEndRow());      // ��û������ ������ ��ȣ
		
//		��ûó�� �޼ҵ��� ��ȯ������ ���� Map ��ü ����
//		 => �������� Map��ü�� ��Ʈ��(Entry)�� �����Ͽ� ��ȯ - Entry >> JSON(JavaScript ��ü)
		Map<String, Object> returnMap = new HashMap<String, Object>();
//		�ΰ��� �ڹٽ�ũ��Ʈ ��ü , "restBoardList" => �迭��ü / "Pager" => Object��ü
		returnMap.put("restBoardList", restBoardService.getRestBoardList(pagerMap));
		returnMap.put("pager", pager);
		
		return returnMap;
		
	}
	
	
	
//	�Խñ��� ���޹޾� REST_BOARD ���̺� �����ϰ� �������� ���ڿ��� ��ȯ�ϴ� ��ûó�� �޼ҵ�  
//	 => �Ϲ������� ������ ��� POST, �˻��� GET���� ��û 
//	 => �ѱ��� ������ �ʵ��� POST ������� ��û
	@RequestMapping(value = "/board_add", method = RequestMethod.POST)
	@ResponseBody //View�� �ƴ� �޼ҵ尡 ����
//	@RequestBody ������̼��� �̿��Ͽ� JSON ������ �Է°��� Java ��ü�� �ʵ�� ��ȯ�޾� ����
	public String restBoardAdd(@RequestBody RestBoard board) {
//		Xss ���ݿ� ���� ���� �±� ���� ���ڸ� ȸ�� ���ڷ� ��ȯ�Ͽ� ����(ex.���� or ����)
//		 => �±� ��ũ��Ʈ ����, ����ڰ� �Է��� ������ ���ڸ� ����
		board.setContent(HtmlUtils.htmlEscape(board.getContent()));
		restBoardService.addRestBoard(board);
		return "success";
	}
	
	/*
//	�Խñ� ��ȣ�� �ܴ޹޾� REST_TABLE�� ����� �ش� �Խñ��� �˻��Ͽ� JSON ���·� �����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping(value = "/board_view", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@RequestParam int num) {
		return restBoardService.getRestBoard(num);
		
	}
	*/
	
	//�Խñ� ��ȣ�� URL �ּҷ� ���޹޾� REST_BOARD���̺� ����� �ش� �Խñ��� �˻��Ͽ� JSON ���·� �����ϴ� ��ûó�� �޼ҵ� 
	// => ��û �ڿ��� URL �ּҿ� {������}�������� ǥ�� 
	// => @PathBariable ������̼��� �̿��Ͽ� URL �ּҷ� ���޵� ���� �Ű������� ���� ���� 
	//    URL �ּҰ� �ϳ��� data�� �Ǵ°� 
	//��û�ڿ��� ������� �Ű��������� ������ �����ؾ߸� �ϸ� �ٸ� ��� @Pathvariable ������̼��� value �Ӽ������� ��û�ڿ��� ������ ���� ����
	@RequestMapping(value = "/board_view/{num}", method = RequestMethod.GET)
	@ResponseBody
	public RestBoard restBoardView(@PathVariable int num) {
		return restBoardService.getRestBoard(num);
		
	}	
	
	
//	�Խñ��� ���޹޾� REST_BOARD ���̺� ����� �Խñ��� �����ϰ� ����� ���ڿ��� �����ϴ� ��ûó�� �޼ҵ�
//	 => ��û����� ���� ���� ��� method �Ӽ����� {} �ȿ� �����Ͽ� ����
	@RequestMapping(value = "/board_modify", method = {RequestMethod.PUT,RequestMethod.PATCH})
	@ResponseBody
	public String restBoardModify(@RequestBody RestBoard board) {
		restBoardService.modifyRestBoard(board);
		return "success";
	}
	
	
//	�Խñ۹�ȣ�� URL�ּҷ� ���޹޾� REST_BOARD ���̺� ����� �Խñ��� �����ϰ� ����� ���ڿ��� �����ϴ� ��ûó�� �޼ҵ�
	@RequestMapping(value = "/board_remove/{num}", method = RequestMethod.DELETE)
	@ResponseBody
	public String restBoarddelete(@PathVariable int num) {
		restBoardService.removeRestBoard(num);
		return "success";
	}
	

}

































