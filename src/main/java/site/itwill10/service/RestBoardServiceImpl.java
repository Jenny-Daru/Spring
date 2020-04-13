package site.itwill10.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.RestBoardDAO;
import site.itwill10.dto.RestBoard;

// [Ajax�� ����¡ó���� �ٽ�]
@Service
public class RestBoardServiceImpl implements RestBoardService {
	
	@Autowired
	private RestBoardDAO restBoardDAO;

	@Transactional
	@Override
	public void addRestBoard(RestBoard board) {
		restBoardDAO.insertRestBoard(board);
	}

	@Transactional
	@Override
	public void modifyRestBoard(RestBoard board) {
		/* �̰� ������ �ϴ� �ּ�ó��
//		�����ϱ� �� �Խñ� ��ȣ�� �Խñ��� �˻��ϱ�
//		���̺� ����� ������ �̿��Ͽ� ����� SQL ����� ���ް��� ���� ��ȿ�� �˻�
//		 => ���ް��� ���� ���� �߻��� ������ ���� �߻� 
		if(restBoardDAO.selectRestBoard(board.getNum())==null) {
			throw new Exception("�����Ϸ��� �ϴ� �Խñ� ������~");
		}
		*/
		restBoardDAO.updateRestBoard(board);
	}

	@Transactional
	@Override
	public void removeRestBoard(int num) {
		restBoardDAO.deleteRestBoard(num);
	}

	@Override
	public RestBoard getRestBoard(int num) {
		return restBoardDAO.selectRestBoard(num);
	}

	@Override
	public int getRestBoardCount() {
		return restBoardDAO.selectRestBoardCount();
	}

	@Override
	public List<RestBoard> getRestBoardList(Map<String, Object> map) {
		return restBoardDAO.selectRestBoardList(map);
	}

}













