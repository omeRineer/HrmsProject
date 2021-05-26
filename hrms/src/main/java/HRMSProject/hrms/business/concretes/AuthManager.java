package HRMSProject.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.AuthService;
import HRMSProject.hrms.business.abstracts.EmailService;
import HRMSProject.hrms.business.abstracts.UserService;
import HRMSProject.hrms.business.abstracts.VerificationService;
import HRMSProject.hrms.core.utilities.results.ErrorResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.EmployerDao;
import HRMSProject.hrms.dataAccess.abstracts.JobSeekerDao;
import HRMSProject.hrms.dataAccess.abstracts.UserDao;
import HRMSProject.hrms.entities.abstracts.User;
import HRMSProject.hrms.entities.concretes.Employer;
import HRMSProject.hrms.entities.concretes.JobSeeker;

@Service
public class AuthManager implements AuthService {

	private JobSeekerDao jobSeekerDao;
	private EmployerDao employerDao;
	private UserService userService;
	private EmailService emailService;
	private VerificationService verificationService;
	
	@Autowired
	public AuthManager(JobSeekerDao jobSeekerDao,
			EmployerDao employerDao,
			UserService userService,
			EmailService emailService,
			VerificationService verificationService) 
	{
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.employerDao=employerDao;
		this.userService=userService;
		this.emailService=emailService;
		this.verificationService=verificationService;
	}
	
	@Override
	public Result registerForJobSeeker(JobSeeker jobSeeker) {
		
		if (jobSeeker.getFirstName()==null | jobSeeker.getLastName()==null | jobSeeker.getNationalityId()==null 
				 | jobSeeker.getEmail()==null | jobSeeker.getPassword() == null) {
			return new ErrorResult("Alanlar boş geçilemez");
		}
		
		Result result=existNationalityId(jobSeeker.getNationalityId());
		if (!result.isSuccess()) {
			return new ErrorResult(result.getMessage());
		}
		
		Result emailExist=existEmail(jobSeeker.getEmail());
		if (!emailExist.isSuccess()) {
			return new ErrorResult(emailExist.getMessage());
		}
		
		if (!verificationService.verify(jobSeeker)) {
			return new ErrorResult("Mernis Doğrulanamadı");
		}
		
		jobSeekerDao.save(jobSeeker);
		emailService.send(jobSeeker);
		return new SuccessResult("İş arayan olarak üye olundu");
		
	}

	@Override
	public Result registerForEmployer(Employer employer) {
		
		if (employer.getWebSite()==null |employer.getCompanyName()==null | employer.getEmail()==null 
				| employer.getPassword()==null) {
			return new ErrorResult("Alanlar boş geçilemez");
		}
		
		Result emailExist=existEmail(employer.getEmail());
		if (!emailExist.isSuccess()) {
			return new ErrorResult(emailExist.getMessage());
		}
		
		
		employerDao.save(employer);
		emailService.send(employer);
		return new SuccessResult("İş veren olarak üye olundu");
		
	}
	
	public Result existNationalityId(String nationalityId) {
		JobSeeker result=jobSeekerDao.findByNationalityId(nationalityId);
		if (result!=null) {
			return new ErrorResult("Bu TC no ya sahip kullanıcı mevcut");
		}
		return new SuccessResult();
	}
	
	public Result existEmail(String email) {
		User result=userService.getByEmail(email).getData();
		if (result!=null) {
			return new ErrorResult("Bu email kullanılmış");
		}
		return new SuccessResult();
		
	}

}
