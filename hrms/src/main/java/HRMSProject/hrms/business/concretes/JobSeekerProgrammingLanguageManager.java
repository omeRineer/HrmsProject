package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.JobSeekerProgrammingLanguageService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.JobSeekerProgrammingLanguageDao;
import HRMSProject.hrms.entities.concretes.JobSeekerProgrammingLanguage;

@Service
public class JobSeekerProgrammingLanguageManager implements JobSeekerProgrammingLanguageService {

	private JobSeekerProgrammingLanguageDao jobSeekerProgrammingLanguageDao;
	
	@Autowired
	public JobSeekerProgrammingLanguageManager(JobSeekerProgrammingLanguageDao jobSeekerProgrammingLanguageDao) {
		super();
		this.jobSeekerProgrammingLanguageDao = jobSeekerProgrammingLanguageDao;
	}

	@Override
	public DataResult<List<JobSeekerProgrammingLanguage>> getAll() {
		
		return new SuccessDataResult<List<JobSeekerProgrammingLanguage>>(jobSeekerProgrammingLanguageDao.findAll());
	}

	@Override
	public DataResult<JobSeekerProgrammingLanguage> getById(int id) {
		
		return new SuccessDataResult<JobSeekerProgrammingLanguage>(jobSeekerProgrammingLanguageDao.findById(id).get());
	}

	@Override
	public Result add(JobSeekerProgrammingLanguage jobSeekerProgrammingLanguage) {
		jobSeekerProgrammingLanguageDao.save(jobSeekerProgrammingLanguage);
		return new SuccessResult();
	}

	@Override
	public Result delete(int jobSeekerProgrammingLanguageId) {
		jobSeekerProgrammingLanguageDao.deleteById(jobSeekerProgrammingLanguageId);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerProgrammingLanguage jobSeekerProgrammingLanguage) {
		jobSeekerProgrammingLanguageDao.save(jobSeekerProgrammingLanguage);
		return new SuccessResult();
	}

}
