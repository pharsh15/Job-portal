package JobPortal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="job")
public class job {
	
	@Id
	@Column(name="job_title")
	private String job_title;
	
	@Column(name="status")
	private String status;
	
	public job() 
	{
		
	}

	public job(String job_title, String status) {
		super();
		this.job_title = job_title;
		this.status = status;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	

}
