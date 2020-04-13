package site.itwill04.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

//BeanPostProcessor �������̽��� ��ӹ��� Ŭ����
// => �ٸ� Ŭ������ ���� Spring Bean �ʱ�ȭ �۾��� �����ϱ� ���� �޼ҵ带 �������̵� ����(�ʱ�ȭ �۾��� ���������� �� �� ����)
// => Bean Configuration File�� ����� ��� Ŭ������ ���� �ʱ�ȭ �۾�
public class postProcessorBean implements BeanPostProcessor{
	public postProcessorBean() {
		System.out.println("�ڡڡ� postProcessorBean Ŭ������ �⺻ ������ ȣ�� �ڡڡ�");
	}
	
//	Spring Container�� ���� ����κ��� ��������
//	��� Ŭ������ �������� �ʱ�ȭ �۾� ���� 
//	InitializingBean �������̽��� afterPropertiesSet() �޼ҵ� ȣ�� �� �ڵ� ȣ�� 
	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("�ڡڡ� postProcessorBean Ŭ������ postProcessBeforeInitialization()�޼ҵ� ȣ�� �ڡڡ�");
		return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
	}
	
//	InitializingBean �������̽��� afterPropertiesSet() �޼ҵ� ȣ�� �� �ڵ� ȣ�� 
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("�ڡڡ� postProcessorBean Ŭ������ postProcessAfterInitialization()�޼ҵ� ȣ�� �ڡڡ�");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}
	
//	Ȯ���� ���� xml�� �߰� => id�ʿ���� �������� �̱⶧��

}
