package domain;

import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Entity
@Access(AccessType.PROPERTY)
public class Idea extends DomainEntity {
	
	private String name;
	private String description;
	private Collection<Comment> comments;
	private Collection<Label> labels;

	
	


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
	
	
	@Valid
	@OneToMany(mappedBy = "idea")
	public Collection<Comment> getComments() {
		return comments;
	}

	public void setComments(Collection<Comment> comments) {
		this.comments = comments;
	}
	
	@Valid
	@OneToMany(mappedBy = "idea")
	public Collection<Label> getLabels() {
		return labels;
	}
	 
	public void setLabels(Collection<Label> labels) {
		this.labels = labels;
	}
}
