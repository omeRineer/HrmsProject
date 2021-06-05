package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.JobSeekerSchoolService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.JobSeekerSchoolDao;
import HRMSProject.hrms.entities.concretes.JobSeekerSchool;

@Service
public class JobSeekerSchoolManager implements JobSeekerSchoolService{

	private JobSeekerSchoolDao jobSeekerSchoolDao;
	
	@Autowired
	public JobSeekerSchoolManager(JobSeekerSchoolDao jobSeekerSchoolDao) {
		super();
		this.jobSeekerSchoolDao = jobSeekerSchoolDao;
	}

	@Override
	public DataResult<List<JobSeekerSchool>> getAll() {
		
		return new SuccessDataResult<List<JobSeekerSchool>>(jobSeekerSchoolDao.findAll());
	}

	@Override
	public DataResult<JobSeekerSchool> getById(int id) {
		
		return new SuccessDataResult<JobSeekerSchool>(jobSeekerSchoolDao.findById(id).get());
	}

	@Override
	public Result add(JobSeekerSchool jobSeekerSchool) {
		jobSeekerSchoolDao.save(jobSeekerSchool);
		return new SuccessResult();
	}

	@Override
	public Result delete(int jobSeekerSchoolId) {
		jobSeekerSchoolDao.deleteById(jobSeekerSchoolId);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerSchool jobSeekerSchool) {
		jobSeekerSchoolDao.save(jobSeekerSchool);
		return new SuccessResult();
	}

}
