package site.itwill05.di;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class CollectionBean {
//	�ν��Ͻ��� �����ϴ� ������ �θ�� �ۼ��ϴ� ���� ���� => ���������� ��~~~������
	private List<String> nameList;
	private Set<String> nameSet;
//	List�� Login, Logout, List�� �����ϰ�;� => �������̽� ������ (controller)
//	���׸��� �ڷ����� �������̽��� ������ ��� �ڽ� �ν��Ͻ��� �ݷ��� ��ҷ� ���尡��
//	private List<LoginController> controllerList;
	private List<Controller> controllerList;
	
	private Set<Controller> controllerSet;
	
//	Ű�� ���� ����	
	private Map<String, Controller> controllerMap;
	
//	Properties : �ݷ��ǰ� ������ ���, ������ �Ұ� // ������ �о�鿩 load�޼ҵ带 ���� ������ // Ű�� ���� ���尡���� ���� ���ڿ��� ���� 
//				 ���������δ� Map�� �θ� , Map������ ��ü => Map�� ������ �ִ� �޼ҵ� ��� ���� 
	private Properties properties;
	
	public CollectionBean() {
		System.out.println("### CollectionBean Ŭ������ �⺻ ������ ȣ�� ###");
	}

	public List<String> getNameList() {
		return nameList;
	}

	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}

//	Set�� ���� setter,getter
	public Set<String> getNameSet() {
		return nameSet;
	}

	public void setNameSet(Set<String> nameSet) {
		this.nameSet = nameSet;
	}

//	Controller�� ���� setter.getter
	public List<Controller> getControllerList() {
		return controllerList;
	}

	public void setControllerList(List<Controller> controllerList) {
		this.controllerList = controllerList;
	}

	public Set<Controller> getControllerSet() {
		return controllerSet;
	}

	public void setControllerSet(Set<Controller> controllerSet) {
		this.controllerSet = controllerSet;
	}

	
//	controllerMap�� ���� setter,getter

	public Map<String, Controller> getControllerMap() {
		return controllerMap;
	}

	public void setControllerMap(Map<String, Controller> controllerMap) {
		this.controllerMap = controllerMap;
	}

//	properties�� ���� setter,getter
	
	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}
	
	
	
	
	
	
	

}
