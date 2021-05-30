package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	Result setClosedPosting(int jobPostingId);
	Result add(JobPosting jobPosting);
	Result delete(int id);
	Result update(JobPosting jobPosting);
	DataResult<List<JobPosting>> getAll();
	DataResult<List<JobPosting>> getByTrueStatus();
	DataResult<List<JobPosting>> getByEmployer(int employerId);
	DataResult<List<JobPosting>> getAllByOrderAsc();
}
