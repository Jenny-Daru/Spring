package site.itwill.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

//** : 0�� �̻� 
//�׽�Ʈ Ŭ���������� ��Ʈ�ѷ��� �˻��ϱ� ���� �������� �ۼ� - �����
// ��Ʈ�ѷ��� �޼ҵ带 MockMvc��ü�� ���� ���������� ��û�Ͽ� �޼ҵ尡 ����� �۵��Ǵ� ��������� ModelAndView�� �� ���޵Ǵ��� Ȯ�� ����

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
//���ϵ� ����(*)�� �̿��Ͽ� Bean Configuration File ���� ����
// => ** ���·� ���丮�� ǥ���ϸ� 0�� �̻����� ó�� , ������ ó���ϴ� ��� 
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class StudentControllerTest {
	private static final Logger logger=LoggerFactory.getLogger(StudentControllerTest.class);
	
//	WebApplicationContext : Web Application���� ����ϴ� Spring Container ����� ��ü
//	 						�޶���ϱ� => @Autowired ������
//	���⿡ �ʵ忡 Spring Bean�� ���� 
//	�ʿ������� => ������ MockMvc ��ü���� �޶�� �ϱ����ؼ� 
	@Autowired
	private WebApplicationContext wac;
	
//	�׽�Ʈ ������ ���� ��ü
//	MockMvc : ��û�� �������� �������� �����ϱ� ���� Ŭ����
//	 		  �� Ŭ������ ��ü�� ������� , �긦 �̿��ϸ� WAS���� ��û�ؼ� ��ûó�� �޼ҵ尡 ȣ��Ǵ� �Ȱ��� ����� �ϴ� Ŭ���� 
	private MockMvc mvc;
	
//	@Before : �׽�Ʈ �޼ҵ� ȣ�� �� ����� ����� �ۼ��ϴ� �޼ҵ忡 �����ϴ� ������̼� 
	//		  �ʱ�ȭ �޼ҵ� ������ �� ��� & ������ ������ ����!!, JUnit�� ������ ����ϱ� 
	@Before
	public void setup() {
//		��û�� �������� �����ϴ� ��ü�� ��ȯ�޾� �ʵ忡 ����
		
//		Ư����Ʈ�ѷ��� �ִ� ��û �޼ҵ常 ��û���� => standaloneSetup(controllers)
//		�����Ʈ�ѷ��� �ִ� ��û ó���޼ҵ� ��û ���� 		
		mvc=MockMvcBuilders.webAppContextSetup(wac).build();
		logger.info("MockMvc ��ü ����");
	}
	
	@Test
	public void testStudentDisplay() throws Exception {
//		MockMvc.perform(ReqeustBuilder requestBuild) : �������� Front Controller���� ���ϴ� ����� ��û�ϴ� �޼ҵ� - ResultActions ��ü ��ȯ
//		MockMvcRequestBuilders.get(String uri) : URL �ּҸ� �����Ͽ� GET������� ��û�ϴ� �޼ҵ� - requestBuild ��ü�� ��ȯ
//		ResultActions.andReturn () : ��ûó�� �޼ҵ��� ȣ�� ���(MvcResult���)�� ��ȯ�ϴ� �޼ҵ�
//		andReturn : ��û �� ����� ��ȯ���꼼��
		MvcResult result=mvc.perform(MockMvcRequestBuilders.get("/student/display")).andReturn();
		logger.info(result.getModelAndView().getViewName());
		logger.info(result.getModelAndView().getModel().toString());
	}

}












