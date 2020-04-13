package site.itwill.controller;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import site.itwill10.dto.PointBoard;
import site.itwill10.dto.PointUser;
import site.itwill10.service.PointBoardService;
import site.itwill10.service.PointUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
//@FixMethodOrder : �׽�Ʈ �޼ҵ��� ȣ�� ������ �����ϴ� ������̼� - ex ) ���� �� ������ �˻� ����
//					MethodSorters�Ӽ� : Enum�ڷ���(����ʵ� ������)�� ����ʵ带 �̿��Ͽ� ȣ����� ���� 
//									    =>1.MethodSorters.DEFAULT(�⺻) * ��Ȯ�� ���� �Ұ� - ������� ����Ȯ (�����)*
//										   : �׽�Ʈ �޼ҵ��� HashCode(�޸� �ּҸ� ���� ���� 16���� ���·� �����-����������)�� �̿��Ͽ� ȣ����� ����
//											  >> ���ʴ�� �о�鿩 ȣ��Ǿ� ����, �޸𸮰� �������� ��������� ������ �������� ����� ã�� ����Ǵ� ��� �߻�
//										  2. MethodSorters.JVM : JVM�� �׽�Ʈ �޼ҵ带 �ҷ��� ������� ȣ����� ���� * ���� �Ұ� *
//										  3. MethodSorters.NAME_ASCENDING : �׽�Ʈ �޼ҵ��� �̸��� ������������ �Ͽ� ȣ����� ���� * ��Ȯ�� ���� ���� *
//											  >> �޼ҵ�� ���ĺ� ������ ȣ������� ���ڸ� �ο��Ͽ� ������� ȣ�Ⱑ���ϰ� �ϴ°��� ����!!
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PointBoardServiceTest {
	private static Logger logger=LoggerFactory.getLogger(PointBoardServiceTest.class);
	@Autowired
//	����� ������ �о���̴� �ʵ� ���� - Test����
	private PointUserService pointUserService;
/*
	@Test
	public void testAddPointUser() {
		PointUser user=new PointUser();
		user.setId("Daru");
		user.setName("��ٷ�");
		
//		����� ����� ���� ��ȯ, ���̺� ���� �� �� �Ǿ����� Ȯ��~
		PointUser addUser=pointUserService.addPointUser(user);
//		PointBoardService�޼ҵ� Ȯ���ϱ� ���ؼ��� ����� ������ �ʿ��ϱ� ������ ����ڸ� ���� Ȯ��!!
		logger.info("���̵� = "+addUser.getId()+", �̸� = "+addUser.getName()+", ����Ʈ = "+addUser.getPoint());
		
//		�ѹ����� �� �̹� insert�� ������ ������ ����� �Ѵٸ� ������ ���ܰ� �߻��Ͽ� �ϴ��� ��� ���� ���� 
	}
	*/
	
//	�������� ��¥ Test�ϰ� ������ ����
	@Autowired
	private PointBoardService pointBoardService;
	
	@Test
//	pointBoard�� �Խñ��� �����ϱ� ���� ������� ���񽺸޼ҵ� ȣ���Ͽ� �׽�Ʈ
	public void testAddPointBoard() {
		PointBoard board=new PointBoard();
		board.setWriter("XXX");
		board.setSubject("���� ������~");
		
		PointUser user=pointBoardService.addPointBoard(board);
		logger.info("���̵� = "+user.getId()+", �̸� = "+user.getName()+", ����Ʈ = "+user.getPoint());
		
	}
	
/*
	@Test
//	�Խñ��� ����
	public void testErasePointBoard() {
		PointUser user= pointBoardService.erasePointBoard(1);
		logger.info("���̵� = "+user.getId()+", �̸� = "+user.getName()+", ����Ʈ = "+user.getPoint());
		
	}
	
 */
	@Test
	public void testGetPointBoardList() {
		List<PointBoard> boardList=pointBoardService.getPointBoardList();
		for(PointBoard board:boardList) {
			logger.info("�۹�ȣ = "+board.getNum()+", �ۼ��� = "+board.getWriter()+", ������ = "+board.getSubject());
		}
	}
}



















