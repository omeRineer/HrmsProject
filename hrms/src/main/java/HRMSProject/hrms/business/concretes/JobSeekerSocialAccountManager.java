package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.JobSeekerSocialAccountService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.JobSeekerSocialAccountDao;
import HRMSProject.hrms.entities.concretes.JobSeekerSocialAccount;

@Service
public class JobSeekerSocialAccountManager implements JobSeekerSocialAccountService{
	
	private JobSeekerSocialAccountDao jobSeekerSocialAccountDao;
	
	@Autowired
	public JobSeekerSocialAccountManager(JobSeekerSocialAccountDao jobSeekerSocialAccountDao) {
		super();
		this.jobSeekerSocialAccountDao = jobSeekerSocialAccountDao;
	}

	@Override
	public DataResult<List<JobSeekerSocialAccount>> getAll() {
		
		return new SuccessDataResult<List<JobSeekerSocialAccount>>(jobSeekerSocialAccountDao.findAll());
	}

	@Override
	public DataResult<JobSeekerSocialAccount> getById(int id) {
		
		return new SuccessDataResult<JobSeekerSocialAccount>(jobSeekerSocialAccountDao.findById(id).get());
	}

	@Override
	public Result add(JobSeekerSocialAccount jobSeekerSocialAccount) {
		jobSeekerSocialAccountDao.save(jobSeekerSocialAccount);
		return new SuccessResult();
	}

	@Override
	public Result delete(int jobSeekerSocialAccountId) {
		jobSeekerSocialAccountDao.deleteById(jobSeekerSocialAccountId);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerSocialAccount jobSeekerSocialAccount) {
		jobSeekerSocialAccountDao.save(jobSeekerSocialAccount);
		return new SuccessResult();
	}

}
