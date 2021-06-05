package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.SocialMedia;

public interface SocialMediaService {
	DataResult<List<SocialMedia>> getAll();
	DataResult<SocialMedia> getById(int id);
	Result add(SocialMedia socialMedia);
	Result delete(int socialMediaId);
	Result update(SocialMedia socialMedia);
}
