package HRMSProject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="job_seeker_images")
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerImage {
	
	@Id
	@OneToOne
	@JoinColumn(name="id")
	private int id;
	
	@Column(name="image_path")
	private String imagePath;
}
