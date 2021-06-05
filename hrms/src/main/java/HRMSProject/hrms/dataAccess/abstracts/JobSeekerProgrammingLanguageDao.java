package HRMSProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.hrms.entities.concretes.JobSeekerProgrammingLanguage;


public interface JobSeekerProgrammingLanguageDao extends JpaRepository<JobSeekerProgrammingLanguage,Integer> {

}
