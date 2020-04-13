package site.itwill09.mvc;

import java.util.HashMap;
import java.util.Map;

//Ŭ���̾�Ʈ ��û������ ó�� �ν��Ͻ��� �����ϱ� ���� �ݷ��� �ʵ尡 ����� Ŭ����
// => �������� �ݷ����ʵ� ����Ʈ ��Ʈ�ѷ��� ���� ����Ͽ����� ���� ���� ����Ұ���
public class HandlerMapping {
//	�ݷ��� �ʵ� -   Key : ��û����(String)
//				  value : ó���ν��Ͻ�(Controller) => ó��Ŭ������ Controller�� ��ӹ����ϱ�
	private Map<String, Controller> mapping;
	
	public HandlerMapping() {
//		��ü���� 
		mapping=new HashMap<String, Controller>();
//		Map �ʵ��� �ʱ�ȭ �۾� �޼ҵ� ȣ��
		initConfig();
	}
	
	private void initConfig() {
//		Map�ʵ忡 ������� ��û������ ó���ν��Ͻ��� ����
		mapping.put("/list.itwill", new ListController());
		mapping.put("/view.itwill", new ViewController());
	}
	
//	Ŭ���̾�Ʈ ��û������ ���޹޾� ó�� �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ�
//	 => ����Ʈ ��Ʈ�ѷ����� init�޼ҵ� �ʿ����, ó���޼ҵ嵵 �ʿ����??
	public Controller getController(String command) {
		return mapping.get(command);
		
	}
	
}
