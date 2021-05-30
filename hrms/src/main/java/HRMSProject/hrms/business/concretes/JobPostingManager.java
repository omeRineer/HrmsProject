package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.JobPostingService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.ErrorResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.JobPostingDao;
import HRMSProject.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {

	private JobPostingDao jobPostingDao;
	
	@Autowired
	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı eklendi");
	}

	@Override
	public Result delete(int id) {
		jobPostingDao.deleteById(id);
		return new SuccessResult("İş ilanı silindi");
	}

	@Override
	public Result update(JobPosting jobPosting) {
		jobPostingDao.save(jobPosting);
		return new SuccessResult("İş ilanı güncellendi");
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.findAll());
	}

	@Override
	public DataResult<List<JobPosting>> getByTrueStatus() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByTrueStatus());
	}

	@Override
	public DataResult<List<JobPosting>> getByEmployer(int employerId) {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getByEmployerId(employerId));
	}

	@Override
	public DataResult<List<JobPosting>> getAllByOrderAsc() {
		return new SuccessDataResult<List<JobPosting>>(jobPostingDao.getAllByOrderAsc());
	}

	@Override
	public Result setClosedPosting(int jobPostingId) {
		JobPosting jobPosting=jobPostingDao.findById(jobPostingId).get();
		if (jobPosting!=null) {
			
			if (jobPosting.isStatus()) {
				jobPosting.setStatus(false);
				jobPostingDao.save(jobPosting);
				return new SuccessResult("İlan pasif hale getirildi");
			}
			return new ErrorResult("İlan zaten pasif durumda");
		}
		return new ErrorResult("İlan mevcut değil");
		
		
	}
	
	

}
