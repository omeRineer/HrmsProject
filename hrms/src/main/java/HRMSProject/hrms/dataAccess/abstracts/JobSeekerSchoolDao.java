package HRMSProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.hrms.entities.concretes.JobSeekerSchool;


public interface JobSeekerSchoolDao extends JpaRepository<JobSeekerSchool,Integer>{

}
