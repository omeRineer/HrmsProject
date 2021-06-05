package HRMSProject.hrms.business.abstracts;

import java.util.List;

import HRMSProject.hrms.core.utilities.results.DataResult;
import HRMSProject.hrms.core.utilities.results.Result;
import HRMSProject.hrms.entities.concretes.School;

public interface SchoolService {
	DataResult<List<School>> getAll();
	DataResult<School> getById(int id);
	Result add(School school);
	Result delete(int schoolId);
	Result update(School school);
}
