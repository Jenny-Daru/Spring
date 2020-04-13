package site.itwill04.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

//�ν��Ͻ��� �ʵ带 ���鶧 name�� ���� �������� �ʾ� name���� null
//Ư���� ������ Ŭ���� => �������̽�, Ŭ���� ��ӹ޾� ��� ���� 

//BeanFactoryPostProcessor �������̽��� ��ӹ޾� �ۼ��� Ŭ����
// => postProcessBeanFactory() �޼ҵ� �������̵� ����

// Spring Container�� ���� Spring Bean ���� �� postProcessBeanFactory() �޼ҵ� �ڵ�ȣ�� => �ʱ�ȭ �۾�
// : ConfigurableListableBeanFactory �ν��Ͻ��� �Ű������� ���޹޾� getBean() �޼ҵ�� �ٸ� Spring Bean�� ��ȯ�Ͽ� �ʱ�ȭ �۾�
// : �ٸ� Spring Bean�� �ʵ尪�� ���� Ŭ������ �ʵ尪 ����
public class FactoryPostProcessorBeanTwo implements BeanFactoryPostProcessor {
	private String name;
	
	public FactoryPostProcessorBeanTwo() {
		System.out.println("�ڡڡ� FactoryPostProcessorBeanTwo Ŭ������ �⺻ ������ �ڡڡ�");
//		name="��ٷ�";

	}
	
	public void display() {
		System.out.println("�ܡܡ� FactoryPostProcessorBeanTwo Ŭ������ display() �޼ҵ� ȣ�� �ܡܡ�");
		System.out.println("FactoryPostProcessorBeanTwo Ŭ������ name �ʵ尪 =  "+name);
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("�ܡܡ� FactoryPostProcessorBeanTwo Ŭ������ postProcessBeanFactory() �޼ҵ� ȣ�� �ܡܡ�");
		FactoryPostProcessorBeanOne bean=(FactoryPostProcessorBeanOne)beanFactory.getBean("factoryPostProcessorBeanOne");
		name=bean.getName();
	}	
}











