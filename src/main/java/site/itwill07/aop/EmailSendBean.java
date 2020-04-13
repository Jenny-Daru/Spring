package site.itwill07.aop;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSender;

//�̸��� ���� ����� �����ϴ� Ŭ���� - �ٽɰ��ɸ��
//������ ������ ����
//������ �����ϴ� ���̺귯�� ���� >> ���������� >> pom.xml >> dependency�߰� 
public class EmailSendBean {
	
//	���������� �θ�� ����
//	�̸��� ������ ���� JavaMailSender �ν��Ͻ��� �����ϱ� ���� �ʵ�(��������ȵ�)
	private JavaMailSender mailSender;

//	getter�� ��� �ʿ����
	public JavaMailSender getMailSender() {
		return mailSender;
	}

//	setter�� �ʿ��� ���� : EmailSendBeanŬ������ SpringBean���� ��ϵǾ���� >> setter Injection�ϱ� ���� �ʿ�
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	
	
//	�ٽɰ����ڵ带 ���� �޼ҵ��ۼ�
//	������ ���� �����ű� ������ ���۰����̿� >> �������̴� �ϴ� �ʿ����
//	�̸��� ���۸޼ҵ� - �ٽɰ����ڵ�
//	 => �޴»���� �̸����ּ�, ����, ������ �Ű������� ���޹޾� ����
//	 => �޴� ����� �̸����ּ� ��ȯ - �α׸� ����(�������� ���´�~~ ��ϵǾ����� �ϱ�����)
	public String sendEmail(String email, String subject, String content) {                     // �̰��� target�޼ҵ���
		
//		JavaMailSender.createMimeMessage() : Mimessage �ν��Ͻ��� ��ȯ�ϴ� �޼ҵ� 
//		MimeMessage : �̸��� ���� ���� ������ �����ϱ� ���� Ŭ����
//		mailSender�� ������ ������ �����ǵ� ���ϵ��� ������ MimeMessge�� ����Ȱ��� ������. 
//		createMimeMessage���� �̸��Ϻ����Ŵϱ� ��ü�ϳ��� �������~ �ϸ� ��ü�� �������
		MimeMessage message=mailSender.createMimeMessage();
		
//		�̸����� ������ �̸����� ������ ���氡�� >> ����ó�� �� �ؾ��� 
		try {
//			MimeMessage.setSubject(String subject) : �̸��� ������ �����ϴ� �޼ҵ� 
			message.setSubject(subject);
			
//			MimeMessage.setContent(Multipart mp) : �̹���,÷������ ���� ����
//			MimeMessage.setText(String text) : �̸��� ������ �����ϴ� �޼ҵ�
//											   => �ؽ�Ʈ �޼����θ� �����Ͽ� ���� ����
			message.setText(content);
			
//			MimeMessage.setRecipients(RecipientType type, (Address[] addresses:������, InternaetAddress email:�Ѹ�)) 
//			: MimeMessage.RecipientType.TO >> �̸����� �޴� ����� ���� ������ �����ϴ� �޼ҵ� // CC : ������ �������� �ҰŴ�?
//			  InternetAddress.parse(String Addressemail) >>���ڿ��� ���޹޾� InternaetAddress[] �迭�� ��ȯ�Ͽ� ��ȯ�ϴ� �޼ҵ�
//			   => �޴� ����� �̸��� �ּ� ���� >> InternetAddress �ν��Ͻ� ��� String �ν��Ͻ� ���� ���� 
//			message.setRecipients(MimeMessage.RecipientType.TO, email);
			message.setRecipients(MimeMessage.RecipientType.TO, InternetAddress.parse(email));
			
//			JavaMailSender.sene(MimeMessage message) : �̸����� �����ϴ� �޼ҵ�
			mailSender.send(message);
			
//		  �޼����� �޴»���� ������ �߸��Ǿ��� ��� ���ܹ߻� 
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return email;
	}
	
}











