package HRMSProject.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import HRMSProject.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	
	@Query("From JobPosting where status=true")
	List<JobPosting> getByTrueStatus();
	
	List<JobPosting> getByEmployerId(int employerId);
	
	@Query("From JobPosting order by applicationDeadline ASC")
	List<JobPosting> getAllByOrderAsc();
}
