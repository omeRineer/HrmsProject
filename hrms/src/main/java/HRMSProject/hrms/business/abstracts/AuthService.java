package HRMSProject.hrms.business.abstracts;

import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.Employer;
import HRMSProject.hrms.entities.concretes.JobSeeker;

public interface AuthService {
	Result registerForJobSeeker(JobSeeker jobSeeker);
	Result registerForEmployer(Employer employer);
}
