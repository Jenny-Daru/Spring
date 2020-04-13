package site.itwill04.bean;

//�̱��� ������ ������ �����Ͽ� �ۼ��� Ŭ����, �� �̱��� Ŭ����
// �̱��� ��� ���� : ���α׷��� �ν��Ͻ��� �ϳ��� �����ϰ� ���� ��쿡 ���

//Ŭ������ ����Ͽ� �ν��Ͻ� ��� ���������� , ������ �ִ� ������ �Ȱ��� ��� �ν��Ͻ��� �ϳ��� �ʿ��ϹǷ� �̱������� �ۼ� 
//DAOŬ����ó�� �޼ҵ常 ������ ���� ��� ���α׷��� �޼ҵ� ȣ���� ���� �ν��Ͻ� �ϳ��� �ʿ� => �޸� ȿ�� ����

public class FactoryMethodBean {
	private static FactoryMethodBean _bean;
	
	private FactoryMethodBean() {
		System.out.println("�ڡڡ� FactoryMethodBean Ŭ������ �⺻ ������ ȣ�� �ڡڡ�");
	}
	
	static {
		_bean=new FactoryMethodBean();
	}
	
	public static FactoryMethodBean getFactoryMethodBean() {
		System.out.println("�ܡܡ� FactoryMethodBean Ŭ������ getFactoryMethodBean() �޼ҵ� ȣ�� �ܡܡ�");
		return _bean;
	}

}
