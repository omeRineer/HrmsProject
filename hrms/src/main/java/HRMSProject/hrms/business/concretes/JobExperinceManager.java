package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.JobExperinceService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.JobExperinceDao;
import HRMSProject.hrms.entities.concretes.JobExperince;

@Service
public class JobExperinceManager implements JobExperinceService{

	private JobExperinceDao jobExperinceDao;
	
	@Autowired
	public JobExperinceManager(JobExperinceDao jobExperinceDao) {
		super();
		this.jobExperinceDao = jobExperinceDao;
	}

	@Override
	public DataResult<List<JobExperince>> getAll() {
		
		return new SuccessDataResult<List<JobExperince>>(jobExperinceDao.findAll());
	}

	@Override
	public DataResult<JobExperince> getById(int id) {
		
		return new SuccessDataResult<JobExperince>(jobExperinceDao.findById(id).get());
	}

	@Override
	public Result add(JobExperince jobExperince) {
		jobExperinceDao.save(jobExperince);
		return new SuccessResult();
	}

	@Override
	public Result delete(int jobExperinceId) {
		jobExperinceDao.deleteById(jobExperinceId);
		return new SuccessResult();
	}

	@Override
	public Result update(JobExperince jobExperince) {
		jobExperinceDao.save(jobExperince);
		return new SuccessResult();
	}

}
