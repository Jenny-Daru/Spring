package site.itwill04.bean;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

//@Component : Ŭ������ Spring Bean���� ����ϴ� ������̼�
//              => Ŭ�������� �ڵ����� beanName���� ���� - ù���ڴ� �ҹ��ڷ� ��ȯ
//			 : value ������̼� �Ӽ������� beanName ���� ����
//				=> �ٸ� �Ӽ��� �������� ���� ��� value Ű���� ���� ���� => beanName�� ���� �Ǿ����� cab�� ������ ���
// bean ������Ʈ�� �Ӽ��� ������ ����� �����ϴ� ������̼� - @Lazy, @Scope

//[@Component�� �� ������� �ʰ�, @Component�� ��ӹ޴� �ٸ� �ڽ� ������̼ǵ��� ���� ���]
//@Repository(DAO), @Service(Service) , @Controller(Controller), => Component�� ��ӹ޴� ������̼� 
@Lazy
@Component(value = "cab")
public class ComponentAnnotationBean {

	public ComponentAnnotationBean() {
		System.out.println("�ڡڡ� ComponentAnnotationBean Ŭ������ �⺻ ������ ȣ�� �ڡڡ�");
	}
	
	public void display() {
		System.out.println("�ܡܡ� ComponentAnnotationBean Ŭ������ display() �޼ҵ� ȣ�� �ܡܡ�");
	}
	
}
