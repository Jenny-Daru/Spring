package site.itwill10.service;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import site.itwill10.dao.UserinfoDAO;
import site.itwill10.dto.Userinfo;
import site.itwill10.exception.LoginAuthFailException;
import site.itwill10.exception.UserinfoExistsException;
import site.itwill10.exception.UserinfoNotFoundException;

@Service
public class UserinfoServiceImpl implements UserinfoService {
	
	@Autowired
	private UserinfoDAO userinfoDAO;

	@Transactional
	@Override
	public void addUserinfo(Userinfo userinfo) throws UserinfoExistsException {
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())!=null) {    // ���̵� �ߺ��ȴٸ�
			throw new UserinfoExistsException(userinfo, "�̹� ������� ���̵��!");
		}
		
//		�ԷµǾ� ���޵� ��й�ȣ�� ��ȣȭ ó���Ͽ� ����
//		 => ��ȣȭ ó�����ִ� ���̺귯�� ���� pom.xml
//		 => ��ûó�� �޼ҵ� �Ǵ� JavaBean(DTO) Ŭ������ Setter �޼ҵ忡�� �۾��� ����
//		BCrypt.hashpw(String password, String salt) 
//		 : ���޹��� ��й�ȣ�� ÷������ �̿��Ͽ� ��ȣȭ ó���Ͽ� ��ȯ�ϴ� �޼ҵ�
//		   => �Ȱ��� ��й�ȣ�� �ϴ��� ���� �ٸ��� ��ȣȭ ó����
//		BCrypt.gensalt(int log_rounds)
//		 : ÷������ ���̸� ���޹޾� ÷������ �����Ͽ� ��ȯ�ϴ� �޼ҵ�
//		   => �Ű������� ÷������ ���� ���� ���� ���� - �⺻�� ����(10)
		userinfo.setPassword(BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt(10)));
//		ȸ�����´� 1(�Ϲݰ���)���� ���� , �������� ������ �⺻��(0)�� ���Ƿ� NOOOOOOOOO!!!
		userinfo.setStatus(1);
		
		userinfoDAO.insertUserinfo(userinfo);
 	}

	@Transactional
	@Override
	public void modifyUserinfo(Userinfo userinfo) throws UserinfoNotFoundException {
		if(userinfoDAO.selectUserinfo(userinfo.getUserid())==null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� ���c!");
		}
		String password=userinfo.getPassword();
		if(password!=null &&!password.equals("")) {
			userinfo.setPassword(BCrypt.hashpw(userinfo.getPassword(), BCrypt.gensalt()));
		}
		userinfoDAO.updateUserinfo(userinfo);
	}

	@Transactional
	@Override
	public void removeUserinfo(String userid) throws UserinfoNotFoundException {
		if(userinfoDAO.selectUserinfo(userid)==null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� ���c!");
		}		
		userinfoDAO.deleteUserinfo(userid);
	}

	@Override
	public Userinfo getUserinfo(String userid) throws UserinfoNotFoundException{
		Userinfo userinfo=userinfoDAO.selectUserinfo(userid);
		if(userinfo==null) {
			throw new UserinfoNotFoundException("���̵��� ȸ�������� ���c!");
		}
		return userinfo;
	}

	@Override
	public List<Userinfo> getUserinfoList() {
		return userinfoDAO.selectUserinfoList();
	}

//	����ó�� �޼ҵ� : ���ܰ� �߻��Ǹ� ���� ����, ���ܰ� �߻����� ������ ���� ����
	@Override
	public void loginAuth(Userinfo userinfo) throws LoginAuthFailException {
		Userinfo authUserinfo=userinfoDAO.selectUserinfo(userinfo.getUserid());
		if(authUserinfo==null) {
			throw new LoginAuthFailException(userinfo.getUserid(), "���̵��� ȸ�������� ���c!");
		}
		
//		BCrypt.checkpw(String plaintext, String hashed) 
//		 : �Ϲ� ���ڿ��� ��ȣȭ ó���� ���ڿ��� ���Ͽ� ���� ��� true�� ��ȯ�ϴ� �޼ҵ�
		if(!BCrypt.checkpw(userinfo.getPassword(), authUserinfo.getPassword())) {
			throw new LoginAuthFailException(userinfo.getUserid(), "���̵� ���ų� ��й�ȣ �ٷ�ŵ�???");
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
