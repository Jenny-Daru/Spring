package site.itwill04.bean;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//Spring Container�� Spring Bean�� ����, ���, �Ҹ꿡 ���� �����ֱ�(LifeCycle)�� ����
// => �����ڸ� ����� ���� �ʵ��� �ʱ�ȭ �۾��� ��

// [ Spring Bean ������ ���� �ʱ�ȭ �۾� ���� ]
// 1. ������(Constructor) ȣ�� : �ν��Ͻ��� ������ �� XML ���Ϸκ��� �ν��Ͻ�(��)�� ���޹޾� �ʵ尪 ���� ���� 
//                               ���� ������ => Constructor Injection �� �߿�  ��

// 2.       Setter �޼ҵ� ȣ�� : �ν��Ͻ��� ������ XML ���Ϸκ��� �ν��Ͻ�(��)�� ���޹޾� �ʵ尪 ���� ����  => Setter Injection
//                               �ν��Ͻ��� ��������ڸ��� �����̳ʴ� setter �޼ҵ� ȣ���� (�������� �ƴ�) �� �߿�  ��

// 3. BeanNameAware �������̽��� ��ӹ޾� �������̽��� setBeanName() �޼ҵ� ȣ�� 
//	   : �ν��Ͻ� ���� �� �����̳ʿ��� BeanName�� �����޾� �ʵ尪 ����

// 4. BeanClassLoaderAware �������̽��� setBeanClassLoader() �޼ҵ� ȣ�� 
//     : �ν��Ͻ� ���� �� �����̳ʿ��� BeanClassLoader �ν��Ͻ��� �����޾� �ʵ尪 ����

// 5. BeanFactoryAware �������̽��� setBeanFactory() �޼ҵ� ȣ��
//     : �ν��Ͻ� ���� �� �����̳ʿ��� BeanFactory �ν��Ͻ��� �����޾� �ʵ尪 ����

// 6. ResourceLoaderAware �������̽��� setResourceLoader() �޼ҵ� ȣ��
//	   : �ν��Ͻ� ���� �� �����̳ʿ��� BeanFactory �ν��Ͻ��� �����޾� �ʵ尪 ����

// 7. ApplicationEventPublisherAware �������̽��� setApplicationEventPublisher() �޼ҵ� ȣ��
//     : �ν��Ͻ� ���� �� �����̳ʿ��� ApplicationEventPublisher �ν��Ͻ��� �����޾� �ʵ尪 ����

// 8. MessageSourceAware �������̽��� setMessageSource() �޼ҵ� ȣ��
//	   : �ν��Ͻ� ���� �� �����̳ʿ��� MessageSource �ν��Ͻ��� �����޾� �ʵ尪 ����

// 9. ApplicationContextAware �������̽��� setApplicationContext() �޼ҵ� ȣ�� 
//     : �ν��Ͻ� ���� �� �����̳ʿ��� ApplicationContext �ν��Ͻ��� �����޾� �ʵ尪 ����
//        => �� �߿�  �� - ������ ���(request/response ������� �ʰ� �� �����!������ ���� �޶��ϸ��
//                         ���������� ������ ��� ã���� ��� 

// 10��13�� Ŭ���� �ٽ� �������� => postProcessorBean.java
// 10. BeanPostProcessor �������̽��� postProcessBeforeInitialization() �޼ҵ� ȣ��
//		: �ν��Ͻ� ���� �� �����̳ʿ��� MessageSource �ν��Ͻ��� �����޾� �ʵ尪 ����

// 11. InitializingBean �������̽��� afterPropertiesSet() �޼ҵ� ȣ��
//     : �ν��Ͻ� ���� �� Properties(key,value����/�̸��� ��) ������ �о� �ʵ尪 ����

// 12. bean ������Ʈ�� init-method �Ӽ������� ������ �޼ҵ� ȣ��

// 13. BeanPostProcessor �������̽��� postProcessAfterInitialization() �޼ҵ� ȣ��
//      : �ν��Ͻ� ���� �� �����̳ʿ��� MessageSource �ν��Ͻ��� �����޾� �ʵ尪 ����

//Spring Bean �Ҹ꿡 ���� ������ �۾� ����
// 1. DisposableBean �������̽��� destroy() �޼ҵ� ȣ��
// 2. bean ������Ʈ�� destroy-method �Ӽ������� ������ �޼ҵ� ȣ��

public class LifeCycleBeanApp {
	public static void main(String[] args) {
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");
		
//		���⿡ ������ �����̳� ������� , xml ���� �о� ���ϰ��� 
		ApplicationContext context=new ClassPathXmlApplicationContext("04-2_beanLifeCycle.xml");
		
		System.out.println("=============== Spring Container �ʱ�ȭ �� ===============");

//		�޼ҵ� ȣ���Ұ�
		LifeCycleBean bean=(LifeCycleBean)context.getBean("lifeCycleBean");
		bean.display();
		System.out.println("=============== Spring Container ������ �� ===============");
		((ClassPathXmlApplicationContext)context).close();
		System.out.println("=============== Spring Container ������ �� ===============");

	}

}
