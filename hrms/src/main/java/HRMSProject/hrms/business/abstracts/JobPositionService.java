package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	List<JobPosition> GetAll();
}
