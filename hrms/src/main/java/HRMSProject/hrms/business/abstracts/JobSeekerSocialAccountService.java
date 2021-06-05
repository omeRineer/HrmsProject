package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.JobSeekerSocialAccount;

public interface JobSeekerSocialAccountService {
	DataResult<List<JobSeekerSocialAccount>> getAll();
	DataResult<JobSeekerSocialAccount> getById(int id);
	Result add(JobSeekerSocialAccount jobSeekerSocialAccount);
	Result delete(int jobSeekerSocialAccountId);
	Result update(JobSeekerSocialAccount jobSeekerSocialAccount);
}
