package acme.entities.memorandum;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import acme.entities.fineDish.FineDish;
import acme.framework.entities.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity 
@Getter
@Setter
public class Memorandum extends AbstractEntity{
	
	// Serialisation identifier -----------------------------------------------

	protected static final long	serialVersionUID	= 1L;
	
	//Attributes
	
	@NotBlank
	protected String seqNumber;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Past
	@NotNull
	protected Date instantiationMoment;
	
	@NotBlank
	@Length(min = 1, max = 255)
	protected String report;
	
	@URL
	protected String link;
	
	//RelationShip
	@ManyToOne
	@Valid
	protected FineDish fineDish;

}