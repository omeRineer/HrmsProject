package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.JobExperince;

public interface JobExperinceService {
	DataResult<List<JobExperince>> getAll();
	DataResult<JobExperince> getById(int id);
	Result add(JobExperince jobExperince);
	Result delete(int jobExperinceId);
	Result update(JobExperince jobExperince);
}
