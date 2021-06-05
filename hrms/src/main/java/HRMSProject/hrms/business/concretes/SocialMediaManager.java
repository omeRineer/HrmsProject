package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.SocialMediaService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.SocialMediaDao;
import HRMSProject.hrms.entities.concretes.SocialMedia;

@Service
public class SocialMediaManager implements SocialMediaService {

	private SocialMediaDao socialMediaDao;
	
	@Autowired
	public SocialMediaManager(SocialMediaDao socialMediaDao) {
		super();
		this.socialMediaDao = socialMediaDao;
	}

	@Override
	public DataResult<List<SocialMedia>> getAll() {
		
		return new SuccessDataResult<List<SocialMedia>>(socialMediaDao.findAll());
	}

	@Override
	public DataResult<SocialMedia> getById(int id) {
		
		return new SuccessDataResult<SocialMedia>(socialMediaDao.findById(id).get());
	}

	@Override
	public Result add(SocialMedia socialMedia) {
		socialMediaDao.save(socialMedia);
		return new SuccessResult();
	}

	@Override
	public Result delete(int socialMediaId) {
		socialMediaDao.deleteById(socialMediaId);
		return new SuccessResult();
	}

	@Override
	public Result update(SocialMedia socialMedia) {
		socialMediaDao.save(socialMedia);
		return new SuccessResult();
	}

}
