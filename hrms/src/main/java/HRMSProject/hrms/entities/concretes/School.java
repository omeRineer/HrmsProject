package HRMSProject.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name="schools")
public class School {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="school_name")
	private String schoolName;
	
	@JsonIgnore
	@OneToMany(mappedBy = "school")
	private List<JobSeekerSchool> jobSeekerSchools;
}
