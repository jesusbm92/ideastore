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
public class Administrator extends User{
	
	// RelationShip
	private Collection<User> users;
	
	public Administrator(){
		super();
		users= new ArrayList<User>();
	}
	
	@Valid
	@NotNull
	@OneToMany
	public Collection<User> getUsers(){
		return users;
	}
	
	public void setUsers(Collection<User> users){
		this.users=users;
	}
	
}
