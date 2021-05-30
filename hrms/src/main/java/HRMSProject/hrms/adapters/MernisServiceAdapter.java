package HRMSProject.hrms.adapters;


import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.VerificationService;

import HRMSProject.hrms.entities.concretes.JobSeeker;

@Service
public class MernisServiceAdapter implements VerificationService {

	//HOCA İSTERLERDE MERNİS SERVİSE BAĞLANIN DEMEDİĞİ İÇİN MERNİS SERVİSİNİ ENTEGRE ETMEDİM
	@Override
	public boolean verify(JobSeeker jobSeeker) {
		System.out.println(jobSeeker.getNationalityId() + " TC kimlik numarasına sahip " + 
							jobSeeker.getFirstName()+ " " + jobSeeker.getLastName() +" isimli "+
							jobSeeker.getBirthdayDate() + " doğum tarihli vatandaş KPS sistemi tarafından doğrulandı");
		return true;
	}

	

}
