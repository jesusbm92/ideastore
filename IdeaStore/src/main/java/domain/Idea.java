package domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Entity
@Access(AccessType.PROPERTY)
public class Idea extends DomainEntity {
	
	private String name;
	private String description;
	
	
	public Idea() {
		super();
	}

	
	@Valid
	@NotNull
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Valid
	@NotNull
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
