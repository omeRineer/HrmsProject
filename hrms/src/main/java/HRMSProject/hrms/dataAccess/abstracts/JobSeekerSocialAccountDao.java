package HRMSProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.hrms.entities.concretes.JobSeekerSocialAccount;


public interface JobSeekerSocialAccountDao extends JpaRepository<JobSeekerSocialAccount,Integer> {

}
