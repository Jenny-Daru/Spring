package site.itwill06.oop;


//	�ٽɰ��ɸ�� : �ٽɰ����ڵ�θ� �ۼ��� �޼ҵ尡 ����� Ŭ����

//AOP�� Ⱦ�ܰ��� , �ٽɰ��� �ΰ����� �ڵ带 �����ش�.
// => �޼ҵ�,Ŭ������ ���� ���� ��� (��ü������ ����)
// => Ⱦ�ܰ����ڵ�� �и��ؼ� �������!!!
//�������̽��� �߻�޼ҵ带 �������̵� �����Ͽ� �ٽɰ����ڵ� �ۼ�
public class AopOne implements AopInterface {
	@Override
	public void display1() {
//		Ⱦ�ܰ����ڵ� : �α�,����,Ʈ������,����ó�� ���� �����ϱ� ���� ���
//					   �޼ҵ��� ��ɰ� ������ ���۵ɼ� �ֵ��� ����� ���   ex.�� ȸ������ �߱���~  
//		System.out.println("######### �޼ҵ� ��� ���� �� ��ϵ� ���� ######### ");
//		�ٽɰ����ڵ�(Core) : �޼ҵ�� ����� �����ϱ� ���� �ݵ�� �ʿ��� ��� ex.ȸ�����Ը��
		System.out.println("*** AopOne Ŭ������ display1()�޼ҵ��� ��� ���� ***");
	}

	@Override
	public void display2() {
//		System.out.println("######### �޼ҵ� ��� ���� �� ��ϵ� ���� ######### ");
		System.out.println("*** AopOne Ŭ������ display1()�޼ҵ��� ��� ���� ***");
	}

	@Override
	public void display3() {
//		System.out.println("######### �޼ҵ� ��� ���� �� ��ϵ� ���� ######### ");
		System.out.println("*** AopOne Ŭ������ display1()�޼ҵ��� ��� ���� ***");
	}
	

}
