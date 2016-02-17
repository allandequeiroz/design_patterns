package java4.fun.dataLayer.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="INITIALIZED")
public class Initialized {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  
	@Column(name="ID")
	private Integer id;
	
	@Column(name="INITIALIZED")
	private boolean initialized;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isInitialized() {
		return initialized;
	}

	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}
	
}
