package HRMSProject.hrms.business.abstracts;

import HRMSProject.hrms.entities.abstracts.User;

public interface EmailService {
	void send(User user);
}
