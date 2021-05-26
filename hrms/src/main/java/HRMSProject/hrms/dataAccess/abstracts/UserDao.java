package HRMSProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.hrms.entities.abstracts.User;
import HRMSProject.hrms.entities.concretes.JobSeeker;

public interface UserDao extends JpaRepository<User,Integer> {
	User findByEmail(String email);
}
