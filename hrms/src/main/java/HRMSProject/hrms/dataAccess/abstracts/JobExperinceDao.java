package HRMSProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.hrms.entities.concretes.JobExperince;

public interface JobExperinceDao extends JpaRepository<JobExperince,Integer> {

}
