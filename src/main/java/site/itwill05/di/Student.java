package site.itwill05.di;

//� �������� �����Ŀ� ���� �̸��� �޶�����. 
//�л������� �����ϱ� ���� Ŭ���� : VO , DTO(JDBC-DAO���� ������ ����ϱ� ���� Ŭ����), JavaBean(WEB���� ����� �Է°��� �����ϱ� ���� Ŭ����)
public class Student {
//	������ �����ϱ� ���� �ʵ�(����)
	private int num;
	private String name;
	private String email;
	
//	�����ڴ� �����ε� ���� (�Ű������� �ٸ��ٸ�)
	public Student() {
		System.out.println("### Student Ŭ������ �⺻ ������ ȣ�� ###");
	}

	public Student(int num) {
		super();
		this.num = num;
		System.out.println("### Student Ŭ������ �Ű�����(�й�)�� ����� ������ ȣ�� ###");
	}

	public Student(int num, String name) {
		super();
		this.num = num;
		this.name = name;
		System.out.println("### Student Ŭ������ �Ű�����(�й�,�̸�)�� ����� ������ ȣ�� ###");
	}

	public Student(int num, String name, String email) {
		super();
		this.num = num;
		this.name = name;
		this.email = email;
		System.out.println("### Student Ŭ������ �Ű�����(�й�,�̸�,�̸���)�� ����� ������ ȣ�� ###");
	}

//	����ȭ �Ǿ� �ִ� �ʵ忡 ���� setter,getter >> �̰��� ���� ���ٰ���
//	 => ������ �� ������ ����� �� (�ʵ�� �޼ҵ� ����ȭ ����)
//   => ĸ��ȭ (��ü��ü�� ���� �����ų� ����� �����°�) // ��ü����� �ڹ��� ĸ��ȭ�� ������ �� �޶� 
	
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
		System.out.println("### Student Ŭ������ setNum(int num) �޼ҵ� ȣ�� ###");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println("### Student Ŭ������ setName(String name) �޼ҵ� ȣ�� ###");
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		System.out.println("### Student Ŭ������ setEmail(String email) �޼ҵ� ȣ�� ###");
	}
	
	@Override
		public String toString() {
			return "�й� = "+num+", �̸� = "+name+", �̸��� = "+email;
		}
	

	
	
	
}
