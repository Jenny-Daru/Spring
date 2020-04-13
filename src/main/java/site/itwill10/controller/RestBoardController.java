package site.itwill10.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import site.itwill10.service.RestBoardService;
import site.itwill10.util.Pager;

@Controller
public class RestBoardController {
	
	@Autowired
	private RestBoardService restBoardService;
	
	@RequestMapping("/board")
	public String restBoard() {
		return "rest/board";
	}
	
//	�ڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡڡ�
//	�Խñ� ����� Ajax�� ��û
//	Ŭ���̾�Ʈ ��û�� ���� �Խñ� ����� JSON ������ ���ڿ��� �����ϴ� ��ûó�� �޼ҵ�
//	 => �Խñ� ����� ����¡ ó���Ͽ� ����ǵ��� ����(������ ��ȣ ���޹޴� ���� �߿�) 
//	 => defaultValue = "1"�� ����Ͽ� ��������ȣ�� ���޹��� �ʾƵ� �⺻������ 1�� ���޹޾� �������� ��µǵ��� ����
//	 => �ѰԽñ��� ������ �˾ƾ� ����¡ ó�� ����
	@RequestMapping(value = "/board_list", method = RequestMethod.GET)
	@ResponseBody //�������� �������� ������ , �ڵ����� ��ü�� ��ȯ
	public Map<String, Object> restBoardList(@RequestParam(defaultValue = "1") int pageNum) {
//		REST_BOARD ���̺� ����� �Խñ��� ������ �˻��Ͽ� ��ȯ�޾� ����
		int totalBoard=restBoardService.getRestBoardCount();
		
//		���������� �˻��Ǵ� �Խñ��� ������ ���Ƿ� ����
		int pageSize=5;
		
//		������ ���� ��µ� �������� ������ ���Ƿ� ����
		int blockSize=5;
		
		Pager pager=new Pager(pageNum, totalBoard, pageSize, blockSize);
		
		return null;
		
	}

}















