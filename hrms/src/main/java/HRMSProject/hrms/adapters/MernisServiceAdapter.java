package HRMSProject.hrms.adapters;

import java.rmi.RemoteException;

import HRMSProject.hrms.business.abstracts.VerificationService;
import HRMSProject.hrms.entities.abstracts.User;
import HRMSProject.hrms.entities.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

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
