package site.itwill10.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import site.itwill10.dao.PointUserDAO;
import site.itwill10.dto.PointUser;

@Service
public class PointUserServiceImpl implements PointUserService {
	
	@Autowired
	private PointUserDAO pointUserDAO;
	
//	����� ������ ���޹޾� POINTUSER���̺� �����ϰ� ����� ����� ������ �˻��Ͽ� ��ȯ�ϴ� �޼ҵ�
	@Override
	public PointUser addPointUser(PointUser user) {
//		���� ����Ǳ����� validation�� �̿��Ͽ� �˻� ���������� DB�� ���õ� �˻�� ���⼭ ���� 
//		���̺� ���� ����Ǿ����� Ȯ��!!   ������������������������ : ��Ʈ�ѷ����� / DB ���� : Service���� �˻�(����ó��)��������������������
//		���޵� ������� ���̵� �ߺ� ������ �˻� - �ߺ��� ��� : ������ ���� �߻� (�츮�� ���� ����??����Ŭ���� ���� ���......)
		if(pointUserDAO.selectPointUser(user.getId())!=null) {
//			�����ϴ� ��� ���� ����Ƴ� ������..
			throw new RuntimeException("�̹� ������� ���̵� ����");
		}
//		���ܰ� �߻��� ��� �ϴܿ� �����ϴ� ��� �̽���
		pointUserDAO.insertPointUser(user);
		return pointUserDAO.selectPointUser(user.getId());
	}

}
