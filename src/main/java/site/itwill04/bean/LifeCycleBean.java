package site.itwill04.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class LifeCycleBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, ResourceLoaderAware,
										ApplicationEventPublisherAware, MessageSourceAware, ApplicationContextAware,
										InitializingBean, DisposableBean {
	public LifeCycleBean() {
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ �⺻ ������ ȣ�� �ڡڡ�");
	}
	
	public void display() {
		System.out.println("�ܡܡ� LifeCycleBean Ŭ������ display() �޼ҵ� ȣ�� �ܡܡ�");
	}

	@Override
//	�ʱ�ȭ �۾��� ���� �����̳ʰ� �ڵ�ȣ��(�Ű��������� BeanName���� ��)
	public void setBeanName(String name) {
//		XML�� �����ϴ� BeanName�� ������ ����
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ setBeanName �޼ҵ� ȣ�� �ڡڡ�");
//		System.out.println("name = "+name);
		
		
	}

	@Override
	//  Ŭ���� �δ��� �Ű������� ���� ������
	public void setBeanClassLoader(ClassLoader classLoader) {
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ setBeanClassLoader �޼ҵ� ȣ�� �ڡڡ�");
		
	}

	@Override
	//���������� ������ִ� �ν��Ͻ�
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ setBeanFactory �޼ҵ� ȣ�� �ڡڡ�");
		
	}

	@Override
	public void setResourceLoader(ResourceLoader resourceLoader) {
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ setResourceLoader �޼ҵ� ȣ�� �ڡڡ�");
		
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ setApplicationEventPublisher �޼ҵ� ȣ�� �ڡڡ�");
		
	}

	@Override
	public void setMessageSource(MessageSource messageSource) {
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ setMessageSource �޼ҵ� ȣ�� �ڡڡ�");
		
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ setApplicationContext �޼ҵ� ȣ�� �ڡڡ�");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ afterPropertiesSet �޼ҵ� ȣ�� �ڡڡ�");
		
	}
	
//	3/24 ����
	public void initMethod() {
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ initMethod �޼ҵ� ȣ�� �ڡڡ�");
		
	}

//	������ �����̳ʰ� ���ŵǸ� ���ŵǱ��� ������ �ִ� ��� ������ ���� �Ҹ��ϴµ� ������ �������۾��� �갡����
	@Override
	public void destroy() throws Exception {
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ destroy �޼ҵ� ȣ�� �ڡڡ�");
		
	}

	public void destroyMethod() throws Exception {
		System.out.println("�ڡڡ� LifeCycleBean Ŭ������ destroyMethod �޼ҵ� ȣ�� �ڡڡ�");
		
	}


}












