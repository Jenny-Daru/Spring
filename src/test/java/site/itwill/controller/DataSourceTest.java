package site.itwill.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

//�����ͼҽ��� ����� �߸�������� Ȯ��(test���α׷� ���)�ؾ� ����!!! �� �Ŀ� DAO �ۼ�  
//������ �ҽ�, SqlSessionFactory�� SqlSession�� �׽�Ʈ ���� ���� 
// => ��ServiceŬ���� �޼ҵ带 �׽�Ʈ�� ���� ��� 
// => �̰��� �ߵǾ��ٸ� ����� ����(DAO,DataSource,SqlSessionFactory,SqlSession��)���� �� �ߵȰ��̴�~~��

//@RunWith : �׽�Ʈ Ŭ������ �����ϱ� ���� Ŭ����(Clazz)�� �����ϴ� ������̼� 
//			  >> �� �׽�Ʈ Ŭ������ ��ɷ� �����ұ��???��� ����°� 
//SpringJUnit4ClassRunner : JUnit ����� �̿��Ͽ� �׽�Ʈ Ŭ������ �����ϴ� Runner(�θ� Interface)Ŭ���� 
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration : �׽�Ʈ Ŭ�������� ����ϱ� ���� Spring Bean�� ����ϴ� Bean Configuration File�� �����ϴ� ������̼�
//						   => ApplicationContext ��ü(Spring Container)�� �̿��Ͽ� Spring Bean�� ����
// 							  �����ø����̼� ���ؽ�Ʈ�� �ƴϰ� ���ø����̼� ���ؽ�Ʈ�� ���ؽ�Ʈ�� �����ϴ� ��� �ڿ��� ���� ���� ��, ��� ���丮 �о���̱� ����
//						   locations �Ӽ� : Bean Configuration File ��θ� �迭 ������ �Ӽ������� ���� 
//											 => �迭Ÿ���� �����ϴµ�!! �ڹ迭Ÿ���� [] �ƴ� {} ��üŸ������ ����
//											 => Bean Configuration File ��δ� file ���λ縦 ����Ͽ� ����
//												���ø����̼� ���ؽ�Ʈ�� ������ �о� TEST���α׷� �ȿ��� Spring Bean �������ش�.
//											    src: ������Ʈ �����ȿ�!
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"} )
public class DataSourceTest {
//	��κ� �׽�Ʈ ���α׷��� ���� �α״� logger�̿�
//	file�� �о���̸� ������ �ҽ��� ��������µ� �޶�� �ϸ��
	private static final Logger logger=LoggerFactory.getLogger(DataSourceTest.class);
	
//	���Ͽ� ������ �ҽ��� ��������� @Qualifier�̿�
//	DataSource ���� Ŭ������ Spring Bean�� �����޾� �ʵ忡 ������ ó��
	@Autowired
	private DataSource dataSource;
	
//	�׽�Ʈ �޼ҵ� �ۼ�
//	@Test : �׽�Ʈ �޼ҵ带 �����ϴ� ������̼� 
//			 => Runner Ŭ������ ���� ȣ��Ǿ� ����Ǵ� �޼ҵ� ����
//				������ main�� ������, main�� �ٸ����� Test�޼ҵ� ������ �ۼ� ����!! >> RunnerŬ������ �޼ҵ带 �ڵ�ȣ��Ǿ� ��ɽ���(Test����) 
//	         => ���� : Ctrl + F11 >> JUnit�� �����ϱ� 
	@Test
	public void testDataSource() throws SQLException {
		logger.info("DataSource = "+dataSource);
		logger.info("Connection = "+dataSource.getConnection());
	}
	
//	���̹�Ƽ�� �̿�� SqlSessionFactoryBean �̳� SqlSession�� �� �̿�Ǵ��� Ȯ���غ��� 
//	 >> �ʵ� �� ����� ������ ���Ѽ� �޼ҵ� �ۼ� �� �����ϸ� �� 
}















