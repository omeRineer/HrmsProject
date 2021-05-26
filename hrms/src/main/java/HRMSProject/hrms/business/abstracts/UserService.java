package HRMSProject.hrms.business.abstracts;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.abstracts.User;

public interface UserService {
	Result add(User user);
	DataResult<User> getByEmail(String email);
}
