package site.itwill04.bean;

public class FactoryPostProcessorBeanOne {
	private String name;
	
	public FactoryPostProcessorBeanOne() {
		System.out.println("�ڡڡ� FactoryPostProcessorBeanOne Ŭ������ �⺻ ������ �ڡڡ�");
//		name="��ٷ�";
//		name="�ٷ���";
	}
	
	public void display() {
		System.out.println("�ܡܡ� FactoryPostProcessorBeanOne Ŭ������ display() �޼ҵ� ȣ�� �ܡܡ�");
		System.out.println("FactoryPostProcessorBeanOne Ŭ������ name �ʵ尪 =  "+name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
