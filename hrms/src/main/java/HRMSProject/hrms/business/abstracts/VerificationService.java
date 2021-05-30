package HRMSProject.hrms.business.abstracts;

import HRMSProject.hrms.entities.concretes.JobSeeker;

public interface VerificationService {
	public boolean verify(JobSeeker jobSeeker);
}
