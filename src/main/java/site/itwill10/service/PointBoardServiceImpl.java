package site.itwill10.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.PointBoardDAO;
import site.itwill10.dao.PointUserDAO;
import site.itwill10.dto.PointBoard;
import site.itwill10.dto.PointUser;

//Service Ŭ������ �޼ҵ忡�� ���ܰ� �߻��� ��� ���� �߻� �� ����� ��~~~~�� DAO Ŭ���� �޼ҵ��� SQL���(select �������, INSERT,UPDATE,DELETE)��
// �ڹݵ�á� ROLLBACK ó���ǵ��� �ۼ� => Spring������ Ʈ�������� �ϰ��� �ְ� ó���� �� �ֵ��� TransactionManager ���� Ŭ���� ����
//  => spring-tx���̺귯���� ���(spring-jdbc ���̺귯�� �����ϸ� �ڵ����� �����) 


//PointBoardServiceImpl => �ٽɰ��� �ڵ�
//=> Ⱦ�ܰ��� ��� (adviceŬ���� �����ؾ������� ������ ����. Ʈ������ �Ŵ����� �� ������ �Ұ� !! )
@Service
public class PointBoardServiceImpl implements PointBoardService {
	
	@Autowired
	private PointBoardDAO pointBoardDAO;
	
	@Autowired
	private PointUserDAO pointUserDAO;
	
//	�Խñ� ������ ���޹޾� POINTBOARD ���̺� �����ϰ� �ۼ��� ������ ��ȯ�ϴ� �޼ҵ� 
//	 => �Խñ� �ۼ��ڸ� �����Ͽ� POINTUSER���̺��� ����� ������ ����Ʈ�� �����ǵ��� �ۼ�
//	    �Խñ��� ����Ǹ� ����Ʈ�� �ö󰡰� �� ����Ʈ�� ��� ���!!
	@Transactional
	@Override
	public PointUser addPointBoard(PointBoard board) {
//		�Խñ� ���� �� �ۼ��ڷ� ����ڸ� �˻��ϰ� ����ڰ� ���� ��� - �̻��� ���
		
//		�̸���� ���� ����Ǹ� �������� �ʴ� �ۼ����� �Խñ��� ����� �� �ְ�~ 
//		�׷� �ؿ� ��ɿ��� �������� �ʴ� �ۼ��� �̰�, �ۼ��ڰ� ������ ����Ʈ�� ������ų�� ����!! 
//		 ���� �߻� => �ذ� ) Ʈ������ �Ŵ����� �̿��Ͽ� �ѹ�ó�� 
		pointBoardDAO.insertPointBoard(board);
		if(pointUserDAO.selectPointUser(board.getWriter())==null) {
			throw new RuntimeException("�������� �ʴ� �ۼ��� �Դϴ�!");
		}
		/*
		if(pointUserDAO.selectPointUser(board.getWriter())==null) {
			throw new RuntimeException("�������� �ʴ� �ۼ��� �Դϴ�!");
		}
		*/
		pointUserDAO.updatePointUserPlus(board.getWriter());
		return pointUserDAO.selectPointUser(board.getWriter());
	}

//	�Խñ� ��ȣ�� ���޹޾� POINTBOARD ���̺� ����� �Խñ��� �����ϰ� �ۼ��ڸ� ��ȯ�ϴ� �޼ҵ�
//	 => �Խñ� �ۼ��ڸ� �����Ͽ� POINTUSER���̺� ����� ������� ����Ʈ�� ���ҵǵ��� �ۼ�
//	     �� �޼ҵ� ȣ���ϸ� ��
	@Transactional
	@Override
	public PointUser erasePointBoard(int num) {
//		�Խñ� �ۼ��ڿ� �α����ۼ��� ���ƾ� �����ؾ��� 
		PointBoard board=pointBoardDAO.selectPointBoard(num);
		if(board==null) {
			throw new RuntimeException("�������� �ʴ� �Խñ� �Դϴ�!");
		}
		String writer=pointBoardDAO.selectPointBoard(num).getWriter();
		pointBoardDAO.deletePointBoard(num);
		pointUserDAO.updatePointUserMinus(writer);
		return pointUserDAO.selectPointUser(writer);
	}

//	POINTBOARD ���̺� ����� ��� �Խñ��� �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Override
	public List<PointBoard> getPointBoardList() {
		return pointBoardDAO.selectPointBoardList();
	}

}



















