package site.itwill06.oop;

//Proxy Ŭ���� : �ٽɰ��ɸ��� Ⱦ�ܰ��ɸ���� �����ϱ� ���� Ŭ���� - Aspect
//				  => �ٽɰ����ڵ忡 Ⱦ�ܰ����ڵ带 ������ �޼ҵ带 ����
//�ٽɰ����ڵ带 �������� Ⱦ�ܰ����ڵ带 �����ϴ� �޼ҵ� �ۼ�
public class AopProxy implements AopInterface {

//	�ٽɰ��� ����� �����ϱ� ���� �ʵ�, AopInterface�� ��ӹ��� �ڽ��ν��Ͻ� ���� ����
	private AopInterface target;

//	Ⱦ�ܰ��� ����� �����ϱ� ���� �ʵ�
	private AopLogger logger;
	
//	�ٽɰ��ɸ��� Ⱦ�ܰ��ɸ���� ���޹޾� �ʵ忡 �����ϴ� ������
	public AopProxy(AopInterface target) {
	this.target = target;
	this.logger=new AopLogger();
}

//	Ⱦ�ܰ����ڵ带 �ٽɰ����ڵ� ���� ������ �޼ҵ� - ���� ��ġ ���� : JoinPoint
//	 => �ٽɰ����ڵ�� Ⱦ�ܰ����ڵ尡 �ϳ��� �̷������, ����ɶ� �������°� Weaving(����)
//	 => weaving�� �޼ҵ���� �����ϴ� Ŭ���� - ProxyŬ����
	@Override
	public void display1() {
//		Ⱦ�ܰ����ڵ�
		logger.beforeLog();
//		�ٽɰ����ڵ�
		target.display1();
	}

	@Override
	public void display2() {
		logger.beforeLog();
		target.display2();
		
	}

	@Override
	public void display3() {
		logger.beforeLog();
		target.display3();
	}

}
