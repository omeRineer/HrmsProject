package HRMSProject.hrms.business.abstracts;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.JobSeekerImage;

public interface JobSeekerImageService {
	DataResult<List<JobSeekerImage>> getAll();
	DataResult<JobSeekerImage> getById(int id);
	Result add(MultipartFile file,JobSeekerImage jobSeekerImage);
	Result delete(int jobSeekerImageId);
	Result update(JobSeekerImage jobSeekerImage);
}
