package HRMSProject.hrms.business.concretes;

import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.EmailService;
import HRMSProject.hrms.entities.abstracts.User;

@Service
public class EmailManager implements EmailService {

	@Override
	public void send(User user) {
		System.out.println(user.getEmail() + " adresine doğrulama maili gönderildi");
		
	}

}
