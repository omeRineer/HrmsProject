package HRMSProject.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import HRMSProject.hrms.business.abstracts.JobPositionService;
import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.ErrorResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.core.utilities.results.SuccessDataResult;
import HRMSProject.hrms.core.utilities.results.SuccessResult;
import HRMSProject.hrms.dataAccess.abstracts.JobPositionDao;
import HRMSProject.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao positionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(positionDao.findAll());
	}

	@Override
	public DataResult<JobPosition> getById(int id) {
		return new SuccessDataResult<JobPosition>(positionDao.findById(id).get());
	}

	@Override
	public Result add(JobPosition jobPosition)  {
		Result result=existJobPosition(jobPosition.getPositionName());
		if (result.isSuccess()) {
			positionDao.save(jobPosition);
			return new SuccessResult("İş pozisyonu eklendi");
		}
		
		return new ErrorResult(result.getMessage());
		
		
		
	}

	@Override
	public Result delete(int id) {
		positionDao.deleteById(id);
		
		return new SuccessResult("İş pozisyonu silindi");
		
	}

	@Override
	public Result update(JobPosition jobPosition) {
		positionDao.save(jobPosition);
		
		return new SuccessResult("İş pozisyonu güncellendi");
		
	}
	
	
	
   public Result existJobPosition(String positionName) {
	   JobPosition result=positionDao.findByPositionName(positionName);
	   if (result!=null) {
		   return new ErrorResult("Bu pozisyon zaten mevuct");
	   }
	   return new SuccessResult();
   }
	 
	
	
	

}
