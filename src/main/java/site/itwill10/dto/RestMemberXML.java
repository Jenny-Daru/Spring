package site.itwill10.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/*
�̸�      ��?       ����            
------- -------- ------------- 
ID      NOT NULL VARCHAR2(20)  
NAME             VARCHAR2(30)  
ADDRESS          VARCHAR2(100) 
*/

//XML�� �����ϴ� JavaBean 

//JavaBean(DTO) ��ü�� ����� ȸ�������� JAXB�� �̿��Ͽ� XML ������ ���ڿ��� �ڵ� ��ȯ�ǵ��� ���� 
// => JAXB ����� JDK ���̺귯������ ���� - JDK1.8 ���Ͽ����� JDK���̺귯������ JAXB ���� (JRE System Library�� �����ϹǷ� Maven�̿����� �ʾƵ� ��밡��)
//                                          JDK9 �̻󿡼��� Maven�� �̿��Ͽ� JAXB ����� �����ϴ� ���̺귯�� �����Ͽ� ���

// @XmlRootElement : XML�� Root ������Ʈ�� �����ϴ� ������̼� ���ʼ���
//					  => name�Ӽ� : Root ������Ʈ�� �̸��� �Ӽ������� ����
//					     name �Ӽ� ���� : Ŭ�������� ������Ʈ �̸����� �ڵ� ����
//                       <member> ȸ��������  </member> �̷� �������� ������!!!

//@XmlAccessorType : �ڽ� ������Ʈ�� �������� �� �������� �����ϴ� ������̼� ���ʼ���
//					  => XmlAccessType Enum �ڷ����� ����ʵ带 �Ӽ������� ����
// 					  => XmlAccessType.FIELD : Ŭ������ �ʵ带 �ڽ� ������Ʈ�� ǥ�� 
//					                           �ʵ�� : ������Ʈ �̸�, �ʵ尪 : ������Ʈ�� ����

//@XmlType : �ڽ� ������Ʈ�� ǥ���ϴ� ����� �����ϴ� ������̼� (����)
//			  => propOrder �Ӽ� : �ڽ� ������Ʈ�� ǥ�� ������ ���� 

//@XmlElement : �ڽ� ������Ʈ �̸��� �����ϴ� ������̼� (����)
//				 => @XmlElement ������̼��� �������� ���� ��� �ʵ���� �ڽ� ������Ʈ �̸����� ����

//					 <member> <id><name><address>...  </member>
@XmlRootElement(name = "member")
@XmlAccessorType(XmlAccessType.FIELD)
//@XmlType(propOrder = {"id","address","name"})
public class RestMemberXML {
	private String id;
	private String name;
//	@XmlElement(name = "addr")
	private String address;
	
	public RestMemberXML() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
