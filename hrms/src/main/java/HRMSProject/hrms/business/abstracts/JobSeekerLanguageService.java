package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.JobSeekerLanguage;

public interface JobSeekerLanguageService {
	DataResult<List<JobSeekerLanguage>> getAll();
	DataResult<JobSeekerLanguage> getById(int id);
	Result add(JobSeekerLanguage jobSeekerLanguage);
	Result delete(int jobSeekerLanguageId);
	Result update(JobSeekerLanguage jobSeekerLanguage);
}
