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
public class Entrepreneur extends User{
	
	// RelationShip
	private Collection<Idea> ideas;
	private Collection<Comment> comments;
	
	public Entrepreneur(){
		super();
		ideas= new ArrayList<Idea>();
		comments= new ArrayList<Comment>();
	}
	
	@Valid
	@NotNull
	@OneToMany
	public Collection<Idea> getIdeas(){
		return ideas;
	}
	
	public void setIdeas(Collection<Idea> ideas){
		this.ideas=ideas;
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