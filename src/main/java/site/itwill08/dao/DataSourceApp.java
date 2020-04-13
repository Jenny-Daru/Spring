package site.itwill08.dao;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Data Suorce�� ������ Ŭ���� �ۼ�
//Bean Configuraion File�� �о� Spring Bean ���
public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		ApplicationContext context=new ClassPathXmlApplicationContext("08_dao.xml");
		
		System.out.println("========================================================================================");
		
		DataSource apacheDataSource=context.getBean("apacheDataSource", DataSource.class);
		Connection apacheConnection=apacheDataSource.getConnection();
//		SQLException �߻� >> ������ try~catch ������ ���ѱ�� 
		System.out.println("Apache Connection = "+apacheConnection);
		
		System.out.println("========================================================================================");
		
		DataSource springDataSource=context.getBean("springDataSource", DataSource.class);
		Connection springConnection=springDataSource.getConnection();
		System.out.println("Spring Connection = "+springConnection);
		
		
		((ClassPathXmlApplicationContext)context).close();
		
		
	}

}
