package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.JobSeekerLanguageService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.JobSeekerLanguageDao;
import HRMSProject.hrms.entities.concretes.JobSeekerLanguage;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService{

	private JobSeekerLanguageDao jobSeekerLanguageDao;
	
	@Autowired
	public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao) {
		super();
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
	}

	@Override
	public DataResult<List<JobSeekerLanguage>> getAll() {
		
		return new SuccessDataResult<List<JobSeekerLanguage>>(jobSeekerLanguageDao.findAll());
	}

	@Override
	public DataResult<JobSeekerLanguage> getById(int id) {
		
		return new SuccessDataResult<JobSeekerLanguage>(jobSeekerLanguageDao.findById(id).get());
	}

	@Override
	public Result add(JobSeekerLanguage jobSeekerLanguage) {
		jobSeekerLanguageDao.save(jobSeekerLanguage);
		return new SuccessResult();
	}

	@Override
	public Result delete(int jobSeekerLanguageId) {
		jobSeekerLanguageDao.deleteById(jobSeekerLanguageId);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerLanguage jobSeekerLanguage) {
		jobSeekerLanguageDao.save(jobSeekerLanguage);
		return new SuccessResult();
	}

}
