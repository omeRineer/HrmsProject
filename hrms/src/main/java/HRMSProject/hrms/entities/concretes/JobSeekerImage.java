package HRMSProject.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
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
	@Column(name="id")
	private int id;
	
	@OneToOne
	@MapsId
	@JoinColumn(name="id")
	private JobSeeker jobSeeker;
	
	@Column(name="image_path")
	private String imagePath;
}
