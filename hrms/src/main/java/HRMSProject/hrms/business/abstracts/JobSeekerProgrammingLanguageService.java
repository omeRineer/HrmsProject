package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.JobSeekerProgrammingLanguage;

public interface JobSeekerProgrammingLanguageService {
	DataResult<List<JobSeekerProgrammingLanguage>> getAll();
	DataResult<JobSeekerProgrammingLanguage> getById(int id);
	Result add(JobSeekerProgrammingLanguage jobSeekerProgrammingLanguage);
	Result delete(int jobSeekerProgrammingLanguageId);
	Result update(JobSeekerProgrammingLanguage jobSeekerProgrammingLanguage);
}
