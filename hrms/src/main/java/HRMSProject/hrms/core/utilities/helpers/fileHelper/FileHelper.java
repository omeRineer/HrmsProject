package HRMSProject.hrms.core.utilities.helpers.fileHelper;

import org.springframework.web.multipart.MultipartFile;

import HRMSProject.hrms.core.utilities.results.Result;

public interface FileHelper {
	Result upload(MultipartFile file);
}
