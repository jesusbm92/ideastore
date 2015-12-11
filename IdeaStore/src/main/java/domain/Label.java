package domain;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Access(AccessType.PROPERTY)
public class Label extends DomainEntity{

		private String description;

		// RelationShip
		private Idea idea;

		public Label() {
			super();
		}

		@NotNull
		public String getDescription() {
			return description;
		}

		public void setDescription (String description) {
			this.description = description;
		}
		
	@Valid
	@ManyToOne(optional = true)
	public Idea getIdea() {
		return idea;
	}

	public void setIdea(Idea idea) {
		this.idea = idea;
	}
}
