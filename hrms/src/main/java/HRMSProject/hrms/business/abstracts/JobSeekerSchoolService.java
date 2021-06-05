package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.JobSeekerSchool;

public interface JobSeekerSchoolService {
	DataResult<List<JobSeekerSchool>> getAll();
	DataResult<JobSeekerSchool> getById(int id);
	Result add(JobSeekerSchool jobSeekerSchool);
	Result delete(int jobSeekerSchoolId);
	Result update(JobSeekerSchool jobSeekerSchool);
	
}
