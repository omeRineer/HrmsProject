package HRMSProject.hrms.business.abstracts;

import HRMSProject.hrms.entities.abstracts.User;
import HRMSProject.hrms.entities.concretes.JobSeeker;

public interface VerificationService {
	boolean verify(JobSeeker jobSeeker);
}
