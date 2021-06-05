package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import HRMSProject.hrms.business.abstracts.JobSeekerImageService;
import HRMSProject.hrms.core.utilities.helpers.fileHelper.FileHelper;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.ErrorResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.JobSeekerImageDao;
import HRMSProject.hrms.entities.concretes.JobSeekerImage;

@Service
public class JobSeekerImageManager implements JobSeekerImageService{

	private JobSeekerImageDao jobSeekerImageDao;
	private FileHelper fileHelper;
	
	@Autowired
	public JobSeekerImageManager(JobSeekerImageDao jobSeekerImageDao,FileHelper fileHelper) {
		super();
		this.jobSeekerImageDao = jobSeekerImageDao;
		this.fileHelper=fileHelper;
	}

	@Override
	public DataResult<List<JobSeekerImage>> getAll() {
		
		return new SuccessDataResult<List<JobSeekerImage>>(jobSeekerImageDao.findAll());
	}

	@Override
	public DataResult<JobSeekerImage> getById(int id) {
		
		return new SuccessDataResult<JobSeekerImage>(jobSeekerImageDao.findById(id).get());
	}

	@Override
	public Result add(MultipartFile file,JobSeekerImage jobSeekerImage) {
		
		Result result=fileHelper.upload(file);
		if (!result.isSuccess()) {
			return new ErrorResult();
		}
		jobSeekerImage.setImagePath(file.getOriginalFilename());
		jobSeekerImageDao.save(jobSeekerImage);
		return new SuccessResult();
	}

	@Override
	public Result delete(int jobSeekerImageId) {
		jobSeekerImageDao.deleteById(jobSeekerImageId);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerImage jobSeekerImage) {
		jobSeekerImageDao.save(jobSeekerImage);
		return new SuccessResult();
	}

}
