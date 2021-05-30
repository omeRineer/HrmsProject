package HRMSProject.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import HRMSProject.hrms.entities.concretes.City;

public interface CityDao extends JpaRepository<City, Integer>{

}
