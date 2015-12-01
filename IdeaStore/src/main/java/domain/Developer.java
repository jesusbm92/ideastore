package domain;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
@Access(AccessType.PROPERTY)
public class Developer extends User{
	
	// RelationShip
	private Collection<Comment> comments;
	
	public Developer(){
		super();
		comments= new ArrayList<Comment>();
	}
	
	@Valid
	@NotNull
	@OneToMany
	public Collection<Comment> getComments(){
		return comments;
	}
	
	public void setComments(Collection<Comment> comments){
		this.comments=comments;
	}
}